/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=58d4749f-add6-4717-ad12-0111ebae0805*/
package jasm.gen.risc.sparc;

import jasm.Argument;
import jasm.dis.DisassembledLabel;
import jasm.dis.GlobalLabelMapper;
import jasm.gen.risc.RiscExternalInstruction;
import com.sun.max.collect.Sequence;

/**
 * Output of SPARC instructions in external assembler format.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class SPARCExternalInstruction extends RiscExternalInstruction {

    SPARCExternalInstruction(SPARCTemplate template, Sequence<Argument> arguments) {
        super(template, arguments);
    }

    public SPARCExternalInstruction(SPARCTemplate template, Sequence<Argument> arguments, int offset, Sequence<DisassembledLabel> labels) {
        super(template, arguments, offset, labels);
    }

    public SPARCExternalInstruction(SPARCTemplate template, Sequence<Argument> arguments, int offset, Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
        super(template, arguments, offset, labels, globalLabelMapper);
    }

    @Override
    public boolean isAbsoluteBranch() {
        // There are no branch instructions in SPARC whose target address is not PC relative
        return false;
    }
}
