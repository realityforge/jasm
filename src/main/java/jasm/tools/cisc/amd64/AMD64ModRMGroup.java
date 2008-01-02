/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.amd64;

import jasm.amd64.AMD64GeneralRegister16;
import static jasm.amd64.AMD64GeneralRegister16.*;
import jasm.amd64.AMD64GeneralRegister32;
import static jasm.amd64.AMD64GeneralRegister32.*;
import jasm.amd64.AMD64GeneralRegister64;
import static jasm.amd64.AMD64GeneralRegister64.*;
import static jasm.amd64.AMD64GeneralRegister8.*;
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
import jasm.tools.cisc.x86.ModCase;
import jasm.tools.cisc.x86.ModRMDescription;
import static jasm.tools.cisc.x86.ModRMDescription.modRM;
import jasm.tools.cisc.x86.ModRMGroup;
import jasm.tools.cisc.x86.ModRMOpcode;
import static jasm.tools.cisc.x86.ModRMOpcode.*;
import static jasm.tools.cisc.x86.OperandCode.*;
import static jasm.tools.cisc.x86.OperandTypeCode.v;

/**
 * See A-7 in the book.
 *
 * @see jasm.x86
 */
public enum AMD64ModRMGroup implements ModRMGroup {

  GROUP_1(
      modRM(_0, "ADD"),
      modRM(_1, "OR"),
      modRM(_2, "ADC"),
      modRM(_3, "SBB"),
      modRM(_4, "AND"),
      modRM(_5, "SUB"),
      modRM(_6, "XOR"),
      modRM(_7, "CMP")
  ),
  GROUP_2(
      modRM(_0, "ROL"),
      modRM(_1, "ROR"),
      modRM(_2, "RCL"),
      modRM(_3, "RCR"),
      modRM(_4, "SHL"),
      modRM(_5, "SHR"),
      modRM(_6, "SHL"),
      modRM(_7, "SAR")
  ),
  GROUP_3b(
      modRM(_0, "TEST", Eb.excludeExternalTestArguments(AL), Ib),
      modRM(_1, "TEST", Eb.excludeExternalTestArguments(AL), Ib),
      modRM(_2, "NOT", Eb),
      modRM(_3, "NEG", Eb),
      modRM(_4, "MUL", Eb, new ExternalOmission(AL)),
      modRM(_5, "IMUL", Eb, new ExternalOmission(AL)),
      modRM(_6, "DIV", Eb, new ExternalOmission(AL)),
      modRM(_7, "IDIV", Eb, new ExternalOmission(AL))
  ),
  GROUP_3v(
      modRM(_0, "TEST", Ev.excludeExternalTestArguments(AX, EAX, RAX), Iz.externalRange(0, Integer.MAX_VALUE)),
      modRM(_1, "TEST", Ev.excludeExternalTestArguments(AX, EAX, RAX), Iz.externalRange(0, Integer.MAX_VALUE)),
      modRM(_2, "NOT", Ev),
      modRM(_3, "NEG", Ev),
      modRM(_4, "MUL", Ev),
      modRM(_5, "IMUL", Ev),
      modRM(_6, "DIV", Ev),
      modRM(_7, "IDIV", Ev)
  ),
  GROUP_4(
      modRM(_0, "INC"),
      modRM(_1, "DEC")
  ),
  GROUP_5a(
      modRM(_0, "INC", v, Ev),
      modRM(_1, "DEC", v, Ev)
      // modRM(_3, "CALL", Mp), // legacy mode instruction
      // modRM(_5, "JMP", Mp) // legacy mode instruction
  ),
  GROUP_5b(
      modRM(_2, "CALL", Ev),
      modRM(_4, "JMP", Ev),
      modRM(_6, "PUSH", Ev.excludeExternalTestArguments(AMD64GeneralRegister16.SYMBOLS, AMD64GeneralRegister32.SYMBOLS, AMD64GeneralRegister64.SYMBOLS))
  ),
  GROUP_6a(
      modRM(_0, "SLDT", Mw),
      modRM(_1, "STR", Mw),
      modRM(_2, "LLDT", Ew),
      modRM(_3, "LTR", Ew),
      modRM(_4, "VERR", Ew),
      modRM(_5, "VERW", Ew)
  ),
  GROUP_6b(
      modRM(_0, "SLDT", Rv),
      modRM(_1, "STR", Rv)
  ),
  GROUP_7a(
      modRM(_0, "SGDT", Ms),
      modRM(_1, "SIDT", Ms),
      modRM(_2, "LGDT", Ms),
      modRM(_3, "LIDT", Ms),
      modRM(_4, "SMSW", Mw),
      modRM(_6, "LMSW", Ew),
      modRM(_7, "INVLPG", M)
  ),
  GROUP_7b(
      modRM(_4, "SMSW", Rv),
      modRM(_7, "SWAPGS", ModCase.MOD_3)    // r/m field == 0
      // modRM(_7, "RDTSCP", ModCase.MOD_3) // r/m field == 1
  ),
  GROUP_8(
      modRM(_4, "BT"),
      modRM(_5, "BTS"),
      modRM(_6, "BTR"),
      modRM(_7, "BTC")
  ),
  GROUP_9a(
      modRM(_1, "CMPXCHG8B", Mq)
  ),
  GROUP_9b(
      modRM(_1, "CMPXCHG16B", Mdq)
  ),
  GROUP_10(
  ),
  GROUP_11(
      modRM(_0, "MOV", Eb, Ib),
      modRM(_1, "MOV", Ev, Iz)
  ),
  GROUP_12a(
      modRM(_2, "PSRLW", PRq, Ib),
      modRM(_4, "PSRAW", PRq, Ib),
      modRM(_6, "PSLLW", PRq, Ib)
  ),
  GROUP_12b(
      modRM(_2, "PSRLW", Udq, Ib),
      modRM(_4, "PSRAW", Udq, Ib),
      modRM(_6, "PSLLW", Udq, Ib)
  ),
  GROUP_13a(
      modRM(_2, "PSRLD", PRq, Ib),
      modRM(_4, "PSRAD", PRq, Ib),
      modRM(_6, "PSLLD", PRq, Ib)
  ),
  GROUP_13b(
      modRM(_2, "PSRLD", Udq, Ib),
      modRM(_4, "PSRAD", Udq, Ib),
      modRM(_6, "PSLLD", Udq, Ib)
  ),
  GROUP_14a(
      modRM(_2, "PSRLQ", PRq, Ib),
      modRM(_6, "PSLLQ", PRq, Ib)
  ),
  GROUP_14b(
      modRM(_2, "PSRLQ", Udq, Ib),
      modRM(_3, "PSRLDQ", Udq, Ib),
      modRM(_6, "PSLLQ", Udq, Ib),
      modRM(_7, "PSLLDQ", Udq, Ib)
  ),
  GROUP_15a(
      modRM(_0, "FXSAVE", M),
      modRM(_1, "FXRSTOR", M),
      modRM(_2, "LDMXCSR", Md),
      modRM(_3, "STMXCSR", Md),
      modRM(_7, "CLFLUSH", Mb)
  ),
  GROUP_15b(
      modRM(_5, "LFENCE"),
      modRM(_6, "MFENCE"),
      modRM(_7, "SFENCE")
  ),
  GROUP_16(
      modRM(_0, "PREFETCHNTA"),
      modRM(_1, "PREFETCHT0"),
      modRM(_2, "PREFETCHT1"),
      modRM(_3, "PREFETCHT2")
  ),
  GROUP_P(
      modRM(_0, "PREFETCH"),
      modRM(_1, "PREFETCHW"),
      modRM(_3, "PREFETCH")
  ),
  FP_D8(
      modRM(_0, "FADD", single_real),
      modRM(_1, "FMUL", single_real),
      modRM(_2, "FCOM", single_real),
      modRM(_3, "FCOMP", single_real),
      modRM(_4, "FSUB", single_real),
      modRM(_5, "FSUBR", single_real),
      modRM(_6, "FDIV", single_real),
      modRM(_7, "FDIVR", single_real)
  ),
  FP_D9(
      modRM(_0, "FLD", single_real),
      modRM(_2, "FST", single_real),
      modRM(_3, "FSTP", single_real),
      modRM(_4, "FLDENV", bytes_14_28),
      modRM(_5, "FLDCW", bytes_2),
      modRM(_6, "FSTENV", bytes_14_28),
      modRM(_7, "FSTCW", bytes_2)
  ),
  FP_DA(
      modRM(_0, "FIADD", short_integer),
      modRM(_1, "FIMUL", short_integer),
      modRM(_2, "FICOM", short_integer),
      modRM(_3, "FICOMP", short_integer),
      modRM(_4, "FISUB", short_integer),
      modRM(_5, "FISUBR", short_integer),
      modRM(_6, "FIDIV", short_integer),
      modRM(_7, "FIDIVR", short_integer)
  ),
  FP_DB(
      modRM(_0, "FILD", short_integer),
      modRM(_2, "FIST", short_integer),
      modRM(_3, "FISTP", short_integer),
      modRM(_5, "FLD", extended_real),
      modRM(_7, "FSTP", extended_real)
  ),
  FP_DC(
      modRM(_0, "FADD", double_real),
      modRM(_1, "FMUL", double_real),
      modRM(_2, "FCOM", double_real),
      modRM(_3, "FCOMP", double_real),
      modRM(_4, "FSUB", double_real),
      modRM(_5, "FSUBR", double_real),
      modRM(_6, "FDIV", double_real),
      modRM(_7, "FDIVR", double_real)
  ),
  FP_DD(
      modRM(_0, "FLD", double_real),
      modRM(_2, "FST", double_real),
      modRM(_3, "FSTP", double_real),
      modRM(_4, "FRSTOR", bytes_98_108),
      modRM(_6, "FSAVE", bytes_98_108),
      modRM(_7, "FSTSW", bytes_2)
  ),
  FP_DE(
      modRM(_0, "FIADD", word_integer),
      modRM(_1, "FIMUL", word_integer),
      modRM(_2, "FICOM", word_integer),
      modRM(_3, "FICOMP", word_integer),
      modRM(_4, "FISUB", word_integer),
      modRM(_5, "FISUBR", word_integer),
      modRM(_6, "FIDIV", word_integer),
      modRM(_7, "FIDIVR", word_integer)
  ),
  FP_DF(
      modRM(_0, "FILD", word_integer),
      modRM(_2, "FIST", word_integer),
      modRM(_3, "FISTP", word_integer),
      modRM(_4, "FBLD", packed_bcd),
      modRM(_5, "FILD", long_integer),
      modRM(_6, "FBSTP", packed_bcd),
      modRM(_7, "FISTP", long_integer)
  );

  private final ModRMDescription[] _descriptions;

  private AMD64ModRMGroup(ModRMDescription... descriptions) {
    _descriptions = descriptions;
  }

  public ModRMDescription getDescription(ModRMOpcode opcode) {
    return ModRMDescription.getDescriptionFrom(opcode, _descriptions);
  }
}
