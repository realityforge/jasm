/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.ia32;

import com.sun.max.collect.Sequence;
import jasm.InstructionSet;
import jasm.gen.cisc.x86.FloatingPointOpcodeMap;
import jasm.gen.cisc.x86.X86Assembly;

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
