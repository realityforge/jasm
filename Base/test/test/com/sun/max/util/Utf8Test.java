/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e31f7970-1a0e-4fb8-8dea-9582fe2f813f*/
package test.com.sun.max.util;

import junit.framework.*;

import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public class Utf8Test extends TestCase {

    public Utf8Test(String name) {
        super(name);
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(Utf8Test.class);
    }
    
    private void convertStringToUtf8AndBack(String string) throws Utf8Exception {
        final byte[] utf8 = Utf8.stringToUtf8(string);
        final String result = Utf8.utf8ToString(utf8);
        assertEquals(result, string);
    }
    
    public void test_utf8() throws Utf8Exception {
        convertStringToUtf8AndBack("");
        convertStringToUtf8AndBack(" ");
        convertStringToUtf8AndBack("\n");
        convertStringToUtf8AndBack("abcABC!@#$%^&*()_=/.,;:?><|`~' xyzZXY");
        convertStringToUtf8AndBack("???????????????????????????????");
        convertStringToUtf8AndBack("????p??90=?a");
        for (char ch = Character.MIN_VALUE; ch < Character.MAX_VALUE; ch++) {
            convertStringToUtf8AndBack("abc" + ch + "mno" + ch + ch + "xyz");            
        }
    }
    
}
