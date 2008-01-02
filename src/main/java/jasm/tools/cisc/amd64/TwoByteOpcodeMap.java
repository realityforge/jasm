/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.amd64;

import static jasm.WordWidth.*;
import static jasm.amd64.AMD64GeneralRegister8.*;
import jasm.amd64.AMD64XMMRegister;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.*;
import jasm.tools.cisc.x86.ModCase;
import static jasm.tools.cisc.x86.OperandCode.*;
import jasm.tools.cisc.x86.X86InstructionDescriptionCreator;
import static jasm.util.HexByte.*;
import static jasm.x86.SegmentRegister.*;
import static jasm.x86.X86InstructionPrefix.*;

public final class TwoByteOpcodeMap extends X86InstructionDescriptionCreator {

  /**
   * See A-5 in the book.
   *
   * @see jasm.x86
   */
  private void create_low() {
    define2B(_00, GROUP_6a);
    define2B(_00, GROUP_6b);
    define2B(_01, GROUP_7a);
    define2B(_01, GROUP_7b);
    define2B(_02, "LAR", Gv, Ev); // bug in table, wrongly suggesting Ew
    define2B(_03, "LSL", Gv, Ev); // bug in table, wrongly suggesting Ew
    define2B(_05, "SYSCALL");
    define2B(_06, "CLTS");
    define2B(_07, "SYSRET");

    define2B(_10, "MOVUPS", Vps, Wps);
    define2B(_11, "MOVUPS", Wps, Vps);
    define2B(_12, "MOVLPS", Vps, Mq);
    define2B(_13, "MOVLPS", Mq, Vps); // MOVHLPS??
    define2B(_14, "UNPCKLPS", Vps, Wq);
    define2B(_15, "UNPCKHPS", Vps, Wq);
    define2B(_16, "MOVHPS", Vps, Mq);
    define2B(_17, "MOVHPS", Mq, Vps); // MOVLHPS ??

    define2B(_10, "MOVUPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_11, "MOVUPD", Wpd, Vpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_12, "MOVLPD", Vsd, Mq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_13, "MOVLPD", Mq, Vsd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_14, "UNPCKLPD", Vpd, Wq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_15, "UNPCKHPD", Vpd, Wq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_16, "MOVHPD", Vsd, Mq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_17, "MOVHPD", Mq, Vsd).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_10, "MOVSD", Vdq, Wsd).setMandatoryPrefix(REPNE);
    define2B(_10, "MOVSD", Vsd, Wsd).setMandatoryPrefix(REPNE);
    define2B(_11, "MOVSD", Wsd, Vsd).setMandatoryPrefix(REPNE);
    define2B(_12, "MOVDDUP", Vpd, Wsd).setMandatoryPrefix(REPNE);

    define2B(_10, "MOVSS", Vdq, Wss).setMandatoryPrefix(REPE);
    define2B(_10, "MOVSS", Vss, Wss).setMandatoryPrefix(REPE);
    define2B(_11, "MOVSS", Wss, Vss).setMandatoryPrefix(REPE);
    define2B(_12, "MOVSLDUP", Vps, Wps).setMandatoryPrefix(REPE);

    define2B(_20, "MOV", Rq, Cq);
    define2B(_21, "MOV", Rq, Dq);
    define2B(_22, "MOV", Cq, Rq);
    define2B(_23, "MOV", Dq, Rq);

    define2B(_30, "WRMSR");
    define2B(_31, "RDTSC");
    define2B(_32, "RDMSR");
    define2B(_33, "RDPMC");

    define2B(_40, "CMOVO", Gv, Ev);
    define2B(_41, "CMOVNO", Gv, Ev);
    define2B(_42, "CMOVB", Gv, Ev);
    define2B(_43, "CMOVAE", Gv, Ev);
    define2B(_44, "CMOVE", Gv, Ev);
    define2B(_45, "CMOVNE", Gv, Ev);
    define2B(_46, "CMOVBE", Gv, Ev);
    define2B(_47, "CMOVA", Gv, Ev);

    define2B(_50, "MOVMSKPS", Gd, Ups);
    define2B(_51, "SQRTPS", Vps, Wps);
    define2B(_52, "RSQRTPS", Vps, Wps);
    define2B(_53, "RCPPS", Vps, Wps);
    define2B(_54, "ANDPS", Vps, Wps);
    define2B(_55, "ANDNPS", Vps, Wps);
    define2B(_56, "ORPS", Vps, Wps);
    define2B(_57, "XORPS", Vps, Wps);

    define2B(_50, "MOVMSKPD", Gd, Upd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_51, "SQRTPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_54, "ANDPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_55, "ANDNPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_56, "ORPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_57, "XORPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_51, "SQRTSD", Vsd, Wsd).setMandatoryPrefix(REPNE);

    define2B(_51, "SQRTSS", Vss, Wss).setMandatoryPrefix(REPE);
    define2B(_52, "RSQRTSS", Vss, Wss).setMandatoryPrefix(REPE);
    define2B(_53, "RCPSS", Vss, Wss).setMandatoryPrefix(REPE);

    define2B(_60, "PUNPCKLBW", Pq, Qd);
    define2B(_61, "PUNPCKLWD", Pq, Qd);
    define2B(_62, "PUNPCKLDQ", Pq, Qd);
    define2B(_63, "PACKSSWB", Pq, Qd);
    define2B(_64, "PCMPGTB", Pq, Qq);
    define2B(_65, "PCMPGTW", Pq, Qq);
    define2B(_66, "PCMPGTD", Pq, Qq);
    define2B(_67, "PACKUSWB", Pq, Qq);

    define2B(_60, "PUNPCKLBW", Vdq, Wq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_61, "PUNPCKLWD", Vdq, Wq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_62, "PUNPCKLDQ", Vdq, Wq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_63, "PACKSSWB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_64, "PCMPGTB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_65, "PCMPGTW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_66, "PCMPGTD", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_67, "PACKUSWB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_70, "PSHUFW", Pq, Qq, Ib);
    define2B(_71, GROUP_12a);
    define2B(_72, GROUP_13a);
    define2B(_73, GROUP_14a);
    define2B(_74, "PCMPEQB", Pq, Qq);
    define2B(_75, "PCMPEQW", Pq, Qq);
    define2B(_76, "PCMPEQD", Pq, Qq);
    define2B(_77, "EMMS");

    define2B(_70, "PSHUFD", Vdq, Wdq, Ib).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_71, GROUP_12b).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_72, GROUP_13b).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_73, GROUP_14b).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_74, "PCMPEQB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_75, "PCMPEQW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_76, "PCMPEQD", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_70, "PSHUFLW", Vq, Wq, Ib).setMandatoryPrefix(REPNE);

    define2B(_70, "PSHUFHW", Vq, Wq, Ib).setMandatoryPrefix(REPE);

    define2B(_80, "JO", Jz).setDefaultOperandSize(BITS_64);
    define2B(_81, "JNO", Jz).setDefaultOperandSize(BITS_64);
    define2B(_82, "JB", Jz).setDefaultOperandSize(BITS_64);
    define2B(_83, "JNB", Jz).setDefaultOperandSize(BITS_64);
    define2B(_84, "JZ", Jz).setDefaultOperandSize(BITS_64);
    define2B(_85, "JNZ", Jz).setDefaultOperandSize(BITS_64);
    define2B(_86, "JBE", Jz).setDefaultOperandSize(BITS_64);
    define2B(_87, "JNBE", Jz).setDefaultOperandSize(BITS_64);

    define2B(_90, "SETO", Eb);
    define2B(_91, "SETNO", Eb);
    define2B(_92, "SETB", Eb);
    define2B(_93, "SETNB", Eb);
    define2B(_94, "SETZ", Eb);
    define2B(_95, "SETNZ", Eb);
    define2B(_96, "SETBE", Eb);
    define2B(_97, "SETNBE", Eb);

    define2B(_A0, "PUSH", FS).setDefaultOperandSize(BITS_64);
    define2B(_A1, "POP", FS).setDefaultOperandSize(BITS_64);
    define2B(_A2, "CPUID");
    define2B(_A3, "BT", Ev, Gv);
    define2B(_A4, "SHLD", Ev, Gv, Ib);
    define2B(_A5, "SHLD", Ev, Gv, CL);

    define2B(_B0, "CMPXCHG", Eb, Gb);
    define2B(_B1, "CMPXCHG", Ev, Gv);
    // define2B(_B2, "LSS", Gz, Mp); // legacy mode instruction
    define2B(_B3, "BTR", Ev, Gv);
    // define2B(_B4, "LFS", Gz, Mp); // legacy mode instruction
    // define2B(_B5, "LGS", Gz, Mp); // legacy mode instruction
    define2B(_B6, "MOVZXB", Gv, Eb).setExternalName("movzx");
    define2B(_B7, "MOVZXW", Gd_q, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    define2B(_C0, "XADD", Eb, Gb);
    define2B(_C1, "XADD", Ev, Gv);
    define2B(_C2, "CMPPS", Vps, Wps, ICb);
    define2B(_C3, "MOVNTI", Md_q, Gd_q);
    define2B(_C4, "PINSRW", Pq, Ed, Ib).requireOperandSize(BITS_32); // Ed instead of Ew to mimic intended Gd/Mw
    define2B(_C5, "PEXTRW", Gd, PRq, Ib);
    define2B(_C6, "SHUFPS", Vps, Wps, Ib);
    define2B(_C7, GROUP_9a).requireAddressSize(BITS_32); // depends on CPUID
    define2B(_C7, GROUP_9b).requireAddressSize(BITS_64).beNotExternallyTestable(); // depends on CPUID, rejected by gas on Opteron

    define2B(_C2, "CMPPD", Vpd, Wpd, ICb).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_C4, "PINSRW", Vdq, Ed, Ib).setMandatoryPrefix(OPERAND_SIZE).
        requireOperandSize(BITS_32); // Ed instead of Ew to mimic intended Gd/Mw
    define2B(_C5, "PEXTRW", Gd, Udq, Ib).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_C6, "SHUFPD", Vpd, Wpd, Ib).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_C2, "CMPSD", Vsd, Wsd, ICb).setMandatoryPrefix(REPNE);

    define2B(_C2, "CMPSS", Vss, Wss, ICb).setMandatoryPrefix(REPE);

    define2B(_D1, "PSRLW", Pq, Qq);
    define2B(_D2, "PSRLD", Pq, Qq);
    define2B(_D3, "PSRLQ", Pq, Qq);
    define2B(_D4, "PADDQ", Pq, Qq);
    define2B(_D5, "PMULLW", Pq, Qq);
    define2B(_D7, "PMOVMSKB", Gd, PRq);

    define2B(_D0, "ADDSUBPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_D1, "PSRLW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_D2, "PSRLD", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_D3, "PSRLQ", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_D4, "PADDQ", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_D5, "PMULLW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_D6, "MOVQ",
                  Wq.excludeExternalTestArguments(AMD64XMMRegister.SYMBOLS), Vq) // gas uses F3 0F 7E for reg-reg
        .setMandatoryPrefix(OPERAND_SIZE);
    define2B(_D7, "PMOVMSKB", Gd, Udq).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_D6, "MOVDQ2Q", Pq, Uq).setMandatoryPrefix(REPNE);

    define2B(_D6, "MOVQ2DQ", Vdq, PRq).setMandatoryPrefix(REPE);

    define2B(_E0, "PAVGB", Pq, Qq);
    define2B(_E1, "PSRAW", Pq, Qq);
    define2B(_E2, "PSRAD", Pq, Qq);
    define2B(_E3, "PAVGW", Pq, Qq);
    define2B(_E4, "PMULHUW", Pq, Qq);
    define2B(_E5, "PMULHW", Pq, Qq);
    define2B(_E7, "MOVNTQ", Mq, Pq);

    define2B(_E0, "PAVGB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_E1, "PSRAW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_E2, "PSRAD", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_E3, "PAVGW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_E4, "PMULHUW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_E5, "PMULHW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_E6, "CVTTPD2DQ", Vq, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_E7, "MVNTDQ", Mdq, Vdq).setMandatoryPrefix(OPERAND_SIZE).
        beNotExternallyTestable(); // gas does not know it

    define2B(_E6, "CVTPD2DQ", Vq, Wpd).setMandatoryPrefix(REPNE);

    define2B(_E6, "CVTDQ2PD", Vpd, Wq).setMandatoryPrefix(REPE);

    define2B(_F1, "PSLLW", Pq, Qq);
    define2B(_F2, "PSLLD", Pq, Qq);
    define2B(_F3, "PSLLQ", Pq, Qq);
    define2B(_F4, "PMULUDQ", Pq, Qq);
    define2B(_F5, "PMADDWD", Pq, Qq);
    define2B(_F6, "PSADBW", Pq, Qq);
    define2B(_F7, "MASKMOVQ", Pq, PRq);

    define2B(_F1, "PSLLW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_F2, "PSLLD", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_F3, "PSLLQ", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_F4, "PMULUDQ", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_F5, "PMADDWD", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_F6, "PSADBW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_F7, "MASKMOVDQU", Vdq, Udq).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_F0, "LDDQU", Vpd, Mdq).setMandatoryPrefix(REPNE);
  }

  /**
   * See A-6 in the book.
   *
   * @see jasm.x86
   */
  private void create_high() {
    define2B(_08, "INVD");
    define2B(_09, "WBINVD");
    define2B(_0B, "UD2");
    define2B(_0D, GROUP_P, Mb); // AMD64 table's manual lacks Mb
    define2B(_0E, "FEMMS");

    define2B(_18, GROUP_16, Mb); // AMD64 table's manual lacks Mb
    define2B(_19, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1A, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1B, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1C, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1D, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1E, "NOP").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1F, "NOP").beNotExternallyTestable(); // gas uses 0x90

    define2B(_28, "MOVAPS", Vps, Wps);
    define2B(_29, "MOVAPS", Wps, Vps);
    define2B(_2A, "CVTPI2PS", Vps, Qq);
    define2B(_2B, "MOVNTPS", Mdq, Vps);
    define2B(_2C, "CVTTPS2PI", Pq, Wps);
    define2B(_2D, "CVTPS2PI", Pq, Wps);
    define2B(_2E, "UCOMISS", Vss, Wss);
    define2B(_2F, "COMISS", Vps, Wps);

    define2B(_28, "MOVAPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_29, "MOVAPD", Wpd, Vpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_2A, "CVTPI2PD", Vpd, Qq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_2B, "MOVNTPD", Mdq, Vpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_2C, "CVTTPD2PI", Pq, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_2D, "CVTPD2PI", Pq, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_2E, "UCOMISD", Vsd, Wsd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_2F, "COMISD", Vpd, Wsd).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_2A, "CVTSI2SD", Vsd, Ed_q).setMandatoryPrefix(REPNE);
    define2B(_2C, "CVTTSD2SI", Gd_q, Wsd).setMandatoryPrefix(REPNE);
    define2B(_2D, "CVTSD2SI", Gd_q, Wsd).setMandatoryPrefix(REPNE);

    define2B(_2A, "CVTSI2SS", Vss, Ed_q).setMandatoryPrefix(REPE);
    define2B(_2C, "CVTTSS2SI", Gd_q, Wss).setMandatoryPrefix(REPE);
    define2B(_2D, "CVTSS2SI", Gd_q, Wss).setMandatoryPrefix(REPE);

    define2B(_48, "CMOVS", Gv, Ev);
    define2B(_49, "CMOVNS", Gv, Ev);
    define2B(_4A, "CMOVP", Gv, Ev);
    define2B(_4B, "CMOVNP", Gv, Ev);
    define2B(_4C, "CMOVL", Gv, Ev);
    define2B(_4D, "CMOVGE", Gv, Ev);
    define2B(_4E, "CMOVLE", Gv, Ev);
    define2B(_4F, "CMOVG", Gv, Ev);

    define2B(_58, "ADDPS", Vps, Wps);
    define2B(_59, "MULPS", Vps, Wps);
    define2B(_5A, "CVTPS2PD", Vpd, Wps);
    define2B(_5B, "CVTDQ2PS", Vps, Wdq);
    define2B(_5C, "SUBPS", Vps, Wps);
    define2B(_5D, "MINPS", Vps, Wps);
    define2B(_5E, "DIVPS", Vps, Wps);
    define2B(_5F, "MAXPS", Vps, Wps);

    define2B(_58, "ADDPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_59, "MULPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_5A, "CVTPD2PS", Vps, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_5B, "CVTPS2DQ", Vdq, Wps).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_5C, "SUBPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_5D, "MINPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_5E, "DIVPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_5F, "MAXPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_58, "ADDSD", Vsd, Wsd).setMandatoryPrefix(REPNE);
    define2B(_59, "MULSD", Vsd, Wsd).setMandatoryPrefix(REPNE);
    define2B(_5A, "CVTSD2SS", Vss, Wsd).setMandatoryPrefix(REPNE);
    define2B(_5C, "SUBSD", Vsd, Wsd).setMandatoryPrefix(REPNE);
    define2B(_5D, "MINSD", Vsd, Wsd).setMandatoryPrefix(REPNE);
    define2B(_5E, "DIVSD", Vsd, Wsd).setMandatoryPrefix(REPNE);
    define2B(_5F, "MAXSD", Vsd, Wsd).setMandatoryPrefix(REPNE);

    define2B(_58, "ADDSS", Vss, Wss).setMandatoryPrefix(REPE);
    define2B(_59, "MULSS", Vss, Wss).setMandatoryPrefix(REPE);
    define2B(_5A, "CVTSS2SD", Vsd, Wss).setMandatoryPrefix(REPE);
    define2B(_5B, "CVTTPS2DQ", Vdq, Wps).setMandatoryPrefix(REPE);
    define2B(_5C, "SUBSS", Vss, Wss).setMandatoryPrefix(REPE);
    define2B(_5D, "MINSS", Vss, Wss).setMandatoryPrefix(REPE);
    define2B(_5E, "DIVSS", Vss, Wss).setMandatoryPrefix(REPE);
    define2B(_5F, "MAXSS", Vss, Wss).setMandatoryPrefix(REPE);

    define2B(_68, "PUNPCKHBW", Pq, Qd);
    define2B(_69, "PUNPCKHWD", Pq, Qd);
    define2B(_6A, "PUNPCKHDQ", Pq, Qd);
    define2B(_6B, "PACKSSDW", Pq, Qq);
    define2B(_6E, "MOVD", Pq, Ed_q).beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    define2B(_6F, "MOVQ", Pq, Qq);

    define2B(_68, "PUNPCKHBW", Vdq, Wq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_69, "PUNPCKHWD", Vdq, Wq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_6A, "PUNPCKHDQ", Vdq, Wq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_6B, "PACKSSDW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_6C, "PUNPCKLQDQ", Vdq, Wq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_6D, "PUNPCKHQDQ", Vdq, Wq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_6E, "MOVD", Vdq, Ed_q).
        setMandatoryPrefix(OPERAND_SIZE).
        beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    define2B(_6F, "MOVDQA", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_6F, "MOVDQU", Vdq, Wdq).setMandatoryPrefix(REPE);

    define2B(_7E, "MOVD", Ed_q, Pq).beNotExternallyTestable(); // gas does not allow feature to distinguish operand width
    define2B(_7F, "MOVQ", Qq, Pq);

    define2B(_7C, "HADDPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_7D, "HSUBPD", Vpd, Wpd).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_7E, "MOVD", Ed_q, Vdq).
        setMandatoryPrefix(OPERAND_SIZE).
        beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    define2B(_7F, "MOVDQA", Wdq, Vdq).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_7C, "HADDPS", Vps, Wps).setMandatoryPrefix(REPNE);
    define2B(_7D, "HSUBPS", Vps, Wps).setMandatoryPrefix(REPNE);

    define2B(_7E, "MOVQ", Vq, Wq).setMandatoryPrefix(REPE);
    define2B(_7F, "MOVDQU", Wdq, Vdq).setMandatoryPrefix(REPE);

    define2B(_88, "JS", Jz).setDefaultOperandSize(BITS_64);
    define2B(_89, "JNS", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8A, "JP", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8B, "JNP", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8C, "JL", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8D, "JNL", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8E, "JLE", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8F, "JNLE", Jz).setDefaultOperandSize(BITS_64);

    define2B(_98, "SETS", Eb);
    define2B(_99, "SETNS", Eb);
    define2B(_9A, "SETP", Eb);
    define2B(_9B, "SETNP", Eb);
    define2B(_9C, "SETL", Eb);
    define2B(_9D, "SETNL", Eb);
    define2B(_9E, "SETLE", Eb);
    define2B(_9F, "SETNLE", Eb);

    define2B(_A8, "PUSH", GS).setDefaultOperandSize(BITS_64);
    define2B(_A9, "POP", GS).setDefaultOperandSize(BITS_64);
    define2B(_AA, "RSM");
    define2B(_AB, "BTS", Ev, Gv);
    define2B(_AC, "SHRD", Ev, Gv, Ib);
    define2B(_AD, "SHRD", Ev, Gv, CL);
    define2B(_AE, GROUP_15a);
    define2B(_AE, GROUP_15b, ModCase.MOD_3);
    define2B(_AF, "IMUL", Gv, Ev);

    define2B(_B9, GROUP_10);
    define2B(_BA, GROUP_8, Ev, Ib);
    define2B(_BB, "BTC", Ev, Gv);
    define2B(_BC, "BSF", Gv, Ev);
    define2B(_BD, "BSR", Gv, Ev);
    define2B(_BE, "MOVSXB", Gv, Eb).setExternalName("movsx");
    define2B(_BF, "MOVSXW", Gd_q, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    define2B(_C8, "BSWAP", God_q);

    define2B(_D8, "PSUBUSB", Pq, Qq);
    define2B(_D9, "PSUBUSW", Pq, Qq);
    define2B(_DA, "PMINUB", Pq, Qq);
    define2B(_DB, "PAND", Pq, Qq);
    define2B(_DC, "PADDUSB", Pq, Qq);
    define2B(_DD, "PADDUSW", Pq, Qq);
    define2B(_DE, "PMAXUB", Pq, Qq);
    define2B(_DF, "PANDN", Pq, Qq);

    define2B(_D8, "PSUBUSB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_D9, "PSUBUSW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_DA, "PMINUB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_DB, "PAND", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_DC, "PADDUSB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_DD, "PADDUSW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_DE, "PMAXUB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_DF, "PANDN", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_E8, "PSUBSB", Pq, Qq);
    define2B(_E9, "PSUBSW", Pq, Qq);
    define2B(_EA, "PMINSW", Pq, Qq);
    define2B(_EB, "POR", Pq, Qq);
    define2B(_EC, "PADDSB", Pq, Qq);
    define2B(_ED, "PADDSW", Pq, Qq);
    define2B(_EE, "PMAXSW", Pq, Qq);
    define2B(_EF, "PXOR", Pq, Qq);

    define2B(_E8, "PSUBSB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_E9, "PSUBSW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_EA, "PMINSW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_EB, "POR", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_EC, "PADDSB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_ED, "PADDSW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_EE, "PMAXSW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_EF, "PXOR", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);

    define2B(_F8, "PSUBB", Pq, Qq);
    define2B(_F9, "PSUBW", Pq, Qq);
    define2B(_FA, "PSUBD", Pq, Qq);
    define2B(_FB, "PSUBQ", Pq, Qq);
    define2B(_FC, "PADDB", Pq, Qq);
    define2B(_FD, "PADDW", Pq, Qq);
    define2B(_FE, "PADDD", Pq, Qq);

    define2B(_F8, "PSUBB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_F9, "PSUBW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_FA, "PSUBD", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_FB, "PSUBQ", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_FC, "PADDB", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_FD, "PADDW", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
    define2B(_FE, "PADDD", Vdq, Wdq).setMandatoryPrefix(OPERAND_SIZE);
  }

  TwoByteOpcodeMap() {
    super(AMD64Assembly.ASSEMBLY);
    create_low();
    create_high();
  }
}
