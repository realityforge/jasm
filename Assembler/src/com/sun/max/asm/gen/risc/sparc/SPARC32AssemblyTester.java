/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0ee4e870-505f-476d-8e8d-bc29d0a4f914*/
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
