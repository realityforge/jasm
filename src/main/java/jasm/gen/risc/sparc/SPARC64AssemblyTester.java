/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.sparc;

import jasm.Assembler;
import jasm.WordWidth;
import jasm.gen.AssemblyTestComponent;
import jasm.sparc.as.SPARC64Assembler;
import jasm.sparc.dis.SPARC64DisassembledInstruction;
import jasm.sparc.dis.SPARC64Disassembler;
import java.util.EnumSet;

public final class SPARC64AssemblyTester extends SPARCAssemblyTester<SPARC64DisassembledInstruction> {

    public SPARC64AssemblyTester(EnumSet<AssemblyTestComponent> components) {
        super(SPARCAssembly.ASSEMBLY, WordWidth.BITS_64, components);
    }

    @Override
    protected final Assembler createTestAssembler() {
        return new SPARC64Assembler(0L);
    }

    @Override
    protected final SPARC64Disassembler createTestDisassembler() {
        return new SPARC64Disassembler(0L);
    }

}
