/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.ppc.test.performance;

import jasm.Label;
import jasm.ppc.BranchPredictionBits;
import jasm.ppc.CRF;
import jasm.ppc.GPR;
import jasm.ppc.Zero;
import jasm.ppc.as.PPCAssembler;
import jasm.tools.test.performance.PerformanceTester;

public abstract class PPCPerformanceTester
    extends PerformanceTester {

  public PPCPerformanceTester() {
    super(9);
  }

  protected byte[] assemble(PPCAssembler asm) throws Exception {
    final Label loop1 = new Label();
    final Label loop2 = new Label();

    // Example code from B.3 [Book 2] for list insertion
    asm.lwz(GPR.RTOC, 0, GPR.R3);      // get next pointer
    asm.bindLabel(loop1);
    asm.mr(GPR.R5, GPR.RTOC);          // keep a copy
    asm.stw(GPR.RTOC, 0, GPR.R4);      // store in new element
    asm.sync();                // order stw before stwcx. and before lwarx
    asm.bindLabel(loop2);
    asm.lwarx(GPR.RTOC, Zero.ZERO, GPR.R3); // get it again
    asm.cmpw(GPR.RTOC, GPR.R5);        // loop if changed (someone
    asm.bne(CRF.CR0, loop1, BranchPredictionBits.PN);   //    else progressed)
    asm.stwcx(GPR.R4, Zero.ZERO, GPR.R3);   // add new element to list
    asm.bne(CRF.CR0, loop2, BranchPredictionBits.PN);   // loop if failed    return asm.toByteArray();

    return asm.toByteArray();
  }
}
