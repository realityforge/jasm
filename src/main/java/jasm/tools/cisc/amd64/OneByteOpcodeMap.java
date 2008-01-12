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
import jasm.amd64.AMD64GeneralRegister16;
import static jasm.amd64.AMD64GeneralRegister16.*;
import jasm.amd64.AMD64GeneralRegister32;
import static jasm.amd64.AMD64GeneralRegister32.*;
import static jasm.amd64.AMD64GeneralRegister64.*;
import jasm.amd64.AMD64GeneralRegister8;
import static jasm.amd64.AMD64GeneralRegister8.*;
import static jasm.tools.cisc.amd64.AMD64ModRMGroup.*;
import static jasm.tools.cisc.x86.AddressingMethodCode.M;
import static jasm.tools.cisc.x86.StandardOperandCode.*;
import static jasm.tools.cisc.x86.OperandTypeCode.b;
import static jasm.tools.cisc.x86.OperandTypeCode.v;
import jasm.tools.cisc.x86.X86InstructionDescriptionCreator;
import jasm.tools.cisc.x86.X86RegisterOperandCode;
import static jasm.util.HexByte.*;
import jasm.x86.X86InstructionPrefix;

public final class OneByteOpcodeMap extends X86InstructionDescriptionCreator {

  private void create_low() {
    define1B(_00, "add", Eb, Gb);
    define1B(_01, "add", Ev, Gv);
    define1B(_02, "add", Gb, Eb);
    define1B(_03, "add", Gv, Ev);
    define1B(_04, "add", AL, Ib);
    define1B(_05, "add", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_10, "adc", Eb, Gb);
    define1B(_11, "adc", Ev, Gv);
    define1B(_12, "adc", Gb, Eb);
    define1B(_13, "adc", Gv, Ev);
    define1B(_14, "adc", AL, Ib);
    define1B(_15, "adc", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_20, "and", Eb, Gb);
    define1B(_21, "and", Ev, Gv);
    define1B(_22, "and", Gb, Eb);
    define1B(_23, "and", Gv, Ev);
    define1B(_24, "and", AL, Ib);
    define1B(_25, "and", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_30, "xor", Eb, Gb);
    define1B(_31, "xor", Ev, Gv);
    define1B(_32, "xor", Gb, Eb);
    define1B(_33, "xor", Gv, Ev);
    define1B(_34, "xor", AL, Ib);
    define1B(_35, "xor", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_50, "push", Gov).setDefaultOperandSize(WordWidth.BITS_64);

    define1B(_63, "movsxd", Gq, Ed).requireOperandSize(WordWidth.BITS_64).beNotExternallyTestable(); // REX.W == 1, gas does not seem to know it
    define1B(_63, "movzxd", Gq, Ed).requireOperandSize(WordWidth.BITS_32).beNotExternallyTestable(); // REX.W == 0, we made this extra mnemonic up

    define1B(X86InstructionPrefix.SEG_FS.getValue(), "seg_fs").beAPrefix();
    define1B(X86InstructionPrefix.SEG_GS.getValue(), "seg_gs").beAPrefix();
    define1B(X86InstructionPrefix.OPERAND_SIZE.getValue(), "operand_size").beAPrefix();
    define1B(X86InstructionPrefix.ADDRESS_SIZE.getValue(), "address_size").beAPrefix();

    define1B(_70, "jo", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_71, "jno", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_72, "jb", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_73, "jnb", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_74, "jz", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_75, "jnz", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_76, "jbe", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_77, "jnbe", Jb).setDefaultOperandSize(WordWidth.BITS_64);

    define1B(_80, GROUP_1, b, Eb.excludeExternalTestArguments(AL), Ib);
    define1B(_81, GROUP_1, v, Ev.excludeExternalTestArguments(AX, EAX, RAX), Iz.externalRange(0, Integer.MAX_VALUE));
    define1B(_83, GROUP_1, v, Ev, Ib).beNotExternallyTestable();
    define1B(_84, "test", Eb, Gb).revertExternalOperandOrdering();
    define1B(_85, "test", Ev, Gv).revertExternalOperandOrdering();
    define1B(_86, "xchg", Eb, Gb);
    define1B(_87, "xchg", Ev.excludeExternalTestArguments(AX, EAX, RAX), Gv.excludeExternalTestArguments(AX, EAX, RAX));

    define1B(_90, "nop");
    define1B(_90, "xchg", Gov.excludeDisassemblerTestArguments(AX, EAX, RAX), X86RegisterOperandCode.RAX).beNotExternallyTestable();

    define1B(_A0, "mov", AL, Ob).beNotExternallyTestable();
    define1B(_A1, "mov", X86RegisterOperandCode.RAX, Ov).beNotExternallyTestable();
    define1B(_A2, "mov", Ob, AL).beNotExternallyTestable();
    define1B(_A3, "mov", Ov, X86RegisterOperandCode.RAX).beNotExternallyTestable();
    define1B(_A4, "movs", Yb, Xb);
    define1B(_A5, "movs", Yv, Xv);
    define1B(_A6, "cmps", Yb, Xb);
    define1B(_A7, "cmps", Yv, Xv);

    define1B(_B0, "mov", Gob, Ib);

    define1B(_C0, GROUP_2, b, Eb, Ib);
    define1B(_C1, GROUP_2, v, Ev, Ib);
    define1B(_C2, "ret", Iw).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_C3, "ret").setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_C6, "mov", b, Eb.excludeExternalTestArguments(AMD64GeneralRegister8.SYMBOLS), Ib);
    define1B(_C7, "mov", v, Ev.excludeExternalTestArguments(AMD64GeneralRegister16.SYMBOLS, AMD64GeneralRegister32.SYMBOLS), Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_D0, GROUP_2, b, Eb, 1);
    define1B(_D1, GROUP_2, v, Ev, 1);
    define1B(_D2, GROUP_2, b, Eb, CL);
    define1B(_D3, GROUP_2, v, Ev, CL);
    define1B(_D7, "xlat");

    define1B(_E0, "loopne", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_E1, "loope", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_E2, "loop", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_E3, "jecxz", Jb).requireAddressSize(WordWidth.BITS_32);
    define1B(_E3, "jrcxz", Jb).requireAddressSize(WordWidth.BITS_64);
    define1B(_E4, "in", AL, Ib);
    define1B(_E5, "in", X86RegisterOperandCode.EAX, Ib);
    define1B(_E6, "out", Ib, AL);
    define1B(_E7, "out", Ib, X86RegisterOperandCode.EAX);

    define1B(X86InstructionPrefix.LOCK.getValue(), "lock").beAPrefix();
    define1B(_F1, "int", 1).beNotExternallyTestable(); // is this correct? - gas uses 0xCD
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
    define1B(_0D, "or", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_18, "sbb", Eb, Gb);
    define1B(_19, "sbb", Ev, Gv);
    define1B(_1A, "sbb", Gb, Eb);
    define1B(_1B, "sbb", Gv, Ev);
    define1B(_1C, "sbb", AL, Ib);
    define1B(_1D, "sbb", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_28, "sub", Eb, Gb);
    define1B(_29, "sub", Ev, Gv);
    define1B(_2A, "sub", Gb, Eb);
    define1B(_2B, "sub", Gv, Ev);
    define1B(_2C, "sub", AL, Ib);
    define1B(_2D, "sub", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));
    define1B(X86InstructionPrefix.SEG_CS.getValue(), "seg_cs").beAPrefix();
    define1B(_2F, "das").beNotExternallyTestable(); // not defined in 64 bit mode and so 'as -64' rejects it

    define1B(_38, "cmp", Eb, Gb);
    define1B(_39, "cmp", Ev, Gv);
    define1B(_3A, "cmp", Gb, Eb);
    define1B(_3B, "cmp", Gv, Ev);
    define1B(_3C, "cmp", AL, Ib);
    define1B(_3D, "cmp", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));

    define1B(_58, "pop", Gov).setDefaultOperandSize(WordWidth.BITS_64);

    define1B(_68, "push", Iz.externalRange(Short.MAX_VALUE + 1, Integer.MAX_VALUE)).setDefaultOperandSize(WordWidth.BITS_64); // cannot test 16-bit version, because gas does not generate it
    define1B(_69, "imul", Gv, Ev, Iz.externalRange(0, Integer.MAX_VALUE));
    define1B(_6A, "push", Ib.externalRange(0, 0x7f)).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_6B, "imul", Gv, Ev, Ib.externalRange(0, 0x7f));
    define1B(_6C, "ins", Yb);
    define1B(_6D, "ins", Yz);
    define1B(_6E, "outs", Xb);
    define1B(_6F, "outs", Xz);

    define1B(_78, "js", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_79, "jns", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7A, "jp", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7B, "jnp", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7C, "jl", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7D, "jnl", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7E, "jle", Jb).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_7F, "jnle", Jb).setDefaultOperandSize(WordWidth.BITS_64);

    define1B(_88, "mov", Eb, Gb.excludeExternalTestArguments(AL));
    define1B(_89, "mov", Ev, Gv.excludeExternalTestArguments(AX, EAX));
    define1B(_8A, "mov", Gb.excludeExternalTestArguments(AL), Eb);
    define1B(_8B, "mov", Gv.excludeExternalTestArguments(AX, EAX), Ev);
    define1B(_8C, "mov", Ew.excludeExternalTestArguments(AMD64GeneralRegister16.SYMBOLS), Sw); // gas may needlessly insert OPERAND_SIZE prefix
    define1B(_8D, "lea", Gv, M);
    define1B(_8E, "mov", Sw, Ew.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI)); // gas may needlessly insert OPERAND_SIZE prefix
    define1B(_8F, "pop", Ev.excludeExternalTestArguments(AX, CX, DX, BX, SP, BP, SI, DI)).setDefaultOperandSize(WordWidth.BITS_64);

    define1B(_98, "cwde").requireOperandSize(WordWidth.BITS_32);
    define1B(_98, "cdqe").requireOperandSize(WordWidth.BITS_64);
    define1B(_99, "cdq").requireOperandSize(WordWidth.BITS_32);
    define1B(_99, "cqo").requireOperandSize(WordWidth.BITS_64);
    define1B(_9B, "fwait"); // 'wait' is a Java keyword, so we use the alternate mnemonic, which is more accurately named anyhow
    define1B(_9C, "pushf", v, Fv).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_9D, "popf", v, Fv).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_9E, "sahf").beNotExternallyTestable(); // not available by gas, depends on CPUID
    define1B(_9F, "lahf").beNotExternallyTestable(); // not available by gas, depends on CPUID

    define1B(_A8, "test", AL, Ib);
    define1B(_A9, "test", X86RegisterOperandCode.RAX, Iz.externalRange(0, Integer.MAX_VALUE));
    define1B(_AA, "stos", Yb);
    define1B(_AB, "stos", Yv);
    define1B(_AC, "lods", Xb);
    define1B(_AD, "lods", Xv);
    define1B(_AE, "scas", Yb);
    define1B(_AF, "scas", Yv);

    define1B(_B8, "mov", Gov, Iv);

    define1B(_C8, "enter", Iw, Ib).setDefaultOperandSize(WordWidth.BITS_64).revertExternalOperandOrdering();
    define1B(_C9, "leave").setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_CA, "retf", Iw).beNotExternallyTestable(); // gas does not support segments
    define1B(_CB, "retf").beNotExternallyTestable(); // gas does not support segments
    define1B(_CC, "int", 3);
    define1B(_CD, "INTb", Ib).setExternalName("int"); // suffix "b" to avoid clashing with Java keyword "int"
    define1B(_CF, "iret");

    define1B(_D8, FP_D8);
    define1B(_D9, FP_D9);
    define1B(_DA, FP_DA);
    define1B(_DB, FP_DB);
    define1B(_DC, FP_DC);
    define1B(_DD, FP_DD);
    define1B(_DE, FP_DE);
    define1B(_DF, FP_DF);

    // We found out that '_66 _E8 ...' is NOT supported by our Opteron CPUs, despite footnote 6 on page 418 of the General Purpose Instruction Manual for AMD64:
    define1B(_E8, "call", Jz).setDefaultOperandSize(WordWidth.BITS_64).requireOperandSize(WordWidth.BITS_64); // disabling 0x66 prefix

    define1B(_E9, "jmp", Jz).setDefaultOperandSize(WordWidth.BITS_64);
    define1B(_EB, "jmp", Jb).setDefaultOperandSize(WordWidth.BITS_64);
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
    define1B(_FF, GROUP_5a);
    define1B(_FF, GROUP_5b).setDefaultOperandSize(WordWidth.BITS_64);
  }

  OneByteOpcodeMap() {
    super(AMD64Assembly.ASSEMBLY);
    create_low();
    create_high();
  }
}
