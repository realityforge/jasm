/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=87129a92-c920-4545-97b5-5fc6df345bb0*/
package com.sun.max.asm.gen.risc.ppc;

import com.sun.max.asm.Assembler;
import com.sun.max.asm.dis.ppc.PPC32DisassembledInstruction;
import com.sun.max.asm.dis.ppc.PPC32Disassembler;
import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.ppc.PPC32Assembler;
import com.sun.max.lang.WordWidth;
import java.util.EnumSet;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class PPC32AssemblyTester extends PPCAssemblyTester<PPC32DisassembledInstruction> {

    public PPC32AssemblyTester(EnumSet<AssemblyTestComponent> components) {
        super(PPCAssembly.ASSEMBLY, WordWidth.BITS_32, components);
    }

    @Override
    protected Assembler createTestAssembler() {
        return new PPC32Assembler(0);
    }

    @Override
    protected PPC32Disassembler createTestDisassembler() {
        return new PPC32Disassembler(0);
    }

}
