/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.ppc;

import jasm.AssemblyException;
import jasm.Label;
import jasm.dis.ppc.PPC32Disassembler;
import jasm.dis.ppc.PPC64Disassembler;
import jasm.dis.ppc.PPCDisassembler;
import static jasm.ppc.BranchPredictionBits.PN;
import static jasm.ppc.CRF.CR0;
import static jasm.ppc.GPR.R3;
import static jasm.ppc.GPR.R4;
import static jasm.ppc.GPR.R5;
import static jasm.ppc.GPR.RTOC;
import jasm.ppc.PPC32Assembler;
import jasm.ppc.PPC64Assembler;
import jasm.ppc.PPCAssembler;
import static jasm.ppc.Zero.ZERO;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import junit.framework.TestCase;

/**
 * @author Bernd Mathiske
 */
public class InternalTest extends TestCase {
  private byte[] assemble(PPCAssembler asm) throws AssemblyException {
    final Label loop1 = new Label();
    final Label loop2 = new Label();

    // Example code from B.3 [Book 2] for list insertion
    asm.lwz(RTOC, 0, R3);      // get next pointer
    asm.bindLabel(loop1);
    asm.mr(R5, RTOC);          // keep a copy
    asm.stw(RTOC, 0, R4);      // store in new element
    asm.sync();                // order stw before stwcx. and before lwarx
    asm.bindLabel(loop2);
    asm.lwarx(RTOC, ZERO, R3); // get it again
    asm.cmpw(RTOC, R5);        // loop if changed (someone
    asm.bne(CR0, loop1, PN);   //    else progressed)
    asm.stwcx(R4, ZERO, R3);   // add new element to list
    asm.bne(CR0, loop2, PN);   // loop if failed

    return asm.toByteArray();
  }

  private String disassemble(PPCDisassembler disassembler, byte[] bytes) throws IOException, AssemblyException {
    final BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(bytes));
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    disassembler.scanAndPrint(stream, baos);
    return new String(baos.toByteArray());
  }

  public void test32() throws IOException, AssemblyException {
    final int startAddress = 0x12340000;
    final PPC32Assembler assembler = new PPC32Assembler(startAddress);
    final PPC32Disassembler disassembler = new PPC32Disassembler(startAddress);
    final byte[] bytes = assemble(assembler);
    final String output = disassemble(disassembler, bytes);
    final String expected =
        "0x12340000   00         lwz           r2, 0(r3)                            [80 43 00 00]\n" +
        "0x12340004   04   L1:   mr            r5, r2                               [7C 45 13 78]\n" +
        "0x12340008   08         stw           r2, 0(r4)                            [90 44 00 00]\n" +
        "0x1234000C   12         sync                                               [7C 00 04 AC]\n" +
        "0x12340010   16   L2:   lwarx         r2, 0, r3                            [7C 40 18 28]\n" +
        "0x12340014   20         cmpw          r2, r5                               [7C 02 28 00]\n" +
        "0x12340018   24         bne--         cr0, L1: -20                         [40 C2 FF EC]\n" +
        "0x1234001C   28         stwcx.        r4, 0, r3                            [7C 80 19 2D]\n" +
        "0x12340020   32         bne--         cr0, L2: -16                         [40 C2 FF F0]\n";
    assertEquals(expected, output);
  }

  public void test64() throws IOException, AssemblyException {
    final long startAddress = 0x1234567812340000L;
    final PPC64Assembler assembler = new PPC64Assembler(startAddress);
    final PPC64Disassembler disassembler = new PPC64Disassembler(startAddress);
    final byte[] bytes = assemble(assembler);
    final String output = disassemble(disassembler, bytes);
    final String expected =
        "0x1234567812340000   00         lwz           r2, 0(r3)                            [80 43 00 00]\n" +
        "0x1234567812340004   04   L1:   mr            r5, r2                               [7C 45 13 78]\n" +
        "0x1234567812340008   08         stw           r2, 0(r4)                            [90 44 00 00]\n" +
        "0x123456781234000C   12         sync                                               [7C 00 04 AC]\n" +
        "0x1234567812340010   16   L2:   lwarx         r2, 0, r3                            [7C 40 18 28]\n" +
        "0x1234567812340014   20         cmpw          r2, r5                               [7C 02 28 00]\n" +
        "0x1234567812340018   24         bne--         cr0, L1: -20                         [40 C2 FF EC]\n" +
        "0x123456781234001C   28         stwcx.        r4, 0, r3                            [7C 80 19 2D]\n" +
        "0x1234567812340020   32         bne--         cr0, L2: -16                         [40 C2 FF F0]\n";
    assertEquals(expected, output);
  }
}
