/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=12f99a3a-4e5f-432a-837b-27f886f6b862*/
package jasm.gen.risc.sparc;

import jasm.Assembler;
import jasm.util.WordWidth;
import jasm.dis.sparc.SPARC64DisassembledInstruction;
import jasm.dis.sparc.SPARC64Disassembler;
import jasm.gen.AssemblyTestComponent;
import jasm.sparc.SPARC64Assembler;
import java.util.EnumSet;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class SPARC64AssemblyTester extends SPARCAssemblyTester<SPARC64DisassembledInstruction> {

    public SPARC64AssemblyTester(EnumSet<AssemblyTestComponent> components) {
        super(SPARCAssembly.ASSEMBLY, WordWidth.BITS_64, components);
    }

    @Override
    protected Assembler createTestAssembler() {
        return new SPARC64Assembler(0L);
    }

    @Override
    protected SPARC64Disassembler createTestDisassembler() {
        return new SPARC64Disassembler(0L);
    }

}
