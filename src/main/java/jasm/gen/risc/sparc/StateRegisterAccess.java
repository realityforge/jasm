/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.sparc;

import static jasm.gen.risc.sparc.SPARCFields._rd;
import static jasm.gen.risc.sparc.SPARCFields._rd_state;
import static jasm.gen.risc.sparc.SPARCFields._res_12_0;
import static jasm.gen.risc.sparc.SPARCFields._res_12_5;
import static jasm.gen.risc.sparc.SPARCFields._rs1;
import static jasm.gen.risc.sparc.SPARCFields._rs1_state;
import static jasm.gen.risc.sparc.SPARCFields._rs2;
import static jasm.gen.risc.sparc.SPARCFields._simm13;
import static jasm.gen.risc.sparc.SPARCFields.i;
import static jasm.gen.risc.sparc.SPARCFields.op;
import static jasm.gen.risc.sparc.SPARCFields.op3;

/**
 * @author Bernd Mathiske
 */
public final class StateRegisterAccess extends SPARCInstructionDescriptionCreator {

    private void create_A43() {
        define("rd", op(0x2), op3(0x28), _rs1_state, i(0), _res_12_0, _rd);
    }

    private void create_A62() {
        define("wr", op(0x2), op3(0x30), _rs1, i(0), _res_12_5, _rs2, _rd_state);
        define("wr", op(0x2), op3(0x30), _rs1, i(1), _simm13, _rd_state);
    }

    StateRegisterAccess(SPARCTemplateCreator templateCreator) {
        super(templateCreator);

        setCurrentArchitectureManualSection("A.43");
        create_A43();

        setCurrentArchitectureManualSection("A.62");
        create_A62();
    }
}
