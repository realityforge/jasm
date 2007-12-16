/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8e2d1eca-ccb0-4736-af94-639e121892e0*/
package jasm.dis.sparc;

import jasm.Argument;
import jasm.dis.DisassembledLabel;
import jasm.dis.GlobalLabelMapper;
import jasm.dis.risc.RiscDisassembledInstruction;
import jasm.gen.risc.sparc.SPARCExternalInstruction;
import jasm.gen.risc.sparc.SPARCTemplate;
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
