/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0f9b6d89-46d0-412f-ac9d-66e6ef945199*/
package jasm.gen.risc.sparc;

import static jasm.gen.risc.sparc.SPARCFields._imm22;
import static jasm.gen.risc.sparc.SPARCFields._rd;
import static jasm.gen.risc.sparc.SPARCFields._res_11_5;
import static jasm.gen.risc.sparc.SPARCFields._res_11_6;
import static jasm.gen.risc.sparc.SPARCFields._res_12_5;
import static jasm.gen.risc.sparc.SPARCFields._res_18_14;
import static jasm.gen.risc.sparc.SPARCFields._rs1;
import static jasm.gen.risc.sparc.SPARCFields._rs2;
import static jasm.gen.risc.sparc.SPARCFields._shcnt32;
import static jasm.gen.risc.sparc.SPARCFields._shcnt64;
import static jasm.gen.risc.sparc.SPARCFields._simm13;
import static jasm.gen.risc.sparc.SPARCFields.i;
import static jasm.gen.risc.sparc.SPARCFields.op;
import static jasm.gen.risc.sparc.SPARCFields.op2;
import static jasm.gen.risc.sparc.SPARCFields.op3;
import static jasm.gen.risc.sparc.SPARCFields.x;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
class IntegerArithmetic extends SPARCInstructionDescriptionCreator {

    private void createBinaryArithmetic(String name, int op3Contents) {
        define(name, op(0x2), _rs1, i(0), _res_12_5, _rs2, _rd, op3(op3Contents));
        define(name, op(0x2), _rs1, i(1), _simm13, _rd, op3(op3Contents));
    }

    private void create_A2() {
        createBinaryArithmetic("add", 0x0);
        createBinaryArithmetic("addc", 0x8);
        createBinaryArithmetic("addcc", 0x10);
        createBinaryArithmetic("addccc", 0x18);
    }

    private void create_A10() {
        if (assembly().generatingDeprecatedInstructions()) {
            createBinaryArithmetic("udiv", 0xe);
            createBinaryArithmetic("sdiv", 0xf);
            createBinaryArithmetic("udivcc", 0x1e);
            createBinaryArithmetic("sdivcc", 0x1f);
        }
    }

    private void create_A31() {
        createBinaryArithmetic("and", 0x1);
        createBinaryArithmetic("andcc", 0x11);
        createBinaryArithmetic("andn", 0x5);
        createBinaryArithmetic("andncc", 0x15);
        createBinaryArithmetic("or", 0x2);
        createBinaryArithmetic("orcc", 0x12);
        createBinaryArithmetic("orn", 0x6);
        createBinaryArithmetic("orncc", 0x16);
        createBinaryArithmetic("xor", 0x3);
        createBinaryArithmetic("xorcc", 0x13);
        createBinaryArithmetic("xnor", 0x7);

        createBinaryArithmetic("xnorcc", 0x17);
    }

    private void create_A36() {
        if (assembly().generatingV9Instructions()) {
            createBinaryArithmetic("mulx", 0x9);
            createBinaryArithmetic("sdivx", 0x2d);
            createBinaryArithmetic("udivx", 0xd);
        }
    }

    private void create_A38() {
        if (assembly().generatingDeprecatedInstructions()) {
            createBinaryArithmetic("umul", 0xa);
            createBinaryArithmetic("smul", 0xb);
            createBinaryArithmetic("umulcc", 0x1a);
            createBinaryArithmetic("smulcc", 0x1b);
        }
    }

    private void create_A39() {
        if (assembly().generatingDeprecatedInstructions()) {
            createBinaryArithmetic("mulscc", 0x24);
        }
    }

    private void create_A41() {
        define("popc", op(0x2), _res_18_14, i(0), _res_12_5, _rs2, _rd, op3(0x2e));
        define("popc", op(0x2), _res_18_14, i(1), _simm13, _rd, op3(0x2e));
    }

    private void create_A48() {
        define("sethi", op(0x0), op2(0x4), _imm22, _rd);
    }

    private void createShift(String name, int op3Contents) {
        final Object[] head = {op(0x2), _rs1, op3(op3Contents)};
        define(name, head, i(0), x(0), _res_11_5, _rs2, _rd);
        define(name + "x", head, i(0), x(1), _res_11_5, _rs2, _rd);
        define(name, head, i(1), x(0), _res_11_5, _shcnt32, _rd);
        define(name + "x", head, i(1), x(1), _res_11_6, _shcnt64, _rd);
    }

    private void create_A49() {
        createShift("sll", 0x25);
        createShift("srl", 0x26);
        createShift("sra", 0x27);
    }

    private void create_A56() {
        createBinaryArithmetic("sub", 0x4);
        createBinaryArithmetic("subcc", 0x14);
        createBinaryArithmetic("subc", 0xc);
        createBinaryArithmetic("subccc", 0x1c);
    }

    private void create_A59() {
        createBinaryArithmetic("taddcc", 0x20);
        if (assembly().generatingDeprecatedInstructions()) {
            createBinaryArithmetic("taddcctv", 0x22);
        }
    }

    private void create_A60() {
        createBinaryArithmetic("tsubcc", 0x21);
        if (assembly().generatingDeprecatedInstructions()) {
            createBinaryArithmetic("tsubcctv", 0x23);
        }
    }

    IntegerArithmetic(SPARCTemplateCreator templateCreator) {
        super(templateCreator);

        setCurrentArchitectureManualSection("A.2");
        create_A2();

        setCurrentArchitectureManualSection("A.10");
        create_A10();

        setCurrentArchitectureManualSection("A.31");
        create_A31();

        setCurrentArchitectureManualSection("A.36");
        create_A36();

        setCurrentArchitectureManualSection("A.38");
        create_A38();

        setCurrentArchitectureManualSection("A.39");
        create_A39();

        setCurrentArchitectureManualSection("A.41");
        create_A41();

        setCurrentArchitectureManualSection("A.48");
        create_A48();

        setCurrentArchitectureManualSection("A.49");
        create_A49();

        setCurrentArchitectureManualSection("A.56");
        create_A56();

        setCurrentArchitectureManualSection("A.59");
        create_A59();

        setCurrentArchitectureManualSection("A.60");
        create_A60();
    }
}