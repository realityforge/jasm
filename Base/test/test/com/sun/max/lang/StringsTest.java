/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a3c6a619-d2bc-4ce0-ad88-571ef9130e68*/
package test.com.sun.max.lang;

import junit.framework.*;

import com.sun.max.lang.*;


public class StringsTest extends TestCase {

    public StringsTest(String name) {
        super(name);
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(StringsTest.class);
    }

    public void test_indexOfNonEscapedChar() {
        assertTrue(Strings.indexOfNonEscapedChar('"', " \" \" ", 0) == 1);
        assertTrue(Strings.indexOfNonEscapedChar('"', " \" \" ", 1) == 1);
        assertTrue(Strings.indexOfNonEscapedChar('"', " \" \" ", 2) == 3);
        assertTrue(Strings.indexOfNonEscapedChar('"', " \" \" ", 3) == 3);
        assertTrue(Strings.indexOfNonEscapedChar('"', " \" \" ", 4) == -1);
        assertTrue(Strings.indexOfNonEscapedChar('"', " \" \" ", -1) == 1);
        assertTrue(Strings.indexOfNonEscapedChar('"', " \" \" ", 10) == -1);
    }

    private void assertSplitCommandEquals(String command, String... parts) {
        final String[] parsedParts = Strings.splitCommand(command);
        final boolean result = Arrays.equals(parsedParts, parts);
        assertTrue(Arrays.toString(parsedParts, " "), result);
    }

    private void assertSplitCommandThrowsException(String command) {
        try {
            Strings.splitCommand(command);
            fail("command parsing should have thrown IllegalArgumentException: " + command);
        } catch (IllegalArgumentException iae) {
        }
    }
    
    public void test_splitCommand() {
        assertSplitCommandEquals("cmd \"arg1_with_quote\\\"\" arg2 arg3", "cmd", "arg1_with_quote\\\"", "arg2", "arg3");
        assertSplitCommandEquals("cmd arg1 arg2 arg3", "cmd", "arg1", "arg2", "arg3");
        assertSplitCommandEquals(" cmd arg1 arg2  arg3", "cmd", "arg1", "arg2", "arg3");
        assertSplitCommandEquals("cmd arg1 arg2  arg3 ", "cmd", "arg1", "arg2", "arg3");
        assertSplitCommandEquals("cmd \"arg1 with space\" arg2 arg3", "cmd", "arg1 with space", "arg2", "arg3");
        assertSplitCommandEquals("cmd \"arg1 with space\"  arg2 arg3", "cmd", "arg1 with space", "arg2", "arg3");
        assertSplitCommandEquals("cmd  \"arg1 with space\" arg2 arg3", "cmd", "arg1 with space", "arg2", "arg3");
        assertSplitCommandEquals("cmd \"arg1 with space\"suffix arg3", "cmd", "arg1 with spacesuffix", "arg3");
        assertSplitCommandEquals("cmd prefix\"arg1 with space\" arg3", "cmd", "prefixarg1 with space", "arg3");

        assertSplitCommandThrowsException("cmd arg1 \\");
        assertSplitCommandThrowsException("cmd \"arg1 ");
    }
}
