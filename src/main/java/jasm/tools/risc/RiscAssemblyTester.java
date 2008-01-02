/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc;

import jasm.Argument;
import jasm.WordWidth;
import jasm.dis.risc.RiscDisassembledInstruction;
import jasm.dis.risc.RiscDisassembler;
import jasm.tools.Assembly;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.InstructionConstraint;
import jasm.tools.test.correctness.AssemblyTester;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.EnumSet;
import java.util.List;

public abstract class RiscAssemblyTester<Template_Type extends RiscTemplate<Template_Type>, 
    DisassembledInstruction_Type extends RiscDisassembledInstruction<Template_Type>,
    RiscDisassembler_Type extends RiscDisassembler<Template_Type,DisassembledInstruction_Type>>
    extends AssemblyTester<Template_Type, DisassembledInstruction_Type, RiscDisassembler_Type> {

  public RiscAssemblyTester(Assembly<Template_Type> assembly, WordWidth addressWidth, EnumSet<AssemblyTestComponent> components) {
    super(assembly, addressWidth, components);
  }

  @Override
  protected byte[] readExternalInstruction(PushbackInputStream externalInputStream, Template_Type template, byte[] internalBytes) throws IOException {
    final byte[] result = new byte[4];
    if (externalInputStream.read(result) != 4) {
      throw new IOException("end of file before end of instruction");
    }
    return result;
  }

  @Override
  protected final String disassembleFields(Template_Type template, byte[] assembledInstruction) {
    return new RiscFieldDisassembler<Template_Type>(template, assembledInstruction).toString();
  }

  @Override
  protected final boolean isLegalArgumentList(Template_Type template, List<Argument> arguments) {
    final List<InstructionConstraint> constraints = template.instructionDescription().constraints();
    for (InstructionConstraint constraint : constraints) {
      if (!(constraint.check(template, arguments))) {
        return false;
      }
    }
    return true;
  }

}
