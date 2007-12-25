/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.ppc.correctness;

import jasm.Assembler;
import jasm.WordWidth;
import jasm.gen.AssemblyTestComponent;
import jasm.gen.risc.ppc.PPCAssembly;
import jasm.ppc.as.PPC32Assembler;
import jasm.ppc.dis.PPC32DisassembledInstruction;
import jasm.ppc.dis.PPC32Disassembler;
import java.util.EnumSet;

public final class PPC32AssemblyTester extends PPCAssemblyTester<PPC32DisassembledInstruction> {

    public PPC32AssemblyTester(EnumSet<AssemblyTestComponent> components) {
        super(PPCAssembly.ASSEMBLY, WordWidth.BITS_32, components);
    }

    @Override
    protected final Assembler createTestAssembler() {
        return new PPC32Assembler(0);
    }

    @Override
    protected final PPC32Disassembler createTestDisassembler() {
        return new PPC32Disassembler(0);
    }

}
