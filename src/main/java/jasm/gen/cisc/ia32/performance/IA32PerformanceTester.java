/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.ia32.performance;

import jasm.dis.Disassembler;
import jasm.gen.test.performance.PerformanceTester;
import jasm.ia32.dis.IA32Disassembler;
import jasm.ia32.as.IA32Assembler;
import static jasm.ia32.IA32GeneralRegister32.EDX;
import static jasm.ia32.IA32GeneralRegister32.EAX;
import static jasm.ia32.IA32GeneralRegister32.EBX;
import static jasm.ia32.IA32GeneralRegister32.EBP;
import static jasm.ia32.IA32GeneralRegister32.EDI;
import static jasm.ia32.IA32GeneralRegister8.BL;
import static jasm.ia32.IA32GeneralRegister8.CL;
import static jasm.ia32.IA32GeneralRegister8.AH;
import static jasm.ia32.IA32GeneralRegister8.BH;
import static jasm.ia32.IA32GeneralRegister8.AL;
import static jasm.ia32.IA32GeneralRegister8.CH;
import static jasm.ia32.IA32GeneralRegister8.DL;
import jasm.Label;
import static jasm.x86.Scale.SCALE_2;
import static jasm.x86.Scale.SCALE_1;
import static jasm.x86.Scale.SCALE_4;

public class IA32PerformanceTester
    extends PerformanceTester {

  public IA32PerformanceTester() {
    super(10);
  }

  protected Disassembler<?, ?> getDisassembler() {
    return new IA32Disassembler(0);
  }

  protected byte[] assemble() throws Exception {
    final IA32Assembler asm = new IA32Assembler(0);
    final Label startLabel = new Label();
    asm.bindLabel(startLabel);
    asm.add(EDX.indirect(), BL);
    asm.add(EAX.base(), EBX.index(), SCALE_2, CL);
    asm.m_add(0x1234AB78, EBP.index(), SCALE_1, AH);
    asm.m_add(0x12345678, BH);
    asm.add((byte) 0x23, EAX.indirect(), AL);
    asm.add((byte) 0x23, EAX.base(), EBX.index(), SCALE_4, CL);
    asm.add(0x87654321, EDI.indirect(), CH);
    asm.add(0x87654321, EAX.base(), EBX.index(), SCALE_1, DL);
    asm.add(CL, DL);
    asm.jmp(startLabel);
    return asm.toByteArray();
  }
}
