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
import jasm.ppc.as.PPC32Assembler;
import jasm.tools.risc.ppc.PPCAssembly;
import jasm.tools.risc.ppc.PPCTemplate;
import java.util.List;

public final class PPC32Disassembler
    extends PPCDisassembler<PPC32DisassembledInstruction> {

  private final int _startAddress;

  public PPC32Disassembler(int startAddress) {
    super(PPCAssembly.ASSEMBLY, WordWidth.BITS_32);
    _startAddress = startAddress;
  }

  @Override
  protected final PPC32DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, PPCTemplate template, List<Argument> arguments) {
    return new PPC32DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
  }

  @Override
  protected final Assembler createAssembler(int offset) {
    return new PPC32Assembler(_startAddress + offset);
  }
}
