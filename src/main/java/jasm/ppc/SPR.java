/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ppc;

import jasm.AbstractSymbolicArgument;
import jasm.SymbolSet;

/**
 * Special Purpose Registers.
 */
public final class SPR extends AbstractSymbolicArgument {

  private SPR(int value) {
    super(value);
  }

  /**
   * Denotes the Fixed-Point Exception Register.
   */
  public static final SPR XER = new SPR(1);

  /**
   * Denotes the Link Register.
   */
  public static final SPR LR = new SPR(8);

  /**
   * Denotes the Count Register.
   */
  public static final SPR CTR = new SPR(9);

  public static final SymbolSet<SPR> SYMBOLS = SymbolSet.fromStaticFields(SPR.class);
}
