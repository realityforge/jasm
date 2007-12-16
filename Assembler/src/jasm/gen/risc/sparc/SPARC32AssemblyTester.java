/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.risc.sparc;

import jasm.Assembler;
import jasm.dis.sparc.SPARC32DisassembledInstruction;
import jasm.dis.sparc.SPARC32Disassembler;
import jasm.gen.AssemblyTestComponent;
import jasm.sparc.SPARC32Assembler;
import jasm.util.WordWidth;
import java.util.EnumSet;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class SPARC32AssemblyTester extends SPARCAssemblyTester<SPARC32DisassembledInstruction> {

    public SPARC32AssemblyTester(EnumSet<AssemblyTestComponent> components) {
        super(SPARCAssembly.ASSEMBLY, WordWidth.BITS_32, components);
    }

    @Override
    protected Assembler createTestAssembler() {
        return new SPARC32Assembler(0);
    }

    @Override
    protected SPARC32Disassembler createTestDisassembler() {
        return new SPARC32Disassembler(0);
    }

}
