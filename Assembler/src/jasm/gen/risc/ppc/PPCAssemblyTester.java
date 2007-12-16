/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.ppc;

import com.sun.max.collect.Sequence;
import com.sun.max.io.IndentWriter;
import com.sun.max.lang.Endianness;
import jasm.Argument;
import jasm.dis.DisassembledInstruction;
import jasm.gen.AssemblyTestComponent;
import jasm.gen.risc.RiscAssemblyTester;
import jasm.util.WordWidth;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.EnumSet;

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
