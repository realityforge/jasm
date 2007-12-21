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
