/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.amd64;

import jasm.Argument;
import jasm.Assembler;
import jasm.amd64.AMD64Assembler;
import jasm.amd64.AMD64GeneralRegister8;
import jasm.amd64.AMD64XMMRegister;
import jasm.dis.amd64.AMD64DisassembledInstruction;
import jasm.dis.amd64.AMD64Disassembler;
import jasm.gen.AssemblyTestComponent;
import jasm.gen.cisc.x86.X86AssemblyTester;
import jasm.util.WordWidth;
import jasm.util.collect.Sequence;
import jasm.x86.GeneralRegister;
import java.util.EnumSet;

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
                } else if (generalRegister8.value() >= 4 && externalCodeSizeAttribute != null && externalCodeSizeAttribute.lessThan(
                    WordWidth.BITS_64)) {
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
