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
import jasm.tools.cisc.x86.ModRMGroup;
import static jasm.tools.cisc.x86.OperandCode.*;
import static jasm.tools.cisc.x86.OperandTypeCode.v;
import jasm.tools.cisc.x86.X86RegisterOperandCode;
import jasm.tools.cisc.x86.ModRMOpcode;
import java.util.Arrays;

/**
 * See A-7 in the book.
 *
 * @see jasm.x86
 */
public enum IA32ModRMGroup implements ModRMGroup {

  GROUP_1(
      modRM(ModRMOpcode._0, "ADD"),
      modRM(ModRMOpcode._1, "OR"),
      modRM(ModRMOpcode._2, "ADC"),
      modRM(ModRMOpcode._3, "SBB"),
      modRM(ModRMOpcode._4, "AND"),
      modRM(ModRMOpcode._5, "SUB"),
      modRM(ModRMOpcode._6, "XOR"),
      modRM(ModRMOpcode._7, "CMP")
  ),
  GROUP_2(
      modRM(ModRMOpcode._0, "ROL"),
      modRM(ModRMOpcode._1, "ROR"),
      modRM(ModRMOpcode._2, "RCL"),
      modRM(ModRMOpcode._3, "RCR"),
      modRM(ModRMOpcode._4, "SHL"),
      modRM(ModRMOpcode._5, "SHR"),
      modRM(ModRMOpcode._7, "SAR")
  ),
  GROUP_3b(
      modRM(ModRMOpcode._0, "TEST", Eb.excludeExternalTestArguments(AL), Ib),
      modRM(ModRMOpcode._1, "TEST", Eb.excludeExternalTestArguments(AL), Ib),
      modRM(ModRMOpcode._2, "NOT", Eb),
      modRM(ModRMOpcode._3, "NEG", Eb),
      modRM(ModRMOpcode._4, "MUL", Eb, new ExternalOmission(AL)),
      modRM(ModRMOpcode._5, "IMUL", Eb, new ExternalOmission(AL)),
      modRM(ModRMOpcode._6, "DIV", Eb, new ExternalOmission(AL)),
      modRM(ModRMOpcode._7, "IDIV", Eb, new ExternalOmission(AL))
  ),
  GROUP_3v(
      modRM(ModRMOpcode._0, "TEST", Ev.excludeExternalTestArguments(AX, EAX), Iv),
      modRM(ModRMOpcode._1, "TEST", Ev.excludeExternalTestArguments(AX, EAX), Iv),
      modRM(ModRMOpcode._2, "NOT", Ev),
      modRM(ModRMOpcode._3, "NEG", Ev),
      modRM(ModRMOpcode._4, "MUL", Ev, new ExternalOmission(X86RegisterOperandCode.EAX)),
      modRM(ModRMOpcode._5, "IMUL", Ev, new ExternalOmission(X86RegisterOperandCode.EAX)),
      modRM(ModRMOpcode._6, "DIV", Ev, new ExternalOmission(X86RegisterOperandCode.EAX)),
      modRM(ModRMOpcode._7, "IDIV", Ev, new ExternalOmission(X86RegisterOperandCode.EAX))
  ),
  GROUP_4(
      modRM(ModRMOpcode._0, "INC"),
      modRM(ModRMOpcode._1, "DEC")
  ),
  GROUP_5(
      modRM(ModRMOpcode._0, "INC", v, Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI, EAX, ECX, EDX, EBX, ESP, EBP, ESI, EDI)),
      modRM(ModRMOpcode._1, "DEC", v, Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI, EAX, ECX, EDX, EBX, ESP, EBP, ESI, EDI)),
      modRM(ModRMOpcode._2, "CALL", Ev),
      modRM(ModRMOpcode._3, "CALL", Mp),
      modRM(ModRMOpcode._4, "JMP", Ev),
      modRM(ModRMOpcode._5, "JMP", Mp),
      modRM(ModRMOpcode._6, "PUSH", Ev)
  ),
  GROUP_6a(
      modRM(ModRMOpcode._0, "SLDT", Mw),
      modRM(ModRMOpcode._1, "STR", Mw),
      modRM(ModRMOpcode._2, "LLDT", Ew),
      modRM(ModRMOpcode._3, "LTR", Ew),
      modRM(ModRMOpcode._4, "VERR", Ew),
      modRM(ModRMOpcode._5, "VERW", Ew)
  ),
  GROUP_6b(
      modRM(ModRMOpcode._0, "SLDT", Rv),
      modRM(ModRMOpcode._1, "STR", Rv)
  ),
  GROUP_7a(
      modRM(ModRMOpcode._0, "SGDT", Ms),
      modRM(ModRMOpcode._1, "SIDT", Ms),
      modRM(ModRMOpcode._2, "LGDT", Ms),
      modRM(ModRMOpcode._3, "LIDT", Ms),
      modRM(ModRMOpcode._4, "SMSW", Mw),
      modRM(ModRMOpcode._6, "LMSW", Ew),
      modRM(ModRMOpcode._7, "INVLPG", M)
  ),
  GROUP_7b(
      modRM(ModRMOpcode._4, "SMSW", Rv)
  ),
  GROUP_8(
      modRM(ModRMOpcode._4, "BT"),
      modRM(ModRMOpcode._5, "BTS"),
      modRM(ModRMOpcode._6, "BTR"),
      modRM(ModRMOpcode._7, "BTC")
  ),
  GROUP_9(
      modRM(ModRMOpcode._1, "CMPXCHG8B", Mq)
  ),
  GROUP_10(
      modRM(ModRMOpcode._0, "UD2"),
      modRM(ModRMOpcode._1, "UD2"),
      modRM(ModRMOpcode._2, "UD2"),
      modRM(ModRMOpcode._3, "UD2"),
      modRM(ModRMOpcode._4, "UD2"),
      modRM(ModRMOpcode._5, "UD2"),
      modRM(ModRMOpcode._6, "UD2"),
      modRM(ModRMOpcode._7, "UD2")
  ),
  GROUP_11(
      modRM(ModRMOpcode._2, "PSRLW", PRq, Ib),
      modRM(ModRMOpcode._4, "PSRAW", PRq, Ib),
      modRM(ModRMOpcode._6, "PSLLW", PRq, Ib)
  ),
  GROUP_12(
      modRM(ModRMOpcode._2, "PSRLD", PRq, Ib),
      modRM(ModRMOpcode._4, "PSRAD", PRq, Ib),
      modRM(ModRMOpcode._6, "PSLLD", PRq, Ib)
  ),
  GROUP_13(
      modRM(ModRMOpcode._2, "PSRLQ", PRq, Ib),
      modRM(ModRMOpcode._6, "PSLLQ", PRq, Ib)
  ),
  FP_D8(
      modRM(ModRMOpcode._0, "FADD", single_real),
      modRM(ModRMOpcode._1, "FMUL", single_real),
      modRM(ModRMOpcode._2, "FCOM", single_real),
      modRM(ModRMOpcode._3, "FCOMP", single_real),
      modRM(ModRMOpcode._4, "FSUB", single_real),
      modRM(ModRMOpcode._5, "FSUBR", single_real),
      modRM(ModRMOpcode._6, "FDIV", single_real),
      modRM(ModRMOpcode._7, "FDIVR", single_real)
  ),
  FP_D9(
      modRM(ModRMOpcode._0, "FLD", single_real),
      modRM(ModRMOpcode._2, "FST", single_real),
      modRM(ModRMOpcode._3, "FSTP", single_real),
      modRM(ModRMOpcode._4, "FLDENV", bytes_14_28),
      modRM(ModRMOpcode._5, "FLDCW", bytes_2),
      modRM(ModRMOpcode._6, "FSTENV", bytes_14_28),
      modRM(ModRMOpcode._7, "FSTCW", bytes_2)
  ),
  FP_DA(
      modRM(ModRMOpcode._0, "FIADD", short_integer),
      modRM(ModRMOpcode._1, "FIMUL", short_integer),
      modRM(ModRMOpcode._2, "FICOM", short_integer),
      modRM(ModRMOpcode._3, "FICOMP", short_integer),
      modRM(ModRMOpcode._4, "FISUB", short_integer),
      modRM(ModRMOpcode._5, "FISUBR", short_integer),
      modRM(ModRMOpcode._6, "FIDIV", short_integer),
      modRM(ModRMOpcode._7, "FIDIVR", short_integer)
  ),
  FP_DB(
      modRM(ModRMOpcode._0, "FILD", short_integer),
      modRM(ModRMOpcode._2, "FIST", short_integer),
      modRM(ModRMOpcode._3, "FISTP", short_integer),
      modRM(ModRMOpcode._5, "FLD", extended_real),
      modRM(ModRMOpcode._7, "FSTP", extended_real)
  ),
  FP_DC(
      modRM(ModRMOpcode._0, "FADD", double_real),
      modRM(ModRMOpcode._1, "FMUL", double_real),
      modRM(ModRMOpcode._2, "FCOM", double_real),
      modRM(ModRMOpcode._3, "FCOMP", double_real),
      modRM(ModRMOpcode._4, "FSUB", double_real),
      modRM(ModRMOpcode._5, "FSUBR", double_real),
      modRM(ModRMOpcode._6, "FDIV", double_real),
      modRM(ModRMOpcode._7, "FDIVR", double_real)
  ),
  FP_DD(
      modRM(ModRMOpcode._0, "FLD", double_real),
      modRM(ModRMOpcode._2, "FST", double_real),
      modRM(ModRMOpcode._3, "FSTP", double_real),
      modRM(ModRMOpcode._4, "FRSTOR", bytes_98_108),
      modRM(ModRMOpcode._6, "FSAVE", bytes_98_108),
      modRM(ModRMOpcode._7, "FSTSW", bytes_2)
  ),
  FP_DE(
      modRM(ModRMOpcode._0, "FIADD", word_integer),
      modRM(ModRMOpcode._1, "FIMUL", word_integer),
      modRM(ModRMOpcode._2, "FICOM", word_integer),
      modRM(ModRMOpcode._3, "FICOMP", word_integer),
      modRM(ModRMOpcode._4, "FISUB", word_integer),
      modRM(ModRMOpcode._5, "FISUBR", word_integer),
      modRM(ModRMOpcode._6, "FIDIV", word_integer),
      modRM(ModRMOpcode._7, "FIDIVR", word_integer)
  ),
  FP_DF(
      modRM(ModRMOpcode._0, "FILD", word_integer),
      modRM(ModRMOpcode._2, "FIST", word_integer),
      modRM(ModRMOpcode._3, "FISTP", word_integer),
      modRM(ModRMOpcode._4, "FBLD", packed_bcd),
      modRM(ModRMOpcode._5, "FILD", long_integer),
      modRM(ModRMOpcode._6, "FBSTP", packed_bcd),
      modRM(ModRMOpcode._7, "FISTP", long_integer)
  );

  private static ModRMDescription modRM(ModRMOpcode opcode, String name, Object... specifications) {
    return new ModRMDescription(opcode, name, Arrays.asList(specifications));
  }

  private final ModRMDescription[] _instructionDescriptions;

  private IA32ModRMGroup(ModRMDescription... instructionDescriptions) {
    _instructionDescriptions = instructionDescriptions;
  }

  public ModRMDescription getInstructionDescription(ModRMOpcode opcode) {
    for (ModRMDescription instructionDescription : _instructionDescriptions) {
      if (instructionDescription.opcode() == opcode) {
        return instructionDescription;
      }
    }
    return null;
  }
}
