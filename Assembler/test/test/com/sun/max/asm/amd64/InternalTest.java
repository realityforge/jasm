/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e1b0785f-ad8d-4368-8de6-52ed6cb6078e*/
package test.com.sun.max.asm.amd64;

import static com.sun.max.asm.amd64.AMD64GeneralRegister32.*;
import static com.sun.max.asm.amd64.AMD64GeneralRegister64.*;
import static com.sun.max.asm.amd64.AMD64GeneralRegister8.*;
import static com.sun.max.asm.amd64.AMD64IndexRegister64.*;
import static com.sun.max.asm.x86.Scale.*;

import java.io.*;

import junit.framework.*;

import com.sun.max.asm.*;
import com.sun.max.asm.amd64.*;
import com.sun.max.asm.dis.amd64.*;
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

    private void disassemble(long startAddress, byte[] bytes) throws IOException, AssemblyException {
        final AMD64Disassembler disassembler = new AMD64Disassembler(startAddress);
        final BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(bytes));
        disassembler.scanAndPrint(stream, System.out);
    }

    private byte[] assemble1(long startAddress) throws IOException, AssemblyException {
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
        asm.fixLabel(fixLabel, startAddress + 4); // choose the right addend according to output to hit an instruction start address
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

    public void test1() throws IOException, AssemblyException {
        System.out.println("--- test1: ---");
        final long startAddress = 0x12345678abcdef00L;
        final byte[] bytes = assemble1(startAddress);
        disassemble(startAddress, bytes);
    }

    private byte[] assemble2(long startAddress) throws IOException, AssemblyException {
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
            
        asm.mov(20, RCX.base(), RDI.index(),
                SCALE_8, RDX);
            
        return asm.toByteArray();
    }

    public void test2() throws IOException, AssemblyException {
        System.out.println("--- test2: ---");
        final long startAddress = 0x12345678L;
        final byte[] bytes = assemble2(startAddress);
        disassemble(startAddress, bytes);
    }
}
