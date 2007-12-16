/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=666c0c57-19ee-4c3a-9d72-2883d7a01f92*/
package com.sun.max.asm.gen.risc.sparc;

import static com.sun.max.asm.gen.risc.sparc.SPARCFields._rd;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields._rdPrivReg;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields._res_12_5;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields._res_13_0;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields._rs1;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields._rs1PrivReg;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields._rs2;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields._simm13;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields.i;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields.op;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields.op3;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public class PrivilegedRegisterAccess extends SPARCInstructionDescriptionCreator {

    private void create_A42() {
        define("rdpr", op(0x2), op3(0x2a), _res_13_0, _rs1PrivReg, _rd);
    }

    private void create_A61() {
        final Object[] head = {op(0x2), op3(0x32), _rs1};
        define("wrpr", head, i(0), _res_12_5, _rs2, _rdPrivReg);
        define("wrpr", head, i(1), _simm13, _rdPrivReg);
    }

    PrivilegedRegisterAccess(SPARCTemplateCreator templateCreator) {
        super(templateCreator);

        setCurrentArchitectureManualSection("A.42");
        create_A42();

        setCurrentArchitectureManualSection("A.61");
        create_A61();
    }
}
