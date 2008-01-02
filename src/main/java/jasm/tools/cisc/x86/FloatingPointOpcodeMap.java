/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import static jasm.ia32.IA32GeneralRegister16.*;
import jasm.tools.Assembly;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.ST_i;
import static jasm.util.HexByte.*;
import static jasm.x86.FPStackRegister.ST;
import static jasm.x86.FPStackRegister.ST_0;

public final class FloatingPointOpcodeMap extends X86InstructionDescriptionCreator {

  private void create_D8() {
    defineFP(_D8, _C0, "FADD", ST, ST_i);
    defineFP(_D8, _C8, "FMUL", ST, ST_i);
    defineFP(_D8, _D0, "FCOM", ST_i);
    defineFP(_D8, _D8, "FCOMP", ST_i);
    defineFP(_D8, _E0, "FSUB", ST, ST_i);
    defineFP(_D8, _E8, "FSUBR", ST, ST_i);
    defineFP(_D8, _F0, "FDIV", ST, ST_i);
    defineFP(_D8, _F8, "FDIVR", ST, ST_i);
  }

  private void create_D9() {
    defineFP(_D9, _C0, "FLD", ST_i);
    defineFP(_D9, _C8, "FXCH", ST_i);

    defineFP(_D9, _D0, "FNOP");
    defineFP(_D9, _D8, "FSTP1", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction

    defineFP(_D9, _E0, "FCHS");
    defineFP(_D9, _E1, "FABS");
    defineFP(_D9, _E4, "FTST");
    defineFP(_D9, _E5, "FXAM");
    defineFP(_D9, _E8, "FLD1");
    defineFP(_D9, _E9, "FLDL2T");
    defineFP(_D9, _EA, "FLDL2E");
    defineFP(_D9, _EB, "FLDPI");
    defineFP(_D9, _EC, "FLDLG2");
    defineFP(_D9, _ED, "FLDLN2");
    defineFP(_D9, _EE, "FLDZ");

    defineFP(_D9, _F0, "F2XM1");
    defineFP(_D9, _F1, "FYL2X");
    defineFP(_D9, _F2, "FPTAN");
    defineFP(_D9, _F3, "FPATAN");
    defineFP(_D9, _F4, "FXTRACT");
    defineFP(_D9, _F5, "FPREM1");
    defineFP(_D9, _F6, "FDECSTP");
    defineFP(_D9, _F7, "FINCSTP");
    defineFP(_D9, _F8, "FPREM");
    defineFP(_D9, _F9, "FYL2XP1");
    defineFP(_D9, _FA, "FSQRT");
    defineFP(_D9, _FB, "FSINCOS");
    defineFP(_D9, _FC, "FRNDINT");
    defineFP(_D9, _FD, "FSCALE");
    defineFP(_D9, _FE, "FSIN");
    defineFP(_D9, _FF, "FCOS");
  }

  private void create_DA() {
    defineFP(_DA, _C0, "FCMOVB", ST, ST_i);
    defineFP(_DA, _C8, "FCMOVE", ST, ST_i);
    defineFP(_DA, _D0, "FCMOVBE", ST, ST_i);
    defineFP(_DA, _D8, "FCMOVU", ST, ST_i);
    defineFP(_DA, _E9, "FUCOMPP");
  }

  private void create_DB() {
    defineFP(_DB, _C0, "FCMOVNB", ST, ST_i);
    defineFP(_DB, _C8, "FCMOVNE", ST, ST_i);
    defineFP(_DB, _D0, "FCMOVNBE", ST, ST_i);
    defineFP(_DB, _D8, "FCMOVNU", ST, ST_i);
    defineFP(_DB, _E2, "FCLEX");
    defineFP(_DB, _E3, "FINIT");
    defineFP(_DB, _E8, "FUCOMI", ST, ST_i);
    defineFP(_DB, _F0, "FCOMI", ST, ST_i);
  }

  private void create_DC() {
    defineFP(_DC, _C0, "FADD", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
    defineFP(_DC, _C8, "FMUL", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
    defineFP(_DC, _D0, "FCOM2", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DC, _D8, "FCOMP3", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DC, _E0, "FSUB", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
    defineFP(_DC, _E8, "FSUBR", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
    defineFP(_DC, _F0, "FDIV", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
    defineFP(_DC, _F8, "FDIVR", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
  }

  private void create_DD() {
    defineFP(_DD, _C0, "FFREE", ST_i);
    defineFP(_DD, _C8, "FXCH4", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DD, _D0, "FST", ST_i);
    defineFP(_DD, _D8, "FSTP", ST_i);
    defineFP(_DD, _E0, "FUCOM", ST_i);
    defineFP(_DD, _E8, "FUCOMP", ST_i);
  }

  private void create_DE() {
    defineFP(_DE, _C0, "FADDP", ST_i, ST);
    defineFP(_DE, _C8, "FMULP", ST_i, ST);
    defineFP(_DE, _D0, "FCOMP5", ST_i, ST).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DE, _D9, "FCOMPP");
    defineFP(_DE, _E0, "FSUBRP", ST_i, ST).setExternalName("fsubp"); // gas bug: confounding FSUBRP and FSUBP
    defineFP(_DE, _E8, "FSUBP", ST_i, ST).setExternalName("fsubrp"); // gas bug: confounding FSUBRP and FSUBP
    defineFP(_DE, _F0, "FDIVRP", ST_i, ST).setExternalName("fdivp"); // gas bug: confounding fdivrp and fdivp
    defineFP(_DE, _F8, "FDIVP", ST_i, ST).setExternalName("fdivrp"); // gas bug: confounding fdivrp and fdivp
  }

  private void create_DF() {
    defineFP(_DF, _C0, "FFREEP", ST_i);
    defineFP(_DF, _C8, "FXCH7", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DF, _D0, "FSTP8", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DF, _D8, "FSTP9", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DF, _E0, "FSTSW", AX);
    defineFP(_DF, _E8, "FUCOMIP", ST, ST_i);
    defineFP(_DF, _F0, "FCOMIP", ST, ST_i);
  }

  public FloatingPointOpcodeMap(Assembly<? extends X86Template> assembly) {
    super(assembly);
    create_D8();
    create_D9();
    create_DA();
    create_DB();
    create_DC();
    create_DD();
    create_DE();
    create_DF();
  }
}
