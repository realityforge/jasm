/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.ia32;

import jasm.AssemblyException;
import jasm.Label;
import jasm.dis.ia32.IA32Disassembler;
import jasm.ia32.IA32Assembler;
import static jasm.ia32.IA32GeneralRegister16.AX;
import static jasm.ia32.IA32GeneralRegister16.BP;
import static jasm.ia32.IA32GeneralRegister16.BX;
import static jasm.ia32.IA32GeneralRegister16.CX;
import static jasm.ia32.IA32GeneralRegister16.DX;
import static jasm.ia32.IA32GeneralRegister16.SI;
import static jasm.ia32.IA32GeneralRegister16.SP;
import jasm.ia32.IA32GeneralRegister32;
import static jasm.ia32.IA32GeneralRegister32.EAX;
import static jasm.ia32.IA32GeneralRegister32.EBP;
import static jasm.ia32.IA32GeneralRegister32.EBX;
import static jasm.ia32.IA32GeneralRegister32.ECX;
import static jasm.ia32.IA32GeneralRegister32.EDI;
import static jasm.ia32.IA32GeneralRegister32.EDX;
import static jasm.ia32.IA32GeneralRegister32.ESI;
import static jasm.ia32.IA32GeneralRegister32.ESP;
import static jasm.ia32.IA32GeneralRegister8.AH;
import static jasm.ia32.IA32GeneralRegister8.AL;
import static jasm.ia32.IA32GeneralRegister8.BH;
import static jasm.ia32.IA32GeneralRegister8.BL;
import static jasm.ia32.IA32GeneralRegister8.CH;
import static jasm.ia32.IA32GeneralRegister8.CL;
import static jasm.ia32.IA32GeneralRegister8.DH;
import static jasm.ia32.IA32GeneralRegister8.DL;
import jasm.x86.Scale;
import static jasm.x86.Scale.SCALE_1;
import static jasm.x86.Scale.SCALE_2;
import static jasm.x86.Scale.SCALE_4;
import static jasm.x86.Scale.SCALE_8;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import junit.framework.TestCase;

/**
 * @author Bernd Mathiske
 */
public class InternalTest extends TestCase {

  private static String disassemble(int startAddress, byte[] bytes) throws IOException, AssemblyException {
    final IA32Disassembler disassembler = new IA32Disassembler(startAddress);
    final BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(bytes));
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    disassembler.scanAndPrint(stream, baos);
    return new String(baos.toByteArray());
  }

  public void no_work_as_generated_operand_size_prefix_test_complex() throws IOException, AssemblyException {
    final int startAddress = 0x12358;
    final IA32GeneralRegister32 myGPR = EAX;
    final IA32Assembler asm = new IA32Assembler(startAddress);
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
    asm.add(EDX.indirect(), BL);
    asm.add(EAX.base(), EBX.index(), SCALE_2, CL);
    asm.m_add(0x1234AB78, EBP.index(), SCALE_1, AH);
    asm.m_add(0x12345678, BH);
    asm.add((byte) 0x23, EAX.indirect(), AL);
    asm.add((byte) 0x23, EAX.base(), EBX.index(), SCALE_4, CL);
    asm.add(0x87654321, EDI.indirect(), CH);
    asm.add(0x87654321, EAX.base(), EBX.index(), SCALE_1, DL);
    asm.add(CL, DL);
    asm.fixLabel(fixLabel,
                 startAddress + 52); // choose the right addend according to output to hit an instruction start address
    asm.add(ESI.indirect(), EDX);
    asm.add(EAX.base(), EBX.index(), SCALE_8, ECX);
    asm.m_add(0x12345678, EDX.index(), SCALE_1, EAX);
    asm.m_add(0x12345678, EBP);
    asm.add((byte) 0x16, EAX.indirect(), EBX);
    asm.add((byte) 0x20, EAX.base(), EBX.index(), SCALE_4, ECX);
    asm.add(0x87654321, EDX.indirect(), EAX);
    asm.add(0x87654321, EAX.base(), EBX.index(), SCALE_4, ECX);
    asm.add(EAX, EAX);
    asm.jmp(fixLabel);
    asm.add(ECX.indirect(), DX);
    asm.add(EAX.base(), EBX.index(), SCALE_2, DX);
    asm.m_add(0x12345678, EDX.index(), SCALE_1, AX);
    asm.m_add(0x12345678, BP);
    asm.jmp(label3);
    asm.add(0x87654321, EDX.indirect(), AX);
    asm.add((byte) 0x20, EAX.base(), EBX.index(), SCALE_4, CX);
    asm.add(0x87654321, EDX.indirect(), AX);
    asm.add(0x87654321, EAX.base(), EBX.index(), SCALE_4, CX);
    asm.add(BX, CX);
    asm.add(AL, EAX.indirect());
    asm.add(BX, EAX.base(), EBX.index(), SCALE_4);
    asm.m_add(AH, 0x12345678, EBP.index(), SCALE_1);
    asm.m_add(DH, 0x12345678);
    asm.bindLabel(label3);
    asm.add(BL, (byte) 0x16, EAX.indirect());
    asm.add(CL, (byte) 0x20, EAX.base(), EBX.index(), SCALE_4);
    asm.add(AL, 0x87654321, EDX.indirect());
    asm.add(AL, 0x87654321, EAX.base(), EBX.index(), SCALE_4);
    asm.add(EAX, ECX.indirect());
    asm.jmp(label3);
    asm.call(startLabel);
    asm.add(EBX, EAX.base(), ECX.index(), SCALE_2);
    asm.m_add(ESI, 0x12345678, EAX.index(), SCALE_1);
    asm.m_add(ESP, 0x12345678);
    asm.add(EAX, (byte) 0x16, EAX.indirect());
    asm.add(ECX, (byte) 0x20, EAX.base(), EBX.index(), SCALE_4);
    asm.add(EDX, 0x87AB4321, EDX.indirect());
    asm.add(EBX, 0x87654321, EAX.base(), EBX.index(), SCALE_4);
    asm.add(CX, EBX.indirect());
    asm.jmp(endLabel);
    asm.add(BX, EAX.base(), ECX.index(), SCALE_2);
    asm.m_add(SI, 0x12345678, EAX.index(), SCALE_1);
    asm.m_add(SP, 0x1234AB78);
    asm.add(AX, (byte) 0x16, EAX.indirect());
    asm.add(CX, (byte) 0x20, EAX.base(), EBX.index(), SCALE_4);
    asm.add(DX, 0x87654321, EDX.indirect());
    asm.add(BX, 0x87AB4321, EAX.base(), EBX.index(), SCALE_1);
    asm.add_AL((byte) 0x08);
    asm.add_EAX(0x12344321);
    asm.add_AX((short) 0x1234);
    asm.push_ES();
    asm.addl(ECX, 7);
    asm.bindLabel(label1);
    asm.cmpl(myGPR.indirect(), (byte) 7);
    asm.subl((byte) 4, EBX.base(), ECX.index(), Scale.SCALE_2, 5);
    asm.jmp(label1);
    asm.fixLabel(label2, 0x12345678);
    asm.call(label2);
    asm.jmp(startLabel);
    asm.bindLabel(endLabel);
    final byte[] bytes = asm.toByteArray();
    final String output = disassemble(startAddress, bytes);
    final String expected = "X";
    System.out.println(output);
    assertEquals(expected, output);
  }

  public void test_simple() throws IOException, AssemblyException {
    final int address = 0x12358;
    final IA32Assembler asm = new IA32Assembler(address);
    asm.add(EDX.indirect(), BL);
    asm.add(EAX.base(), EBX.index(), SCALE_2, CL);
    asm.m_add(0x1234AB78, EBP.index(), SCALE_1, AH);
    asm.m_add(0x12345678, BH);
    asm.add((byte) 0x23, EAX.indirect(), AL);
    asm.add((byte) 0x23, EAX.base(), EBX.index(), SCALE_4, CL);
    asm.add(0x87654321, EDI.indirect(), CH);
    asm.add(0x87654321, EAX.base(), EBX.index(), SCALE_1, DL);
    asm.add(CL, DL);
    final byte[] bytes = asm.toByteArray();
    final String output = disassemble(address, bytes);
    final String expected =
        "0x00012358   00       add       [edx], bl                                [00 1A]\n" +
        "0x0001235A   02       add       eax[ebx * 2], cl                         [00 0C 58]\n" +
        "0x0001235D   05       add       0x1234AB78[ebp], ah                      [00 24 2D 78 AB 34 12]\n" +
        "0x00012364   12       add       [0x12345678], bh                         [00 3D 78 56 34 12]\n" +
        "0x0001236A   18       add       [eax + 35], al                           [00 40 23]\n" +
        "0x0001236D   21       add       eax[ebx * 4 + 35], cl                    [00 4C 98 23]\n" +
        "0x00012371   25       add       [edi - 2023406815], ch                   [00 AF 21 43 65 87]\n" +
        "0x00012377   31       add       eax[ebx - 2023406815], dl                [00 94 18 21 43 65 87]\n" +
        "0x0001237E   38       add       cl, dl                                   [00 D1]\n";
    assertEquals(expected, output);
  }

  public void test_simple_with_jump() throws IOException, AssemblyException {
    final int address = 0x12358;
    final IA32Assembler asm = new IA32Assembler(address);
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

    final byte[] bytes = asm.toByteArray();
    final String output = disassemble(address, bytes);
    final String expected =
        "0x00012358   00   L1:   add       [edx], bl                                [00 1A]\n" +
        "0x0001235A   02         add       eax[ebx * 2], cl                         [00 0C 58]\n" +
        "0x0001235D   05         add       0x1234AB78[ebp], ah                      [00 24 2D 78 AB 34 12]\n" +
        "0x00012364   12         add       [0x12345678], bh                         [00 3D 78 56 34 12]\n" +
        "0x0001236A   18         add       [eax + 35], al                           [00 40 23]\n" +
        "0x0001236D   21         add       eax[ebx * 4 + 35], cl                    [00 4C 98 23]\n" +
        "0x00012371   25         add       [edi - 2023406815], ch                   [00 AF 21 43 65 87]\n" +
        "0x00012377   31         add       eax[ebx - 2023406815], dl                [00 94 18 21 43 65 87]\n" +
        "0x0001237E   38         add       cl, dl                                   [00 D1]\n" +
        "0x00012380   40         jmp       L1: -42                                  [EB D6]\n";
    assertEquals(expected, output);
  }

  public void failing_test_jmp_with_operand_size_prefix() throws IOException, AssemblyException {
    final int startAddress = 0x12358;
    final byte[] bytes = new byte[]{(byte) 0x66, (byte) 0xE9, (byte) 0x8B, (byte) 0x00};
    final String output = disassemble(startAddress, bytes);
    //operand prefix causes failure - see issue jasm-9
    final String expected =
        "0x00012358   00         jmp       L1: 139                                  [66 E9 8B 00]\n";
    assertEquals(expected, output);
  }
}
