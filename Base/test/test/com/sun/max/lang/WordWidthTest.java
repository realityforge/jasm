/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=090d5e65-4339-427c-8b8e-157042710938*/
package test.com.sun.max.lang;

import com.sun.max.lang.WordWidth;
import junit.framework.TestCase;

/**
 * Tests for {@link Objects}.
 *
 * @author Hiroshi Yamauchi
 */
public class WordWidthTest extends TestCase {

    public WordWidthTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(WordWidthTest.class);
    }

    public void test_fromInt() {
        assertTrue(WordWidth.fromInt(-1000) == WordWidth.BITS_8);
        assertTrue(WordWidth.fromInt(-1) == WordWidth.BITS_8);
        assertTrue(WordWidth.fromInt(0) == WordWidth.BITS_8);
        assertTrue(WordWidth.fromInt(1) == WordWidth.BITS_8);
        assertTrue(WordWidth.fromInt(2) == WordWidth.BITS_8);
        assertTrue(WordWidth.fromInt(7) == WordWidth.BITS_8);
        assertTrue(WordWidth.fromInt(8) == WordWidth.BITS_8);
        assertTrue(WordWidth.fromInt(9) == WordWidth.BITS_16);
        assertTrue(WordWidth.fromInt(10) == WordWidth.BITS_16);
        assertTrue(WordWidth.fromInt(15) == WordWidth.BITS_16);
        assertTrue(WordWidth.fromInt(16) == WordWidth.BITS_16);
        assertTrue(WordWidth.fromInt(17) == WordWidth.BITS_32);
        assertTrue(WordWidth.fromInt(18) == WordWidth.BITS_32);
        assertTrue(WordWidth.fromInt(31) == WordWidth.BITS_32);
        assertTrue(WordWidth.fromInt(32) == WordWidth.BITS_32);
        assertTrue(WordWidth.fromInt(33) == WordWidth.BITS_64);
        assertTrue(WordWidth.fromInt(34) == WordWidth.BITS_64);
        assertTrue(WordWidth.fromInt(63) == WordWidth.BITS_64);
        assertTrue(WordWidth.fromInt(64) == WordWidth.BITS_64);
        assertTrue(WordWidth.fromInt(65) == WordWidth.BITS_64);
        assertTrue(WordWidth.fromInt(1000) == WordWidth.BITS_64);
    }

    public void test_unsignedEffectiveInt() {
        assertTrue(WordWidth.unsignedEffective(0) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(1) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(2) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(126) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(127) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(128) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(129) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(254) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(255) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(256) == WordWidth.BITS_16);
        assertTrue(WordWidth.unsignedEffective(257) == WordWidth.BITS_16);
    }

    public void test_unsignedEffectiveLong() {
        assertTrue(WordWidth.unsignedEffective(0L) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(1L) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(2L) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(126L) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(127L) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(128L) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(129L) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(254L) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(255L) == WordWidth.BITS_8);
        assertTrue(WordWidth.unsignedEffective(256L) == WordWidth.BITS_16);
        assertTrue(WordWidth.unsignedEffective(257L) == WordWidth.BITS_16);
    }

    public void test_signedEffectiveInt() {
        assertTrue(WordWidth.signedEffective(0) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(1) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(2) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(126) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(127) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(128) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(129) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(254) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(255) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(256) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(257) == WordWidth.BITS_16);

        assertTrue(WordWidth.signedEffective(-1) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(-2) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(-126) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(-127) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(-128) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(-129) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(-130) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(-254) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(-255) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(-256) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(-257) == WordWidth.BITS_16);
    }

    public void test_signedEffectiveLong() {
        assertTrue(WordWidth.signedEffective(0L) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(1L) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(2L) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(126L) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(127L) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(128L) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(129L) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(254L) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(255L) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(256L) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(257L) == WordWidth.BITS_16);

        assertTrue(WordWidth.signedEffective(-1L) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(-2L) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(-126L) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(-127L) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(-128L) == WordWidth.BITS_8);
        assertTrue(WordWidth.signedEffective(-129L) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(-130L) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(-254L) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(-255L) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(-256L) == WordWidth.BITS_16);
        assertTrue(WordWidth.signedEffective(-257L) == WordWidth.BITS_16);
    }
}
