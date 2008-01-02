/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.ia32;

import static jasm.ia32.IA32GeneralRegister8.*;
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
import static jasm.tools.cisc.x86.OperandCode.*;
import jasm.tools.cisc.x86.X86InstructionDescriptionCreator;
import static jasm.util.HexByte.*;
import static jasm.x86.SegmentRegister.*;

final class TwoByteOpcodeMap extends X86InstructionDescriptionCreator {

  private void create_low() {
    define2B(_00, GROUP_6a);
    define2B(_00, GROUP_6b);
    define2B(_01, GROUP_7a);
    define2B(_01, GROUP_7b);
    define2B(_02, "LAR", Gv, Ev); // bug in table, wrongly suggesting Ew
    define2B(_03, "LSL", Gv, Ev); // bug in table, wrongly suggesting Ew
    define2B(_06, "CLTS");

    define2B(_20, "MOV", Rd, Cd);
    define2B(_21, "MOV", Rd, Dd);
    define2B(_22, "MOV", Cd, Rd);
    define2B(_23, "MOV", Dd, Rd);

    define2B(_30, "WRMSR");
    define2B(_31, "RDTSC");
    define2B(_32, "RDMSR");
    define2B(_33, "RDPMC");

    define2B(_40, "CMOVO", Gv, Ev);
    define2B(_41, "CMOVNO", Gv, Ev);
    define2B(_42, "CMOVB", Gv, Ev);
    define2B(_43, "CMOVNB", Gv, Ev);
    define2B(_44, "CMOVZ", Gv, Ev);
    define2B(_45, "CMOVNZ", Gv, Ev);
    define2B(_46, "CMOVBE", Gv, Ev);
    define2B(_47, "CMOVNBE", Gv, Ev);

    define2B(_60, "PUNPCKLBW", Pq, Qd);
    define2B(_61, "PUNPCKLWD", Pq, Qd);
    define2B(_62, "PUNPCKLDQ", Pq, Qd);
    define2B(_63, "PACKSSWB", Pq, Qd);
    define2B(_64, "PCMPGTB", Pq, Qd);
    define2B(_65, "PCMPGTW", Pq, Qd);
    define2B(_66, "PCMPGTD", Pq, Qd);
    define2B(_67, "PACKUSWB", Pq, Qd);

    define2B(_70, "PSHUFW", Pq, Qd, Ib);
    define2B(_71, GROUP_11);
    define2B(_72, GROUP_12);
    define2B(_73, GROUP_13);
    define2B(_74, "PCMPEQB", Pq, Qd);
    define2B(_75, "PCMPEQW", Pq, Qd);
    define2B(_76, "PCMPEQD", Pq, Qd);
    define2B(_77, "EMMS");

    define2B(_80, "JO", Jv);
    define2B(_81, "JNO", Jv);
    define2B(_82, "JB", Jv);
    define2B(_83, "JNB", Jv);
    define2B(_84, "JZ", Jv);
    define2B(_85, "JNZ", Jv);
    define2B(_86, "JBE", Jv);
    define2B(_87, "JNBE", Jv);

    define2B(_90, "SETO", Eb);
    define2B(_91, "SETNO", Eb);
    define2B(_92, "SETB", Eb);
    define2B(_93, "SETNB", Eb);
    define2B(_94, "SETZ", Eb);
    define2B(_95, "SETNZ", Eb);
    define2B(_96, "SETBE", Eb);
    define2B(_97, "SETNBE", Eb);

    define2B(_A0, "PUSH", FS);
    define2B(_A1, "POP", FS);
    define2B(_A2, "CPUID");
    define2B(_A3, "BT", Ev, Gv);
    define2B(_A4, "SHLD", Ev, Gv, Ib);
    define2B(_A5, "SHLD", Ev, Gv, CL);
    //define2B(_A6, "CMPXCHG", Xb, Ts); // invalid opcode or undocumented instruction?
    //define2B(_A7, "CMPXCHG", Ib, Ts); // invalid opcode or undocumented instruction?

    define2B(_B0, "CMPXCHG", Eb, Gb);
    define2B(_B1, "CMPXCHG", Ev, Gv);
    define2B(_B2, "LSS", Gv, Mp); // bug in table: no Gv
    define2B(_B3, "BTR", Ev, Gv);
    define2B(_B4, "LFS", Gv, Mp); // bug in table: no Gv
    define2B(_B5, "LGS", Gv, Mp); // bug in table: no Gv
    define2B(_B6, "MOVZXB", Gv, Eb).setExternalName("movzx");
    define2B(_B7, "MOVZXW", Gv, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    define2B(_C0, "XADD", Eb, Gb);
    define2B(_C1, "XADD", Ev, Gv);
    define2B(_C7, GROUP_9);

    define2B(_D1, "PSRLW", Pq, Qd);
    define2B(_D2, "PSRLD", Pq, Qd);
    define2B(_D3, "PSRLQ", Pq, Qd);
    define2B(_D5, "PMULLW", Pq, Qd);

    define2B(_E1, "PSRAW", Pq, Qd);
    define2B(_E2, "PSRAD", Pq, Qd);
    define2B(_E5, "PMULHW", Pq, Qd);

    define2B(_F1, "PSLLW", Pq, Qd);
    define2B(_F2, "PSLLD", Pq, Qd);
    define2B(_F3, "PSLLQ", Pq, Qd);
    define2B(_F5, "PMADDWD", Pq, Qd);
  }

  private void create_high() {
    define2B(_08, "INVD");
    define2B(_09, "WBINVD");
    define2B(_0B, "UD2");

    define2B(_48, "CMOVS", Gv, Ev);
    define2B(_49, "CMOVNS", Gv, Ev);
    define2B(_4A, "CMOVP", Gv, Ev);
    define2B(_4B, "CMOVNP", Gv, Ev);
    define2B(_4C, "CMOVL", Gv, Ev);
    define2B(_4D, "CMOVNL", Gv, Ev);
    define2B(_4E, "CMOVLE", Gv, Ev);
    define2B(_4F, "CMOVNLE", Gv, Ev);

    define2B(_68, "PUNPCKHBW", Pq, Qd);
    define2B(_69, "PUNPCKHWD", Pq, Qd);
    define2B(_6A, "PUNPCKHDQ", Pq, Qd);
    define2B(_6B, "PACKSSDW", Pq, Qd);
    define2B(_6E, "MOVD", Pd, Ed);
    define2B(_6F, "MOVQ", Pq, Qq);

    define2B(_7E, "MOVD", Ed, Pd);
    define2B(_7F, "MOVQ", Qq, Pq);

    define2B(_88, "JS", Jv);
    define2B(_89, "JNS", Jv);
    define2B(_8A, "JP", Jv);
    define2B(_8B, "JNP", Jv);
    define2B(_8C, "JL", Jv);
    define2B(_8D, "JNL", Jv);
    define2B(_8E, "JLE", Jv);
    define2B(_8F, "JNLE", Jv);

    define2B(_98, "SETS", Eb);
    define2B(_99, "SETNS", Eb);
    define2B(_9A, "SETP", Eb);
    define2B(_9B, "SETNP", Eb);
    define2B(_9C, "SETL", Eb);
    define2B(_9D, "SETNL", Eb);
    define2B(_9E, "SETLE", Eb);
    define2B(_9F, "SETNLE", Eb);

    define2B(_A8, "PUSH", GS);
    define2B(_A9, "POP", GS);
    define2B(_AA, "RSM");
    define2B(_AB, "BTS", Ev, Gv);
    define2B(_AC, "SHRD", Ev, Gv, Ib);
    define2B(_AD, "SHRD", Ev, Gv, CL);
    define2B(_AF, "IMUL", Gv, Ev);

    define2B(_B9, GROUP_10);
    define2B(_BA, GROUP_8, Ev, Ib);
    define2B(_BB, "BTC", Ev, Gv);
    define2B(_BC, "BSF", Gv, Ev);
    define2B(_BD, "BSR", Gv, Ev);
    define2B(_BE, "MOVSXB", Gv, Eb).setExternalName("movsx");
    define2B(_BF, "MOVSXW", Gv, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    define2B(_C8, "BSWAP", God);

    define2B(_D8, "PSUBUSB", Pq, Qq);
    define2B(_D9, "PSUBUSW", Pq, Qq);
    define2B(_DB, "PAND", Pq, Qq);
    define2B(_DC, "PADDUSB", Pq, Qq);
    define2B(_DD, "PADDUSW", Pq, Qq);
    define2B(_DF, "PANDN", Pq, Qq);

    define2B(_E8, "PSUBSB", Pq, Qq);
    define2B(_E9, "PSUBSW", Pq, Qq);
    define2B(_EB, "POR", Pq, Qq);
    define2B(_EC, "PADDSB", Pq, Qq);
    define2B(_ED, "PADDSW", Pq, Qq);
    define2B(_EF, "PXOR", Pq, Qq);

    define2B(_F8, "PSUBB", Pq, Qq);
    define2B(_F9, "PSUBW", Pq, Qq);
    define2B(_FA, "PSUBD", Pq, Qq);
    define2B(_FC, "PADDB", Pq, Qq);
    define2B(_FD, "PADDW", Pq, Qq);
    define2B(_FE, "PADDD", Pq, Qq);
  }

  TwoByteOpcodeMap() {
    super(IA32Assembly.ASSEMBLY);
    create_low();
    create_high();
  }
}
