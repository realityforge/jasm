/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=58d4749f-add6-4717-ad12-0111ebae0805*/
package com.sun.max.asm.gen.risc.sparc;

import com.sun.max.asm.*;
import com.sun.max.asm.dis.*;
import com.sun.max.asm.gen.risc.*;
import com.sun.max.collect.*;

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
