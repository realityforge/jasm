/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d77b5c59-ec27-40c5-a7f9-edbf21609056*/
package com.sun.max.asm.gen.risc;

import java.io.*;
import java.util.*;

import com.sun.max.asm.*;
import com.sun.max.asm.dis.*;
import com.sun.max.asm.gen.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;

/**
 * @author Bernd Mathiske
 */
public abstract class RiscAssemblyTester<Template_Type extends RiscTemplate, DisassembledInstruction_Type extends DisassembledInstruction<Template_Type>>
                          extends AssemblyTester<Template_Type, DisassembledInstruction_Type> {

    public RiscAssemblyTester(Assembly<Template_Type> assembly, WordWidth addressWidth, EnumSet<AssemblyTestComponent> components) {
        super(assembly, addressWidth, components);
    }
    
    @Override
    protected byte[] readExternalInstruction(PushbackInputStream externalInputStream, Template_Type template, byte[] internalBytes) throws IOException {
        final byte[] result = new byte[4];
        if (externalInputStream.read(result) != 4) {
            throw new IOException("end of file before end of instruction");
        }
        return result;
    }

    @Override
    protected String disassembleFields(Template_Type template, byte[] assembledInstruction) {
        return new RiscFieldDisassembler<Template_Type>(template, assembledInstruction).toString();
    }
    
    @Override
    protected boolean isLegalArgumentList(Template_Type template, Sequence<Argument> arguments) {
        final Sequence<InstructionConstraint> constraints = template.instructionDescription().constraints();
        for (InstructionConstraint constraint : constraints) {
            if (!(constraint.check(template, arguments))) {
                return false;
            }
        }
        return true;
    }
    
}
