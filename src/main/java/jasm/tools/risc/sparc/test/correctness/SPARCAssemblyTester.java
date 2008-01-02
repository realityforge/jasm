/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc.test.correctness;

import jasm.Argument;
import jasm.WordWidth;
import jasm.dis.risc.RiscDisassembledInstruction;
import jasm.sparc.dis.SPARCDisassembler;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.risc.RiscAssemblyTester;
import jasm.tools.risc.sparc.SPARCAssembly;
import jasm.tools.risc.sparc.SPARCExternalInstruction;
import jasm.tools.risc.sparc.SPARCTemplate;
import jasm.tools.util.IndentWriter;
import jasm.util.EndianUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.EnumSet;
import java.util.List;

public abstract class SPARCAssemblyTester<DisassembledInstruction_Type extends RiscDisassembledInstruction<SPARCTemplate>>
    extends RiscAssemblyTester<SPARCTemplate, DisassembledInstruction_Type, SPARCDisassembler<DisassembledInstruction_Type>> {

  public SPARCAssemblyTester(SPARCAssembly assembly, WordWidth addressWidth, EnumSet<AssemblyTestComponent> components) {
    super(assembly, addressWidth, components);
  }

  @Override
  public final SPARCAssembly assembly() {
    return (SPARCAssembly) super.assembly();
  }

  @Override
  protected final String assemblerCommand() {
    return "as -xarch=v9a";
  }

  private SPARCTemplate _lastTemplate;

  @Override
  protected final void assembleExternally(IndentWriter writer, SPARCTemplate template, List<Argument> argumentList, String label) {

    // This is a workaround for SPARC V9 ABI compliance checks: http://developers.sun.com/solaris/articles/sparcv9abi.html
    if (_lastTemplate == null || template != _lastTemplate) {
      writer.println(".register %g2,#scratch");
      writer.println(".register %g3,#scratch");
      writer.println(".register %g6,#scratch");
      writer.println(".register %g7,#scratch");
      _lastTemplate = template;
    }
    final SPARCExternalInstruction instruction = new SPARCExternalInstruction(template, argumentList);
    writer.println(instruction.toString());
    writer.println("nop"); // fill potential DCTI slot with something - see below
  }

  @Override
  protected final boolean readNop(InputStream stream) throws IOException {
    final int instruction = EndianUtil.readBEInt(stream);
    return instruction == 0x01000000;
  }

  @Override
  protected final byte[] readExternalInstruction(PushbackInputStream externalInputStream, SPARCTemplate template, byte[] internalBytes) throws IOException {
    final byte[] result = super.readExternalInstruction(externalInputStream, template, internalBytes);
    if (!readNop(externalInputStream)) { // read potential DCTI slot place holder contents - see above
      throw new IllegalStateException("nop missing after external instruction");
    }
    return result;
  }
}
