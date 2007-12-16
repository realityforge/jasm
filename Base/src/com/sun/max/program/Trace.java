/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.program;

import com.sun.max.io.MultiOutputStream;
import com.sun.max.program.option.PositiveIntegerProgramOption;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Tracing output for debugging purposes. No performance impact when disabled. Some performance impact when active, even
 * without output. Possibly significant performance impact when producing a lot of output.
 *
 * @author Bernd Mathiske
 */
public class Trace extends PositiveIntegerProgramOption {

    private static PrintStream _stream;

    public static PrintStream stream() {
        return _stream;
    }

    public static void setStream(PrintStream stream) {
        _stream = stream;
    }

    static {
        final String traceFileName = System.getProperty("maxwell.trace.file");
        _stream = System.out;
        if (traceFileName != null) {
            final File traceFile = new File(traceFileName);
            try {
                final OutputStream fileStream = new BufferedOutputStream(new FileOutputStream(traceFile));
                if (System.getProperty("maxwell.trace.noconsole") != null) {
                    _stream = new PrintStream(fileStream);
                } else {
                    _stream = new PrintStream(new MultiOutputStream(fileStream, System.out));
                }
            } catch (IOException ioException) {
                System.err.println("Could not open file for trace output: " + traceFile.getAbsolutePath());
            }
        }
    }

    /**
     * Static master switch. Set by source code editing only (for now).
     *
     * Set '_enabled' to 'true' to enable tracing output, according to your other trace-related settings.
     *
     * Set '_enabled' to 'false' to prevent any tracing. All tracing routines will thus become dead code. The optimizing
     * compiler should then be able to eliminate the runtime overhead.
     */
    private static final boolean _ENABLED = true;

    /**
     * This dynamic master throttle for tracing is in effect iff the static switch '_enabled' is set to 'true'.
     */
    private static int _level;

    public static void on(int level) {
        assert level >= 0;
        _level = level;
        //Breakpoint.when(level > 1);
    }

    public static void on() {
        on(Integer.MAX_VALUE);
    }

    public static void off() {
        _level = 0;
    }

    public static int level() {
        return _level;
    }

    public static boolean hasLevel(int requiredLevel) {
        return _level >= requiredLevel;
    }

    private static int _indentation;

    private static String makePrefix(int requiredLevel) {
        String result = "";
        for (int i = 0; i < _indentation; i++) {
            result += " ";
        }
        return "<Trace " + requiredLevel + "> " + result;
    }

    public static void line(int requiredLevel) {
        if (_ENABLED && hasLevel(requiredLevel)) {
            _stream.println();
            _stream.flush();
        }
    }

    public static void line(int requiredLevel, String message) {
        if (_ENABLED && hasLevel(requiredLevel)) {
            _stream.println(makePrefix(requiredLevel) + message);
            _stream.flush();
        }
    }

    public static void begin(int requiredLevel, String message) {
        if (_ENABLED) {
            if (hasLevel(requiredLevel)) {
                _stream.println(makePrefix(requiredLevel) + "BEGIN: " + message);
                _stream.flush();
                _indentation++;
            }
        }
    }

    public static void end(int requiredLevel, String message) {
        if (_ENABLED) {
            if (hasLevel(requiredLevel)) {
                _indentation--;
                assert _indentation >= 0;
                _stream.println(makePrefix(requiredLevel) + "END:   " + message);
                _stream.flush();
            }
        }
    }

    public Trace() {
        super("-trace", "sets tracing level");
    }

    public Trace(int level) {
        this();
        _level = level;
    }

    @Override
    protected Integer unassignedDefaultValue() {
        return _level;
    }

    @Override
    public void useValue(Integer value) {
        on(value);
    }

    @Override
    protected Integer assignedDefaultValue() {
        return Integer.MAX_VALUE;
    }
}
