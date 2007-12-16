/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7120018c-854a-451f-9fd0-3f491dfae30f*/
package com.sun.max.asm;


/**
 * An argument whose {@link Argument#externalValue() value} is manifest as a suffix of the mnemonic
 * in external assembler syntax.
 *
 * @author Doug Simon
 */
public interface ExternalMnemonicSuffixArgument extends SymbolicArgument {
    boolean isOptional();
}
