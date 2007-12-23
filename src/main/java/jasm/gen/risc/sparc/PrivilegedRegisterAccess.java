/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.sparc;

import static jasm.gen.risc.sparc.SPARCFields.i;
import static jasm.gen.risc.sparc.SPARCFields.op;
import static jasm.gen.risc.sparc.SPARCFields.op3;
import static jasm.gen.risc.sparc.SPARCFields.rd;
import static jasm.gen.risc.sparc.SPARCFields.rdPrivReg;
import static jasm.gen.risc.sparc.SPARCFields.res_12_5;
import static jasm.gen.risc.sparc.SPARCFields.res_13_0;
import static jasm.gen.risc.sparc.SPARCFields.rs1;
import static jasm.gen.risc.sparc.SPARCFields.rs1PrivReg;
import static jasm.gen.risc.sparc.SPARCFields.rs2;
import static jasm.gen.risc.sparc.SPARCFields.simm13;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public final class PrivilegedRegisterAccess extends SPARCInstructionDescriptionCreator {

    private void create_A42() {
        define("rdpr", op(0x2), op3(0x2a), res_13_0, rs1PrivReg, rd);
    }

    private void create_A61() {
        final Object[] head = {op(0x2), op3(0x32), rs1};
        define("wrpr", head, i(0), res_12_5, rs2, rdPrivReg);
        define("wrpr", head, i(1), simm13, rdPrivReg);
    }

    PrivilegedRegisterAccess(SPARCTemplateCreator templateCreator) {
        super(templateCreator);

        setCurrentArchitectureManualSection("A.42");
        create_A42();

        setCurrentArchitectureManualSection("A.61");
        create_A61();
    }
}
