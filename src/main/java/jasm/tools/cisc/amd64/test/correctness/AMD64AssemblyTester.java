/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.amd64.test.correctness;

import jasm.Argument;
import jasm.Assembler;
import jasm.WordWidth;
import jasm.amd64.AMD64GeneralRegister8;
import jasm.amd64.AMD64XMMRegister;
import jasm.amd64.as.AMD64Assembler;
import jasm.amd64.dis.AMD64DisassembledInstruction;
import jasm.amd64.dis.AMD64Disassembler;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.cisc.amd64.AMD64Assembly;
import jasm.tools.cisc.amd64.AMD64Template;
import jasm.tools.cisc.x86.test.correctness.X86AssemblyTester;
import jasm.x86.GeneralRegister;
import java.util.EnumSet;
import java.util.List;

public final class AMD64AssemblyTester extends X86AssemblyTester<AMD64Template, AMD64DisassembledInstruction> {

  public AMD64AssemblyTester(EnumSet<AssemblyTestComponent> components) {
    super(AMD64Assembly.ASSEMBLY, WordWidth.BITS_64, components);
  }

  @Override
  protected final String assemblerCommand() {
    return "as -64";
  }

  @Override
  protected final Assembler createTestAssembler() {
    return new AMD64Assembler(0L);
  }

  @Override
  protected final AMD64Disassembler createTestDisassembler() {
    return new AMD64Disassembler(0L);
  }

  @Override
  protected final boolean isLegalArgumentList(AMD64Template template, List<Argument> arguments) {
    final WordWidth externalCodeSizeAttribute = template.externalCodeSizeAttribute();
    for (Argument argument : arguments) {
      if (argument instanceof AMD64GeneralRegister8) {
        final AMD64GeneralRegister8 generalRegister8 = (AMD64GeneralRegister8) argument;
        if (generalRegister8.isHighByte()) {
          if (template.hasRexPrefix(arguments)) {
            return false;
          }
        } else
        if (generalRegister8.value() >= 4 && externalCodeSizeAttribute != null && externalCodeSizeAttribute.lessThan(
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
