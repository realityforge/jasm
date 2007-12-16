/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm;


/**
 * Instruction Set Architecture monikers.
 *
 * @author Bernd Mathiske
 */
public enum InstructionSet {

    AMD64(Category.CISC, RelativeAddressing.FROM_INSTRUCTION_END),
    IA32(Category.CISC, RelativeAddressing.FROM_INSTRUCTION_END),
    PPC(Category.RISC, RelativeAddressing.FROM_INSTRUCTION_START),
    SPARC(Category.RISC, RelativeAddressing.FROM_INSTRUCTION_START);

    public enum Category {
        CISC, RISC;
    }

    private final Category _category;

    public Category category() {
        return _category;
    }

    public enum RelativeAddressing {
        FROM_INSTRUCTION_START, FROM_INSTRUCTION_END;
    }

    private final RelativeAddressing _relativeAddressing;

    public RelativeAddressing relativeAddressing() {
        return _relativeAddressing;
    }

    private InstructionSet(Category category, RelativeAddressing relativeAddressing) {
        _category = category;
        _relativeAddressing = relativeAddressing;
    }

    @Override
    public String toString() {
        return name();
    }

}
