/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc;

import static jasm.tools.risc.sparc.SPARCFields.*;

public final class RegisterWindowManagement extends SPARCInstructionDescriptionCreator {

  private void createSaveOrRestore(String name, int op3Contents) {
    define(name, op(0x2), rs1, op3(op3Contents), i(0), res_12_5, rs2, rd);
    define(name, op(0x2), rs1, op3(op3Contents), i(1), simm13, rd);
  }

  private void create_A21() {
    define("flushw", op(0x2), res_29_25, op3(0x2b), res_18_14, i(0), res_12_0);
  }

  private void create_A45() {
    createSaveOrRestore("save", 0x3c);
    createSaveOrRestore("restore", 0x3d);
  }

  private void create_A46() {
    define("saved", op(0x2), fcnc(0), op3(0x31), res_18_0);
    define("restored", op(0x2), fcnc(1), op3(0x31), res_18_0);
  }

  RegisterWindowManagement(SPARCTemplateCreator templateCreator) {
    super(templateCreator);

    setCurrentArchitectureManualSection("A.21");
    create_A21();

    setCurrentArchitectureManualSection("A.45");
    create_A45();

    setCurrentArchitectureManualSection("A.46");
    create_A46();
  }
}
