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
import jasm.dis.ppc.PPC32DisassembledInstruction;
import jasm.dis.ppc.PPC32Disassembler;
import jasm.gen.AssemblyTestComponent;
import jasm.ppc.PPC32Assembler;
import jasm.util.WordWidth;
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