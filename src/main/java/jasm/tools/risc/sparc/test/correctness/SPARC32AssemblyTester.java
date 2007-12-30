/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc.test.correctness;

import jasm.Assembler;
import jasm.WordWidth;
import jasm.sparc.as.SPARC32Assembler;
import jasm.sparc.dis.SPARC32DisassembledInstruction;
import jasm.sparc.dis.SPARC32Disassembler;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.risc.sparc.SPARCAssembly;
import java.util.EnumSet;

public final class SPARC32AssemblyTester extends SPARCAssemblyTester<SPARC32DisassembledInstruction> {

  public SPARC32AssemblyTester(EnumSet<AssemblyTestComponent> components) {
    super(SPARCAssembly.ASSEMBLY, WordWidth.BITS_32, components);
  }

  @Override
  protected final Assembler createTestAssembler() {
    return new SPARC32Assembler(0);
  }

  @Override
  protected final SPARC32Disassembler createTestDisassembler() {
    return new SPARC32Disassembler(0);
  }

}
