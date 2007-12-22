/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.program;

/**
 * @author Bernd Mathiske
 */
public final class ProgramError extends Error {

  private static final long serialVersionUID = 0;

  public ProgramError(String message, Throwable cause) {
    super(message, cause);
  }

  public static void check(boolean condition) {
    check(condition, "Program Error");
  }

  public static void check(boolean condition, String message) {
    if (!condition) {
      throw new ProgramError(message, null);
    }
  }

  public static void unexpected(String message, Throwable throwable) {
    throw new ProgramError("Unexpected Program Error: " + message, throwable);
  }

  public static void unexpected(String message) {
    unexpected(message, null);
  }

  public static void unexpected(Throwable throwable) {
    unexpected("", throwable);
  }

  public static void unexpected() {
    unexpected("");
  }
}
