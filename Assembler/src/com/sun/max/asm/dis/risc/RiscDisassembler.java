/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=46f154df-dad5-4dbb-82d6-ef1e421cbd47*/
package com.sun.max.asm.dis.risc;

import java.io.*;
import java.util.Arrays;

import com.sun.max.asm.*;
import com.sun.max.asm.dis.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.*;
import com.sun.max.asm.gen.risc.field.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;
import com.sun.max.program.*;

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
        final Class<RiscAssembly<Template_Type>> type = null;
        return StaticLoophole.cast(type, super.assembly());
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
            throw new AssemblyException("instruction could not be disassembled: " + Bytes.toHexLiteral(endianness().toBytes(instruction)));
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
