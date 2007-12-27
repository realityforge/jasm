/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

/** An argument that corresponds to a non-optional mnemonic suffix in the external assembler syntax. */
public abstract class NameSuffixSymbolicArgument extends AbstractSymbolicArgument implements ExternalMnemonicSuffixArgument {

  protected NameSuffixSymbolicArgument(int value) {
    super(value);
  }

  @Override
  public final String externalValue() {
    return name().toLowerCase();
  }

  public final boolean isOptional() {
    return false;
  }
}
