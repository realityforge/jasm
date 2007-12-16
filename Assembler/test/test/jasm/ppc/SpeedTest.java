/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e7cccc10-c50f-4c42-bc16-c1b67e57261b*/
package test.jasm.ppc;

import jasm.AssemblyException;
import jasm.Label;
import static jasm.ppc.BranchPredictionBits.NONE;
import static jasm.ppc.CRF.CR0;
import static jasm.ppc.GPR.R0;
import static jasm.ppc.GPR.R23;
import static jasm.ppc.GPR.R24;
import static jasm.ppc.GPR.R29;
import static jasm.ppc.GPR.R3;
import static jasm.ppc.GPR.R30;
import static jasm.ppc.GPR.R31;
import static jasm.ppc.GPR.SP;
import jasm.ppc.PPC32Assembler;
import com.sun.max.ide.MaxTestCase;
import java.io.IOException;

/**
 * @author Bernd Mathiske
 */
public class SpeedTest extends MaxTestCase {
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
