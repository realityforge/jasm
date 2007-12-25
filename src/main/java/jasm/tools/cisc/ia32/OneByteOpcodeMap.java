/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.ia32;

import jasm.WordWidth;
import static jasm.ia32.IA32GeneralRegister16.AX;
import static jasm.ia32.IA32GeneralRegister16.BP;
import static jasm.ia32.IA32GeneralRegister16.BX;
import static jasm.ia32.IA32GeneralRegister16.CX;
import static jasm.ia32.IA32GeneralRegister16.DI;
import static jasm.ia32.IA32GeneralRegister16.DX;
import static jasm.ia32.IA32GeneralRegister16.SI;
import static jasm.ia32.IA32GeneralRegister16.SP;
import static jasm.ia32.IA32GeneralRegister32.EAX;
import static jasm.ia32.IA32GeneralRegister32.EBP;
import static jasm.ia32.IA32GeneralRegister32.EBX;
import static jasm.ia32.IA32GeneralRegister32.ECX;
import static jasm.ia32.IA32GeneralRegister32.EDI;
import static jasm.ia32.IA32GeneralRegister32.EDX;
import static jasm.ia32.IA32GeneralRegister32.ESI;
import static jasm.ia32.IA32GeneralRegister32.ESP;
import static jasm.ia32.IA32GeneralRegister8.AH;
import static jasm.ia32.IA32GeneralRegister8.AL;
import static jasm.ia32.IA32GeneralRegister8.BH;
import static jasm.ia32.IA32GeneralRegister8.BL;
import static jasm.ia32.IA32GeneralRegister8.CH;
import static jasm.ia32.IA32GeneralRegister8.CL;
import static jasm.ia32.IA32GeneralRegister8.DH;
import static jasm.ia32.IA32GeneralRegister8.DL;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.FP_D8;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.FP_D9;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.FP_DA;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.FP_DB;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.FP_DC;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.FP_DD;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.FP_DE;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.FP_DF;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_1;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_2;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_3b;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_3v;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_4;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_5;
import static jasm.tools.cisc.x86.AddressingMethodCode.M;
import static jasm.tools.cisc.x86.OperandCode.Ap;
import static jasm.tools.cisc.x86.OperandCode.Eb;
import static jasm.tools.cisc.x86.OperandCode.Ev;
import static jasm.tools.cisc.x86.OperandCode.Ew;
import static jasm.tools.cisc.x86.OperandCode.Fv;
import static jasm.tools.cisc.x86.OperandCode.Gb;
import static jasm.tools.cisc.x86.OperandCode.Gv;
import static jasm.tools.cisc.x86.OperandCode.Gw;
import static jasm.tools.cisc.x86.OperandCode.Ib;
import static jasm.tools.cisc.x86.OperandCode.Iv;
import static jasm.tools.cisc.x86.OperandCode.Iw;
import static jasm.tools.cisc.x86.OperandCode.Jb;
import static jasm.tools.cisc.x86.OperandCode.Jv;
import static jasm.tools.cisc.x86.OperandCode.Ma;
import static jasm.tools.cisc.x86.OperandCode.Mp;
import static jasm.tools.cisc.x86.OperandCode.Nb;
import static jasm.tools.cisc.x86.OperandCode.Nv;
import static jasm.tools.cisc.x86.OperandCode.Ob;
import static jasm.tools.cisc.x86.OperandCode.Ov;
import static jasm.tools.cisc.x86.OperandCode.Sw;
import static jasm.tools.cisc.x86.OperandCode.Xb;
import static jasm.tools.cisc.x86.OperandCode.Xv;
import static jasm.tools.cisc.x86.OperandCode.Yb;
import static jasm.tools.cisc.x86.OperandCode.Yv;
import static jasm.tools.cisc.x86.OperandTypeCode.b;
import static jasm.tools.cisc.x86.OperandTypeCode.v;
import static jasm.tools.cisc.x86.RegisterOperandCode.eAX;
import jasm.tools.cisc.x86.X86InstructionDescriptionCreator;
import static jasm.tools.cisc.x86.X86Opcode.ADDRESS_SIZE;
import static jasm.tools.cisc.x86.X86Opcode.FWAIT;
import static jasm.tools.cisc.x86.X86Opcode.LOCK;
import static jasm.tools.cisc.x86.X86Opcode.OPERAND_SIZE;
import static jasm.tools.cisc.x86.X86Opcode.REPE;
import static jasm.tools.cisc.x86.X86Opcode.REPNE;
import static jasm.tools.cisc.x86.X86Opcode.SEG_CS;
import static jasm.tools.cisc.x86.X86Opcode.SEG_DS;
import static jasm.tools.cisc.x86.X86Opcode.SEG_ES;
import static jasm.tools.cisc.x86.X86Opcode.SEG_FS;
import static jasm.tools.cisc.x86.X86Opcode.SEG_GS;
import static jasm.tools.cisc.x86.X86Opcode.SEG_SS;
import static jasm.util.HexByte._00;
import static jasm.util.HexByte._01;
import static jasm.util.HexByte._02;
import static jasm.util.HexByte._03;
import static jasm.util.HexByte._04;
import static jasm.util.HexByte._05;
import static jasm.util.HexByte._06;
import static jasm.util.HexByte._07;
import static jasm.util.HexByte._08;
import static jasm.util.HexByte._09;
import static jasm.util.HexByte._0A;
import static jasm.util.HexByte._0B;
import static jasm.util.HexByte._0C;
import static jasm.util.HexByte._0D;
import static jasm.util.HexByte._0E;
import static jasm.util.HexByte._10;
import static jasm.util.HexByte._11;
import static jasm.util.HexByte._12;
import static jasm.util.HexByte._13;
import static jasm.util.HexByte._14;
import static jasm.util.HexByte._15;
import static jasm.util.HexByte._16;
import static jasm.util.HexByte._17;
import static jasm.util.HexByte._18;
import static jasm.util.HexByte._19;
import static jasm.util.HexByte._1A;
import static jasm.util.HexByte._1B;
import static jasm.util.HexByte._1C;
import static jasm.util.HexByte._1D;
import static jasm.util.HexByte._1E;
import static jasm.util.HexByte._1F;
import static jasm.util.HexByte._20;
import static jasm.util.HexByte._21;
import static jasm.util.HexByte._22;
import static jasm.util.HexByte._23;
import static jasm.util.HexByte._24;
import static jasm.util.HexByte._25;
import static jasm.util.HexByte._27;
import static jasm.util.HexByte._28;
import static jasm.util.HexByte._29;
import static jasm.util.HexByte._2A;
import static jasm.util.HexByte._2B;
import static jasm.util.HexByte._2C;
import static jasm.util.HexByte._2D;
import static jasm.util.HexByte._2F;
import static jasm.util.HexByte._30;
import static jasm.util.HexByte._31;
import static jasm.util.HexByte._32;
import static jasm.util.HexByte._33;
import static jasm.util.HexByte._34;
import static jasm.util.HexByte._35;
import static jasm.util.HexByte._37;
import static jasm.util.HexByte._38;
import static jasm.util.HexByte._39;
import static jasm.util.HexByte._3A;
import static jasm.util.HexByte._3B;
import static jasm.util.HexByte._3C;
import static jasm.util.HexByte._3D;
import static jasm.util.HexByte._3F;
import static jasm.util.HexByte._40;
import static jasm.util.HexByte._48;
import static jasm.util.HexByte._50;
import static jasm.util.HexByte._58;
import static jasm.util.HexByte._60;
import static jasm.util.HexByte._61;
import static jasm.util.HexByte._62;
import static jasm.util.HexByte._63;
import static jasm.util.HexByte._68;
import static jasm.util.HexByte._69;
import static jasm.util.HexByte._6A;
import static jasm.util.HexByte._6B;
import static jasm.util.HexByte._6C;
import static jasm.util.HexByte._6D;
import static jasm.util.HexByte._6E;
import static jasm.util.HexByte._6F;
import static jasm.util.HexByte._70;
import static jasm.util.HexByte._71;
import static jasm.util.HexByte._72;
import static jasm.util.HexByte._73;
import static jasm.util.HexByte._74;
import static jasm.util.HexByte._75;
import static jasm.util.HexByte._76;
import static jasm.util.HexByte._77;
import static jasm.util.HexByte._78;
import static jasm.util.HexByte._79;
import static jasm.util.HexByte._7A;
import static jasm.util.HexByte._7B;
import static jasm.util.HexByte._7C;
import static jasm.util.HexByte._7D;
import static jasm.util.HexByte._7E;
import static jasm.util.HexByte._7F;
import static jasm.util.HexByte._80;
import static jasm.util.HexByte._81;
import static jasm.util.HexByte._82;
import static jasm.util.HexByte._83;
import static jasm.util.HexByte._84;
import static jasm.util.HexByte._85;
import static jasm.util.HexByte._86;
import static jasm.util.HexByte._87;
import static jasm.util.HexByte._88;
import static jasm.util.HexByte._89;
import static jasm.util.HexByte._8A;
import static jasm.util.HexByte._8B;
import static jasm.util.HexByte._8C;
import static jasm.util.HexByte._8D;
import static jasm.util.HexByte._8E;
import static jasm.util.HexByte._8F;
import static jasm.util.HexByte._90;
import static jasm.util.HexByte._98;
import static jasm.util.HexByte._99;
import static jasm.util.HexByte._9A;
import static jasm.util.HexByte._9C;
import static jasm.util.HexByte._9D;
import static jasm.util.HexByte._9E;
import static jasm.util.HexByte._9F;
import static jasm.util.HexByte._A0;
import static jasm.util.HexByte._A1;
import static jasm.util.HexByte._A2;
import static jasm.util.HexByte._A3;
import static jasm.util.HexByte._A4;
import static jasm.util.HexByte._A5;
import static jasm.util.HexByte._A6;
import static jasm.util.HexByte._A7;
import static jasm.util.HexByte._A8;
import static jasm.util.HexByte._A9;
import static jasm.util.HexByte._AA;
import static jasm.util.HexByte._AB;
import static jasm.util.HexByte._AC;
import static jasm.util.HexByte._AD;
import static jasm.util.HexByte._AE;
import static jasm.util.HexByte._AF;
import static jasm.util.HexByte._B0;
import static jasm.util.HexByte._B8;
import static jasm.util.HexByte._C0;
import static jasm.util.HexByte._C1;
import static jasm.util.HexByte._C2;
import static jasm.util.HexByte._C3;
import static jasm.util.HexByte._C4;
import static jasm.util.HexByte._C5;
import static jasm.util.HexByte._C6;
import static jasm.util.HexByte._C7;
import static jasm.util.HexByte._C8;
import static jasm.util.HexByte._C9;
import static jasm.util.HexByte._CA;
import static jasm.util.HexByte._CB;
import static jasm.util.HexByte._CC;
import static jasm.util.HexByte._CD;
import static jasm.util.HexByte._CE;
import static jasm.util.HexByte._CF;
import static jasm.util.HexByte._D0;
import static jasm.util.HexByte._D1;
import static jasm.util.HexByte._D2;
import static jasm.util.HexByte._D3;
import static jasm.util.HexByte._D4;
import static jasm.util.HexByte._D5;
import static jasm.util.HexByte._D6;
import static jasm.util.HexByte._D7;
import static jasm.util.HexByte._D8;
import static jasm.util.HexByte._D9;
import static jasm.util.HexByte._DA;
import static jasm.util.HexByte._DB;
import static jasm.util.HexByte._DC;
import static jasm.util.HexByte._DD;
import static jasm.util.HexByte._DE;
import static jasm.util.HexByte._DF;
import static jasm.util.HexByte._E0;
import static jasm.util.HexByte._E1;
import static jasm.util.HexByte._E2;
import static jasm.util.HexByte._E3;
import static jasm.util.HexByte._E4;
import static jasm.util.HexByte._E5;
import static jasm.util.HexByte._E6;
import static jasm.util.HexByte._E7;
import static jasm.util.HexByte._E8;
import static jasm.util.HexByte._E9;
import static jasm.util.HexByte._EA;
import static jasm.util.HexByte._EB;
import static jasm.util.HexByte._EC;
import static jasm.util.HexByte._ED;
import static jasm.util.HexByte._EE;
import static jasm.util.HexByte._EF;
import static jasm.util.HexByte._F4;
import static jasm.util.HexByte._F5;
import static jasm.util.HexByte._F6;
import static jasm.util.HexByte._F7;
import static jasm.util.HexByte._F8;
import static jasm.util.HexByte._F9;
import static jasm.util.HexByte._FA;
import static jasm.util.HexByte._FB;
import static jasm.util.HexByte._FC;
import static jasm.util.HexByte._FD;
import static jasm.util.HexByte._FE;
import static jasm.util.HexByte._FF;
import static jasm.x86.SegmentRegister.CS;
import static jasm.x86.SegmentRegister.DS;
import static jasm.x86.SegmentRegister.ES;
import static jasm.x86.SegmentRegister.SS;

/**
 * Representation of the ...
 */
final class OneByteOpcodeMap extends X86InstructionDescriptionCreator {

  private void create_low() {
    define(_00, "ADD", Eb, Gb);
    define(_01, "ADD", Ev, Gv);
    define(_02, "ADD", Gb, Eb);
    define(_03, "ADD", Gv, Ev);
    define(_04, "ADD", AL, Ib);
    define(_05, "ADD", eAX, Iv);
    define(_06, "PUSH", ES);
    define(_07, "POP", ES);

    define(_10, "ADC", Eb, Gb);
    define(_11, "ADC", Ev, Gv);
    define(_12, "ADC", Gb, Eb);
    define(_13, "ADC", Gv, Ev);
    define(_14, "ADC", AL, Ib);
    define(_15, "ADC", eAX, Iv);
    define(_16, "PUSH", SS);
    define(_17, "POP", SS);

    define(_20, "AND", Eb, Gb);
    define(_21, "AND", Ev, Gv);
    define(_22, "AND", Gb, Eb);
    define(_23, "AND", Gv, Ev);
    define(_24, "AND", AL, Ib);
    define(_25, "AND", eAX, Iv);
    define(SEG_ES, "SEG_ES").beNotExternallyTestable(); // prefix
    define(_27, "DAA");

    define(_30, "XOR", Eb, Gb);
    define(_31, "XOR", Ev, Gv);
    define(_32, "XOR", Gb, Eb);
    define(_33, "XOR", Gv, Ev);
    define(_34, "XOR", AL, Ib);
    define(_35, "XOR", eAX, Iv);
    define(SEG_SS, "SEG_SS").beNotExternallyTestable(); // prefix
    define(_37, "AAA");

    define(_40, "INC", Nv);

    define(_50, "PUSH", Nv);

    define(_60, "PUSHA").requireOperandSize(WordWidth.BITS_16).beNotExternallyTestable(); // gas does not emit the operand size prefix
    define(_60, "PUSHAD").requireOperandSize(WordWidth.BITS_32).setExternalName("pusha");
    define(_61, "POPA").requireOperandSize(WordWidth.BITS_16).beNotExternallyTestable(); // gas does not emit the operand size prefix
    define(_61, "POPAD").requireOperandSize(WordWidth.BITS_32).setExternalName("popa");
    define(_62, "BOUND", Gv, Ma).revertExternalOperandOrdering();
    define(_63, "ARPL", Ew, Gw);
    define(SEG_FS, "SEG_FS").beNotExternallyTestable(); // prefix
    define(SEG_GS, "SEG_GS").beNotExternallyTestable(); // prefix
    define(OPERAND_SIZE, "OPERAND_SIZE").beNotDisassemblable().beNotExternallyTestable(); // prefix
    define(ADDRESS_SIZE, "ADDRESS_SIZE").beNotDisassemblable().beNotExternallyTestable(); // prefix

    define(_70, "JO", Jb);
    define(_71, "JNO", Jb);
    define(_72, "JB", Jb);
    define(_73, "JNB", Jb);
    define(_74, "JZ", Jb);
    define(_75, "JNZ", Jb);
    define(_76, "JBE", Jb);
    define(_77, "JNBE", Jb);

    define(_80, GROUP_1, b, Eb.excludeExternalTestArguments(AL), Ib);
    define(_81, GROUP_1, v, Ev.excludeExternalTestArguments(AX, EAX), Iv);
    define(_82, GROUP_1, b, Eb.excludeExternalTestArguments(AL), Ib);
    define(_83, GROUP_1, v, Ev, Ib).beNotExternallyTestable();
    define(_84, "TEST", Eb, Gb).revertExternalOperandOrdering();
    define(_85, "TEST", Ev, Gv).revertExternalOperandOrdering();
    define(_86, "XCHG", Eb, Gb);
    define(_87, "XCHG", Ev.excludeExternalTestArguments(AX, EAX), Gv.excludeExternalTestArguments(AX, EAX));

    define(_90, "NOP");
    define(_90, "XCHG", Nv.excludeDisassemblerTestArguments(AX, EAX), eAX);

    define(_A0, "MOV", AL, Ob);
    define(_A1, "MOV", eAX, Ov);
    define(_A2, "MOV", Ob, AL);
    define(_A3, "MOV", Ov, eAX);
    define(_A4, "MOVS", Yb, Xb);
    define(_A5, "MOVS", Yv, Xv);
    define(_A6, "CMPS", Yb, Xb);
    define(_A7, "CMPS", Yv, Xv);

    define(_B0, "MOV", Nb, Ib);

    define(_C0, GROUP_2, b, Eb, Ib);
    define(_C1, GROUP_2, v, Ev, Ib);
    define(_C2, "RET", Iw);
    define(_C3, "RET");
    define(_C4, "LES", Gv, Mp);
    define(_C5, "LDS", Gv, Mp);
    define(_C6, "MOV", b, Eb.excludeExternalTestArguments(AL, CL, DL, BL, AH, CH, DH, BH), Ib);
    define(_C7, "MOV", v, Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI, EAX, ECX, EDX, EBX, ESP, EBP, ESI, EDI), Iv);

    define(_D0, GROUP_2, b, Eb, 1);
    define(_D1, GROUP_2, v, Ev, 1);
    define(_D2, GROUP_2, b, Eb, CL);
    define(_D3, GROUP_2, v, Ev, CL);
    define(_D4, "AAM", Ib.range(0, 0x7f));
    define(_D5, "AAD", Ib.range(0, 0x7f));
    define(_D6, "SALC").beNotExternallyTestable(); // missing in gas (undocumented by Intel)
    define(_D7, "XLAT");

    define(_E0, "LOOPNE", Jb);
    define(_E1, "LOOPE", Jb);
    define(_E2, "LOOP", Jb);
    define(_E3, "JCXZ", Jb).requireAddressSize(WordWidth.BITS_16);
    define(_E3, "JECXZ", Jb).requireAddressSize(WordWidth.BITS_32);
    define(_E4, "IN", AL, Ib);
    define(_E5, "IN", eAX, Ib);
    define(_E6, "OUT", Ib, AL);
    define(_E7, "OUT", Ib, eAX);

    define(LOCK, "LOCK").beNotExternallyTestable(); // prefix
    define(REPNE, "REPNE").beNotExternallyTestable(); // prefix
    define(REPE, "REPE").beNotExternallyTestable(); // prefix
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
    define(_0D, "OR", eAX, Iv);
    define(_0E, "PUSH", CS);

    define(_18, "SBB", Eb, Gb);
    define(_19, "SBB", Ev, Gv);
    define(_1A, "SBB", Gb, Eb);
    define(_1B, "SBB", Gv, Ev);
    define(_1C, "SBB", AL, Ib);
    define(_1D, "SBB", eAX, Iv);
    define(_1E, "PUSH", DS);
    define(_1F, "POP", DS);

    define(_28, "SUB", Eb, Gb);
    define(_29, "SUB", Ev, Gv);
    define(_2A, "SUB", Gb, Eb);
    define(_2B, "SUB", Gv, Ev);
    define(_2C, "SUB", AL, Ib);
    define(_2D, "SUB", eAX, Iv);
    define(SEG_CS, "SEG_CS").beNotExternallyTestable(); // prefix
    define(_2F, "DAS");

    define(_38, "CMP", Eb, Gb);
    define(_39, "CMP", Ev, Gv);
    define(_3A, "CMP", Gb, Eb);
    define(_3B, "CMP", Gv, Ev);
    define(_3C, "CMP", AL, Ib);
    define(_3D, "CMP", eAX, Iv);
    define(SEG_DS, "SEG_DS").beNotExternallyTestable(); // prefix
    define(_3F, "AAS");

    define(_48, "DEC", Nv);

    define(_58, "POP", Nv);

    define(_68, "PUSH", Iv);
    define(_69, "IMUL", Gv, Ev, Iv);
    define(_6A, "PUSH", Ib.externalRange(0, 0x7f));
    define(_6B, "IMUL", Gv, Ev, Ib.externalRange(0, 0x7f));
    define(_6C, "INS", Yb);
    define(_6D, "INS", Yv);
    define(_6E, "OUTS", Xb);
    define(_6F, "OUTS", Xv);

    define(_78, "JS", Jb);
    define(_79, "JNS", Jb);
    define(_7A, "JP", Jb);
    define(_7B, "JNP", Jb);
    define(_7C, "JL", Jb);
    define(_7D, "JNL", Jb);
    define(_7E, "JLE", Jb);
    define(_7F, "JNLE", Jb);

    define(_88, "MOV", Eb, Gb.excludeExternalTestArguments(AL));
    define(_89, "MOV", Ev, Gv.excludeExternalTestArguments(AX, EAX));
    define(_8A, "MOV", Gb.excludeExternalTestArguments(AL), Eb);
    define(_8B, "MOV", Gv.excludeExternalTestArguments(AX, EAX), Ev);
    define(_8C, "MOV", Ew.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI), Sw); // gas may needlessly insert OPERAND_SIZE prefix
    define(_8D, "LEA", Gv, M);
    define(_8E, "MOV", Sw, Ew.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI)); // gas may needlessly insert OPERAND_SIZE prefix
    define(_8F, "POP", Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI, EAX, ECX, EDX, EBX, ESP, EBP, ESI, EDI));

    define(_98, "CBW").requireOperandSize(WordWidth.BITS_16);
    define(_98, "CWDE").requireOperandSize(WordWidth.BITS_32);
    define(_99, "CWD").requireOperandSize(WordWidth.BITS_16);
    define(_99, "CDQ").requireOperandSize(WordWidth.BITS_32);
    define(_9A, "CALL", Ap);
    define(FWAIT, "FWAIT"); // 'wait' is a Java keyword, so we use the alternate mnemonic, which is more accurately named anyhow
    define(_9C, "PUSHF", v, Fv);
    define(_9D, "POPF", v, Fv);
    define(_9E, "SAHF");
    define(_9F, "LAHF");

    define(_A8, "TEST", AL, Ib);
    define(_A9, "TEST", eAX, Iv);
    define(_AA, "STOS", Yb);
    define(_AB, "STOS", Yv);
    define(_AC, "LODS", Xb);
    define(_AD, "LODS", Xv);
    define(_AE, "SCAS", Yb);
    define(_AF, "SCAS", Yv);

    define(_B8, "MOV", Nv, Iv);

    define(_C8, "ENTER", Iw, Ib).revertExternalOperandOrdering();
    define(_C9, "LEAVE");
    define(_CA, "RETF", Iw).beNotExternallyTestable(); // gas does not support segments
    define(_CB, "RETF").beNotExternallyTestable(); // gas does not support segments
    define(_CC, "INT", 3);
    define(_CD, "INTb", Ib).setExternalName("int"); // suffix "b" to avoid clashing with Java keyword "int"
    define(_CE, "INTO");
    define(_CF, "IRET");

    define(_D8, FP_D8);
    define(_D9, FP_D9);
    define(_DA, FP_DA);
    define(_DB, FP_DB);
    define(_DC, FP_DC);
    define(_DD, FP_DD);
    define(_DE, FP_DE);
    define(_DF, FP_DF);

    define(_E8, "CALL", Jv);
    define(_E9, "JMP", Jv);
    define(_EA, "JMP", Ap);
    define(_EB, "JMP", Jb);
    define(_EC, "IN", AL, DX);
    define(_ED, "IN", eAX, DX);
    define(_EE, "OUT", DX, AL);
    define(_EF, "OUT", DX, eAX);

    define(_F8, "CLC");
    define(_F9, "STC");
    define(_FA, "CLI");
    define(_FB, "STI");
    define(_FC, "CLD");
    define(_FD, "STD");
    define(_FE, GROUP_4, b, Eb);
    define(_FF, GROUP_5);
  }

  OneByteOpcodeMap() {
    super(IA32Assembly.ASSEMBLY);
    create_low();
    create_high();
  }
}
