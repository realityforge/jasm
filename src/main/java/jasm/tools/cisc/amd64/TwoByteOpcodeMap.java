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
import static jasm.amd64.AMD64GeneralRegister8.CL;
import jasm.amd64.AMD64XMMRegister;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_10;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_12a;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_12b;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_13a;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_13b;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_14a;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_14b;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_15a;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_15b;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_16;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_6a;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_6b;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_7a;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_7b;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_8;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_9a;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_9b;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.GROUP_P;
import jasm.tools.cisc.x86.ModCase;
import static jasm.tools.cisc.x86.OperandCode.Cq;
import static jasm.tools.cisc.x86.OperandCode.Dq;
import static jasm.tools.cisc.x86.OperandCode.Eb;
import static jasm.tools.cisc.x86.OperandCode.Ed;
import static jasm.tools.cisc.x86.OperandCode.Ed_q;
import static jasm.tools.cisc.x86.OperandCode.Ev;
import static jasm.tools.cisc.x86.OperandCode.Ew;
import static jasm.tools.cisc.x86.OperandCode.Gb;
import static jasm.tools.cisc.x86.OperandCode.Gd;
import static jasm.tools.cisc.x86.OperandCode.Gd_q;
import static jasm.tools.cisc.x86.OperandCode.God_q;
import static jasm.tools.cisc.x86.OperandCode.Gv;
import static jasm.tools.cisc.x86.OperandCode.ICb;
import static jasm.tools.cisc.x86.OperandCode.Ib;
import static jasm.tools.cisc.x86.OperandCode.Jz;
import static jasm.tools.cisc.x86.OperandCode.Mb;
import static jasm.tools.cisc.x86.OperandCode.Md_q;
import static jasm.tools.cisc.x86.OperandCode.Mdq;
import static jasm.tools.cisc.x86.OperandCode.Mq;
import static jasm.tools.cisc.x86.OperandCode.PRq;
import static jasm.tools.cisc.x86.OperandCode.Pq;
import static jasm.tools.cisc.x86.OperandCode.Qd;
import static jasm.tools.cisc.x86.OperandCode.Qq;
import static jasm.tools.cisc.x86.OperandCode.Rq;
import static jasm.tools.cisc.x86.OperandCode.Udq;
import static jasm.tools.cisc.x86.OperandCode.Upd;
import static jasm.tools.cisc.x86.OperandCode.Ups;
import static jasm.tools.cisc.x86.OperandCode.Uq;
import static jasm.tools.cisc.x86.OperandCode.Vdq;
import static jasm.tools.cisc.x86.OperandCode.Vpd;
import static jasm.tools.cisc.x86.OperandCode.Vps;
import static jasm.tools.cisc.x86.OperandCode.Vq;
import static jasm.tools.cisc.x86.OperandCode.Vsd;
import static jasm.tools.cisc.x86.OperandCode.Vss;
import static jasm.tools.cisc.x86.OperandCode.Wdq;
import static jasm.tools.cisc.x86.OperandCode.Wpd;
import static jasm.tools.cisc.x86.OperandCode.Wps;
import static jasm.tools.cisc.x86.OperandCode.Wq;
import static jasm.tools.cisc.x86.OperandCode.Wsd;
import static jasm.tools.cisc.x86.OperandCode.Wss;
import jasm.tools.cisc.x86.X86InstructionDescriptionCreator;
import jasm.tools.cisc.x86.X86InstructionPrefix;
import static jasm.util.HexByte._00;
import static jasm.util.HexByte._01;
import static jasm.util.HexByte._02;
import static jasm.util.HexByte._03;
import static jasm.util.HexByte._05;
import static jasm.util.HexByte._06;
import static jasm.util.HexByte._07;
import static jasm.util.HexByte._08;
import static jasm.util.HexByte._09;
import static jasm.util.HexByte._0B;
import static jasm.util.HexByte._0D;
import static jasm.util.HexByte._0E;
import static jasm.util.HexByte._0F;
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
import static jasm.util.HexByte._28;
import static jasm.util.HexByte._29;
import static jasm.util.HexByte._2A;
import static jasm.util.HexByte._2B;
import static jasm.util.HexByte._2C;
import static jasm.util.HexByte._2D;
import static jasm.util.HexByte._2E;
import static jasm.util.HexByte._2F;
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
import static jasm.util.HexByte._50;
import static jasm.util.HexByte._51;
import static jasm.util.HexByte._52;
import static jasm.util.HexByte._53;
import static jasm.util.HexByte._54;
import static jasm.util.HexByte._55;
import static jasm.util.HexByte._56;
import static jasm.util.HexByte._57;
import static jasm.util.HexByte._58;
import static jasm.util.HexByte._59;
import static jasm.util.HexByte._5A;
import static jasm.util.HexByte._5B;
import static jasm.util.HexByte._5C;
import static jasm.util.HexByte._5D;
import static jasm.util.HexByte._5E;
import static jasm.util.HexByte._5F;
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
import static jasm.util.HexByte._AE;
import static jasm.util.HexByte._AF;
import static jasm.util.HexByte._B0;
import static jasm.util.HexByte._B1;
import static jasm.util.HexByte._B3;
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
import static jasm.util.HexByte._C2;
import static jasm.util.HexByte._C3;
import static jasm.util.HexByte._C4;
import static jasm.util.HexByte._C5;
import static jasm.util.HexByte._C6;
import static jasm.util.HexByte._C7;
import static jasm.util.HexByte._C8;
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
import static jasm.util.HexByte._F0;
import static jasm.util.HexByte._F1;
import static jasm.util.HexByte._F2;
import static jasm.util.HexByte._F3;
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
import static jasm.x86.SegmentRegister.FS;
import static jasm.x86.SegmentRegister.GS;

public final class TwoByteOpcodeMap extends X86InstructionDescriptionCreator {

  /**
   * See A-5 in the book.
   *
   * @see jasm.x86
   */
  private void create_low() {
    define(_0F, _00, GROUP_6a);
    define(_0F, _00, GROUP_6b);
    define(_0F, _01, GROUP_7a);
    define(_0F, _01, GROUP_7b);
    define(_0F, _02, "LAR", Gv, Ev); // bug in table, wrongly suggesting Ew
    define(_0F, _03, "LSL", Gv, Ev); // bug in table, wrongly suggesting Ew
    define(_0F, _05, "SYSCALL");
    define(_0F, _06, "CLTS");
    define(_0F, _07, "SYSRET");

    define(_0F, _10, "MOVUPS", Vps, Wps);
    define(_0F, _11, "MOVUPS", Wps, Vps);
    define(_0F, _12, "MOVLPS", Vps, Mq);
    define(_0F, _13, "MOVLPS", Mq, Vps); // MOVHLPS??
    define(_0F, _14, "UNPCKLPS", Vps, Wq);
    define(_0F, _15, "UNPCKHPS", Vps, Wq);
    define(_0F, _16, "MOVHPS", Vps, Mq);
    define(_0F, _17, "MOVHPS", Mq, Vps); // MOVLHPS ??

    define(_66, _0F, _10, "MOVUPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _11, "MOVUPD", Wpd, Vpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _12, "MOVLPD", Vsd, Mq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _13, "MOVLPD", Mq, Vsd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _14, "UNPCKLPD", Vpd, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _15, "UNPCKHPD", Vpd, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _16, "MOVHPD", Vsd, Mq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _17, "MOVHPD", Mq, Vsd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_F2, _0F, _10, "MOVSD", Vdq, Wsd);
    define(_F2, _0F, _10, "MOVSD", Vsd, Wsd);
    define(_F2, _0F, _11, "MOVSD", Wsd, Vsd);
    define(_F2, _0F, _12, "MOVDDUP", Vpd, Wsd);

    define(_F3, _0F, _10, "MOVSS", Vdq, Wss);
    define(_F3, _0F, _10, "MOVSS", Vss, Wss);
    define(_F3, _0F, _11, "MOVSS", Wss, Vss);
    define(_F3, _0F, _12, "MOVSLDUP", Vps, Wps);

    define(_0F, _20, "MOV", Rq, Cq);
    define(_0F, _21, "MOV", Rq, Dq);
    define(_0F, _22, "MOV", Cq, Rq);
    define(_0F, _23, "MOV", Dq, Rq);

    define(_0F, _30, "WRMSR");
    define(_0F, _31, "RDTSC");
    define(_0F, _32, "RDMSR");
    define(_0F, _33, "RDPMC");

    define(_0F, _40, "CMOVO", Gv, Ev);
    define(_0F, _41, "CMOVNO", Gv, Ev);
    define(_0F, _42, "CMOVB", Gv, Ev);
    define(_0F, _43, "CMOVAE", Gv, Ev);
    define(_0F, _44, "CMOVE", Gv, Ev);
    define(_0F, _45, "CMOVNE", Gv, Ev);
    define(_0F, _46, "CMOVBE", Gv, Ev);
    define(_0F, _47, "CMOVA", Gv, Ev);

    define(_0F, _50, "MOVMSKPS", Gd, Ups);
    define(_0F, _51, "SQRTPS", Vps, Wps);
    define(_0F, _52, "RSQRTPS", Vps, Wps);
    define(_0F, _53, "RCPPS", Vps, Wps);
    define(_0F, _54, "ANDPS", Vps, Wps);
    define(_0F, _55, "ANDNPS", Vps, Wps);
    define(_0F, _56, "ORPS", Vps, Wps);
    define(_0F, _57, "XORPS", Vps, Wps);

    define(_66, _0F, _50, "MOVMSKPD", Gd, Upd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _51, "SQRTPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _54, "ANDPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _55, "ANDNPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _56, "ORPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _57, "XORPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_F2, _0F, _51, "SQRTSD", Vsd, Wsd);

    define(_F3, _0F, _51, "SQRTSS", Vss, Wss);
    define(_F3, _0F, _52, "RSQRTSS", Vss, Wss);
    define(_F3, _0F, _53, "RCPSS", Vss, Wss);

    define(_0F, _60, "PUNPCKLBW", Pq, Qd);
    define(_0F, _61, "PUNPCKLWD", Pq, Qd);
    define(_0F, _62, "PUNPCKLDQ", Pq, Qd);
    define(_0F, _63, "PACKSSWB", Pq, Qd);
    define(_0F, _64, "PCMPGTB", Pq, Qq);
    define(_0F, _65, "PCMPGTW", Pq, Qq);
    define(_0F, _66, "PCMPGTD", Pq, Qq);
    define(_0F, _67, "PACKUSWB", Pq, Qq);

    define(_66, _0F, _60, "PUNPCKLBW", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _61, "PUNPCKLWD", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _62, "PUNPCKLDQ", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _63, "PACKSSWB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _64, "PCMPGTB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _65, "PCMPGTW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _66, "PCMPGTD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _67, "PACKUSWB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_0F, _70, "PSHUFW", Pq, Qq, Ib);
    define(_0F, _71, GROUP_12a);
    define(_0F, _72, GROUP_13a);
    define(_0F, _73, GROUP_14a);
    define(_0F, _74, "PCMPEQB", Pq, Qq);
    define(_0F, _75, "PCMPEQW", Pq, Qq);
    define(_0F, _76, "PCMPEQD", Pq, Qq);
    define(_0F, _77, "EMMS");

    define(_66, _0F, _70, "PSHUFD", Vdq, Wdq, Ib).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _71, GROUP_12b).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _72, GROUP_13b).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _73, GROUP_14b).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _74, "PCMPEQB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _75, "PCMPEQW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _76, "PCMPEQD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_F2, _0F, _70, "PSHUFLW", Vq, Wq, Ib);

    define(_F3, _0F, _70, "PSHUFHW", Vq, Wq, Ib);

    define(_0F, _80, "JO", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _81, "JNO", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _82, "JB", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _83, "JNB", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _84, "JZ", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _85, "JNZ", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _86, "JBE", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _87, "JNBE", Jz).setDefaultOperandSize(WordWidth.BITS_64);

    define(_0F, _90, "SETO", Eb);
    define(_0F, _91, "SETNO", Eb);
    define(_0F, _92, "SETB", Eb);
    define(_0F, _93, "SETNB", Eb);
    define(_0F, _94, "SETZ", Eb);
    define(_0F, _95, "SETNZ", Eb);
    define(_0F, _96, "SETBE", Eb);
    define(_0F, _97, "SETNBE", Eb);

    define(_0F, _A0, "PUSH", FS).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _A1, "POP", FS).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _A2, "CPUID");
    define(_0F, _A3, "BT", Ev, Gv);
    define(_0F, _A4, "SHLD", Ev, Gv, Ib);
    define(_0F, _A5, "SHLD", Ev, Gv, CL);

    define(_0F, _B0, "CMPXCHG", Eb, Gb);
    define(_0F, _B1, "CMPXCHG", Ev, Gv);
    // define(_0F, _B2, "LSS", Gz, Mp); // legacy mode instruction
    define(_0F, _B3, "BTR", Ev, Gv);
    // define(_0F, _B4, "LFS", Gz, Mp); // legacy mode instruction
    // define(_0F, _B5, "LGS", Gz, Mp); // legacy mode instruction
    define(_0F, _B6, "MOVZXB", Gv, Eb).setExternalName("movzx");
    define(_0F, _B7, "MOVZXW", Gd_q, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    define(_0F, _C0, "XADD", Eb, Gb);
    define(_0F, _C1, "XADD", Ev, Gv);
    define(_0F, _C2, "CMPPS", Vps, Wps, ICb);
    define(_0F, _C3, "MOVNTI", Md_q, Gd_q);
    define(_0F, _C4, "PINSRW", Pq, Ed, Ib).requireOperandSize(WordWidth.BITS_32); // Ed instead of Ew to mimic intended Gd/Mw
    define(_0F, _C5, "PEXTRW", Gd, PRq, Ib);
    define(_0F, _C6, "SHUFPS", Vps, Wps, Ib);
    define(_0F, _C7, GROUP_9a).requireAddressSize(WordWidth.BITS_32); // depends on CPUID
    define(_0F, _C7, GROUP_9b).requireAddressSize(WordWidth.BITS_64).beNotExternallyTestable(); // depends on CPUID, rejected by gas on Opteron

    define(_66, _0F, _C2, "CMPPD", Vpd, Wpd, ICb).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _C4, "PINSRW", Vdq, Ed, Ib).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE).
        requireOperandSize(WordWidth.BITS_32); // Ed instead of Ew to mimic intended Gd/Mw
    define(_66, _0F, _C5, "PEXTRW", Gd, Udq, Ib).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _C6, "SHUFPD", Vpd, Wpd, Ib).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_F2, _0F, _C2, "CMPSD", Vsd, Wsd, ICb);

    define(_F3, _0F, _C2, "CMPSS", Vss, Wss, ICb);

    define(_0F, _D1, "PSRLW", Pq, Qq);
    define(_0F, _D2, "PSRLD", Pq, Qq);
    define(_0F, _D3, "PSRLQ", Pq, Qq);
    define(_0F, _D4, "PADDQ", Pq, Qq);
    define(_0F, _D5, "PMULLW", Pq, Qq);
    define(_0F, _D7, "PMOVMSKB", Gd, PRq);

    define(_66, _0F, _D0, "ADDSUBPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _D1, "PSRLW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _D2, "PSRLD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _D3, "PSRLQ", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _D4, "PADDQ", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _D5, "PMULLW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _D6, "MOVQ",
           Wq.excludeExternalTestArguments(AMD64XMMRegister.SYMBOLS), Vq) // gas uses F3 0F 7E for reg-reg
        .setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _D7, "PMOVMSKB", Gd, Udq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_F2, _0F, _D6, "MOVDQ2Q", Pq, Uq);

    define(_F3, _0F, _D6, "MOVQ2DQ", Vdq, PRq);

    define(_0F, _E0, "PAVGB", Pq, Qq);
    define(_0F, _E1, "PSRAW", Pq, Qq);
    define(_0F, _E2, "PSRAD", Pq, Qq);
    define(_0F, _E3, "PAVGW", Pq, Qq);
    define(_0F, _E4, "PMULHUW", Pq, Qq);
    define(_0F, _E5, "PMULHW", Pq, Qq);
    define(_0F, _E7, "MOVNTQ", Mq, Pq);

    define(_66, _0F, _E0, "PAVGB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _E1, "PSRAW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _E2, "PSRAD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _E3, "PAVGW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _E4, "PMULHUW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _E5, "PMULHW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _E6, "CVTTPD2DQ", Vq, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _E7, "MVNTDQ", Mdq, Vdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE).
        beNotExternallyTestable(); // gas does not know it

    define(_F2, _0F, _E6, "CVTPD2DQ", Vq, Wpd);

    define(_F3, _0F, _E6, "CVTDQ2PD", Vpd, Wq);

    define(_0F, _F1, "PSLLW", Pq, Qq);
    define(_0F, _F2, "PSLLD", Pq, Qq);
    define(_0F, _F3, "PSLLQ", Pq, Qq);
    define(_0F, _F4, "PMULUDQ", Pq, Qq);
    define(_0F, _F5, "PMADDWD", Pq, Qq);
    define(_0F, _F6, "PSADBW", Pq, Qq);
    define(_0F, _F7, "MASKMOVQ", Pq, PRq);

    define(_66, _0F, _F1, "PSLLW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _F2, "PSLLD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _F3, "PSLLQ", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _F4, "PMULUDQ", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _F5, "PMADDWD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _F6, "PSADBW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _F7, "MASKMOVDQU", Vdq, Udq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_F2, _0F, _F0, "LDDQU", Vpd, Mdq);
  }

  /**
   * See A-6 in the book.
   *
   * @see jasm.x86
   */
  private void create_high() {
    define(_0F, _08, "INVD");
    define(_0F, _09, "WBINVD");
    define(_0F, _0B, "UD2");
    define(_0F, _0D, GROUP_P, Mb); // AMD64 table's manual lacks Mb
    define(_0F, _0E, "FEMMS");

    define(_0F, _18, GROUP_16, Mb); // AMD64 table's manual lacks Mb
    define(_0F, _19, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define(_0F, _1A, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define(_0F, _1B, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define(_0F, _1C, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define(_0F, _1D, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define(_0F, _1E, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define(_0F, _1F, "NOP").beNotExternallyTestable(); // gas uses 0x90

    define(_0F, _28, "MOVAPS", Vps, Wps);
    define(_0F, _29, "MOVAPS", Wps, Vps);
    define(_0F, _2A, "CVTPI2PS", Vps, Qq);
    define(_0F, _2B, "MOVNTPS", Mdq, Vps);
    define(_0F, _2C, "CVTTPS2PI", Pq, Wps);
    define(_0F, _2D, "CVTPS2PI", Pq, Wps);
    define(_0F, _2E, "UCOMISS", Vss, Wss);
    define(_0F, _2F, "COMISS", Vps, Wps);

    define(_66, _0F, _28, "MOVAPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _29, "MOVAPD", Wpd, Vpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _2A, "CVTPI2PD", Vpd, Qq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _2B, "MOVNTPD", Mdq, Vpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _2C, "CVTTPD2PI", Pq, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _2D, "CVTPD2PI", Pq, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _2E, "UCOMISD", Vsd, Wsd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _2F, "COMISD", Vpd, Wsd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_F2, _0F, _2A, "CVTSI2SD", Vsd, Ed_q);
    define(_F2, _0F, _2C, "CVTTSD2SI", Gd_q, Wsd);
    define(_F2, _0F, _2D, "CVTSD2SI", Gd_q, Wsd);

    define(_F3, _0F, _2A, "CVTSI2SS", Vss, Ed_q);
    define(_F3, _0F, _2C, "CVTTSS2SI", Gd_q, Wss);
    define(_F3, _0F, _2D, "CVTSS2SI", Gd_q, Wss);

    define(_0F, _48, "CMOVS", Gv, Ev);
    define(_0F, _49, "CMOVNS", Gv, Ev);
    define(_0F, _4A, "CMOVP", Gv, Ev);
    define(_0F, _4B, "CMOVNP", Gv, Ev);
    define(_0F, _4C, "CMOVL", Gv, Ev);
    define(_0F, _4D, "CMOVGE", Gv, Ev);
    define(_0F, _4E, "CMOVLE", Gv, Ev);
    define(_0F, _4F, "CMOVG", Gv, Ev);

    define(_0F, _58, "ADDPS", Vps, Wps);
    define(_0F, _59, "MULPS", Vps, Wps);
    define(_0F, _5A, "CVTPS2PD", Vpd, Wps);
    define(_0F, _5B, "CVTDQ2PS", Vps, Wdq);
    define(_0F, _5C, "SUBPS", Vps, Wps);
    define(_0F, _5D, "MINPS", Vps, Wps);
    define(_0F, _5E, "DIVPS", Vps, Wps);
    define(_0F, _5F, "MAXPS", Vps, Wps);

    define(_66, _0F, _58, "ADDPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _59, "MULPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _5A, "CVTPD2PS", Vps, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _5B, "CVTPS2DQ", Vdq, Wps).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _5C, "SUBPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _5D, "MINPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _5E, "DIVPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _5F, "MAXPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_F2, _0F, _58, "ADDSD", Vsd, Wsd);
    define(_F2, _0F, _59, "MULSD", Vsd, Wsd);
    define(_F2, _0F, _5A, "CVTSD2SS", Vss, Wsd);
    define(_F2, _0F, _5C, "SUBSD", Vsd, Wsd);
    define(_F2, _0F, _5D, "MINSD", Vsd, Wsd);
    define(_F2, _0F, _5E, "DIVSD", Vsd, Wsd);
    define(_F2, _0F, _5F, "MAXSD", Vsd, Wsd);

    define(_F3, _0F, _58, "ADDSS", Vss, Wss);
    define(_F3, _0F, _59, "MULSS", Vss, Wss);
    define(_F3, _0F, _5A, "CVTSS2SD", Vsd, Wss);
    define(_F3, _0F, _5B, "CVTTPS2DQ", Vdq, Wps);
    define(_F3, _0F, _5C, "SUBSS", Vss, Wss);
    define(_F3, _0F, _5D, "MINSS", Vss, Wss);
    define(_F3, _0F, _5E, "DIVSS", Vss, Wss);
    define(_F3, _0F, _5F, "MAXSS", Vss, Wss);

    define(_0F, _68, "PUNPCKHBW", Pq, Qd);
    define(_0F, _69, "PUNPCKHWD", Pq, Qd);
    define(_0F, _6A, "PUNPCKHDQ", Pq, Qd);
    define(_0F, _6B, "PACKSSDW", Pq, Qq);
    define(_0F, _6E, "MOVD", Pq, Ed_q).beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    define(_0F, _6F, "MOVQ", Pq, Qq);

    define(_66, _0F, _68, "PUNPCKHBW", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _69, "PUNPCKHWD", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _6A, "PUNPCKHDQ", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _6B, "PACKSSDW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _6C, "PUNPCKLQDQ", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _6D, "PUNPCKHQDQ", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _6E, "MOVD", Vdq, Ed_q).
        setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE).
        beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    define(_66, _0F, _6F, "MOVDQA", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_F3, _0F, _6F, "MOVDQU", Vdq, Wdq);

    define(_0F, _7E, "MOVD", Ed_q, Pq).beNotExternallyTestable(); // gas does not allow feature to distinguish operand width
    define(_0F, _7F, "MOVQ", Qq, Pq);

    define(_66, _0F, _7C, "HADDPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _7D, "HSUBPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _7E, "MOVD", Ed_q, Vdq).
        setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE).
        beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    define(_66, _0F, _7F, "MOVDQA", Wdq, Vdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_F2, _0F, _7C, "HADDPS", Vps, Wps);
    define(_F2, _0F, _7D, "HSUBPS", Vps, Wps);

    define(_F3, _0F, _7E, "MOVQ", Vq, Wq);
    define(_F3, _0F, _7F, "MOVDQU", Wdq, Vdq);

    define(_0F, _88, "JS", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _89, "JNS", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _8A, "JP", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _8B, "JNP", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _8C, "JL", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _8D, "JNL", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _8E, "JLE", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _8F, "JNLE", Jz).setDefaultOperandSize(WordWidth.BITS_64);

    define(_0F, _98, "SETS", Eb);
    define(_0F, _99, "SETNS", Eb);
    define(_0F, _9A, "SETP", Eb);
    define(_0F, _9B, "SETNP", Eb);
    define(_0F, _9C, "SETL", Eb);
    define(_0F, _9D, "SETNL", Eb);
    define(_0F, _9E, "SETLE", Eb);
    define(_0F, _9F, "SETNLE", Eb);

    define(_0F, _A8, "PUSH", GS).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _A9, "POP", GS).setDefaultOperandSize(WordWidth.BITS_64);
    define(_0F, _AA, "RSM");
    define(_0F, _AB, "BTS", Ev, Gv);
    define(_0F, _AC, "SHRD", Ev, Gv, Ib);
    define(_0F, _AD, "SHRD", Ev, Gv, CL);
    define(_0F, _AE, GROUP_15a);
    define(_0F, _AE, GROUP_15b, ModCase.MOD_3);
    define(_0F, _AF, "IMUL", Gv, Ev);

    define(_0F, _B9, GROUP_10);
    define(_0F, _BA, GROUP_8, Ev, Ib);
    define(_0F, _BB, "BTC", Ev, Gv);
    define(_0F, _BC, "BSF", Gv, Ev);
    define(_0F, _BD, "BSR", Gv, Ev);
    define(_0F, _BE, "MOVSXB", Gv, Eb).setExternalName("movsx");
    define(_0F, _BF, "MOVSXW", Gd_q, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    define(_0F, _C8, "BSWAP", God_q);

    define(_0F, _D8, "PSUBUSB", Pq, Qq);
    define(_0F, _D9, "PSUBUSW", Pq, Qq);
    define(_0F, _DA, "PMINUB", Pq, Qq);
    define(_0F, _DB, "PAND", Pq, Qq);
    define(_0F, _DC, "PADDUSB", Pq, Qq);
    define(_0F, _DD, "PADDUSW", Pq, Qq);
    define(_0F, _DE, "PMAXUB", Pq, Qq);
    define(_0F, _DF, "PANDN", Pq, Qq);

    define(_66, _0F, _D8, "PSUBUSB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _D9, "PSUBUSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _DA, "PMINUB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _DB, "PAND", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _DC, "PADDUSB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _DD, "PADDUSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _DE, "PMAXUB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _DF, "PANDN", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_0F, _E8, "PSUBSB", Pq, Qq);
    define(_0F, _E9, "PSUBSW", Pq, Qq);
    define(_0F, _EA, "PMINSW", Pq, Qq);
    define(_0F, _EB, "POR", Pq, Qq);
    define(_0F, _EC, "PADDSB", Pq, Qq);
    define(_0F, _ED, "PADDSW", Pq, Qq);
    define(_0F, _EE, "PMAXSW", Pq, Qq);
    define(_0F, _EF, "PXOR", Pq, Qq);

    define(_66, _0F, _E8, "PSUBSB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _E9, "PSUBSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _EA, "PMINSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _EB, "POR", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _EC, "PADDSB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _ED, "PADDSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _EE, "PMAXSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _EF, "PXOR", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    define(_0F, _F8, "PSUBB", Pq, Qq);
    define(_0F, _F9, "PSUBW", Pq, Qq);
    define(_0F, _FA, "PSUBD", Pq, Qq);
    define(_0F, _FB, "PSUBQ", Pq, Qq);
    define(_0F, _FC, "PADDB", Pq, Qq);
    define(_0F, _FD, "PADDW", Pq, Qq);
    define(_0F, _FE, "PADDD", Pq, Qq);

    define(_66, _0F, _F8, "PSUBB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _F9, "PSUBW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _FA, "PSUBD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _FB, "PSUBQ", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _FC, "PADDB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _FD, "PADDW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    define(_66, _0F, _FE, "PADDD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
  }

  TwoByteOpcodeMap() {
    super(AMD64Assembly.ASSEMBLY);
    create_low();
    create_high();
  }
}
