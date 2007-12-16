/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=52c19f16-7bb0-42ce-9b3f-f9c61a9e6cf5*/
package com.sun.max.asm.gen.cisc.amd64;

import com.sun.max.asm.InstructionSet;
import com.sun.max.asm.gen.cisc.x86.FloatingPointOpcodeMap;
import com.sun.max.asm.gen.cisc.x86.X86Assembly;
import com.sun.max.collect.Sequence;

/**
 * @author Bernd Mathiske
 */
public final class AMD64Assembly extends X86Assembly<AMD64Template> {

    private AMD64Assembly() {
        super(InstructionSet.AMD64, AMD64Template.class);
    }

    @Override
    protected Sequence<AMD64Template> createTemplates() {
        final AMD64TemplateCreator creator = new AMD64TemplateCreator();
        creator.createTemplates(new OneByteOpcodeMap());
        creator.createTemplates(new TwoByteOpcodeMap());
        creator.createTemplates(new FloatingPointOpcodeMap(this));
        return creator.templates();
    }

    public static final AMD64Assembly ASSEMBLY = new AMD64Assembly();
}
