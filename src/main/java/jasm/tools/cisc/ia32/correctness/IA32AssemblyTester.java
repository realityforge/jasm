/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.ia32.correctness;

import jasm.Argument;
import jasm.Assembler;
import jasm.WordWidth;
import jasm.ia32.as.IA32Assembler;
import jasm.ia32.dis.IA32DisassembledInstruction;
import jasm.ia32.dis.IA32Disassembler;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.cisc.ia32.IA32Assembly;
import jasm.tools.cisc.ia32.IA32Template;
import jasm.tools.cisc.x86.correctness.X86AssemblyTester;
import java.util.EnumSet;
import java.util.List;

public final class IA32AssemblyTester
    extends X86AssemblyTester<IA32Template, IA32DisassembledInstruction> {

  public IA32AssemblyTester(EnumSet<AssemblyTestComponent> components) {
    super(IA32Assembly.ASSEMBLY, WordWidth.BITS_32, components);
  }

  @Override
  protected final String assemblerCommand() {
    return "as -32";
  }

  @Override
  protected final Assembler createTestAssembler() {
    return new IA32Assembler(0);
  }

  @Override
  protected final IA32Disassembler createTestDisassembler() {
    return new IA32Disassembler(0);
  }

  @Override
  protected final boolean isLegalArgumentList(IA32Template template, List<Argument> arguments) {
    return true;
  }
}
