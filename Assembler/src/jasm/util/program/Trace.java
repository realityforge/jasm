/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.program;

import jasm.util.program.option.PositiveIntegerProgramOption;

/**
 * Tracing output for debugging purposes. No performance impact when disabled. Some performance impact when active, even
 * without output. Possibly significant performance impact when producing a lot of output.
 *
 * @author Bernd Mathiske
 */
public class Trace extends PositiveIntegerProgramOption {
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

  public static boolean hasLevel(int requiredLevel) {
        return _level >= requiredLevel;
    }

    private static String makePrefix(int requiredLevel) {
        return "<Trace " + requiredLevel + "> ";
    }

    public static void line(int requiredLevel) {
        if (_ENABLED && hasLevel(requiredLevel)) {
            System.out.println();
            System.out.flush();
        }
    }

    public static void line(int requiredLevel, String message) {
        if (_ENABLED && hasLevel(requiredLevel)) {
            System.out.println(makePrefix(requiredLevel) + message);
            System.out.flush();
        }
    }

  public Trace() {
        super("-trace", "sets tracing level");
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
