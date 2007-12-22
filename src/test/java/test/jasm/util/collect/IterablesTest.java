/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.util.collect;

import jasm.util.collect.Iterables;
import junit.framework.TestCase;

/**
 * Tests for jasm.util.util.Iterables.
 *
 * @author Hiroshi Yamauchi
 */
public class IterablesTest extends TestCase {
  public void test_empty() {
    final Iterable<String> iterable = Iterables.empty();
    int counter = 0;
    for (String s : iterable) {
      counter = s.length() + 1;
    }
    assertTrue(counter == 0);
  }
}
