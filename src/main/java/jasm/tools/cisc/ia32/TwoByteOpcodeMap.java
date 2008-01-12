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
import static jasm.tools.cisc.x86.StandardOperandCode.*;
import jasm.tools.cisc.x86.X86InstructionDescriptionCreator;
import static jasm.util.HexByte.*;
import static jasm.x86.SegmentRegister.*;

final class TwoByteOpcodeMap extends X86InstructionDescriptionCreator {

  private void create_low() {
    define2B(_00, GROUP_6a);
    define2B(_00, GROUP_6b);
    define2B(_01, GROUP_7a);
    define2B(_01, GROUP_7b);
    define2B(_02, "lar", Gv, Ev); // bug in table, wrongly suggesting Ew
    define2B(_03, "lsl", Gv, Ev); // bug in table, wrongly suggesting Ew
    define2B(_06, "clts");

    define2B(_20, "mov", Rd, Cd);
    define2B(_21, "mov", Rd, Dd);
    define2B(_22, "mov", Cd, Rd);
    define2B(_23, "mov", Dd, Rd);

    define2B(_30, "wrmsr");
    define2B(_31, "rdtsc");
    define2B(_32, "rdmsr");
    define2B(_33, "rdpmc");

    define2B(_40, "cmovo", Gv, Ev);
    define2B(_41, "cmovno", Gv, Ev);
    define2B(_42, "cmovb", Gv, Ev);
    define2B(_43, "cmovnb", Gv, Ev);
    define2B(_44, "cmovz", Gv, Ev);
    define2B(_45, "cmovnz", Gv, Ev);
    define2B(_46, "cmovbe", Gv, Ev);
    define2B(_47, "cmovnbe", Gv, Ev);

    define2B(_60, "punpcklbw", Pq, Qd);
    define2B(_61, "punpcklwd", Pq, Qd);
    define2B(_62, "punpckldq", Pq, Qd);
    define2B(_63, "packsswb", Pq, Qd);
    define2B(_64, "pcmpgtb", Pq, Qd);
    define2B(_65, "pcmpgtw", Pq, Qd);
    define2B(_66, "pcmpgtd", Pq, Qd);
    define2B(_67, "packuswb", Pq, Qd);

    define2B(_70, "pshufw", Pq, Qd, Ib);
    define2B(_71, GROUP_11);
    define2B(_72, GROUP_12);
    define2B(_73, GROUP_13);
    define2B(_74, "pcmpeqb", Pq, Qd);
    define2B(_75, "pcmpeqw", Pq, Qd);
    define2B(_76, "pcmpeqd", Pq, Qd);
    define2B(_77, "emms");

    define2B(_80, "jo", Jv);
    define2B(_81, "jno", Jv);
    define2B(_82, "jb", Jv);
    define2B(_83, "jnb", Jv);
    define2B(_84, "jz", Jv);
    define2B(_85, "jnz", Jv);
    define2B(_86, "jbe", Jv);
    define2B(_87, "jnbe", Jv);

    define2B(_90, "seto", Eb);
    define2B(_91, "setno", Eb);
    define2B(_92, "setb", Eb);
    define2B(_93, "setnb", Eb);
    define2B(_94, "setz", Eb);
    define2B(_95, "setnz", Eb);
    define2B(_96, "setbe", Eb);
    define2B(_97, "setnbe", Eb);

    define2B(_A0, "push", FS);
    define2B(_A1, "pop", FS);
    define2B(_A2, "cpuid");
    define2B(_A3, "bt", Ev, Gv);
    define2B(_A4, "shld", Ev, Gv, Ib);
    define2B(_A5, "shld", Ev, Gv, CL);
    //define2B(_A6, "cmpxchg", Xb, Ts); // invalid opcode or undocumented instruction?
    //define2B(_A7, "cmpxchg", Ib, Ts); // invalid opcode or undocumented instruction?

    define2B(_B0, "cmpxchg", Eb, Gb);
    define2B(_B1, "cmpxchg", Ev, Gv);
    define2B(_B2, "lss", Gv, Mp); // bug in table: no Gv
    define2B(_B3, "btr", Ev, Gv);
    define2B(_B4, "lfs", Gv, Mp); // bug in table: no Gv
    define2B(_B5, "lgs", Gv, Mp); // bug in table: no Gv
    define2B(_B6, "movzxb", Gv, Eb).setExternalName("movzx");
    define2B(_B7, "movzxw", Gv, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    define2B(_C0, "xadd", Eb, Gb);
    define2B(_C1, "xadd", Ev, Gv);
    define2B(_C7, GROUP_9);

    define2B(_D1, "psrlw", Pq, Qd);
    define2B(_D2, "psrld", Pq, Qd);
    define2B(_D3, "psrlq", Pq, Qd);
    define2B(_D5, "pmullw", Pq, Qd);

    define2B(_E1, "psraw", Pq, Qd);
    define2B(_E2, "psrad", Pq, Qd);
    define2B(_E5, "pmulhw", Pq, Qd);

    define2B(_F1, "psllw", Pq, Qd);
    define2B(_F2, "pslld", Pq, Qd);
    define2B(_F3, "psllq", Pq, Qd);
    define2B(_F5, "pmaddwd", Pq, Qd);
  }

  private void create_high() {
    define2B(_08, "invd");
    define2B(_09, "wbinvd");
    define2B(_0B, "ud2");

    define2B(_48, "cmovs", Gv, Ev);
    define2B(_49, "cmovns", Gv, Ev);
    define2B(_4A, "cmovp", Gv, Ev);
    define2B(_4B, "cmovnp", Gv, Ev);
    define2B(_4C, "cmovl", Gv, Ev);
    define2B(_4D, "cmovnl", Gv, Ev);
    define2B(_4E, "cmovle", Gv, Ev);
    define2B(_4F, "cmovnle", Gv, Ev);

    define2B(_68, "punpckhbw", Pq, Qd);
    define2B(_69, "punpckhwd", Pq, Qd);
    define2B(_6A, "punpckhdq", Pq, Qd);
    define2B(_6B, "packssdw", Pq, Qd);
    define2B(_6E, "movd", Pd, Ed);
    define2B(_6F, "movq", Pq, Qq);

    define2B(_7E, "movd", Ed, Pd);
    define2B(_7F, "movq", Qq, Pq);

    define2B(_88, "js", Jv);
    define2B(_89, "jns", Jv);
    define2B(_8A, "jp", Jv);
    define2B(_8B, "jnp", Jv);
    define2B(_8C, "jl", Jv);
    define2B(_8D, "jnl", Jv);
    define2B(_8E, "jle", Jv);
    define2B(_8F, "jnle", Jv);

    define2B(_98, "sets", Eb);
    define2B(_99, "setns", Eb);
    define2B(_9A, "setp", Eb);
    define2B(_9B, "setnp", Eb);
    define2B(_9C, "setl", Eb);
    define2B(_9D, "setnl", Eb);
    define2B(_9E, "setle", Eb);
    define2B(_9F, "setnle", Eb);

    define2B(_A8, "push", GS);
    define2B(_A9, "pop", GS);
    define2B(_AA, "rsm");
    define2B(_AB, "bts", Ev, Gv);
    define2B(_AC, "shrd", Ev, Gv, Ib);
    define2B(_AD, "shrd", Ev, Gv, CL);
    define2B(_AF, "imul", Gv, Ev);

    define2B(_B9, GROUP_10);
    define2B(_BA, GROUP_8, Ev, Ib);
    define2B(_BB, "btc", Ev, Gv);
    define2B(_BC, "bsf", Gv, Ev);
    define2B(_BD, "bsr", Gv, Ev);
    define2B(_BE, "movsxb", Gv, Eb).setExternalName("movsx");
    define2B(_BF, "movsxw", Gv, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    define2B(_C8, "bswap", God);

    define2B(_D8, "psubusb", Pq, Qq);
    define2B(_D9, "psubusw", Pq, Qq);
    define2B(_DB, "pand", Pq, Qq);
    define2B(_DC, "paddusb", Pq, Qq);
    define2B(_DD, "paddusw", Pq, Qq);
    define2B(_DF, "pandn", Pq, Qq);

    define2B(_E8, "psubsb", Pq, Qq);
    define2B(_E9, "psubsw", Pq, Qq);
    define2B(_EB, "por", Pq, Qq);
    define2B(_EC, "paddsb", Pq, Qq);
    define2B(_ED, "paddsw", Pq, Qq);
    define2B(_EF, "pxor", Pq, Qq);

    define2B(_F8, "psubb", Pq, Qq);
    define2B(_F9, "psubw", Pq, Qq);
    define2B(_FA, "psubd", Pq, Qq);
    define2B(_FC, "paddb", Pq, Qq);
    define2B(_FD, "paddw", Pq, Qq);
    define2B(_FE, "paddd", Pq, Qq);
  }

  TwoByteOpcodeMap() {
    super(IA32Assembly.ASSEMBLY);
    create_low();
    create_high();
  }
}
