/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.ppc;

import jasm.tools.Assembly;
import jasm.tools.risc.RiscInstructionDescription;
import jasm.tools.risc.RiscInstructionDescriptionCreator;
import jasm.tools.risc.RiscInstructionDescriptionModifier;
import java.util.Collections;
import java.util.List;

public abstract class PPCInstructionDescriptionCreator extends RiscInstructionDescriptionCreator {

  protected PPCInstructionDescriptionCreator(PPCTemplateCreator templateCreator) {
    super(PPCAssembly.ASSEMBLY, templateCreator);
  }

  @Override
  public final PPCAssembly assembly() {
    final Assembly assembly = super.assembly();
    return (PPCAssembly) assembly;
  }

  protected final RiscInstructionDescription define64(Object... specifications) {
    return (assembly().generating64BitInstructions()) ? define(specifications) : null;
  }

  protected final RiscInstructionDescription defineP5(Object... specifications) {
    return (assembly().generatingPower5Instructions()) ? define(specifications) : null;
  }

  protected final RiscInstructionDescriptionModifier synthesize64(String name, String templateName, Object... patterns) {
    if ((assembly().generating64BitInstructions())) {
      return synthesize(name, templateName, patterns);
    } else {
      final List<RiscInstructionDescription> sequence = Collections.emptyList();
      return new RiscInstructionDescriptionModifier(sequence);
    }
  }
}
