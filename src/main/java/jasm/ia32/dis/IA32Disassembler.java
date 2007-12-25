/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ia32.dis;

import jasm.Argument;
import jasm.Assembler;
import jasm.WordWidth;
import jasm.gen.cisc.ia32.IA32Assembly;
import jasm.gen.cisc.ia32.IA32Template;
import jasm.ia32.as.IA32Assembler;
import jasm.util.HexByte;
import jasm.x86.dis.X86Disassembler;
import jasm.x86.dis.X86InstructionHeader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Instantiate this class to disassemble IA32 instruction streams.
 */
public final class IA32Disassembler extends X86Disassembler<IA32Template, IA32DisassembledInstruction> {

  private final int _startAddress;

  public IA32Disassembler(int startAddress) {
    super(IA32Assembly.ASSEMBLY, WordWidth.BITS_32);
    _startAddress = startAddress;
  }

  @Override
  protected final boolean isRexPrefix(HexByte opcode) {
    return false;
  }

  @Override
  protected final IA32DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, IA32Template template, List<Argument> arguments) {
    return new IA32DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
  }

  @Override
  protected final Assembler createAssembler(int offset) {
    return new IA32Assembler(10, _startAddress + offset);
  }

  private static Map<X86InstructionHeader, LinkedList<IA32Template>> _headerToTemplates =
      X86InstructionHeader.createMapping(IA32Assembly.ASSEMBLY, WordWidth.BITS_32);

  @Override
  protected final Map<X86InstructionHeader, LinkedList<IA32Template>> headerToTemplates() {
    return _headerToTemplates;
  }
}
