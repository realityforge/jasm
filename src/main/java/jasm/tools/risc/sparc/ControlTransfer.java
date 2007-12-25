/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc;

import static jasm.tools.risc.sparc.SPARCFields.a;
import static jasm.tools.risc.sparc.SPARCFields.bits_18_14;
import static jasm.tools.risc.sparc.SPARCFields.bits_24_22;
import static jasm.tools.risc.sparc.SPARCFields.bits_28_28;
import static jasm.tools.risc.sparc.SPARCFields.cc;
import static jasm.tools.risc.sparc.SPARCFields.const22;
import static jasm.tools.risc.sparc.SPARCFields.d16;
import static jasm.tools.risc.sparc.SPARCFields.disp19;
import static jasm.tools.risc.sparc.SPARCFields.disp22;
import static jasm.tools.risc.sparc.SPARCFields.disp30;
import static jasm.tools.risc.sparc.SPARCFields.fcc_21_20;
import static jasm.tools.risc.sparc.SPARCFields.fcnc;
import static jasm.tools.risc.sparc.SPARCFields.fcond_28_25;
import static jasm.tools.risc.sparc.SPARCFields.i;
import static jasm.tools.risc.sparc.SPARCFields.icond_28_25;
import static jasm.tools.risc.sparc.SPARCFields.op;
import static jasm.tools.risc.sparc.SPARCFields.op2;
import static jasm.tools.risc.sparc.SPARCFields.op3;
import static jasm.tools.risc.sparc.SPARCFields.p;
import static jasm.tools.risc.sparc.SPARCFields.rcond_27_25;
import static jasm.tools.risc.sparc.SPARCFields.rd;
import static jasm.tools.risc.sparc.SPARCFields.res_10_5;
import static jasm.tools.risc.sparc.SPARCFields.res_10_7;
import static jasm.tools.risc.sparc.SPARCFields.res_12_5;
import static jasm.tools.risc.sparc.SPARCFields.res_18_0;
import static jasm.tools.risc.sparc.SPARCFields.res_29_25;
import static jasm.tools.risc.sparc.SPARCFields.res_29_29;
import static jasm.tools.risc.sparc.SPARCFields.rs1;
import static jasm.tools.risc.sparc.SPARCFields.rs2;
import static jasm.tools.risc.sparc.SPARCFields.simm13;
import static jasm.tools.risc.sparc.SPARCFields.swTrapNumber;
import static jasm.tools.risc.sparc.SPARCFields.tcc;
import static jasm.sparc.AnnulBit.NO_A;
import jasm.sparc.BPr;
import jasm.sparc.Bicc;
import static jasm.sparc.BranchPredictionBit.PT;
import jasm.sparc.FBfcc;

final class ControlTransfer extends SPARCInstructionDescriptionCreator {

    private void createBPr(String prefix, Object... objects) {
        for (BPr condition : BPr.SYMBOLS) {
            define(prefix + condition.name().toLowerCase(), objects, rcond_27_25(condition));
        }
    }

    private void create_A3() {
        createBPr("br", op(0x0), a, p, bits_28_28(0), bits_24_22(0x3), rs1, d16);
        createBPr("br", op(0x0), a(NO_A), p(PT), bits_28_28(0), bits_24_22(0x3), rs1, d16);
        define("br", op(0x0), rcond_27_25, a, p, bits_28_28(0), bits_24_22(0x3), rs1, d16);
    }

    private void createFBfcc(String prefix, Object... objects) {
        for (FBfcc condition : FBfcc.SYMBOLS) {
            define(prefix + condition.name().toLowerCase(), objects, fcond_28_25(condition));
        }
    }

    private void create_A4() {
        if (assembly().generatingDeprecatedInstructions()) {
            createFBfcc("fb", op(0x0), a, bits_24_22(0x6), disp22);
            createFBfcc("fb", op(0x0), a(NO_A), bits_24_22(0x6), disp22);
            define("fb", op(0x0), fcond_28_25, a, bits_24_22(0x6), disp22);
        }
    }

    private void create_A5() {
        if (assembly().generatingV9Instructions()) {
            createFBfcc("fb", op(0x0), a, p, bits_24_22(0x5), fcc_21_20, disp19);
            createFBfcc("fb", op(0x0), a(NO_A), p(PT), bits_24_22(0x5), fcc_21_20, disp19);
            define("fb", op(0x0), fcond_28_25, a, p, bits_24_22(0x5), fcc_21_20, disp19);
        }
    }

    private void createBicc(String prefix, Object... objects) {
        for (Bicc condition : Bicc.SYMBOLS) {
            define(prefix + condition.name().toLowerCase(), objects, icond_28_25(condition));
        }
    }


    private void create_A6() {
        if (assembly().generatingDeprecatedInstructions()) {
            createBicc("b", op(0x0), a, bits_24_22(0x2), disp22);
            createBicc("b", op(0x0), a(NO_A), bits_24_22(0x2), disp22);
            define("b", op(0x0), icond_28_25, a, bits_24_22(0x2), disp22);
        }
    }

    private void create_A7() {
        if (assembly().generatingV9Instructions()) {
            createBicc("b", op(0x0), a, p, bits_24_22(0x1), cc, disp19);
            createBicc("b", op(0x0), a(NO_A), p(PT), bits_24_22(0x1), cc, disp19);
            define("b", op(0x0), icond_28_25, a, p, bits_24_22(0x1), cc, disp19);
        }
    }

    private void create_A8() {
        define("call", op(0x1), disp30);
    }

    private void create_A11() {
        define("done", op(0x2), op3(0x3e), res_18_0, fcnc(0));
        define("retry", op(0x2), op3(0x3e), res_18_0, fcnc(1));
    }

    private void create_A22() {
        define("illtrap", op(0x0), res_29_25, op2(0x0), const22);
    }

    private void create_A24() {
        define("jmpl", op(0x2), op3(0x38), rs1, " + ", i(0), res_12_5, rs2, rd);
        define("jmpl", op(0x2), op3(0x38), rs1, " + ", i(1), simm13, rd);
    }

    private void create_A45() {
        final Object[] head = {op(0x2), res_29_25, op3(0x39), rs1, " + "};

        // should be called "return", but that's a Java keyword
        define("return_", head, i(0), res_12_5, rs2).setExternalName("return");
        define("return_", head, i(1), simm13).setExternalName("return");
    }

    private void create_A50() {
        define("sir", op(0x2), rd(15), op3(0x30), bits_18_14(0), i(1), simm13);
    }

    private void create_A61() {
        final Object[] head = {op(0x2), res_29_29, op3(0x3a), tcc, rs1, " + "};
        createBicc("t", head, i(0), res_10_5, rs2);
        createBicc("t", head, i(1), res_10_7, swTrapNumber);
    }

    ControlTransfer(SPARCTemplateCreator templateCreator) {
        super(templateCreator);

        setCurrentArchitectureManualSection("A.3");
        create_A3();

        setCurrentArchitectureManualSection("A.4");
        create_A4();

        setCurrentArchitectureManualSection("A.5");
        create_A5();

        setCurrentArchitectureManualSection("A.6");
        create_A6();

        setCurrentArchitectureManualSection("A.7");
        create_A7();

        setCurrentArchitectureManualSection("A.8");
        create_A8();

        setCurrentArchitectureManualSection("A.11");
        create_A11();

        setCurrentArchitectureManualSection("A.22");
        create_A22();

        setCurrentArchitectureManualSection("A.24");
        create_A24();

        setCurrentArchitectureManualSection("A.45");
        create_A45();

        setCurrentArchitectureManualSection("A.50");
        create_A50();

        setCurrentArchitectureManualSection("A.61");
        create_A61();

        setCurrentArchitectureManualSection(null);
    }
}
