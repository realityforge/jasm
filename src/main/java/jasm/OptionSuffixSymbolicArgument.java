/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

/** An argument that corresponds to an optional mnemonic suffix in the external assembler syntax. */
public abstract class OptionSuffixSymbolicArgument
    extends AbstractSymbolicArgument
    implements ExternalMnemonicSuffixArgument {

  private final String _externalMnemonicSuffix;

  protected OptionSuffixSymbolicArgument(int value, String externalMnemonicSuffix) {
    super(value);
    _externalMnemonicSuffix = externalMnemonicSuffix;
  }

  @Override
  public final String externalValue() {
    return _externalMnemonicSuffix;
  }

  public final boolean isOptional() {
    return true;
  }
}
