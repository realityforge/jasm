/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.util;

import jasm.Symbol;
import jasm.SymbolSet;
import junit.framework.TestCase;

public final class SymbolSetTest extends TestCase {

  private static enum NonSuccessiveEnum implements Symbol {
    E0(0), E100(100), E1000(1000);

    private final int _value;

    private NonSuccessiveEnum(int value) {
      _value = value;
    }

    public int value() {
      return _value;
    }
  }

  public final void test_value() {
    assertTrue(NonSuccessiveEnum.E0.ordinal() == 0);
    assertTrue(NonSuccessiveEnum.E100.ordinal() == 1);
    assertTrue(NonSuccessiveEnum.E1000.ordinal() == 2);
    assertTrue(NonSuccessiveEnum.E0.value() == 0);
    assertTrue(NonSuccessiveEnum.E100.value() == 100);
    assertTrue(NonSuccessiveEnum.E1000.value() == 1000);
  }

  public final void test_symbols() {
    final SymbolSet<NonSuccessiveEnum> enumerator = SymbolSet.fromEnum(NonSuccessiveEnum.class);
    assertTrue(enumerator.type() == NonSuccessiveEnum.class);
    int sum = 0;
    for (NonSuccessiveEnum e : enumerator) {
      sum += e.value();
    }
    assertTrue(sum == 1100);
    assertTrue(enumerator.fromValue(0) == NonSuccessiveEnum.E0);
    assertTrue(enumerator.fromValue(100) == NonSuccessiveEnum.E100);
    assertTrue(enumerator.fromValue(1000) == NonSuccessiveEnum.E1000);
    assertTrue(enumerator.fromValue(1) == null);
  }
}
