/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.ppc;

import jasm.Assembler;
import jasm.dis.ppc.PPC64DisassembledInstruction;
import jasm.dis.ppc.PPC64Disassembler;
import jasm.gen.AssemblyTestComponent;
import jasm.ppc.PPC64Assembler;
import jasm.WordWidth;
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
