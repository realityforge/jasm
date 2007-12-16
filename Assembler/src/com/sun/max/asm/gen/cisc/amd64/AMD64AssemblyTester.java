/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=68197fc6-00c2-49e6-b142-aefda19175a1*/
package com.sun.max.asm.gen.cisc.amd64;

import java.util.*;

import com.sun.max.asm.*;
import com.sun.max.asm.amd64.*;
import com.sun.max.asm.dis.amd64.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.cisc.x86.*;
import com.sun.max.asm.x86.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;

/**
 * @author Bernd Mathiske
 */
public class AMD64AssemblyTester extends X86AssemblyTester<AMD64Template, AMD64DisassembledInstruction> {

    public AMD64AssemblyTester(EnumSet<AssemblyTestComponent> components) {
        super(AMD64Assembly.ASSEMBLY, WordWidth.BITS_64, components);
    }

    @Override
    protected String assemblerCommand() {
        return "as -64";
    }

    @Override
    protected Assembler createTestAssembler() {
        return new AMD64Assembler(0L);
    }
    
    @Override
    protected AMD64Disassembler createTestDisassembler() {
        return new AMD64Disassembler(0L);
    }
    
    @Override
    protected boolean isLegalArgumentList(AMD64Template template, Sequence<Argument> arguments) {
        final WordWidth externalCodeSizeAttribute = template.externalCodeSizeAttribute();
        for (Argument argument : arguments) {
            if (argument instanceof AMD64GeneralRegister8) {
                final AMD64GeneralRegister8 generalRegister8 = (AMD64GeneralRegister8) argument;
                if (generalRegister8.isHighByte()) {
                    if (template.hasRexPrefix(arguments)) {
                        return false;
                    }
                } else if (generalRegister8.value() >= 4 && externalCodeSizeAttribute != null && externalCodeSizeAttribute.lessThan(WordWidth.BITS_64)) {
                    return false;
                }
            } else if (externalCodeSizeAttribute != null && externalCodeSizeAttribute.lessThan(WordWidth.BITS_64)) {
                // exclude cases that gas does not support (but that otherwise seem plausible):
                if (argument instanceof GeneralRegister) {
                    final GeneralRegister generalRegister = (GeneralRegister) argument;
                    if ((generalRegister.value() >= 8) || (generalRegister.width() == WordWidth.BITS_64)) {
                        return false;
                    } 
                } else if (argument instanceof AMD64XMMRegister) {
                    final AMD64XMMRegister xmmRegister = (AMD64XMMRegister) argument;
                    if (xmmRegister.value() >= 8) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
