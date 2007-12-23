/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.amd64;

import jasm.AssemblyException;
import jasm.Label;
import static jasm.amd64.AMD64GeneralRegister32.EBX;
import static jasm.amd64.AMD64GeneralRegister32.ECX;
import jasm.amd64.AMD64GeneralRegister64;
import static jasm.amd64.AMD64GeneralRegister64.RAX;
import static jasm.amd64.AMD64GeneralRegister64.RBP;
import static jasm.amd64.AMD64GeneralRegister64.RBX;
import static jasm.amd64.AMD64GeneralRegister64.RCX;
import static jasm.amd64.AMD64GeneralRegister64.RDI;
import static jasm.amd64.AMD64GeneralRegister64.RDX;
import static jasm.amd64.AMD64GeneralRegister64.RSP;
import static jasm.amd64.AMD64GeneralRegister8.AH;
import static jasm.amd64.AMD64GeneralRegister8.BH;
import static jasm.amd64.AMD64GeneralRegister8.BL;
import static jasm.amd64.AMD64GeneralRegister8.CL;
import static jasm.amd64.AMD64GeneralRegister8.DL;
import static jasm.amd64.AMD64IndexRegister64.RBX_INDEX;
import jasm.amd64.as.AMD64Assembler;
import jasm.amd64.dis.AMD64Disassembler;
import static jasm.x86.Scale.SCALE_1;
import static jasm.x86.Scale.SCALE_2;
import static jasm.x86.Scale.SCALE_8;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import junit.framework.TestCase;

/**
 * @author Bernd Mathiske
 */
public final class InternalTest extends TestCase {
  private String disassemble(long startAddress, byte[] bytes) throws IOException, AssemblyException {
    final AMD64Disassembler disassembler = new AMD64Disassembler(startAddress);
    final BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(bytes));
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    disassembler.scanAndPrint(stream, baos);
    return new String(baos.toByteArray());
  }

  private byte[] assemble1(long startAddress) throws Exception {
    final AMD64GeneralRegister64 myGPR = RAX;
    final AMD64Assembler asm = new AMD64Assembler(startAddress);
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
    asm.fixLabel(fixLabel,
                 startAddress + 4); // choose the right addend according to output to hit an instruction start address
    asm.jmp(fixLabel);
    asm.jmp(label3);
    asm.bindLabel(label3);
    asm.jmp(label3);
    asm.call(startLabel);
    asm.jmp(endLabel);
    asm.addl(ECX, 7);
    asm.bindLabel(label1);
    asm.cmpl(myGPR.indirect(), (byte) 7);
    asm.subl((byte) 4, RBX.base(), RCX.index(), SCALE_2, 5);
    asm.jmp(label1);
    asm.fixLabel(label2, startAddress + 0x12345678);
    asm.call(label2);
    asm.jmp(startLabel);
    asm.bindLabel(endLabel);

    return asm.toByteArray();
  }

  public final void test1() throws Exception {
    final long startAddress = 0x12345678abcdef00L;
    final byte[] bytes = assemble1(startAddress);
    final String output = disassemble(startAddress, bytes);
    final String expected =
        "0x12345678ABCDEF00   00   L1:   jmp       L4: +52                                  [EB 34]\n" +
        "0x12345678ABCDEF02   02         jmp       L1: -4                                   [EB FC]\n" +
        "0x12345678ABCDEF04   04   L2:   call      L2: -5                                   [E8 FB FF FF FF]\n" +
        "0x12345678ABCDEF09   09         add       [rdx], bl                                [00 1A]\n" +
        "0x12345678ABCDEF0B   11         add       rax[rbx * 2], cl                         [00 0C 58]\n" +
        "0x12345678ABCDEF0E   14         add       0x12345678[rbp], ah                      [00 24 2D 78 56 34 12]\n" +
        "0x12345678ABCDEF15   21         add       [L4: +27], bh                            [00 3D 1B 00 00 00]\n" +
        "0x12345678ABCDEF1B   27         add       ebx, [L4: +21]                           [03 1D 15 00 00 00]\n" +
        "0x12345678ABCDEF21   33         add       cl, dl                                   [00 D1]\n" +
        "0x12345678ABCDEF23   35         jmp       L2: -33                                  [EB DF]\n" +
        "0x12345678ABCDEF25   37         jmp       L3: +0                                   [EB 00]\n" +
        "0x12345678ABCDEF27   39   L3:   jmp       L3: -2                                   [EB FE]\n" +
        "0x12345678ABCDEF29   41         call      L1: -46                                  [E8 D2 FF FF FF]\n" +
        "0x12345678ABCDEF2E   46         jmp       +26                                      [EB 1A]\n" +
        "0x12345678ABCDEF30   48         addl      ecx, 0x7                                 [81 C1 07 00 00 00]\n" +
        "0x12345678ABCDEF36   54   L4:   cmpl      [rax], 0x7                               [83 38 07]\n" +
        "0x12345678ABCDEF39   57         subl      rbx[rcx * 2 + 4], 0x5                    [81 6C 4B 04 05 00 00 00]\n" +
        "0x12345678ABCDEF41   65         jmp       L4: -13                                  [EB F3]\n" +
        "0x12345678ABCDEF43   67         call      +305419824                               [E8 30 56 34 12]\n" +
        "0x12345678ABCDEF48   72         jmp       L1: -74                                  [EB B6]\n";
    assertEquals(expected, output);
  }

  private byte[] assemble2(long startAddress) throws Exception {
    final AMD64Assembler asm = new AMD64Assembler(startAddress);

    final Label loop = new Label();
    final Label subroutine = new Label();
    asm.fixLabel(subroutine, 0x234L);

    asm.mov(RDX, 12, RSP.indirect());
    asm.bindLabel(loop);
    asm.call(subroutine);
    asm.sub(RDX, RAX);
    asm.cmpq(RDX, 0);
    asm.jnz(loop);

    asm.mov(20, RCX.base(), RDI.index(), SCALE_8, RDX);

    return asm.toByteArray();
  }

  public final void test2() throws Exception {
    final long startAddress = 0x12345678L;
    final byte[] bytes = assemble2(startAddress);
    final String output = disassemble(startAddress, bytes);
    final String expected =
        "0x0000000012345678   00         mov       rdx, [rsp + 12]                          [48 8B 94 24 0C 00 00 00]\n" +
        "0x0000000012345680   08   L1:   call      -305419345                               [E8 AF AB CB ED]\n" +
        "0x0000000012345685   13         sub       rdx, rax                                 [48 29 C2]\n" +
        "0x0000000012345688   16         cmpq      rdx, 0x0                                 [48 81 FA 00 00 00 00]\n" +
        "0x000000001234568F   23         jnz       L1: -17                                  [75 EF]\n" +
        "0x0000000012345691   25         mov       rcx[rdi * 8 + 20], rdx                   [48 89 94 F9 14 00 00 00]\n";
    assertEquals(expected, output);
  }
}
