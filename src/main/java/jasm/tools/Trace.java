/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools;

/**
 * Tracing output for debugging purposes. No performance impact when disabled. Some performance impact when active, even
 * without output. Possibly significant performance impact when producing a lot of output.
 */
public final class Trace {
  private static final boolean _ENABLED = true;
  private static int _level;

  public static void on(int level) {
    assert level >= 0;
    _level = level;
  }

  private static boolean enabledAt(int requiredLevel) {
    return _level >= requiredLevel;
  }

  private static String makePrefix(int requiredLevel) {
    return "<Trace " + requiredLevel + "> ";
  }

  public static void line(int requiredLevel) {
    if (_ENABLED && enabledAt(requiredLevel)) {
      System.out.println();
      System.out.flush();
    }
  }

  public static void line(int requiredLevel, String message) {
    if (_ENABLED && enabledAt(requiredLevel)) {
      System.out.println(makePrefix(requiredLevel) + message);
      System.out.flush();
    }
  }
}
