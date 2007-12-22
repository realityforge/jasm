/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.ppc;

import jasm.gen.InstructionDescription;
import jasm.gen.risc.RiscTemplateCreator;

/**
 *
 *
 * @author Bernd Mathiske
 */
public final class PPCTemplateCreator extends RiscTemplateCreator<PPCTemplate> {

    PPCTemplateCreator() {
        super();
    }

    @Override
    protected final PPCTemplate createTemplate(InstructionDescription instructionDescription) {
        return new PPCTemplate(instructionDescription);
    }

}
