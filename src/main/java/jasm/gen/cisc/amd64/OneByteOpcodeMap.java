/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.amd64;

import jasm.amd64.AMD64GeneralRegister16;
import static jasm.amd64.AMD64GeneralRegister16.AX;
import static jasm.amd64.AMD64GeneralRegister16.BP;
import static jasm.amd64.AMD64GeneralRegister16.BX;
import static jasm.amd64.AMD64GeneralRegister16.CX;
import static jasm.amd64.AMD64GeneralRegister16.DI;
import static jasm.amd64.AMD64GeneralRegister16.DX;
import static jasm.amd64.AMD64GeneralRegister16.SI;
import static jasm.amd64.AMD64GeneralRegister16.SP;
import jasm.amd64.AMD64GeneralRegister32;
import static jasm.amd64.AMD64GeneralRegister32.EAX;
import static jasm.amd64.AMD64GeneralRegister64.RAX;
import jasm.amd64.AMD64GeneralRegister8;
import static jasm.amd64.AMD64GeneralRegister8.AL;
import static jasm.amd64.AMD64GeneralRegister8.CL;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.FP_D8;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.FP_D9;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.FP_DA;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.FP_DB;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.FP_DC;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.FP_DD;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.FP_DE;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.FP_DF;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.GROUP_1;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.GROUP_2;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.GROUP_3b;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.GROUP_3v;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.GROUP_4;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.GROUP_5a;
import static jasm.gen.cisc.amd64.AMD64ModRMGroup.GROUP_5b;
import static jasm.gen.cisc.x86.AddressingMethodCode.M;
import static jasm.gen.cisc.x86.OperandCode.Eb;
import static jasm.gen.cisc.x86.OperandCode.Ed;
import static jasm.gen.cisc.x86.OperandCode.Ev;
import static jasm.gen.cisc.x86.OperandCode.Ew;
import static jasm.gen.cisc.x86.OperandCode.Fv;
import static jasm.gen.cisc.x86.OperandCode.Gb;
import static jasm.gen.cisc.x86.OperandCode.Gq;
import static jasm.gen.cisc.x86.OperandCode.Gv;
import static jasm.gen.cisc.x86.OperandCode.Ib;
import static jasm.gen.cisc.x86.OperandCode.Iv;
import static jasm.gen.cisc.x86.OperandCode.Iw;
import static jasm.gen.cisc.x86.OperandCode.Iz;
import static jasm.gen.cisc.x86.OperandCode.Jb;
import static jasm.gen.cisc.x86.OperandCode.Jz;
import static jasm.gen.cisc.x86.OperandCode.Nb;
import static jasm.gen.cisc.x86.OperandCode.Nv;
import static jasm.gen.cisc.x86.OperandCode.Ob;
import static jasm.gen.cisc.x86.OperandCode.Ov;
import static jasm.gen.cisc.x86.OperandCode.Sw;
import static jasm.gen.cisc.x86.OperandCode.Xb;
import static jasm.gen.cisc.x86.OperandCode.Xv;
import static jasm.gen.cisc.x86.OperandCode.Xz;
import static jasm.gen.cisc.x86.OperandCode.Yb;
import static jasm.gen.cisc.x86.OperandCode.Yv;
import static jasm.gen.cisc.x86.OperandCode.Yz;
import static jasm.gen.cisc.x86.OperandTypeCode.b;
import static jasm.gen.cisc.x86.OperandTypeCode.v;
import static jasm.gen.cisc.x86.RegisterOperandCode.eAX;
import static jasm.gen.cisc.x86.RegisterOperandCode.rAX;
import jasm.gen.cisc.x86.X86InstructionDescriptionCreator;
import static jasm.gen.cisc.x86.X86Opcode.ADDRESS_SIZE;
import static jasm.gen.cisc.x86.X86Opcode.FWAIT;
import static jasm.gen.cisc.x86.X86Opcode.LOCK;
import static jasm.gen.cisc.x86.X86Opcode.OPERAND_SIZE;
import static jasm.gen.cisc.x86.X86Opcode.REPE;
import static jasm.gen.cisc.x86.X86Opcode.REPNE;
import static jasm.gen.cisc.x86.X86Opcode.SEG_CS;
import static jasm.gen.cisc.x86.X86Opcode.SEG_FS;
import static jasm.gen.cisc.x86.X86Opcode.SEG_GS;
import static jasm.util.HexByte._00;
import static jasm.util.HexByte._01;
import static jasm.util.HexByte._02;
import static jasm.util.HexByte._03;
import static jasm.util.HexByte._04;
import static jasm.util.HexByte._05;
import static jasm.util.HexByte._08;
import static jasm.util.HexByte._09;
import static jasm.util.HexByte._0A;
import static jasm.util.HexByte._0B;
import static jasm.util.HexByte._0C;
import static jasm.util.HexByte._0D;
import static jasm.util.HexByte._10;
import static jasm.util.HexByte._11;
import static jasm.util.HexByte._12;
import static jasm.util.HexByte._13;
import static jasm.util.HexByte._14;
import static jasm.util.HexByte._15;
import static jasm.util.HexByte._18;
import static jasm.util.HexByte._19;
import static jasm.util.HexByte._1A;
import static jasm.util.HexByte._1B;
import static jasm.util.HexByte._1C;
import static jasm.util.HexByte._1D;
import static jasm.util.HexByte._20;
import static jasm.util.HexByte._21;
import static jasm.util.HexByte._22;
import static jasm.util.HexByte._23;
import static jasm.util.HexByte._24;
import static jasm.util.HexByte._25;
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
import static jasm.util.HexByte._38;
import static jasm.util.HexByte._39;
import static jasm.util.HexByte._3A;
import static jasm.util.HexByte._3B;
import static jasm.util.HexByte._3C;
import static jasm.util.HexByte._3D;
import static jasm.util.HexByte._50;
import static jasm.util.HexByte._58;
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
import static jasm.util.HexByte._C6;
import static jasm.util.HexByte._C7;
import static jasm.util.HexByte._C8;
import static jasm.util.HexByte._C9;
import static jasm.util.HexByte._CA;
import static jasm.util.HexByte._CB;
import static jasm.util.HexByte._CC;
import static jasm.util.HexByte._CD;
import static jasm.util.HexByte._CF;
import static jasm.util.HexByte._D0;
import static jasm.util.HexByte._D1;
import static jasm.util.HexByte._D2;
import static jasm.util.HexByte._D3;
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
import static jasm.util.HexByte._EB;
import static jasm.util.HexByte._EC;
import static jasm.util.HexByte._ED;
import static jasm.util.HexByte._EE;
import static jasm.util.HexByte._EF;
import static jasm.util.HexByte._F1;
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
import jasm.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class OneByteOpcodeMap extends X86InstructionDescriptionCreator {

    private void create_low() {
        define(_00, "ADD", Eb, Gb);
        define(_01, "ADD", Ev, Gv);
        define(_02, "ADD", Gb, Eb);
        define(_03, "ADD", Gv, Ev);
        define(_04, "ADD", AL, Ib);
        define(_05, "ADD", rAX, Iz.externalRange(0, Integer.MAX_VALUE));

        define(_10, "ADC", Eb, Gb);
        define(_11, "ADC", Ev, Gv);
        define(_12, "ADC", Gb, Eb);
        define(_13, "ADC", Gv, Ev);
        define(_14, "ADC", AL, Ib);
        define(_15, "ADC", rAX, Iz.externalRange(0, Integer.MAX_VALUE));

        define(_20, "AND", Eb, Gb);
        define(_21, "AND", Ev, Gv);
        define(_22, "AND", Gb, Eb);
        define(_23, "AND", Gv, Ev);
        define(_24, "AND", AL, Ib);
        define(_25, "AND", rAX, Iz.externalRange(0, Integer.MAX_VALUE));

        define(_30, "XOR", Eb, Gb);
        define(_31, "XOR", Ev, Gv);
        define(_32, "XOR", Gb, Eb);
        define(_33, "XOR", Gv, Ev);
        define(_34, "XOR", AL, Ib);
        define(_35, "XOR", rAX, Iz.externalRange(0, Integer.MAX_VALUE));

        define(_50, "PUSH", Nv).setDefaultOperandSize(WordWidth.BITS_64);

        define(_63, "MOVSXD", Gq, Ed).requireOperandSize(WordWidth.BITS_64).beNotExternallyTestable(); // REX.W == 1, gas does not seem to know it
        define(_63, "MOVZXD", Gq, Ed).requireOperandSize(WordWidth.BITS_32).beNotExternallyTestable(); // REX.W == 0, we made this extra mnemonic up

        define(SEG_FS, "SEG_FS").beNotExternallyTestable(); // prefix
        define(SEG_GS, "SEG_GS").beNotExternallyTestable(); // prefix
        define(OPERAND_SIZE, "OPERAND_SIZE").beNotDisassemblable().beNotExternallyTestable(); // prefix
        define(ADDRESS_SIZE, "ADDRESS_SIZE").beNotDisassemblable().beNotExternallyTestable(); // prefix

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
        define(_90, "XCHG", Nv.excludeDisassemblerTestArguments(AX, EAX, RAX), rAX).beNotExternallyTestable();

        define(_A0, "MOV", AL, Ob).beNotExternallyTestable();
        define(_A1, "MOV", rAX, Ov).beNotExternallyTestable();
        define(_A2, "MOV", Ob, AL).beNotExternallyTestable();
        define(_A3, "MOV", Ov, rAX).beNotExternallyTestable();
        define(_A4, "MOVS", Yb, Xb);
        define(_A5, "MOVS", Yv, Xv);
        define(_A6, "CMPS", Yb, Xb);
        define(_A7, "CMPS", Yv, Xv);

        define(_B0, "MOV", Nb, Ib);

        define(_C0, GROUP_2, b, Eb, Ib);
        define(_C1, GROUP_2, v, Ev, Ib);
        define(_C2, "RET", Iw).setDefaultOperandSize(WordWidth.BITS_64);
        define(_C3, "RET").setDefaultOperandSize(WordWidth.BITS_64);
        define(_C6, "MOV", b, Eb.excludeExternalTestArguments(AMD64GeneralRegister8.ENUMERATOR), Ib);
        define(_C7, "MOV", v, Ev.excludeExternalTestArguments(AMD64GeneralRegister16.ENUMERATOR, AMD64GeneralRegister32.ENUMERATOR), Iz.externalRange(0, Integer.MAX_VALUE));

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
        define(_E5, "IN", eAX, Ib);
        define(_E6, "OUT", Ib, AL);
        define(_E7, "OUT", Ib, eAX);

        define(LOCK, "LOCK").beNotExternallyTestable(); // prefix
        define(_F1, "INT", 1).beNotExternallyTestable(); // is this correct? - gas uses 0xCD
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
        define(_0D, "OR", rAX, Iz.externalRange(0, Integer.MAX_VALUE));

        define(_18, "SBB", Eb, Gb);
        define(_19, "SBB", Ev, Gv);
        define(_1A, "SBB", Gb, Eb);
        define(_1B, "SBB", Gv, Ev);
        define(_1C, "SBB", AL, Ib);
        define(_1D, "SBB", rAX, Iz.externalRange(0, Integer.MAX_VALUE));

        define(_28, "SUB", Eb, Gb);
        define(_29, "SUB", Ev, Gv);
        define(_2A, "SUB", Gb, Eb);
        define(_2B, "SUB", Gv, Ev);
        define(_2C, "SUB", AL, Ib);
        define(_2D, "SUB", rAX, Iz.externalRange(0, Integer.MAX_VALUE));
        define(SEG_CS, "SEG_CS").beNotExternallyTestable(); // prefix
        define(_2F, "DAS").beNotExternallyTestable(); // not defined in 64 bit mode and so 'as -64' rejects it

        define(_38, "CMP", Eb, Gb);
        define(_39, "CMP", Ev, Gv);
        define(_3A, "CMP", Gb, Eb);
        define(_3B, "CMP", Gv, Ev);
        define(_3C, "CMP", AL, Ib);
        define(_3D, "CMP", rAX, Iz.externalRange(0, Integer.MAX_VALUE));

        define(_58, "POP", Nv).setDefaultOperandSize(WordWidth.BITS_64);

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
        define(_8C, "MOV", Ew.excludeExternalTestArguments(AMD64GeneralRegister16.ENUMERATOR), Sw); // gas may needlessly insert OPERAND_SIZE prefix
        define(_8D, "LEA", Gv, M);
        define(_8E, "MOV", Sw, Ew.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI)); // gas may needlessly insert OPERAND_SIZE prefix
        define(_8F, "POP", Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI)).setDefaultOperandSize(WordWidth.BITS_64);

        define(_98, "CWDE").requireOperandSize(WordWidth.BITS_32);
        define(_98, "CDQE").requireOperandSize(WordWidth.BITS_64);
        define(_99, "CDQ").requireOperandSize(WordWidth.BITS_32);
        define(_99, "CQO").requireOperandSize(WordWidth.BITS_64);
        define(FWAIT, "FWAIT"); // 'wait' is a Java keyword, so we use the alternate mnemonic, which is more accurately named anyhow
        define(_9C, "PUSHF", v, Fv).setDefaultOperandSize(WordWidth.BITS_64);
        define(_9D, "POPF", v, Fv).setDefaultOperandSize(WordWidth.BITS_64);
        define(_9E, "SAHF").beNotExternallyTestable(); // not available by gas, depends on CPUID
        define(_9F, "LAHF").beNotExternallyTestable(); // not available by gas, depends on CPUID

        define(_A8, "TEST", AL, Ib);
        define(_A9, "TEST", rAX, Iz.externalRange(0, Integer.MAX_VALUE));
        define(_AA, "STOS", Yb);
        define(_AB, "STOS", Yv);
        define(_AC, "LODS", Xb);
        define(_AD, "LODS", Xv);
        define(_AE, "SCAS", Yb);
        define(_AF, "SCAS", Yv);

        define(_B8, "MOV", Nv, Iv);

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
        define(_FF, GROUP_5a);
        define(_FF, GROUP_5b).setDefaultOperandSize(WordWidth.BITS_64);
    }

    OneByteOpcodeMap() {
        super(AMD64Assembly.ASSEMBLY);
        create_low();
        create_high();
    }
}
