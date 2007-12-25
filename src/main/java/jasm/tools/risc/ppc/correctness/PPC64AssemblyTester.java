/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.ppc.correctness;

import jasm.Assembler;
import jasm.WordWidth;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.risc.ppc.PPCAssembly;
import jasm.ppc.as.PPC64Assembler;
import jasm.ppc.dis.PPC64DisassembledInstruction;
import jasm.ppc.dis.PPC64Disassembler;
import java.util.EnumSet;

public final class PPC64AssemblyTester extends PPCAssemblyTester<PPC64DisassembledInstruction> {

    public PPC64AssemblyTester(EnumSet<AssemblyTestComponent> components) {
        super(PPCAssembly.ASSEMBLY, WordWidth.BITS_64, components);
    }

    @Override
    protected final Assembler createTestAssembler() {
        return new PPC64Assembler(0L);
    }

    @Override
    protected final PPC64Disassembler createTestDisassembler() {
        return new PPC64Disassembler(0L);
    }

}
