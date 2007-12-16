/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=2747fe26-161e-45ef-a221-7fd1d1a6fa2f*/
package com.sun.max.asm.gen.risc.ppc;

import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.*;
import com.sun.max.collect.*;

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
        return (assembly().generating64BitInstructions()) ? synthesize(name, templateName, patterns) : new RiscInstructionDescriptionModifier(Sequence.Static.empty(RiscInstructionDescription.class));
    }
}
