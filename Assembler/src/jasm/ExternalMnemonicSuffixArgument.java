/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm;


/**
 * An argument whose {@link Argument#externalValue() value} is manifest as a suffix of the mnemonic
 * in external assembler syntax.
 *
 * @author Doug Simon
 */
public interface ExternalMnemonicSuffixArgument extends SymbolicArgument {
    boolean isOptional();
}
