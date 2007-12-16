/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=12f99a3a-4e5f-432a-837b-27f886f6b862*/
package com.sun.max.asm.gen.risc.sparc;

import java.util.*;

import com.sun.max.asm.*;
import com.sun.max.asm.dis.sparc.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.sparc.*;
import com.sun.max.lang.*;

/**
 * 
 *
 * @author Bernd Mathiske
 */
public class SPARC64AssemblyTester extends SPARCAssemblyTester<SPARC64DisassembledInstruction> {

    public SPARC64AssemblyTester(EnumSet<AssemblyTestComponent> components) {
        super(SPARCAssembly.ASSEMBLY, WordWidth.BITS_64, components);
    }

    @Override
    protected Assembler createTestAssembler() {
        return new SPARC64Assembler(0L);
    }
    
    @Override
    protected SPARC64Disassembler createTestDisassembler() {
        return new SPARC64Disassembler(0L);
    }
    
}
