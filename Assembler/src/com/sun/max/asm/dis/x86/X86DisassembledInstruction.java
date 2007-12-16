/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6e73a029-ec1e-4a1a-936a-73a3cbbb8b36*/
package com.sun.max.asm.dis.x86;

import com.sun.max.asm.Argument;
import com.sun.max.asm.dis.DisassembledInstruction;
import com.sun.max.asm.dis.DisassembledLabel;
import com.sun.max.asm.dis.GlobalLabelMapper;
import com.sun.max.asm.gen.ImmediateArgument;
import com.sun.max.asm.gen.ImplicitOperand;
import com.sun.max.asm.gen.cisc.x86.ParameterPlace;
import com.sun.max.asm.gen.cisc.x86.X86AddressParameter;
import com.sun.max.asm.gen.cisc.x86.X86DisplacementParameter;
import com.sun.max.asm.gen.cisc.x86.X86ImmediateParameter;
import com.sun.max.asm.gen.cisc.x86.X86OffsetParameter;
import com.sun.max.asm.gen.cisc.x86.X86Operand;
import com.sun.max.asm.gen.cisc.x86.X86Parameter;
import com.sun.max.asm.gen.cisc.x86.X86Template;
import com.sun.max.asm.gen.cisc.x86.X86TemplateContext;
import com.sun.max.asm.x86.IndirectRegister;
import com.sun.max.asm.x86.Scale;
import com.sun.max.collect.MutableQueue;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.Strings;
import com.sun.max.lang.WordWidth;
import java.util.Queue;

/**
 * An x86 instruction, given as an x86 template and a sequence of arguments.
 *
 * The string representation for disassembler output has the following format,
 * which borrows from both Intel and AT&T syntax and differs from either
 * regarding indirect addressing and indexing.
 *
 * Operand order follows Intel syntax:
 *
 * mnemonic argument
 * mnemonic destination, source
 * mnemonic argument1, argument2, argument3
 *
 * Some mnemonics may have operand size suffixes as in AT&T (gas) syntax.
 * Suffix    Intel size     Java size    # bits
 * ------    -----------    ---------    ------
 * b         byte           byte          8
 * w         word           short        16
 * l         long word      int          32
 * q         quad word      long         64
 *
 * Using this AT&T syntax feature, there is no need for operand size indicators
 * (e.g. DWORD PTR) for pointers as in Intel syntax.
 *
 * Registers etc. are named as in Intel syntax,
 * in lower case without AT&T's "%" prefix.
 *
 * Indexing is indicated by '[' and ']', similiar to array access in the Java(TM) Programming Language:
 *
 * base[index], e.g. eax[ebx]
 *
 * Indirect access looks like indexing without a base (or with implicit base 0):
 *
 * [indirect], e.g. [ecx]
 *
 * Displacements are added/subtracted from the index/indirect operand:
 *
 * base[index + displacement], e.g. ebp[eax - 12]
 * [indirect + displacement], e.g. [esi + 100]
 *
 * Scale is displayed as multiplication of the index:
 *
 * [base[index * scale] or base[index * scale + displacement], e.g. ecx[ebx * 4 + 10]
 *
 * A scale of 1 is left implicit, i.e. not printed.
 * Scale literals are the unsigned decimal integer numbers 2, 4, 8.
 *
 * Displacement literals are signed decimal integer numbers.
 *
 * Direct memory references (pointer literals) are unsigned hexadecimal integer numbers, e.g.:
 *
 * [0x12345678], 0x12345678[eax]
 *
 * Immediate operands are unsigned hexadecimal integer numbers, e.g.:
 *
 * 0x12, 0xffff, 0x0, 0x123456789abcdef
 *
 * Offset operands are signed decimal integer numbers, like displacements, but without space between the sign and the number, e.g.:
 *
 * jmp +12
 * call -2048
 *
 * RIP (Relative to Instruction Pointer) addressing is a combination of an offset operand and indirect addressing, e.g.:
 *
 * add [+20], eax
 * mov ebx, [-200]
 *
 * The disassembler displays synthetic labels for all target addresses
 * within the disassembled address range that hit the start address of an instruction.
 * Operands that coincide with such a label are displayed with the respective Label prepended. e.g.:
 *
 * jmp L1: +100
 * adc [L2: +128], ESI
 *
 * @author Bernd Mathiske
 * @author Greg Wright
 */
public abstract class X86DisassembledInstruction<Template_Type extends X86Template> extends DisassembledInstruction<Template_Type> {

    protected X86DisassembledInstruction(int offset, byte[] bytes, Template_Type template, Sequence<Argument> arguments) {
        super(offset, bytes, template, arguments);
    }

    private String getSibIndexAndScale(Queue<X86Operand> operands, Queue<Argument> arguments) {
        X86Parameter parameter = (X86Parameter) operands.remove();
        assert parameter.place() == ParameterPlace.SIB_INDEX || parameter.place() == ParameterPlace.SIB_INDEX_REXX;
        final String result = arguments.remove().disassembledValue();
        parameter = (X86Parameter) operands.remove();
        assert parameter.place() == ParameterPlace.SIB_SCALE;
        final Scale scale = (Scale) arguments.remove();
        if (scale == Scale.SCALE_1) {
            return result;
        }
        return result + " * " + scale.disassembledValue();
    }

    private String addition(Argument argument, String space) {
        assert argument instanceof ImmediateArgument;
        final long value = argument.asLong();
        final String s = Long.toString(value);
        if (value >= 0) {
            return "+" + space + s;
        }
        return "-" + space + s.substring(1);
    }

    private String getOperand(Queue<X86Operand> operands, Queue<Argument> arguments, Sequence<DisassembledLabel> labels) {
        final X86Operand operand = operands.remove();
        if (operand instanceof ImplicitOperand) {
            final ImplicitOperand implicitOperand = (ImplicitOperand) operand;
            return implicitOperand.argument().disassembledValue();
        }
        final X86Parameter parameter = (X86Parameter) operand;
        final Argument argument = arguments.remove();
        if (parameter instanceof X86DisplacementParameter) {
            assert parameter.place() == ParameterPlace.APPEND;
            final X86Parameter nextParameter = (X86Parameter) operands.element();
            String prefix = "";
            if (IndirectRegister.class.isAssignableFrom(nextParameter.type())) {
                operands.remove();
                prefix += "[" + arguments.remove().disassembledValue();
            } else {
                if (nextParameter.place() == ParameterPlace.SIB_BASE || nextParameter.place() == ParameterPlace.SIB_BASE_REXB) {
                    operands.remove();
                    prefix += arguments.remove().disassembledValue();
                }
                prefix += "[" + getSibIndexAndScale(operands, arguments);
            }
            return prefix + " " + addition(argument, " ") + "]";
        }
        if (parameter.place() == ParameterPlace.SIB_BASE || parameter.place() == ParameterPlace.SIB_BASE_REXB) {
            return argument.disassembledValue() + "[" + getSibIndexAndScale(operands, arguments) + "]";
        }
        if (IndirectRegister.class.isAssignableFrom(parameter.type())) {
            return "[" + argument.disassembledValue() + "]";
        }
        if (parameter instanceof X86AddressParameter) {
            String address = argument.disassembledValue();
            final DisassembledLabel label = addressArgumentToLabel((ImmediateArgument) argument, labels);
            if (label != null) {
                address = label.name() + ": " + address;
            }
            final X86Operand nextOperand = operands.peek();
            if (nextOperand instanceof X86Parameter) {
                final X86Parameter nextParameter = (X86Parameter) nextOperand;
                if (nextParameter.place() == ParameterPlace.SIB_INDEX || nextParameter.place() == ParameterPlace.SIB_INDEX_REXX) {
                    return address + "[" + getSibIndexAndScale(operands, arguments) + "]";
                }
            }
            return "[" + address + "]";
        }
        if (parameter instanceof X86OffsetParameter) {
            String offset = addition(argument, "");
            final DisassembledLabel label = offsetArgumentToLabel((ImmediateArgument) argument, labels);
            if (label != null) {
                offset = label.name() + ": " + offset;
            }
            if (template().addressSizeAttribute() == WordWidth.BITS_64 && template().rmCase() == X86TemplateContext.RMCase.SDWORD) {
                return "[" + offset + "]"; // RIP
            }
            return offset;
        }
        if (parameter.getClass() == X86ImmediateParameter.class) {
            return argument.disassembledValue();
        }
        return argument.disassembledValue();
    }

    @Override
    public String externalName() {
        return template().externalName();
    }

    @Override
    public String operandsToString(Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
        final Queue<X86Operand> operandQueue = new MutableQueue<X86Operand>(template().operands());
        final Queue<Argument> argumentQueue = new MutableQueue<Argument>(arguments());
        String result = "";
        String separator = "";
        while (!operandQueue.isEmpty()) {
            result += separator + getOperand(operandQueue, argumentQueue, labels);
            separator = ", ";
        }
        return result;
    }

    @Override
    public String toString(Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
        String s = operandsToString(labels, globalLabelMapper);
        if (s.length() > 0) {
            s = "  " + s;
        }
        return Strings.padLengthWithSpaces(externalName(), 8) + s;
    }

    @Override
    public int offsetForRelativeAddressing() {
        return startOffset() + bytes().length;
    }

}
