/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
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
