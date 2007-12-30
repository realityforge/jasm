/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.amd64;

import jasm.Argument;
import jasm.AssemblyException;
import jasm.Label;
import static jasm.amd64.AMD64GeneralRegister64.*;
import jasm.amd64.as.AMD64Assembler;
import jasm.amd64.dis.AMD64Disassembler;
import jasm.dis.DecoderException;
import jasm.tools.Parameter;
import jasm.tools.cisc.amd64.AMD64Assembly;
import jasm.tools.cisc.amd64.AMD64Template;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestCase;

public final class BoundLabelTest extends TestCase {
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

  private byte[] assemble(long startAddress, int labelDelta) throws AssemblyException {
    final AMD64Assembler assembler = new AMD64Assembler(startAddress);
    final List<AMD64Template> labelTemplates = AMD64Assembly.ASSEMBLY.getLabelTemplates();
    final Label[] labels = new Label[labelTemplates.size() + LABEL_DELTA];
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
      final Argument[] arguments = new Argument[template.parameters().size()];
      for (int parameterIndex = 0; parameterIndex < template.parameters().size(); parameterIndex++) {
        if (parameterIndex == template.labelParameterIndex()) {
          arguments[parameterIndex] = labels[labelIndex];
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
          arguments[parameterIndex] = argument;
        }
      }
      AMD64Assembly.ASSEMBLY.assemble(assembler, template, Arrays.asList(arguments));
      bindIndex++;
      labelIndex++;
    }
    if (labelDelta >= 0) {
      insertInstructions(assembler, labels, bindIndex);
    }
    for (final Label label : labels) {
      assert label.state() == Label.State.BOUND;
    }
    return assembler.toByteArray();
  }

  private void disassemble(long startAddress, byte[] bytes) throws IOException, DecoderException {
    final AMD64Disassembler disassembler = new AMD64Disassembler(startAddress);
    final BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(bytes));
    disassembler.scanAndPrint(stream, System.out);
  }

  public final void notest_allLabelInstructions() throws Exception {
    final long startAddress = 0x0L;

    byte[] bytes = assemble(startAddress, 0);
    disassemble(startAddress, bytes);

    bytes = assemble(startAddress, LABEL_DELTA);
    disassemble(startAddress, bytes);

    bytes = assemble(startAddress, -LABEL_DELTA);
    disassemble(startAddress, bytes);
  }

  public final void test_effectOfVariableInstructionLengthOnLabel()
      throws Exception {
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
