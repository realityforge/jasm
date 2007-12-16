/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=96ddbf63-bbd2-47a3-8a89-d25882354a71*/
package jasm;

/**
 * An argument that corresponds to a non-optional mnemonic suffix in the external assembler syntax.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public abstract class NameSuffixSymbolicArgument extends AbstractSymbolicArgument implements ExternalMnemonicSuffixArgument {

    protected NameSuffixSymbolicArgument(int value) {
        super(value);
    }

    @Override
    public String externalValue() {
        return name().toLowerCase();
    }

    public boolean isOptional() {
        return false;
    }
}
