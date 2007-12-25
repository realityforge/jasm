/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc;

import static jasm.tools.risc.sparc.SPARCFields.impl_dep;
import static jasm.tools.risc.sparc.SPARCFields.op;
import static jasm.tools.risc.sparc.SPARCFields.op3;

public final class ImplementationDependent extends SPARCInstructionDescriptionCreator {

  private void create_A23() {
    define("impdep1", op(0x2), op3(0x36), impl_dep);
    define("impdep2", op(0x2), op3(0x37), impl_dep);
  }

  ImplementationDependent(SPARCTemplateCreator templateCreator) {
    super(templateCreator);

    setCurrentArchitectureManualSection("A.23");
    create_A23();
  }
}
