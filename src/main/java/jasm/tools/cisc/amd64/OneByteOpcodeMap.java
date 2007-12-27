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
import jasm.x86.X86InstructionPrefix;
import jasm.tools.cisc.x86.X86RegisterOperandCode;
import static jasm.util.HexByte.*;

public final class OneByteOpcodeMap extends X86InstructionDescriptionCreator {

  private void create_low() {
    define(_00, "ADD", Eb, Gb);
    define(_01, "ADD", Ev, Gv);
    define(_02, "ADD", Gb, Eb);
    define(_03, "ADD", Gv, Ev);
    define(_04, "ADD", AL, Ib);
    define(_05, "ADD", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define(_10, "ADC", Eb, Gb);
    define(_11, "ADC", Ev, Gv);
    define(_12, "ADC", Gb, Eb);
    define(_13, "ADC", Gv, Ev);
    define(_14, "ADC", AL, Ib);
    define(_15, "ADC", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define(_20, "AND", Eb, Gb);
    define(_21, "AND", Ev, Gv);
    define(_22, "AND", Gb, Eb);
    define(_23, "AND", Gv, Ev);
    define(_24, "AND", AL, Ib);
    define(_25, "AND", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define(_30, "XOR", Eb, Gb);
    define(_31, "XOR", Ev, Gv);
    define(_32, "XOR", Gb, Eb);
    define(_33, "XOR", Gv, Ev);
    define(_34, "XOR", AL, Ib);
    define(_35, "XOR", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define(_50, "PUSH", Gov).setDefaultOperandSize(WordWidth.BITS_64);

    define(_63, "MOVSXD", Gq, Ed).requireOperandSize(WordWidth.BITS_64).beNotExternallyTestable(); // REX.W == 1, gas does not seem to know it
    define(_63, "MOVZXD", Gq, Ed).requireOperandSize(WordWidth.BITS_32).beNotExternallyTestable(); // REX.W == 0, we made this extra mnemonic up

    define(X86InstructionPrefix.SEG_FS.getValue(), "SEG_FS").beAPrefix();
    define(X86InstructionPrefix.SEG_GS.getValue(), "SEG_GS").beAPrefix();
    define(X86InstructionPrefix.OPERAND_SIZE.getValue(), "OPERAND_SIZE").beNotDisassemblable().beAPrefix();
    define(X86InstructionPrefix.ADDRESS_SIZE.getValue(), "ADDRESS_SIZE").beNotDisassemblable().beAPrefix();

    define(_70, "JO", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_71, "JNO", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_72, "JB", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_73, "JNB", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_74, "JZ", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_75, "JNZ", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_76, "JBE", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_77, "JNBE", Jb).setDefaultOperandSize(WordWidth.BITS_64);

    define(_80, GROUP_1, b, Eb.excludeExternalTestArguments(AL), Ib);
    define(_81, GROUP_1, v, Ev.excludeExternalTestArguments(AX, EAX, RAX), Iz.externalRange(0, Integer.MAX_VALUE));
    define(_83, GROUP_1, v, Ev, Ib).beNotExternallyTestable();
    define(_84, "TEST", Eb, Gb).revertExternalOperandOrdering();
    define(_85, "TEST", Ev, Gv).revertExternalOperandOrdering();
    define(_86, "XCHG", Eb, Gb);
    define(_87, "XCHG", Ev.excludeExternalTestArguments(AX, EAX, RAX), Gv.excludeExternalTestArguments(AX, EAX, RAX));

    define(_90, "NOP");
    define(_90, "XCHG", Gov.excludeDisassemblerTestArguments(AX, EAX, RAX), X86RegisterOperandCode.RAX).beNotExternallyTestable();

    define(_A0, "MOV", AL, Ob).beNotExternallyTestable();
    define(_A1, "MOV", X86RegisterOperandCode.RAX, Ov).beNotExternallyTestable();
    define(_A2, "MOV", Ob, AL).beNotExternallyTestable();
    define(_A3, "MOV", Ov, X86RegisterOperandCode.RAX).beNotExternallyTestable();
    define(_A4, "MOVS", Yb, Xb);
    define(_A5, "MOVS", Yv, Xv);
    define(_A6, "CMPS", Yb, Xb);
    define(_A7, "CMPS", Yv, Xv);

    define(_B0, "MOV", Gob, Ib);

    define(_C0, GROUP_2, b, Eb, Ib);
    define(_C1, GROUP_2, v, Ev, Ib);
    define(_C2, "RET", Iw).setDefaultOperandSize(WordWidth.BITS_64);
    define(_C3, "RET").setDefaultOperandSize(WordWidth.BITS_64);
    define(_C6, "MOV", b, Eb.excludeExternalTestArguments(AMD64GeneralRegister8.SYMBOLS), Ib);
    define(_C7, "MOV", v, Ev.excludeExternalTestArguments(AMD64GeneralRegister16.SYMBOLS, AMD64GeneralRegister32.SYMBOLS), Iz.externalRange(0, Integer.MAX_VALUE));

    define(_D0, GROUP_2, b, Eb, 1);
    define(_D1, GROUP_2, v, Ev, 1);
    define(_D2, GROUP_2, b, Eb, CL);
    define(_D3, GROUP_2, v, Ev, CL);
    define(_D7, "XLAT");

    define(_E0, "LOOPNE", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_E1, "LOOPE", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_E2, "LOOP", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_E3, "JECXZ", Jb).requireAddressSize(WordWidth.BITS_32);
    define(_E3, "JRCXZ", Jb).requireAddressSize(WordWidth.BITS_64);
    define(_E4, "IN", AL, Ib);
    define(_E5, "IN", X86RegisterOperandCode.EAX, Ib);
    define(_E6, "OUT", Ib, AL);
    define(_E7, "OUT", Ib, X86RegisterOperandCode.EAX);

    define(X86InstructionPrefix.LOCK.getValue(), "LOCK").beAPrefix();
    define(_F1, "INT", 1).beNotExternallyTestable(); // is this correct? - gas uses 0xCD
    define(X86InstructionPrefix.REPNE.getValue(), "REPNE").beAPrefix();
    define(X86InstructionPrefix.REPE.getValue(), "REPE").beAPrefix();
    define(_F4, "HLT");
    define(_F5, "CMC");
    define(_F6, GROUP_3b, b);
    define(_F7, GROUP_3v, v);
  }

  private void create_high() {
    define(_08, "OR", Eb, Gb);
    define(_09, "OR", Ev, Gv);
    define(_0A, "OR", Gb, Eb);
    define(_0B, "OR", Gv, Ev);
    define(_0C, "OR", AL, Ib);
    define(_0D, "OR", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define(_18, "SBB", Eb, Gb);
    define(_19, "SBB", Ev, Gv);
    define(_1A, "SBB", Gb, Eb);
    define(_1B, "SBB", Gv, Ev);
    define(_1C, "SBB", AL, Ib);
    define(_1D, "SBB", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define(_28, "SUB", Eb, Gb);
    define(_29, "SUB", Ev, Gv);
    define(_2A, "SUB", Gb, Eb);
    define(_2B, "SUB", Gv, Ev);
    define(_2C, "SUB", AL, Ib);
    define(_2D, "SUB", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));
    define(X86InstructionPrefix.SEG_CS.getValue(), "SEG_CS").beAPrefix();
    define(_2F, "DAS").beNotExternallyTestable(); // not defined in 64 bit mode and so 'as -64' rejects it

    define(_38, "CMP", Eb, Gb);
    define(_39, "CMP", Ev, Gv);
    define(_3A, "CMP", Gb, Eb);
    define(_3B, "CMP", Gv, Ev);
    define(_3C, "CMP", AL, Ib);
    define(_3D, "CMP", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define(_58, "POP", Gov).setDefaultOperandSize(WordWidth.BITS_64);

    define(_68, "PUSH", Iz.externalRange(Short.MAX_VALUE + 1, Integer.MAX_VALUE)).setDefaultOperandSize(WordWidth.BITS_64); // cannot test 16-bit version, because gas does not generate it
    define(_69, "IMUL", Gv, Ev, Iz.externalRange(0, Integer.MAX_VALUE));
    define(_6A, "PUSH", Ib.externalRange(0, 0x7f)).setDefaultOperandSize(WordWidth.BITS_64);
    define(_6B, "IMUL", Gv, Ev, Ib.externalRange(0, 0x7f));
    define(_6C, "INS", Yb);
    define(_6D, "INS", Yz);
    define(_6E, "OUTS", Xb);
    define(_6F, "OUTS", Xz);

    define(_78, "JS", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_79, "JNS", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_7A, "JP", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_7B, "JNP", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_7C, "JL", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_7D, "JNL", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_7E, "JLE", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_7F, "JNLE", Jb).setDefaultOperandSize(WordWidth.BITS_64);

    define(_88, "MOV", Eb, Gb.excludeExternalTestArguments(AL));
    define(_89, "MOV", Ev, Gv.excludeExternalTestArguments(AX, EAX));
    define(_8A, "MOV", Gb.excludeExternalTestArguments(AL), Eb);
    define(_8B, "MOV", Gv.excludeExternalTestArguments(AX, EAX), Ev);
    define(_8C, "MOV", Ew.excludeExternalTestArguments(AMD64GeneralRegister16.SYMBOLS), Sw); // gas may needlessly insert OPERAND_SIZE prefix
    define(_8D, "LEA", Gv, M);
    define(_8E, "MOV", Sw, Ew.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI)); // gas may needlessly insert OPERAND_SIZE prefix
    define(_8F, "POP", Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI)).setDefaultOperandSize(WordWidth.BITS_64);

    define(_98, "CWDE").requireOperandSize(WordWidth.BITS_32);
    define(_98, "CDQE").requireOperandSize(WordWidth.BITS_64);
    define(_99, "CDQ").requireOperandSize(WordWidth.BITS_32);
    define(_99, "CQO").requireOperandSize(WordWidth.BITS_64);
    define(_9B, "FWAIT"); // 'wait' is a Java keyword, so we use the alternate mnemonic, which is more accurately named anyhow
    define(_9C, "PUSHF", v, Fv).setDefaultOperandSize(WordWidth.BITS_64);
    define(_9D, "POPF", v, Fv).setDefaultOperandSize(WordWidth.BITS_64);
    define(_9E, "SAHF").beNotExternallyTestable(); // not available by gas, depends on CPUID
    define(_9F, "LAHF").beNotExternallyTestable(); // not available by gas, depends on CPUID

    define(_A8, "TEST", AL, Ib);
    define(_A9, "TEST", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));
    define(_AA, "STOS", Yb);
    define(_AB, "STOS", Yv);
    define(_AC, "LODS", Xb);
    define(_AD, "LODS", Xv);
    define(_AE, "SCAS", Yb);
    define(_AF, "SCAS", Yv);

    define(_B8, "MOV", Gov, Iv);

    define(_C8, "ENTER", Iw, Ib).setDefaultOperandSize(WordWidth.BITS_64).revertExternalOperandOrdering();
    define(_C9, "LEAVE").setDefaultOperandSize(WordWidth.BITS_64);
    define(_CA, "RETF", Iw).beNotExternallyTestable(); // gas does not support segments
    define(_CB, "RETF").beNotExternallyTestable(); // gas does not support segments
    define(_CC, "INT", 3);
    define(_CD, "INTb", Ib).setExternalName("int"); // suffix "b" to avoid clashing with Java keyword "int"
    define(_CF, "IRET");

    define(_D8, FP_D8);
    define(_D9, FP_D9);
    define(_DA, FP_DA);
    define(_DB, FP_DB);
    define(_DC, FP_DC);
    define(_DD, FP_DD);
    define(_DE, FP_DE);
    define(_DF, FP_DF);

    // We found out that '_66 _E8 ...' is NOT supported by our Opteron CPUs, despite footnote 6 on page 418 of the General Purpose Instruction Manual for AMD64:
    define(_E8, "CALL", Jz).setDefaultOperandSize(WordWidth.BITS_64).requireOperandSize(WordWidth.BITS_64); // disabling 0x66 prefix

    define(_E9, "JMP", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_EB, "JMP", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define(_EC, "IN", AL, DX);
    define(_ED, "IN", X86RegisterOperandCode.EAX, DX);
    define(_EE, "OUT", DX, AL);
    define(_EF, "OUT", DX, X86RegisterOperandCode.EAX);

    define(_F8, "CLC");
    define(_F9, "STC");
    define(_FA, "CLI");
    define(_FB, "STI");
    define(_FC, "CLD");
    define(_FD, "STD");
    define(_FE, GROUP_4, b, Eb);
    define(_FF, GROUP_5a);
    define(_FF, GROUP_5b).setDefaultOperandSize(WordWidth.BITS_64);
  }

  OneByteOpcodeMap() {
    super(AMD64Assembly.ASSEMBLY);
    create_low();
    create_high();
  }
}
