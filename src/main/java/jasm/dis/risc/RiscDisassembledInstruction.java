/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.risc;

import jasm.Argument;
import jasm.dis.DisassembledInstruction;
import jasm.gen.risc.RiscTemplate;
import java.util.List;

/**
 *
 *
 * @author Bernd Mathiske
 * @author Greg Wright
 */
public abstract class RiscDisassembledInstruction<Template_Type extends RiscTemplate> extends DisassembledInstruction<Template_Type> {

    protected RiscDisassembledInstruction(int offset, byte[] bytes, Template_Type template, List<Argument> arguments) {
        super(offset, bytes, template, arguments);
    }

    @Override
    public int offsetForRelativeAddressing() {
        return startOffset();
    }
}
