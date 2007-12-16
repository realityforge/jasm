/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=fc9be28f-a1bd-4e4b-b621-85f0eb0ee607*/
package com.sun.max.asm.gen.risc.ppc;

import com.sun.max.asm.Assembler;
import com.sun.max.asm.dis.ppc.PPC64DisassembledInstruction;
import com.sun.max.asm.dis.ppc.PPC64Disassembler;
import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.ppc.PPC64Assembler;
import com.sun.max.lang.WordWidth;
import java.util.EnumSet;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class PPC64AssemblyTester extends PPCAssemblyTester<PPC64DisassembledInstruction> {

    public PPC64AssemblyTester(EnumSet<AssemblyTestComponent> components) {
        super(PPCAssembly.ASSEMBLY, WordWidth.BITS_64, components);
    }

    @Override
    protected Assembler createTestAssembler() {
        return new PPC64Assembler(0L);
    }

    @Override
    protected PPC64Disassembler createTestDisassembler() {
        return new PPC64Disassembler(0L);
    }

}
