/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.util;

import jasm.WordWidth;
import junit.framework.TestCase;

/**
 * Tests for {@link jasm.WordWidth}.
 */
public final class WordWidthTest extends TestCase {
  public final void test_fromInt() {
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

  public final void test_unsignedEffectiveInt() {
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

  public final void test_unsignedEffectiveLong() {
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

  public final void test_signedEffectiveInt() {
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

  public final void test_signedEffectiveLong() {
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
