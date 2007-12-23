/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.sparc;

import jasm.gen.risc.field.RiscField;
import static jasm.gen.risc.sparc.SPARCFields.bits_13_13;
import static jasm.gen.risc.sparc.SPARCFields.bits_18_18;
import static jasm.gen.risc.sparc.SPARCFields.cond_17_14;
import static jasm.gen.risc.sparc.SPARCFields.dfrd;
import static jasm.gen.risc.sparc.SPARCFields.dfrs2;
import static jasm.gen.risc.sparc.SPARCFields.fmovTypeBit;
import static jasm.gen.risc.sparc.SPARCFields.fmovfcc;
import static jasm.gen.risc.sparc.SPARCFields.fmovicc;
import static jasm.gen.risc.sparc.SPARCFields.i;
import static jasm.gen.risc.sparc.SPARCFields.movTypeBit;
import static jasm.gen.risc.sparc.SPARCFields.movfcc;
import static jasm.gen.risc.sparc.SPARCFields.movicc;
import static jasm.gen.risc.sparc.SPARCFields.op;
import static jasm.gen.risc.sparc.SPARCFields.op3;
import static jasm.gen.risc.sparc.SPARCFields.opfLow_10_5;
import static jasm.gen.risc.sparc.SPARCFields.opfLow_9_5;
import static jasm.gen.risc.sparc.SPARCFields.qfrd;
import static jasm.gen.risc.sparc.SPARCFields.qfrs2;
import static jasm.gen.risc.sparc.SPARCFields.rcond_12_10;
import static jasm.gen.risc.sparc.SPARCFields.rd;
import static jasm.gen.risc.sparc.SPARCFields.res_10_5;
import static jasm.gen.risc.sparc.SPARCFields.res_9_5;
import static jasm.gen.risc.sparc.SPARCFields.rs1;
import static jasm.gen.risc.sparc.SPARCFields.rs2;
import static jasm.gen.risc.sparc.SPARCFields.sfrd;
import static jasm.gen.risc.sparc.SPARCFields.sfrs2;
import static jasm.gen.risc.sparc.SPARCFields.simm10;
import static jasm.gen.risc.sparc.SPARCFields.simm11;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
final class ConditionalMove extends SPARCInstructionDescriptionCreator {

    private void addIccOrFcc(String suffix, RiscField fmovccField, RiscField movccField, int typeBitContents, int condContents) {
        // A.33
        final Object[] fmovHead = {op(0x2), op3(0x35), bits_18_18(0), cond_17_14(condContents), fmovTypeBit(typeBitContents), fmovccField};
        setCurrentArchitectureManualSection("A.33");
        define("fmovs" + suffix, fmovHead, opfLow_10_5(0x1), sfrs2, sfrd);
        define("fmovd" + suffix, fmovHead, opfLow_10_5(0x2), dfrs2, dfrd);
        define("fmovq" + suffix, fmovHead, opfLow_10_5(0x3), qfrs2, qfrd);
        // A.35
        final Object[] movHead = {op(0x2), op3(0x2c), movTypeBit(typeBitContents), cond_17_14(condContents), movccField};
        setCurrentArchitectureManualSection("A.35");
        define("mov" + suffix, movHead, i(1), simm11, rd);
        define("mov" + suffix, movHead, i(0), res_10_5, rs2, rd);
    }

    private void addMovr(String suffix, int rcondContents) {
        // A.34
        final Object[] fmovrHead = {op(0x2), op3(0x35), bits_13_13(0), rcond_12_10(rcondContents)};
        setCurrentArchitectureManualSection("A.34");
        define("fmovrs" + suffix, fmovrHead, opfLow_9_5(0x5), rs1, sfrs2, sfrd);
        define("fmovrd" + suffix, fmovrHead, opfLow_9_5(0x6), rs1, dfrs2, dfrd);
        define("fmovrq" + suffix, fmovrHead, opfLow_9_5(0x7), rs1, qfrs2, qfrd);
        // A.36
        final Object[] movrHead = {op(0x2), op3(0x2f), rcond_12_10(rcondContents)};
        setCurrentArchitectureManualSection("A.36");
        define("movr" + suffix, movrHead, i(0), res_9_5, rs1, rs2, rd);
        // sparc asm is too lenient with simm10
        define("movr" + suffix, movrHead, i(1), rs1, simm10, rd);
    }

    private void addIcc(String suffix, int condContents) {
        addIccOrFcc(suffix, fmovicc, movicc, 1, condContents);
    }

    private void addFcc(String suffix, int condContents) {
        addIccOrFcc(suffix, fmovfcc, movfcc, 0, condContents);
    }

    private void create_A33_A35() {
        addIcc("a", 0x8);
        addIcc("n", 0x0);
        addIcc("ne", 0x9);
        addIcc("e", 0x1);
        addIcc("g", 0xa);
        addIcc("le", 0x2);
        addIcc("ge", 0xb);
        addIcc("l", 0x3);
        addIcc("gu", 0xc);
        addIcc("leu", 0x4);
        addIcc("cc", 0xd);
        addIcc("cs", 0x5);
        addIcc("pos", 0xe);
        addIcc("neg", 0x6);
        addIcc("vc", 0xf);
        addIcc("vs", 0x7);

        addFcc("a", 0x8);
        addFcc("n", 0x0);
        addFcc("u", 0x7);
        addFcc("g", 0x6);
        addFcc("ug", 0x5);
        addFcc("l", 0x4);
        addFcc("ul", 0x3);
        addFcc("lg", 0x2);
        addFcc("ne", 0x1);
        addFcc("e", 0x9);
        addFcc("ue", 0xa);
        addFcc("ge", 0xb);
        addFcc("uge", 0xc);
        addFcc("le", 0xd);
        addFcc("ule", 0xe);
        addFcc("o", 0xf);
    }

    private void create_A34_A36() {
        addMovr("e", 0x1);
        addMovr("lez", 0x2);
        addMovr("lz", 0x3);
        addMovr("ne", 0x5);
        addMovr("gz", 0x6);
        addMovr("gez", 0x7);
    }

    ConditionalMove(SPARCTemplateCreator templateCreator) {
        super(templateCreator);

        create_A34_A36();
        create_A33_A35();
    }

}
