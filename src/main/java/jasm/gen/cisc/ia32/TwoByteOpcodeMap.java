/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.ia32;

import static jasm.gen.cisc.ia32.IA32ModRMGroup.GROUP_10;
import static jasm.gen.cisc.ia32.IA32ModRMGroup.GROUP_11;
import static jasm.gen.cisc.ia32.IA32ModRMGroup.GROUP_12;
import static jasm.gen.cisc.ia32.IA32ModRMGroup.GROUP_13;
import static jasm.gen.cisc.ia32.IA32ModRMGroup.GROUP_6a;
import static jasm.gen.cisc.ia32.IA32ModRMGroup.GROUP_6b;
import static jasm.gen.cisc.ia32.IA32ModRMGroup.GROUP_7a;
import static jasm.gen.cisc.ia32.IA32ModRMGroup.GROUP_7b;
import static jasm.gen.cisc.ia32.IA32ModRMGroup.GROUP_8;
import static jasm.gen.cisc.ia32.IA32ModRMGroup.GROUP_9;
import static jasm.gen.cisc.x86.OperandCode.Cd;
import static jasm.gen.cisc.x86.OperandCode.Dd;
import static jasm.gen.cisc.x86.OperandCode.Eb;
import static jasm.gen.cisc.x86.OperandCode.Ed;
import static jasm.gen.cisc.x86.OperandCode.Ev;
import static jasm.gen.cisc.x86.OperandCode.Ew;
import static jasm.gen.cisc.x86.OperandCode.Gb;
import static jasm.gen.cisc.x86.OperandCode.Gv;
import static jasm.gen.cisc.x86.OperandCode.Ib;
import static jasm.gen.cisc.x86.OperandCode.Jv;
import static jasm.gen.cisc.x86.OperandCode.Mp;
import static jasm.gen.cisc.x86.OperandCode.Nd;
import static jasm.gen.cisc.x86.OperandCode.Pd;
import static jasm.gen.cisc.x86.OperandCode.Pq;
import static jasm.gen.cisc.x86.OperandCode.Qd;
import static jasm.gen.cisc.x86.OperandCode.Qq;
import static jasm.gen.cisc.x86.OperandCode.Rd;
import jasm.gen.cisc.x86.X86InstructionDescriptionCreator;
import static jasm.ia32.IA32GeneralRegister8.CL;
import static jasm.util.HexByte._00;
import static jasm.util.HexByte._01;
import static jasm.util.HexByte._02;
import static jasm.util.HexByte._03;
import static jasm.util.HexByte._06;
import static jasm.util.HexByte._08;
import static jasm.util.HexByte._09;
import static jasm.util.HexByte._0B;
import static jasm.util.HexByte._0F;
import static jasm.util.HexByte._20;
import static jasm.util.HexByte._21;
import static jasm.util.HexByte._22;
import static jasm.util.HexByte._23;
import static jasm.util.HexByte._30;
import static jasm.util.HexByte._31;
import static jasm.util.HexByte._32;
import static jasm.util.HexByte._33;
import static jasm.util.HexByte._40;
import static jasm.util.HexByte._41;
import static jasm.util.HexByte._42;
import static jasm.util.HexByte._43;
import static jasm.util.HexByte._44;
import static jasm.util.HexByte._45;
import static jasm.util.HexByte._46;
import static jasm.util.HexByte._47;
import static jasm.util.HexByte._48;
import static jasm.util.HexByte._49;
import static jasm.util.HexByte._4A;
import static jasm.util.HexByte._4B;
import static jasm.util.HexByte._4C;
import static jasm.util.HexByte._4D;
import static jasm.util.HexByte._4E;
import static jasm.util.HexByte._4F;
import static jasm.util.HexByte._60;
import static jasm.util.HexByte._61;
import static jasm.util.HexByte._62;
import static jasm.util.HexByte._63;
import static jasm.util.HexByte._64;
import static jasm.util.HexByte._65;
import static jasm.util.HexByte._66;
import static jasm.util.HexByte._67;
import static jasm.util.HexByte._68;
import static jasm.util.HexByte._69;
import static jasm.util.HexByte._6A;
import static jasm.util.HexByte._6B;
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
import static jasm.util.HexByte._91;
import static jasm.util.HexByte._92;
import static jasm.util.HexByte._93;
import static jasm.util.HexByte._94;
import static jasm.util.HexByte._95;
import static jasm.util.HexByte._96;
import static jasm.util.HexByte._97;
import static jasm.util.HexByte._98;
import static jasm.util.HexByte._99;
import static jasm.util.HexByte._9A;
import static jasm.util.HexByte._9B;
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
import static jasm.util.HexByte._A8;
import static jasm.util.HexByte._A9;
import static jasm.util.HexByte._AA;
import static jasm.util.HexByte._AB;
import static jasm.util.HexByte._AC;
import static jasm.util.HexByte._AD;
import static jasm.util.HexByte._AF;
import static jasm.util.HexByte._B0;
import static jasm.util.HexByte._B1;
import static jasm.util.HexByte._B2;
import static jasm.util.HexByte._B3;
import static jasm.util.HexByte._B4;
import static jasm.util.HexByte._B5;
import static jasm.util.HexByte._B6;
import static jasm.util.HexByte._B7;
import static jasm.util.HexByte._B9;
import static jasm.util.HexByte._BA;
import static jasm.util.HexByte._BB;
import static jasm.util.HexByte._BC;
import static jasm.util.HexByte._BD;
import static jasm.util.HexByte._BE;
import static jasm.util.HexByte._BF;
import static jasm.util.HexByte._C0;
import static jasm.util.HexByte._C1;
import static jasm.util.HexByte._C7;
import static jasm.util.HexByte._C8;
import static jasm.util.HexByte._D1;
import static jasm.util.HexByte._D2;
import static jasm.util.HexByte._D3;
import static jasm.util.HexByte._D5;
import static jasm.util.HexByte._D8;
import static jasm.util.HexByte._D9;
import static jasm.util.HexByte._DB;
import static jasm.util.HexByte._DC;
import static jasm.util.HexByte._DD;
import static jasm.util.HexByte._DF;
import static jasm.util.HexByte._E1;
import static jasm.util.HexByte._E2;
import static jasm.util.HexByte._E5;
import static jasm.util.HexByte._E8;
import static jasm.util.HexByte._E9;
import static jasm.util.HexByte._EB;
import static jasm.util.HexByte._EC;
import static jasm.util.HexByte._ED;
import static jasm.util.HexByte._EF;
import static jasm.util.HexByte._F1;
import static jasm.util.HexByte._F2;
import static jasm.util.HexByte._F3;
import static jasm.util.HexByte._F5;
import static jasm.util.HexByte._F8;
import static jasm.util.HexByte._F9;
import static jasm.util.HexByte._FA;
import static jasm.util.HexByte._FC;
import static jasm.util.HexByte._FD;
import static jasm.util.HexByte._FE;
import static jasm.x86.SegmentRegister.FS;
import static jasm.x86.SegmentRegister.GS;

final class TwoByteOpcodeMap extends X86InstructionDescriptionCreator {

    private void create_low() {
        define(_0F, _00, GROUP_6a);
        define(_0F, _00, GROUP_6b);
        define(_0F, _01, GROUP_7a);
        define(_0F, _01, GROUP_7b);
        define(_0F, _02, "LAR", Gv, Ev); // bug in table, wrongly suggesting Ew
        define(_0F, _03, "LSL", Gv, Ev); // bug in table, wrongly suggesting Ew
        define(_0F, _06, "CLTS");

        define(_0F, _20, "MOV", Rd, Cd);
        define(_0F, _21, "MOV", Rd, Dd);
        define(_0F, _22, "MOV", Cd, Rd);
        define(_0F, _23, "MOV", Dd, Rd);

        define(_0F, _30, "WRMSR");
        define(_0F, _31, "RDTSC");
        define(_0F, _32, "RDMSR");
        define(_0F, _33, "RDPMC");

        define(_0F, _40, "CMOVO", Gv, Ev);
        define(_0F, _41, "CMOVNO", Gv, Ev);
        define(_0F, _42, "CMOVB", Gv, Ev);
        define(_0F, _43, "CMOVNB", Gv, Ev);
        define(_0F, _44, "CMOVZ", Gv, Ev);
        define(_0F, _45, "CMOVNZ", Gv, Ev);
        define(_0F, _46, "CMOVBE", Gv, Ev);
        define(_0F, _47, "CMOVNBE", Gv, Ev);

        define(_0F, _60, "PUNPCKLBW", Pq, Qd);
        define(_0F, _61, "PUNPCKLWD", Pq, Qd);
        define(_0F, _62, "PUNPCKLDQ", Pq, Qd);
        define(_0F, _63, "PACKSSWB", Pq, Qd);
        define(_0F, _64, "PCMPGTB", Pq, Qd);
        define(_0F, _65, "PCMPGTW", Pq, Qd);
        define(_0F, _66, "PCMPGTD", Pq, Qd);
        define(_0F, _67, "PACKUSWB", Pq, Qd);

        define(_0F, _70, "PSHUFW", Pq, Qd, Ib);
        define(_0F, _71, GROUP_11);
        define(_0F, _72, GROUP_12);
        define(_0F, _73, GROUP_13);
        define(_0F, _74, "PCMPEQB", Pq, Qd);
        define(_0F, _75, "PCMPEQW", Pq, Qd);
        define(_0F, _76, "PCMPEQD", Pq, Qd);
        define(_0F, _77, "EMMS");

        define(_0F, _80, "JO", Jv);
        define(_0F, _81, "JNO", Jv);
        define(_0F, _82, "JB", Jv);
        define(_0F, _83, "JNB", Jv);
        define(_0F, _84, "JZ", Jv);
        define(_0F, _85, "JNZ", Jv);
        define(_0F, _86, "JBE", Jv);
        define(_0F, _87, "JNBE", Jv);

        define(_0F, _90, "SETO", Eb);
        define(_0F, _91, "SETNO", Eb);
        define(_0F, _92, "SETB", Eb);
        define(_0F, _93, "SETNB", Eb);
        define(_0F, _94, "SETZ", Eb);
        define(_0F, _95, "SETNZ", Eb);
        define(_0F, _96, "SETBE", Eb);
        define(_0F, _97, "SETNBE", Eb);

        define(_0F, _A0, "PUSH", FS);
        define(_0F, _A1, "POP", FS);
        define(_0F, _A2, "CPUID");
        define(_0F, _A3, "BT", Ev, Gv);
        define(_0F, _A4, "SHLD", Ev, Gv, Ib);
        define(_0F, _A5, "SHLD", Ev, Gv, CL);
        //define(_0F, _A6, "CMPXCHG", Xb, Ts); // invalid opcode or undocumented instruction?
        //define(_0F, _A7, "CMPXCHG", Ib, Ts); // invalid opcode or undocumented instruction?

        define(_0F, _B0, "CMPXCHG", Eb, Gb);
        define(_0F, _B1, "CMPXCHG", Ev, Gv);
        define(_0F, _B2, "LSS", Gv, Mp); // bug in table: no Gv
        define(_0F, _B3, "BTR", Ev, Gv);
        define(_0F, _B4, "LFS", Gv, Mp); // bug in table: no Gv
        define(_0F, _B5, "LGS", Gv, Mp); // bug in table: no Gv
        define(_0F, _B6, "MOVZXB", Gv, Eb).setExternalName("movzx");
        define(_0F, _B7, "MOVZXW", Gv, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

        define(_0F, _C0, "XADD", Eb, Gb);
        define(_0F, _C1, "XADD", Ev, Gv);
        define(_0F, _C7, GROUP_9);

        define(_0F, _D1, "PSRLW", Pq, Qd);
        define(_0F, _D2, "PSRLD", Pq, Qd);
        define(_0F, _D3, "PSRLQ", Pq, Qd);
        define(_0F, _D5, "PMULLW", Pq, Qd);

        define(_0F, _E1, "PSRAW", Pq, Qd);
        define(_0F, _E2, "PSRAD", Pq, Qd);
        define(_0F, _E5, "PMULHW", Pq, Qd);

        define(_0F, _F1, "PSLLW", Pq, Qd);
        define(_0F, _F2, "PSLLD", Pq, Qd);
        define(_0F, _F3, "PSLLQ", Pq, Qd);
        define(_0F, _F5, "PMADDWD", Pq, Qd);
    }

    private void create_high() {
        define(_0F, _08, "INVD");
        define(_0F, _09, "WBINVD");
        define(_0F, _0B, "UD2");

        define(_0F, _48, "CMOVS", Gv, Ev);
        define(_0F, _49, "CMOVNS", Gv, Ev);
        define(_0F, _4A, "CMOVP", Gv, Ev);
        define(_0F, _4B, "CMOVNP", Gv, Ev);
        define(_0F, _4C, "CMOVL", Gv, Ev);
        define(_0F, _4D, "CMOVNL", Gv, Ev);
        define(_0F, _4E, "CMOVLE", Gv, Ev);
        define(_0F, _4F, "CMOVNLE", Gv, Ev);

        define(_0F, _68, "PUNPCKHBW", Pq, Qd);
        define(_0F, _69, "PUNPCKHWD", Pq, Qd);
        define(_0F, _6A, "PUNPCKHDQ", Pq, Qd);
        define(_0F, _6B, "PACKSSDW", Pq, Qd);
        define(_0F, _6E, "MOVD", Pd, Ed);
        define(_0F, _6F, "MOVQ", Pq, Qq);

        define(_0F, _7E, "MOVD", Ed, Pd);
        define(_0F, _7F, "MOVQ", Qq, Pq);

        define(_0F, _88, "JS", Jv);
        define(_0F, _89, "JNS", Jv);
        define(_0F, _8A, "JP", Jv);
        define(_0F, _8B, "JNP", Jv);
        define(_0F, _8C, "JL", Jv);
        define(_0F, _8D, "JNL", Jv);
        define(_0F, _8E, "JLE", Jv);
        define(_0F, _8F, "JNLE", Jv);

        define(_0F, _98, "SETS", Eb);
        define(_0F, _99, "SETNS", Eb);
        define(_0F, _9A, "SETP", Eb);
        define(_0F, _9B, "SETNP", Eb);
        define(_0F, _9C, "SETL", Eb);
        define(_0F, _9D, "SETNL", Eb);
        define(_0F, _9E, "SETLE", Eb);
        define(_0F, _9F, "SETNLE", Eb);

        define(_0F, _A8, "PUSH", GS);
        define(_0F, _A9, "POP", GS);
        define(_0F, _AA, "RSM");
        define(_0F, _AB, "BTS", Ev, Gv);
        define(_0F, _AC, "SHRD", Ev, Gv, Ib);
        define(_0F, _AD, "SHRD", Ev, Gv, CL);
        define(_0F, _AF, "IMUL", Gv, Ev);

        define(_0F, _B9, GROUP_10);
        define(_0F, _BA, GROUP_8, Ev, Ib);
        define(_0F, _BB, "BTC", Ev, Gv);
        define(_0F, _BC, "BSF", Gv, Ev);
        define(_0F, _BD, "BSR", Gv, Ev);
        define(_0F, _BE, "MOVSXB", Gv, Eb).setExternalName("movsx");
        define(_0F, _BF, "MOVSXW", Gv, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

        define(_0F, _C8, "BSWAP", Nd);

        define(_0F, _D8, "PSUBUSB", Pq, Qq);
        define(_0F, _D9, "PSUBUSW", Pq, Qq);
        define(_0F, _DB, "PAND", Pq, Qq);
        define(_0F, _DC, "PADDUSB", Pq, Qq);
        define(_0F, _DD, "PADDUSW", Pq, Qq);
        define(_0F, _DF, "PANDN", Pq, Qq);

        define(_0F, _E8, "PSUBSB", Pq, Qq);
        define(_0F, _E9, "PSUBSW", Pq, Qq);
        define(_0F, _EB, "POR", Pq, Qq);
        define(_0F, _EC, "PADDSB", Pq, Qq);
        define(_0F, _ED, "PADDSW", Pq, Qq);
        define(_0F, _EF, "PXOR", Pq, Qq);

        define(_0F, _F8, "PSUBB", Pq, Qq);
        define(_0F, _F9, "PSUBW", Pq, Qq);
        define(_0F, _FA, "PSUBD", Pq, Qq);
        define(_0F, _FC, "PADDB", Pq, Qq);
        define(_0F, _FD, "PADDW", Pq, Qq);
        define(_0F, _FE, "PADDD", Pq, Qq);
    }

    TwoByteOpcodeMap() {
        super(IA32Assembly.ASSEMBLY);
        create_low();
        create_high();
    }
}
