/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.util;

import com.sun.max.lang.StaticLoophole;
import com.sun.max.program.ProgramError;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * This is a class that provides support for timing computations (at millisecond granularity),
 * including nested computations. The timing data gathered for each computation includes
 * both flat time (time not spent inside timed inner computations) and total time.
 *
 * @author  Doug Simon
 */
public final class Timer<Key_Type> {
    /**
     * A computation to be timed that throws an exception.
     */
    public abstract static class ComputationWithException<Result_Type, Exception_Type extends Throwable> {

        protected final Class<? extends Throwable> _exceptionType;

        public ComputationWithException(Class<? extends Throwable> exceptionType) {
            _exceptionType = exceptionType;
        }

        /**
         * Performs the computation that will be timed.
         *
         * @return   the result of the computation
         */
        public abstract Result_Type run() throws Exception_Type;
    }

    /**
     * An instance of {@code Execution} encapsulates the state of a
     * computation including its duration, result and any exception thrown.
     */
    static class Execution<Result_Type, Exception_Type> {
        /**
         * The duration of the computation inclusing any nested compuatutions.
         */
        protected long _nestedTimes;

        /**
         * The result of the computation.
         */
        protected Result_Type _result;

        /**
         * The exception (if any) thrown by the computation.
         */
        protected Exception_Type _exception;
    }

    /**
     * The collected flat times.
     */
    private final Map<Key_Type, Long> _flatTimes = new HashMap<Key_Type, Long>();

    /**
     * The collected nested times.
     */
    private final Map<Key_Type, Long> _totalTimes = new HashMap<Key_Type, Long>();

    /**
     * A stack to model the nesting of computations.
     */
    private final Stack<Execution> _executions = new Stack<Execution>();

    /**
     * Executes a computation.
     *
     * @param   id  the identifier of the computation
     * @param   c   the {@code Computation} or
     *              {@code ComputationException} instance representing
     *              the computation to be executed
     * @return  the dynamic state of the computation's execution
     */
    private <Result_Type, Exception_Type extends Throwable> Execution<Result_Type, Exception_Type> execute(Key_Type id, Object c) {
        final long start = System.currentTimeMillis();
        final Execution<Result_Type, Exception_Type> e = new Execution<Result_Type, Exception_Type>();
        _executions.push(e);
        final Long currentTotal = _totalTimes.get(id);
        try {
          ComputationWithException<Result_Type, Exception_Type> comp = StaticLoophole.cast(c);
          e._result = comp.run();
        } catch (Throwable ex) {
            if (c instanceof ComputationWithException) {
                ComputationWithException<Result_Type, Exception_Type> comp = StaticLoophole.cast(c);
                final Class<? extends Throwable> exceptionType = comp._exceptionType;
                if (ex instanceof Error) {
                    throw (Error) ex;
                }
                if (ex instanceof RuntimeException) {
                    throw (RuntimeException) ex;
                }
                if (exceptionType.isInstance(ex)) {
                  final Class<Exception_Type> t = null;
                  e._exception = StaticLoophole.cast(t, ex);
                } else {
                    throw new RuntimeException("computation threw " + ex.getClass().getName() + ", expected " + exceptionType.getName(), ex);
                }
            } else {
                // Must be an unchecked exception (RuntimeException or Error subclass)
                if (ex instanceof RuntimeException) {
                    throw (RuntimeException) ex;
                }
                if (ex instanceof Error) {
                    throw (Error) ex;
                }
                ProgramError.unexpected();
            }
        } finally {
            _executions.pop();
            final long time = System.currentTimeMillis() - start;
            if (!_executions.isEmpty()) {
                final Execution execution = _executions.peek();
                execution._nestedTimes += time;
            }
            _totalTimes.put(id, time + (currentTotal == null ? 0L : currentTotal));

            final Long flatTime = _flatTimes.get(id);
            if (flatTime == null) {
                _flatTimes.put(id, time - e._nestedTimes);
            } else {
                _flatTimes.put(id, flatTime + (time - e._nestedTimes));
            }
        }
        return e;
    }

  /**
     * Time a specified computation denoted by a specified identifier. The
     * time taken to perform the computation is added to the accumulative
     * time to perform all computations with the same identifier.
     *
     * @param   id           the identifier for the computation
     * @param   computation  the computation to be performed and timed
     * @return  the result of the computation.
     */
    public <Result_Type, Exception_Type extends Throwable> Result_Type time(Key_Type id, ComputationWithException<Result_Type, Exception_Type> computation) throws Exception_Type {
        final Execution<Result_Type, Exception_Type> e = execute(id, computation);
        if (e._exception != null) {
            throw e._exception;
        }
        return e._result;
    }

  /**
     * Gets an iterator over the collected flat times.
     *
     * @return  an iterator over the collected flat times
     */
    public Iterable<Entry<Key_Type, Long>> flatTimes() {
        return _flatTimes.entrySet();
    }

  /**
     * Resets all the data gathered by the timer.
     *
     * @throws IllegalStateException if there is an execution currently being timed
     */
    public void reset() {
        if (!_executions.isEmpty()) {
            throw new IllegalStateException();
        }
        _flatTimes.clear();
        _totalTimes.clear();
    }
}
