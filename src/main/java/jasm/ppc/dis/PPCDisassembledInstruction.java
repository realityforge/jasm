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
import jasm.dis.DisassembledLabel;
import jasm.dis.GlobalLabelMapper;
import jasm.dis.risc.RiscDisassembledInstruction;
import jasm.tools.risc.ppc.PPCExternalInstruction;
import jasm.tools.risc.ppc.PPCTemplate;
import java.util.List;

public abstract class PPCDisassembledInstruction
    extends RiscDisassembledInstruction<PPCTemplate> {

  PPCDisassembledInstruction(int offset, byte[] bytes, PPCTemplate template, List<Argument> arguments) {
    super(offset, bytes, template, arguments);
  }

  @Override
  public final String externalName() {
    final PPCExternalInstruction instruction = new PPCExternalInstruction(template(), arguments(), startOffset(), null, null);
    return instruction.name();
  }

  @Override
  public final String operandsToString(List<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
    final PPCExternalInstruction instruction = new PPCExternalInstruction(template(), arguments(), startOffset(), labels, globalLabelMapper);
    return instruction.operands();
  }

  @Override
  public final String toString(List<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
    final PPCExternalInstruction instruction = new PPCExternalInstruction(template(), arguments(), startOffset(), labels, globalLabelMapper);
    return instruction.toString();
  }
}
