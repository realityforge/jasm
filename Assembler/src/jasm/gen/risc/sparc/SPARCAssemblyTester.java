/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e89be4a7-dcd9-4af2-b606-d8a6b9e4c684*/
package jasm.gen.risc.sparc;

import com.sun.max.collect.Sequence;
import com.sun.max.io.IndentWriter;
import com.sun.max.lang.Endianness;
import com.sun.max.program.ProgramError;
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
public abstract class SPARCAssemblyTester<DisassembledInstruction_Type extends DisassembledInstruction<SPARCTemplate>>
                          extends RiscAssemblyTester<SPARCTemplate, DisassembledInstruction_Type> {

    public SPARCAssemblyTester(SPARCAssembly assembly, WordWidth addressWidth, EnumSet<AssemblyTestComponent> components) {
        super(assembly, addressWidth, components);
    }

    @Override
    public SPARCAssembly assembly() {
        return (SPARCAssembly) super.assembly();
    }

    @Override
    protected String assemblerCommand() {
        return "as -xarch=v9a";
    }

    private SPARCTemplate _lastTemplate;

    @Override
    protected void assembleExternally(IndentWriter writer, SPARCTemplate template, Sequence<Argument> argumentList, String label) {

        // This is a workaround for SPARC V9 ABI compliance checks: http://developers.sun.com/solaris/articles/sparcv9abi.html
        if (_lastTemplate == null || template != _lastTemplate) {
            writer.println(".register %g2,#scratch");
            writer.println(".register %g3,#scratch");
            writer.println(".register %g6,#scratch");
            writer.println(".register %g7,#scratch");
            _lastTemplate = template;
        }
        final SPARCExternalInstruction instruction = new SPARCExternalInstruction(template, argumentList);
        writer.println(instruction.toString());
        writer.println("nop"); // fill potential DCTI slot with something - see below
    }

    @Override
    protected boolean readNop(InputStream stream) throws IOException {
        final int instruction = Endianness.BIG.readInt(stream);
        return instruction == 0x01000000;
    }

    @Override
    protected byte[] readExternalInstruction(PushbackInputStream externalInputStream, SPARCTemplate template, byte[] internalBytes) throws IOException {
        final byte[] result = super.readExternalInstruction(externalInputStream, template, internalBytes);
        if (!readNop(externalInputStream)) { // read potential DCTI slot place holder contents - see above
            ProgramError.unexpected("nop missing after external instruction");
        }
        return result;
    }
}
