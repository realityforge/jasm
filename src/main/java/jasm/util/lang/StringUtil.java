/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.lang;

/**
 * Additional String-related operations.
 *
 * @author Bernd Mathiske
 */
public final class StringUtil {
  public static String times(char ch, int nTimes) {
    if (nTimes <= 0) {
      return "";
    }
    final char[] chars = new char[nTimes];
    for (int i = 0; i < nTimes; i++) {
      chars[i] = ch;
    }
    return new String(chars);
  }

  private static final char[] SPACES;

  static {
    SPACES = new char[200];
    java.util.Arrays.fill(SPACES, ' ');
  }

  public static String spaces(int nSpaces) {
    if (nSpaces <= SPACES.length) {
      return new String(SPACES, 0, nSpaces);
    }
    return times(' ', nSpaces);
  }

  public static String padLengthWithSpaces(String s, int length) {
    if (s.length() >= length) {
      return s;
    }
    return s + spaces(length - s.length());
  }
}
