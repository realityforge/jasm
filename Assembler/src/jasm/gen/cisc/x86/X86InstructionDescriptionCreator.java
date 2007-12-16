/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.x86;

import com.sun.max.collect.MutableSequence;
import jasm.gen.Assembly;
import jasm.gen.InstructionDescriptionCreator;

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
    protected X86InstructionDescription createInstructionDescription(MutableSequence<Object> specifications) {
        return new X86InstructionDescription(specifications);
    }
}
