/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8e2d1eca-ccb0-4736-af94-639e121892e0*/
package com.sun.max.asm.dis.sparc;

import com.sun.max.asm.Argument;
import com.sun.max.asm.dis.DisassembledLabel;
import com.sun.max.asm.dis.GlobalLabelMapper;
import com.sun.max.asm.dis.risc.RiscDisassembledInstruction;
import com.sun.max.asm.gen.risc.sparc.SPARCExternalInstruction;
import com.sun.max.asm.gen.risc.sparc.SPARCTemplate;
import com.sun.max.collect.Sequence;

/**
 * @author Bernd Mathiske
 */
public abstract class SPARCDisassembledInstruction extends RiscDisassembledInstruction<SPARCTemplate> {

    SPARCDisassembledInstruction(int offset, byte[] bytes, SPARCTemplate template, Sequence<Argument> arguments) {
        super(offset, bytes, template, arguments);
    }

    @Override
    public String externalName() {
        final SPARCExternalInstruction instruction = new SPARCExternalInstruction(template(), arguments(), startOffset(), null, null);
        return instruction.name();
    }

    @Override
    public String operandsToString(Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
        final SPARCExternalInstruction instruction = new SPARCExternalInstruction(template(), arguments(), startOffset(), labels, globalLabelMapper);
        return instruction.operands();
    }

    @Override
    public String toString(Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
        final SPARCExternalInstruction instruction = new SPARCExternalInstruction(template(), arguments(), startOffset(), labels, globalLabelMapper);
        return instruction.toString();
    }

}
