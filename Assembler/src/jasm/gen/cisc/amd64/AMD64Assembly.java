/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.amd64;

import com.sun.max.collect.Sequence;
import jasm.InstructionSet;
import jasm.gen.cisc.x86.FloatingPointOpcodeMap;
import jasm.gen.cisc.x86.X86Assembly;

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
