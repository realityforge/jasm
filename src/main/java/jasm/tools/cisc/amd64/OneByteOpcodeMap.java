/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.amd64;

import jasm.WordWidth;
import jasm.amd64.AMD64GeneralRegister16;
import static jasm.amd64.AMD64GeneralRegister16.*;
import jasm.amd64.AMD64GeneralRegister32;
import static jasm.amd64.AMD64GeneralRegister32.*;
import static jasm.amd64.AMD64GeneralRegister64.*;
import jasm.amd64.AMD64GeneralRegister8;
import static jasm.amd64.AMD64GeneralRegister8.*;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.*;
import static jasm.tools.cisc.x86.AddressingMethodCode.M;
import static jasm.tools.cisc.x86.OperandCode.*;
import static jasm.tools.cisc.x86.OperandTypeCode.b;
import static jasm.tools.cisc.x86.OperandTypeCode.v;
import jasm.tools.cisc.x86.X86InstructionDescriptionCreator;
import jasm.tools.cisc.x86.X86RegisterOperandCode;
import static jasm.util.HexByte.*;
import jasm.x86.X86InstructionPrefix;

public final class OneByteOpcodeMap extends X86InstructionDescriptionCreator {

  private void create_low() {
    define1B(_00, "ADD", Eb, Gb);
    define1B(_01, "ADD", Ev, Gv);
    define1B(_02, "ADD", Gb, Eb);
    define1B(_03, "ADD", Gv, Ev);
    define1B(_04, "ADD", AL, Ib);
    define1B(_05, "ADD", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_10, "ADC", Eb, Gb);
    define1B(_11, "ADC", Ev, Gv);
    define1B(_12, "ADC", Gb, Eb);
    define1B(_13, "ADC", Gv, Ev);
    define1B(_14, "ADC", AL, Ib);
    define1B(_15, "ADC", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_20, "AND", Eb, Gb);
    define1B(_21, "AND", Ev, Gv);
    define1B(_22, "AND", Gb, Eb);
    define1B(_23, "AND", Gv, Ev);
    define1B(_24, "AND", AL, Ib);
    define1B(_25, "AND", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_30, "XOR", Eb, Gb);
    define1B(_31, "XOR", Ev, Gv);
    define1B(_32, "XOR", Gb, Eb);
    define1B(_33, "XOR", Gv, Ev);
    define1B(_34, "XOR", AL, Ib);
    define1B(_35, "XOR", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_50, "PUSH", Gov).setDefaultOperandSize(WordWidth.BITS_64);

    define1B(_63, "MOVSXD", Gq, Ed).requireOperandSize(WordWidth.BITS_64).beNotExternallyTestable(); // REX.W == 1, gas does not seem to know it
    define1B(_63, "MOVZXD", Gq, Ed).requireOperandSize(WordWidth.BITS_32).beNotExternallyTestable(); // REX.W == 0, we made this extra mnemonic up

    define1B(X86InstructionPrefix.SEG_FS.getValue(), "SEG_FS").beAPrefix();
    define1B(X86InstructionPrefix.SEG_GS.getValue(), "SEG_GS").beAPrefix();
    define1B(X86InstructionPrefix.OPERAND_SIZE.getValue(), "OPERAND_SIZE").beAPrefix();
    define1B(X86InstructionPrefix.ADDRESS_SIZE.getValue(), "ADDRESS_SIZE").beAPrefix();

    define1B(_70, "JO", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_71, "JNO", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_72, "JB", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_73, "JNB", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_74, "JZ", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_75, "JNZ", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_76, "JBE", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_77, "JNBE", Jb).setDefaultOperandSize(WordWidth.BITS_64);

    define1B(_80, GROUP_1, b, Eb.excludeExternalTestArguments(AL), Ib);
    define1B(_81, GROUP_1, v, Ev.excludeExternalTestArguments(AX, EAX, RAX), Iz.externalRange(0, Integer.MAX_VALUE));
    define1B(_83, GROUP_1, v, Ev, Ib).beNotExternallyTestable();
    define1B(_84, "TEST", Eb, Gb).revertExternalOperandOrdering();
    define1B(_85, "TEST", Ev, Gv).revertExternalOperandOrdering();
    define1B(_86, "XCHG", Eb, Gb);
    define1B(_87, "XCHG", Ev.excludeExternalTestArguments(AX, EAX, RAX), Gv.excludeExternalTestArguments(AX, EAX, RAX));

    define1B(_90, "NOP");
    define1B(_90, "XCHG", Gov.excludeDisassemblerTestArguments(AX, EAX, RAX), X86RegisterOperandCode.RAX).beNotExternallyTestable();

    define1B(_A0, "MOV", AL, Ob).beNotExternallyTestable();
    define1B(_A1, "MOV", X86RegisterOperandCode.RAX, Ov).beNotExternallyTestable();
    define1B(_A2, "MOV", Ob, AL).beNotExternallyTestable();
    define1B(_A3, "MOV", Ov, X86RegisterOperandCode.RAX).beNotExternallyTestable();
    define1B(_A4, "MOVS", Yb, Xb);
    define1B(_A5, "MOVS", Yv, Xv);
    define1B(_A6, "CMPS", Yb, Xb);
    define1B(_A7, "CMPS", Yv, Xv);

    define1B(_B0, "MOV", Gob, Ib);

    define1B(_C0, GROUP_2, b, Eb, Ib);
    define1B(_C1, GROUP_2, v, Ev, Ib);
    define1B(_C2, "RET", Iw).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_C3, "RET").setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_C6, "MOV", b, Eb.excludeExternalTestArguments(AMD64GeneralRegister8.SYMBOLS), Ib);
    define1B(_C7, "MOV", v, Ev.excludeExternalTestArguments(AMD64GeneralRegister16.SYMBOLS, AMD64GeneralRegister32.SYMBOLS), Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_D0, GROUP_2, b, Eb, 1);
    define1B(_D1, GROUP_2, v, Ev, 1);
    define1B(_D2, GROUP_2, b, Eb, CL);
    define1B(_D3, GROUP_2, v, Ev, CL);
    define1B(_D7, "XLAT");

    define1B(_E0, "LOOPNE", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_E1, "LOOPE", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_E2, "LOOP", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_E3, "JECXZ", Jb).requireAddressSize(WordWidth.BITS_32);
    define1B(_E3, "JRCXZ", Jb).requireAddressSize(WordWidth.BITS_64);
    define1B(_E4, "IN", AL, Ib);
    define1B(_E5, "IN", X86RegisterOperandCode.EAX, Ib);
    define1B(_E6, "OUT", Ib, AL);
    define1B(_E7, "OUT", Ib, X86RegisterOperandCode.EAX);

    define1B(X86InstructionPrefix.LOCK.getValue(), "LOCK").beAPrefix();
    define1B(_F1, "INT", 1).beNotExternallyTestable(); // is this correct? - gas uses 0xCD
    define1B(X86InstructionPrefix.REPNE.getValue(), "REPNE").beAPrefix();
    define1B(X86InstructionPrefix.REPE.getValue(), "REPE").beAPrefix();
    define1B(_F4, "HLT");
    define1B(_F5, "CMC");
    define1B(_F6, GROUP_3b, b);
    define1B(_F7, GROUP_3v, v);
  }

  private void create_high() {
    define1B(_08, "OR", Eb, Gb);
    define1B(_09, "OR", Ev, Gv);
    define1B(_0A, "OR", Gb, Eb);
    define1B(_0B, "OR", Gv, Ev);
    define1B(_0C, "OR", AL, Ib);
    define1B(_0D, "OR", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_18, "SBB", Eb, Gb);
    define1B(_19, "SBB", Ev, Gv);
    define1B(_1A, "SBB", Gb, Eb);
    define1B(_1B, "SBB", Gv, Ev);
    define1B(_1C, "SBB", AL, Ib);
    define1B(_1D, "SBB", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_28, "SUB", Eb, Gb);
    define1B(_29, "SUB", Ev, Gv);
    define1B(_2A, "SUB", Gb, Eb);
    define1B(_2B, "SUB", Gv, Ev);
    define1B(_2C, "SUB", AL, Ib);
    define1B(_2D, "SUB", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));
    define1B(X86InstructionPrefix.SEG_CS.getValue(), "SEG_CS").beAPrefix();
    define1B(_2F, "DAS").beNotExternallyTestable(); // not defined in 64 bit mode and so 'as -64' rejects it

    define1B(_38, "CMP", Eb, Gb);
    define1B(_39, "CMP", Ev, Gv);
    define1B(_3A, "CMP", Gb, Eb);
    define1B(_3B, "CMP", Gv, Ev);
    define1B(_3C, "CMP", AL, Ib);
    define1B(_3D, "CMP", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_58, "POP", Gov).setDefaultOperandSize(WordWidth.BITS_64);

    define1B(_68, "PUSH", Iz.externalRange(Short.MAX_VALUE + 1, Integer.MAX_VALUE)).setDefaultOperandSize(WordWidth.BITS_64); // cannot test 16-bit version, because gas does not generate it
    define1B(_69, "IMUL", Gv, Ev, Iz.externalRange(0, Integer.MAX_VALUE));
    define1B(_6A, "PUSH", Ib.externalRange(0, 0x7f)).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_6B, "IMUL", Gv, Ev, Ib.externalRange(0, 0x7f));
    define1B(_6C, "INS", Yb);
    define1B(_6D, "INS", Yz);
    define1B(_6E, "OUTS", Xb);
    define1B(_6F, "OUTS", Xz);

    define1B(_78, "JS", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_79, "JNS", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7A, "JP", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7B, "JNP", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7C, "JL", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7D, "JNL", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7E, "JLE", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7F, "JNLE", Jb).setDefaultOperandSize(WordWidth.BITS_64);

    define1B(_88, "MOV", Eb, Gb.excludeExternalTestArguments(AL));
    define1B(_89, "MOV", Ev, Gv.excludeExternalTestArguments(AX, EAX));
    define1B(_8A, "MOV", Gb.excludeExternalTestArguments(AL), Eb);
    define1B(_8B, "MOV", Gv.excludeExternalTestArguments(AX, EAX), Ev);
    define1B(_8C, "MOV", Ew.excludeExternalTestArguments(AMD64GeneralRegister16.SYMBOLS), Sw); // gas may needlessly insert OPERAND_SIZE prefix
    define1B(_8D, "LEA", Gv, M);
    define1B(_8E, "MOV", Sw, Ew.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI)); // gas may needlessly insert OPERAND_SIZE prefix
    define1B(_8F, "POP", Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI)).setDefaultOperandSize(WordWidth.BITS_64);

    define1B(_98, "CWDE").requireOperandSize(WordWidth.BITS_32);
    define1B(_98, "CDQE").requireOperandSize(WordWidth.BITS_64);
    define1B(_99, "CDQ").requireOperandSize(WordWidth.BITS_32);
    define1B(_99, "CQO").requireOperandSize(WordWidth.BITS_64);
    define1B(_9B, "FWAIT"); // 'wait' is a Java keyword, so we use the alternate mnemonic, which is more accurately named anyhow
    define1B(_9C, "PUSHF", v, Fv).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_9D, "POPF", v, Fv).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_9E, "SAHF").beNotExternallyTestable(); // not available by gas, depends on CPUID
    define1B(_9F, "LAHF").beNotExternallyTestable(); // not available by gas, depends on CPUID

    define1B(_A8, "TEST", AL, Ib);
    define1B(_A9, "TEST", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));
    define1B(_AA, "STOS", Yb);
    define1B(_AB, "STOS", Yv);
    define1B(_AC, "LODS", Xb);
    define1B(_AD, "LODS", Xv);
    define1B(_AE, "SCAS", Yb);
    define1B(_AF, "SCAS", Yv);

    define1B(_B8, "MOV", Gov, Iv);

    define1B(_C8, "ENTER", Iw, Ib).setDefaultOperandSize(WordWidth.BITS_64).revertExternalOperandOrdering();
    define1B(_C9, "LEAVE").setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_CA, "RETF", Iw).beNotExternallyTestable(); // gas does not support segments
    define1B(_CB, "RETF").beNotExternallyTestable(); // gas does not support segments
    define1B(_CC, "INT", 3);
    define1B(_CD, "INTb", Ib).setExternalName("int"); // suffix "b" to avoid clashing with Java keyword "int"
    define1B(_CF, "IRET");

    define1B(_D8, FP_D8);
    define1B(_D9, FP_D9);
    define1B(_DA, FP_DA);
    define1B(_DB, FP_DB);
    define1B(_DC, FP_DC);
    define1B(_DD, FP_DD);
    define1B(_DE, FP_DE);
    define1B(_DF, FP_DF);

    // We found out that '_66 _E8 ...' is NOT supported by our Opteron CPUs, despite footnote 6 on page 418 of the General Purpose Instruction Manual for AMD64:
    define1B(_E8, "CALL", Jz).setDefaultOperandSize(WordWidth.BITS_64).requireOperandSize(WordWidth.BITS_64); // disabling 0x66 prefix

    define1B(_E9, "JMP", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_EB, "JMP", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_EC, "IN", AL, DX);
    define1B(_ED, "IN", X86RegisterOperandCode.EAX, DX);
    define1B(_EE, "OUT", DX, AL);
    define1B(_EF, "OUT", DX, X86RegisterOperandCode.EAX);

    define1B(_F8, "CLC");
    define1B(_F9, "STC");
    define1B(_FA, "CLI");
    define1B(_FB, "STI");
    define1B(_FC, "CLD");
    define1B(_FD, "STD");
    define1B(_FE, GROUP_4, b, Eb);
    define1B(_FF, GROUP_5a);
    define1B(_FF, GROUP_5b).setDefaultOperandSize(WordWidth.BITS_64);
  }

  OneByteOpcodeMap() {
    super(AMD64Assembly.ASSEMBLY);
    create_low();
    create_high();
  }
}
