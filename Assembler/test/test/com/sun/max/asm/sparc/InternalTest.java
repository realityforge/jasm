/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4507a0da-6869-4c82-8c16-b10a29e34f74*/
package test.com.sun.max.asm.sparc;

import com.sun.max.asm.AssemblyException;
import com.sun.max.asm.Label;
import com.sun.max.asm.dis.sparc.SPARC32Disassembler;
import com.sun.max.asm.dis.sparc.SPARC64Disassembler;
import com.sun.max.asm.dis.sparc.SPARCDisassembler;
import static com.sun.max.asm.sparc.AnnulBit.A;
import static com.sun.max.asm.sparc.BranchPredictionBit.PT;
import static com.sun.max.asm.sparc.GPR.G0;
import static com.sun.max.asm.sparc.GPR.G1;
import static com.sun.max.asm.sparc.GPR.G4;
import static com.sun.max.asm.sparc.GPR.G5;
import static com.sun.max.asm.sparc.GPR.G7;
import static com.sun.max.asm.sparc.GPR.I0;
import static com.sun.max.asm.sparc.GPR.I1;
import static com.sun.max.asm.sparc.GPR.L0;
import static com.sun.max.asm.sparc.GPR.O2;
import static com.sun.max.asm.sparc.ICCOperand.ICC;
import static com.sun.max.asm.sparc.MembarOperand.LOAD_LOAD;
import static com.sun.max.asm.sparc.MembarOperand.LOAD_STORE;
import static com.sun.max.asm.sparc.MembarOperand.NO_MEMBAR;
import com.sun.max.asm.sparc.SPARC32Assembler;
import com.sun.max.asm.sparc.SPARC64Assembler;
import com.sun.max.asm.sparc.SPARCAssembler;
import com.sun.max.asm.sparc.StateRegister;
import com.sun.max.ide.MaxTestCase;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Bernd Mathiske
 */
public class InternalTest extends MaxTestCase {
    private byte[] assemble(SPARCAssembler asm) throws IOException, AssemblyException {
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
        }

        asm.membar(LOAD_LOAD.or(LOAD_STORE));
        asm.membar(NO_MEMBAR.or(LOAD_STORE));

        return asm.toByteArray();
    }

    private void disassemble(SPARCDisassembler disassembler, byte[] bytes) throws IOException, AssemblyException {
        final BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(bytes));
        disassembler.scanAndPrint(stream, System.out);
    }

    public void test32() throws IOException, AssemblyException {
        final int startAddress = 0x12340000;
        final SPARC32Assembler assembler = new SPARC32Assembler(startAddress);
        final SPARC32Disassembler disassembler = new SPARC32Disassembler(startAddress);
        final byte[] bytes = assemble(assembler);
        disassemble(disassembler, bytes);
        System.out.println();
    }

    public void test64() throws IOException, AssemblyException {
        final long startAddress = 0x1234567812340000L;
        final SPARC64Assembler assembler = new SPARC64Assembler(startAddress);
        final SPARC64Disassembler disassembler = new SPARC64Disassembler(startAddress);
        final byte[] bytes = assemble(assembler);
        disassemble(disassembler, bytes);
        System.out.println();
    }
}
