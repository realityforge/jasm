/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc.performance;

import jasm.Label;
import jasm.tools.test.performance.PerformanceTester;
import static jasm.sparc.AnnulBit.A;
import static jasm.sparc.BranchPredictionBit.PT;
import static jasm.sparc.GPR.G0;
import static jasm.sparc.GPR.G1;
import static jasm.sparc.GPR.G4;
import static jasm.sparc.GPR.G5;
import static jasm.sparc.GPR.G7;
import static jasm.sparc.GPR.I0;
import static jasm.sparc.GPR.I1;
import static jasm.sparc.GPR.L0;
import static jasm.sparc.GPR.O2;
import static jasm.sparc.ICCOperand.ICC;
import static jasm.sparc.MembarOperand.LOAD_LOAD;
import static jasm.sparc.MembarOperand.LOAD_STORE;
import static jasm.sparc.MembarOperand.NO_MEMBAR;
import jasm.sparc.StateRegister;
import jasm.sparc.as.SPARCAssembler;

public abstract class SPARCPerformanceTester
    extends PerformanceTester {

  public SPARCPerformanceTester() {
    super(9);
  }

  protected byte[] assemble(SPARCAssembler asm) throws Exception {
    asm.rd(StateRegister.PC, G1);

    asm.add(G0, I1, O2);
    asm.sub(G5, 12, G7);
    asm.movvc(ICC, -12, G7);
    asm.sethi(0x1234, G7);

    // Example code from J.6:
    final Label retry = new Label();
    final Label loop = new Label();
    final Label out = new Label();

    asm.bindLabel(retry);
    asm.ldstub(G1, G4, I0);
    asm.tst(I0);
    asm.be(out);
    asm.nop();
    asm.bindLabel(loop);
    asm.ldub(G1, G4, I0);
    asm.tst(I0);
    asm.bne(loop);
    asm.nop();
    asm.ba(retry);
    asm.ba(A, PT, ICC, retry);
    asm.bindLabel(out);
    asm.rd(StateRegister.PC, L0);

    asm.membar(LOAD_LOAD.or(LOAD_STORE));
    asm.membar(NO_MEMBAR.or(LOAD_STORE));

    return asm.toByteArray();
  }
}
