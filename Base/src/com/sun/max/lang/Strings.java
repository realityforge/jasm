/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Additional String-related operations.
 *
 * @author Bernd Mathiske
 */
public final class Strings {

    private Strings() {
    }

    /**
     * @param stream
     *            the input stream to be read in its entirety and then closed
     * @return the contents of the input stream as a String, with line breaks
     * @throws IOException
     *             as usual
     */
    public static String fromInputStream(InputStream stream) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        final StringBuffer result = new StringBuffer();
        final String lineSeparator = System.getProperty("line.separator");
        while (true) {
            final String line = reader.readLine();
            if (line == null) {
                stream.close();
                return result.toString();
            }
            result.append(line);
            result.append(lineSeparator);
        }
    }

    public static String firstCharToLowerCase(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }

    public static String firstCharToUpperCase(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

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

    public static String padLengthWithSpaces(int length, String s) {
        if (s.length() >= length) {
            return s;
        }
        return spaces(length - s.length()) + s;
    }

    /**
     * Finds the index of the first non-escaped instance of {@code c} in {@code s} starting at {@code fromIndex}.
     * The search takes into account that the escape char (i.e. {@code '\'}) may itself be escaped.
     *
     * @return -1 if the char could not be found
     */
    public static int indexOfNonEscapedChar(char c, String s, int fromIndex) {
        int index = s.indexOf(c, fromIndex);
        while (index != -1) {
            if (index > 0 && (s.charAt(index - 1) != '\\') || (index > 1 && s.charAt(index - 2) == '\\')) {
                return index;
            }
            index = s.indexOf(c, index + 1);
        }
        return -1;
    }

    /**
     * Parses a command line into a string array appropriate for calling {@link Runtime#exec(String[])}.
     * The given command line is tokenized around {@link Character#isWhitespace(char) whitespaces}
     * except for sequences of characters enclosed in non-escaped double quotes (after the double
     * quotes are removed).
     */
    public static String[] splitCommand(String command) {
        final List<String> parts = new ArrayList<String>();

        boolean escapedChar = false;
        boolean insideQuotes = false;

        final char[] buffer = new char[command.length()];
        int pos = 0;

        for (int index = 0; index < command.length(); ++index) {
            final char ch = command.charAt(index);
            if (escapedChar) {
                escapedChar = false;
            } else {
                if (ch == '\\') {
                    escapedChar = true;
                } else {
                    if (insideQuotes) {
                        if (ch == '"') {
                            insideQuotes = false;
                            continue;
                        }
                    } else {
                        if (ch == '"') {
                            insideQuotes = true;
                            continue;
                        } else if (Character.isWhitespace(ch)) {
                            if (pos != 0) {
                                parts.add(new String(buffer, 0, pos));
                                pos = 0;
                            }
                            continue;

                        }
                    }
                }
            }
            buffer[pos++] = ch;
        }

        if (insideQuotes) {
            throw new IllegalArgumentException("unclosed quotes");
        }
        if (escapedChar) {
            throw new IllegalArgumentException("command line cannot end with escape char '\\'");
        }
        if (pos != 0) {
            parts.add(new String(buffer, 0, pos));
        }
        return parts.toArray(new String[parts.size()]);
    }

    public static String truncate(String s, int maxLength) {
        if (maxLength < 0) {
            throw new IllegalArgumentException();
        }
        if (s.length() <= maxLength) {
            return s;
        }
        return s.substring(0, maxLength) + "...";
    }

    /**
     * Chops the last {@code count} from a given string.
     *
     * @param s      the string to chop
     * @param count  the number of characters to chop from the end of {@code s}
     * @return the chopped string
     * @throws  IndexOutOfBoundsException  if <code>count < s.length()</code>
     */
    public static String chopSuffix(String s, int count) {
        return s.substring(0, s.length() - count);
    }

    /**
     * Chops the last {@code suffix.length()} from a given string. Calling this method is
     * equivalent to {@link #chopSuffix(String, int) chop(s, suffix.length())}.
     */
    public static String chopSuffix(String s, String suffix) {
        return chopSuffix(s, suffix.length());
    }

    /**
     * Without any checkcast or instanceof.
     */
    public static boolean equal(String s1, String s2) {
        final int n = s1.length();
        if (n != s2.length()) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
