/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc;

import jasm.InstructionSet;
import jasm.tools.risc.RiscAssembly;
import java.util.List;

public final class SPARCAssembly extends RiscAssembly<SPARCTemplate> {

    private static final boolean GENERATING_DEPRECATED_INSTRUCTIONS = true;
    private static final boolean GENERATING_V9_INSTRUCTIONS = true;

    private SPARCAssembly() {
        super(InstructionSet.SPARC, SPARCTemplate.class);
    }

    public boolean generatingDeprecatedInstructions() {
        return GENERATING_DEPRECATED_INSTRUCTIONS;
    }

    public boolean generatingV9Instructions() {
        return GENERATING_V9_INSTRUCTIONS;
    }

  @Override
    protected List<SPARCTemplate> createTemplates() {
        final SPARCTemplateCreator creator = new SPARCTemplateCreator();
        creator.createTemplates(new MemoryAccess(creator));
        creator.createTemplates(new MemorySynchronization(creator));
        creator.createTemplates(new IntegerArithmetic(creator));
        creator.createTemplates(new ControlTransfer(creator));
        creator.createTemplates(new ConditionalMove(creator));
        creator.createTemplates(new RegisterWindowManagement(creator));
        creator.createTemplates(new StateRegisterAccess(creator));
        creator.createTemplates(new PrivilegedRegisterAccess(creator));
        creator.createTemplates(new FloatingPointOperate(creator));
        creator.createTemplates(new ImplementationDependent(creator));
        creator.createTemplates(new SyntheticInstructions(creator));
        return creator.templates();
    }

    public static final SPARCAssembly ASSEMBLY = new SPARCAssembly();
}
