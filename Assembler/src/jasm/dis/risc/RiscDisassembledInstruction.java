/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.dis.risc;

import com.sun.max.collect.Sequence;
import jasm.Argument;
import jasm.dis.DisassembledInstruction;
import jasm.gen.risc.RiscTemplate;

/**
 *
 *
 * @author Bernd Mathiske
 * @author Greg Wright
 */
public abstract class RiscDisassembledInstruction<Template_Type extends RiscTemplate> extends DisassembledInstruction<Template_Type> {

    protected RiscDisassembledInstruction(int offset, byte[] bytes, Template_Type template, Sequence<Argument> arguments) {
        super(offset, bytes, template, arguments);
    }

    @Override
    public int offsetForRelativeAddressing() {
        return startOffset();
    }
}
