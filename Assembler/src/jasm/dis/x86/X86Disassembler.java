/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=63ebacf6-7aa1-4007-b697-a74444ad33c0*/
package jasm.dis.x86;

import jasm.Argument;
import jasm.Assembler;
import jasm.AssemblyException;
import jasm.util.WordWidth;
import jasm.amd64.AMD64GeneralRegister8;
import jasm.dis.DisassembledInstruction;
import jasm.dis.Disassembler;
import jasm.gen.Assembly;
import jasm.gen.Immediate16Argument;
import jasm.gen.Immediate32Argument;
import jasm.gen.Immediate64Argument;
import jasm.gen.Immediate8Argument;
import jasm.gen.cisc.x86.X86Assembly;
import jasm.gen.cisc.x86.X86EnumerableParameter;
import jasm.gen.cisc.x86.X86Field;
import jasm.gen.cisc.x86.X86NumericalParameter;
import jasm.gen.cisc.x86.X86Opcode;
import jasm.gen.cisc.x86.X86Parameter;
import jasm.gen.cisc.x86.X86Template;
import jasm.gen.cisc.x86.X86TemplateContext;
import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.io.Streams;
import com.sun.max.lang.Endianness;
import com.sun.max.program.Trace;
import com.sun.max.util.Enumerator;
import com.sun.max.util.HexByte;
import com.sun.max.util.Predicate;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * A disassembler for x86 instructions.
 *
 * @see Disassembler
 * @see X86DisassembledInstruction
 *
 * @author Bernd Mathiske
 */
public abstract class X86Disassembler<Template_Type extends X86Template, DisassembledInstruction_Type extends DisassembledInstruction<Template_Type>>
                          extends Disassembler<Template_Type, DisassembledInstruction_Type> {

    private int _currentOffset;

    protected X86Disassembler(Assembly<Template_Type> assembly, WordWidth addressWidth) {
        super(assembly, addressWidth, Endianness.LITTLE);
    }

    protected abstract boolean isRexPrefix(HexByte opcode);

    private X86InstructionHeader scanInstructionHeader(BufferedInputStream stream) throws IOException {
        int byteValue = stream.read();
        if (byteValue < 0) {
            return null;
        }
        final X86InstructionHeader header = new X86InstructionHeader();
        do {
            final HexByte hexByte = HexByte.values()[byteValue];
            if (header._opcode1 == null) {
                if (hexByte == X86Opcode.ADDRESS_SIZE) {
                    header._hasAddressSizePrefix = true;
                } else if (hexByte == X86Opcode.OPERAND_SIZE || hexByte == X86Opcode.REPE || hexByte == X86Opcode.REPNE) {
                    header._instructionSelectionPrefix = hexByte;
                } else if (isRexPrefix(hexByte)) {
                    header._rexPrefix = hexByte;
                } else {
                    header._opcode1 = hexByte;
                    if (hexByte != HexByte._0F) {
                        return header;
                    }
                }
            } else {
                header._opcode2 = hexByte;
                return header;
            }
            byteValue = stream.read();
        } while (byteValue >= 0);
        return header;
    }

    private Sequence<Argument> scanArguments(BufferedInputStream stream, Template_Type template, X86InstructionHeader header, byte modRMByte, byte sibByte) throws IOException {
        final AppendableSequence<Argument> arguments = new ArrayListSequence<Argument>();
        final byte rexByte = (header._rexPrefix != null) ? header._rexPrefix.byteValue() : 0;
        for (X86Parameter parameter : template.parameters()) {
            int value = 0;
            switch (parameter.place()) {
                case MOD_REG_REXR:
                    value = X86Field.extractRexValue(X86Field.REX_R_BIT_INDEX, rexByte);
                    // fall through...
                case MOD_REG:
                    value += X86Field.REG.extract(modRMByte);
                    break;
                case MOD_RM_REXB:
                    value = X86Field.extractRexValue(X86Field.REX_B_BIT_INDEX, rexByte);
                    // fall through...
                case MOD_RM:
                    value += X86Field.RM.extract(modRMByte);
                    break;
                case SIB_BASE_REXB:
                    value = X86Field.extractRexValue(X86Field.REX_B_BIT_INDEX, rexByte);
                    // fall through...
                case SIB_BASE:
                    value += X86Field.BASE.extract(sibByte);
                    break;
                case SIB_INDEX_REXX:
                    value = X86Field.extractRexValue(X86Field.REX_X_BIT_INDEX, rexByte);
                    // fall through...
                case SIB_INDEX:
                    value += X86Field.INDEX.extract(sibByte);
                    break;
                case SIB_SCALE:
                    value = X86Field.SCALE.extract(sibByte);
                    break;
                case APPEND:
                    if (parameter instanceof X86EnumerableParameter) {
                        final X86EnumerableParameter enumerableParameter = (X86EnumerableParameter) parameter;
                        final Enumerator enumerator = enumerableParameter.enumerator();
                        arguments.append((Argument) enumerator.fromValue(endianness().readByte(stream)));
                        continue;
                    }
                    final X86NumericalParameter numericalParameter = (X86NumericalParameter) parameter;
                    switch (numericalParameter.width()) {
                        case BITS_8:
                            arguments.append(new Immediate8Argument(endianness().readByte(stream)));
                            break;
                        case BITS_16:
                            arguments.append(new Immediate16Argument(endianness().readShort(stream)));
                            break;
                        case BITS_32:
                            arguments.append(new Immediate32Argument(endianness().readInt(stream)));
                            break;
                        case BITS_64:
                            arguments.append(new Immediate64Argument(endianness().readLong(stream)));
                            break;
                    }
                    continue;
                case OPCODE1_REXB:
                    value = X86Field.extractRexValue(X86Field.REX_B_BIT_INDEX, rexByte);
                    // fall through...
                case OPCODE1:
                    value += header._opcode1.ordinal() & 7;
                    break;
                case OPCODE2_REXB:
                    value = X86Field.extractRexValue(X86Field.REX_B_BIT_INDEX, rexByte);
                    // fall through...
                case OPCODE2:
                    value += header._opcode2.ordinal() & 7;
                    break;
            }
            final X86EnumerableParameter enumerableParameter = (X86EnumerableParameter) parameter;
            final Enumerator enumerator = enumerableParameter.enumerator();
            if (enumerator == AMD64GeneralRegister8.ENUMERATOR) {
                arguments.append(AMD64GeneralRegister8.fromValue(value, header._rexPrefix != null));
            } else {
                arguments.append((Argument) enumerator.fromValue(value));
            }
        }
        return arguments;
    }

    private int getModVariantParameterIndex(Template_Type template, byte modRMByte, byte sibByte) {
        if (template.modCase() == X86TemplateContext.ModCase.MOD_0 && X86Field.MOD.extract(modRMByte) != X86TemplateContext.ModCase.MOD_0.value()) {
            switch (template.rmCase()) {
                case NORMAL:
                    if (template.addressSizeAttribute() == WordWidth.BITS_16) {
                        if (X86Field.RM.extract(modRMByte) != X86TemplateContext.RMCase.SWORD.value()) {
                            return -1;
                        }
                    } else if (X86Field.RM.extract(modRMByte) != X86TemplateContext.RMCase.SDWORD.value()) {
                        return -1;
                    }
                    for (int i = 0; i < template.parameters().length(); i++) {
                        switch (template.parameters().get(i).place()) {
                            case MOD_RM_REXB:
                            case MOD_RM:
                                return i;
                            default:
                                break;
                        }
                    }
                    break;
                case SIB:
                    if (template.sibBaseCase() == X86TemplateContext.SibBaseCase.GENERAL_REGISTER && X86Field.BASE.extract(sibByte) == 5) {
                        for (int i = 0; i < template.parameters().length(); i++) {
                            switch (template.parameters().get(i).place()) {
                                case SIB_BASE_REXB:
                                case SIB_BASE:
                                    return i;
                                default:
                                    break;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return -1;
    }

    private byte getSibByte(BufferedInputStream stream, Template_Type template, byte modRMByte) throws IOException {
        if (template.addressSizeAttribute() == WordWidth.BITS_16) {
            return 0;
        }
        if (template.hasSibByte()) {
            return endianness().readByte(stream);
        }
        if (template.hasModRMByte() && X86Field.RM.extract(modRMByte) == X86TemplateContext.RMCase.SIB.value() &&
                   X86Field.MOD.extract(modRMByte) != X86TemplateContext.ModCase.MOD_3.value()) {
            return endianness().readByte(stream);
        }
        return 0;
    }

    protected abstract Map<X86InstructionHeader, AppendableSequence<Template_Type>> headerToTemplates();

    private static int _serial;

    public DisassembledInstruction_Type scanInstruction(BufferedInputStream stream, X86InstructionHeader header) throws IOException, AssemblyException {
        _serial++;
        Trace.line(3, "instruction: " + _serial);
        boolean isFloatingPointEscape = false;
        if (X86Opcode.isFloatingPointEscape(header._opcode1)) {
            final int byte2 = stream.read();
            if (byte2 >= 0xC0) {
                isFloatingPointEscape = true;
                header._opcode2 = HexByte.values()[byte2];
            }
        }
        if (header._opcode1 != null) {
            final Sequence<Template_Type> templates = headerToTemplates().get(header);
            if (templates != null) {
                for (Template_Type template : templates) {
                    stream.reset();
                    scanInstructionHeader(stream);
                    if (isFloatingPointEscape) {
                        stream.read();
                    }
                    try {
                        byte modRMByte = 0;
                        byte sibByte = 0;
                        int modVariantParameterIndex = -1;
                        Sequence<Argument> arguments = null;
                        if (template.hasModRMByte()) {
                            modRMByte = endianness().readByte(stream);
                            sibByte = getSibByte(stream, template, modRMByte);
                            modVariantParameterIndex = getModVariantParameterIndex(template, modRMByte, sibByte);
                            if (modVariantParameterIndex >= 0) {
                                final Template_Type modVariantTemplate = X86Assembly.getModVariantTemplate(templates, template, template.parameters().get(modVariantParameterIndex).type());
                                arguments = scanArguments(stream, modVariantTemplate, header, modRMByte, sibByte);
                            }
                        }
                        if (arguments == null) {
                            arguments = scanArguments(stream, template, header, modRMByte, sibByte);
                        }
                        if (modVariantParameterIndex >= 0) {
                            final Immediate8Argument immediateArgument = (Immediate8Argument) arguments.get(modVariantParameterIndex);
                            if (immediateArgument.value() != 0) {
                                continue;
                            }

                            // Remove the mod variant argument
                            final Argument modVariantArgument = arguments.get(modVariantParameterIndex);
                            arguments = Sequence.Static.filter(arguments, new Predicate<Argument>() {
                                public boolean evaluate(Argument argument) {
                                    return modVariantArgument != argument;
                                }
                            });
                        }
                        if (!Sequence.Static.containsIdentical(arguments, null)) {
                            final Assembler assembler = createAssembler(_currentOffset);
                            assembly().assemble(assembler, template, arguments);
                            final byte[] bytes = assembler.toByteArray();
                            stream.reset();
                            if (Streams.startsWith(stream, bytes)) {
                                final DisassembledInstruction_Type disassembledInstruction = createDisassembledInstruction(_currentOffset, bytes, template, arguments);
                                _currentOffset += bytes.length;
                                return disassembledInstruction;
                            }
                        }
                    } catch (IOException ioException) {
                        // this one did not work, so loop back up and try another template
                    }
                }
            }
        }
        if (header._instructionSelectionPrefix == X86Opcode.REPE || header._instructionSelectionPrefix == X86Opcode.REPNE) {
            final X86InstructionHeader prefixHeader = new X86InstructionHeader();
            prefixHeader._opcode1 = header._instructionSelectionPrefix;
            final Sequence<Template_Type> prefixTemplates = headerToTemplates().get(prefixHeader);
            final Template_Type template = prefixTemplates.first();
            final byte[] bytes = new byte[]{header._instructionSelectionPrefix.byteValue()};
            final DisassembledInstruction_Type disassembledInstruction = createDisassembledInstruction(_currentOffset, bytes, template, Sequence.Static.empty(Argument.class));
            _currentOffset++;
            return disassembledInstruction;
        }
        throw new AssemblyException("unknown instruction");
    }

    private static final int MORE_THAN_ANY_INSTRUCTION_LENGTH = 100;

    @Override
    public Sequence<DisassembledInstruction_Type> scanOneInstruction(BufferedInputStream stream) throws IOException, AssemblyException {
        stream.mark(MORE_THAN_ANY_INSTRUCTION_LENGTH);
        final X86InstructionHeader header = scanInstructionHeader(stream);
        if (header == null) {
            throw new AssemblyException("unknown instruction");
        }
        return new ArrayListSequence<DisassembledInstruction_Type>(scanInstruction(stream, header));
    }

    @Override
    public Sequence<DisassembledInstruction_Type> scan(BufferedInputStream stream) throws IOException, AssemblyException {
        final AppendableSequence<DisassembledInstruction_Type> result = new ArrayListSequence<DisassembledInstruction_Type>();
        while (true) {
            stream.mark(MORE_THAN_ANY_INSTRUCTION_LENGTH);
            final X86InstructionHeader header = scanInstructionHeader(stream);
            if (header == null) {
                return result;
            }
            final DisassembledInstruction_Type disassembledInstruction = scanInstruction(stream, header);
            result.append(disassembledInstruction);
        }
    }

}
