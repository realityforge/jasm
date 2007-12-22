/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.ia32;

import jasm.Argument;
import jasm.Assembler;
import jasm.dis.ia32.IA32DisassembledInstruction;
import jasm.dis.ia32.IA32Disassembler;
import jasm.gen.AssemblyTestComponent;
import jasm.gen.cisc.x86.X86AssemblyTester;
import jasm.ia32.IA32Assembler;
import jasm.util.WordWidth;
import java.util.EnumSet;
import java.util.List;

/**
 * @author Bernd Mathiske
 */
public class IA32AssemblyTester extends X86AssemblyTester<IA32Template, IA32DisassembledInstruction> {

    public IA32AssemblyTester(EnumSet<AssemblyTestComponent> components) {
        super(IA32Assembly.ASSEMBLY, WordWidth.BITS_32, components);
    }

    @Override
    protected String assemblerCommand() {
        return "as -32";
    }

    @Override
    protected Assembler createTestAssembler() {
        return new IA32Assembler(0);
    }

    @Override
    protected IA32Disassembler createTestDisassembler() {
        return new IA32Disassembler(0);
    }

    @Override
    protected boolean isLegalArgumentList(IA32Template template, List<Argument> arguments) {
        return true;
    }
}
