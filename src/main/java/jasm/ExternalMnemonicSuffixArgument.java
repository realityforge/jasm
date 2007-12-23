/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;


/**
 * An argument whose {@link Argument#externalValue() value} is manifest as a suffix of the mnemonic
 * in external assembler syntax.
 */
public interface ExternalMnemonicSuffixArgument extends SymbolicArgument {
    boolean isOptional();
}
