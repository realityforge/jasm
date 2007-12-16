/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=50f15edf-6c04-4237-99ed-c3c405fc4159*/
package com.sun.max.asm.gen.cisc.ia32;

import static com.sun.max.asm.gen.cisc.ia32.IA32ModRMGroup.*;
import static com.sun.max.asm.gen.cisc.x86.OperandCode.*;
import static com.sun.max.asm.ia32.IA32GeneralRegister8.*;
import static com.sun.max.asm.x86.SegmentRegister.*;
import static com.sun.max.util.HexByte.*;

import com.sun.max.asm.gen.cisc.x86.*;

/**
 * @author Bernd Mathiske
 */
class TwoByteOpcodeMap extends X86InstructionDescriptionCreator {

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
