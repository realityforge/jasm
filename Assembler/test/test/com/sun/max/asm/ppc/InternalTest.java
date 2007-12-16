/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6f119a9d-8097-4894-87ef-1dd806afc442*/
package test.com.sun.max.asm.ppc;

import static com.sun.max.asm.ppc.GPR.*;
import static com.sun.max.asm.ppc.Zero.*;
import static com.sun.max.asm.ppc.CRF.*;
import static com.sun.max.asm.ppc.BranchPredictionBits.*;


import java.io.*;

import junit.framework.*;

import com.sun.max.asm.*;
import com.sun.max.asm.dis.ppc.*;
import com.sun.max.asm.ppc.*;
import com.sun.max.ide.*;

/**
 * @author Bernd Mathiske
 */
public class InternalTest extends MaxTestCase {
    
    public InternalTest() {        
        super();

    }

    public InternalTest(String name) {        
        super(name);
    }
    
    public static Test suite() {
        final TestSuite suite = new TestSuite(InternalTest.class.getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(InternalTest.class);
        //$JUnit-END$
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(InternalTest.class);
    }

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
