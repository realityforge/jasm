/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.risc;

import jasm.Argument;
import jasm.Assembler;
import jasm.AssemblyException;
import jasm.WordWidth;
import jasm.dis.DisassembledInstruction;
import jasm.dis.Disassembler;
import jasm.tools.Assembly;
import jasm.tools.InstructionConstraint;
import jasm.tools.risc.RiscAssembly;
import jasm.tools.risc.RiscTemplate;
import jasm.tools.risc.field.OperandField;
import jasm.util.EndianUtil;
import jasm.util.ProgramWarning;
import jasm.util.StaticLoophole;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class RiscDisassembler<Template_Type extends RiscTemplate, DisassembledInstruction_Type extends DisassembledInstruction<Template_Type>>
    extends Disassembler<Template_Type, DisassembledInstruction_Type> {

  protected RiscDisassembler(Assembly<Template_Type> assembly, WordWidth addressWidth) {
    super(assembly, addressWidth);
  }

  @Override
  public final RiscAssembly<Template_Type> assembly() {
    return StaticLoophole.cast(super.assembly());
  }

  private int _currentOffset;

  /**
   * Extract the value for each operand of a template from an encoded instruction whose opcode
   * matches that of the template.
   *
   * @param instruction the encoded instruction
   * @return the decoded arguments for each operand or null if at least one operand has
   *         an invalid value in the encoded instruction
   */
  private List<Argument> disassemble(int instruction, Template_Type template) {
    final ArrayList<Argument> arguments = new ArrayList<Argument>();
    for (OperandField operandField : template.parameters()) {
      final Argument argument = operandField.disassemble(instruction);
      if (argument == null) {
        return null;
      }
      arguments.add(argument);
    }
    return arguments;
  }

  private boolean isLegalArgumentList(Template_Type template, List<Argument> arguments) {
    final List<InstructionConstraint> constraints = template.instructionDescription().constraints();
    for (InstructionConstraint constraint : constraints) {
      if (!(constraint.check(template, arguments))) {
        return false;
      }
    }
    return true;
  }

  public byte[] toBEBytes(int value) {
    int val = value;
    final byte[] bytes = new byte[4];
    bytes[3] = (byte) (val & 0xff);
    val >>= 8;
    bytes[2] = (byte) (val & 0xff);
    val >>= 8;
    bytes[1] = (byte) (val & 0xff);
    val >>= 8;
    bytes[0] = (byte) (val & 0xff);
    return bytes;
  }

  @Override
  public final List<DisassembledInstruction_Type> scanOneInstruction(BufferedInputStream stream) throws IOException, AssemblyException {
    final int instruction = EndianUtil.readBEInt(stream);
    final ArrayList<DisassembledInstruction_Type> result = new ArrayList<DisassembledInstruction_Type>();
    final byte[] instructionBytes = toBEBytes(instruction);
    for (SpecificityGroup<Template_Type> specificityGroup : assembly().specificityGroups()) {
      for (OpcodeMaskGroup<Template_Type> opcodeMaskGroup : specificityGroup.opcodeMaskGroups()) {
        final int opcode = instruction & opcodeMaskGroup.mask();
        for (Template_Type template : opcodeMaskGroup.templatesFor(opcode)) {
          // Skip synthetic instructions when preference is for raw instructions,
          // and skip instructions with a different number of arguments than requested if so (i.e. when running the AssemblyTester):
          if (template != null && template.isDisassemblable() && ((abstractionPreference() == AbstractionPreference.SYNTHETIC) || !template.instructionDescription().isSynthetic())) {
            final List<Argument> arguments = disassemble(instruction, template);
            if (arguments != null && (expectedNumberOfArguments() < 0 || arguments.size() == expectedNumberOfArguments())) {
              if (isLegalArgumentList(template, arguments)) {
                final Assembler assembler = createAssembler(_currentOffset);
                try {
                  assembly().assemble(assembler, template, arguments);
                  final byte[] bytes = assembler.toByteArray();
                  if (Arrays.equals(bytes, instructionBytes)) {
                    final DisassembledInstruction_Type disassembledInstruction = createDisassembledInstruction(_currentOffset, bytes, template, arguments);
                    result.add(disassembledInstruction);
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
      String s = "0x";
      for (byte value : toBEBytes(instruction)) {
        s += String.format("%02X", value);
      }
      throw new AssemblyException("instruction could not be disassembled: " + s);
    }
    _currentOffset += 4;
    return result;
  }

  @Override
  protected final List<DisassembledInstruction_Type> scan(BufferedInputStream stream) throws IOException, AssemblyException {
    final ArrayList<DisassembledInstruction_Type> result = new ArrayList<DisassembledInstruction_Type>();
    try {
      while (true) {
        final List<DisassembledInstruction_Type> disassembledInstructions = scanOneInstruction(stream);
        boolean foundSyntheticDisassembledInstruction = false;
        if (abstractionPreference() == AbstractionPreference.SYNTHETIC) {
          for (DisassembledInstruction_Type disassembledInstruction : disassembledInstructions) {
            if (disassembledInstruction.template().instructionDescription().isSynthetic()) {
              result.add(disassembledInstruction);
              foundSyntheticDisassembledInstruction = true;
              break;
            }
          }
        }
        if (!foundSyntheticDisassembledInstruction) {
          result.add(disassembledInstructions.get(0));
        }
      }
    } catch (IOException ioException) {
      return result;
    }
  }
}
