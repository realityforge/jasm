/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.ia32;

import jasm.Label;
import static jasm.ia32.IA32GeneralRegister16.*;
import jasm.ia32.IA32GeneralRegister32;
import static jasm.ia32.IA32GeneralRegister32.*;
import static jasm.ia32.IA32GeneralRegister8.*;
import jasm.ia32.as.IA32Assembler;
import jasm.ia32.dis.IA32Disassembler;
import jasm.x86.Scale;
import static jasm.x86.Scale.SCALE_1;
import static jasm.x86.Scale.SCALE_2;
import static jasm.x86.Scale.SCALE_4;
import static jasm.x86.Scale.SCALE_8;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import junit.framework.TestCase;

public final class InternalTest extends TestCase {

  private static String disassemble(int startAddress, byte[] bytes)
      throws Exception {
    final IA32Disassembler disassembler = new IA32Disassembler(startAddress);
    final BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(bytes));
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    disassembler.scanAndPrint(stream, baos);
    return new String(baos.toByteArray());
  }

  public final void test_complex()
      throws Exception {
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
    final String expected =
        "0x00012358   000   L1:   jmp       L4: +291                                 [66 E9 23 01]\n" +
        "0x0001235C   004         jmp       L1: -6                                   [EB FA]\n" +
        "0x0001235E   006         call      L2: +42                                  [66 E8 2A 00]\n" +
        "0x00012362   010         add       [edx], bl                                [00 1A]\n" +
        "0x00012364   012         add       eax[ebx * 2], cl                         [00 0C 58]\n" +
        "0x00012367   015         add       0x1234AB78[ebp], ah                      [00 24 2D 78 AB 34 12]\n" +
        "0x0001236E   022         add       [0x12345678], bh                         [00 3D 78 56 34 12]\n" +
        "0x00012374   028         add       [eax + 35], al                           [00 40 23]\n" +
        "0x00012377   031         add       eax[ebx * 4 + 35], cl                    [00 4C 98 23]\n" +
        "0x0001237B   035         add       [edi - 2023406815], ch                   [00 AF 21 43 65 87]\n" +
        "0x00012381   041         add       eax[ebx - 2023406815], dl                [00 94 18 21 43 65 87]\n" +
        "0x00012388   048         add       cl, dl                                   [00 D1]\n" +
        "0x0001238A   050         add       [esi], edx                               [01 16]\n" +
        "0x0001238C   052   L2:   add       eax[ebx * 8], ecx                        [01 0C D8]\n" +
        "0x0001238F   055         add       0x12345678[edx], eax                     [01 04 15 78 56 34 12]\n" +
        "0x00012396   062         add       [0x12345678], ebp                        [01 2D 78 56 34 12]\n" +
        "0x0001239C   068         add       [eax + 22], ebx                          [01 58 16]\n" +
        "0x0001239F   071         add       eax[ebx * 4 + 32], ecx                   [01 4C 98 20]\n" +
        "0x000123A3   075         add       [edx - 2023406815], eax                  [01 82 21 43 65 87]\n" +
        "0x000123A9   081         add       eax[ebx * 4 - 2023406815], ecx           [01 8C 98 21 43 65 87]\n" +
        "0x000123B0   088         add       eax, eax                                 [01 C0]\n" +
        "0x000123B2   090         jmp       L2: -40                                  [EB D8]\n" +
        "0x000123B4   092         add       [ecx], dx                                [66 01 11]\n" +
        "0x000123B7   095         add       eax[ebx * 2], dx                         [66 01 14 58]\n" +
        "0x000123BB   099         add       0x12345678[edx], ax                      [66 01 04 15 78 56 34 12]\n" +
        "0x000123C3   107         add       [0x12345678], bp                         [66 01 2D 78 56 34 12]\n" +
        "0x000123CA   114         jmp       L3: +49                                  [EB 31]\n" +
        "0x000123CC   116         add       [edx - 2023406815], ax                   [66 01 82 21 43 65 87]\n" +
        "0x000123D3   123         add       eax[ebx * 4 + 32], cx                    [66 01 4C 98 20]\n" +
        "0x000123D8   128         add       [edx - 2023406815], ax                   [66 01 82 21 43 65 87]\n" +
        "0x000123DF   135         add       eax[ebx * 4 - 2023406815], cx            [66 01 8C 98 21 43 65 87]\n" +
        "0x000123E7   143         add       bx, cx                                   [66 01 CB]\n" +
        "0x000123EA   146         add       al, [eax]                                [02 00]\n" +
        "0x000123EC   148         add       bx, eax[ebx * 4]                         [66 03 1C 98]\n" +
        "0x000123F0   152         add       ah, 0x12345678[ebp]                      [02 24 2D 78 56 34 12]\n" +
        "0x000123F7   159         add       dh, [0x12345678]                         [02 35 78 56 34 12]\n" +
        "0x000123FD   165   L3:   add       bl, [eax + 22]                           [02 58 16]\n" +
        "0x00012400   168         add       cl, eax[ebx * 4 + 32]                    [02 4C 98 20]\n" +
        "0x00012404   172         add       al, [edx - 2023406815]                   [02 82 21 43 65 87]\n" +
        "0x0001240A   178         add       al, eax[ebx * 4 - 2023406815]            [02 84 98 21 43 65 87]\n" +
        "0x00012411   185         add       eax, [ecx]                               [03 01]\n" +
        "0x00012413   187         jmp       L3: -24                                  [EB E8]\n" +
        "0x00012415   189         call      L1: -193                                 [66 E8 3F FF]\n" +
        "0x00012419   193         add       ebx, eax[ecx * 2]                        [03 1C 48]\n" +
        "0x0001241C   196         add       esi, 0x12345678[eax]                     [03 34 05 78 56 34 12]\n" +
        "0x00012423   203         add       esp, [0x12345678]                        [03 25 78 56 34 12]\n" +
        "0x00012429   209         add       eax, [eax + 22]                          [03 40 16]\n" +
        "0x0001242C   212         add       ecx, eax[ebx * 4 + 32]                   [03 4C 98 20]\n" +
        "0x00012430   216         add       edx, [edx - 2018819295]                  [03 92 21 43 AB 87]\n" +
        "0x00012436   222         add       ebx, eax[ebx * 4 - 2023406815]           [03 9C 98 21 43 65 87]\n" +
        "0x0001243D   229         add       cx, [ebx]                                [66 03 0B]\n" +
        "0x00012440   232         jmp       +83                                      [EB 53]\n" +
        "0x00012442   234         add       bx, eax[ecx * 2]                         [66 03 1C 48]\n" +
        "0x00012446   238         add       si, 0x12345678[eax]                      [66 03 34 05 78 56 34 12]\n" +
        "0x0001244E   246         add       sp, [0x1234AB78]                         [66 03 25 78 AB 34 12]\n" +
        "0x00012455   253         add       ax, [eax + 22]                           [66 03 40 16]\n" +
        "0x00012459   257         add       cx, eax[ebx * 4 + 32]                    [66 03 4C 98 20]\n" +
        "0x0001245E   262         add       dx, [edx - 2023406815]                   [66 03 92 21 43 65 87]\n" +
        "0x00012465   269         add       bx, eax[ebx - 2018819295]                [66 03 9C 18 21 43 AB 87]\n" +
        "0x0001246D   277         add       al, 0x8                                  [04 08]\n" +
        "0x0001246F   279         addl      eax, 0x12344321                          [05 21 43 34 12]\n" +
        "0x00012474   284         addw      ax, 0x1234                               [66 05 34 12]\n" +
        "0x00012478   288         push      es                                       [06]\n" +
        "0x00012479   289         addl      ecx, 0x7                                 [81 C1 07 00 00 00]\n" +
        "0x0001247F   295   L4:   cmpl      [eax], 0x7                               [83 38 07]\n" +
        "0x00012482   298         subl      ebx[ecx * 2 + 4], 0x5                    [81 6C 4B 04 05 00 00 00]\n" +
        "0x0001248A   306         jmp       L4: -13                                  [EB F3]\n" +
        "0x0001248C   308         call      +305344999                               [E8 E7 31 33 12]\n" +
        "0x00012491   313         jmp       L1: -317                                 [66 E9 C3 FE]\n";

    assertEquals(expected, output);
  }

  public final void test_simple()
      throws Exception {
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

  public final void test_simple_with_jump()
      throws Exception {
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

  public final void test_jmp_with_operand_size_prefix()
      throws Exception {
    final int startAddress = 0x12358;
    final byte[] bytes = new byte[]{(byte) 0x66, (byte) 0xE9, (byte) 0x8B, (byte) 0x00};
    final String output = disassemble(startAddress, bytes);

    final String expected =
        "0x00012358   0       jmp       +139                                     [66 E9 8B 00]\n";
    assertEquals(expected, output);
  }
}
