/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=af58e9d8-0ed6-493b-a45b-6cb554be8952*/
package com.sun.max.asm.dis.ppc;

import com.sun.max.asm.*;
import com.sun.max.asm.dis.*;
import com.sun.max.asm.dis.risc.*;
import com.sun.max.asm.gen.risc.ppc.*;
import com.sun.max.collect.*;

/**
 * @author Bernd Mathiske
 */
public abstract class PPCDisassembledInstruction extends RiscDisassembledInstruction<PPCTemplate> {

    PPCDisassembledInstruction(int offset, byte[] bytes, PPCTemplate template, Sequence<Argument> arguments) {
        super(offset, bytes, template, arguments);
    }
    
    @Override
    public String externalName() {
        final PPCExternalInstruction instruction = new PPCExternalInstruction(template(), arguments(), startOffset(), null, null);
        return instruction.name();
    }

    @Override
    public String operandsToString(Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
        final PPCExternalInstruction instruction = new PPCExternalInstruction(template(), arguments(), startOffset(), labels, globalLabelMapper);
        return instruction.operands();
    }

    @Override
    public String toString(Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
        final PPCExternalInstruction instruction = new PPCExternalInstruction(template(), arguments(), startOffset(), labels, globalLabelMapper);
        return instruction.toString();
    }

}
