/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d7fb6f79-6e9c-4ba9-85b7-a1830917f79c*/
package com.sun.max.asm.gen.cisc.ia32;

import com.sun.max.asm.Argument;
import com.sun.max.asm.Assembler;
import com.sun.max.asm.dis.ia32.IA32DisassembledInstruction;
import com.sun.max.asm.dis.ia32.IA32Disassembler;
import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.gen.cisc.x86.X86AssemblyTester;
import com.sun.max.asm.ia32.IA32Assembler;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.WordWidth;
import java.util.EnumSet;

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
    protected boolean isLegalArgumentList(IA32Template template, Sequence<Argument> arguments) {
        return true;
    }
}
