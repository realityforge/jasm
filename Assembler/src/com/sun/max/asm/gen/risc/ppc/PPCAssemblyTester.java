/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=91ecad04-1965-49ce-ba8e-bce4da291b82*/
package com.sun.max.asm.gen.risc.ppc;

import java.io.*;
import java.util.*;

import com.sun.max.asm.*;
import com.sun.max.asm.dis.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.*;
import com.sun.max.collect.*;
import com.sun.max.io.*;
import com.sun.max.lang.*;

/**
 * @author Bernd Mathiske
 */
public abstract class PPCAssemblyTester<DisassembledInstruction_Type extends DisassembledInstruction<PPCTemplate>>
                          extends RiscAssemblyTester<PPCTemplate, DisassembledInstruction_Type> {

    public PPCAssemblyTester(PPCAssembly assembly, WordWidth addressWidth, EnumSet<AssemblyTestComponent> components) {
        super(assembly, addressWidth, components);
    }
    
    @Override
    public PPCAssembly assembly() {
        return (PPCAssembly) super.assembly();
    }
    
    @Override
    protected String assemblerCommand() {
        return "as -force_cpusubtype_ALL";
    }
    
    @Override
    protected void assembleExternally(IndentWriter writer, PPCTemplate template, Sequence<Argument> argumentList, String label) {
        final PPCExternalInstruction instruction = new PPCExternalInstruction(template, argumentList);
        writer.println(instruction.toString());
    }

    @Override
    protected boolean readNop(InputStream stream) throws IOException {
        final int instruction = Endianness.BIG.readInt(stream);
        return instruction == 0x60000000;
    }
     
    @Override
    protected byte[] readExternalInstruction(PushbackInputStream externalInputStream, PPCTemplate template, byte[] internalBytes) throws IOException {
        final byte[] result = super.readExternalInstruction(externalInputStream, template, internalBytes);
        
        // Work-around for bug in Apple's version of the GNU 'as' assembler (see javadoc for 'isExternalMTCRFEncodingBroken' for more details)
        if (assembly().isExternalMTCRFEncodingBroken()) {
            if (template.externalName().equals("mtcrf")) {
                // Force 11th bit to 0
                final int bit11Mask = Integer.parseInt("11101111", 2);
                result[1] &= bit11Mask;
            } else if (template.externalName().equals("mtocrf")) {
                // Force 11th bit to 1
                final int bit11Mask = Integer.parseInt("00010000", 2);
                result[1] |= bit11Mask;
            }
        }
        return result;
    }
}
