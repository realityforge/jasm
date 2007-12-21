/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.util;

import jasm.util.Ints;
import junit.framework.TestCase;

/**
 * Tests for {@link Ints}.
 *
 * @author Bernd Mathiske
 */
public class IntsTest extends TestCase {
    public void test_numberOfEffectiveUnsignedBits() {
        assertTrue(Ints.numberOfEffectiveUnsignedBits(0) == 0);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(1) == 1);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(2) == 2);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(3) == 2);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(4) == 3);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(126) == 7);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(127) == 7);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(128) == 8);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(129) == 8);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(254) == 8);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(255) == 8);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(256) == 9);
        assertTrue(Ints.numberOfEffectiveUnsignedBits(257) == 9);
    }

    public void test_numberOfEffectiveSignedBits() {
        for (int i = 0; i < 257; i++) {
            assertTrue(Ints.numberOfEffectiveSignedBits(i) == Ints.numberOfEffectiveUnsignedBits(i) + 1);
        }
        assertTrue(Ints.numberOfEffectiveSignedBits(0) == 1);
        assertTrue(Ints.numberOfEffectiveSignedBits(-1) == 1);
        assertTrue(Ints.numberOfEffectiveSignedBits(-2) == 2);
        assertTrue(Ints.numberOfEffectiveSignedBits(-3) == 3);
        assertTrue(Ints.numberOfEffectiveSignedBits(-4) == 3);
        assertTrue(Ints.numberOfEffectiveSignedBits(-5) == 4);
        assertTrue(Ints.numberOfEffectiveSignedBits(-6) == 4);
        assertTrue(Ints.numberOfEffectiveSignedBits(-7) == 4);
        assertTrue(Ints.numberOfEffectiveSignedBits(-8) == 4);
        assertTrue(Ints.numberOfEffectiveSignedBits(-9) == 5);
        assertTrue(Ints.numberOfEffectiveSignedBits(-126) == 8);
        assertTrue(Ints.numberOfEffectiveSignedBits(-127) == 8);
        assertTrue(Ints.numberOfEffectiveSignedBits(-128) == 8);
        assertTrue(Ints.numberOfEffectiveSignedBits(-129) == 9);
        assertTrue(Ints.numberOfEffectiveSignedBits(-254) == 9);
        assertTrue(Ints.numberOfEffectiveSignedBits(-255) == 9);
        assertTrue(Ints.numberOfEffectiveSignedBits(-256) == 9);
        assertTrue(Ints.numberOfEffectiveSignedBits(-257) == 10);
    }
}
