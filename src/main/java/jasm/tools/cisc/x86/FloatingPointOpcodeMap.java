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

public final class  FloatingPointOpcodeMap extends X86InstructionDescriptionCreator {

  private void create_D8() {
    defineFP(_D8, _C0, "fadd", ST, ST_i);
    defineFP(_D8, _C8, "fmul", ST, ST_i);
    defineFP(_D8, _D0, "fcom", ST_i);
    defineFP(_D8, _D8, "fcomp", ST_i);
    defineFP(_D8, _E0, "fsub", ST, ST_i);
    defineFP(_D8, _E8, "fsubr", ST, ST_i);
    defineFP(_D8, _F0, "fdiv", ST, ST_i);
    defineFP(_D8, _F8, "fdivr", ST, ST_i);
  }

  private void create_D9() {
    defineFP(_D9, _C0, "fld", ST_i);
    defineFP(_D9, _C8, "fxch", ST_i);

    defineFP(_D9, _D0, "fnop");
    defineFP(_D9, _D8, "fstp1", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction

    defineFP(_D9, _E0, "fchs");
    defineFP(_D9, _E1, "fabs");
    defineFP(_D9, _E4, "ftst");
    defineFP(_D9, _E5, "fxam");
    defineFP(_D9, _E8, "fld1");
    defineFP(_D9, _E9, "fldl2t");
    defineFP(_D9, _EA, "fldl2e");
    defineFP(_D9, _EB, "fldpi");
    defineFP(_D9, _EC, "fldlg2");
    defineFP(_D9, _ED, "fldln2");
    defineFP(_D9, _EE, "fldz");

    defineFP(_D9, _F0, "f2xm1");
    defineFP(_D9, _F1, "fyl2x");
    defineFP(_D9, _F2, "fptan");
    defineFP(_D9, _F3, "fpatan");
    defineFP(_D9, _F4, "fxtract");
    defineFP(_D9, _F5, "fprem1");
    defineFP(_D9, _F6, "fdecstp");
    defineFP(_D9, _F7, "fincstp");
    defineFP(_D9, _F8, "fprem");
    defineFP(_D9, _F9, "fyl2xp1");
    defineFP(_D9, _FA, "fsqrt");
    defineFP(_D9, _FB, "fsincos");
    defineFP(_D9, _FC, "frndint");
    defineFP(_D9, _FD, "fscale");
    defineFP(_D9, _FE, "fsin");
    defineFP(_D9, _FF, "fcos");
  }

  private void create_DA() {
    defineFP(_DA, _C0, "fcmovb", ST, ST_i);
    defineFP(_DA, _C8, "fcmove", ST, ST_i);
    defineFP(_DA, _D0, "fcmovbe", ST, ST_i);
    defineFP(_DA, _D8, "fcmovu", ST, ST_i);
    defineFP(_DA, _E9, "fucompp");
  }

  private void create_DB() {
    defineFP(_DB, _C0, "fcmovnb", ST, ST_i);
    defineFP(_DB, _C8, "fcmovne", ST, ST_i);
    defineFP(_DB, _D0, "fcmovnbe", ST, ST_i);
    defineFP(_DB, _D8, "fcmovnu", ST, ST_i);
    defineFP(_DB, _E2, "fclex");
    defineFP(_DB, _E3, "finit");
    defineFP(_DB, _E8, "fucomi", ST, ST_i);
    defineFP(_DB, _F0, "fcomi", ST, ST_i);
  }

  private void create_DC() {
    defineFP(_DC, _C0, "fadd", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
    defineFP(_DC, _C8, "fmul", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
    defineFP(_DC, _D0, "fcom2", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DC, _D8, "fcomp3", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DC, _E0, "fsub", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
    defineFP(_DC, _E8, "fsubr", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
    defineFP(_DC, _F0, "fdiv", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
    defineFP(_DC, _F8, "fdivr", ST_i.excludeExternalTestArguments(ST_0, ST), ST); //gas uses D8 if both operands are ST(0)
  }

  private void create_DD() {
    defineFP(_DD, _C0, "ffree", ST_i);
    defineFP(_DD, _C8, "fxch4", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DD, _D0, "fst", ST_i);
    defineFP(_DD, _D8, "fstp", ST_i);
    defineFP(_DD, _E0, "fucom", ST_i);
    defineFP(_DD, _E8, "fucomp", ST_i);
  }

  private void create_DE() {
    defineFP(_DE, _C0, "faddp", ST_i, ST);
    defineFP(_DE, _C8, "fmulp", ST_i, ST);
    defineFP(_DE, _D0, "fcomp5", ST_i, ST).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DE, _D9, "fcompp");
    defineFP(_DE, _E0, "fsubrp", ST_i, ST).setExternalName("fsubp"); // gas bug: confounding FSUBRP and FSUBP
    defineFP(_DE, _E8, "fsubp", ST_i, ST).setExternalName("fsubrp"); // gas bug: confounding FSUBRP and FSUBP
    defineFP(_DE, _F0, "fdivrp", ST_i, ST).setExternalName("fdivp"); // gas bug: confounding fdivrp and fdivp
    defineFP(_DE, _F8, "fdivp", ST_i, ST).setExternalName("fdivrp"); // gas bug: confounding fdivrp and fdivp
  }

  private void create_DF() {
    defineFP(_DF, _C0, "ffreep", ST_i);
    defineFP(_DF, _C8, "fxch7", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DF, _D0, "fstp8", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DF, _D8, "fstp9", ST_i).beNotExternallyTestable(); // not implemented by gas, since this is a redundant instruction
    defineFP(_DF, _E0, "fstsw", AX);
    defineFP(_DF, _E8, "fucomip", ST, ST_i);
    defineFP(_DF, _F0, "fcomip", ST, ST_i);
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
