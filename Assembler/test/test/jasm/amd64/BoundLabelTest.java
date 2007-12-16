/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a192f364-a188-4ec5-a6d8-0958118cb561*/
package test.jasm.amd64;

import com.sun.max.collect.ArraySequence;
import com.sun.max.collect.MutableSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.ide.MaxTestCase;
import jasm.Argument;
import jasm.AssemblyException;
import jasm.Label;
import jasm.amd64.AMD64Assembler;
import static jasm.amd64.AMD64GeneralRegister64.RAX;
import static jasm.amd64.AMD64GeneralRegister64.RBX;
import jasm.dis.amd64.AMD64Disassembler;
import jasm.gen.Parameter;
import jasm.gen.cisc.amd64.AMD64Assembly;
import jasm.gen.cisc.amd64.AMD64Template;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author Bernd Mathiske
 */
public class BoundLabelTest extends MaxTestCase {
    private static final int LABEL_DELTA = 10;

    private int insertInstructions(AMD64Assembler assembler, Label[] labels, int labelIndex) {
        int index = labelIndex;
        for (int i = 0; i < LABEL_DELTA; i++) {
            assembler.bindLabel(labels[index]);
            assembler.nop();
            index++;
        }
        return index;
    }

    private byte[] assemble(long startAddress, int labelDelta) throws IOException, AssemblyException {
        final AMD64Assembler assembler = new AMD64Assembler(startAddress);
        final Sequence<AMD64Template> labelTemplates = AMD64Assembly.ASSEMBLY.getLabelTemplates();
        final Label[] labels = new Label[labelTemplates.length() + LABEL_DELTA];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new Label();
        }
        int labelIndex = 0;
        int bindIndex = 0;
        if (labelDelta < 0) {
            bindIndex = insertInstructions(assembler, labels, 0);
        } else {
            labelIndex = labelDelta;
        }
        for (AMD64Template template : labelTemplates) {
            assembler.bindLabel(labels[bindIndex]);
            final MutableSequence<Argument> arguments = new ArraySequence<Argument>(template.parameters().length());
            for (int parameterIndex = 0; parameterIndex < template.parameters().length(); parameterIndex++) {
                if (parameterIndex == template.labelParameterIndex()) {
                    arguments.set(parameterIndex, labels[labelIndex]);
                } else {
                    final Parameter parameter = template.parameters().get(parameterIndex);
                    final Iterator<? extends Argument> testArguments = parameter.getLegalTestArguments().iterator();
                    Argument argument = testArguments.next();
                    // skip AL, CL, DL, BL:
                    for (int i = 0; i < 4; i++) {
                        if (testArguments.hasNext()) {
                            argument = testArguments.next();
                        }
                    }
                    arguments.set(parameterIndex, argument);
                }
            }
            AMD64Assembly.ASSEMBLY.assemble(assembler, template, arguments);
            bindIndex++;
            labelIndex++;
        }
        if (labelDelta >= 0) {
            insertInstructions(assembler, labels, bindIndex);
        }
        for (int i = 0; i < labels.length; i++) {
            final Label label = labels[i];
            assert label.state() == Label.State.BOUND;
        }
        return assembler.toByteArray();
    }

    private void disassemble(long startAddress, byte[] bytes) throws IOException, AssemblyException {
        final AMD64Disassembler disassembler = new AMD64Disassembler(startAddress);
        final BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(bytes));
        disassembler.scanAndPrint(stream, System.out);
    }

    public void notest_allLabelInstructions() throws IOException, AssemblyException {
        final long startAddress = 0x0L;

        byte[] bytes = assemble(startAddress, 0);
        disassemble(startAddress, bytes);

        bytes = assemble(startAddress, LABEL_DELTA);
        disassemble(startAddress, bytes);

        bytes = assemble(startAddress, -LABEL_DELTA);
        disassemble(startAddress, bytes);
    }

    public void test_effectOfVariableInstructionLengthOnLabel() throws IOException, AssemblyException {
        // Repeat with different assembled sizes of the 'jnz' instruction below:
        for (int n = 4; n < 2000; n += 128) {
            final long startAddress = 0x0L;
            final Label label = new Label();
            final Label target = new Label();
            final AMD64Assembler a = new AMD64Assembler(startAddress);
            a.nop();
            a.jnz(target);
            a.nop();
            a.nop();
            a.nop();
            a.nop();
            a.nop();
            a.nop();
            a.nop();
            a.nop();
            a.bindLabel(label);
            a.call(0);
            for (int i = 0; i < n; i++) {
                a.nop();
            }
            a.xor(RAX, RAX);
            a.bindLabel(target);
            a.xor(RBX, RBX);
            final byte[] bytes = a.toByteArray();
            assertTrue(bytes[label.offset()] == (byte) 0xE8); // is there a call instruction at the label's address?
        }
    }
}