/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.sparc;

import jasm.OptionSuffixSymbolicArgument;
import jasm.SymbolSet;

/**
 * An optional (suffix) argument to a branch assembler instruction specifying
 * if the instruction in the delay slot of the branch will be executed. For example:
 * <pre>bne,a <i>label</i></pre>
 */
public final class AnnulBit extends OptionSuffixSymbolicArgument {

  private AnnulBit(int value, String externalMnemonicSuffix) {
    super(value, externalMnemonicSuffix);
  }

  /** The annul bit is not set. */
  public static final AnnulBit NO_A = new AnnulBit(0, "");

  /** The annul bit is set. */
  public static final AnnulBit A = new AnnulBit(1, ",a");

  public static final SymbolSet<AnnulBit> SYMBOLS = SymbolSet.fromStaticFields(AnnulBit.class);
}
