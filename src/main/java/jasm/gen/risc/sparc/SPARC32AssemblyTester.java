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
