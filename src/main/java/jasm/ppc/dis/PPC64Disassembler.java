/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ppc.dis;

import jasm.Argument;
import jasm.Assembler;
import jasm.WordWidth;
import jasm.ppc.as.PPC64Assembler;
import jasm.tools.risc.ppc.PPCAssembly;
import jasm.tools.risc.ppc.PPCTemplate;
import java.util.List;

public final class PPC64Disassembler extends PPCDisassembler<PPC64DisassembledInstruction> {

  private final long _startAddress;

  public PPC64Disassembler(long startAddress) {
    super(PPCAssembly.ASSEMBLY, WordWidth.BITS_64);
    _startAddress = startAddress;
  }

  @Override
  protected final PPC64DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, PPCTemplate template, List<Argument> arguments) {
    return new PPC64DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
  }

  @Override
  protected final Assembler createAssembler(int offset) {
    return new PPC64Assembler(_startAddress + offset);
  }
}
