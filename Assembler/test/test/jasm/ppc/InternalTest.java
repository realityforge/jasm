/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package test.jasm.ppc;

import com.sun.max.ide.MaxTestCase;
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
import java.io.IOException;

/**
 * @author Bernd Mathiske
 */
public class InternalTest extends MaxTestCase {
    private byte[] assemble(PPCAssembler asm) throws IOException, AssemblyException {
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

    private void disassemble(PPCDisassembler disassembler, byte[] bytes) throws IOException, AssemblyException {
        final BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(bytes));
        disassembler.scanAndPrint(stream, System.out);
    }

    public void test32() throws IOException, AssemblyException {
        final int startAddress = 0x12340000;
        final PPC32Assembler assembler = new PPC32Assembler(startAddress);
        final PPC32Disassembler disassembler = new PPC32Disassembler(startAddress);
        final byte[] bytes = assemble(assembler);
        disassemble(disassembler, bytes);
        System.out.println();
    }

    public void test64() throws IOException, AssemblyException {
        final long startAddress = 0x1234567812340000L;
        final PPC64Assembler assembler = new PPC64Assembler(startAddress);
        final PPC64Disassembler disassembler = new PPC64Disassembler(startAddress);
        final byte[] bytes = assemble(assembler);
        disassemble(disassembler, bytes);
        System.out.println();
    }
}
