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
import static jasm.tools.cisc.x86.StandardOperandCode.*;
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
    define2B(_02, "lar", Gv, Ev); // bug in table, wrongly suggesting Ew
    define2B(_03, "lsl", Gv, Ev); // bug in table, wrongly suggesting Ew
    define2B(_05, "syscall");
    define2B(_06, "clts");
    define2B(_07, "sysret");

    define2B(_10, "movups", Vps, Wps);
    define2B(_11, "movups", Wps, Vps);
    define2B(_12, "movlps", Vps, Mq);
    define2B(_13, "movlps", Mq, Vps); // MOVHLPS??
    define2B(_14, "unpcklps", Vps, Wq);
    define2B(_15, "unpckhps", Vps, Wq);
    define2B(_16, "movhps", Vps, Mq);
    define2B(_17, "movhps", Mq, Vps); // MOVLHPS ??

    define2B(_10, "movupd", Vpd, Wpd).requireOperandPrefix();
    define2B(_11, "movupd", Wpd, Vpd).requireOperandPrefix();
    define2B(_12, "movlpd", Vsd, Mq).requireOperandPrefix();
    define2B(_13, "movlpd", Mq, Vsd).requireOperandPrefix();
    define2B(_14, "unpcklpd", Vpd, Wq).requireOperandPrefix();
    define2B(_15, "unpckhpd", Vpd, Wq).requireOperandPrefix();
    define2B(_16, "movhpd", Vsd, Mq).requireOperandPrefix();
    define2B(_17, "movhpd", Mq, Vsd).requireOperandPrefix();

    define2B(_10, "movsd", Vdq, Wsd).mandatoryGroup1Prefix(REPNE);
    define2B(_10, "movsd", Vsd, Wsd).mandatoryGroup1Prefix(REPNE);
    define2B(_11, "movsd", Wsd, Vsd).mandatoryGroup1Prefix(REPNE);
    define2B(_12, "movddup", Vpd, Wsd).mandatoryGroup1Prefix(REPNE);

    define2B(_10, "movss", Vdq, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_10, "movss", Vss, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_11, "movss", Wss, Vss).mandatoryGroup1Prefix(REPE);
    define2B(_12, "movsldup", Vps, Wps).mandatoryGroup1Prefix(REPE);

    define2B(_20, "mov", Rq, Cq);
    define2B(_21, "mov", Rq, Dq);
    define2B(_22, "mov", Cq, Rq);
    define2B(_23, "mov", Dq, Rq);

    define2B(_30, "wrmsr");
    define2B(_31, "rdtsc");
    define2B(_32, "rdmsr");
    define2B(_33, "rdpmc");

    define2B(_40, "cmovo", Gv, Ev);
    define2B(_41, "cmovno", Gv, Ev);
    define2B(_42, "cmovb", Gv, Ev);
    define2B(_43, "cmovae", Gv, Ev);
    define2B(_44, "cmove", Gv, Ev);
    define2B(_45, "cmovne", Gv, Ev);
    define2B(_46, "cmovbe", Gv, Ev);
    define2B(_47, "cmova", Gv, Ev);

    define2B(_50, "movmskps", Gd, Ups);
    define2B(_51, "sqrtps", Vps, Wps);
    define2B(_52, "rsqrtps", Vps, Wps);
    define2B(_53, "rcpps", Vps, Wps);
    define2B(_54, "andps", Vps, Wps);
    define2B(_55, "andnps", Vps, Wps);
    define2B(_56, "orps", Vps, Wps);
    define2B(_57, "xorps", Vps, Wps);

    define2B(_50, "movmskpd", Gd, Upd).requireOperandPrefix();
    define2B(_51, "sqrtpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_54, "andpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_55, "andnpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_56, "orpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_57, "xorpd", Vpd, Wpd).requireOperandPrefix();

    define2B(_51, "sqrtsd", Vsd, Wsd).mandatoryGroup1Prefix(REPNE);

    define2B(_51, "sqrtss", Vss, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_52, "rsqrtss", Vss, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_53, "rcpss", Vss, Wss).mandatoryGroup1Prefix(REPE);

    define2B(_60, "punpcklbw", Pq, Qd);
    define2B(_61, "punpcklwd", Pq, Qd);
    define2B(_62, "punpckldq", Pq, Qd);
    define2B(_63, "packsswb", Pq, Qd);
    define2B(_64, "pcmpgtb", Pq, Qq);
    define2B(_65, "pcmpgtw", Pq, Qq);
    define2B(_66, "pcmpgtd", Pq, Qq);
    define2B(_67, "packuswb", Pq, Qq);

    define2B(_60, "punpcklbw", Vdq, Wq).requireOperandPrefix();
    define2B(_61, "punpcklwd", Vdq, Wq).requireOperandPrefix();
    define2B(_62, "punpckldq", Vdq, Wq).requireOperandPrefix();
    define2B(_63, "packsswb", Vdq, Wdq).requireOperandPrefix();
    define2B(_64, "pcmpgtb", Vdq, Wdq).requireOperandPrefix();
    define2B(_65, "pcmpgtw", Vdq, Wdq).requireOperandPrefix();
    define2B(_66, "pcmpgtd", Vdq, Wdq).requireOperandPrefix();
    define2B(_67, "packuswb", Vdq, Wdq).requireOperandPrefix();

    define2B(_70, "pshufw", Pq, Qq, Ib);
    define2B(_71, GROUP_12a);
    define2B(_72, GROUP_13a);
    define2B(_73, GROUP_14a);
    define2B(_74, "pcmpeqb", Pq, Qq);
    define2B(_75, "pcmpeqw", Pq, Qq);
    define2B(_76, "pcmpeqd", Pq, Qq);
    define2B(_77, "emms");

    define2B(_70, "pshufd", Vdq, Wdq, Ib).requireOperandPrefix();
    define2B(_71, GROUP_12b).requireOperandPrefix();
    define2B(_72, GROUP_13b).requireOperandPrefix();
    define2B(_73, GROUP_14b).requireOperandPrefix();
    define2B(_74, "pcmpeqb", Vdq, Wdq).requireOperandPrefix();
    define2B(_75, "pcmpeqw", Vdq, Wdq).requireOperandPrefix();
    define2B(_76, "pcmpeqd", Vdq, Wdq).requireOperandPrefix();

    define2B(_70, "pshuflw", Vq, Wq, Ib).mandatoryGroup1Prefix(REPNE);

    define2B(_70, "pshufhw", Vq, Wq, Ib).mandatoryGroup1Prefix(REPE);

    define2B(_80, "jo", Jz).setDefaultOperandSize(BITS_64);
    define2B(_81, "jno", Jz).setDefaultOperandSize(BITS_64);
    define2B(_82, "jb", Jz).setDefaultOperandSize(BITS_64);
    define2B(_83, "jnb", Jz).setDefaultOperandSize(BITS_64);
    define2B(_84, "jz", Jz).setDefaultOperandSize(BITS_64);
    define2B(_85, "jnz", Jz).setDefaultOperandSize(BITS_64);
    define2B(_86, "jbe", Jz).setDefaultOperandSize(BITS_64);
    define2B(_87, "jnbe", Jz).setDefaultOperandSize(BITS_64);

    define2B(_90, "seto", Eb);
    define2B(_91, "setno", Eb);
    define2B(_92, "setb", Eb);
    define2B(_93, "setnb", Eb);
    define2B(_94, "setz", Eb);
    define2B(_95, "setnz", Eb);
    define2B(_96, "setbe", Eb);
    define2B(_97, "setnbe", Eb);

    define2B(_A0, "push", FS).setDefaultOperandSize(BITS_64);
    define2B(_A1, "pop", FS).setDefaultOperandSize(BITS_64);
    define2B(_A2, "cpuid");
    define2B(_A3, "bt", Ev, Gv);
    define2B(_A4, "shld", Ev, Gv, Ib);
    define2B(_A5, "shld", Ev, Gv, CL);

    define2B(_B0, "cmpxchg", Eb, Gb);
    define2B(_B1, "cmpxchg", Ev, Gv);
    // define2B(_B2, "lss", Gz, Mp); // legacy mode instruction
    define2B(_B3, "btr", Ev, Gv);
    // define2B(_B4, "lfs", Gz, Mp); // legacy mode instruction
    // define2B(_B5, "lgs", Gz, Mp); // legacy mode instruction
    define2B(_B6, "movzxb", Gv, Eb).setExternalName("movzx");
    define2B(_B7, "movzxw", Gd_q, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    define2B(_C0, "xadd", Eb, Gb);
    define2B(_C1, "xadd", Ev, Gv);
    define2B(_C2, "cmpps", Vps, Wps, ICb);
    define2B(_C3, "movnti", Md_q, Gd_q);
    define2B(_C4, "pinsrw", Pq, Ed, Ib).requireOperandSize(BITS_32); // Ed instead of Ew to mimic intended Gd/Mw
    define2B(_C5, "pextrw", Gd, PRq, Ib);
    define2B(_C6, "shufps", Vps, Wps, Ib);
    define2B(_C7, GROUP_9a).requireAddressSize(BITS_32); // depends on CPUID
    define2B(_C7, GROUP_9b).requireAddressSize(BITS_64).beNotExternallyTestable(); // depends on CPUID, rejected by gas on Opteron

    define2B(_C2, "cmppd", Vpd, Wpd, ICb).requireOperandPrefix();
    define2B(_C4, "pinsrw", Vdq, Ed, Ib).requireOperandPrefix().
        requireOperandSize(BITS_32); // Ed instead of Ew to mimic intended Gd/Mw
    define2B(_C5, "pextrw", Gd, Udq, Ib).requireOperandPrefix();
    define2B(_C6, "shufpd", Vpd, Wpd, Ib).requireOperandPrefix();

    define2B(_C2, "cmpsd", Vsd, Wsd, ICb).mandatoryGroup1Prefix(REPNE);

    define2B(_C2, "cmpss", Vss, Wss, ICb).mandatoryGroup1Prefix(REPE);

    define2B(_D1, "psrlw", Pq, Qq);
    define2B(_D2, "psrld", Pq, Qq);
    define2B(_D3, "psrlq", Pq, Qq);
    define2B(_D4, "paddq", Pq, Qq);
    define2B(_D5, "pmullw", Pq, Qq);
    define2B(_D7, "pmovmskb", Gd, PRq);

    define2B(_D0, "addsubpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_D1, "psrlw", Vdq, Wdq).requireOperandPrefix();
    define2B(_D2, "psrld", Vdq, Wdq).requireOperandPrefix();
    define2B(_D3, "psrlq", Vdq, Wdq).requireOperandPrefix();
    define2B(_D4, "paddq", Vdq, Wdq).requireOperandPrefix();
    define2B(_D5, "pmullw", Vdq, Wdq).requireOperandPrefix();
    define2B(_D6, "movq",
             Wq.excludeExternalTestArguments(AMD64XMMRegister.SYMBOLS), Vq) // gas uses F3 0F 7E for reg-reg
        .requireOperandPrefix();
    define2B(_D7, "pmovmskb", Gd, Udq).requireOperandPrefix();

    define2B(_D6, "movdq2q", Pq, Uq).mandatoryGroup1Prefix(REPNE);

    define2B(_D6, "movq2dq", Vdq, PRq).mandatoryGroup1Prefix(REPE);

    define2B(_E0, "pavgb", Pq, Qq);
    define2B(_E1, "psraw", Pq, Qq);
    define2B(_E2, "psrad", Pq, Qq);
    define2B(_E3, "pavgw", Pq, Qq);
    define2B(_E4, "pmulhuw", Pq, Qq);
    define2B(_E5, "pmulhw", Pq, Qq);
    define2B(_E7, "movntq", Mq, Pq);

    define2B(_E0, "pavgb", Vdq, Wdq).requireOperandPrefix();
    define2B(_E1, "psraw", Vdq, Wdq).requireOperandPrefix();
    define2B(_E2, "psrad", Vdq, Wdq).requireOperandPrefix();
    define2B(_E3, "pavgw", Vdq, Wdq).requireOperandPrefix();
    define2B(_E4, "pmulhuw", Vdq, Wdq).requireOperandPrefix();
    define2B(_E5, "pmulhw", Vdq, Wdq).requireOperandPrefix();
    define2B(_E6, "cvttpd2dq", Vq, Wpd).requireOperandPrefix();
    define2B(_E7, "mvntdq", Mdq, Vdq).requireOperandPrefix().
        beNotExternallyTestable(); // gas does not know it

    define2B(_E6, "cvtpd2dq", Vq, Wpd).mandatoryGroup1Prefix(REPNE);

    define2B(_E6, "cvtdq2pd", Vpd, Wq).mandatoryGroup1Prefix(REPE);

    define2B(_F1, "psllw", Pq, Qq);
    define2B(_F2, "pslld", Pq, Qq);
    define2B(_F3, "psllq", Pq, Qq);
    define2B(_F4, "pmuludq", Pq, Qq);
    define2B(_F5, "pmaddwd", Pq, Qq);
    define2B(_F6, "psadbw", Pq, Qq);
    define2B(_F7, "maskmovq", Pq, PRq);

    define2B(_F1, "psllw", Vdq, Wdq).requireOperandPrefix();
    define2B(_F2, "pslld", Vdq, Wdq).requireOperandPrefix();
    define2B(_F3, "psllq", Vdq, Wdq).requireOperandPrefix();
    define2B(_F4, "pmuludq", Vdq, Wdq).requireOperandPrefix();
    define2B(_F5, "pmaddwd", Vdq, Wdq).requireOperandPrefix();
    define2B(_F6, "psadbw", Vdq, Wdq).requireOperandPrefix();
    define2B(_F7, "maskmovdqu", Vdq, Udq).requireOperandPrefix();

    define2B(_F0, "lddqu", Vpd, Mdq).mandatoryGroup1Prefix(REPNE);
  }

  /**
   * See A-6 in the book.
   *
   * @see jasm.x86
   */
  private void create_high() {
    define2B(_08, "invd");
    define2B(_09, "wbinvd");
    define2B(_0B, "ud2");
    define2B(_0D, GROUP_P, Mb); // AMD64 table's manual lacks Mb
    define2B(_0E, "femms");

    define2B(_18, GROUP_16, Mb); // AMD64 table's manual lacks Mb
    define2B(_19, "nop").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1A, "nop").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1B, "nop").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1C, "nop").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1D, "nop").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1E, "nop").beNotExternallyTestable(); // gas uses 0x90
    define2B(_1F, "nop").beNotExternallyTestable(); // gas uses 0x90

    define2B(_28, "movaps", Vps, Wps);
    define2B(_29, "movaps", Wps, Vps);
    define2B(_2A, "cvtpi2ps", Vps, Qq);
    define2B(_2B, "movntps", Mdq, Vps);
    define2B(_2C, "cvttps2pi", Pq, Wps);
    define2B(_2D, "cvtps2pi", Pq, Wps);
    define2B(_2E, "ucomiss", Vss, Wss);
    define2B(_2F, "comiss", Vps, Wps);

    define2B(_28, "movapd", Vpd, Wpd).requireOperandPrefix();
    define2B(_29, "movapd", Wpd, Vpd).requireOperandPrefix();
    define2B(_2A, "cvtpi2pd", Vpd, Qq).requireOperandPrefix();
    define2B(_2B, "movntpd", Mdq, Vpd).requireOperandPrefix();
    define2B(_2C, "cvttpd2pi", Pq, Wpd).requireOperandPrefix();
    define2B(_2D, "cvtpd2pi", Pq, Wpd).requireOperandPrefix();
    define2B(_2E, "ucomisd", Vsd, Wsd).requireOperandPrefix();
    define2B(_2F, "comisd", Vpd, Wsd).requireOperandPrefix();

    define2B(_2A, "cvtsi2sd", Vsd, Ed_q).mandatoryGroup1Prefix(REPNE);
    define2B(_2C, "cvttsd2si", Gd_q, Wsd).mandatoryGroup1Prefix(REPNE);
    define2B(_2D, "cvtsd2si", Gd_q, Wsd).mandatoryGroup1Prefix(REPNE);

    define2B(_2A, "cvtsi2ss", Vss, Ed_q).mandatoryGroup1Prefix(REPE);
    define2B(_2C, "cvttss2si", Gd_q, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_2D, "cvtss2si", Gd_q, Wss).mandatoryGroup1Prefix(REPE);

    define2B(_48, "cmovs", Gv, Ev);
    define2B(_49, "cmovns", Gv, Ev);
    define2B(_4A, "cmovp", Gv, Ev);
    define2B(_4B, "cmovnp", Gv, Ev);
    define2B(_4C, "cmovl", Gv, Ev);
    define2B(_4D, "cmovge", Gv, Ev);
    define2B(_4E, "cmovle", Gv, Ev);
    define2B(_4F, "cmovg", Gv, Ev);

    define2B(_58, "addps", Vps, Wps);
    define2B(_59, "mulps", Vps, Wps);
    define2B(_5A, "cvtps2pd", Vpd, Wps);
    define2B(_5B, "cvtdq2ps", Vps, Wdq);
    define2B(_5C, "subps", Vps, Wps);
    define2B(_5D, "minps", Vps, Wps);
    define2B(_5E, "divps", Vps, Wps);
    define2B(_5F, "maxps", Vps, Wps);

    define2B(_58, "addpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_59, "mulpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_5A, "cvtpd2ps", Vps, Wpd).requireOperandPrefix();
    define2B(_5B, "cvtps2dq", Vdq, Wps).requireOperandPrefix();
    define2B(_5C, "subpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_5D, "minpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_5E, "divpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_5F, "maxpd", Vpd, Wpd).requireOperandPrefix();

    define2B(_58, "addsd", Vsd, Wsd).mandatoryGroup1Prefix(REPNE);
    define2B(_59, "mulsd", Vsd, Wsd).mandatoryGroup1Prefix(REPNE);
    define2B(_5A, "cvtsd2ss", Vss, Wsd).mandatoryGroup1Prefix(REPNE);
    define2B(_5C, "subsd", Vsd, Wsd).mandatoryGroup1Prefix(REPNE);
    define2B(_5D, "minsd", Vsd, Wsd).mandatoryGroup1Prefix(REPNE);
    define2B(_5E, "divsd", Vsd, Wsd).mandatoryGroup1Prefix(REPNE);
    define2B(_5F, "maxsd", Vsd, Wsd).mandatoryGroup1Prefix(REPNE);

    define2B(_58, "addss", Vss, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_59, "mulss", Vss, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_5A, "cvtss2sd", Vsd, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_5B, "cvttps2dq", Vdq, Wps).mandatoryGroup1Prefix(REPE);
    define2B(_5C, "subss", Vss, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_5D, "minss", Vss, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_5E, "divss", Vss, Wss).mandatoryGroup1Prefix(REPE);
    define2B(_5F, "maxss", Vss, Wss).mandatoryGroup1Prefix(REPE);

    define2B(_68, "punpckhbw", Pq, Qd);
    define2B(_69, "punpckhwd", Pq, Qd);
    define2B(_6A, "punpckhdq", Pq, Qd);
    define2B(_6B, "packssdw", Pq, Qq);
    define2B(_6E, "movd", Pq, Ed_q).beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    define2B(_6F, "movq", Pq, Qq);

    define2B(_68, "punpckhbw", Vdq, Wq).requireOperandPrefix();
    define2B(_69, "punpckhwd", Vdq, Wq).requireOperandPrefix();
    define2B(_6A, "punpckhdq", Vdq, Wq).requireOperandPrefix();
    define2B(_6B, "packssdw", Vdq, Wdq).requireOperandPrefix();
    define2B(_6C, "punpcklqdq", Vdq, Wq).requireOperandPrefix();
    define2B(_6D, "punpckhqdq", Vdq, Wq).requireOperandPrefix();
    define2B(_6E, "movd", Vdq, Ed_q).
        requireOperandPrefix().
        beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    define2B(_6F, "movdqa", Vdq, Wdq).requireOperandPrefix();

    define2B(_6F, "movdqu", Vdq, Wdq).mandatoryGroup1Prefix(REPE);

    define2B(_7E, "movd", Ed_q, Pq).beNotExternallyTestable(); // gas does not allow feature to distinguish operand width
    define2B(_7F, "movq", Qq, Pq);

    define2B(_7C, "haddpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_7D, "hsubpd", Vpd, Wpd).requireOperandPrefix();
    define2B(_7E, "movd", Ed_q, Vdq).
        requireOperandPrefix().
        beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    define2B(_7F, "movdqa", Wdq, Vdq).requireOperandPrefix();

    define2B(_7C, "haddps", Vps, Wps).mandatoryGroup1Prefix(REPNE);
    define2B(_7D, "hsubps", Vps, Wps).mandatoryGroup1Prefix(REPNE);

    define2B(_7E, "movq", Vq, Wq).mandatoryGroup1Prefix(REPE);
    define2B(_7F, "movdqu", Wdq, Vdq).mandatoryGroup1Prefix(REPE);

    define2B(_88, "js", Jz).setDefaultOperandSize(BITS_64);
    define2B(_89, "jns", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8A, "jp", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8B, "jnp", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8C, "jl", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8D, "jnl", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8E, "jle", Jz).setDefaultOperandSize(BITS_64);
    define2B(_8F, "jnle", Jz).setDefaultOperandSize(BITS_64);

    define2B(_98, "sets", Eb);
    define2B(_99, "setns", Eb);
    define2B(_9A, "setp", Eb);
    define2B(_9B, "setnp", Eb);
    define2B(_9C, "setl", Eb);
    define2B(_9D, "setnl", Eb);
    define2B(_9E, "setle", Eb);
    define2B(_9F, "setnle", Eb);

    define2B(_A8, "push", GS).setDefaultOperandSize(BITS_64);
    define2B(_A9, "pop", GS).setDefaultOperandSize(BITS_64);
    define2B(_AA, "rsm");
    define2B(_AB, "bts", Ev, Gv);
    define2B(_AC, "shrd", Ev, Gv, Ib);
    define2B(_AD, "shrd", Ev, Gv, CL);
    define2B(_AE, GROUP_15a);
    define2B(_AE, GROUP_15b, ModCase.MOD_3);
    define2B(_AF, "imul", Gv, Ev);

    define2B(_B9, GROUP_10);
    define2B(_BA, GROUP_8, Ev, Ib);
    define2B(_BB, "btc", Ev, Gv);
    define2B(_BC, "bsf", Gv, Ev);
    define2B(_BD, "bsr", Gv, Ev);
    define2B(_BE, "movsxb", Gv, Eb).setExternalName("movsx");
    define2B(_BF, "movsxw", Gd_q, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    define2B(_C8, "bswap", God_q);

    define2B(_D8, "psubusb", Pq, Qq);
    define2B(_D9, "psubusw", Pq, Qq);
    define2B(_DA, "pminub", Pq, Qq);
    define2B(_DB, "pand", Pq, Qq);
    define2B(_DC, "paddusb", Pq, Qq);
    define2B(_DD, "paddusw", Pq, Qq);
    define2B(_DE, "pmaxub", Pq, Qq);
    define2B(_DF, "pandn", Pq, Qq);

    define2B(_D8, "psubusb", Vdq, Wdq).requireOperandPrefix();
    define2B(_D9, "psubusw", Vdq, Wdq).requireOperandPrefix();
    define2B(_DA, "pminub", Vdq, Wdq).requireOperandPrefix();
    define2B(_DB, "pand", Vdq, Wdq).requireOperandPrefix();
    define2B(_DC, "paddusb", Vdq, Wdq).requireOperandPrefix();
    define2B(_DD, "paddusw", Vdq, Wdq).requireOperandPrefix();
    define2B(_DE, "pmaxub", Vdq, Wdq).requireOperandPrefix();
    define2B(_DF, "pandn", Vdq, Wdq).requireOperandPrefix();

    define2B(_E8, "psubsb", Pq, Qq);
    define2B(_E9, "psubsw", Pq, Qq);
    define2B(_EA, "pminsw", Pq, Qq);
    define2B(_EB, "por", Pq, Qq);
    define2B(_EC, "paddsb", Pq, Qq);
    define2B(_ED, "paddsw", Pq, Qq);
    define2B(_EE, "pmaxsw", Pq, Qq);
    define2B(_EF, "pxor", Pq, Qq);

    define2B(_E8, "psubsb", Vdq, Wdq).requireOperandPrefix();
    define2B(_E9, "psubsw", Vdq, Wdq).requireOperandPrefix();
    define2B(_EA, "pminsw", Vdq, Wdq).requireOperandPrefix();
    define2B(_EB, "por", Vdq, Wdq).requireOperandPrefix();
    define2B(_EC, "paddsb", Vdq, Wdq).requireOperandPrefix();
    define2B(_ED, "paddsw", Vdq, Wdq).requireOperandPrefix();
    define2B(_EE, "pmaxsw", Vdq, Wdq).requireOperandPrefix();
    define2B(_EF, "pxor", Vdq, Wdq).requireOperandPrefix();

    define2B(_F8, "psubb", Pq, Qq);
    define2B(_F9, "psubw", Pq, Qq);
    define2B(_FA, "psubd", Pq, Qq);
    define2B(_FB, "psubq", Pq, Qq);
    define2B(_FC, "paddb", Pq, Qq);
    define2B(_FD, "paddw", Pq, Qq);
    define2B(_FE, "paddd", Pq, Qq);

    define2B(_F8, "psubb", Vdq, Wdq).requireOperandPrefix();
    define2B(_F9, "psubw", Vdq, Wdq).requireOperandPrefix();
    define2B(_FA, "psubd", Vdq, Wdq).requireOperandPrefix();
    define2B(_FB, "psubq", Vdq, Wdq).requireOperandPrefix();
    define2B(_FC, "paddb", Vdq, Wdq).requireOperandPrefix();
    define2B(_FD, "paddw", Vdq, Wdq).requireOperandPrefix();
    define2B(_FE, "paddd", Vdq, Wdq).requireOperandPrefix();
  }

  TwoByteOpcodeMap() {
    super(AMD64Assembly.ASSEMBLY);
    create_low();
    create_high();
  }
}
