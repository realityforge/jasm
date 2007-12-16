/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0ee4e870-505f-476d-8e8d-bc29d0a4f914*/
package jasm.gen.risc.sparc;

import jasm.Assembler;
import jasm.util.WordWidth;
import jasm.dis.sparc.SPARC32DisassembledInstruction;
import jasm.dis.sparc.SPARC32Disassembler;
import jasm.gen.AssemblyTestComponent;
import jasm.sparc.SPARC32Assembler;
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
