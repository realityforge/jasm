/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.x86;


/**
 * Some information about a family of instructions that have the same basic opcode.
 *
 * @see OpcodeAssessor
 *
 * @author Bernd Mathiske
 */
public class InstructionAssessment {

    private boolean _hasAddressSizeVariants;
    private boolean _hasOperandSizeVariants;
    private boolean _hasModRMByte;
    private ModRMGroup _modRMGroup;
    private boolean _isJump;

    public InstructionAssessment() {
    }

    public void haveAddressSizeVariants() {
        _hasAddressSizeVariants = true;
    }

    public boolean hasAddressSizeVariants() {
        return _hasAddressSizeVariants;
    }

    public void haveOperandSizeVariants() {
        _hasOperandSizeVariants = true;
    }

    public boolean hasOperandSizeVariants() {
        return _hasOperandSizeVariants;
    }

    public void haveModRMByte() {
        _hasModRMByte = true;
    }

    public boolean hasModRMByte() {
        return _hasModRMByte;
    }

    public void setModRMGroup(ModRMGroup modRMGroup) {
        _modRMGroup = modRMGroup;
        _hasModRMByte = modRMGroup != null;
    }

    public ModRMGroup modRMGroup() {
        return _modRMGroup;
    }

    public void beJump() {
        _isJump = true;
    }

    public boolean isJump() {
        return _isJump;
    }
}
