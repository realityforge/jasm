/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc;

import com.sun.max.collect.Sequence;
import jasm.Argument;
import jasm.dis.DisassembledInstruction;
import jasm.gen.Assembly;
import jasm.gen.AssemblyTestComponent;
import jasm.gen.AssemblyTester;
import jasm.gen.InstructionConstraint;
import jasm.util.WordWidth;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.EnumSet;

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
