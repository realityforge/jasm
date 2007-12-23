/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.sparc;

import jasm.AssemblyException;
import jasm.Label;
import static jasm.sparc.AnnulBit.A;
import static jasm.sparc.BranchPredictionBit.PT;
import static jasm.sparc.GPR.G0;
import static jasm.sparc.GPR.G1;
import static jasm.sparc.GPR.G4;
import static jasm.sparc.GPR.G5;
import static jasm.sparc.GPR.G7;
import static jasm.sparc.GPR.I0;
import static jasm.sparc.GPR.I1;
import static jasm.sparc.GPR.L0;
import static jasm.sparc.GPR.O2;
import static jasm.sparc.ICCOperand.ICC;
import static jasm.sparc.MembarOperand.LOAD_LOAD;
import static jasm.sparc.MembarOperand.LOAD_STORE;
import static jasm.sparc.MembarOperand.NO_MEMBAR;
import jasm.sparc.StateRegister;
import jasm.sparc.as.SPARC32Assembler;
import jasm.sparc.as.SPARC64Assembler;
import jasm.sparc.as.SPARCAssembler;
import jasm.sparc.dis.SPARC32Disassembler;
import jasm.sparc.dis.SPARC64Disassembler;
import jasm.sparc.dis.SPARCDisassembler;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import junit.framework.TestCase;

public final class InternalTest extends TestCase {
  private byte[] assemble(SPARCAssembler asm) throws AssemblyException {
    asm.rd(StateRegister.PC, G1);

    asm.add(G0, I1, O2);
    asm.sub(G5, 12, G7);
    asm.movvc(ICC, -12, G7);
    asm.sethi(0x1234, G7);

    // Example code from J.6:
    final Label retry = new Label();
    final Label loop = new Label();
    final Label out = new Label();

    asm.bindLabel(retry);
    asm.ldstub(G1, G4, I0);
    asm.tst(I0);
    asm.be(out);
    asm.nop();
    asm.bindLabel(loop);
    asm.ldub(G1, G4, I0);
    asm.tst(I0);
    asm.bne(loop);
    asm.nop();
    asm.ba(retry);
    asm.ba(A, PT, ICC, retry);
    asm.bindLabel(out);
    asm.rd(StateRegister.PC, L0);

    try {
      asm.sethi(0x0fffffff, G1);
      fail();
    } catch (IllegalArgumentException illegalArgumentException) {
      //ignored
    }

    asm.membar(LOAD_LOAD.or(LOAD_STORE));
    asm.membar(NO_MEMBAR.or(LOAD_STORE));

    return asm.toByteArray();
  }

  private String disassemble(SPARCDisassembler disassembler, byte[] bytes) throws IOException, AssemblyException {
    final BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(bytes));
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    disassembler.scanAndPrint(stream, baos);
    return new String(baos.toByteArray());
  }

  public final void test32() throws IOException, AssemblyException {
    final int startAddress = 0x12340000;
    final SPARC32Assembler assembler = new SPARC32Assembler(startAddress);
    final SPARC32Disassembler disassembler = new SPARC32Disassembler(startAddress);
    final byte[] bytes = assemble(assembler);
    final String output = disassemble(disassembler, bytes);
    final String expected =
        "0x12340000   00         rd            %pc, %g1                             [83 41 40 00]\n" +
        "0x12340004   04         add           %g0, %i1, %o2                        [94 00 00 19]\n" +
        "0x12340008   08         sub           %g5, 12, %g7                         [8E 21 60 0C]\n" +
        "0x1234000C   12         movvc         %icc, -12, %g7                       [8F 67 E7 F4]\n" +
        "0x12340010   16         sethi         0x1234, %g7                          [0F 00 12 34]\n" +
        "0x12340014   20   L1:   ldstub        [%g1 + %g4], %i0                     [F0 68 40 04]\n" +
        "0x12340018   24         tst           %i0                                  [80 90 00 18]\n" +
        "0x1234001C   28         be            L3: +32                              [02 80 00 08]\n" +
        "0x12340020   32         nop                                                [01 00 00 00]\n" +
        "0x12340024   36   L2:   ldub          [%g1 + %g4], %i0                     [F0 08 40 04]\n" +
        "0x12340028   40         tst           %i0                                  [80 90 00 18]\n" +
        "0x1234002C   44         bne           L2: -8                               [12 BF FF FE]\n" +
        "0x12340030   48         nop                                                [01 00 00 00]\n" +
        "0x12340034   52         ba            L1: -32                              [10 BF FF F8]\n" +
        "0x12340038   56         ba,a,pt       %icc, L1: -36                        [30 4F FF F7]\n" +
        "0x1234003C   60   L3:   rd            %pc, %l0                             [A1 41 40 00]\n" +
        "0x12340040   64         membar        #LoadLoad | #LoadStore               [81 43 E0 05]\n" +
        "0x12340044   68         membar        #LoadStore                           [81 43 E0 04]\n";
    assertEquals(expected, output);
  }

  public final void test64() throws IOException, AssemblyException {
    final long startAddress = 0x1234567812340000L;
    final SPARC64Assembler assembler = new SPARC64Assembler(startAddress);
    final SPARC64Disassembler disassembler = new SPARC64Disassembler(startAddress);
    final byte[] bytes = assemble(assembler);
    final String output = disassemble(disassembler, bytes);
    final String expected =
        "0x1234567812340000   00         rd            %pc, %g1                             [83 41 40 00]\n" +
        "0x1234567812340004   04         add           %g0, %i1, %o2                        [94 00 00 19]\n" +
        "0x1234567812340008   08         sub           %g5, 12, %g7                         [8E 21 60 0C]\n" +
        "0x123456781234000C   12         movvc         %icc, -12, %g7                       [8F 67 E7 F4]\n" +
        "0x1234567812340010   16         sethi         0x1234, %g7                          [0F 00 12 34]\n" +
        "0x1234567812340014   20   L1:   ldstub        [%g1 + %g4], %i0                     [F0 68 40 04]\n" +
        "0x1234567812340018   24         tst           %i0                                  [80 90 00 18]\n" +
        "0x123456781234001C   28         be            L3: +32                              [02 80 00 08]\n" +
        "0x1234567812340020   32         nop                                                [01 00 00 00]\n" +
        "0x1234567812340024   36   L2:   ldub          [%g1 + %g4], %i0                     [F0 08 40 04]\n" +
        "0x1234567812340028   40         tst           %i0                                  [80 90 00 18]\n" +
        "0x123456781234002C   44         bne           L2: -8                               [12 BF FF FE]\n" +
        "0x1234567812340030   48         nop                                                [01 00 00 00]\n" +
        "0x1234567812340034   52         ba            L1: -32                              [10 BF FF F8]\n" +
        "0x1234567812340038   56         ba,a,pt       %icc, L1: -36                        [30 4F FF F7]\n" +
        "0x123456781234003C   60   L3:   rd            %pc, %l0                             [A1 41 40 00]\n" +
        "0x1234567812340040   64         membar        #LoadLoad | #LoadStore               [81 43 E0 05]\n" +
        "0x1234567812340044   68         membar        #LoadStore                           [81 43 E0 04]\n";
    assertEquals(expected, output);
  }
}
