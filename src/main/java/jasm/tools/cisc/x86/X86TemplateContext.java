/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.WordWidth;
import jasm.tools.util.ProgramError;

/**
 * A bundle of choices one can make when creating a template.
 */
public final class X86TemplateContext implements Cloneable {

    public enum ModCase {
        MOD_0, MOD_1, MOD_2, MOD_3;

        public int value() {
            return ordinal();
        }
    }

    public enum RMCase {
        NORMAL(0), SIB(4), SWORD(6), SDWORD(5);

        private final int _rmFieldValue;

        private RMCase(int rmFieldValue) {
            _rmFieldValue = rmFieldValue;
        }

        public int value() {
            return _rmFieldValue;
        }
    }

    public enum SibIndexCase {
        GENERAL_REGISTER,
        NONE
    }

    public enum SibBaseCase {
        GENERAL_REGISTER,
        SPECIAL
    }

    X86TemplateContext() {
    }

    private WordWidth _addressSizeAttribute;

    public final WordWidth addressSizeAttribute() {
        return _addressSizeAttribute;
    }

    public final void setAddressSizeAttribute(WordWidth addressSizeAttribute) {
        _addressSizeAttribute = addressSizeAttribute;
    }

    private WordWidth _operandSizeAttribute;

    public final WordWidth operandSizeAttribute() {
        return _operandSizeAttribute;
    }

    public final void setOperandSizeAttribute(WordWidth operandSizeAttribute) {
        _operandSizeAttribute = operandSizeAttribute;
    }

    private ModRMGroup.Opcode _modRMGroupOpcode;

    public final ModRMGroup.Opcode modRMGroupOpcode() {
        return _modRMGroupOpcode;
    }

    public final void setModRMGroupOpcode(ModRMGroup.Opcode modRMGroupOpcode) {
        _modRMGroupOpcode = modRMGroupOpcode;
    }

    private ModCase _modCase;

    public final ModCase modCase() {
        return _modCase;
    }

    public final void setModCase(ModCase modCase) {
        _modCase = modCase;
    }

    private RMCase _rmCase;

    public final RMCase rmCase() {
        return _rmCase;
    }

    public final void setRMCase(RMCase rmCase) {
        _rmCase = rmCase;
    }

    private SibIndexCase _sibIndexCase;

    public final SibIndexCase sibIndexCase() {
        return _sibIndexCase;
    }

    public final void setSibIndexCase(SibIndexCase sibIndexCase) {
        _sibIndexCase = sibIndexCase;
    }

    protected SibBaseCase _sibBaseCase;

    public final SibBaseCase sibBaseCase() {
        return _sibBaseCase;
    }

    public final void setSibBaseCase(SibBaseCase sibBaseCase) {
        _sibBaseCase = sibBaseCase;
    }

    @Override
    public final X86TemplateContext clone() {
        try {
            return (X86TemplateContext) super.clone();
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new ProgramError("clone() failed", cloneNotSupportedException);
        }
    }

    @Override
    public final String toString() {
        return "<Context: " + _addressSizeAttribute + ", " + _operandSizeAttribute + ", " + _modRMGroupOpcode + ", " + _modCase + ", " + _rmCase + ", " + _sibIndexCase + ", " + _sibBaseCase + ">";
    }
}
