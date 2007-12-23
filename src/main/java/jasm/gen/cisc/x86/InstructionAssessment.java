/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;


/**
 * Some information about a family of instructions that have the same basic opcode.
 *
 * @see OpcodeAssessor
 */
public final class InstructionAssessment {

    private boolean _hasAddressSizeVariants;
    private boolean _hasOperandSizeVariants;
    private boolean _hasModRMByte;
    private ModRMGroup _modRMGroup;
    private boolean _isJump;

    public InstructionAssessment() {
    }

    public final void haveAddressSizeVariants() {
        _hasAddressSizeVariants = true;
    }

    public final boolean hasAddressSizeVariants() {
        return _hasAddressSizeVariants;
    }

    public final void haveOperandSizeVariants() {
        _hasOperandSizeVariants = true;
    }

    public final boolean hasOperandSizeVariants() {
        return _hasOperandSizeVariants;
    }

    public final void haveModRMByte() {
        _hasModRMByte = true;
    }

    public final boolean hasModRMByte() {
        return _hasModRMByte;
    }

    public final void setModRMGroup(ModRMGroup modRMGroup) {
        _modRMGroup = modRMGroup;
        _hasModRMByte = modRMGroup != null;
    }

    public final ModRMGroup modRMGroup() {
        return _modRMGroup;
    }

    public final void beJump() {
        _isJump = true;
    }

    public final boolean isJump() {
        return _isJump;
    }
}
