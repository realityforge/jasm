/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0e6a49df-6701-4af5-9706-490becac311f*/
package com.sun.max.util;

import java.util.Stack;

/**
 * This is a class that provides support for timing computations (at nanosecond granularity),
 * including nested computations. The timing data gathered for each computation does not include
 * time spent inside timed inner computations.
 *
 * The {@link Timer} class provides similiar functionality but at millisecond
 * granularity with support for flat and total times.
 *
 * @author  Bernd Mathiske
 */
public final class NanoTimer {

    private static ThreadLocal<Stack<NanoTimer>> _timers = new ThreadLocal<Stack<NanoTimer>>() {
        @Override
        protected synchronized Stack<NanoTimer> initialValue() {
            return new Stack<NanoTimer>();
        }
    };

    private long _mark;
    private long _elapsed;

    private NanoTimer() {
    }

    private static void start() {
        final long now = System.nanoTime();
        if (!_timers.get().isEmpty()) {
            final NanoTimer oldTimer = _timers.get().peek();
            oldTimer._elapsed += now - oldTimer._mark;
        }
        final NanoTimer newTimer = new NanoTimer();
        _timers.get().push(newTimer);
        newTimer._mark = System.nanoTime();
    }

    private static long stop() {
        final long now = System.nanoTime();
        final NanoTimer timer = _timers.get().pop();
        timer._elapsed += now - timer._mark;
        if (!_timers.get().empty()) {
            final NanoTimer outerTimer = _timers.get().peek();
            outerTimer._mark = System.nanoTime();
        }
        return timer._elapsed;
    }

    public static long run(Runnable runnable) {
        start();
        long result = 0L;
        try {
            runnable.run();
        } finally {
            result = stop();
        }
        return result;
    }
}
