/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.ppc;

import jasm.gen.Assembly;
import jasm.gen.risc.RiscInstructionDescription;
import jasm.gen.risc.RiscInstructionDescriptionCreator;
import jasm.gen.risc.RiscInstructionDescriptionModifier;
import jasm.util.collect.Sequence;

/**
 *
 *
 * @author Doug Simon
 */
public abstract class PPCInstructionDescriptionCreator extends RiscInstructionDescriptionCreator {

    protected PPCInstructionDescriptionCreator(PPCTemplateCreator templateCreator) {
        super(PPCAssembly.ASSEMBLY, templateCreator);
    }

    @Override
    public PPCAssembly assembly() {
        final Assembly assembly = super.assembly();
        return (PPCAssembly) assembly;
    }

    protected RiscInstructionDescription define64(Object... specifications) {
        return (assembly().generating64BitInstructions()) ? define(specifications) : null;
    }

    protected RiscInstructionDescription defineP5(Object... specifications) {
        return (assembly().generatingPower5Instructions()) ? define(specifications) : null;
    }

    protected RiscInstructionDescriptionModifier synthesize64(String name, String templateName, Object... patterns) {
      if ((assembly().generating64BitInstructions())) {
        return synthesize(name, templateName, patterns);
      } else {
        final Sequence<RiscInstructionDescription> sequence = Sequence.Static.empty();
        return new RiscInstructionDescriptionModifier(sequence);
      }
    }
}