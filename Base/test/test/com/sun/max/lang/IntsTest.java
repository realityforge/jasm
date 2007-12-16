/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6da9cd72-c8d6-4c34-a0f0-014071ef8a96*/
package test.com.sun.max.lang;

import junit.framework.*;

import com.sun.max.lang.*;

/**
 * Tests for {@link Ints}.
 *
 * @author Bernd Mathiske
 */
public class IntsTest extends TestCase {
 
    public IntsTest(String name) {
        super(name);
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(IntsTest.class);
    }

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
