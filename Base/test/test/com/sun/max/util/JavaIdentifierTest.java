/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=3f908167-eb6d-4645-91c3-874c65a30e0e*/
package test.com.sun.max.util;

import com.sun.max.ide.MaxTestCase;
import com.sun.max.util.JavaIdentifier;

/**
 * Tests for {@link JavaIdentifier}.
 *
 * @author Hiroshi Yamauchi
 */
public class JavaIdentifierTest extends MaxTestCase {

    public JavaIdentifierTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(JavaIdentifierTest.class);
    }

    public void test_isValid() {
        assertTrue(JavaIdentifier.isValid("a000"));
        assertTrue(!JavaIdentifier.isValid("000x"));
        assertTrue(JavaIdentifier.isValid("$a000"));
        assertTrue(JavaIdentifier.isValid("_000x"));
        assertTrue(JavaIdentifier.isValid("abc"));
        assertTrue(!JavaIdentifier.isValid("<init>"));
        assertTrue(JavaIdentifier.isValid("abc$bcc"));
        assertTrue(!JavaIdentifier.isValid("-000x"));
        assertTrue(JavaIdentifier.isValid("for"));
    }

    public void test_isValidQualified() {
        assertTrue(JavaIdentifier.isValidQualified("java.a000"));
        assertTrue(JavaIdentifier.isValidQualified("java.a000$bbb"));
        assertTrue(JavaIdentifier.isValidQualified("_.aa.__"));
        assertTrue(!JavaIdentifier.isValidQualified("java.1"));
        assertTrue(JavaIdentifier.isValidQualified("java.C$222"));
        assertTrue(!JavaIdentifier.isValidQualified("13"));
    }
}
