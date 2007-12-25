/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.amd64;

import jasm.Label;
import static jasm.amd64.AMD64GeneralRegister32.EBX;
import static jasm.amd64.AMD64GeneralRegister32.ECX;
import static jasm.amd64.AMD64GeneralRegister64.RAX;
import static jasm.amd64.AMD64GeneralRegister64.RBP;
import static jasm.amd64.AMD64GeneralRegister64.RBX;
import static jasm.amd64.AMD64GeneralRegister64.RCX;
import static jasm.amd64.AMD64GeneralRegister64.RDX;
import static jasm.amd64.AMD64GeneralRegister8.AH;
import static jasm.amd64.AMD64GeneralRegister8.BH;
import static jasm.amd64.AMD64GeneralRegister8.BL;
import static jasm.amd64.AMD64GeneralRegister8.CL;
import static jasm.amd64.AMD64GeneralRegister8.DL;
import static jasm.amd64.AMD64IndexRegister64.RBX_INDEX;
import jasm.amd64.as.AMD64Assembler;
import jasm.amd64.dis.AMD64Disassembler;
import jasm.dis.Disassembler;
import jasm.gen.perf.PerformanceTester;
import static jasm.x86.Scale.SCALE_1;
import static jasm.x86.Scale.SCALE_2;

public class AMD64PerformanceTester
    extends PerformanceTester {

  public AMD64PerformanceTester() {
    super(21);
  }

  protected Disassembler<?, ?> getDisassembler() {
    return new AMD64Disassembler(0);
  }

  protected byte[] assemble() throws Exception {
    final AMD64Assembler asm = new AMD64Assembler(0);
    final Label startLabel = new Label();
    final Label endLabel = new Label();
    final Label label1 = new Label();
    final Label label2 = new Label();
    final Label label3 = new Label();
    final Label fixLabel = new Label();

    asm.bindLabel(startLabel);
    asm.jmp(label1);
    asm.jmp(startLabel);
    asm.call(fixLabel);
    asm.add(RDX.indirect(), BL);
    asm.add(RAX.base(), RBX_INDEX, SCALE_2, CL);
    asm.m_add(0x12345678, RBP.index(), SCALE_1, AH);
    asm.rip_add(label1, BH);
    asm.rip_add(EBX, label1);
    asm.add(CL, DL);
    asm.fixLabel(fixLabel, 4);
    asm.jmp(fixLabel);
    asm.jmp(label3);
    asm.bindLabel(label3);
    asm.jmp(label3);
    asm.call(startLabel);
    asm.jmp(endLabel);
    asm.addl(ECX, 7);
    asm.bindLabel(label1);
    asm.cmpl(RAX.indirect(), (byte) 7);
    asm.subl((byte) 4, RBX.base(), RCX.index(), SCALE_2, 5);
    asm.jmp(label1);
    asm.fixLabel(label2, 0x12345678);
    asm.call(label2);
    asm.jmp(startLabel);
    asm.bindLabel(endLabel);
    return asm.toByteArray();
  }
}
