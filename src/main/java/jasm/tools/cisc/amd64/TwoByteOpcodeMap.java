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
import static jasm.amd64.AMD64GeneralRegister8.*;
import jasm.amd64.AMD64XMMRegister;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.*;
import jasm.tools.cisc.x86.ModCase;
import static jasm.tools.cisc.x86.OperandCode.*;
import jasm.tools.cisc.x86.X86InstructionDescription;
import jasm.tools.cisc.x86.X86InstructionDescriptionCreator;
import jasm.tools.cisc.x86.X86InstructionPrefix;
import jasm.util.ArrayUtil;
import static jasm.util.HexByte.*;
import static jasm.x86.SegmentRegister.FS;
import static jasm.x86.SegmentRegister.GS;
import java.util.ArrayList;

public final class TwoByteOpcodeMap extends X86InstructionDescriptionCreator {

  /**
   * See A-5 in the book.
   *
   * @see jasm.x86
   */
  private void create_low() {
    defineTwoByte(_00, GROUP_6a);
    defineTwoByte(_00, GROUP_6b);
    defineTwoByte(_01, GROUP_7a);
    defineTwoByte(_01, GROUP_7b);
    defineTwoByte(_02, "LAR", Gv, Ev); // bug in table, wrongly suggesting Ew
    defineTwoByte(_03, "LSL", Gv, Ev); // bug in table, wrongly suggesting Ew
    defineTwoByte(_05, "SYSCALL");
    defineTwoByte(_06, "CLTS");
    defineTwoByte(_07, "SYSRET");

    defineTwoByte(_10, "MOVUPS", Vps, Wps);
    defineTwoByte(_11, "MOVUPS", Wps, Vps);
    defineTwoByte(_12, "MOVLPS", Vps, Mq);
    defineTwoByte(_13, "MOVLPS", Mq, Vps); // MOVHLPS??
    defineTwoByte(_14, "UNPCKLPS", Vps, Wq);
    defineTwoByte(_15, "UNPCKHPS", Vps, Wq);
    defineTwoByte(_16, "MOVHPS", Vps, Mq);
    defineTwoByte(_17, "MOVHPS", Mq, Vps); // MOVLHPS ??

    defineTwoByte(_10, "MOVUPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_11, "MOVUPD", Wpd, Vpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_12, "MOVLPD", Vsd, Mq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_13, "MOVLPD", Mq, Vsd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_14, "UNPCKLPD", Vpd, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_15, "UNPCKHPD", Vpd, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_16, "MOVHPD", Vsd, Mq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_17, "MOVHPD", Mq, Vsd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_10, "MOVSD", Vdq, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_10, "MOVSD", Vsd, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_11, "MOVSD", Wsd, Vsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_12, "MOVDDUP", Vpd, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);

    defineTwoByte(_10, "MOVSS", Vdq, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_10, "MOVSS", Vss, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_11, "MOVSS", Wss, Vss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_12, "MOVSLDUP", Vps, Wps).setMandatoryPrefix(X86InstructionPrefix.REPE);

    defineTwoByte(_20, "MOV", Rq, Cq);
    defineTwoByte(_21, "MOV", Rq, Dq);
    defineTwoByte(_22, "MOV", Cq, Rq);
    defineTwoByte(_23, "MOV", Dq, Rq);

    defineTwoByte(_30, "WRMSR");
    defineTwoByte(_31, "RDTSC");
    defineTwoByte(_32, "RDMSR");
    defineTwoByte(_33, "RDPMC");

    defineTwoByte(_40, "CMOVO", Gv, Ev);
    defineTwoByte(_41, "CMOVNO", Gv, Ev);
    defineTwoByte(_42, "CMOVB", Gv, Ev);
    defineTwoByte(_43, "CMOVAE", Gv, Ev);
    defineTwoByte(_44, "CMOVE", Gv, Ev);
    defineTwoByte(_45, "CMOVNE", Gv, Ev);
    defineTwoByte(_46, "CMOVBE", Gv, Ev);
    defineTwoByte(_47, "CMOVA", Gv, Ev);

    defineTwoByte(_50, "MOVMSKPS", Gd, Ups);
    defineTwoByte(_51, "SQRTPS", Vps, Wps);
    defineTwoByte(_52, "RSQRTPS", Vps, Wps);
    defineTwoByte(_53, "RCPPS", Vps, Wps);
    defineTwoByte(_54, "ANDPS", Vps, Wps);
    defineTwoByte(_55, "ANDNPS", Vps, Wps);
    defineTwoByte(_56, "ORPS", Vps, Wps);
    defineTwoByte(_57, "XORPS", Vps, Wps);

    defineTwoByte(_50, "MOVMSKPD", Gd, Upd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_51, "SQRTPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_54, "ANDPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_55, "ANDNPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_56, "ORPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_57, "XORPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_51, "SQRTSD", Vsd, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);

    defineTwoByte(_51, "SQRTSS", Vss, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_52, "RSQRTSS", Vss, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_53, "RCPSS", Vss, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);

    defineTwoByte(_60, "PUNPCKLBW", Pq, Qd);
    defineTwoByte(_61, "PUNPCKLWD", Pq, Qd);
    defineTwoByte(_62, "PUNPCKLDQ", Pq, Qd);
    defineTwoByte(_63, "PACKSSWB", Pq, Qd);
    defineTwoByte(_64, "PCMPGTB", Pq, Qq);
    defineTwoByte(_65, "PCMPGTW", Pq, Qq);
    defineTwoByte(_66, "PCMPGTD", Pq, Qq);
    defineTwoByte(_67, "PACKUSWB", Pq, Qq);

    defineTwoByte(_60, "PUNPCKLBW", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_61, "PUNPCKLWD", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_62, "PUNPCKLDQ", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_63, "PACKSSWB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_64, "PCMPGTB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_65, "PCMPGTW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_66, "PCMPGTD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_67, "PACKUSWB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_70, "PSHUFW", Pq, Qq, Ib);
    defineTwoByte(_71, GROUP_12a);
    defineTwoByte(_72, GROUP_13a);
    defineTwoByte(_73, GROUP_14a);
    defineTwoByte(_74, "PCMPEQB", Pq, Qq);
    defineTwoByte(_75, "PCMPEQW", Pq, Qq);
    defineTwoByte(_76, "PCMPEQD", Pq, Qq);
    defineTwoByte(_77, "EMMS");

    defineTwoByte(_70, "PSHUFD", Vdq, Wdq, Ib).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_71, GROUP_12b).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_72, GROUP_13b).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_73, GROUP_14b).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_74, "PCMPEQB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_75, "PCMPEQW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_76, "PCMPEQD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_70, "PSHUFLW", Vq, Wq, Ib).setMandatoryPrefix(X86InstructionPrefix.REPNE);

    defineTwoByte(_70, "PSHUFHW", Vq, Wq, Ib).setMandatoryPrefix(X86InstructionPrefix.REPE);

    defineTwoByte(_80, "JO", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_81, "JNO", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_82, "JB", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_83, "JNB", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_84, "JZ", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_85, "JNZ", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_86, "JBE", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_87, "JNBE", Jz).setDefaultOperandSize(WordWidth.BITS_64);

    defineTwoByte(_90, "SETO", Eb);
    defineTwoByte(_91, "SETNO", Eb);
    defineTwoByte(_92, "SETB", Eb);
    defineTwoByte(_93, "SETNB", Eb);
    defineTwoByte(_94, "SETZ", Eb);
    defineTwoByte(_95, "SETNZ", Eb);
    defineTwoByte(_96, "SETBE", Eb);
    defineTwoByte(_97, "SETNBE", Eb);

    defineTwoByte(_A0, "PUSH", FS).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_A1, "POP", FS).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_A2, "CPUID");
    defineTwoByte(_A3, "BT", Ev, Gv);
    defineTwoByte(_A4, "SHLD", Ev, Gv, Ib);
    defineTwoByte(_A5, "SHLD", Ev, Gv, CL);

    defineTwoByte(_B0, "CMPXCHG", Eb, Gb);
    defineTwoByte(_B1, "CMPXCHG", Ev, Gv);
    // defineTwoByte(_B2, "LSS", Gz, Mp); // legacy mode instruction
    defineTwoByte(_B3, "BTR", Ev, Gv);
    // defineTwoByte(_B4, "LFS", Gz, Mp); // legacy mode instruction
    // defineTwoByte(_B5, "LGS", Gz, Mp); // legacy mode instruction
    defineTwoByte(_B6, "MOVZXB", Gv, Eb).setExternalName("movzx");
    defineTwoByte(_B7, "MOVZXW", Gd_q, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    defineTwoByte(_C0, "XADD", Eb, Gb);
    defineTwoByte(_C1, "XADD", Ev, Gv);
    defineTwoByte(_C2, "CMPPS", Vps, Wps, ICb);
    defineTwoByte(_C3, "MOVNTI", Md_q, Gd_q);
    defineTwoByte(_C4, "PINSRW", Pq, Ed, Ib).requireOperandSize(WordWidth.BITS_32); // Ed instead of Ew to mimic intended Gd/Mw
    defineTwoByte(_C5, "PEXTRW", Gd, PRq, Ib);
    defineTwoByte(_C6, "SHUFPS", Vps, Wps, Ib);
    defineTwoByte(_C7, GROUP_9a).requireAddressSize(WordWidth.BITS_32); // depends on CPUID
    defineTwoByte(_C7, GROUP_9b).requireAddressSize(WordWidth.BITS_64).beNotExternallyTestable(); // depends on CPUID, rejected by gas on Opteron

    defineTwoByte(_C2, "CMPPD", Vpd, Wpd, ICb).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_C4, "PINSRW", Vdq, Ed, Ib).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE).
        requireOperandSize(WordWidth.BITS_32); // Ed instead of Ew to mimic intended Gd/Mw
    defineTwoByte(_C5, "PEXTRW", Gd, Udq, Ib).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_C6, "SHUFPD", Vpd, Wpd, Ib).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_C2, "CMPSD", Vsd, Wsd, ICb).setMandatoryPrefix(X86InstructionPrefix.REPNE);

    defineTwoByte(_C2, "CMPSS", Vss, Wss, ICb).setMandatoryPrefix(X86InstructionPrefix.REPE);

    defineTwoByte(_D1, "PSRLW", Pq, Qq);
    defineTwoByte(_D2, "PSRLD", Pq, Qq);
    defineTwoByte(_D3, "PSRLQ", Pq, Qq);
    defineTwoByte(_D4, "PADDQ", Pq, Qq);
    defineTwoByte(_D5, "PMULLW", Pq, Qq);
    defineTwoByte(_D7, "PMOVMSKB", Gd, PRq);

    defineTwoByte(_D0, "ADDSUBPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_D1, "PSRLW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_D2, "PSRLD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_D3, "PSRLQ", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_D4, "PADDQ", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_D5, "PMULLW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_D6, "MOVQ",
                  Wq.excludeExternalTestArguments(AMD64XMMRegister.SYMBOLS), Vq) // gas uses F3 0F 7E for reg-reg
        .setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_D7, "PMOVMSKB", Gd, Udq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_D6, "MOVDQ2Q", Pq, Uq).setMandatoryPrefix(X86InstructionPrefix.REPNE);

    defineTwoByte(_D6, "MOVQ2DQ", Vdq, PRq).setMandatoryPrefix(X86InstructionPrefix.REPE);

    defineTwoByte(_E0, "PAVGB", Pq, Qq);
    defineTwoByte(_E1, "PSRAW", Pq, Qq);
    defineTwoByte(_E2, "PSRAD", Pq, Qq);
    defineTwoByte(_E3, "PAVGW", Pq, Qq);
    defineTwoByte(_E4, "PMULHUW", Pq, Qq);
    defineTwoByte(_E5, "PMULHW", Pq, Qq);
    defineTwoByte(_E7, "MOVNTQ", Mq, Pq);

    defineTwoByte(_E0, "PAVGB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_E1, "PSRAW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_E2, "PSRAD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_E3, "PAVGW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_E4, "PMULHUW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_E5, "PMULHW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_E6, "CVTTPD2DQ", Vq, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_E7, "MVNTDQ", Mdq, Vdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE).
        beNotExternallyTestable(); // gas does not know it

    defineTwoByte(_E6, "CVTPD2DQ", Vq, Wpd).setMandatoryPrefix(X86InstructionPrefix.REPNE);

    defineTwoByte(_E6, "CVTDQ2PD", Vpd, Wq).setMandatoryPrefix(X86InstructionPrefix.REPE);

    defineTwoByte(_F1, "PSLLW", Pq, Qq);
    defineTwoByte(_F2, "PSLLD", Pq, Qq);
    defineTwoByte(_F3, "PSLLQ", Pq, Qq);
    defineTwoByte(_F4, "PMULUDQ", Pq, Qq);
    defineTwoByte(_F5, "PMADDWD", Pq, Qq);
    defineTwoByte(_F6, "PSADBW", Pq, Qq);
    defineTwoByte(_F7, "MASKMOVQ", Pq, PRq);

    defineTwoByte(_F1, "PSLLW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_F2, "PSLLD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_F3, "PSLLQ", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_F4, "PMULUDQ", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_F5, "PMADDWD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_F6, "PSADBW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_F7, "MASKMOVDQU", Vdq, Udq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_F0, "LDDQU", Vpd, Mdq).setMandatoryPrefix(X86InstructionPrefix.REPNE);
  }

  /**
   * See A-6 in the book.
   *
   * @see jasm.x86
   */
  private void create_high() {
    defineTwoByte(_08, "INVD");
    defineTwoByte(_09, "WBINVD");
    defineTwoByte(_0B, "UD2");
    defineTwoByte(_0D, GROUP_P, Mb); // AMD64 table's manual lacks Mb
    defineTwoByte(_0E, "FEMMS");

    defineTwoByte(_18, GROUP_16, Mb); // AMD64 table's manual lacks Mb
    defineTwoByte(_19, "NOP").beNotExternallyTestable(); // gas uses 0x90
    defineTwoByte(_1A, "NOP").beNotExternallyTestable(); // gas uses 0x90
    defineTwoByte(_1B, "NOP").beNotExternallyTestable(); // gas uses 0x90
    defineTwoByte(_1C, "NOP").beNotExternallyTestable(); // gas uses 0x90
    defineTwoByte(_1D, "NOP").beNotExternallyTestable(); // gas uses 0x90
    defineTwoByte(_1E, "NOP").beNotExternallyTestable(); // gas uses 0x90
    defineTwoByte(_1F, "NOP").beNotExternallyTestable(); // gas uses 0x90

    defineTwoByte(_28, "MOVAPS", Vps, Wps);
    defineTwoByte(_29, "MOVAPS", Wps, Vps);
    defineTwoByte(_2A, "CVTPI2PS", Vps, Qq);
    defineTwoByte(_2B, "MOVNTPS", Mdq, Vps);
    defineTwoByte(_2C, "CVTTPS2PI", Pq, Wps);
    defineTwoByte(_2D, "CVTPS2PI", Pq, Wps);
    defineTwoByte(_2E, "UCOMISS", Vss, Wss);
    defineTwoByte(_2F, "COMISS", Vps, Wps);

    defineTwoByte(_28, "MOVAPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_29, "MOVAPD", Wpd, Vpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_2A, "CVTPI2PD", Vpd, Qq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_2B, "MOVNTPD", Mdq, Vpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_2C, "CVTTPD2PI", Pq, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_2D, "CVTPD2PI", Pq, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_2E, "UCOMISD", Vsd, Wsd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_2F, "COMISD", Vpd, Wsd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_2A, "CVTSI2SD", Vsd, Ed_q).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_2C, "CVTTSD2SI", Gd_q, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_2D, "CVTSD2SI", Gd_q, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);

    defineTwoByte(_2A, "CVTSI2SS", Vss, Ed_q).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_2C, "CVTTSS2SI", Gd_q, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_2D, "CVTSS2SI", Gd_q, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);

    defineTwoByte(_48, "CMOVS", Gv, Ev);
    defineTwoByte(_49, "CMOVNS", Gv, Ev);
    defineTwoByte(_4A, "CMOVP", Gv, Ev);
    defineTwoByte(_4B, "CMOVNP", Gv, Ev);
    defineTwoByte(_4C, "CMOVL", Gv, Ev);
    defineTwoByte(_4D, "CMOVGE", Gv, Ev);
    defineTwoByte(_4E, "CMOVLE", Gv, Ev);
    defineTwoByte(_4F, "CMOVG", Gv, Ev);

    defineTwoByte(_58, "ADDPS", Vps, Wps);
    defineTwoByte(_59, "MULPS", Vps, Wps);
    defineTwoByte(_5A, "CVTPS2PD", Vpd, Wps);
    defineTwoByte(_5B, "CVTDQ2PS", Vps, Wdq);
    defineTwoByte(_5C, "SUBPS", Vps, Wps);
    defineTwoByte(_5D, "MINPS", Vps, Wps);
    defineTwoByte(_5E, "DIVPS", Vps, Wps);
    defineTwoByte(_5F, "MAXPS", Vps, Wps);

    defineTwoByte(_58, "ADDPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_59, "MULPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_5A, "CVTPD2PS", Vps, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_5B, "CVTPS2DQ", Vdq, Wps).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_5C, "SUBPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_5D, "MINPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_5E, "DIVPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_5F, "MAXPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_58, "ADDSD", Vsd, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_59, "MULSD", Vsd, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_5A, "CVTSD2SS", Vss, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_5C, "SUBSD", Vsd, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_5D, "MINSD", Vsd, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_5E, "DIVSD", Vsd, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_5F, "MAXSD", Vsd, Wsd).setMandatoryPrefix(X86InstructionPrefix.REPNE);

    defineTwoByte(_58, "ADDSS", Vss, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_59, "MULSS", Vss, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_5A, "CVTSS2SD", Vsd, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_5B, "CVTTPS2DQ", Vdq, Wps).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_5C, "SUBSS", Vss, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_5D, "MINSS", Vss, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_5E, "DIVSS", Vss, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_5F, "MAXSS", Vss, Wss).setMandatoryPrefix(X86InstructionPrefix.REPE);

    defineTwoByte(_68, "PUNPCKHBW", Pq, Qd);
    defineTwoByte(_69, "PUNPCKHWD", Pq, Qd);
    defineTwoByte(_6A, "PUNPCKHDQ", Pq, Qd);
    defineTwoByte(_6B, "PACKSSDW", Pq, Qq);
    defineTwoByte(_6E, "MOVD", Pq, Ed_q).beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    defineTwoByte(_6F, "MOVQ", Pq, Qq);

    defineTwoByte(_68, "PUNPCKHBW", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_69, "PUNPCKHWD", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_6A, "PUNPCKHDQ", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_6B, "PACKSSDW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_6C, "PUNPCKLQDQ", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_6D, "PUNPCKHQDQ", Vdq, Wq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_6E, "MOVD", Vdq, Ed_q).
        setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE).
        beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    defineTwoByte(_6F, "MOVDQA", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_6F, "MOVDQU", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.REPE);

    defineTwoByte(_7E, "MOVD", Ed_q, Pq).beNotExternallyTestable(); // gas does not allow feature to distinguish operand width
    defineTwoByte(_7F, "MOVQ", Qq, Pq);

    defineTwoByte(_7C, "HADDPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_7D, "HSUBPD", Vpd, Wpd).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_7E, "MOVD", Ed_q, Vdq).
        setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE).
        beNotExternallyTestable(); // gas does not feature suffix to distinguish operand width
    defineTwoByte(_7F, "MOVDQA", Wdq, Vdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_7C, "HADDPS", Vps, Wps).setMandatoryPrefix(X86InstructionPrefix.REPNE);
    defineTwoByte(_7D, "HSUBPS", Vps, Wps).setMandatoryPrefix(X86InstructionPrefix.REPNE);

    defineTwoByte(_7E, "MOVQ", Vq, Wq).setMandatoryPrefix(X86InstructionPrefix.REPE);
    defineTwoByte(_7F, "MOVDQU", Wdq, Vdq).setMandatoryPrefix(X86InstructionPrefix.REPE);

    defineTwoByte(_88, "JS", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_89, "JNS", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_8A, "JP", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_8B, "JNP", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_8C, "JL", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_8D, "JNL", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_8E, "JLE", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_8F, "JNLE", Jz).setDefaultOperandSize(WordWidth.BITS_64);

    defineTwoByte(_98, "SETS", Eb);
    defineTwoByte(_99, "SETNS", Eb);
    defineTwoByte(_9A, "SETP", Eb);
    defineTwoByte(_9B, "SETNP", Eb);
    defineTwoByte(_9C, "SETL", Eb);
    defineTwoByte(_9D, "SETNL", Eb);
    defineTwoByte(_9E, "SETLE", Eb);
    defineTwoByte(_9F, "SETNLE", Eb);

    defineTwoByte(_A8, "PUSH", GS).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_A9, "POP", GS).setDefaultOperandSize(WordWidth.BITS_64);
    defineTwoByte(_AA, "RSM");
    defineTwoByte(_AB, "BTS", Ev, Gv);
    defineTwoByte(_AC, "SHRD", Ev, Gv, Ib);
    defineTwoByte(_AD, "SHRD", Ev, Gv, CL);
    defineTwoByte(_AE, GROUP_15a);
    defineTwoByte(_AE, GROUP_15b, ModCase.MOD_3);
    defineTwoByte(_AF, "IMUL", Gv, Ev);

    defineTwoByte(_B9, GROUP_10);
    defineTwoByte(_BA, GROUP_8, Ev, Ib);
    defineTwoByte(_BB, "BTC", Ev, Gv);
    defineTwoByte(_BC, "BSF", Gv, Ev);
    defineTwoByte(_BD, "BSR", Gv, Ev);
    defineTwoByte(_BE, "MOVSXB", Gv, Eb).setExternalName("movsx");
    defineTwoByte(_BF, "MOVSXW", Gd_q, Ew).beNotExternallyTestable(); // gas unnecessarily prepends the operand size prefix 0x66

    defineTwoByte(_C8, "BSWAP", God_q);

    defineTwoByte(_D8, "PSUBUSB", Pq, Qq);
    defineTwoByte(_D9, "PSUBUSW", Pq, Qq);
    defineTwoByte(_DA, "PMINUB", Pq, Qq);
    defineTwoByte(_DB, "PAND", Pq, Qq);
    defineTwoByte(_DC, "PADDUSB", Pq, Qq);
    defineTwoByte(_DD, "PADDUSW", Pq, Qq);
    defineTwoByte(_DE, "PMAXUB", Pq, Qq);
    defineTwoByte(_DF, "PANDN", Pq, Qq);

    defineTwoByte(_D8, "PSUBUSB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_D9, "PSUBUSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_DA, "PMINUB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_DB, "PAND", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_DC, "PADDUSB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_DD, "PADDUSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_DE, "PMAXUB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_DF, "PANDN", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_E8, "PSUBSB", Pq, Qq);
    defineTwoByte(_E9, "PSUBSW", Pq, Qq);
    defineTwoByte(_EA, "PMINSW", Pq, Qq);
    defineTwoByte(_EB, "POR", Pq, Qq);
    defineTwoByte(_EC, "PADDSB", Pq, Qq);
    defineTwoByte(_ED, "PADDSW", Pq, Qq);
    defineTwoByte(_EE, "PMAXSW", Pq, Qq);
    defineTwoByte(_EF, "PXOR", Pq, Qq);

    defineTwoByte(_E8, "PSUBSB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_E9, "PSUBSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_EA, "PMINSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_EB, "POR", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_EC, "PADDSB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_ED, "PADDSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_EE, "PMAXSW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_EF, "PXOR", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);

    defineTwoByte(_F8, "PSUBB", Pq, Qq);
    defineTwoByte(_F9, "PSUBW", Pq, Qq);
    defineTwoByte(_FA, "PSUBD", Pq, Qq);
    defineTwoByte(_FB, "PSUBQ", Pq, Qq);
    defineTwoByte(_FC, "PADDB", Pq, Qq);
    defineTwoByte(_FD, "PADDW", Pq, Qq);
    defineTwoByte(_FE, "PADDD", Pq, Qq);

    defineTwoByte(_F8, "PSUBB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_F9, "PSUBW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_FA, "PSUBD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_FB, "PSUBQ", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_FC, "PADDB", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_FD, "PADDW", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
    defineTwoByte(_FE, "PADDD", Vdq, Wdq).setMandatoryPrefix(X86InstructionPrefix.OPERAND_SIZE);
  }

  TwoByteOpcodeMap() {
    super(AMD64Assembly.ASSEMBLY);
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
