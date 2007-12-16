/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d84ee2b0-a342-4dd9-82db-ca29accc9d4d*/
package com.sun.max.util;

import com.sun.max.annotate.*;
import com.sun.max.lang.*;

/**
 * Compute given functions in always one and the same single thread.
 * 
 * This is for example necessary in Linux where one and 
 * the same thread needs to be reused to represent the whole process in certain contexts,
 * e.g. when using the ptrace interface.
 * 
 * @author Bernd Mathiske
 */
public class SingleThread extends Thread {

    private static final class Worker extends Thread {
        
        private Function1 _function = null;
        private Object _result = null;
        private Throwable _throwable = null;

        private Worker() {
            setDaemon(true);
            start();
        }

        @Override
        public synchronized void run() {
            while (true) {
                _result = null;
                _throwable = null;
                if (_function != null) {
                    try {
                        _result = _function.run();
                    } catch (Throwable throwable) {
                        _throwable = throwable;
                    }
                    _function = null;
                    notifyAll();
                }
                try {
                    wait();
                } catch (InterruptedException interruptedException) {
                }
            }
        }
    }
    
    private static Worker _worker;
    
    public static synchronized <Result_Type, Exception_Type extends Exception> Result_Type execute(Class<Result_Type> resultType, Class<Exception_Type> exceptionType, Function1<Result_Type, Exception_Type> function) throws Exception_Type {
        if (_worker == null) {
            _worker = new Worker();
        }
        synchronized (_worker) {
            _worker._function = function;
            _worker.notifyAll();
            while (_worker._function != null) {
                try {
                    _worker.wait();
                } catch (InterruptedException interruptedException) {
                }
            }
            if (_worker._throwable != null) {
                if (exceptionType.isInstance(_worker._throwable)) {
                    throw exceptionType.cast(_worker._throwable);
                }
                throw new Error("SingleThread.execute", _worker._throwable);
            }
            return resultType.cast(_worker._result);
        }
    }

    private static final class UnusedException extends Exception {        
    }
    
    public static synchronized <Result_Type> Result_Type execute(Class<Result_Type> resultType, final Function<Result_Type> function) {
        final Function1<Result_Type, UnusedException> function1 = new Function1<Result_Type, UnusedException>() {
            @Implement(Function1.class)
            public Result_Type run() throws UnusedException {
                return function.run();
            }
        };
        try {
            return execute(resultType, UnusedException.class, function1);
        } catch (UnusedException unusedException) {
            return null;
        }
    }

    public static synchronized <Exception_Type extends Exception> void execute(Class<Exception_Type> exceptionType, final Runnable1<Exception_Type> runnable) throws Exception_Type {
        final Function1<Object, Exception_Type> function1 = new Function1<Object, Exception_Type>() {
            @Implement(Function1.class)
            public Object run() throws Exception_Type {
                runnable.run();
                return null;
            }
        };
        execute(Object.class, exceptionType, function1);
    }

    public static synchronized void execute(final Runnable runnable) {
        final Function<Void> function1 = new Function<Void>() {
            @Implement(Function1.class)
            public Void run() {
                runnable.run();
                return null;
            }
        };
        execute(Void.class, function1);
    }
}
