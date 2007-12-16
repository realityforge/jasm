/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=eb623de7-8787-431f-91ef-6537aba7c191*/
package com.sun.max.asm.gen.cisc.ia32;

import com.sun.max.asm.*;
import com.sun.max.asm.gen.cisc.x86.*;
import com.sun.max.collect.*;

/**
 * @author Bernd Mathiske
 */
public final class IA32Assembly extends X86Assembly<IA32Template> {

    private IA32Assembly() {
        super(InstructionSet.IA32, IA32Template.class);
    }
    
    @Override
    protected Sequence<IA32Template> createTemplates() {
        final IA32TemplateCreator creator = new IA32TemplateCreator();    
        creator.createTemplates(new OneByteOpcodeMap());
        creator.createTemplates(new TwoByteOpcodeMap());
        creator.createTemplates(new FloatingPointOpcodeMap(this));
        return creator.templates();
    }

    public static final IA32Assembly ASSEMBLY = new IA32Assembly();
    
}
