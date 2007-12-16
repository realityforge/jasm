/*VCSID=94f35135-bcd9-415c-91fc-5fd06fe3f634*/
/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/* VCSID=a5b1da0c-ba1a-4c30-89a6-ad3e43802e06 */
package com.sun.max.asm;

import com.sun.max.lang.WordWidth;

/**
 * Interface for target code edition. Currently, used by the JIT only, for template-based code generation.
 * The interface is currently customized to the need of the JIT.
 *
 * @author Laurent Daynes
 */
public interface AssemblyInstructionEditor {
    /**
     * Returns the displacement in the edited instruction.
     * @param displacementWidth the width of the displacement in the instruction
     * @return  the displacement in the edited instruction
     */
    int getIntDisplacement(WordWidth displacementWidth) throws AssemblyException;

    /**
     * Returns the immediate int value in the edited instruction.
     * @param displacementWidth the width of the displacement in the instruction
     * @return  the displacement in the edited instruction
     */
   int getIntImmediate(WordWidth immediateWidth) throws AssemblyException;

    /**
     * Replace the value of the immediate displacement in a load/store instruction.
     * The original instruction must have an immediate displacement operand that can hold 8-bit immediate value.
     * @param disp8
     */
    void fixDisplacement(WordWidth displacementWidth, boolean withIndex, byte disp8);

    /**
     * Replace the value of the immediate displacement in a load/store instruction.
     * The original instruction must have an immediate displacement operand that can hold 32-bit immediate value.
     * @param disp32
     * @throws AssemblyException
     *      if the replacement is not allowed (e.g., the instruction is
     *      not a load/store with immediate displacement parameter).
     */
    void fixDisplacement(WordWidth displacementWidth, boolean withIndex, int disp32) throws AssemblyException;

    /**
     * Replace the value of the immediate source operand of an  instruction.
     * (tested with store instruction only).
     * @param operandWidth the width of the operand being replaced
     * @param imm8 the new immediate value of the operand.
     */
    void fixImmediateOperand(WordWidth operandWidth, byte imm8);

    /**
     * Replace the value of the immediate source operand of an  instruction.
     * (tested with store instruction only).
     * @param operandWidth the width of the operand being replaced
     * @param imm16 the new immediate value of the operand.
     */
    void fixImmediateOperand(WordWidth operandWidth, short imm16);

    /**
     * Replace the value of the immediate source operand of an  instruction.
     * (tested with store instruction only).
     * @param operandWidth the width of the operand being replaced
     * @param imm32 the new immediate value of the operand.
     */
    void fixImmediateOperand(WordWidth operandWidth, int imm32);

    /**
     * Replace the value of the immediate source operand of an  instruction.
     * @param imm64 the new immediate value of the operand.
     */
    void fixImmediateOperand(int imm32);

    /**
     * Replace the value of the immediate source operand of an  instruction.
     * @param imm64 the new immediate value of the operand.
     */
    void fixImmediateOperand(long imm64);
}
