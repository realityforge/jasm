/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package test.jasm.util;

import jasm.util.Longs;
import junit.framework.TestCase;

/**
 * Tests for {@link Longs}.
 *
 * @author Bernd Mathiske
 */
public class LongsTest extends TestCase {
    public void test_numberOfEffectiveUnsignedBits() {
        assertTrue(Longs.numberOfEffectiveUnsignedBits(0L) == 0);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(1L) == 1);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(2L) == 2);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(3L) == 2);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(4L) == 3);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(126L) == 7);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(127L) == 7);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(129L) == 8);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(254L) == 8);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(255L) == 8);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(256L) == 9);
        assertTrue(Longs.numberOfEffectiveUnsignedBits(257L) == 9);
    }

    public void test_numberOfEffectiveSignedBits() {
        for (long i = 0; i < 257L; i++) {
            assertTrue(Longs.numberOfEffectiveSignedBits(i) == Longs.numberOfEffectiveUnsignedBits(i) + 1L);
        }
        assertTrue(Longs.numberOfEffectiveSignedBits(0L) == 1);
        assertTrue(Longs.numberOfEffectiveSignedBits(-1L) == 1);
        assertTrue(Longs.numberOfEffectiveSignedBits(-2L) == 2);
        assertTrue(Longs.numberOfEffectiveSignedBits(-3L) == 3);
        assertTrue(Longs.numberOfEffectiveSignedBits(-4L) == 3);
        assertTrue(Longs.numberOfEffectiveSignedBits(-5L) == 4);
        assertTrue(Longs.numberOfEffectiveSignedBits(-6L) == 4);
        assertTrue(Longs.numberOfEffectiveSignedBits(-7L) == 4);
        assertTrue(Longs.numberOfEffectiveSignedBits(-8L) == 4);
        assertTrue(Longs.numberOfEffectiveSignedBits(-9L) == 5);
        assertTrue(Longs.numberOfEffectiveSignedBits(-126L) == 8);
        assertTrue(Longs.numberOfEffectiveSignedBits(-127L) == 8);
        assertTrue(Longs.numberOfEffectiveSignedBits(-128L) == 8);
        assertTrue(Longs.numberOfEffectiveSignedBits(-129L) == 9);
        assertTrue(Longs.numberOfEffectiveSignedBits(-254L) == 9);
        assertTrue(Longs.numberOfEffectiveSignedBits(-255L) == 9);
        assertTrue(Longs.numberOfEffectiveSignedBits(-256L) == 9);
        assertTrue(Longs.numberOfEffectiveSignedBits(-257L) == 10);
    }
}
