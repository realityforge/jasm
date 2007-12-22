/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.util;

import jasm.util.HexByte;
import java.util.EnumSet;
import junit.framework.TestCase;

/**
 * Tests for {@link HexByte}.
 *
 * @author Hiroshi Yamauchi
 */
public final class HexByteTest extends TestCase {
  public final void test_value() {
    final EnumSet<HexByte> enumSet = EnumSet.allOf(HexByte.class);
    for (Enum e : enumSet) {
      assertTrue(Integer.parseInt(e.name().substring(1), 16) == e.ordinal());
    }
  }
}
