/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.ppc.test.correctness;

import jasm.Argument;
import jasm.WordWidth;
import jasm.dis.DisassembledInstruction;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.risc.RiscAssemblyTester;
import jasm.tools.risc.ppc.PPCAssembly;
import jasm.tools.risc.ppc.PPCExternalInstruction;
import jasm.tools.risc.ppc.PPCTemplate;
import jasm.tools.util.IndentWriter;
import jasm.util.EndianUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.EnumSet;
import java.util.List;

public abstract class PPCAssemblyTester<DisassembledInstruction_Type extends DisassembledInstruction<PPCTemplate>>
    extends RiscAssemblyTester<PPCTemplate, DisassembledInstruction_Type> {

  public PPCAssemblyTester(PPCAssembly assembly, WordWidth addressWidth, EnumSet<AssemblyTestComponent> components) {
    super(assembly, addressWidth, components);
  }

  @Override
  public final PPCAssembly assembly() {
    return (PPCAssembly) super.assembly();
  }

  @Override
  protected final String assemblerCommand() {
    return "as -force_cpusubtype_ALL";
  }

  @Override
  protected final void assembleExternally(IndentWriter writer, PPCTemplate template, List<Argument> argumentList, String label) {
    final PPCExternalInstruction instruction = new PPCExternalInstruction(template, argumentList);
    writer.println(instruction.toString());
  }

  @Override
  protected final boolean readNop(InputStream stream) throws IOException {
    final int instruction = EndianUtil.readBEInt(stream);
    return instruction == 0x60000000;
  }

  @Override
  protected final byte[] readExternalInstruction(PushbackInputStream externalInputStream, PPCTemplate template, byte[] internalBytes) throws IOException {
    final byte[] result = super.readExternalInstruction(externalInputStream, template, internalBytes);

    // Work-around for bug in Apple's version of the GNU 'as' assembler (see javadoc for 'isExternalMTCRFEncodingBroken' for more details)
    if (assembly().isExternalMTCRFEncodingBroken()) {
      if (template.externalName().equals("mtcrf")) {
        // Force 11th bit to 0
        final int bit11Mask = Integer.parseInt("11101111", 2);
        result[1] &= bit11Mask;
      } else if (template.externalName().equals("mtocrf")) {
        // Force 11th bit to 1
        final int bit11Mask = Integer.parseInt("00010000", 2);
        result[1] |= bit11Mask;
      }
    }
    return result;
  }
}
