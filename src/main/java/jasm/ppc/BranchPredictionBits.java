/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ppc;

import jasm.OptionSuffixSymbolicArgument;
import jasm.SymbolSet;

/**
 * The branch prediction values for the conditional branches whose encoding includes
 * a hint about whether the branch is likely to be taken or is likely not to be taken.
 */
public final class BranchPredictionBits extends OptionSuffixSymbolicArgument {

  private BranchPredictionBits(int value, String externalMnemonicSuffix) {
    super(value, externalMnemonicSuffix);
  }

  /**
   * No hint is given.
   */
  public static final BranchPredictionBits NONE = new BranchPredictionBits(0, "");

  /**
   * The branch is very likely to be taken.
   */
  public static final BranchPredictionBits PT = new BranchPredictionBits(3, "++");

  /**
   * The branch is very likely <b>not</b> to be taken.
   */
  public static final BranchPredictionBits PN = new BranchPredictionBits(2, "--");

  public static final SymbolSet<BranchPredictionBits> SYMBOLS = SymbolSet.fromStaticFields(BranchPredictionBits.class);
}
