/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=2682a5e7-e2ad-44fc-9f92-6071813d2edb*/
package com.sun.max.asm.gen.cisc.x86;

import com.sun.max.asm.gen.Assembly;
import com.sun.max.asm.gen.InstructionDescriptionCreator;
import com.sun.max.collect.MutableSequence;

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
