/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc;

import static jasm.sparc.AnnulBit.A;
import static jasm.sparc.BranchPredictionBit.PT;
import static jasm.sparc.GPR.G0;
import static jasm.sparc.GPR.I7;
import static jasm.sparc.GPR.O7;
import static jasm.sparc.ICCOperand.XCC;
import jasm.sparc.StateRegister;
import static jasm.tools.InstructionConstraint.Static.getPredicateMethod;
import static jasm.tools.InstructionConstraint.Static.makePredicate;
import static jasm.tools.risc.sparc.SPARCFields.*;

/** Simple synthetic SPARC instructions. */
final class SyntheticInstructions extends SPARCInstructionDescriptionCreator {

  private void create_A39() {
    synthesize("nop", "sethi", imm22(0), rd(G0));
  }

  private static final int ASI_P = 0x80;
  private static final int ASI_P_L = 0x88;

  private void create_G3() {
    synthesize("cmp", "subcc", rd(G0));
    synthesize("jmp", "jmpl", rd(G0));
    synthesize("call", "jmpl", rd(O7));
    synthesize("iprefetch", "bn", a(A), p(PT), cc(XCC));
    synthesize("tst", "orcc", rs1(G0), rd(G0), i(0));
    synthesize("ret", "jmpl", rs1(I7), simm13(8), rd(G0)).replace(" + ", "");
    synthesize("retl", "jmpl", rs1(O7), simm13(8), rd(G0)).replace(" + ", "");
    synthesize("restore", "restore", rs1(G0), rs2(G0), rd(G0));
    synthesize("save", "save", rs1(G0), rs2(G0), rd(G0));
    synthesize("signx", "sra", rs2(G0), i(0));
    synthesize("signx", "sra", rs1(rd), rs2(G0), i(0));
    synthesize("not", "xnor", rs2(G0));
    synthesize("not", "xnor", rs1(rd), rs2(G0));
    synthesize("neg", "sub", rs1(G0), i(0));
    synthesize("neg", "sub", rs1(G0), rs2(rd), i(0));
    synthesize("cas", "casa", immAsi(ASI_P));
    synthesize("casl", "casa", immAsi(ASI_P_L));
    synthesize("casx", "casxa", immAsi(ASI_P));
    synthesize("casxl", "casxa", immAsi(ASI_P_L));
    synthesize("inc", "add", rs1(rd), simm13(1), i(1));
    synthesize("inc", "add", rs1(rd), i(1));
    synthesize("inccc", "addcc", rs1(rd), simm13(1), i(1));
    synthesize("inccc", "addcc", rs1(rd), i(1));
    synthesize("dec", "sub", rs1(rd), simm13(1), i(1));
    synthesize("dec", "sub", rs1(rd), i(1));
    synthesize("deccc", "subcc", rs1(rd), simm13(1), i(1));
    synthesize("deccc", "subcc", rs1(rd), i(1));
    synthesize("btst", "andcc", rd(G0)).swap(rs2, rs1).swap(simm13, rs1);
    synthesize("bset", "or", rs1(rd));
    synthesize("bclr", "andn", rs1(rd));
    synthesize("btog", "xor", rs1(rd));
    synthesize("clr", "or", rs1(G0), rs2(G0));
    synthesize("clrb", "stb", rd(G0)).replace(", [", "[");
    synthesize("clrh", "sth", rd(G0)).replace(", [", "[");
    synthesize("clr", "stw", rd(G0)).replace(", [", "[");
    synthesize("clrx", "stx", rd(G0)).replace(", [", "[");
    synthesize("clruw", "srl", rs2(G0), i(0));
    synthesize("clruw", "srl", rs1(rd), rs2(G0), i(0));
    synthesize("mov", "or", rs1(G0));
    synthesize("mov", "rd", makePredicate(getPredicateMethod(StateRegister.class, "isYorASR"), rs1_state));
    synthesize("mov", "wr", rs1(G0), makePredicate(getPredicateMethod(StateRegister.class, "isYorASR"), rd_state));
  }

  SyntheticInstructions(SPARCTemplateCreator creator) {
    super(creator);

    setCurrentArchitectureManualSection("A.39");
    create_A39();

    setCurrentArchitectureManualSection("G.3");
    create_G3();
  }

}
