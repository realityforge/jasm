/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.gen.Assembly;
import jasm.gen.InstructionDescriptionCreator;
import java.util.List;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class X86InstructionDescriptionCreator extends InstructionDescriptionCreator<X86InstructionDescription> {

    public X86InstructionDescriptionCreator(Assembly<? extends X86Template> assembly) {
        super(assembly);
    }

    @Override
    protected X86InstructionDescription createInstructionDescription(List<Object> specifications) {
        return new X86InstructionDescription(specifications);
    }
}
