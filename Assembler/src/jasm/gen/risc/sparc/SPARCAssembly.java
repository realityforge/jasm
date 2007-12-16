/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4141c816-6402-47a8-b6da-c1d3131bb9bb*/
package jasm.gen.risc.sparc;

import com.sun.max.collect.Sequence;
import jasm.InstructionSet;
import jasm.gen.risc.RiscAssembly;
import jasm.gen.risc.bitRange.BitRangeOrder;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
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
    public BitRangeOrder bitRangeEndianness() {
        return BitRangeOrder.DESCENDING;
    }

    @Override
    protected Sequence<SPARCTemplate> createTemplates() {
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
