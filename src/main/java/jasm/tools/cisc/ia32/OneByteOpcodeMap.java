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
import static jasm.WordWidth.*;
import static jasm.ia32.IA32GeneralRegister16.*;
import static jasm.ia32.IA32GeneralRegister32.*;
import static jasm.ia32.IA32GeneralRegister8.*;
import static jasm.tools.cisc.ia32.IA32ModRMGroup.*;
import static jasm.tools.cisc.x86.AddressingMethodCode.M;
import static jasm.tools.cisc.x86.StandardOperandCode.*;
import static jasm.tools.cisc.x86.OperandTypeCode.b;
import static jasm.tools.cisc.x86.OperandTypeCode.v;
import jasm.tools.cisc.x86.X86InstructionDescriptionCreator;
import jasm.tools.cisc.x86.X86RegisterOperandCode;
import static jasm.util.HexByte.*;
import static jasm.x86.SegmentRegister.*;
import jasm.x86.X86InstructionPrefix;

/** Representation of the ... */
final class OneByteOpcodeMap
    extends X86InstructionDescriptionCreator {

  private void create_low() {
    define1B(_00, "add", Eb, Gb);
    define1B(_01, "add", Ev, Gv);
    define1B(_02, "add", Gb, Eb);
    define1B(_03, "add", Gv, Ev);
    define1B(_04, "add", AL, Ib);
    define1B(_05, "add", X86RegisterOperandCode.EAX, Iv);
    define1B(_06, "push", ES);
    define1B(_07, "pop", ES);

    define1B(_10, "adc", Eb, Gb);
    define1B(_11, "adc", Ev, Gv);
    define1B(_12, "adc", Gb, Eb);
    define1B(_13, "adc", Gv, Ev);
    define1B(_14, "adc", AL, Ib);
    define1B(_15, "adc", X86RegisterOperandCode.EAX, Iv);
    define1B(_16, "push", SS);
    define1B(_17, "pop", SS);

    define1B(_20, "and", Eb, Gb);
    define1B(_21, "and", Ev, Gv);
    define1B(_22, "and", Gb, Eb);
    define1B(_23, "and", Gv, Ev);
    define1B(_24, "and", AL, Ib);
    define1B(_25, "and", X86RegisterOperandCode.EAX, Iv);
    define1B(X86InstructionPrefix.SEG_ES.getValue(), "seg_es").beAPrefix();
    define1B(_27, "daa");

    define1B(_30, "xor", Eb, Gb);
    define1B(_31, "xor", Ev, Gv);
    define1B(_32, "xor", Gb, Eb);
    define1B(_33, "xor", Gv, Ev);
    define1B(_34, "xor", AL, Ib);
    define1B(_35, "xor", X86RegisterOperandCode.EAX, Iv);
    define1B(X86InstructionPrefix.SEG_SS.getValue(), "seg_ss").beAPrefix();
    define1B(_37, "aaa");

    define1B(_40, "inc", Gov);

    define1B(_50, "push", Gov);

    define1B(_60, "pusha").requireOperandSize(BITS_16).beNotExternallyTestable(); // gas does not emit the operand size prefix
    define1B(_60, "pushad").requireOperandSize(WordWidth.BITS_32).setExternalName("pusha");
    define1B(_61, "popa").requireOperandSize(BITS_16).beNotExternallyTestable(); // gas does not emit the operand size prefix
    define1B(_61, "popad").requireOperandSize(WordWidth.BITS_32).setExternalName("popa");
    define1B(_62, "bound", Gv, Ma).revertExternalOperandOrdering();
    define1B(_63, "arpl", Ew, Gw);
    define1B(X86InstructionPrefix.SEG_FS.getValue(), "seg_fs").beAPrefix();
    define1B(X86InstructionPrefix.SEG_GS.getValue(), "seg_gs").beAPrefix();
    define1B(X86InstructionPrefix.OPERAND_SIZE.getValue(), "operand_size").beAPrefix();
    define1B(X86InstructionPrefix.ADDRESS_SIZE.getValue(), "address_size").beAPrefix();

    define1B(_70, "jo", Jb);
    define1B(_71, "jno", Jb);
    define1B(_72, "jb", Jb);
    define1B(_73, "jnb", Jb);
    define1B(_74, "jz", Jb);
    define1B(_75, "jnz", Jb);
    define1B(_76, "jbe", Jb);
    define1B(_77, "jnbe", Jb);

    define1B(_80, GROUP_1, b, Eb.excludeExternalTestArguments(AL), Ib);
    define1B(_81, GROUP_1, v, Ev.excludeExternalTestArguments(AX, EAX), Iv);
    define1B(_82, GROUP_1, b, Eb.excludeExternalTestArguments(AL), Ib);
    define1B(_83, GROUP_1, v, Ev, Ib).beNotExternallyTestable();
    define1B(_84, "test", Eb, Gb).revertExternalOperandOrdering();
    define1B(_85, "test", Ev, Gv).revertExternalOperandOrdering();
    define1B(_86, "xchg", Eb, Gb);
    define1B(_87, "xchg", Ev.excludeExternalTestArguments(AX, EAX), Gv.excludeExternalTestArguments(AX, EAX));

    define1B(_90, "nop");
    define1B(_90, "xchg", Gov.excludeDisassemblerTestArguments(AX, EAX), X86RegisterOperandCode.EAX);

    define1B(_A0, "mov", AL, Ob);
    define1B(_A1, "mov", X86RegisterOperandCode.EAX, Ov);
    define1B(_A2, "mov", Ob, AL);
    define1B(_A3, "mov", Ov, X86RegisterOperandCode.EAX);
    define1B(_A4, "movs", Yb, Xb);
    define1B(_A5, "movs", Yv, Xv);
    define1B(_A6, "cmps", Yb, Xb);
    define1B(_A7, "cmps", Yv, Xv);

    define1B(_B0, "mov", Gob, Ib);

    define1B(_C0, GROUP_2, b, Eb, Ib);
    define1B(_C1, GROUP_2, v, Ev, Ib);
    define1B(_C2, "ret", Iw);
    define1B(_C3, "ret");
    define1B(_C4, "les", Gv, Mp);
    define1B(_C5, "lds", Gv, Mp);
    define1B(_C6, "mov", b, Eb.excludeExternalTestArguments(AL, CL, DL, BL, AH, CH, DH, BH), Ib);
    define1B(_C7, "mov", v, Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI, EAX, ECX, EDX, EBX, ESP, EBP, ESI, EDI), Iv);

    define1B(_D0, GROUP_2, b, Eb, 1);
    define1B(_D1, GROUP_2, v, Ev, 1);
    define1B(_D2, GROUP_2, b, Eb, CL);
    define1B(_D3, GROUP_2, v, Ev, CL);
    define1B(_D4, "aam", Ib.range(0, 0x7f));
    define1B(_D5, "aad", Ib.range(0, 0x7f));
    define1B(_D6, "salc").beNotExternallyTestable(); // missing in gas (undocumented by Intel)
    define1B(_D7, "xlat");

    define1B(_E0, "loopne", Jb);
    define1B(_E1, "loope", Jb);
    define1B(_E2, "loop", Jb);
    define1B(_E3, "jcxz", Jb).requireAddressSize(BITS_16);
    define1B(_E3, "jecxz", Jb).requireAddressSize(WordWidth.BITS_32);
    define1B(_E4, "in", AL, Ib);
    define1B(_E5, "in", X86RegisterOperandCode.EAX, Ib);
    define1B(_E6, "out", Ib, AL);
    define1B(_E7, "out", Ib, X86RegisterOperandCode.EAX);

    define1B(X86InstructionPrefix.LOCK.getValue(), "lock").beAPrefix();
    define1B(X86InstructionPrefix.REPNE.getValue(), "repne").beAPrefix();
    define1B(X86InstructionPrefix.REPE.getValue(), "repe").beAPrefix();
    define1B(_F4, "hlt");
    define1B(_F5, "cmc");
    define1B(_F6, GROUP_3b, b);
    define1B(_F7, GROUP_3v, v);
  }

  private void create_high() {
    define1B(_08, "or", Eb, Gb);
    define1B(_09, "or", Ev, Gv);
    define1B(_0A, "or", Gb, Eb);
    define1B(_0B, "or", Gv, Ev);
    define1B(_0C, "or", AL, Ib);
    define1B(_0D, "or", X86RegisterOperandCode.EAX, Iv);
    define1B(_0E, "push", CS);

    define1B(_18, "sbb", Eb, Gb);
    define1B(_19, "sbb", Ev, Gv);
    define1B(_1A, "sbb", Gb, Eb);
    define1B(_1B, "sbb", Gv, Ev);
    define1B(_1C, "sbb", AL, Ib);
    define1B(_1D, "sbb", X86RegisterOperandCode.EAX, Iv);
    define1B(_1E, "push", DS);
    define1B(_1F, "pop", DS);

    define1B(_28, "sub", Eb, Gb);
    define1B(_29, "sub", Ev, Gv);
    define1B(_2A, "sub", Gb, Eb);
    define1B(_2B, "sub", Gv, Ev);
    define1B(_2C, "sub", AL, Ib);
    define1B(_2D, "sub", X86RegisterOperandCode.EAX, Iv);
    define1B(X86InstructionPrefix.SEG_CS.getValue(), "seg_cs").beAPrefix();
    define1B(_2F, "das");

    define1B(_38, "cmp", Eb, Gb);
    define1B(_39, "cmp", Ev, Gv);
    define1B(_3A, "cmp", Gb, Eb);
    define1B(_3B, "cmp", Gv, Ev);
    define1B(_3C, "cmp", AL, Ib);
    define1B(_3D, "cmp", X86RegisterOperandCode.EAX, Iv);
    define1B(X86InstructionPrefix.SEG_DS.getValue(), "seg_ds").beAPrefix();
    define1B(_3F, "aas");

    define1B(_48, "dec", Gov);

    define1B(_58, "pop", Gov);

    define1B(_68, "push", Iv);
    define1B(_69, "imul", Gv, Ev, Iv);
    define1B(_6A, "push", Ib.externalRange(0, 0x7f));
    define1B(_6B, "imul", Gv, Ev, Ib.externalRange(0, 0x7f));
    define1B(_6C, "ins", Yb);
    define1B(_6D, "ins", Yv);
    define1B(_6E, "outs", Xb);
    define1B(_6F, "outs", Xv);

    define1B(_78, "js", Jb);
    define1B(_79, "jns", Jb);
    define1B(_7A, "jp", Jb);
    define1B(_7B, "jnp", Jb);
    define1B(_7C, "jl", Jb);
    define1B(_7D, "jnl", Jb);
    define1B(_7E, "jle", Jb);
    define1B(_7F, "jnle", Jb);

    define1B(_88, "mov", Eb, Gb.excludeExternalTestArguments(AL));
    define1B(_89, "mov", Ev, Gv.excludeExternalTestArguments(AX, EAX));
    define1B(_8A, "mov", Gb.excludeExternalTestArguments(AL), Eb);
    define1B(_8B, "mov", Gv.excludeExternalTestArguments(AX, EAX), Ev);
    define1B(_8C, "mov", Ew.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI), Sw); // gas may needlessly insert OPERAND_SIZE prefix
    define1B(_8D, "lea", Gv, M);
    define1B(_8E, "mov", Sw, Ew.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI)); // gas may needlessly insert OPERAND_SIZE prefix
    define1B(_8F, "pop", Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI, EAX, ECX, EDX, EBX, ESP, EBP, ESI, EDI));

    define1B(_98, "cbw").requireOperandSize(BITS_16);
    define1B(_98, "cwde").requireOperandSize(WordWidth.BITS_32);
    define1B(_99, "cwd").requireOperandSize(BITS_16);
    define1B(_99, "cdq").requireOperandSize(WordWidth.BITS_32);
    define1B(_9A, "call", Ap);
    define1B(_9B, "fwait"); // 'wait' is a Java keyword, so we use the alternate mnemonic, which is more accurately named anyhow
    define1B(_9C, "pushf", v, Fv);
    define1B(_9D, "popf", v, Fv);
    define1B(_9E, "sahf");
    define1B(_9F, "lahf");

    define1B(_A8, "test", AL, Ib);
    define1B(_A9, "test", X86RegisterOperandCode.EAX, Iv);
    define1B(_AA, "stos", Yb);
    define1B(_AB, "stos", Yv);
    define1B(_AC, "lods", Xb);
    define1B(_AD, "lods", Xv);
    define1B(_AE, "scas", Yb);
    define1B(_AF, "scas", Yv);

    define1B(_B8, "mov", Gov, Iv);

    define1B(_C8, "enter", Iw, Ib).revertExternalOperandOrdering();
    define1B(_C9, "leave");
    define1B(_CA, "retf", Iw).beNotExternallyTestable(); // gas does not support segments
    define1B(_CB, "retf").beNotExternallyTestable(); // gas does not support segments
    define1B(_CC, "int", 3);
    define1B(_CD, "INTb", Ib).setExternalName("int"); // suffix "b" to avoid clashing with Java keyword "int"
    define1B(_CE, "into");
    define1B(_CF, "iret");

    define1B(_D8, FP_D8);
    define1B(_D9, FP_D9);
    define1B(_DA, FP_DA);
    define1B(_DB, FP_DB);
    define1B(_DC, FP_DC);
    define1B(_DD, FP_DD);
    define1B(_DE, FP_DE);
    define1B(_DF, FP_DF);

    define1B(_E8, "call", Jv);
    define1B(_E9, "jmp", Jv).requireOperandSize(BITS_16);
    define1B(_E9, "jmp", Jv).requireOperandSize(BITS_32);
    define1B(_EA, "jmp", Ap);
    define1B(_EB, "jmp", Jb);
    define1B(_EC, "in", AL, DX);
    define1B(_ED, "in", X86RegisterOperandCode.EAX, DX);
    define1B(_EE, "out", DX, AL);
    define1B(_EF, "out", DX, X86RegisterOperandCode.EAX);

    define1B(_F8, "clc");
    define1B(_F9, "stc");
    define1B(_FA, "cli");
    define1B(_FB, "sti");
    define1B(_FC, "cld");
    define1B(_FD, "std");
    define1B(_FE, GROUP_4, b, Eb);
    define1B(_FF, GROUP_5);
  }

  OneByteOpcodeMap() {
    super(IA32Assembly.ASSEMBLY);
    create_low();
    create_high();
  }
}
