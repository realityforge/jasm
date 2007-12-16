/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ddf44d84-4e6a-4f14-b94f-5130ace94d1c*/
// START GENERATED CONTENT

package com.sun.max.asm.amd64;

import com.sun.max.asm.AssemblyException;
import com.sun.max.asm.Label;
import com.sun.max.asm.LabelAddressInstruction;
import com.sun.max.asm.LabelOffsetInstruction;
import com.sun.max.asm.x86.MMXRegister;
import com.sun.max.asm.x86.SegmentRegister;

public abstract class AMD64LabelAssembler extends AMD64RawAssembler {

    protected AMD64LabelAssembler() {
        super();
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>label</i>, <i>source</i>
     */
    // Template#: 1, Serial#: 4
    public void rip_add(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_add(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_add(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>label</i>, <i>source</i>
     */
    // Template#: 2, Serial#: 13
    public void rip_add(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_add(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 13; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_add(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>label</i>, <i>source</i>
     */
    // Template#: 3, Serial#: 22
    public void rip_add(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_add(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 22; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_add(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>label</i>, <i>source</i>
     */
    // Template#: 4, Serial#: 31
    public void rip_add(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_add(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 31; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_add(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>destination</i>, <i>label</i>
     */
    // Template#: 5, Serial#: 40
    public void rip_add(final AMD64GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_add(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 40; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_add(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>destination</i>, <i>label</i>
     */
    // Template#: 6, Serial#: 48
    public void rip_add(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_add(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 48; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_add(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>destination</i>, <i>label</i>
     */
    // Template#: 7, Serial#: 56
    public void rip_add(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_add(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 56; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_add(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>destination</i>, <i>label</i>
     */
    // Template#: 8, Serial#: 64
    public void rip_add(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_add(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 64; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_add(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>label</i>, <i>source</i>
     */
    // Template#: 9, Serial#: 76
    public void rip_adc(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adc(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 76; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adc(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>label</i>, <i>source</i>
     */
    // Template#: 10, Serial#: 85
    public void rip_adc(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adc(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 85; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adc(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>label</i>, <i>source</i>
     */
    // Template#: 11, Serial#: 94
    public void rip_adc(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adc(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 94; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adc(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>label</i>, <i>source</i>
     */
    // Template#: 12, Serial#: 103
    public void rip_adc(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adc(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 103; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adc(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>destination</i>, <i>label</i>
     */
    // Template#: 13, Serial#: 112
    public void rip_adc(final AMD64GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adc(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 112; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adc(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>destination</i>, <i>label</i>
     */
    // Template#: 14, Serial#: 120
    public void rip_adc(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adc(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 120; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adc(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>destination</i>, <i>label</i>
     */
    // Template#: 15, Serial#: 128
    public void rip_adc(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adc(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 128; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adc(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>destination</i>, <i>label</i>
     */
    // Template#: 16, Serial#: 136
    public void rip_adc(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adc(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 136; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adc(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>label</i>, <i>source</i>
     */
    // Template#: 17, Serial#: 148
    public void rip_and(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_and(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 148; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_and(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>label</i>, <i>source</i>
     */
    // Template#: 18, Serial#: 157
    public void rip_and(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_and(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 157; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_and(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>label</i>, <i>source</i>
     */
    // Template#: 19, Serial#: 166
    public void rip_and(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_and(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 166; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_and(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>label</i>, <i>source</i>
     */
    // Template#: 20, Serial#: 175
    public void rip_and(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_and(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 175; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_and(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>destination</i>, <i>label</i>
     */
    // Template#: 21, Serial#: 184
    public void rip_and(final AMD64GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_and(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 184; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_and(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>destination</i>, <i>label</i>
     */
    // Template#: 22, Serial#: 192
    public void rip_and(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_and(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 192; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_and(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>destination</i>, <i>label</i>
     */
    // Template#: 23, Serial#: 200
    public void rip_and(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_and(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 200; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_and(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>destination</i>, <i>label</i>
     */
    // Template#: 24, Serial#: 208
    public void rip_and(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_and(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 208; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_and(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>label</i>, <i>source</i>
     */
    // Template#: 25, Serial#: 220
    public void rip_xor(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xor(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 220; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xor(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>label</i>, <i>source</i>
     */
    // Template#: 26, Serial#: 229
    public void rip_xor(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xor(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 229; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xor(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>label</i>, <i>source</i>
     */
    // Template#: 27, Serial#: 238
    public void rip_xor(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xor(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 238; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xor(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>label</i>, <i>source</i>
     */
    // Template#: 28, Serial#: 247
    public void rip_xor(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xor(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 247; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xor(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>destination</i>, <i>label</i>
     */
    // Template#: 29, Serial#: 256
    public void rip_xor(final AMD64GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xor(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 256; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xor(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>destination</i>, <i>label</i>
     */
    // Template#: 30, Serial#: 264
    public void rip_xor(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xor(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 264; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xor(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>destination</i>, <i>label</i>
     */
    // Template#: 31, Serial#: 272
    public void rip_xor(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xor(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 272; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xor(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>destination</i>, <i>label</i>
     */
    // Template#: 32, Serial#: 280
    public void rip_xor(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xor(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 280; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xor(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsxd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 33, Serial#: 294
    public void rip_movsxd(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movsxd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 294; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movsxd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzxd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 34, Serial#: 303
    public void rip_movzxd(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movzxd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 303; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movzxd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jo  }<i>label</i>
     */
    // Template#: 35, Serial#: 313
    public void jo(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jo(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 313; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jo(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jo(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jno  }<i>label</i>
     */
    // Template#: 36, Serial#: 314
    public void jno(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jno(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 314; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jno(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jno(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jb  }<i>label</i>
     */
    // Template#: 37, Serial#: 315
    public void jb(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jb(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 315; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jb(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jb(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jnb  }<i>label</i>
     */
    // Template#: 38, Serial#: 316
    public void jnb(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnb(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 316; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnb(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jnb(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jz  }<i>label</i>
     */
    // Template#: 39, Serial#: 317
    public void jz(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jz(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 317; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jz(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jz(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jnz  }<i>label</i>
     */
    // Template#: 40, Serial#: 318
    public void jnz(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnz(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 318; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnz(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jnz(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jbe  }<i>label</i>
     */
    // Template#: 41, Serial#: 319
    public void jbe(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jbe(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 319; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jbe(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jbe(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jnbe  }<i>label</i>
     */
    // Template#: 42, Serial#: 320
    public void jnbe(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnbe(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 320; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnbe(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jnbe(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 43, Serial#: 324
    public void rip_addb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 324; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 44, Serial#: 328
    public void rip_orb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_orb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 328; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_orb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 45, Serial#: 332
    public void rip_adcb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adcb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 332; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adcb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 46, Serial#: 336
    public void rip_sbbb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbbb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 336; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbbb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 47, Serial#: 340
    public void rip_andb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 340; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 48, Serial#: 344
    public void rip_subb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 344; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 49, Serial#: 348
    public void rip_xorb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xorb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 348; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xorb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 50, Serial#: 352
    public void rip_cmpb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 352; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 51, Serial#: 396
    public void rip_addl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addl(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 396; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addl(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 52, Serial#: 400
    public void rip_orl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_orl(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 400; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_orl(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 53, Serial#: 404
    public void rip_adcl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adcl(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 404; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adcl(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 54, Serial#: 408
    public void rip_sbbl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbbl(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 408; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbbl(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 55, Serial#: 412
    public void rip_andl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andl(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 412; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andl(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 56, Serial#: 416
    public void rip_subl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subl(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 416; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subl(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 57, Serial#: 420
    public void rip_xorl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xorl(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 420; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xorl(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 58, Serial#: 424
    public void rip_cmpl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpl(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 424; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpl(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addq  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 59, Serial#: 468
    public void rip_addq(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addq(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 468; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addq(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orq  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 60, Serial#: 472
    public void rip_orq(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_orq(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 472; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_orq(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcq  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 61, Serial#: 476
    public void rip_adcq(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adcq(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 476; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adcq(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbq  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 62, Serial#: 480
    public void rip_sbbq(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbbq(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 480; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbbq(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andq  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 63, Serial#: 484
    public void rip_andq(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andq(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 484; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andq(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subq  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 64, Serial#: 488
    public void rip_subq(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subq(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 488; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subq(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorq  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 65, Serial#: 492
    public void rip_xorq(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xorq(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 492; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xorq(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpq  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 66, Serial#: 496
    public void rip_cmpq(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpq(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 496; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpq(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 67, Serial#: 540
    public void rip_addw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addw(placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 540; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addw(labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 68, Serial#: 544
    public void rip_orw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_orw(placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 544; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_orw(labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 69, Serial#: 548
    public void rip_adcw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adcw(placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 548; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adcw(labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 70, Serial#: 552
    public void rip_sbbw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbbw(placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 552; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbbw(labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 71, Serial#: 556
    public void rip_andw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andw(placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 556; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andw(labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 72, Serial#: 560
    public void rip_subw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subw(placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 560; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subw(labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 73, Serial#: 564
    public void rip_xorw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xorw(placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 564; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xorw(labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 74, Serial#: 568
    public void rip_cmpw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpw(placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 568; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpw(labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 75, Serial#: 612
    public void rip_addl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 612; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 76, Serial#: 616
    public void rip_orl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_orl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 616; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_orl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 77, Serial#: 620
    public void rip_adcl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adcl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 620; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adcl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 78, Serial#: 624
    public void rip_sbbl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbbl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 624; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbbl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 79, Serial#: 628
    public void rip_andl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 628; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 80, Serial#: 632
    public void rip_subl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 632; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 81, Serial#: 636
    public void rip_xorl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xorl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 636; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xorl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 82, Serial#: 640
    public void rip_cmpl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 640; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 83, Serial#: 684
    public void rip_addq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 684; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 84, Serial#: 688
    public void rip_orq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_orq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 688; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_orq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 85, Serial#: 692
    public void rip_adcq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adcq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 692; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adcq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 86, Serial#: 696
    public void rip_sbbq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbbq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 696; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbbq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 87, Serial#: 700
    public void rip_andq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 700; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 88, Serial#: 704
    public void rip_subq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 704; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 89, Serial#: 708
    public void rip_xorq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xorq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 708; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xorq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 90, Serial#: 712
    public void rip_cmpq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 712; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 91, Serial#: 756
    public void rip_addw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 756; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 92, Serial#: 760
    public void rip_orw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_orw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 760; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_orw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 93, Serial#: 764
    public void rip_adcw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_adcw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 764; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_adcw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 94, Serial#: 768
    public void rip_sbbw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbbw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 768; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbbw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 95, Serial#: 772
    public void rip_andw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 772; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 96, Serial#: 776
    public void rip_subw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 776; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 97, Serial#: 780
    public void rip_xorw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xorw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 780; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xorw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 98, Serial#: 784
    public void rip_cmpw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 784; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code test  }<i>label</i>, <i>source</i>
     */
    // Template#: 99, Serial#: 828
    public void rip_test(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_test(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 828; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_test(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code test  }<i>label</i>, <i>source</i>
     */
    // Template#: 100, Serial#: 837
    public void rip_test(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_test(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 837; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_test(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code test  }<i>label</i>, <i>source</i>
     */
    // Template#: 101, Serial#: 846
    public void rip_test(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_test(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 846; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_test(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code test  }<i>label</i>, <i>source</i>
     */
    // Template#: 102, Serial#: 855
    public void rip_test(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_test(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 855; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_test(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 103, Serial#: 864
    public void rip_xchg(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xchg(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 864; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xchg(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 104, Serial#: 873
    public void rip_xchg(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xchg(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 873; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xchg(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 105, Serial#: 882
    public void rip_xchg(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xchg(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 882; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xchg(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 106, Serial#: 891
    public void rip_xchg(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xchg(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 891; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xchg(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 107, Serial#: 901
    public void m_mov_AL(final Label label) {
        final int startOffset = currentOffset();
        final long placeHolder = 0;
        m_mov_AL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 901; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov_AL(labelAddressAsLong());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 108, Serial#: 902
    public void m_mov_EAX(final Label label) {
        final int startOffset = currentOffset();
        final long placeHolder = 0;
        m_mov_EAX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 902; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov_EAX(labelAddressAsLong());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 109, Serial#: 903
    public void m_mov_RAX(final Label label) {
        final int startOffset = currentOffset();
        final long placeHolder = 0;
        m_mov_RAX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 903; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov_RAX(labelAddressAsLong());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 110, Serial#: 904
    public void m_mov_AX(final Label label) {
        final int startOffset = currentOffset();
        final long placeHolder = 0;
        m_mov_AX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 904; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov_AX(labelAddressAsLong());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 111, Serial#: 905
    public void m_mov___AL(final Label label) {
        final int startOffset = currentOffset();
        final long placeHolder = 0;
        m_mov___AL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 905; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov___AL(labelAddressAsLong());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 112, Serial#: 906
    public void m_mov___EAX(final Label label) {
        final int startOffset = currentOffset();
        final long placeHolder = 0;
        m_mov___EAX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 906; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov___EAX(labelAddressAsLong());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 113, Serial#: 907
    public void m_mov___RAX(final Label label) {
        final int startOffset = currentOffset();
        final long placeHolder = 0;
        m_mov___RAX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 907; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov___RAX(labelAddressAsLong());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 114, Serial#: 908
    public void m_mov___AX(final Label label) {
        final int startOffset = currentOffset();
        final long placeHolder = 0;
        m_mov___AX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 908; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov___AX(labelAddressAsLong());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 115, Serial#: 921
    public void rip_rolb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rolb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 921; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rolb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 116, Serial#: 925
    public void rip_rorb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 925; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 117, Serial#: 929
    public void rip_rclb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rclb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 929; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rclb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 118, Serial#: 933
    public void rip_rcrb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 933; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 119, Serial#: 937
    public void rip_shlb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shlb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 937; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shlb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 120, Serial#: 941
    public void rip_shrb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 941; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 121, Serial#: 945
    public void rip_sarb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 945; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code roll  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 122, Serial#: 984
    public void rip_roll(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_roll(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 984; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_roll(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 123, Serial#: 988
    public void rip_rorl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 988; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcll  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 124, Serial#: 992
    public void rip_rcll(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcll(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 992; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcll(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 125, Serial#: 996
    public void rip_rcrl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 996; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shll  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 126, Serial#: 1000
    public void rip_shll(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shll(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1000; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shll(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 127, Serial#: 1004
    public void rip_shrl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1004; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 128, Serial#: 1008
    public void rip_sarl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarl(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1008; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarl(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 129, Serial#: 1047
    public void rip_rolq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rolq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1047; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rolq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 130, Serial#: 1051
    public void rip_rorq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1051; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 131, Serial#: 1055
    public void rip_rclq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rclq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1055; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rclq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 132, Serial#: 1059
    public void rip_rcrq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1059; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 133, Serial#: 1063
    public void rip_shlq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shlq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1063; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shlq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 134, Serial#: 1067
    public void rip_shrq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1067; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarq  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 135, Serial#: 1071
    public void rip_sarq(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarq(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1071; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarq(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 136, Serial#: 1110
    public void rip_rolw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rolw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1110; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rolw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 137, Serial#: 1114
    public void rip_rorw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1114; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 138, Serial#: 1118
    public void rip_rclw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rclw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1118; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rclw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 139, Serial#: 1122
    public void rip_rcrw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1122; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 140, Serial#: 1126
    public void rip_shlw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shlw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1126; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shlw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 141, Serial#: 1130
    public void rip_shrw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1130; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 142, Serial#: 1134
    public void rip_sarw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarw(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1134; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarw(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 143, Serial#: 1175
    public void rip_movb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1175; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 144, Serial#: 1184
    public void rip_movl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movl(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1184; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movl(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movq  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 145, Serial#: 1193
    public void rip_movq(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movq(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1193; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movq(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 146, Serial#: 1202
    public void rip_movw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movw(placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1202; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movw(labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolb  }<i>label</i>
     */
    // Template#: 147, Serial#: 1211
    public void rip_rolb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rolb___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1211; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rolb___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorb  }<i>label</i>
     */
    // Template#: 148, Serial#: 1215
    public void rip_rorb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorb___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1215; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorb___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclb  }<i>label</i>
     */
    // Template#: 149, Serial#: 1219
    public void rip_rclb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rclb___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1219; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rclb___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrb  }<i>label</i>
     */
    // Template#: 150, Serial#: 1223
    public void rip_rcrb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrb___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1223; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrb___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlb  }<i>label</i>
     */
    // Template#: 151, Serial#: 1227
    public void rip_shlb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shlb___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1227; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shlb___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrb  }<i>label</i>
     */
    // Template#: 152, Serial#: 1231
    public void rip_shrb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrb___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1231; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrb___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarb  }<i>label</i>
     */
    // Template#: 153, Serial#: 1235
    public void rip_sarb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarb___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1235; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarb___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code roll  }<i>label</i>
     */
    // Template#: 154, Serial#: 1274
    public void rip_roll___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_roll___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1274; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_roll___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorl  }<i>label</i>
     */
    // Template#: 155, Serial#: 1278
    public void rip_rorl___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorl___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1278; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorl___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcll  }<i>label</i>
     */
    // Template#: 156, Serial#: 1282
    public void rip_rcll___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcll___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1282; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcll___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrl  }<i>label</i>
     */
    // Template#: 157, Serial#: 1286
    public void rip_rcrl___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrl___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1286; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrl___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shll  }<i>label</i>
     */
    // Template#: 158, Serial#: 1290
    public void rip_shll___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shll___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1290; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shll___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrl  }<i>label</i>
     */
    // Template#: 159, Serial#: 1294
    public void rip_shrl___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrl___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1294; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrl___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarl  }<i>label</i>
     */
    // Template#: 160, Serial#: 1298
    public void rip_sarl___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarl___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1298; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarl___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolq  }<i>label</i>
     */
    // Template#: 161, Serial#: 1337
    public void rip_rolq___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rolq___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1337; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rolq___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorq  }<i>label</i>
     */
    // Template#: 162, Serial#: 1341
    public void rip_rorq___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorq___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1341; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorq___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclq  }<i>label</i>
     */
    // Template#: 163, Serial#: 1345
    public void rip_rclq___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rclq___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1345; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rclq___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrq  }<i>label</i>
     */
    // Template#: 164, Serial#: 1349
    public void rip_rcrq___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrq___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1349; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrq___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlq  }<i>label</i>
     */
    // Template#: 165, Serial#: 1353
    public void rip_shlq___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shlq___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1353; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shlq___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrq  }<i>label</i>
     */
    // Template#: 166, Serial#: 1357
    public void rip_shrq___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrq___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1357; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrq___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarq  }<i>label</i>
     */
    // Template#: 167, Serial#: 1361
    public void rip_sarq___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarq___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1361; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarq___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolw  }<i>label</i>
     */
    // Template#: 168, Serial#: 1400
    public void rip_rolw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rolw___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1400; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rolw___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorw  }<i>label</i>
     */
    // Template#: 169, Serial#: 1404
    public void rip_rorw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorw___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1404; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorw___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclw  }<i>label</i>
     */
    // Template#: 170, Serial#: 1408
    public void rip_rclw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rclw___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1408; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rclw___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrw  }<i>label</i>
     */
    // Template#: 171, Serial#: 1412
    public void rip_rcrw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrw___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1412; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrw___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlw  }<i>label</i>
     */
    // Template#: 172, Serial#: 1416
    public void rip_shlw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shlw___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1416; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shlw___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrw  }<i>label</i>
     */
    // Template#: 173, Serial#: 1420
    public void rip_shrw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrw___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1420; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrw___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarw  }<i>label</i>
     */
    // Template#: 174, Serial#: 1424
    public void rip_sarw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarw___1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1424; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarw___1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolb  }<i>label</i>
     */
    // Template#: 175, Serial#: 1463
    public void rip_rolb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rolb___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1463; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rolb___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorb  }<i>label</i>
     */
    // Template#: 176, Serial#: 1467
    public void rip_rorb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorb___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1467; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorb___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclb  }<i>label</i>
     */
    // Template#: 177, Serial#: 1471
    public void rip_rclb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rclb___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1471; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rclb___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrb  }<i>label</i>
     */
    // Template#: 178, Serial#: 1475
    public void rip_rcrb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrb___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1475; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrb___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlb  }<i>label</i>
     */
    // Template#: 179, Serial#: 1479
    public void rip_shlb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shlb___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1479; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shlb___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrb  }<i>label</i>
     */
    // Template#: 180, Serial#: 1483
    public void rip_shrb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrb___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1483; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrb___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarb  }<i>label</i>
     */
    // Template#: 181, Serial#: 1487
    public void rip_sarb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarb___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1487; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarb___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code roll  }<i>label</i>
     */
    // Template#: 182, Serial#: 1526
    public void rip_roll___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_roll___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1526; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_roll___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorl  }<i>label</i>
     */
    // Template#: 183, Serial#: 1530
    public void rip_rorl___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorl___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1530; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorl___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcll  }<i>label</i>
     */
    // Template#: 184, Serial#: 1534
    public void rip_rcll___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcll___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1534; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcll___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrl  }<i>label</i>
     */
    // Template#: 185, Serial#: 1538
    public void rip_rcrl___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrl___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1538; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrl___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shll  }<i>label</i>
     */
    // Template#: 186, Serial#: 1542
    public void rip_shll___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shll___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1542; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shll___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrl  }<i>label</i>
     */
    // Template#: 187, Serial#: 1546
    public void rip_shrl___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrl___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1546; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrl___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarl  }<i>label</i>
     */
    // Template#: 188, Serial#: 1550
    public void rip_sarl___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarl___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1550; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarl___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolq  }<i>label</i>
     */
    // Template#: 189, Serial#: 1589
    public void rip_rolq___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rolq___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1589; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rolq___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorq  }<i>label</i>
     */
    // Template#: 190, Serial#: 1593
    public void rip_rorq___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorq___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1593; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorq___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclq  }<i>label</i>
     */
    // Template#: 191, Serial#: 1597
    public void rip_rclq___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rclq___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1597; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rclq___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrq  }<i>label</i>
     */
    // Template#: 192, Serial#: 1601
    public void rip_rcrq___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrq___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1601; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrq___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlq  }<i>label</i>
     */
    // Template#: 193, Serial#: 1605
    public void rip_shlq___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shlq___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1605; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shlq___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrq  }<i>label</i>
     */
    // Template#: 194, Serial#: 1609
    public void rip_shrq___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrq___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1609; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrq___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarq  }<i>label</i>
     */
    // Template#: 195, Serial#: 1613
    public void rip_sarq___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarq___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1613; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarq___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolw  }<i>label</i>
     */
    // Template#: 196, Serial#: 1652
    public void rip_rolw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rolw___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1652; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rolw___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorw  }<i>label</i>
     */
    // Template#: 197, Serial#: 1656
    public void rip_rorw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rorw___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1656; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rorw___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclw  }<i>label</i>
     */
    // Template#: 198, Serial#: 1660
    public void rip_rclw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rclw___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1660; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rclw___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrw  }<i>label</i>
     */
    // Template#: 199, Serial#: 1664
    public void rip_rcrw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcrw___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1664; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcrw___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlw  }<i>label</i>
     */
    // Template#: 200, Serial#: 1668
    public void rip_shlw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shlw___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1668; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shlw___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrw  }<i>label</i>
     */
    // Template#: 201, Serial#: 1672
    public void rip_shrw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrw___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1672; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrw___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarw  }<i>label</i>
     */
    // Template#: 202, Serial#: 1676
    public void rip_sarw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sarw___CL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1676; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sarw___CL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code loopne  }<i>label</i>
     */
    // Template#: 203, Serial#: 1713
    public void loopne(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        loopne(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 1) {
            @Override
            protected int templateSerial() { return 1713; }
            @Override
            protected void assemble() throws AssemblyException {
                loopne(labelOffsetAsByte());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code loope  }<i>label</i>
     */
    // Template#: 204, Serial#: 1714
    public void loope(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        loope(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 1) {
            @Override
            protected int templateSerial() { return 1714; }
            @Override
            protected void assemble() throws AssemblyException {
                loope(labelOffsetAsByte());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code loop  }<i>label</i>
     */
    // Template#: 205, Serial#: 1715
    public void loop(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        loop(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 1) {
            @Override
            protected int templateSerial() { return 1715; }
            @Override
            protected void assemble() throws AssemblyException {
                loop(labelOffsetAsByte());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jrcxz  }<i>label</i>
     */
    // Template#: 206, Serial#: 1716
    public void jrcxz(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jrcxz(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 1) {
            @Override
            protected int templateSerial() { return 1716; }
            @Override
            protected void assemble() throws AssemblyException {
                jrcxz(labelOffsetAsByte());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code testb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 207, Serial#: 1734
    public void rip_testb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_testb(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1734; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_testb(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code notb  }<i>label</i>
     */
    // Template#: 208, Serial#: 1738
    public void rip_notb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_notb(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1738; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_notb(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code negb  }<i>label</i>
     */
    // Template#: 209, Serial#: 1742
    public void rip_negb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_negb(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1742; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_negb(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulb  }<i>label</i>
     */
    // Template#: 210, Serial#: 1746
    public void rip_mulb___AL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mulb___AL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1746; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mulb___AL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imulb  }<i>label</i>
     */
    // Template#: 211, Serial#: 1750
    public void rip_imulb___AL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imulb___AL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1750; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imulb___AL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divb  }<i>label</i>
     */
    // Template#: 212, Serial#: 1754
    public void rip_divb___AL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_divb___AL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1754; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_divb___AL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code idivb  }<i>label</i>
     */
    // Template#: 213, Serial#: 1758
    public void rip_idivb___AL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_idivb___AL(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1758; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_idivb___AL(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code testl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 214, Serial#: 1797
    public void rip_testl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_testl(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1797; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_testl(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code notl  }<i>label</i>
     */
    // Template#: 215, Serial#: 1801
    public void rip_notl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_notl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1801; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_notl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code negl  }<i>label</i>
     */
    // Template#: 216, Serial#: 1805
    public void rip_negl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_negl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1805; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_negl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mull  }<i>label</i>
     */
    // Template#: 217, Serial#: 1809
    public void rip_mull(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mull(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1809; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mull(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imull  }<i>label</i>
     */
    // Template#: 218, Serial#: 1813
    public void rip_imull(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imull(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1813; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imull(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divl  }<i>label</i>
     */
    // Template#: 219, Serial#: 1817
    public void rip_divl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_divl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1817; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_divl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code idivl  }<i>label</i>
     */
    // Template#: 220, Serial#: 1821
    public void rip_idivl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_idivl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1821; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_idivl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code testq  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 221, Serial#: 1860
    public void rip_testq(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_testq(placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1860; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_testq(labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code notq  }<i>label</i>
     */
    // Template#: 222, Serial#: 1864
    public void rip_notq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_notq(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1864; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_notq(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code negq  }<i>label</i>
     */
    // Template#: 223, Serial#: 1868
    public void rip_negq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_negq(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1868; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_negq(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulq  }<i>label</i>
     */
    // Template#: 224, Serial#: 1872
    public void rip_mulq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mulq(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1872; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mulq(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imulq  }<i>label</i>
     */
    // Template#: 225, Serial#: 1876
    public void rip_imulq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imulq(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1876; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imulq(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divq  }<i>label</i>
     */
    // Template#: 226, Serial#: 1880
    public void rip_divq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_divq(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1880; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_divq(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code idivq  }<i>label</i>
     */
    // Template#: 227, Serial#: 1884
    public void rip_idivq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_idivq(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1884; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_idivq(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code testw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 228, Serial#: 1923
    public void rip_testw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_testw(placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1923; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_testw(labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code notw  }<i>label</i>
     */
    // Template#: 229, Serial#: 1927
    public void rip_notw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_notw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1927; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_notw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code negw  }<i>label</i>
     */
    // Template#: 230, Serial#: 1931
    public void rip_negw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_negw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1931; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_negw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulw  }<i>label</i>
     */
    // Template#: 231, Serial#: 1935
    public void rip_mulw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mulw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1935; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mulw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imulw  }<i>label</i>
     */
    // Template#: 232, Serial#: 1939
    public void rip_imulw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imulw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1939; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imulw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divw  }<i>label</i>
     */
    // Template#: 233, Serial#: 1943
    public void rip_divw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_divw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1943; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_divw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code idivw  }<i>label</i>
     */
    // Template#: 234, Serial#: 1947
    public void rip_idivw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_idivw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1947; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_idivw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>label</i>, <i>source</i>
     */
    // Template#: 235, Serial#: 1986
    public void rip_or(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_or(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1986; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_or(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>label</i>, <i>source</i>
     */
    // Template#: 236, Serial#: 1995
    public void rip_or(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_or(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 1995; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_or(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>label</i>, <i>source</i>
     */
    // Template#: 237, Serial#: 2004
    public void rip_or(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_or(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2004; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_or(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>label</i>, <i>source</i>
     */
    // Template#: 238, Serial#: 2013
    public void rip_or(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_or(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2013; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_or(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>destination</i>, <i>label</i>
     */
    // Template#: 239, Serial#: 2022
    public void rip_or(final AMD64GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_or(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2022; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_or(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>destination</i>, <i>label</i>
     */
    // Template#: 240, Serial#: 2030
    public void rip_or(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_or(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2030; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_or(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>destination</i>, <i>label</i>
     */
    // Template#: 241, Serial#: 2038
    public void rip_or(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_or(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2038; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_or(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>destination</i>, <i>label</i>
     */
    // Template#: 242, Serial#: 2046
    public void rip_or(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_or(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2046; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_or(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>label</i>, <i>source</i>
     */
    // Template#: 243, Serial#: 2058
    public void rip_sbb(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbb(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2058; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbb(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>label</i>, <i>source</i>
     */
    // Template#: 244, Serial#: 2067
    public void rip_sbb(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbb(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2067; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbb(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>label</i>, <i>source</i>
     */
    // Template#: 245, Serial#: 2076
    public void rip_sbb(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbb(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2076; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbb(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>label</i>, <i>source</i>
     */
    // Template#: 246, Serial#: 2085
    public void rip_sbb(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbb(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2085; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbb(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 247, Serial#: 2094
    public void rip_sbb(final AMD64GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2094; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 248, Serial#: 2102
    public void rip_sbb(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2102; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 249, Serial#: 2110
    public void rip_sbb(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2110; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 250, Serial#: 2118
    public void rip_sbb(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sbb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2118; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sbb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>label</i>, <i>source</i>
     */
    // Template#: 251, Serial#: 2130
    public void rip_sub(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sub(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2130; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sub(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>label</i>, <i>source</i>
     */
    // Template#: 252, Serial#: 2139
    public void rip_sub(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sub(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2139; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sub(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>label</i>, <i>source</i>
     */
    // Template#: 253, Serial#: 2148
    public void rip_sub(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sub(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2148; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sub(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>label</i>, <i>source</i>
     */
    // Template#: 254, Serial#: 2157
    public void rip_sub(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sub(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2157; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sub(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 255, Serial#: 2166
    public void rip_sub(final AMD64GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sub(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2166; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sub(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 256, Serial#: 2174
    public void rip_sub(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sub(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2174; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sub(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 257, Serial#: 2182
    public void rip_sub(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sub(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2182; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sub(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 258, Serial#: 2190
    public void rip_sub(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sub(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2190; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sub(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>label</i>, <i>source</i>
     */
    // Template#: 259, Serial#: 2204
    public void rip_cmp(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmp(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2204; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmp(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>label</i>, <i>source</i>
     */
    // Template#: 260, Serial#: 2213
    public void rip_cmp(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmp(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2213; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmp(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>label</i>, <i>source</i>
     */
    // Template#: 261, Serial#: 2222
    public void rip_cmp(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmp(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2222; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmp(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>label</i>, <i>source</i>
     */
    // Template#: 262, Serial#: 2231
    public void rip_cmp(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmp(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2231; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmp(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 263, Serial#: 2240
    public void rip_cmp(final AMD64GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmp(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2240; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmp(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 264, Serial#: 2248
    public void rip_cmp(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmp(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2248; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmp(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 265, Serial#: 2256
    public void rip_cmp(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmp(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2256; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmp(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 266, Serial#: 2264
    public void rip_cmp(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmp(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2264; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmp(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>imm32</i>
     */
    // Template#: 267, Serial#: 2280
    public void rip_imul(final AMD64GeneralRegister32 destination, final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imul(destination, placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2280; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imul(destination, labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>imm32</i>
     */
    // Template#: 268, Serial#: 2289
    public void rip_imul(final AMD64GeneralRegister64 destination, final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imul(destination, placeHolder, imm32);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2289; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imul(destination, labelOffsetAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>imm16</i>
     */
    // Template#: 269, Serial#: 2298
    public void rip_imul(final AMD64GeneralRegister16 destination, final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imul(destination, placeHolder, imm16);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2298; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imul(destination, labelOffsetAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 270, Serial#: 2308
    public void rip_imul(final AMD64GeneralRegister32 destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imul(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2308; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imul(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 271, Serial#: 2317
    public void rip_imul(final AMD64GeneralRegister64 destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imul(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2317; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imul(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 272, Serial#: 2326
    public void rip_imul(final AMD64GeneralRegister16 destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imul(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2326; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imul(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code js  }<i>label</i>
     */
    // Template#: 273, Serial#: 2338
    public void js(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        js(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 2338; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        js(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        js(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jns  }<i>label</i>
     */
    // Template#: 274, Serial#: 2339
    public void jns(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jns(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 2339; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jns(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jns(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jp  }<i>label</i>
     */
    // Template#: 275, Serial#: 2340
    public void jp(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jp(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 2340; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jp(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jp(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jnp  }<i>label</i>
     */
    // Template#: 276, Serial#: 2341
    public void jnp(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnp(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 2341; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnp(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jnp(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jl  }<i>label</i>
     */
    // Template#: 277, Serial#: 2342
    public void jl(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 2342; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jl(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jl(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jnl  }<i>label</i>
     */
    // Template#: 278, Serial#: 2343
    public void jnl(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 2343; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnl(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jnl(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jle  }<i>label</i>
     */
    // Template#: 279, Serial#: 2344
    public void jle(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jle(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 2344; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jle(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jle(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jnle  }<i>label</i>
     */
    // Template#: 280, Serial#: 2345
    public void jnle(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnle(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 2345; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnle(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jnle(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>source</i>
     */
    // Template#: 281, Serial#: 2349
    public void rip_mov(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mov(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2349; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mov(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>source</i>
     */
    // Template#: 282, Serial#: 2358
    public void rip_mov(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mov(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2358; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mov(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>source</i>
     */
    // Template#: 283, Serial#: 2367
    public void rip_mov(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mov(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2367; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mov(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>source</i>
     */
    // Template#: 284, Serial#: 2376
    public void rip_mov(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mov(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2376; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mov(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>
     */
    // Template#: 285, Serial#: 2385
    public void rip_mov(final AMD64GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mov(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2385; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mov(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>
     */
    // Template#: 286, Serial#: 2393
    public void rip_mov(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mov(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2393; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mov(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>
     */
    // Template#: 287, Serial#: 2401
    public void rip_mov(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mov(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2401; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mov(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>
     */
    // Template#: 288, Serial#: 2409
    public void rip_mov(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mov(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2409; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mov(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>source</i>
     */
    // Template#: 289, Serial#: 2417
    public void rip_mov(final Label label, final SegmentRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mov(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2417; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mov(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lea  }<i>destination</i>, <i>label</i>
     */
    // Template#: 290, Serial#: 2426
    public void rip_lea(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lea(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2426; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lea(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lea  }<i>destination</i>, <i>label</i>
     */
    // Template#: 291, Serial#: 2434
    public void rip_lea(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lea(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2434; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lea(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lea  }<i>destination</i>, <i>label</i>
     */
    // Template#: 292, Serial#: 2442
    public void rip_lea(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lea(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2442; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lea(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>
     */
    // Template#: 293, Serial#: 2450
    public void rip_mov(final SegmentRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mov(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2450; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mov(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pop  }<i>label</i>
     */
    // Template#: 294, Serial#: 2459
    public void rip_pop(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pop(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2459; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pop(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fadds  }<i>label</i>
     */
    // Template#: 295, Serial#: 2504
    public void rip_fadds(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fadds(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2504; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fadds(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fmuls  }<i>label</i>
     */
    // Template#: 296, Serial#: 2508
    public void rip_fmuls(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fmuls(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2508; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fmuls(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcoms  }<i>label</i>
     */
    // Template#: 297, Serial#: 2512
    public void rip_fcoms(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fcoms(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2512; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fcoms(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcomps  }<i>label</i>
     */
    // Template#: 298, Serial#: 2516
    public void rip_fcomps(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fcomps(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2516; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fcomps(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubs  }<i>label</i>
     */
    // Template#: 299, Serial#: 2520
    public void rip_fsubs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fsubs(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2520; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fsubs(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubrs  }<i>label</i>
     */
    // Template#: 300, Serial#: 2524
    public void rip_fsubrs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fsubrs(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2524; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fsubrs(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivs  }<i>label</i>
     */
    // Template#: 301, Serial#: 2528
    public void rip_fdivs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fdivs(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2528; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fdivs(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivrs  }<i>label</i>
     */
    // Template#: 302, Serial#: 2532
    public void rip_fdivrs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fdivrs(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2532; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fdivrs(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code flds  }<i>label</i>
     */
    // Template#: 303, Serial#: 2568
    public void rip_flds(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_flds(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2568; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_flds(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsts  }<i>label</i>
     */
    // Template#: 304, Serial#: 2572
    public void rip_fsts(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fsts(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2572; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fsts(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstps  }<i>label</i>
     */
    // Template#: 305, Serial#: 2576
    public void rip_fstps(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fstps(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2576; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fstps(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldenv  }<i>label</i>
     */
    // Template#: 306, Serial#: 2580
    public void rip_fldenv(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fldenv(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2580; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fldenv(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldcw  }<i>label</i>
     */
    // Template#: 307, Serial#: 2584
    public void rip_fldcw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fldcw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2584; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fldcw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstenv  }<i>label</i>
     */
    // Template#: 308, Serial#: 2588
    public void rip_fstenv(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fstenv(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2588; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fstenv(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstcw  }<i>label</i>
     */
    // Template#: 309, Serial#: 2592
    public void rip_fstcw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fstcw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2592; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fstcw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fiaddl  }<i>label</i>
     */
    // Template#: 310, Serial#: 2624
    public void rip_fiaddl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fiaddl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2624; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fiaddl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fimull  }<i>label</i>
     */
    // Template#: 311, Serial#: 2628
    public void rip_fimull(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fimull(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2628; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fimull(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficoml  }<i>label</i>
     */
    // Template#: 312, Serial#: 2632
    public void rip_ficoml(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_ficoml(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2632; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_ficoml(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficompl  }<i>label</i>
     */
    // Template#: 313, Serial#: 2636
    public void rip_ficompl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_ficompl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2636; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_ficompl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubl  }<i>label</i>
     */
    // Template#: 314, Serial#: 2640
    public void rip_fisubl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fisubl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2640; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fisubl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubrl  }<i>label</i>
     */
    // Template#: 315, Serial#: 2644
    public void rip_fisubrl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fisubrl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2644; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fisubrl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivl  }<i>label</i>
     */
    // Template#: 316, Serial#: 2648
    public void rip_fidivl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fidivl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2648; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fidivl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivrl  }<i>label</i>
     */
    // Template#: 317, Serial#: 2652
    public void rip_fidivrl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fidivrl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2652; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fidivrl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fildl  }<i>label</i>
     */
    // Template#: 318, Serial#: 2688
    public void rip_fildl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fildl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2688; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fildl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistl  }<i>label</i>
     */
    // Template#: 319, Serial#: 2692
    public void rip_fistl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fistl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2692; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fistl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistpl  }<i>label</i>
     */
    // Template#: 320, Serial#: 2696
    public void rip_fistpl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fistpl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2696; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fistpl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldt  }<i>label</i>
     */
    // Template#: 321, Serial#: 2700
    public void rip_fldt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fldt(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2700; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fldt(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstpt  }<i>label</i>
     */
    // Template#: 322, Serial#: 2704
    public void rip_fstpt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fstpt(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2704; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fstpt(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code faddl  }<i>label</i>
     */
    // Template#: 323, Serial#: 2728
    public void rip_faddl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_faddl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2728; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_faddl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fmull  }<i>label</i>
     */
    // Template#: 324, Serial#: 2732
    public void rip_fmull(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fmull(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2732; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fmull(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcoml  }<i>label</i>
     */
    // Template#: 325, Serial#: 2736
    public void rip_fcoml(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fcoml(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2736; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fcoml(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcompl  }<i>label</i>
     */
    // Template#: 326, Serial#: 2740
    public void rip_fcompl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fcompl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2740; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fcompl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubl  }<i>label</i>
     */
    // Template#: 327, Serial#: 2744
    public void rip_fsubl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fsubl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2744; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fsubl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubrl  }<i>label</i>
     */
    // Template#: 328, Serial#: 2748
    public void rip_fsubrl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fsubrl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2748; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fsubrl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivl  }<i>label</i>
     */
    // Template#: 329, Serial#: 2752
    public void rip_fdivl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fdivl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2752; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fdivl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivrl  }<i>label</i>
     */
    // Template#: 330, Serial#: 2756
    public void rip_fdivrl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fdivrl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2756; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fdivrl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldl  }<i>label</i>
     */
    // Template#: 331, Serial#: 2792
    public void rip_fldl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fldl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2792; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fldl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstl  }<i>label</i>
     */
    // Template#: 332, Serial#: 2796
    public void rip_fstl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fstl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2796; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fstl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstpl  }<i>label</i>
     */
    // Template#: 333, Serial#: 2800
    public void rip_fstpl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fstpl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2800; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fstpl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code frstor  }<i>label</i>
     */
    // Template#: 334, Serial#: 2804
    public void rip_frstor(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_frstor(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2804; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_frstor(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsave  }<i>label</i>
     */
    // Template#: 335, Serial#: 2808
    public void rip_fsave(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fsave(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2808; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fsave(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstsw  }<i>label</i>
     */
    // Template#: 336, Serial#: 2812
    public void rip_fstsw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fstsw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2812; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fstsw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fiadds  }<i>label</i>
     */
    // Template#: 337, Serial#: 2840
    public void rip_fiadds(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fiadds(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2840; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fiadds(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fimuls  }<i>label</i>
     */
    // Template#: 338, Serial#: 2844
    public void rip_fimuls(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fimuls(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2844; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fimuls(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficoms  }<i>label</i>
     */
    // Template#: 339, Serial#: 2848
    public void rip_ficoms(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_ficoms(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2848; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_ficoms(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficomps  }<i>label</i>
     */
    // Template#: 340, Serial#: 2852
    public void rip_ficomps(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_ficomps(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2852; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_ficomps(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubs  }<i>label</i>
     */
    // Template#: 341, Serial#: 2856
    public void rip_fisubs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fisubs(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2856; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fisubs(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubrs  }<i>label</i>
     */
    // Template#: 342, Serial#: 2860
    public void rip_fisubrs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fisubrs(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2860; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fisubrs(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivs  }<i>label</i>
     */
    // Template#: 343, Serial#: 2864
    public void rip_fidivs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fidivs(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2864; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fidivs(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivrs  }<i>label</i>
     */
    // Template#: 344, Serial#: 2868
    public void rip_fidivrs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fidivrs(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2868; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fidivrs(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code filds  }<i>label</i>
     */
    // Template#: 345, Serial#: 2904
    public void rip_filds(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_filds(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2904; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_filds(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fists  }<i>label</i>
     */
    // Template#: 346, Serial#: 2908
    public void rip_fists(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fists(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2908; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fists(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistps  }<i>label</i>
     */
    // Template#: 347, Serial#: 2912
    public void rip_fistps(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fistps(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2912; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fistps(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbld  }<i>label</i>
     */
    // Template#: 348, Serial#: 2916
    public void rip_fbld(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fbld(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2916; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fbld(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fildq  }<i>label</i>
     */
    // Template#: 349, Serial#: 2920
    public void rip_fildq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fildq(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2920; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fildq(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbstp  }<i>label</i>
     */
    // Template#: 350, Serial#: 2924
    public void rip_fbstp(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fbstp(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2924; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fbstp(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistpq  }<i>label</i>
     */
    // Template#: 351, Serial#: 2928
    public void rip_fistpq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fistpq(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2928; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fistpq(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code call  }<i>label</i>
     */
    // Template#: 352, Serial#: 2957
    public void call(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        call(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2957; }
            @Override
            protected void assemble() throws AssemblyException {
                call(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jmp  }<i>label</i>
     */
    // Template#: 353, Serial#: 2958
    public void jmp(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jmp(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 5) {
            @Override
            protected int templateSerial() { return 2958; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jmp(labelOffsetAsByte());
                        break;
                    }
                    case BITS_32: {
                        jmp(labelOffsetAsInt());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jmp  }<i>label</i>
     */
    // Template#: 354, Serial#: 2959
    /**
     * Pseudo-external assembler syntax: {@code incb  }<i>label</i>
     */
    // Template#: 355, Serial#: 2977
    public void rip_incb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_incb(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2977; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_incb(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code decb  }<i>label</i>
     */
    // Template#: 356, Serial#: 2981
    public void rip_decb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_decb(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2981; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_decb(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code incl  }<i>label</i>
     */
    // Template#: 357, Serial#: 2995
    public void rip_incl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_incl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2995; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_incl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code decl  }<i>label</i>
     */
    // Template#: 358, Serial#: 2999
    public void rip_decl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_decl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 2999; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_decl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code incq  }<i>label</i>
     */
    // Template#: 359, Serial#: 3013
    public void rip_incq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_incq(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3013; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_incq(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code decq  }<i>label</i>
     */
    // Template#: 360, Serial#: 3017
    public void rip_decq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_decq(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3017; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_decq(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code incw  }<i>label</i>
     */
    // Template#: 361, Serial#: 3031
    public void rip_incw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_incw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3031; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_incw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code decw  }<i>label</i>
     */
    // Template#: 362, Serial#: 3035
    public void rip_decw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_decw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3035; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_decw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code call  }<i>label</i>
     */
    // Template#: 363, Serial#: 3049
    public void rip_call(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_call(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3049; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_call(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jmp  }<i>label</i>
     */
    // Template#: 364, Serial#: 3053
    public void rip_jmp(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_jmp(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3053; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_jmp(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code push  }<i>label</i>
     */
    // Template#: 365, Serial#: 3057
    public void rip_push(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_push(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3057; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_push(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sldt  }<i>label</i>
     */
    // Template#: 366, Serial#: 3077
    public void rip_sldt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sldt(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3077; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sldt(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code str  }<i>label</i>
     */
    // Template#: 367, Serial#: 3081
    public void rip_str(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_str(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3081; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_str(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lldt  }<i>label</i>
     */
    // Template#: 368, Serial#: 3085
    public void rip_lldt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lldt(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3085; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lldt(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ltr  }<i>label</i>
     */
    // Template#: 369, Serial#: 3089
    public void rip_ltr(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_ltr(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3089; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_ltr(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code verr  }<i>label</i>
     */
    // Template#: 370, Serial#: 3093
    public void rip_verr(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_verr(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3093; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_verr(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code verw  }<i>label</i>
     */
    // Template#: 371, Serial#: 3097
    public void rip_verw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_verw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3097; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_verw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sgdt  }<i>label</i>
     */
    // Template#: 372, Serial#: 3135
    public void rip_sgdt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sgdt(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3135; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sgdt(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sidt  }<i>label</i>
     */
    // Template#: 373, Serial#: 3139
    public void rip_sidt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sidt(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3139; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sidt(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lgdt  }<i>label</i>
     */
    // Template#: 374, Serial#: 3143
    public void rip_lgdt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lgdt(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3143; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lgdt(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lidt  }<i>label</i>
     */
    // Template#: 375, Serial#: 3147
    public void rip_lidt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lidt(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3147; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lidt(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code smsw  }<i>label</i>
     */
    // Template#: 376, Serial#: 3151
    public void rip_smsw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_smsw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3151; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_smsw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lmsw  }<i>label</i>
     */
    // Template#: 377, Serial#: 3155
    public void rip_lmsw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lmsw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3155; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lmsw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code invlpg  }<i>label</i>
     */
    // Template#: 378, Serial#: 3159
    public void rip_invlpg(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_invlpg(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3159; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_invlpg(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lar  }<i>destination</i>, <i>label</i>
     */
    // Template#: 379, Serial#: 3196
    public void rip_lar(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lar(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3196; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lar(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lar  }<i>destination</i>, <i>label</i>
     */
    // Template#: 380, Serial#: 3205
    public void rip_lar(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lar(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3205; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lar(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lar  }<i>destination</i>, <i>label</i>
     */
    // Template#: 381, Serial#: 3214
    public void rip_lar(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lar(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3214; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lar(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lsl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 382, Serial#: 3223
    public void rip_lsl(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lsl(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3223; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lsl(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lsl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 383, Serial#: 3232
    public void rip_lsl(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lsl(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3232; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lsl(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lsl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 384, Serial#: 3241
    public void rip_lsl(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lsl(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3241; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lsl(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movups  }<i>destination</i>, <i>label</i>
     */
    // Template#: 385, Serial#: 3253
    public void rip_movups(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movups(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3253; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movups(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movups  }<i>label</i>, <i>source</i>
     */
    // Template#: 386, Serial#: 3262
    public void rip_movups(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movups(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3262; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movups(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movlps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 387, Serial#: 3270
    public void rip_movlps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movlps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3270; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movlps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movlps  }<i>label</i>, <i>source</i>
     */
    // Template#: 388, Serial#: 3278
    public void rip_movlps(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movlps(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3278; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movlps(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code unpcklps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 389, Serial#: 3286
    public void rip_unpcklps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_unpcklps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3286; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_unpcklps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code unpckhps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 390, Serial#: 3295
    public void rip_unpckhps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_unpckhps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3295; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_unpckhps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movhps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 391, Serial#: 3304
    public void rip_movhps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movhps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3304; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movhps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movhps  }<i>label</i>, <i>source</i>
     */
    // Template#: 392, Serial#: 3312
    public void rip_movhps(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movhps(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3312; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movhps(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movupd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 393, Serial#: 3320
    public void rip_movupd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movupd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3320; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movupd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movupd  }<i>label</i>, <i>source</i>
     */
    // Template#: 394, Serial#: 3329
    public void rip_movupd(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movupd(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3329; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movupd(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movlpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 395, Serial#: 3337
    public void rip_movlpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movlpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3337; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movlpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movlpd  }<i>label</i>, <i>source</i>
     */
    // Template#: 396, Serial#: 3345
    public void rip_movlpd(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movlpd(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3345; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movlpd(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code unpcklpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 397, Serial#: 3353
    public void rip_unpcklpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_unpcklpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3353; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_unpcklpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code unpckhpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 398, Serial#: 3362
    public void rip_unpckhpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_unpckhpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3362; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_unpckhpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movhpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 399, Serial#: 3371
    public void rip_movhpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movhpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3371; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movhpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movhpd  }<i>label</i>, <i>source</i>
     */
    // Template#: 400, Serial#: 3379
    public void rip_movhpd(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movhpd(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3379; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movhpd(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 401, Serial#: 3387
    public void rip_movsd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movsd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3387; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movsd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsd  }<i>label</i>, <i>source</i>
     */
    // Template#: 402, Serial#: 3396
    public void rip_movsd(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movsd(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3396; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movsd(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movddup  }<i>destination</i>, <i>label</i>
     */
    // Template#: 403, Serial#: 3404
    public void rip_movddup(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movddup(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3404; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movddup(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 404, Serial#: 3413
    public void rip_movss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3413; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movss  }<i>label</i>, <i>source</i>
     */
    // Template#: 405, Serial#: 3422
    public void rip_movss(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movss(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3422; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movss(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsldup  }<i>destination</i>, <i>label</i>
     */
    // Template#: 406, Serial#: 3430
    public void rip_movsldup(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movsldup(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3430; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movsldup(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovo  }<i>destination</i>, <i>label</i>
     */
    // Template#: 407, Serial#: 3447
    public void rip_cmovo(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovo(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3447; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovo(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovo  }<i>destination</i>, <i>label</i>
     */
    // Template#: 408, Serial#: 3456
    public void rip_cmovo(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovo(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3456; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovo(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovo  }<i>destination</i>, <i>label</i>
     */
    // Template#: 409, Serial#: 3465
    public void rip_cmovo(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovo(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3465; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovo(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovno  }<i>destination</i>, <i>label</i>
     */
    // Template#: 410, Serial#: 3474
    public void rip_cmovno(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovno(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3474; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovno(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovno  }<i>destination</i>, <i>label</i>
     */
    // Template#: 411, Serial#: 3483
    public void rip_cmovno(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovno(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3483; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovno(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovno  }<i>destination</i>, <i>label</i>
     */
    // Template#: 412, Serial#: 3492
    public void rip_cmovno(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovno(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3492; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovno(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 413, Serial#: 3501
    public void rip_cmovb(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3501; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 414, Serial#: 3510
    public void rip_cmovb(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3510; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 415, Serial#: 3519
    public void rip_cmovb(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3519; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovae  }<i>destination</i>, <i>label</i>
     */
    // Template#: 416, Serial#: 3528
    public void rip_cmovae(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovae(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3528; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovae(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovae  }<i>destination</i>, <i>label</i>
     */
    // Template#: 417, Serial#: 3537
    public void rip_cmovae(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovae(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3537; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovae(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovae  }<i>destination</i>, <i>label</i>
     */
    // Template#: 418, Serial#: 3546
    public void rip_cmovae(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovae(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3546; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovae(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmove  }<i>destination</i>, <i>label</i>
     */
    // Template#: 419, Serial#: 3555
    public void rip_cmove(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmove(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3555; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmove(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmove  }<i>destination</i>, <i>label</i>
     */
    // Template#: 420, Serial#: 3564
    public void rip_cmove(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmove(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3564; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmove(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmove  }<i>destination</i>, <i>label</i>
     */
    // Template#: 421, Serial#: 3573
    public void rip_cmove(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmove(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3573; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmove(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovne  }<i>destination</i>, <i>label</i>
     */
    // Template#: 422, Serial#: 3582
    public void rip_cmovne(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovne(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3582; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovne(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovne  }<i>destination</i>, <i>label</i>
     */
    // Template#: 423, Serial#: 3591
    public void rip_cmovne(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovne(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3591; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovne(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovne  }<i>destination</i>, <i>label</i>
     */
    // Template#: 424, Serial#: 3600
    public void rip_cmovne(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovne(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3600; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovne(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovbe  }<i>destination</i>, <i>label</i>
     */
    // Template#: 425, Serial#: 3609
    public void rip_cmovbe(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovbe(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3609; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovbe(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovbe  }<i>destination</i>, <i>label</i>
     */
    // Template#: 426, Serial#: 3618
    public void rip_cmovbe(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovbe(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3618; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovbe(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovbe  }<i>destination</i>, <i>label</i>
     */
    // Template#: 427, Serial#: 3627
    public void rip_cmovbe(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovbe(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3627; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovbe(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmova  }<i>destination</i>, <i>label</i>
     */
    // Template#: 428, Serial#: 3636
    public void rip_cmova(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmova(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3636; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmova(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmova  }<i>destination</i>, <i>label</i>
     */
    // Template#: 429, Serial#: 3645
    public void rip_cmova(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmova(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3645; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmova(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmova  }<i>destination</i>, <i>label</i>
     */
    // Template#: 430, Serial#: 3654
    public void rip_cmova(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmova(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3654; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmova(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sqrtps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 431, Serial#: 3664
    public void rip_sqrtps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sqrtps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3664; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sqrtps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rsqrtps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 432, Serial#: 3673
    public void rip_rsqrtps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rsqrtps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3673; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rsqrtps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcpps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 433, Serial#: 3682
    public void rip_rcpps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcpps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3682; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcpps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 434, Serial#: 3691
    public void rip_andps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3691; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andnps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 435, Serial#: 3700
    public void rip_andnps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andnps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3700; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andnps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 436, Serial#: 3709
    public void rip_orps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_orps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3709; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_orps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 437, Serial#: 3718
    public void rip_xorps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xorps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3718; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xorps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sqrtpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 438, Serial#: 3728
    public void rip_sqrtpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sqrtpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3728; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sqrtpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 439, Serial#: 3737
    public void rip_andpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3737; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andnpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 440, Serial#: 3746
    public void rip_andnpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_andnpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3746; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_andnpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 441, Serial#: 3755
    public void rip_orpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_orpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3755; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_orpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 442, Serial#: 3764
    public void rip_xorpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xorpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3764; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xorpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sqrtsd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 443, Serial#: 3773
    public void rip_sqrtsd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sqrtsd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3773; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sqrtsd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sqrtss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 444, Serial#: 3782
    public void rip_sqrtss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sqrtss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3782; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sqrtss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rsqrtss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 445, Serial#: 3791
    public void rip_rsqrtss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rsqrtss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3791; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rsqrtss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcpss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 446, Serial#: 3800
    public void rip_rcpss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_rcpss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3800; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_rcpss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpcklbw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 447, Serial#: 3809
    public void rip_punpcklbw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpcklbw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3809; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpcklbw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpcklwd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 448, Serial#: 3818
    public void rip_punpcklwd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpcklwd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3818; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpcklwd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckldq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 449, Serial#: 3827
    public void rip_punpckldq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpckldq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3827; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpckldq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packsswb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 450, Serial#: 3836
    public void rip_packsswb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_packsswb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3836; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_packsswb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 451, Serial#: 3845
    public void rip_pcmpgtb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpgtb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3845; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpgtb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 452, Serial#: 3854
    public void rip_pcmpgtw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpgtw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3854; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpgtw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 453, Serial#: 3863
    public void rip_pcmpgtd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpgtd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3863; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpgtd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packuswb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 454, Serial#: 3872
    public void rip_packuswb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_packuswb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3872; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_packuswb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpcklbw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 455, Serial#: 3881
    public void rip_punpcklbw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpcklbw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3881; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpcklbw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpcklwd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 456, Serial#: 3890
    public void rip_punpcklwd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpcklwd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3890; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpcklwd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckldq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 457, Serial#: 3899
    public void rip_punpckldq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpckldq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3899; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpckldq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packsswb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 458, Serial#: 3908
    public void rip_packsswb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_packsswb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3908; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_packsswb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 459, Serial#: 3917
    public void rip_pcmpgtb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpgtb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3917; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpgtb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 460, Serial#: 3926
    public void rip_pcmpgtw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpgtw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3926; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpgtw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 461, Serial#: 3935
    public void rip_pcmpgtd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpgtd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3935; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpgtd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packuswb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 462, Serial#: 3944
    public void rip_packuswb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_packuswb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3944; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_packuswb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pshufw  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 463, Serial#: 3953
    public void rip_pshufw(final MMXRegister destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pshufw(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3953; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pshufw(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 464, Serial#: 3970
    public void rip_pcmpeqb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpeqb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3970; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpeqb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 465, Serial#: 3979
    public void rip_pcmpeqw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpeqw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3979; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpeqw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 466, Serial#: 3988
    public void rip_pcmpeqd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpeqd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3988; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpeqd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pshufd  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 467, Serial#: 3998
    public void rip_pshufd(final AMD64XMMRegister destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pshufd(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 3998; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pshufd(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 468, Serial#: 4017
    public void rip_pcmpeqb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpeqb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4017; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpeqb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 469, Serial#: 4026
    public void rip_pcmpeqw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpeqw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4026; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpeqw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 470, Serial#: 4035
    public void rip_pcmpeqd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pcmpeqd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4035; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pcmpeqd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pshuflw  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 471, Serial#: 4044
    public void rip_pshuflw(final AMD64XMMRegister destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pshuflw(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4044; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pshuflw(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pshufhw  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 472, Serial#: 4053
    public void rip_pshufhw(final AMD64XMMRegister destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pshufhw(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4053; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pshufhw(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jo  }<i>label</i>
     */
    // Template#: 473, Serial#: 4059
    /**
     * Pseudo-external assembler syntax: {@code jno  }<i>label</i>
     */
    // Template#: 474, Serial#: 4060
    /**
     * Pseudo-external assembler syntax: {@code jb  }<i>label</i>
     */
    // Template#: 475, Serial#: 4061
    /**
     * Pseudo-external assembler syntax: {@code jnb  }<i>label</i>
     */
    // Template#: 476, Serial#: 4062
    /**
     * Pseudo-external assembler syntax: {@code jz  }<i>label</i>
     */
    // Template#: 477, Serial#: 4063
    /**
     * Pseudo-external assembler syntax: {@code jnz  }<i>label</i>
     */
    // Template#: 478, Serial#: 4064
    /**
     * Pseudo-external assembler syntax: {@code jbe  }<i>label</i>
     */
    // Template#: 479, Serial#: 4065
    /**
     * Pseudo-external assembler syntax: {@code jnbe  }<i>label</i>
     */
    // Template#: 480, Serial#: 4066
    /**
     * Pseudo-external assembler syntax: {@code seto  }<i>label</i>
     */
    // Template#: 481, Serial#: 4070
    public void rip_seto(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_seto(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4070; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_seto(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setno  }<i>label</i>
     */
    // Template#: 482, Serial#: 4079
    public void rip_setno(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setno(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4079; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setno(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setb  }<i>label</i>
     */
    // Template#: 483, Serial#: 4088
    public void rip_setb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setb(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4088; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setb(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnb  }<i>label</i>
     */
    // Template#: 484, Serial#: 4097
    public void rip_setnb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setnb(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4097; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setnb(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setz  }<i>label</i>
     */
    // Template#: 485, Serial#: 4106
    public void rip_setz(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setz(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4106; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setz(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnz  }<i>label</i>
     */
    // Template#: 486, Serial#: 4115
    public void rip_setnz(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setnz(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4115; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setnz(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setbe  }<i>label</i>
     */
    // Template#: 487, Serial#: 4124
    public void rip_setbe(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setbe(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4124; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setbe(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnbe  }<i>label</i>
     */
    // Template#: 488, Serial#: 4133
    public void rip_setnbe(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setnbe(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4133; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setnbe(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt  }<i>label</i>, <i>source</i>
     */
    // Template#: 489, Serial#: 4145
    public void rip_bt(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bt(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4145; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bt(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt  }<i>label</i>, <i>source</i>
     */
    // Template#: 490, Serial#: 4154
    public void rip_bt(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bt(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4154; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bt(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt  }<i>label</i>, <i>source</i>
     */
    // Template#: 491, Serial#: 4163
    public void rip_bt(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bt(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4163; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bt(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 492, Serial#: 4172
    public void rip_shld(final Label label, final AMD64GeneralRegister32 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shld(placeHolder, source, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4172; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shld(labelOffsetAsInt(), source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 493, Serial#: 4181
    public void rip_shld(final Label label, final AMD64GeneralRegister64 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shld(placeHolder, source, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4181; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shld(labelOffsetAsInt(), source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 494, Serial#: 4190
    public void rip_shld(final Label label, final AMD64GeneralRegister16 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shld(placeHolder, source, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4190; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shld(labelOffsetAsInt(), source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>source</i>
     */
    // Template#: 495, Serial#: 4199
    public void rip_shld_CL(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shld_CL(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4199; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shld_CL(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>source</i>
     */
    // Template#: 496, Serial#: 4208
    public void rip_shld_CL(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shld_CL(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4208; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shld_CL(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>source</i>
     */
    // Template#: 497, Serial#: 4217
    public void rip_shld_CL(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shld_CL(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4217; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shld_CL(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 498, Serial#: 4226
    public void rip_cmpxchg(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpxchg(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4226; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpxchg(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 499, Serial#: 4235
    public void rip_cmpxchg(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpxchg(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4235; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpxchg(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 500, Serial#: 4244
    public void rip_cmpxchg(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpxchg(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4244; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpxchg(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 501, Serial#: 4253
    public void rip_cmpxchg(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpxchg(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4253; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpxchg(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btr  }<i>label</i>, <i>source</i>
     */
    // Template#: 502, Serial#: 4262
    public void rip_btr(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_btr(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4262; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_btr(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btr  }<i>label</i>, <i>source</i>
     */
    // Template#: 503, Serial#: 4271
    public void rip_btr(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_btr(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4271; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_btr(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btr  }<i>label</i>, <i>source</i>
     */
    // Template#: 504, Serial#: 4280
    public void rip_btr(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_btr(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4280; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_btr(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzx  }<i>destination</i>, <i>label</i>
     */
    // Template#: 505, Serial#: 4289
    public void rip_movzxb(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movzxb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4289; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movzxb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzx  }<i>destination</i>, <i>label</i>
     */
    // Template#: 506, Serial#: 4298
    public void rip_movzxb(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movzxb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4298; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movzxb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzx  }<i>destination</i>, <i>label</i>
     */
    // Template#: 507, Serial#: 4307
    public void rip_movzxb(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movzxb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4307; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movzxb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzxw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 508, Serial#: 4316
    public void rip_movzxw(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movzxw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4316; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movzxw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzxw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 509, Serial#: 4325
    public void rip_movzxw(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movzxw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4325; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movzxw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xadd  }<i>label</i>, <i>source</i>
     */
    // Template#: 510, Serial#: 4334
    public void rip_xadd(final Label label, final AMD64GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xadd(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4334; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xadd(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xadd  }<i>label</i>, <i>source</i>
     */
    // Template#: 511, Serial#: 4343
    public void rip_xadd(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xadd(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4343; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xadd(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xadd  }<i>label</i>, <i>source</i>
     */
    // Template#: 512, Serial#: 4352
    public void rip_xadd(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xadd(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4352; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xadd(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xadd  }<i>label</i>, <i>source</i>
     */
    // Template#: 513, Serial#: 4361
    public void rip_xadd(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_xadd(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4361; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_xadd(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpps  }<i>destination</i>, <i>label</i>, <i>amd64xmmcomparison</i>
     */
    // Template#: 514, Serial#: 4370
    public void rip_cmpps(final AMD64XMMRegister destination, final Label label, final AMD64XMMComparison amd64xmmcomparison) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpps(destination, placeHolder, amd64xmmcomparison);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4370; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpps(destination, labelOffsetAsInt(), amd64xmmcomparison);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movnti  }<i>label</i>, <i>source</i>
     */
    // Template#: 515, Serial#: 4379
    public void rip_movnti(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movnti(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4379; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movnti(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movnti  }<i>label</i>, <i>source</i>
     */
    // Template#: 516, Serial#: 4387
    public void rip_movnti(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movnti(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4387; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movnti(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pinsrw  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 517, Serial#: 4395
    public void rip_pinsrw(final MMXRegister destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pinsrw(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4395; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pinsrw(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shufps  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 518, Serial#: 4405
    public void rip_shufps(final AMD64XMMRegister destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shufps(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4405; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shufps(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg16b  }<i>label</i>
     */
    // Template#: 519, Serial#: 4414
    public void rip_cmpxchg16b(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpxchg16b(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4414; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpxchg16b(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmppd  }<i>destination</i>, <i>label</i>, <i>amd64xmmcomparison</i>
     */
    // Template#: 520, Serial#: 4422
    public void rip_cmppd(final AMD64XMMRegister destination, final Label label, final AMD64XMMComparison amd64xmmcomparison) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmppd(destination, placeHolder, amd64xmmcomparison);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4422; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmppd(destination, labelOffsetAsInt(), amd64xmmcomparison);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pinsrw  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 521, Serial#: 4431
    public void rip_pinsrw(final AMD64XMMRegister destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pinsrw(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4431; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pinsrw(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shufpd  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 522, Serial#: 4441
    public void rip_shufpd(final AMD64XMMRegister destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shufpd(destination, placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4441; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shufpd(destination, labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpsd  }<i>destination</i>, <i>label</i>, <i>amd64xmmcomparison</i>
     */
    // Template#: 523, Serial#: 4450
    public void rip_cmpsd(final AMD64XMMRegister destination, final Label label, final AMD64XMMComparison amd64xmmcomparison) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpsd(destination, placeHolder, amd64xmmcomparison);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4450; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpsd(destination, labelOffsetAsInt(), amd64xmmcomparison);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpss  }<i>destination</i>, <i>label</i>, <i>amd64xmmcomparison</i>
     */
    // Template#: 524, Serial#: 4459
    public void rip_cmpss(final AMD64XMMRegister destination, final Label label, final AMD64XMMComparison amd64xmmcomparison) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmpss(destination, placeHolder, amd64xmmcomparison);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4459; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmpss(destination, labelOffsetAsInt(), amd64xmmcomparison);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrlw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 525, Serial#: 4468
    public void rip_psrlw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psrlw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4468; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psrlw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrld  }<i>destination</i>, <i>label</i>
     */
    // Template#: 526, Serial#: 4477
    public void rip_psrld(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psrld(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4477; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psrld(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrlq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 527, Serial#: 4486
    public void rip_psrlq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psrlq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4486; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psrlq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 528, Serial#: 4495
    public void rip_paddq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4495; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmullw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 529, Serial#: 4504
    public void rip_pmullw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmullw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4504; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmullw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addsubpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 530, Serial#: 4514
    public void rip_addsubpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addsubpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4514; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addsubpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrlw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 531, Serial#: 4523
    public void rip_psrlw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psrlw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4523; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psrlw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrld  }<i>destination</i>, <i>label</i>
     */
    // Template#: 532, Serial#: 4532
    public void rip_psrld(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psrld(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4532; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psrld(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrlq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 533, Serial#: 4541
    public void rip_psrlq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psrlq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4541; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psrlq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 534, Serial#: 4550
    public void rip_paddq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4550; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmullw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 535, Serial#: 4559
    public void rip_pmullw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmullw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4559; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmullw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movq  }<i>label</i>, <i>source</i>
     */
    // Template#: 536, Serial#: 4568
    public void rip_movq(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movq(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4568; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movq(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pavgb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 537, Serial#: 4580
    public void rip_pavgb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pavgb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4580; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pavgb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psraw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 538, Serial#: 4589
    public void rip_psraw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psraw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4589; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psraw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrad  }<i>destination</i>, <i>label</i>
     */
    // Template#: 539, Serial#: 4598
    public void rip_psrad(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psrad(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4598; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psrad(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pavgw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 540, Serial#: 4607
    public void rip_pavgw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pavgw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4607; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pavgw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmulhuw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 541, Serial#: 4616
    public void rip_pmulhuw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmulhuw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4616; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmulhuw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmulhw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 542, Serial#: 4625
    public void rip_pmulhw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmulhw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4625; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmulhw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movntq  }<i>label</i>, <i>source</i>
     */
    // Template#: 543, Serial#: 4634
    public void rip_movntq(final Label label, final MMXRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movntq(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4634; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movntq(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pavgb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 544, Serial#: 4642
    public void rip_pavgb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pavgb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4642; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pavgb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psraw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 545, Serial#: 4651
    public void rip_psraw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psraw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4651; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psraw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrad  }<i>destination</i>, <i>label</i>
     */
    // Template#: 546, Serial#: 4660
    public void rip_psrad(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psrad(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4660; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psrad(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pavgw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 547, Serial#: 4669
    public void rip_pavgw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pavgw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4669; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pavgw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmulhuw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 548, Serial#: 4678
    public void rip_pmulhuw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmulhuw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4678; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmulhuw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmulhw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 549, Serial#: 4687
    public void rip_pmulhw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmulhw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4687; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmulhw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvttpd2dq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 550, Serial#: 4696
    public void rip_cvttpd2dq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvttpd2dq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4696; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvttpd2dq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mvntdq  }<i>label</i>, <i>source</i>
     */
    // Template#: 551, Serial#: 4705
    public void rip_mvntdq(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mvntdq(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4705; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mvntdq(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtpd2dq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 552, Serial#: 4713
    public void rip_cvtpd2dq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtpd2dq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4713; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtpd2dq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtdq2pd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 553, Serial#: 4722
    public void rip_cvtdq2pd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtdq2pd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4722; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtdq2pd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psllw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 554, Serial#: 4731
    public void rip_psllw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psllw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4731; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psllw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pslld  }<i>destination</i>, <i>label</i>
     */
    // Template#: 555, Serial#: 4740
    public void rip_pslld(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pslld(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4740; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pslld(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psllq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 556, Serial#: 4749
    public void rip_psllq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psllq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4749; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psllq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmuludq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 557, Serial#: 4758
    public void rip_pmuludq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmuludq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4758; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmuludq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmaddwd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 558, Serial#: 4767
    public void rip_pmaddwd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmaddwd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4767; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmaddwd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psadbw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 559, Serial#: 4776
    public void rip_psadbw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psadbw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4776; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psadbw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psllw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 560, Serial#: 4786
    public void rip_psllw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psllw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4786; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psllw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pslld  }<i>destination</i>, <i>label</i>
     */
    // Template#: 561, Serial#: 4795
    public void rip_pslld(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pslld(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4795; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pslld(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psllq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 562, Serial#: 4804
    public void rip_psllq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psllq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4804; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psllq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmuludq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 563, Serial#: 4813
    public void rip_pmuludq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmuludq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4813; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmuludq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmaddwd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 564, Serial#: 4822
    public void rip_pmaddwd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmaddwd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4822; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmaddwd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psadbw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 565, Serial#: 4831
    public void rip_psadbw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psadbw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4831; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psadbw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lddqu  }<i>destination</i>, <i>label</i>
     */
    // Template#: 566, Serial#: 4841
    public void rip_lddqu(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_lddqu(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4841; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_lddqu(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code prefetch  }<i>label</i>
     */
    // Template#: 567, Serial#: 4852
    public void rip_prefetch(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_prefetch(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4852; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_prefetch(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code prefetchw  }<i>label</i>
     */
    // Template#: 568, Serial#: 4856
    public void rip_prefetchw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_prefetchw(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4856; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_prefetchw(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code prefetchnta  }<i>label</i>
     */
    // Template#: 569, Serial#: 4869
    public void rip_prefetchnta(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_prefetchnta(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4869; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_prefetchnta(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code prefetcht0  }<i>label</i>
     */
    // Template#: 570, Serial#: 4873
    public void rip_prefetcht0(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_prefetcht0(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4873; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_prefetcht0(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code prefetcht1  }<i>label</i>
     */
    // Template#: 571, Serial#: 4877
    public void rip_prefetcht1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_prefetcht1(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4877; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_prefetcht1(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code prefetcht2  }<i>label</i>
     */
    // Template#: 572, Serial#: 4881
    public void rip_prefetcht2(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_prefetcht2(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4881; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_prefetcht2(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movaps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 573, Serial#: 4901
    public void rip_movaps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movaps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4901; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movaps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movaps  }<i>label</i>, <i>source</i>
     */
    // Template#: 574, Serial#: 4910
    public void rip_movaps(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movaps(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4910; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movaps(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtpi2ps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 575, Serial#: 4918
    public void rip_cvtpi2ps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtpi2ps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4918; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtpi2ps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movntps  }<i>label</i>, <i>source</i>
     */
    // Template#: 576, Serial#: 4927
    public void rip_movntps(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movntps(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4927; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movntps(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvttps2pi  }<i>destination</i>, <i>label</i>
     */
    // Template#: 577, Serial#: 4935
    public void rip_cvttps2pi(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvttps2pi(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4935; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvttps2pi(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtps2pi  }<i>destination</i>, <i>label</i>
     */
    // Template#: 578, Serial#: 4944
    public void rip_cvtps2pi(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtps2pi(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4944; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtps2pi(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ucomiss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 579, Serial#: 4953
    public void rip_ucomiss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_ucomiss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4953; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_ucomiss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code comiss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 580, Serial#: 4962
    public void rip_comiss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_comiss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4962; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_comiss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movapd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 581, Serial#: 4971
    public void rip_movapd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movapd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4971; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movapd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movapd  }<i>label</i>, <i>source</i>
     */
    // Template#: 582, Serial#: 4980
    public void rip_movapd(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movapd(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4980; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movapd(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtpi2pd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 583, Serial#: 4988
    public void rip_cvtpi2pd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtpi2pd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4988; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtpi2pd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movntpd  }<i>label</i>, <i>source</i>
     */
    // Template#: 584, Serial#: 4997
    public void rip_movntpd(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movntpd(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 4997; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movntpd(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvttpd2pi  }<i>destination</i>, <i>label</i>
     */
    // Template#: 585, Serial#: 5005
    public void rip_cvttpd2pi(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvttpd2pi(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5005; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvttpd2pi(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtpd2pi  }<i>destination</i>, <i>label</i>
     */
    // Template#: 586, Serial#: 5014
    public void rip_cvtpd2pi(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtpd2pi(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5014; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtpd2pi(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ucomisd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 587, Serial#: 5023
    public void rip_ucomisd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_ucomisd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5023; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_ucomisd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code comisd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 588, Serial#: 5032
    public void rip_comisd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_comisd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5032; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_comisd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtsi2sdl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 589, Serial#: 5041
    public void rip_cvtsi2sdl(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtsi2sdl(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5041; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtsi2sdl(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtsi2sdq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 590, Serial#: 5050
    public void rip_cvtsi2sdq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtsi2sdq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5050; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtsi2sdq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvttsd2si  }<i>destination</i>, <i>label</i>
     */
    // Template#: 591, Serial#: 5059
    public void rip_cvttsd2si(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvttsd2si(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5059; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvttsd2si(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvttsd2si  }<i>destination</i>, <i>label</i>
     */
    // Template#: 592, Serial#: 5068
    public void rip_cvttsd2si(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvttsd2si(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5068; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvttsd2si(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtsd2si  }<i>destination</i>, <i>label</i>
     */
    // Template#: 593, Serial#: 5077
    public void rip_cvtsd2si(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtsd2si(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5077; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtsd2si(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtsd2si  }<i>destination</i>, <i>label</i>
     */
    // Template#: 594, Serial#: 5086
    public void rip_cvtsd2si(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtsd2si(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5086; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtsd2si(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtsi2ssl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 595, Serial#: 5095
    public void rip_cvtsi2ssl(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtsi2ssl(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5095; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtsi2ssl(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtsi2ssq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 596, Serial#: 5104
    public void rip_cvtsi2ssq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtsi2ssq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5104; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtsi2ssq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvttss2si  }<i>destination</i>, <i>label</i>
     */
    // Template#: 597, Serial#: 5113
    public void rip_cvttss2si(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvttss2si(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5113; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvttss2si(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvttss2si  }<i>destination</i>, <i>label</i>
     */
    // Template#: 598, Serial#: 5122
    public void rip_cvttss2si(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvttss2si(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5122; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvttss2si(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtss2si  }<i>destination</i>, <i>label</i>
     */
    // Template#: 599, Serial#: 5131
    public void rip_cvtss2si(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtss2si(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5131; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtss2si(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtss2si  }<i>destination</i>, <i>label</i>
     */
    // Template#: 600, Serial#: 5140
    public void rip_cvtss2si(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtss2si(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5140; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtss2si(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovs  }<i>destination</i>, <i>label</i>
     */
    // Template#: 601, Serial#: 5149
    public void rip_cmovs(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovs(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5149; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovs(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovs  }<i>destination</i>, <i>label</i>
     */
    // Template#: 602, Serial#: 5158
    public void rip_cmovs(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovs(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5158; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovs(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovs  }<i>destination</i>, <i>label</i>
     */
    // Template#: 603, Serial#: 5167
    public void rip_cmovs(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovs(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5167; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovs(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovns  }<i>destination</i>, <i>label</i>
     */
    // Template#: 604, Serial#: 5176
    public void rip_cmovns(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovns(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5176; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovns(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovns  }<i>destination</i>, <i>label</i>
     */
    // Template#: 605, Serial#: 5185
    public void rip_cmovns(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovns(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5185; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovns(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovns  }<i>destination</i>, <i>label</i>
     */
    // Template#: 606, Serial#: 5194
    public void rip_cmovns(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovns(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5194; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovns(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 607, Serial#: 5203
    public void rip_cmovp(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovp(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5203; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovp(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 608, Serial#: 5212
    public void rip_cmovp(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovp(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5212; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovp(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 609, Serial#: 5221
    public void rip_cmovp(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovp(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5221; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovp(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 610, Serial#: 5230
    public void rip_cmovnp(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovnp(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5230; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovnp(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 611, Serial#: 5239
    public void rip_cmovnp(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovnp(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5239; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovnp(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 612, Serial#: 5248
    public void rip_cmovnp(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovnp(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5248; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovnp(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 613, Serial#: 5257
    public void rip_cmovl(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovl(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5257; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovl(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 614, Serial#: 5266
    public void rip_cmovl(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovl(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5266; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovl(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 615, Serial#: 5275
    public void rip_cmovl(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovl(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5275; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovl(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovge  }<i>destination</i>, <i>label</i>
     */
    // Template#: 616, Serial#: 5284
    public void rip_cmovge(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovge(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5284; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovge(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovge  }<i>destination</i>, <i>label</i>
     */
    // Template#: 617, Serial#: 5293
    public void rip_cmovge(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovge(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5293; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovge(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovge  }<i>destination</i>, <i>label</i>
     */
    // Template#: 618, Serial#: 5302
    public void rip_cmovge(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovge(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5302; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovge(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovle  }<i>destination</i>, <i>label</i>
     */
    // Template#: 619, Serial#: 5311
    public void rip_cmovle(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovle(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5311; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovle(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovle  }<i>destination</i>, <i>label</i>
     */
    // Template#: 620, Serial#: 5320
    public void rip_cmovle(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovle(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5320; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovle(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovle  }<i>destination</i>, <i>label</i>
     */
    // Template#: 621, Serial#: 5329
    public void rip_cmovle(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovle(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5329; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovle(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovg  }<i>destination</i>, <i>label</i>
     */
    // Template#: 622, Serial#: 5338
    public void rip_cmovg(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovg(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5338; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovg(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovg  }<i>destination</i>, <i>label</i>
     */
    // Template#: 623, Serial#: 5347
    public void rip_cmovg(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovg(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5347; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovg(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovg  }<i>destination</i>, <i>label</i>
     */
    // Template#: 624, Serial#: 5356
    public void rip_cmovg(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cmovg(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5356; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cmovg(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 625, Serial#: 5365
    public void rip_addps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5365; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 626, Serial#: 5374
    public void rip_mulps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mulps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5374; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mulps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtps2pd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 627, Serial#: 5383
    public void rip_cvtps2pd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtps2pd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5383; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtps2pd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtdq2ps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 628, Serial#: 5392
    public void rip_cvtdq2ps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtdq2ps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5392; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtdq2ps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 629, Serial#: 5401
    public void rip_subps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5401; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code minps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 630, Serial#: 5410
    public void rip_minps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_minps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5410; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_minps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 631, Serial#: 5419
    public void rip_divps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_divps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5419; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_divps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code maxps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 632, Serial#: 5428
    public void rip_maxps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_maxps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5428; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_maxps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 633, Serial#: 5437
    public void rip_addpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5437; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 634, Serial#: 5446
    public void rip_mulpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mulpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5446; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mulpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtpd2ps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 635, Serial#: 5455
    public void rip_cvtpd2ps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtpd2ps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5455; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtpd2ps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtps2dq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 636, Serial#: 5464
    public void rip_cvtps2dq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtps2dq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5464; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtps2dq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 637, Serial#: 5473
    public void rip_subpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5473; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code minpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 638, Serial#: 5482
    public void rip_minpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_minpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5482; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_minpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 639, Serial#: 5491
    public void rip_divpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_divpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5491; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_divpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code maxpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 640, Serial#: 5500
    public void rip_maxpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_maxpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5500; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_maxpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addsd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 641, Serial#: 5509
    public void rip_addsd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addsd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5509; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addsd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulsd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 642, Serial#: 5518
    public void rip_mulsd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mulsd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5518; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mulsd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtsd2ss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 643, Serial#: 5527
    public void rip_cvtsd2ss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtsd2ss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5527; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtsd2ss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subsd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 644, Serial#: 5536
    public void rip_subsd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subsd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5536; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subsd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code minsd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 645, Serial#: 5545
    public void rip_minsd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_minsd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5545; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_minsd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divsd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 646, Serial#: 5554
    public void rip_divsd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_divsd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5554; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_divsd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code maxsd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 647, Serial#: 5563
    public void rip_maxsd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_maxsd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5563; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_maxsd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 648, Serial#: 5572
    public void rip_addss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_addss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5572; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_addss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 649, Serial#: 5581
    public void rip_mulss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_mulss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5581; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_mulss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvtss2sd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 650, Serial#: 5590
    public void rip_cvtss2sd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvtss2sd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5590; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvtss2sd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cvttps2dq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 651, Serial#: 5599
    public void rip_cvttps2dq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_cvttps2dq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5599; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_cvttps2dq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 652, Serial#: 5608
    public void rip_subss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_subss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5608; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_subss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code minss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 653, Serial#: 5617
    public void rip_minss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_minss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5617; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_minss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 654, Serial#: 5626
    public void rip_divss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_divss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5626; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_divss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code maxss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 655, Serial#: 5635
    public void rip_maxss(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_maxss(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5635; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_maxss(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhbw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 656, Serial#: 5644
    public void rip_punpckhbw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpckhbw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5644; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpckhbw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhwd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 657, Serial#: 5653
    public void rip_punpckhwd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpckhwd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5653; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpckhwd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhdq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 658, Serial#: 5662
    public void rip_punpckhdq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpckhdq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5662; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpckhdq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packssdw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 659, Serial#: 5671
    public void rip_packssdw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_packssdw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5671; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_packssdw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 660, Serial#: 5680
    public void rip_movdl(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdl(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5680; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdl(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 661, Serial#: 5689
    public void rip_movdq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5689; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 662, Serial#: 5698
    public void rip_movq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5698; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhbw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 663, Serial#: 5707
    public void rip_punpckhbw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpckhbw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5707; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpckhbw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhwd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 664, Serial#: 5716
    public void rip_punpckhwd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpckhwd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5716; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpckhwd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhdq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 665, Serial#: 5725
    public void rip_punpckhdq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpckhdq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5725; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpckhdq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packssdw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 666, Serial#: 5734
    public void rip_packssdw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_packssdw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5734; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_packssdw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpcklqdq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 667, Serial#: 5743
    public void rip_punpcklqdq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpcklqdq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5743; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpcklqdq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhqdq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 668, Serial#: 5752
    public void rip_punpckhqdq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_punpckhqdq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5752; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_punpckhqdq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 669, Serial#: 5761
    public void rip_movdl(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdl(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5761; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdl(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 670, Serial#: 5770
    public void rip_movdq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5770; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdqa  }<i>destination</i>, <i>label</i>
     */
    // Template#: 671, Serial#: 5779
    public void rip_movdqa(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdqa(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5779; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdqa(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdqu  }<i>destination</i>, <i>label</i>
     */
    // Template#: 672, Serial#: 5788
    public void rip_movdqu(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdqu(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5788; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdqu(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdl  }<i>label</i>, <i>source</i>
     */
    // Template#: 673, Serial#: 5797
    public void rip_movdl(final Label label, final MMXRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdl(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5797; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdl(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdq  }<i>label</i>, <i>source</i>
     */
    // Template#: 674, Serial#: 5806
    public void rip_movdq(final Label label, final MMXRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdq(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5806; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdq(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movq  }<i>label</i>, <i>source</i>
     */
    // Template#: 675, Serial#: 5815
    public void rip_movq(final Label label, final MMXRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movq(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5815; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movq(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code haddpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 676, Serial#: 5823
    public void rip_haddpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_haddpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5823; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_haddpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code hsubpd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 677, Serial#: 5832
    public void rip_hsubpd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_hsubpd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5832; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_hsubpd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdl  }<i>label</i>, <i>source</i>
     */
    // Template#: 678, Serial#: 5841
    public void rip_movdl(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdl(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5841; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdl(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdq  }<i>label</i>, <i>source</i>
     */
    // Template#: 679, Serial#: 5850
    public void rip_movdq(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdq(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5850; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdq(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdqa  }<i>label</i>, <i>source</i>
     */
    // Template#: 680, Serial#: 5859
    public void rip_movdqa(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdqa(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5859; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdqa(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code haddps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 681, Serial#: 5867
    public void rip_haddps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_haddps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5867; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_haddps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code hsubps  }<i>destination</i>, <i>label</i>
     */
    // Template#: 682, Serial#: 5876
    public void rip_hsubps(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_hsubps(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5876; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_hsubps(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 683, Serial#: 5885
    public void rip_movq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5885; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movdqu  }<i>label</i>, <i>source</i>
     */
    // Template#: 684, Serial#: 5893
    public void rip_movdqu(final Label label, final AMD64XMMRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movdqu(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5893; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movdqu(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code js  }<i>label</i>
     */
    // Template#: 685, Serial#: 5898
    /**
     * Pseudo-external assembler syntax: {@code jns  }<i>label</i>
     */
    // Template#: 686, Serial#: 5899
    /**
     * Pseudo-external assembler syntax: {@code jp  }<i>label</i>
     */
    // Template#: 687, Serial#: 5900
    /**
     * Pseudo-external assembler syntax: {@code jnp  }<i>label</i>
     */
    // Template#: 688, Serial#: 5901
    /**
     * Pseudo-external assembler syntax: {@code jl  }<i>label</i>
     */
    // Template#: 689, Serial#: 5902
    /**
     * Pseudo-external assembler syntax: {@code jnl  }<i>label</i>
     */
    // Template#: 690, Serial#: 5903
    /**
     * Pseudo-external assembler syntax: {@code jle  }<i>label</i>
     */
    // Template#: 691, Serial#: 5904
    /**
     * Pseudo-external assembler syntax: {@code jnle  }<i>label</i>
     */
    // Template#: 692, Serial#: 5905
    /**
     * Pseudo-external assembler syntax: {@code sets  }<i>label</i>
     */
    // Template#: 693, Serial#: 5909
    public void rip_sets(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_sets(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5909; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_sets(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setns  }<i>label</i>
     */
    // Template#: 694, Serial#: 5918
    public void rip_setns(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setns(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5918; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setns(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setp  }<i>label</i>
     */
    // Template#: 695, Serial#: 5927
    public void rip_setp(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setp(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5927; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setp(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnp  }<i>label</i>
     */
    // Template#: 696, Serial#: 5936
    public void rip_setnp(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setnp(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5936; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setnp(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setl  }<i>label</i>
     */
    // Template#: 697, Serial#: 5945
    public void rip_setl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5945; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnl  }<i>label</i>
     */
    // Template#: 698, Serial#: 5954
    public void rip_setnl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setnl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5954; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setnl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setle  }<i>label</i>
     */
    // Template#: 699, Serial#: 5963
    public void rip_setle(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setle(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5963; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setle(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnle  }<i>label</i>
     */
    // Template#: 700, Serial#: 5972
    public void rip_setnle(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_setnle(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5972; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_setnle(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bts  }<i>label</i>, <i>source</i>
     */
    // Template#: 701, Serial#: 5984
    public void rip_bts(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bts(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5984; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bts(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bts  }<i>label</i>, <i>source</i>
     */
    // Template#: 702, Serial#: 5993
    public void rip_bts(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bts(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 5993; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bts(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bts  }<i>label</i>, <i>source</i>
     */
    // Template#: 703, Serial#: 6002
    public void rip_bts(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bts(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6002; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bts(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 704, Serial#: 6011
    public void rip_shrd(final Label label, final AMD64GeneralRegister32 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrd(placeHolder, source, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6011; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrd(labelOffsetAsInt(), source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 705, Serial#: 6020
    public void rip_shrd(final Label label, final AMD64GeneralRegister64 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrd(placeHolder, source, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6020; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrd(labelOffsetAsInt(), source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 706, Serial#: 6029
    public void rip_shrd(final Label label, final AMD64GeneralRegister16 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrd(placeHolder, source, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6029; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrd(labelOffsetAsInt(), source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>source</i>
     */
    // Template#: 707, Serial#: 6038
    public void rip_shrd_CL(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrd_CL(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6038; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrd_CL(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>source</i>
     */
    // Template#: 708, Serial#: 6047
    public void rip_shrd_CL(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrd_CL(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6047; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrd_CL(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>source</i>
     */
    // Template#: 709, Serial#: 6056
    public void rip_shrd_CL(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_shrd_CL(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6056; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_shrd_CL(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fxsave  }<i>label</i>
     */
    // Template#: 710, Serial#: 6065
    public void rip_fxsave(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fxsave(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6065; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fxsave(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fxrstor  }<i>label</i>
     */
    // Template#: 711, Serial#: 6069
    public void rip_fxrstor(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_fxrstor(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6069; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_fxrstor(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ldmxcsr  }<i>label</i>
     */
    // Template#: 712, Serial#: 6073
    public void rip_ldmxcsr(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_ldmxcsr(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6073; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_ldmxcsr(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code stmxcsr  }<i>label</i>
     */
    // Template#: 713, Serial#: 6077
    public void rip_stmxcsr(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_stmxcsr(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6077; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_stmxcsr(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code clflush  }<i>label</i>
     */
    // Template#: 714, Serial#: 6081
    public void rip_clflush(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_clflush(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6081; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_clflush(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>
     */
    // Template#: 715, Serial#: 6108
    public void rip_imul(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imul(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6108; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imul(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>
     */
    // Template#: 716, Serial#: 6117
    public void rip_imul(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imul(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6117; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imul(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>
     */
    // Template#: 717, Serial#: 6126
    public void rip_imul(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_imul(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6126; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_imul(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 718, Serial#: 6135
    public void rip_bt(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bt(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6135; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bt(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bts  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 719, Serial#: 6139
    public void rip_bts(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bts(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6139; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bts(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btr  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 720, Serial#: 6143
    public void rip_btr(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_btr(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6143; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_btr(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btc  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 721, Serial#: 6147
    public void rip_btc(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_btc(placeHolder, imm8);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6147; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_btc(labelOffsetAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btc  }<i>label</i>, <i>source</i>
     */
    // Template#: 722, Serial#: 6179
    public void rip_btc(final Label label, final AMD64GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_btc(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6179; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_btc(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btc  }<i>label</i>, <i>source</i>
     */
    // Template#: 723, Serial#: 6188
    public void rip_btc(final Label label, final AMD64GeneralRegister64 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_btc(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6188; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_btc(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btc  }<i>label</i>, <i>source</i>
     */
    // Template#: 724, Serial#: 6197
    public void rip_btc(final Label label, final AMD64GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_btc(placeHolder, source);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6197; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_btc(labelOffsetAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsf  }<i>destination</i>, <i>label</i>
     */
    // Template#: 725, Serial#: 6206
    public void rip_bsf(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bsf(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6206; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bsf(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsf  }<i>destination</i>, <i>label</i>
     */
    // Template#: 726, Serial#: 6215
    public void rip_bsf(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bsf(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6215; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bsf(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsf  }<i>destination</i>, <i>label</i>
     */
    // Template#: 727, Serial#: 6224
    public void rip_bsf(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bsf(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6224; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bsf(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsr  }<i>destination</i>, <i>label</i>
     */
    // Template#: 728, Serial#: 6233
    public void rip_bsr(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bsr(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6233; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bsr(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsr  }<i>destination</i>, <i>label</i>
     */
    // Template#: 729, Serial#: 6242
    public void rip_bsr(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bsr(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6242; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bsr(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsr  }<i>destination</i>, <i>label</i>
     */
    // Template#: 730, Serial#: 6251
    public void rip_bsr(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_bsr(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6251; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_bsr(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsx  }<i>destination</i>, <i>label</i>
     */
    // Template#: 731, Serial#: 6260
    public void rip_movsxb(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movsxb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6260; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movsxb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsx  }<i>destination</i>, <i>label</i>
     */
    // Template#: 732, Serial#: 6269
    public void rip_movsxb(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movsxb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6269; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movsxb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsx  }<i>destination</i>, <i>label</i>
     */
    // Template#: 733, Serial#: 6278
    public void rip_movsxb(final AMD64GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movsxb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6278; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movsxb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsxw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 734, Serial#: 6287
    public void rip_movsxw(final AMD64GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movsxw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6287; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movsxw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsxw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 735, Serial#: 6296
    public void rip_movsxw(final AMD64GeneralRegister64 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_movsxw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6296; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_movsxw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubusb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 736, Serial#: 6307
    public void rip_psubusb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubusb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6307; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubusb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubusw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 737, Serial#: 6316
    public void rip_psubusw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubusw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6316; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubusw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pminub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 738, Serial#: 6325
    public void rip_pminub(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pminub(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6325; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pminub(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pand  }<i>destination</i>, <i>label</i>
     */
    // Template#: 739, Serial#: 6334
    public void rip_pand(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pand(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6334; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pand(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddusb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 740, Serial#: 6343
    public void rip_paddusb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddusb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6343; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddusb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddusw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 741, Serial#: 6352
    public void rip_paddusw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddusw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6352; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddusw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmaxub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 742, Serial#: 6361
    public void rip_pmaxub(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmaxub(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6361; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmaxub(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pandn  }<i>destination</i>, <i>label</i>
     */
    // Template#: 743, Serial#: 6370
    public void rip_pandn(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pandn(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6370; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pandn(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubusb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 744, Serial#: 6379
    public void rip_psubusb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubusb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6379; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubusb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubusw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 745, Serial#: 6388
    public void rip_psubusw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubusw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6388; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubusw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pminub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 746, Serial#: 6397
    public void rip_pminub(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pminub(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6397; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pminub(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pand  }<i>destination</i>, <i>label</i>
     */
    // Template#: 747, Serial#: 6406
    public void rip_pand(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pand(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6406; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pand(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddusb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 748, Serial#: 6415
    public void rip_paddusb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddusb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6415; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddusb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddusw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 749, Serial#: 6424
    public void rip_paddusw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddusw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6424; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddusw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmaxub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 750, Serial#: 6433
    public void rip_pmaxub(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmaxub(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6433; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmaxub(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pandn  }<i>destination</i>, <i>label</i>
     */
    // Template#: 751, Serial#: 6442
    public void rip_pandn(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pandn(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6442; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pandn(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubsb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 752, Serial#: 6451
    public void rip_psubsb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubsb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6451; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubsb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubsw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 753, Serial#: 6460
    public void rip_psubsw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubsw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6460; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubsw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pminsw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 754, Serial#: 6469
    public void rip_pminsw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pminsw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6469; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pminsw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code por  }<i>destination</i>, <i>label</i>
     */
    // Template#: 755, Serial#: 6478
    public void rip_por(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_por(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6478; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_por(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddsb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 756, Serial#: 6487
    public void rip_paddsb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddsb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6487; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddsb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddsw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 757, Serial#: 6496
    public void rip_paddsw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddsw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6496; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddsw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmaxsw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 758, Serial#: 6505
    public void rip_pmaxsw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmaxsw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6505; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmaxsw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pxor  }<i>destination</i>, <i>label</i>
     */
    // Template#: 759, Serial#: 6514
    public void rip_pxor(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pxor(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6514; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pxor(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubsb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 760, Serial#: 6523
    public void rip_psubsb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubsb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6523; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubsb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubsw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 761, Serial#: 6532
    public void rip_psubsw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubsw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6532; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubsw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pminsw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 762, Serial#: 6541
    public void rip_pminsw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pminsw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6541; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pminsw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code por  }<i>destination</i>, <i>label</i>
     */
    // Template#: 763, Serial#: 6550
    public void rip_por(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_por(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6550; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_por(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddsb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 764, Serial#: 6559
    public void rip_paddsb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddsb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6559; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddsb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddsw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 765, Serial#: 6568
    public void rip_paddsw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddsw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6568; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddsw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmaxsw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 766, Serial#: 6577
    public void rip_pmaxsw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pmaxsw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6577; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pmaxsw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pxor  }<i>destination</i>, <i>label</i>
     */
    // Template#: 767, Serial#: 6586
    public void rip_pxor(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_pxor(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6586; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_pxor(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 768, Serial#: 6595
    public void rip_psubb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6595; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 769, Serial#: 6604
    public void rip_psubw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6604; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 770, Serial#: 6613
    public void rip_psubd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6613; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 771, Serial#: 6622
    public void rip_psubq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6622; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 772, Serial#: 6631
    public void rip_paddb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6631; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 773, Serial#: 6640
    public void rip_paddw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6640; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 774, Serial#: 6649
    public void rip_paddd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6649; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 775, Serial#: 6658
    public void rip_psubb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6658; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 776, Serial#: 6667
    public void rip_psubw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6667; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 777, Serial#: 6676
    public void rip_psubd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6676; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubd(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 778, Serial#: 6685
    public void rip_psubq(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_psubq(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6685; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_psubq(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 779, Serial#: 6694
    public void rip_paddb(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddb(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6694; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddb(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 780, Serial#: 6703
    public void rip_paddw(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddw(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6703; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddw(destination, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 781, Serial#: 6712
    public void rip_paddd(final AMD64XMMRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        rip_paddd(destination, placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 4) {
            @Override
            protected int templateSerial() { return 6712; }
            @Override
            protected void assemble() throws AssemblyException {
                rip_paddd(destination, labelOffsetAsInt());
            }
        };
    }

}
// END GENERATED CONTENT
