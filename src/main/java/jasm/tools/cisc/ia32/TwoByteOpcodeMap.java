/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.ia32;

import static jasm.ia32.IA32GeneralRegister8.CL;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_10;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_11;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_12;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_13;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_6a;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_6b;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_7a;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_7b;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_8;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.GROUP_9;
import static jasm.tools.cisc.x86.OperandCode.Cd;
import static jasm.tools.cisc.x86.OperandCode.Dd;
import static jasm.tools.cisc.x86.OperandCode.Eb;
import static jasm.tools.cisc.x86.OperandCode.Ed;
import static jasm.tools.cisc.x86.OperandCode.Ev;
import static jasm.tools.cisc.x86.OperandCode.Ew;
import static jasm.tools.cisc.x86.OperandCode.Gb;
import static jasm.tools.cisc.x86.OperandCode.Gv;
import static jasm.tools.cisc.x86.OperandCode.Ib;
import static jasm.tools.cisc.x86.OperandCode.Jv;
import static jasm.tools.cisc.x86.OperandCode.Mp;
import static jasm.tools.cisc.x86.OperandCode.God;
import static jasm.tools.cisc.x86.OperandCode.Pd;
import static jasm.tools.cisc.x86.OperandCode.Pq;
import static jasm.tools.cisc.x86.OperandCode.Qd;
import static jasm.tools.cisc.x86.OperandCode.Qq;
import static jasm.tools.cisc.x86.OperandCode.Rd;
import jasm.tools.cisc.x86.X86InstructionDescriptionCreator;
import jasm.tools.cisc.x86.X86InstructionDescription;
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
import jasm.util.ArrayUtil;
import static jasm.x86.SegmentRegister.FS;
import static jasm.x86.SegmentRegister.GS;
import java.util.ArrayList;

final class TwoByteOpcodeMap extends X86InstructionDescriptionCreator {

  private void create_low() {
    defineTwoByte(_00, GROUP_6a);
    defineTwoByte(_00, GROUP_6b);
    defineTwoByte(_01, GROUP_7a);
    defineTwoByte(_01, GROUP_7b);
    defineTwoByte(_02, "LAR", Gv, Ev); // bug in table, wrongly suggesting Ew
    defineTwoByte(_03, "LSL", Gv, Ev); // bug in table, wrongly suggesting Ew
    defineTwoByte(_06, "CLTS");

    defineTwoByte(_20, "MOV", Rd, Cd);
    defineTwoByte(_21, "MOV", Rd, Dd);
    defineTwoByte(_22, "MOV", Cd, Rd);
    defineTwoByte(_23, "MOV", Dd, Rd);

    defineTwoByte(_30, "WRMSR");
    defineTwoByte(_31, "RDTSC");
    defineTwoByte(_32, "RDMSR");
    defineTwoByte(_33, "RDPMC");

    defineTwoByte(_40, "CMOVO", Gv, Ev);
    defineTwoByte(_41, "CMOVNO", Gv, Ev);
    defineTwoByte(_42, "CMOVB", Gv, Ev);
    defineTwoByte(_43, "CMOVNB", Gv, Ev);
    defineTwoByte(_44, "CMOVZ", Gv, Ev);
    defineTwoByte(_45, "CMOVNZ", Gv, Ev);
    defineTwoByte(_46, "CMOVBE", Gv, Ev);
    defineTwoByte(_47, "CMOVNBE", Gv, Ev);

    defineTwoByte(_60, "PUNPCKLBW", Pq, Qd);
    defineTwoByte(_61, "PUNPCKLWD", Pq, Qd);
    defineTwoByte(_62, "PUNPCKLDQ", Pq, Qd);
    defineTwoByte(_63, "PACKSSWB", Pq, Qd);
    defineTwoByte(_64, "PCMPGTB", Pq, Qd);
    defineTwoByte(_65, "PCMPGTW", Pq, Qd);
    defineTwoByte(_66, "PCMPGTD", Pq, Qd);
    defineTwoByte(_67, "PACKUSWB", Pq, Qd);

    defineTwoByte(_70, "PSHUFW", Pq, Qd, Ib);
    defineTwoByte(_71, GROUP_11);
    defineTwoByte(_72, GROUP_12);
    defineTwoByte(_73, GROUP_13);
    defineTwoByte(_74, "PCMPEQB", Pq, Qd);
    defineTwoByte(_75, "PCMPEQW", Pq, Qd);
    defineTwoByte(_76, "PCMPEQD", Pq, Qd);
    defineTwoByte(_77, "EMMS");

    defineTwoByte(_80, "JO", Jv);
    defineTwoByte(_81, "JNO", Jv);
    defineTwoByte(_82, "JB", Jv);
    defineTwoByte(_83, "JNB", Jv);
    defineTwoByte(_84, "JZ", Jv);
    defineTwoByte(_85, "JNZ", Jv);
    defineTwoByte(_86, "JBE", Jv);
    defineTwoByte(_87, "JNBE", Jv);

    defineTwoByte(_90, "SETO", Eb);
    defineTwoByte(_91, "SETNO", Eb);
    defineTwoByte(_92, "SETB", Eb);
    defineTwoByte(_93, "SETNB", Eb);
    defineTwoByte(_94, "SETZ", Eb);
    defineTwoByte(_95, "SETNZ", Eb);
    defineTwoByte(_96, "SETBE", Eb);
    defineTwoByte(_97, "SETNBE", Eb);

    defineTwoByte(_A0, "PUSH", FS);
    defineTwoByte(_A1, "POP", FS);
    defineTwoByte(_A2, "CPUID");
    defineTwoByte(_A3, "BT", Ev, Gv);
    defineTwoByte(_A4, "SHLD", Ev, Gv, Ib);
    defineTwoByte(_A5, "SHLD", Ev, Gv, CL);
    //defineTwoByte(_A6, "CMPXCHG", Xb, Ts); // invalid opcode or undocumented instruction?
    //defineTwoByte(_A7, "CMPXCHG", Ib, Ts); // invalid opcode or undocumented instruction?

    defineTwoByte(_B0, "CMPXCHG", Eb, Gb);
    defineTwoByte(_B1, "CMPXCHG", Ev, Gv);
    defineTwoByte(_B2, "LSS", Gv, Mp); // bug in table: no Gv
    defineTwoByte(_B3, "BTR", Ev, Gv);
    defineTwoByte(_B4, "LFS", Gv, Mp); // bug in table: no Gv
    defineTwoByte(_B5, "LGS", Gv, Mp); // bug in table: no Gv
    defineTwoByte(_B6, "MOVZXB", Gv, Eb).setExternalName("movzx");
    defineTwoByte(_B7, "MOVZXW", Gv, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    defineTwoByte(_C0, "XADD", Eb, Gb);
    defineTwoByte(_C1, "XADD", Ev, Gv);
    defineTwoByte(_C7, GROUP_9);

    defineTwoByte(_D1, "PSRLW", Pq, Qd);
    defineTwoByte(_D2, "PSRLD", Pq, Qd);
    defineTwoByte(_D3, "PSRLQ", Pq, Qd);
    defineTwoByte(_D5, "PMULLW", Pq, Qd);

    defineTwoByte(_E1, "PSRAW", Pq, Qd);
    defineTwoByte(_E2, "PSRAD", Pq, Qd);
    defineTwoByte(_E5, "PMULHW", Pq, Qd);

    defineTwoByte(_F1, "PSLLW", Pq, Qd);
    defineTwoByte(_F2, "PSLLD", Pq, Qd);
    defineTwoByte(_F3, "PSLLQ", Pq, Qd);
    defineTwoByte(_F5, "PMADDWD", Pq, Qd);
  }

  private void create_high() {
    defineTwoByte(_08, "INVD");
    defineTwoByte(_09, "WBINVD");
    defineTwoByte(_0B, "UD2");

    defineTwoByte(_48, "CMOVS", Gv, Ev);
    defineTwoByte(_49, "CMOVNS", Gv, Ev);
    defineTwoByte(_4A, "CMOVP", Gv, Ev);
    defineTwoByte(_4B, "CMOVNP", Gv, Ev);
    defineTwoByte(_4C, "CMOVL", Gv, Ev);
    defineTwoByte(_4D, "CMOVNL", Gv, Ev);
    defineTwoByte(_4E, "CMOVLE", Gv, Ev);
    defineTwoByte(_4F, "CMOVNLE", Gv, Ev);

    defineTwoByte(_68, "PUNPCKHBW", Pq, Qd);
    defineTwoByte(_69, "PUNPCKHWD", Pq, Qd);
    defineTwoByte(_6A, "PUNPCKHDQ", Pq, Qd);
    defineTwoByte(_6B, "PACKSSDW", Pq, Qd);
    defineTwoByte(_6E, "MOVD", Pd, Ed);
    defineTwoByte(_6F, "MOVQ", Pq, Qq);

    defineTwoByte(_7E, "MOVD", Ed, Pd);
    defineTwoByte(_7F, "MOVQ", Qq, Pq);

    defineTwoByte(_88, "JS", Jv);
    defineTwoByte(_89, "JNS", Jv);
    defineTwoByte(_8A, "JP", Jv);
    defineTwoByte(_8B, "JNP", Jv);
    defineTwoByte(_8C, "JL", Jv);
    defineTwoByte(_8D, "JNL", Jv);
    defineTwoByte(_8E, "JLE", Jv);
    defineTwoByte(_8F, "JNLE", Jv);

    defineTwoByte(_98, "SETS", Eb);
    defineTwoByte(_99, "SETNS", Eb);
    defineTwoByte(_9A, "SETP", Eb);
    defineTwoByte(_9B, "SETNP", Eb);
    defineTwoByte(_9C, "SETL", Eb);
    defineTwoByte(_9D, "SETNL", Eb);
    defineTwoByte(_9E, "SETLE", Eb);
    defineTwoByte(_9F, "SETNLE", Eb);

    defineTwoByte(_A8, "PUSH", GS);
    defineTwoByte(_A9, "POP", GS);
    defineTwoByte(_AA, "RSM");
    defineTwoByte(_AB, "BTS", Ev, Gv);
    defineTwoByte(_AC, "SHRD", Ev, Gv, Ib);
    defineTwoByte(_AD, "SHRD", Ev, Gv, CL);
    defineTwoByte(_AF, "IMUL", Gv, Ev);

    defineTwoByte(_B9, GROUP_10);
    defineTwoByte(_BA, GROUP_8, Ev, Ib);
    defineTwoByte(_BB, "BTC", Ev, Gv);
    defineTwoByte(_BC, "BSF", Gv, Ev);
    defineTwoByte(_BD, "BSR", Gv, Ev);
    defineTwoByte(_BE, "MOVSXB", Gv, Eb).setExternalName("movsx");
    defineTwoByte(_BF, "MOVSXW", Gv, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    defineTwoByte(_C8, "BSWAP", God);

    defineTwoByte(_D8, "PSUBUSB", Pq, Qq);
    defineTwoByte(_D9, "PSUBUSW", Pq, Qq);
    defineTwoByte(_DB, "PAND", Pq, Qq);
    defineTwoByte(_DC, "PADDUSB", Pq, Qq);
    defineTwoByte(_DD, "PADDUSW", Pq, Qq);
    defineTwoByte(_DF, "PANDN", Pq, Qq);

    defineTwoByte(_E8, "PSUBSB", Pq, Qq);
    defineTwoByte(_E9, "PSUBSW", Pq, Qq);
    defineTwoByte(_EB, "POR", Pq, Qq);
    defineTwoByte(_EC, "PADDSB", Pq, Qq);
    defineTwoByte(_ED, "PADDSW", Pq, Qq);
    defineTwoByte(_EF, "PXOR", Pq, Qq);

    defineTwoByte(_F8, "PSUBB", Pq, Qq);
    defineTwoByte(_F9, "PSUBW", Pq, Qq);
    defineTwoByte(_FA, "PSUBD", Pq, Qq);
    defineTwoByte(_FC, "PADDB", Pq, Qq);
    defineTwoByte(_FD, "PADDW", Pq, Qq);
    defineTwoByte(_FE, "PADDD", Pq, Qq);
  }

  TwoByteOpcodeMap() {
    super(IA32Assembly.ASSEMBLY);
    create_low();
    create_high();
  }

  private X86InstructionDescription defineTwoByte(Object... specifications) {
    final Object[] objects = ArrayUtil.flatten(specifications);
    final ArrayList<Object> specs = new ArrayList<Object>(objects.length + 1);
    specs.add(_0F);
    for (Object object : objects) {
      specs.add(object);
    }
    return defineInstructionDescription(specs);
  }
}
