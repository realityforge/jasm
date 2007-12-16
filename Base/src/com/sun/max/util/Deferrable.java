/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b85ca99b-987c-4e5e-8090-148e83e6864b*/
package com.sun.max.util;

import com.sun.max.lang.Runnable2;
import java.util.List;
import java.util.Vector;

/**
 * Deferred Runnables.
 *
 * Creating a Deferrable either causes immediate execution of its 'run()' method
 * or queues it for deferred execution later on when 'runAll()' is called.
 *
 * @author Bernd Mathiske
 */
public abstract class Deferrable implements Runnable {

    public Deferrable(Queue queue) {
        queue.handle(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static final class Queue {

        private List<Deferrable> _deferrables;

        private Queue() {
        }

        synchronized void handle(Deferrable deferrable) {
            if (_deferrables != null) {
                _deferrables.add(deferrable);
            } else {
                deferrable.run();
            }
        }

        public synchronized void deferAll() {
            _deferrables = new Vector<Deferrable>();
        }

        public synchronized void runAll() {
            if (_deferrables != null) {
                final List<Deferrable> deferrables = _deferrables;
                _deferrables = null;
                for (Deferrable deferrable : deferrables) {
                    deferrable.run();
                }
            }
        }

    }

    public static Queue createRunning() {
        return new Queue();
    }

    public static Queue createDeferred() {
        final Queue queue = new Queue();
        queue.deferAll();
        return queue;
    }

    public abstract static class Block implements Runnable {
        public Block(Queue queue) {
            queue.deferAll();
            run();
            queue.runAll();
        }
    }

    public abstract static class Block2<Exception1_Type extends Exception, Exception2_Type extends Exception> implements Runnable2<Exception1_Type, Exception2_Type> {
        public Block2(Queue queue) throws Exception1_Type, Exception2_Type {
            queue.deferAll();
            run();
            queue.runAll();
        }
    }
}
