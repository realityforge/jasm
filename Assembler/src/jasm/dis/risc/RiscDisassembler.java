/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.risc;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.Endianness;
import com.sun.max.lang.StaticLoophole;
import com.sun.max.program.ProgramWarning;
import jasm.Argument;
import jasm.Assembler;
import jasm.AssemblyException;
import jasm.dis.DisassembledInstruction;
import jasm.dis.Disassembler;
import jasm.gen.Assembly;
import jasm.gen.InstructionConstraint;
import jasm.gen.risc.RiscAssembly;
import jasm.gen.risc.RiscTemplate;
import jasm.gen.risc.field.OperandField;
import jasm.util.WordWidth;
import jasm.util.HexUtil;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 * @author Dave Ungar
 * @author Adam Spitz
 */
public abstract class RiscDisassembler<Template_Type extends RiscTemplate, DisassembledInstruction_Type extends DisassembledInstruction<Template_Type>>
    extends Disassembler<Template_Type, DisassembledInstruction_Type> {

    protected RiscDisassembler(Assembly<Template_Type> assembly, WordWidth addressWidth, Endianness endianness) {
        super(assembly, addressWidth, endianness);
    }

    @Override
    public RiscAssembly<Template_Type> assembly() {
        return StaticLoophole.cast(super.assembly());
    }

    private int _currentOffset;

    /**
     * Extract the value for each operand of a template from an encoded instruction whose opcode
     * matches that of the template.
     *
     * @param instruction  the encoded instruction
     * @return the decoded arguments for each operand or null if at least one operand has
     *         an invalid value in the encoded instruction
     */
    private Sequence<Argument> disassemble(int instruction, Template_Type template) {
        final AppendableSequence<Argument> arguments = new ArrayListSequence<Argument>();
        for (OperandField operandField : template.parameters()) {
            final Argument argument = operandField.disassemble(instruction);
            if (argument == null) {
                return null;
            }
            arguments.append(argument);
        }
        return arguments;
    }

    private boolean isLegalArgumentList(Template_Type template, Sequence<Argument> arguments) {
        final Sequence<InstructionConstraint> constraints = template.instructionDescription().constraints();
        for (InstructionConstraint constraint : constraints) {
            if (!(constraint.check(template, arguments))) {
                return false;
            }
        }
        return true;
    }
    @Override
    public Sequence<DisassembledInstruction_Type> scanOneInstruction(BufferedInputStream stream) throws IOException, AssemblyException {
        final int instruction = endianness().readInt(stream);
        final AppendableSequence<DisassembledInstruction_Type> result = new ArrayListSequence<DisassembledInstruction_Type>();
        final byte[] instructionBytes = endianness().toBytes(instruction);
        for (SpecificityGroup<Template_Type> specificityGroup : assembly().specificityGroups()) {
            for (OpcodeMaskGroup<Template_Type> opcodeMaskGroup : specificityGroup.opcodeMaskGroups()) {
                final int opcode = instruction & opcodeMaskGroup.mask();
                for (Template_Type template : opcodeMaskGroup.templatesFor(opcode)) {
                    // Skip synthetic instructions when preference is for raw instructions,
                    // and skip instructions with a different number of arguments than requested if so (i.e. when running the AssemblyTester):
                    if (template != null && template.isDisassemblable() && ((abstractionPreference() == AbstractionPreference.SYNTHETIC) || !template.instructionDescription().isSynthetic())) {
                        final Sequence<Argument> arguments = disassemble(instruction, template);
                        if (arguments != null && (expectedNumberOfArguments() < 0 || arguments.length() == expectedNumberOfArguments())) {
                            if (isLegalArgumentList(template, arguments)) {
                                final Assembler assembler = createAssembler(_currentOffset);
                                try {
                                    assembly().assemble(assembler, template, arguments);
                                    final byte[] bytes = assembler.toByteArray();
                                    if (Arrays.equals(bytes, instructionBytes)) {
                                        final DisassembledInstruction_Type disassembledInstruction = createDisassembledInstruction(_currentOffset, bytes, template, arguments);
                                        result.append(disassembledInstruction);
                                    }
                                } catch (AssemblyException assemblyException) {
                                    ProgramWarning.message("could not assemble matching instruction: " + template);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            throw new AssemblyException("instruction could not be disassembled: " + HexUtil.toHexLiteral(endianness().toBytes(instruction)));
        }
        _currentOffset += 4;
        return result;
    }

    @Override
    public Sequence<DisassembledInstruction_Type> scan(BufferedInputStream stream) throws IOException, AssemblyException {
        final AppendableSequence<DisassembledInstruction_Type> result = new ArrayListSequence<DisassembledInstruction_Type>();
        try {
            while (true) {
                final Sequence<DisassembledInstruction_Type> disassembledInstructions = scanOneInstruction(stream);
                boolean foundSyntheticDisassembledInstruction = false;
                if (abstractionPreference() == AbstractionPreference.SYNTHETIC) {
                    for (DisassembledInstruction_Type disassembledInstruction : disassembledInstructions) {
                        if (disassembledInstruction.template().instructionDescription().isSynthetic()) {
                            result.append(disassembledInstruction);
                            foundSyntheticDisassembledInstruction = true;
                            break;
                        }
                    }
                }
                if (!foundSyntheticDisassembledInstruction) {
                    result.append(disassembledInstructions.first());
                }
            }
        } catch (IOException ioException) {
            return result;
        }
    }

}
