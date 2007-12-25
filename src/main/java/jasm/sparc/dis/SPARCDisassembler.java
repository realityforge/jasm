/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.sparc.dis;

import jasm.WordWidth;
import jasm.dis.DisassembledInstruction;
import jasm.dis.risc.RiscDisassembler;
import jasm.tools.risc.sparc.SPARCAssembly;
import jasm.tools.risc.sparc.SPARCTemplate;

public abstract class SPARCDisassembler<DisassembledInstruction_Type extends DisassembledInstruction<SPARCTemplate>>
    extends RiscDisassembler<SPARCTemplate, DisassembledInstruction_Type> {

  protected SPARCDisassembler(SPARCAssembly assembly, WordWidth addressWidth) {
    super(assembly, addressWidth);
  }
}
