/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc;

import static jasm.tools.risc.sparc.SPARCFields.i;
import static jasm.tools.risc.sparc.SPARCFields.op;
import static jasm.tools.risc.sparc.SPARCFields.op3;
import static jasm.tools.risc.sparc.SPARCFields.rd;
import static jasm.tools.risc.sparc.SPARCFields.rd_state;
import static jasm.tools.risc.sparc.SPARCFields.res_12_0;
import static jasm.tools.risc.sparc.SPARCFields.res_12_5;
import static jasm.tools.risc.sparc.SPARCFields.rs1;
import static jasm.tools.risc.sparc.SPARCFields.rs1_state;
import static jasm.tools.risc.sparc.SPARCFields.rs2;
import static jasm.tools.risc.sparc.SPARCFields.simm13;

public final class StateRegisterAccess extends SPARCInstructionDescriptionCreator {

  private void create_A43() {
    define("rd", op(0x2), op3(0x28), rs1_state, i(0), res_12_0, rd);
  }

  private void create_A62() {
    define("wr", op(0x2), op3(0x30), rs1, i(0), res_12_5, rs2, rd_state);
    define("wr", op(0x2), op3(0x30), rs1, i(1), simm13, rd_state);
  }

  StateRegisterAccess(SPARCTemplateCreator templateCreator) {
    super(templateCreator);

    setCurrentArchitectureManualSection("A.43");
    create_A43();

    setCurrentArchitectureManualSection("A.62");
    create_A62();
  }
}
