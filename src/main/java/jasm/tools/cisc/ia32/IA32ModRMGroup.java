/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.ia32;

import static jasm.ia32.IA32GeneralRegister16.*;
import static jasm.ia32.IA32GeneralRegister32.*;
import static jasm.ia32.IA32GeneralRegister8.*;
import jasm.tools.ExternalOmission;
import static jasm.tools.cisc.x86.AddressingMethodCode.M;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.bytes_14_28;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.bytes_2;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.bytes_98_108;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.double_real;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.extended_real;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.long_integer;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.packed_bcd;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.short_integer;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.single_real;
import static jasm.tools.cisc.x86.FloatingPointOperandCode.word_integer;
import jasm.tools.cisc.x86.ModRMDescription;
import static jasm.tools.cisc.x86.ModRMDescription.modRM;
import jasm.tools.cisc.x86.ModRMGroup;
import jasm.tools.cisc.x86.ModRMOpcode;
import static jasm.tools.cisc.x86.ModRMOpcode.*;
import static jasm.tools.cisc.x86.StandardOperandCode.*;
import static jasm.tools.cisc.x86.OperandTypeCode.v;
import jasm.tools.cisc.x86.X86RegisterOperandCode;

/**
 * See A-7 in the book.
 *
 * @see jasm.x86
 */
public enum IA32ModRMGroup implements ModRMGroup {

  GROUP_1(
      modRM(_0, "add"),
      modRM(_1, "or"),
      modRM(_2, "adc"),
      modRM(_3, "sbb"),
      modRM(_4, "and"),
      modRM(_5, "sub"),
      modRM(_6, "xor"),
      modRM(_7, "cmp")
  ),
  GROUP_2(
      modRM(_0, "rol"),
      modRM(_1, "ror"),
      modRM(_2, "rcl"),
      modRM(_3, "rcr"),
      modRM(_4, "shl"),
      modRM(_5, "shr"),
      modRM(_7, "sar")
  ),
  GROUP_3b(
      modRM(_0, "test", Eb.excludeExternalTestArguments(AL), Ib),
      modRM(_1, "test", Eb.excludeExternalTestArguments(AL), Ib),
      modRM(_2, "not", Eb),
      modRM(_3, "neg", Eb),
      modRM(_4, "mul", Eb, new ExternalOmission(AL)),
      modRM(_5, "imul", Eb, new ExternalOmission(AL)),
      modRM(_6, "div", Eb, new ExternalOmission(AL)),
      modRM(_7, "idiv", Eb, new ExternalOmission(AL))
  ),
  GROUP_3v(
      modRM(_0, "test", Ev.excludeExternalTestArguments(AX, EAX), Iv),
      modRM(_1, "test", Ev.excludeExternalTestArguments(AX, EAX), Iv),
      modRM(_2, "not", Ev),
      modRM(_3, "neg", Ev),
      modRM(_4, "mul", Ev, new ExternalOmission(X86RegisterOperandCode.EAX)),
      modRM(_5, "imul", Ev, new ExternalOmission(X86RegisterOperandCode.EAX)),
      modRM(_6, "div", Ev, new ExternalOmission(X86RegisterOperandCode.EAX)),
      modRM(_7, "idiv", Ev, new ExternalOmission(X86RegisterOperandCode.EAX))
  ),
  GROUP_4(
      modRM(_0, "inc"),
      modRM(_1, "dec")
  ),
  GROUP_5(
      modRM(_0, "inc", v, Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI, EAX, ECX, EDX, EBX, ESP, EBP, ESI, EDI)),
      modRM(_1, "dec", v, Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI, EAX, ECX, EDX, EBX, ESP, EBP, ESI, EDI)),
      modRM(_2, "call", Ev),
      modRM(_3, "call", Mp),
      modRM(_4, "jmp", Ev),
      modRM(_5, "jmp", Mp),
      modRM(_6, "push", Ev)
  ),
  GROUP_6a(
      modRM(_0, "sldt", Mw),
      modRM(_1, "str", Mw),
      modRM(_2, "lldt", Ew),
      modRM(_3, "ltr", Ew),
      modRM(_4, "verr", Ew),
      modRM(_5, "verw", Ew)
  ),
  GROUP_6b(
      modRM(_0, "sldt", Rv),
      modRM(_1, "str", Rv)
  ),
  GROUP_7a(
      modRM(_0, "sgdt", Ms),
      modRM(_1, "sidt", Ms),
      modRM(_2, "lgdt", Ms),
      modRM(_3, "lidt", Ms),
      modRM(_4, "smsw", Mw),
      modRM(_6, "lmsw", Ew),
      modRM(_7, "invlpg", M)
  ),
  GROUP_7b(
      modRM(_4, "smsw", Rv)
  ),
  GROUP_8(
      modRM(_4, "bt"),
      modRM(_5, "bts"),
      modRM(_6, "btr"),
      modRM(_7, "btc")
  ),
  GROUP_9(
      modRM(_1, "cmpxchg8b", Mq)
  ),
  GROUP_10(
      modRM(_0, "ud2"),
      modRM(_1, "ud2"),
      modRM(_2, "ud2"),
      modRM(_3, "ud2"),
      modRM(_4, "ud2"),
      modRM(_5, "ud2"),
      modRM(_6, "ud2"),
      modRM(_7, "ud2")
  ),
  GROUP_11(
      modRM(_2, "psrlw", PRq, Ib),
      modRM(_4, "psraw", PRq, Ib),
      modRM(_6, "psllw", PRq, Ib)
  ),
  GROUP_12(
      modRM(_2, "psrld", PRq, Ib),
      modRM(_4, "psrad", PRq, Ib),
      modRM(_6, "pslld", PRq, Ib)
  ),
  GROUP_13(
      modRM(_2, "psrlq", PRq, Ib),
      modRM(_6, "psllq", PRq, Ib)
  ),
  FP_D8(
      modRM(_0, "fadd", single_real),
      modRM(_1, "fmul", single_real),
      modRM(_2, "fcom", single_real),
      modRM(_3, "fcomp", single_real),
      modRM(_4, "fsub", single_real),
      modRM(_5, "fsubr", single_real),
      modRM(_6, "fdiv", single_real),
      modRM(_7, "fdivr", single_real)
  ),
  FP_D9(
      modRM(_0, "fld", single_real),
      modRM(_2, "fst", single_real),
      modRM(_3, "fstp", single_real),
      modRM(_4, "fldenv", bytes_14_28),
      modRM(_5, "fldcw", bytes_2),
      modRM(_6, "fstenv", bytes_14_28),
      modRM(_7, "fstcw", bytes_2)
  ),
  FP_DA(
      modRM(_0, "fiadd", short_integer),
      modRM(_1, "fimul", short_integer),
      modRM(_2, "ficom", short_integer),
      modRM(_3, "ficomp", short_integer),
      modRM(_4, "fisub", short_integer),
      modRM(_5, "fisubr", short_integer),
      modRM(_6, "fidiv", short_integer),
      modRM(_7, "fidivr", short_integer)
  ),
  FP_DB(
      modRM(_0, "fild", short_integer),
      modRM(_2, "fist", short_integer),
      modRM(_3, "fistp", short_integer),
      modRM(_5, "fld", extended_real),
      modRM(_7, "fstp", extended_real)
  ),
  FP_DC(
      modRM(_0, "fadd", double_real),
      modRM(_1, "fmul", double_real),
      modRM(_2, "fcom", double_real),
      modRM(_3, "fcomp", double_real),
      modRM(_4, "fsub", double_real),
      modRM(_5, "fsubr", double_real),
      modRM(_6, "fdiv", double_real),
      modRM(_7, "fdivr", double_real)
  ),
  FP_DD(
      modRM(_0, "fld", double_real),
      modRM(_2, "fst", double_real),
      modRM(_3, "fstp", double_real),
      modRM(_4, "frstor", bytes_98_108),
      modRM(_6, "fsave", bytes_98_108),
      modRM(_7, "fstsw", bytes_2)
  ),
  FP_DE(
      modRM(_0, "fiadd", word_integer),
      modRM(_1, "fimul", word_integer),
      modRM(_2, "ficom", word_integer),
      modRM(_3, "ficomp", word_integer),
      modRM(_4, "fisub", word_integer),
      modRM(_5, "fisubr", word_integer),
      modRM(_6, "fidiv", word_integer),
      modRM(_7, "fidivr", word_integer)
  ),
  FP_DF(
      modRM(_0, "fild", word_integer),
      modRM(_2, "fist", word_integer),
      modRM(_3, "fistp", word_integer),
      modRM(_4, "fbld", packed_bcd),
      modRM(_5, "fild", long_integer),
      modRM(_6, "fbstp", packed_bcd),
      modRM(_7, "fistp", long_integer)
  );

  private final ModRMDescription[] _descriptions;

  private IA32ModRMGroup(ModRMDescription... descriptions) {
    _descriptions = descriptions;
  }

  public ModRMDescription getDescription(ModRMOpcode opcode) {
    return ModRMDescription.getDescriptionFrom(opcode, _descriptions);
  }
}
