/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.Argument;
import jasm.WordWidth;
import jasm.dis.DisassembledInstruction;
import jasm.gen.Assembly;
import jasm.gen.AssemblyTestComponent;
import jasm.gen.ImmediateArgument;
import jasm.gen.ImplicitOperand;
import jasm.gen.test.AssemblyTester;
import jasm.gen.util.IndentWriter;
import jasm.util.HexByte;
import jasm.util.lang.StaticLoophole;
import jasm.x86.IndirectRegister;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Bernd Mathiske
 */
public abstract class X86AssemblyTester<Template_Type extends X86Template, DisassembledInstruction_Type extends DisassembledInstruction<Template_Type>>
                          extends AssemblyTester<Template_Type, DisassembledInstruction_Type> {

    public X86AssemblyTester(Assembly<Template_Type> assembly, WordWidth addressWidth, EnumSet<AssemblyTestComponent> components) {
        super(assembly, addressWidth, components);
    }

    @Override
    public final X86Assembly<Template_Type> assembly() {
        return StaticLoophole.cast(super.assembly());
    }

    private String getSibIndexAndScale(Queue<X86Operand> operands, Queue<Argument> arguments) {
        X86Parameter parameter = (X86Parameter) operands.remove();
        assert parameter.place() == ParameterPlace.SIB_INDEX || parameter.place() == ParameterPlace.SIB_INDEX_REXX;
        final String result = arguments.remove().externalValue() + ",";
        parameter = (X86Parameter) operands.remove();
        assert parameter.place() == ParameterPlace.SIB_SCALE;
        return result + arguments.remove().externalValue() + ")";
    }

    private String getOperand(X86Template template, Queue<X86Operand> operands, Queue<Argument> arguments, String label) {
        final X86Operand operand = operands.remove();
        if (operand instanceof ImplicitOperand) {
            final ImplicitOperand implicitOperand = (ImplicitOperand) operand;
            if (implicitOperand.externalPresence() == ImplicitOperand.ExternalPresence.OMITTED) {
                return "";
            }
            final Argument argument = implicitOperand.argument();
            if (argument instanceof ImmediateArgument) {
                return "$" + implicitOperand.argument().externalValue();
            }
            return implicitOperand.argument().externalValue();
        }
        final X86Parameter parameter = (X86Parameter) operand;
        final Argument argument = arguments.remove();
        if (parameter instanceof X86DisplacementParameter) {
            assert parameter.place() == ParameterPlace.APPEND;
            final ImmediateArgument immediateArgument = (ImmediateArgument) argument;
            String prefix = immediateArgument.signedExternalValue() + "(";
            final X86Parameter nextParameter = (X86Parameter) operands.element();
            if (IndirectRegister.class.isAssignableFrom(nextParameter.type())) {
                operands.remove();
                return prefix + arguments.remove().externalValue() + ")";
            }
            if (nextParameter.place() == ParameterPlace.SIB_BASE || nextParameter.place() == ParameterPlace.SIB_BASE_REXB) {
                operands.remove();
                prefix += arguments.remove().externalValue() + ",";
            }
            return prefix + getSibIndexAndScale(operands, arguments);
        }
        if (parameter.place() == ParameterPlace.SIB_BASE || parameter.place() == ParameterPlace.SIB_BASE_REXB) {
            return "(" + argument.externalValue() + "," + getSibIndexAndScale(operands, arguments);
        }
        if (IndirectRegister.class.isAssignableFrom(parameter.type())) {
            return "(" + argument.externalValue() + ")";
        }
        if (parameter instanceof X86AddressParameter) {
            final X86Operand nextOperand = operands.peek();
            if (nextOperand instanceof X86Parameter) {
                final X86Parameter nextParameter = (X86Parameter) nextOperand;
                if (nextParameter.place() == ParameterPlace.SIB_INDEX || nextParameter.place() == ParameterPlace.SIB_INDEX_REXX) {
                    return argument.externalValue() + "(," + getSibIndexAndScale(operands, arguments);
                }
            }
        }
        if (parameter instanceof X86OffsetParameter) {
            if (template.addressSizeAttribute() == WordWidth.BITS_64 && template.rmCase() == X86TemplateContext.RMCase.SDWORD) {
                return argument.externalValue() + "(%rip)";
            }
            final ImmediateArgument immediateArgument = (ImmediateArgument) argument;
            return label + " + (" + immediateArgument.signedExternalValue() + ")";
        }
        if (parameter.getClass() == X86ImmediateParameter.class) {
            return "$" + argument.externalValue();
        }
        return argument.externalValue();
    }

    /**
     * Yes, 'X86DisassembledInstruction.toString()' may be similar,
     * but it pertains only to our own private disassembly output style,
     * whereas here, we have to comply strictly with the requirements of GNU asm (gas).
     * We keep these two objectives completely separate and
     * we want to keep the code in this file here stable.
     */
    @Override
    protected final void assembleExternally(IndentWriter stream, Template_Type template, List<Argument> argumentList, String label) {
        final WordWidth externalCodeSizeAttribute = template.externalCodeSizeAttribute();
        if (externalCodeSizeAttribute != null) {
            stream.println(".code" + externalCodeSizeAttribute.numberOfBits());
        } else {
            stream.println(".code" + addressWidth().numberOfBits());
        }
        final LinkedList<X86Operand> operandQueue = new LinkedList<X86Operand>(template.operands());
        final LinkedList<Argument> argumentQueue = new LinkedList<Argument>(argumentList);
        String first = "";
        if (!operandQueue.isEmpty()) {
            first = getOperand(template, operandQueue, argumentQueue, label);
        }
        String second = "";
        if (!operandQueue.isEmpty()) {
            second = getOperand(template, operandQueue, argumentQueue, label);
        }
        String third = "";
        if (!operandQueue.isEmpty()) {
            third = getOperand(template, operandQueue, argumentQueue, label);
        }

        stream.print(template.externalName());
        stream.print("    ");
        if (third.length() > 0) {
            stream.print(third + ",");
        }
        if (template.isExternalOperandOrderingInverted()) {
            if (second.length() > 0) {
                stream.print(second + ",");
            }
            stream.println(first);
        } else {
            if (first.length() > 0) {
                stream.print(first + ",");
            }
            stream.println(second);
        }
        stream.outdent();
        stream.println(label + ":");
        stream.indent();
    }

    @Override
    protected final byte[] readExternalInstruction(PushbackInputStream externalInputStream, Template_Type template, byte[] internalBytes) throws IOException {
        if (X86Opcode.isFloatingPointEscape(template.opcode1())) {
            // We skip FWAIT instructions that the external assembler may inject before floating point operations
            final int externalOpcode = externalInputStream.read();
            if (externalOpcode != X86Opcode.FWAIT.ordinal()) {
                externalInputStream.unread(externalOpcode);
            }
        }
        final byte[] externalBytes = new byte[internalBytes.length];
        int i = 0;
        final WordWidth externalCodeSizeAttribute = template.externalCodeSizeAttribute();
        if (externalCodeSizeAttribute != null && externalCodeSizeAttribute != addressWidth()) {
            if (template.addressSizeAttribute() == externalCodeSizeAttribute) {
                assert internalBytes[0] == X86Opcode.ADDRESS_SIZE.byteValue();
                externalBytes[i++] = X86Opcode.ADDRESS_SIZE.byteValue();
            } else {
                assert internalBytes[0] != X86Opcode.ADDRESS_SIZE.byteValue();
                final int externalOpcode = externalInputStream.read();
                if (externalOpcode != X86Opcode.ADDRESS_SIZE.ordinal()) {
                    externalInputStream.unread(externalOpcode);
                }
            }
            if (template.instructionSelectionPrefix() != HexByte._66) {
                if (template.operandSizeAttribute() == externalCodeSizeAttribute && externalCodeSizeAttribute == WordWidth.BITS_16) {
                    assert internalBytes[i] == X86Opcode.OPERAND_SIZE.byteValue();
                    externalBytes[i++] = X86Opcode.OPERAND_SIZE.byteValue();
                } else if (template.operandSizeAttribute() != WordWidth.BITS_16) {
                    assert internalBytes[i] != X86Opcode.OPERAND_SIZE.byteValue();
                    final int externalOpcode = externalInputStream.read();
                    if (externalOpcode != X86Opcode.OPERAND_SIZE.ordinal()) {
                        externalInputStream.unread(externalOpcode);
                    }
                }
            }
            if (externalCodeSizeAttribute != WordWidth.BITS_64 && template.operandSizeAttribute() == WordWidth.BITS_64 &&
                    template.instructionDescription().defaultOperandSize() != WordWidth.BITS_64) {
                assert 0x40 <= internalBytes[i] && internalBytes[i] <= 0x4F; // is REX prefix
                externalBytes[i] = internalBytes[i];
                i++;
            }
        }
        while (i < externalBytes.length) {
            externalBytes[i] = (byte) externalInputStream.read();
            i++;
        }
        return externalBytes;
    }

    @Override
    protected final boolean readNop(InputStream stream) throws IOException {
        final int instruction = stream.read();
        return instruction == 0x90;
    }

    @Override
    protected final String disassembleFields(Template_Type template, byte[] assembledInstruction) {
        return "<not yet implemented>";
    }
}
