/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e7cccc10-c50f-4c42-bc16-c1b67e57261b*/
package test.com.sun.max.asm.ppc;

import static com.sun.max.asm.ppc.BranchPredictionBits.*;
import static com.sun.max.asm.ppc.CRF.*;
import static com.sun.max.asm.ppc.GPR.*;

import java.io.*;

import junit.framework.*;

import com.sun.max.asm.*;
import com.sun.max.asm.ppc.*;
import com.sun.max.ide.*;

/**
 * @author Bernd Mathiske
 */
public class SpeedTest extends MaxTestCase {
    
    public SpeedTest() {        
        super();

    }

    public SpeedTest(String name) {        
        super(name);
    }
    
    public static Test suite() {
        final TestSuite suite = new TestSuite(SpeedTest.class.getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(SpeedTest.class);
        //$JUnit-END$
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(SpeedTest.class);
    }

    public byte[] produce()  throws IOException, AssemblyException {
        final int startAddress = 0x0000ecf0;
        final PPC32Assembler asm = new PPC32Assembler(startAddress);
        final Label label1 = new Label();
        
        asm.mflr(R0);
        asm.stwu(SP, -96, SP);
        asm.stmw(R23, 60, SP);
        asm.stw(R0, 100, SP);
        asm.mr(R23, R3);
        asm.mr(R31, R23);
        asm.cmplwi(R31, 2);
        asm.blt(CR0, label1, NONE);
        asm.addic(R30, R31, -1);
        asm.addic(R29, R31, -2);
        asm.mr(R3, R30);
        asm.mr(R3, R30);
        asm.lis(R24, 0);
        asm.ori(R24, R24, 60656);
        asm.mtctr(R24);
        asm.bctrl();
        asm.mr(R30, R3);
        asm.mr(R3, R29);
        asm.lis(R24, 0);
        asm.ori(R24, R24, 60656);
        asm.mtctr(R24);
        asm.bctrl();
        asm.mr(R29, R3);
        asm.addic(R30, R30, 1);
        asm.add(R3, R30, R29);
        asm.lwz(R0, 100, SP);
        asm.mtlr(R0);
        asm.lmw(R23, 60, SP);
        asm.addi(SP, SP, 96);
        asm.blr();
        asm.bindLabel(label1);
        asm.li(R3, 1);
        asm.lwz(R0, 100, SP);
        asm.mtlr(R0);
        asm.lmw(R23, 60, SP);
        asm.addi(SP, SP, 96);
        asm.blr();
        return asm.toByteArray();        
    }
    
    public void test_speed() throws IOException, AssemblyException {
        System.out.println("start");
        for (int i = 0; i < 10000000; i++) {
            produce();
        }
        System.out.println("done.");
        //final PPC32Disassembler disassembler = new PPC32Disassembler(startAddress);
        //disassemble(disassembler, bytes);
    }
}
