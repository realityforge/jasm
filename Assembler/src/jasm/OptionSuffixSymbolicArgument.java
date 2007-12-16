/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=aea8a06b-7a48-4e67-b889-f0320bbe0717*/
package jasm;

/**
 * An argument that corresponds to an optional mnemonic suffix in the external assembler syntax.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public abstract class OptionSuffixSymbolicArgument extends AbstractSymbolicArgument implements ExternalMnemonicSuffixArgument {

    private final String _externalMnemonicSuffix;

    protected OptionSuffixSymbolicArgument(int value, String externalMnemonicSuffix) {
        super(value);
        _externalMnemonicSuffix = externalMnemonicSuffix;
    }

    @Override
    public String externalValue() {
        return _externalMnemonicSuffix;
    }

    public boolean isOptional() {
        return true;
    }
}
