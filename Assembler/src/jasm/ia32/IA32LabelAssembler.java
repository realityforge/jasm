/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=de44d5ac-8539-4b8f-94c8-acace3ba1395*/
// START GENERATED CONTENT

package jasm.ia32;

import jasm.AssemblyException;
import jasm.Label;
import jasm.LabelAddressInstruction;
import jasm.LabelOffsetInstruction;
import jasm.x86.MMXRegister;
import jasm.x86.Scale;
import jasm.x86.SegmentRegister;

public abstract class IA32LabelAssembler extends IA32RawAssembler {

    protected IA32LabelAssembler() {
        super();
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 1, Serial#: 3
    public void m_add(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>label</i>, <i>source</i>
     */
    // Template#: 2, Serial#: 4
    public void m_add(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 4; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 3, Serial#: 12
    public void m_add(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 12; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>label</i>, <i>source</i>
     */
    // Template#: 4, Serial#: 13
    public void m_add(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 13; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 5, Serial#: 21
    public void m_add(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 21; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>label</i>, <i>source</i>
     */
    // Template#: 6, Serial#: 22
    public void m_add(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 22; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 7, Serial#: 30
    public void m_add(final IA32GeneralRegister8 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 30; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>destination</i>, <i>label</i>
     */
    // Template#: 8, Serial#: 31
    public void m_add(final IA32GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 31; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 9, Serial#: 38
    public void m_add(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 38; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>destination</i>, <i>label</i>
     */
    // Template#: 10, Serial#: 39
    public void m_add(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 39; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 11, Serial#: 46
    public void m_add(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 46; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code add  }<i>destination</i>, <i>label</i>
     */
    // Template#: 12, Serial#: 47
    public void m_add(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_add(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 47; }
            @Override
            protected void assemble() throws AssemblyException {
                m_add(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 13, Serial#: 59
    public void m_adc(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 59; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>label</i>, <i>source</i>
     */
    // Template#: 14, Serial#: 60
    public void m_adc(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 60; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 15, Serial#: 68
    public void m_adc(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 68; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>label</i>, <i>source</i>
     */
    // Template#: 16, Serial#: 69
    public void m_adc(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 69; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 17, Serial#: 77
    public void m_adc(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 77; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>label</i>, <i>source</i>
     */
    // Template#: 18, Serial#: 78
    public void m_adc(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 78; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 19, Serial#: 86
    public void m_adc(final IA32GeneralRegister8 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 86; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>destination</i>, <i>label</i>
     */
    // Template#: 20, Serial#: 87
    public void m_adc(final IA32GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 87; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 21, Serial#: 94
    public void m_adc(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 94; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>destination</i>, <i>label</i>
     */
    // Template#: 22, Serial#: 95
    public void m_adc(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 95; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 23, Serial#: 102
    public void m_adc(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 102; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adc  }<i>destination</i>, <i>label</i>
     */
    // Template#: 24, Serial#: 103
    public void m_adc(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adc(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 103; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adc(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 25, Serial#: 115
    public void m_and(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 115; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>label</i>, <i>source</i>
     */
    // Template#: 26, Serial#: 116
    public void m_and(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 116; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 27, Serial#: 124
    public void m_and(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 124; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>label</i>, <i>source</i>
     */
    // Template#: 28, Serial#: 125
    public void m_and(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 125; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 29, Serial#: 133
    public void m_and(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 133; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>label</i>, <i>source</i>
     */
    // Template#: 30, Serial#: 134
    public void m_and(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 134; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 31, Serial#: 142
    public void m_and(final IA32GeneralRegister8 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 142; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>destination</i>, <i>label</i>
     */
    // Template#: 32, Serial#: 143
    public void m_and(final IA32GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 143; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 33, Serial#: 150
    public void m_and(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 150; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>destination</i>, <i>label</i>
     */
    // Template#: 34, Serial#: 151
    public void m_and(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 151; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 35, Serial#: 158
    public void m_and(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 158; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code and  }<i>destination</i>, <i>label</i>
     */
    // Template#: 36, Serial#: 159
    public void m_and(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_and(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 159; }
            @Override
            protected void assemble() throws AssemblyException {
                m_and(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 37, Serial#: 171
    public void m_xor(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 171; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>label</i>, <i>source</i>
     */
    // Template#: 38, Serial#: 172
    public void m_xor(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 172; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 39, Serial#: 180
    public void m_xor(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 180; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>label</i>, <i>source</i>
     */
    // Template#: 40, Serial#: 181
    public void m_xor(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 181; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 41, Serial#: 189
    public void m_xor(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 189; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>label</i>, <i>source</i>
     */
    // Template#: 42, Serial#: 190
    public void m_xor(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 190; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 43, Serial#: 198
    public void m_xor(final IA32GeneralRegister8 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 198; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>destination</i>, <i>label</i>
     */
    // Template#: 44, Serial#: 199
    public void m_xor(final IA32GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 199; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 45, Serial#: 206
    public void m_xor(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 206; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>destination</i>, <i>label</i>
     */
    // Template#: 46, Serial#: 207
    public void m_xor(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 207; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 47, Serial#: 214
    public void m_xor(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 214; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xor  }<i>destination</i>, <i>label</i>
     */
    // Template#: 48, Serial#: 215
    public void m_xor(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xor(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 215; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xor(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bound  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 49, Serial#: 235
    public void m_bound(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bound(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 235; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bound(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bound  }<i>destination</i>, <i>label</i>
     */
    // Template#: 50, Serial#: 236
    public void m_bound(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bound(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 236; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bound(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bound  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 51, Serial#: 243
    public void m_bound(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bound(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 243; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bound(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bound  }<i>destination</i>, <i>label</i>
     */
    // Template#: 52, Serial#: 244
    public void m_bound(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bound(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 244; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bound(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code arpl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 53, Serial#: 251
    public void m_arpl(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_arpl(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 251; }
            @Override
            protected void assemble() throws AssemblyException {
                m_arpl(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code arpl  }<i>label</i>, <i>source</i>
     */
    // Template#: 54, Serial#: 252
    public void m_arpl(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_arpl(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 252; }
            @Override
            protected void assemble() throws AssemblyException {
                m_arpl(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jo  }<i>label</i>
     */
    // Template#: 55, Serial#: 262
    public void jo(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jo(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 262; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jo(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jo(labelOffsetAsShort());
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
    // Template#: 56, Serial#: 263
    public void jno(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jno(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 263; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jno(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jno(labelOffsetAsShort());
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
    // Template#: 57, Serial#: 264
    public void jb(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jb(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 264; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jb(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jb(labelOffsetAsShort());
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
    // Template#: 58, Serial#: 265
    public void jnb(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnb(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 265; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnb(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jnb(labelOffsetAsShort());
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
    // Template#: 59, Serial#: 266
    public void jz(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jz(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 266; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jz(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jz(labelOffsetAsShort());
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
    // Template#: 60, Serial#: 267
    public void jnz(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnz(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 267; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnz(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jnz(labelOffsetAsShort());
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
    // Template#: 61, Serial#: 268
    public void jbe(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jbe(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 268; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jbe(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jbe(labelOffsetAsShort());
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
    // Template#: 62, Serial#: 269
    public void jnbe(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnbe(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 269; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnbe(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jnbe(labelOffsetAsShort());
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
     * Pseudo-external assembler syntax: {@code addb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 63, Serial#: 272
    public void m_addb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_addb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 272; }
            @Override
            protected void assemble() throws AssemblyException {
                m_addb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 64, Serial#: 273
    public void m_addb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_addb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 273; }
            @Override
            protected void assemble() throws AssemblyException {
                m_addb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 65, Serial#: 276
    public void m_orb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_orb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 276; }
            @Override
            protected void assemble() throws AssemblyException {
                m_orb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 66, Serial#: 277
    public void m_orb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_orb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 277; }
            @Override
            protected void assemble() throws AssemblyException {
                m_orb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 67, Serial#: 280
    public void m_adcb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adcb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 280; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adcb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 68, Serial#: 281
    public void m_adcb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adcb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 281; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adcb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 69, Serial#: 284
    public void m_sbbb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbbb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 284; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbbb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 70, Serial#: 285
    public void m_sbbb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbbb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 285; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbbb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 71, Serial#: 288
    public void m_andb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_andb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 288; }
            @Override
            protected void assemble() throws AssemblyException {
                m_andb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 72, Serial#: 289
    public void m_andb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_andb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 289; }
            @Override
            protected void assemble() throws AssemblyException {
                m_andb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 73, Serial#: 292
    public void m_subb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_subb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 292; }
            @Override
            protected void assemble() throws AssemblyException {
                m_subb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 74, Serial#: 293
    public void m_subb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_subb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 293; }
            @Override
            protected void assemble() throws AssemblyException {
                m_subb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 75, Serial#: 296
    public void m_xorb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xorb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 296; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xorb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 76, Serial#: 297
    public void m_xorb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xorb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 297; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xorb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 77, Serial#: 300
    public void m_cmpb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 300; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 78, Serial#: 301
    public void m_cmpb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 301; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 79, Serial#: 344
    public void m_addl(final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_addl(placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 344; }
            @Override
            protected void assemble() throws AssemblyException {
                m_addl(labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 80, Serial#: 345
    public void m_addl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_addl(placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 345; }
            @Override
            protected void assemble() throws AssemblyException {
                m_addl(labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 81, Serial#: 348
    public void m_orl(final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_orl(placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 348; }
            @Override
            protected void assemble() throws AssemblyException {
                m_orl(labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 82, Serial#: 349
    public void m_orl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_orl(placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 349; }
            @Override
            protected void assemble() throws AssemblyException {
                m_orl(labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 83, Serial#: 352
    public void m_adcl(final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adcl(placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 352; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adcl(labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 84, Serial#: 353
    public void m_adcl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adcl(placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 353; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adcl(labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 85, Serial#: 356
    public void m_sbbl(final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbbl(placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 356; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbbl(labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 86, Serial#: 357
    public void m_sbbl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbbl(placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 357; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbbl(labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 87, Serial#: 360
    public void m_andl(final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_andl(placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 360; }
            @Override
            protected void assemble() throws AssemblyException {
                m_andl(labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 88, Serial#: 361
    public void m_andl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_andl(placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 361; }
            @Override
            protected void assemble() throws AssemblyException {
                m_andl(labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 89, Serial#: 364
    public void m_subl(final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_subl(placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 364; }
            @Override
            protected void assemble() throws AssemblyException {
                m_subl(labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 90, Serial#: 365
    public void m_subl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_subl(placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 365; }
            @Override
            protected void assemble() throws AssemblyException {
                m_subl(labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 91, Serial#: 368
    public void m_xorl(final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xorl(placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 368; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xorl(labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 92, Serial#: 369
    public void m_xorl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xorl(placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 369; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xorl(labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 93, Serial#: 372
    public void m_cmpl(final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpl(placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 372; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpl(labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 94, Serial#: 373
    public void m_cmpl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpl(placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 373; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpl(labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 95, Serial#: 416
    public void m_addw(final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_addw(placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 416; }
            @Override
            protected void assemble() throws AssemblyException {
                m_addw(labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 96, Serial#: 417
    public void m_addw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_addw(placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 417; }
            @Override
            protected void assemble() throws AssemblyException {
                m_addw(labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 97, Serial#: 420
    public void m_orw(final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_orw(placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 420; }
            @Override
            protected void assemble() throws AssemblyException {
                m_orw(labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 98, Serial#: 421
    public void m_orw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_orw(placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 421; }
            @Override
            protected void assemble() throws AssemblyException {
                m_orw(labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 99, Serial#: 424
    public void m_adcw(final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adcw(placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 424; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adcw(labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 100, Serial#: 425
    public void m_adcw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adcw(placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 425; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adcw(labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 101, Serial#: 428
    public void m_sbbw(final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbbw(placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 428; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbbw(labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 102, Serial#: 429
    public void m_sbbw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbbw(placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 429; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbbw(labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 103, Serial#: 432
    public void m_andw(final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_andw(placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 432; }
            @Override
            protected void assemble() throws AssemblyException {
                m_andw(labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 104, Serial#: 433
    public void m_andw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_andw(placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 433; }
            @Override
            protected void assemble() throws AssemblyException {
                m_andw(labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 105, Serial#: 436
    public void m_subw(final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_subw(placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 436; }
            @Override
            protected void assemble() throws AssemblyException {
                m_subw(labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 106, Serial#: 437
    public void m_subw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_subw(placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 437; }
            @Override
            protected void assemble() throws AssemblyException {
                m_subw(labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 107, Serial#: 440
    public void m_xorw(final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xorw(placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 440; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xorw(labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 108, Serial#: 441
    public void m_xorw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xorw(placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 441; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xorw(labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 109, Serial#: 444
    public void m_cmpw(final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpw(placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 444; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpw(labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 110, Serial#: 445
    public void m_cmpw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpw(placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 445; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpw(labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 111, Serial#: 488
    public void m_addl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_addl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 488; }
            @Override
            protected void assemble() throws AssemblyException {
                m_addl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 112, Serial#: 489
    public void m_addl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_addl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 489; }
            @Override
            protected void assemble() throws AssemblyException {
                m_addl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 113, Serial#: 492
    public void m_orl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_orl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 492; }
            @Override
            protected void assemble() throws AssemblyException {
                m_orl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 114, Serial#: 493
    public void m_orl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_orl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 493; }
            @Override
            protected void assemble() throws AssemblyException {
                m_orl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 115, Serial#: 496
    public void m_adcl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adcl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 496; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adcl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 116, Serial#: 497
    public void m_adcl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adcl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 497; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adcl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 117, Serial#: 500
    public void m_sbbl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbbl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 500; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbbl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 118, Serial#: 501
    public void m_sbbl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbbl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 501; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbbl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 119, Serial#: 504
    public void m_andl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_andl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 504; }
            @Override
            protected void assemble() throws AssemblyException {
                m_andl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 120, Serial#: 505
    public void m_andl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_andl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 505; }
            @Override
            protected void assemble() throws AssemblyException {
                m_andl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 121, Serial#: 508
    public void m_subl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_subl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 508; }
            @Override
            protected void assemble() throws AssemblyException {
                m_subl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 122, Serial#: 509
    public void m_subl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_subl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 509; }
            @Override
            protected void assemble() throws AssemblyException {
                m_subl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 123, Serial#: 512
    public void m_xorl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xorl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 512; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xorl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 124, Serial#: 513
    public void m_xorl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xorl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 513; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xorl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 125, Serial#: 516
    public void m_cmpl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 516; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 126, Serial#: 517
    public void m_cmpl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 517; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 127, Serial#: 560
    public void m_addw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_addw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 560; }
            @Override
            protected void assemble() throws AssemblyException {
                m_addw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code addw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 128, Serial#: 561
    public void m_addw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_addw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 561; }
            @Override
            protected void assemble() throws AssemblyException {
                m_addw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 129, Serial#: 564
    public void m_orw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_orw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 564; }
            @Override
            protected void assemble() throws AssemblyException {
                m_orw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code orw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 130, Serial#: 565
    public void m_orw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_orw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 565; }
            @Override
            protected void assemble() throws AssemblyException {
                m_orw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 131, Serial#: 568
    public void m_adcw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adcw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 568; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adcw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code adcw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 132, Serial#: 569
    public void m_adcw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_adcw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 569; }
            @Override
            protected void assemble() throws AssemblyException {
                m_adcw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 133, Serial#: 572
    public void m_sbbw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbbw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 572; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbbw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbbw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 134, Serial#: 573
    public void m_sbbw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbbw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 573; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbbw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 135, Serial#: 576
    public void m_andw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_andw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 576; }
            @Override
            protected void assemble() throws AssemblyException {
                m_andw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code andw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 136, Serial#: 577
    public void m_andw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_andw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 577; }
            @Override
            protected void assemble() throws AssemblyException {
                m_andw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 137, Serial#: 580
    public void m_subw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_subw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 580; }
            @Override
            protected void assemble() throws AssemblyException {
                m_subw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code subw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 138, Serial#: 581
    public void m_subw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_subw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 581; }
            @Override
            protected void assemble() throws AssemblyException {
                m_subw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 139, Serial#: 584
    public void m_xorw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xorw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 584; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xorw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xorw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 140, Serial#: 585
    public void m_xorw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xorw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 585; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xorw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 141, Serial#: 588
    public void m_cmpw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 588; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 142, Serial#: 589
    public void m_cmpw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 589; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code test  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 143, Serial#: 632
    public void m_test(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_test(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 632; }
            @Override
            protected void assemble() throws AssemblyException {
                m_test(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code test  }<i>label</i>, <i>source</i>
     */
    // Template#: 144, Serial#: 633
    public void m_test(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_test(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 633; }
            @Override
            protected void assemble() throws AssemblyException {
                m_test(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code test  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 145, Serial#: 641
    public void m_test(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_test(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 641; }
            @Override
            protected void assemble() throws AssemblyException {
                m_test(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code test  }<i>label</i>, <i>source</i>
     */
    // Template#: 146, Serial#: 642
    public void m_test(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_test(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 642; }
            @Override
            protected void assemble() throws AssemblyException {
                m_test(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code test  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 147, Serial#: 650
    public void m_test(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_test(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 650; }
            @Override
            protected void assemble() throws AssemblyException {
                m_test(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code test  }<i>label</i>, <i>source</i>
     */
    // Template#: 148, Serial#: 651
    public void m_test(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_test(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 651; }
            @Override
            protected void assemble() throws AssemblyException {
                m_test(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xchg  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 149, Serial#: 659
    public void m_xchg(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xchg(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 659; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xchg(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 150, Serial#: 660
    public void m_xchg(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xchg(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 660; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xchg(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xchg  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 151, Serial#: 668
    public void m_xchg(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xchg(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 668; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xchg(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 152, Serial#: 669
    public void m_xchg(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xchg(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 669; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xchg(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xchg  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 153, Serial#: 677
    public void m_xchg(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xchg(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 677; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xchg(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 154, Serial#: 678
    public void m_xchg(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xchg(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 678; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xchg(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 155, Serial#: 687
    public void m_mov_AL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov_AL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 687; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov_AL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 156, Serial#: 688
    public void m_mov_EAX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov_EAX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 688; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov_EAX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 157, Serial#: 689
    public void m_mov_AX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov_AX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 689; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov_AX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 158, Serial#: 690
    public void m_mov___AL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov___AL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 690; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov___AL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 159, Serial#: 691
    public void m_mov___EAX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov___EAX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 691; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov___EAX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>
     */
    // Template#: 160, Serial#: 692
    public void m_mov___AX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov___AX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 692; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov___AX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 161, Serial#: 702
    public void m_rolb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 702; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 162, Serial#: 703
    public void m_rolb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 703; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 163, Serial#: 706
    public void m_rorb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 706; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 164, Serial#: 707
    public void m_rorb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 707; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 165, Serial#: 710
    public void m_rclb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 710; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 166, Serial#: 711
    public void m_rclb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 711; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 167, Serial#: 714
    public void m_rcrb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 714; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 168, Serial#: 715
    public void m_rcrb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 715; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 169, Serial#: 718
    public void m_shlb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 718; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 170, Serial#: 719
    public void m_shlb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 719; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 171, Serial#: 722
    public void m_shrb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 722; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 172, Serial#: 723
    public void m_shrb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 723; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 173, Serial#: 726
    public void m_sarb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 726; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 174, Serial#: 727
    public void m_sarb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 727; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code roll  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 175, Serial#: 765
    public void m_roll(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_roll(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 765; }
            @Override
            protected void assemble() throws AssemblyException {
                m_roll(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code roll  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 176, Serial#: 766
    public void m_roll(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_roll(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 766; }
            @Override
            protected void assemble() throws AssemblyException {
                m_roll(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 177, Serial#: 769
    public void m_rorl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 769; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 178, Serial#: 770
    public void m_rorl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 770; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcll  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 179, Serial#: 773
    public void m_rcll(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcll(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 773; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcll(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcll  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 180, Serial#: 774
    public void m_rcll(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcll(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 774; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcll(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 181, Serial#: 777
    public void m_rcrl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 777; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 182, Serial#: 778
    public void m_rcrl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 778; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shll  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 183, Serial#: 781
    public void m_shll(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shll(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 781; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shll(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shll  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 184, Serial#: 782
    public void m_shll(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shll(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 782; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shll(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 185, Serial#: 785
    public void m_shrl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 785; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 186, Serial#: 786
    public void m_shrl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 786; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 187, Serial#: 789
    public void m_sarl(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarl(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 789; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarl(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarl  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 188, Serial#: 790
    public void m_sarl(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarl(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 790; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarl(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 189, Serial#: 828
    public void m_rolw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 828; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 190, Serial#: 829
    public void m_rolw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 829; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 191, Serial#: 832
    public void m_rorw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 832; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 192, Serial#: 833
    public void m_rorw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 833; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 193, Serial#: 836
    public void m_rclw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 836; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 194, Serial#: 837
    public void m_rclw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 837; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 195, Serial#: 840
    public void m_rcrw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 840; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 196, Serial#: 841
    public void m_rcrw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 841; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 197, Serial#: 844
    public void m_shlw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 844; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 198, Serial#: 845
    public void m_shlw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 845; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 199, Serial#: 848
    public void m_shrw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 848; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 200, Serial#: 849
    public void m_shrw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 849; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 201, Serial#: 852
    public void m_sarw(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarw(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 852; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarw(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarw  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 202, Serial#: 853
    public void m_sarw(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarw(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 853; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarw(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code les  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 203, Serial#: 893
    public void m_les(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_les(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 893; }
            @Override
            protected void assemble() throws AssemblyException {
                m_les(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code les  }<i>destination</i>, <i>label</i>
     */
    // Template#: 204, Serial#: 894
    public void m_les(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_les(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 894; }
            @Override
            protected void assemble() throws AssemblyException {
                m_les(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code les  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 205, Serial#: 901
    public void m_les(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_les(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 901; }
            @Override
            protected void assemble() throws AssemblyException {
                m_les(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code les  }<i>destination</i>, <i>label</i>
     */
    // Template#: 206, Serial#: 902
    public void m_les(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_les(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 902; }
            @Override
            protected void assemble() throws AssemblyException {
                m_les(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lds  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 207, Serial#: 909
    public void m_lds(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lds(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 909; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lds(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lds  }<i>destination</i>, <i>label</i>
     */
    // Template#: 208, Serial#: 910
    public void m_lds(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lds(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 910; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lds(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lds  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 209, Serial#: 917
    public void m_lds(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lds(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 917; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lds(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lds  }<i>destination</i>, <i>label</i>
     */
    // Template#: 210, Serial#: 918
    public void m_lds(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lds(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 918; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lds(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 211, Serial#: 925
    public void m_movb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 925; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 212, Serial#: 926
    public void m_movb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 926; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 213, Serial#: 934
    public void m_movl(final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movl(placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 934; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movl(labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 214, Serial#: 935
    public void m_movl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movl(placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 935; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movl(labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 215, Serial#: 943
    public void m_movw(final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movw(placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 943; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movw(labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 216, Serial#: 944
    public void m_movw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movw(placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 944; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movw(labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 217, Serial#: 952
    public void m_rolb___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolb___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 952; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolb___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolb  }<i>label</i>
     */
    // Template#: 218, Serial#: 953
    public void m_rolb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolb___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 953; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolb___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 219, Serial#: 956
    public void m_rorb___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorb___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 956; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorb___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorb  }<i>label</i>
     */
    // Template#: 220, Serial#: 957
    public void m_rorb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorb___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 957; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorb___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 221, Serial#: 960
    public void m_rclb___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclb___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 960; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclb___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclb  }<i>label</i>
     */
    // Template#: 222, Serial#: 961
    public void m_rclb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclb___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 961; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclb___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 223, Serial#: 964
    public void m_rcrb___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrb___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 964; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrb___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrb  }<i>label</i>
     */
    // Template#: 224, Serial#: 965
    public void m_rcrb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrb___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 965; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrb___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 225, Serial#: 968
    public void m_shlb___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlb___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 968; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlb___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlb  }<i>label</i>
     */
    // Template#: 226, Serial#: 969
    public void m_shlb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlb___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 969; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlb___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 227, Serial#: 972
    public void m_shrb___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrb___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 972; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrb___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrb  }<i>label</i>
     */
    // Template#: 228, Serial#: 973
    public void m_shrb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrb___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 973; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrb___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 229, Serial#: 976
    public void m_sarb___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarb___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 976; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarb___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarb  }<i>label</i>
     */
    // Template#: 230, Serial#: 977
    public void m_sarb___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarb___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 977; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarb___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code roll  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 231, Serial#: 1015
    public void m_roll___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_roll___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1015; }
            @Override
            protected void assemble() throws AssemblyException {
                m_roll___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code roll  }<i>label</i>
     */
    // Template#: 232, Serial#: 1016
    public void m_roll___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_roll___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1016; }
            @Override
            protected void assemble() throws AssemblyException {
                m_roll___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 233, Serial#: 1019
    public void m_rorl___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorl___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1019; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorl___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorl  }<i>label</i>
     */
    // Template#: 234, Serial#: 1020
    public void m_rorl___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorl___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1020; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorl___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcll  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 235, Serial#: 1023
    public void m_rcll___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcll___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1023; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcll___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcll  }<i>label</i>
     */
    // Template#: 236, Serial#: 1024
    public void m_rcll___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcll___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1024; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcll___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 237, Serial#: 1027
    public void m_rcrl___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrl___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1027; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrl___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrl  }<i>label</i>
     */
    // Template#: 238, Serial#: 1028
    public void m_rcrl___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrl___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1028; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrl___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shll  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 239, Serial#: 1031
    public void m_shll___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shll___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1031; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shll___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shll  }<i>label</i>
     */
    // Template#: 240, Serial#: 1032
    public void m_shll___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shll___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1032; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shll___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 241, Serial#: 1035
    public void m_shrl___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrl___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1035; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrl___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrl  }<i>label</i>
     */
    // Template#: 242, Serial#: 1036
    public void m_shrl___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrl___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1036; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrl___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 243, Serial#: 1039
    public void m_sarl___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarl___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1039; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarl___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarl  }<i>label</i>
     */
    // Template#: 244, Serial#: 1040
    public void m_sarl___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarl___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1040; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarl___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 245, Serial#: 1078
    public void m_rolw___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolw___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1078; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolw___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolw  }<i>label</i>
     */
    // Template#: 246, Serial#: 1079
    public void m_rolw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolw___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1079; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolw___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 247, Serial#: 1082
    public void m_rorw___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorw___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1082; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorw___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorw  }<i>label</i>
     */
    // Template#: 248, Serial#: 1083
    public void m_rorw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorw___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1083; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorw___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 249, Serial#: 1086
    public void m_rclw___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclw___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1086; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclw___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclw  }<i>label</i>
     */
    // Template#: 250, Serial#: 1087
    public void m_rclw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclw___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1087; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclw___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 251, Serial#: 1090
    public void m_rcrw___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrw___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1090; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrw___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrw  }<i>label</i>
     */
    // Template#: 252, Serial#: 1091
    public void m_rcrw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrw___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1091; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrw___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 253, Serial#: 1094
    public void m_shlw___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlw___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1094; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlw___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlw  }<i>label</i>
     */
    // Template#: 254, Serial#: 1095
    public void m_shlw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlw___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1095; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlw___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 255, Serial#: 1098
    public void m_shrw___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrw___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1098; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrw___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrw  }<i>label</i>
     */
    // Template#: 256, Serial#: 1099
    public void m_shrw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrw___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1099; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrw___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 257, Serial#: 1102
    public void m_sarw___1(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarw___1(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1102; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarw___1(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarw  }<i>label</i>
     */
    // Template#: 258, Serial#: 1103
    public void m_sarw___1(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarw___1(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1103; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarw___1(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 259, Serial#: 1141
    public void m_rolb___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolb___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1141; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolb___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolb  }<i>label</i>
     */
    // Template#: 260, Serial#: 1142
    public void m_rolb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolb___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1142; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolb___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 261, Serial#: 1145
    public void m_rorb___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorb___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1145; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorb___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorb  }<i>label</i>
     */
    // Template#: 262, Serial#: 1146
    public void m_rorb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorb___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1146; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorb___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 263, Serial#: 1149
    public void m_rclb___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclb___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1149; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclb___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclb  }<i>label</i>
     */
    // Template#: 264, Serial#: 1150
    public void m_rclb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclb___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1150; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclb___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 265, Serial#: 1153
    public void m_rcrb___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrb___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1153; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrb___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrb  }<i>label</i>
     */
    // Template#: 266, Serial#: 1154
    public void m_rcrb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrb___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1154; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrb___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 267, Serial#: 1157
    public void m_shlb___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlb___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1157; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlb___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlb  }<i>label</i>
     */
    // Template#: 268, Serial#: 1158
    public void m_shlb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlb___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1158; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlb___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 269, Serial#: 1161
    public void m_shrb___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrb___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1161; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrb___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrb  }<i>label</i>
     */
    // Template#: 270, Serial#: 1162
    public void m_shrb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrb___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1162; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrb___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 271, Serial#: 1165
    public void m_sarb___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarb___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1165; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarb___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarb  }<i>label</i>
     */
    // Template#: 272, Serial#: 1166
    public void m_sarb___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarb___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1166; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarb___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code roll  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 273, Serial#: 1204
    public void m_roll___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_roll___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1204; }
            @Override
            protected void assemble() throws AssemblyException {
                m_roll___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code roll  }<i>label</i>
     */
    // Template#: 274, Serial#: 1205
    public void m_roll___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_roll___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1205; }
            @Override
            protected void assemble() throws AssemblyException {
                m_roll___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 275, Serial#: 1208
    public void m_rorl___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorl___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1208; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorl___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorl  }<i>label</i>
     */
    // Template#: 276, Serial#: 1209
    public void m_rorl___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorl___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1209; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorl___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcll  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 277, Serial#: 1212
    public void m_rcll___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcll___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1212; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcll___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcll  }<i>label</i>
     */
    // Template#: 278, Serial#: 1213
    public void m_rcll___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcll___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1213; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcll___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 279, Serial#: 1216
    public void m_rcrl___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrl___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1216; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrl___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrl  }<i>label</i>
     */
    // Template#: 280, Serial#: 1217
    public void m_rcrl___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrl___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1217; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrl___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shll  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 281, Serial#: 1220
    public void m_shll___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shll___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1220; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shll___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shll  }<i>label</i>
     */
    // Template#: 282, Serial#: 1221
    public void m_shll___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shll___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1221; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shll___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 283, Serial#: 1224
    public void m_shrl___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrl___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1224; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrl___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrl  }<i>label</i>
     */
    // Template#: 284, Serial#: 1225
    public void m_shrl___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrl___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1225; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrl___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 285, Serial#: 1228
    public void m_sarl___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarl___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1228; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarl___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarl  }<i>label</i>
     */
    // Template#: 286, Serial#: 1229
    public void m_sarl___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarl___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1229; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarl___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 287, Serial#: 1267
    public void m_rolw___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolw___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1267; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolw___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rolw  }<i>label</i>
     */
    // Template#: 288, Serial#: 1268
    public void m_rolw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rolw___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1268; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rolw___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 289, Serial#: 1271
    public void m_rorw___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorw___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1271; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorw___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rorw  }<i>label</i>
     */
    // Template#: 290, Serial#: 1272
    public void m_rorw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rorw___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1272; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rorw___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 291, Serial#: 1275
    public void m_rclw___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclw___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1275; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclw___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rclw  }<i>label</i>
     */
    // Template#: 292, Serial#: 1276
    public void m_rclw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rclw___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1276; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rclw___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 293, Serial#: 1279
    public void m_rcrw___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrw___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1279; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrw___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code rcrw  }<i>label</i>
     */
    // Template#: 294, Serial#: 1280
    public void m_rcrw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_rcrw___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1280; }
            @Override
            protected void assemble() throws AssemblyException {
                m_rcrw___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 295, Serial#: 1283
    public void m_shlw___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlw___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1283; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlw___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shlw  }<i>label</i>
     */
    // Template#: 296, Serial#: 1284
    public void m_shlw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shlw___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1284; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shlw___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 297, Serial#: 1287
    public void m_shrw___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrw___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1287; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrw___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrw  }<i>label</i>
     */
    // Template#: 298, Serial#: 1288
    public void m_shrw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrw___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1288; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrw___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 299, Serial#: 1291
    public void m_sarw___CL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarw___CL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1291; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarw___CL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sarw  }<i>label</i>
     */
    // Template#: 300, Serial#: 1292
    public void m_sarw___CL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sarw___CL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1292; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sarw___CL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code loopne  }<i>label</i>
     */
    // Template#: 301, Serial#: 1332
    public void loopne(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        loopne(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 1) {
            @Override
            protected int templateSerial() { return 1332; }
            @Override
            protected void assemble() throws AssemblyException {
                loopne(labelOffsetAsByte());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code loope  }<i>label</i>
     */
    // Template#: 302, Serial#: 1333
    public void loope(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        loope(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 1) {
            @Override
            protected int templateSerial() { return 1333; }
            @Override
            protected void assemble() throws AssemblyException {
                loope(labelOffsetAsByte());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code loop  }<i>label</i>
     */
    // Template#: 303, Serial#: 1334
    public void loop(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        loop(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 1) {
            @Override
            protected int templateSerial() { return 1334; }
            @Override
            protected void assemble() throws AssemblyException {
                loop(labelOffsetAsByte());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jecxz  }<i>label</i>
     */
    // Template#: 304, Serial#: 1335
    public void jecxz(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jecxz(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 1) {
            @Override
            protected int templateSerial() { return 1335; }
            @Override
            protected void assemble() throws AssemblyException {
                jecxz(labelOffsetAsByte());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code testb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 305, Serial#: 1349
    public void m_testb(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_testb(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1349; }
            @Override
            protected void assemble() throws AssemblyException {
                m_testb(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code testb  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 306, Serial#: 1350
    public void m_testb(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_testb(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1350; }
            @Override
            protected void assemble() throws AssemblyException {
                m_testb(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code notb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 307, Serial#: 1353
    public void m_notb(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_notb(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1353; }
            @Override
            protected void assemble() throws AssemblyException {
                m_notb(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code notb  }<i>label</i>
     */
    // Template#: 308, Serial#: 1354
    public void m_notb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_notb(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1354; }
            @Override
            protected void assemble() throws AssemblyException {
                m_notb(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code negb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 309, Serial#: 1357
    public void m_negb(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_negb(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1357; }
            @Override
            protected void assemble() throws AssemblyException {
                m_negb(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code negb  }<i>label</i>
     */
    // Template#: 310, Serial#: 1358
    public void m_negb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_negb(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1358; }
            @Override
            protected void assemble() throws AssemblyException {
                m_negb(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 311, Serial#: 1361
    public void m_mulb___AL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mulb___AL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1361; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mulb___AL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulb  }<i>label</i>
     */
    // Template#: 312, Serial#: 1362
    public void m_mulb___AL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mulb___AL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1362; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mulb___AL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imulb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 313, Serial#: 1365
    public void m_imulb___AL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imulb___AL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1365; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imulb___AL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imulb  }<i>label</i>
     */
    // Template#: 314, Serial#: 1366
    public void m_imulb___AL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imulb___AL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1366; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imulb___AL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 315, Serial#: 1369
    public void m_divb___AL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_divb___AL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1369; }
            @Override
            protected void assemble() throws AssemblyException {
                m_divb___AL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divb  }<i>label</i>
     */
    // Template#: 316, Serial#: 1370
    public void m_divb___AL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_divb___AL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1370; }
            @Override
            protected void assemble() throws AssemblyException {
                m_divb___AL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code idivb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 317, Serial#: 1373
    public void m_idivb___AL(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_idivb___AL(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1373; }
            @Override
            protected void assemble() throws AssemblyException {
                m_idivb___AL(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code idivb  }<i>label</i>
     */
    // Template#: 318, Serial#: 1374
    public void m_idivb___AL(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_idivb___AL(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1374; }
            @Override
            protected void assemble() throws AssemblyException {
                m_idivb___AL(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code testl  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 319, Serial#: 1412
    public void m_testl(final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_testl(placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1412; }
            @Override
            protected void assemble() throws AssemblyException {
                m_testl(labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code testl  }<i>label</i>, <i>imm32</i>
     */
    // Template#: 320, Serial#: 1413
    public void m_testl(final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_testl(placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1413; }
            @Override
            protected void assemble() throws AssemblyException {
                m_testl(labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code notl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 321, Serial#: 1416
    public void m_notl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_notl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1416; }
            @Override
            protected void assemble() throws AssemblyException {
                m_notl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code notl  }<i>label</i>
     */
    // Template#: 322, Serial#: 1417
    public void m_notl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_notl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1417; }
            @Override
            protected void assemble() throws AssemblyException {
                m_notl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code negl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 323, Serial#: 1420
    public void m_negl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_negl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1420; }
            @Override
            protected void assemble() throws AssemblyException {
                m_negl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code negl  }<i>label</i>
     */
    // Template#: 324, Serial#: 1421
    public void m_negl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_negl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1421; }
            @Override
            protected void assemble() throws AssemblyException {
                m_negl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mull  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 325, Serial#: 1424
    public void m_mull___EAX(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mull___EAX(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1424; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mull___EAX(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mull  }<i>label</i>
     */
    // Template#: 326, Serial#: 1425
    public void m_mull___EAX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mull___EAX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1425; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mull___EAX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imull  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 327, Serial#: 1428
    public void m_imull___EAX(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imull___EAX(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1428; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imull___EAX(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imull  }<i>label</i>
     */
    // Template#: 328, Serial#: 1429
    public void m_imull___EAX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imull___EAX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1429; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imull___EAX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 329, Serial#: 1432
    public void m_divl___EAX(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_divl___EAX(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1432; }
            @Override
            protected void assemble() throws AssemblyException {
                m_divl___EAX(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divl  }<i>label</i>
     */
    // Template#: 330, Serial#: 1433
    public void m_divl___EAX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_divl___EAX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1433; }
            @Override
            protected void assemble() throws AssemblyException {
                m_divl___EAX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code idivl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 331, Serial#: 1436
    public void m_idivl___EAX(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_idivl___EAX(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1436; }
            @Override
            protected void assemble() throws AssemblyException {
                m_idivl___EAX(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code idivl  }<i>label</i>
     */
    // Template#: 332, Serial#: 1437
    public void m_idivl___EAX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_idivl___EAX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1437; }
            @Override
            protected void assemble() throws AssemblyException {
                m_idivl___EAX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code testw  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 333, Serial#: 1475
    public void m_testw(final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_testw(placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1475; }
            @Override
            protected void assemble() throws AssemblyException {
                m_testw(labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code testw  }<i>label</i>, <i>imm16</i>
     */
    // Template#: 334, Serial#: 1476
    public void m_testw(final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_testw(placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1476; }
            @Override
            protected void assemble() throws AssemblyException {
                m_testw(labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code notw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 335, Serial#: 1479
    public void m_notw(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_notw(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1479; }
            @Override
            protected void assemble() throws AssemblyException {
                m_notw(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code notw  }<i>label</i>
     */
    // Template#: 336, Serial#: 1480
    public void m_notw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_notw(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1480; }
            @Override
            protected void assemble() throws AssemblyException {
                m_notw(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code negw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 337, Serial#: 1483
    public void m_negw(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_negw(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1483; }
            @Override
            protected void assemble() throws AssemblyException {
                m_negw(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code negw  }<i>label</i>
     */
    // Template#: 338, Serial#: 1484
    public void m_negw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_negw(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1484; }
            @Override
            protected void assemble() throws AssemblyException {
                m_negw(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 339, Serial#: 1487
    public void m_mulw___AX(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mulw___AX(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1487; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mulw___AX(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mulw  }<i>label</i>
     */
    // Template#: 340, Serial#: 1488
    public void m_mulw___AX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mulw___AX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1488; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mulw___AX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imulw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 341, Serial#: 1491
    public void m_imulw___AX(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imulw___AX(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1491; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imulw___AX(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imulw  }<i>label</i>
     */
    // Template#: 342, Serial#: 1492
    public void m_imulw___AX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imulw___AX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1492; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imulw___AX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 343, Serial#: 1495
    public void m_divw___AX(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_divw___AX(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1495; }
            @Override
            protected void assemble() throws AssemblyException {
                m_divw___AX(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code divw  }<i>label</i>
     */
    // Template#: 344, Serial#: 1496
    public void m_divw___AX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_divw___AX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1496; }
            @Override
            protected void assemble() throws AssemblyException {
                m_divw___AX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code idivw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 345, Serial#: 1499
    public void m_idivw___AX(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_idivw___AX(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1499; }
            @Override
            protected void assemble() throws AssemblyException {
                m_idivw___AX(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code idivw  }<i>label</i>
     */
    // Template#: 346, Serial#: 1500
    public void m_idivw___AX(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_idivw___AX(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1500; }
            @Override
            protected void assemble() throws AssemblyException {
                m_idivw___AX(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 347, Serial#: 1538
    public void m_or(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1538; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>label</i>, <i>source</i>
     */
    // Template#: 348, Serial#: 1539
    public void m_or(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1539; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 349, Serial#: 1547
    public void m_or(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1547; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>label</i>, <i>source</i>
     */
    // Template#: 350, Serial#: 1548
    public void m_or(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1548; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 351, Serial#: 1556
    public void m_or(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1556; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>label</i>, <i>source</i>
     */
    // Template#: 352, Serial#: 1557
    public void m_or(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1557; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 353, Serial#: 1565
    public void m_or(final IA32GeneralRegister8 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1565; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>destination</i>, <i>label</i>
     */
    // Template#: 354, Serial#: 1566
    public void m_or(final IA32GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1566; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 355, Serial#: 1573
    public void m_or(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1573; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>destination</i>, <i>label</i>
     */
    // Template#: 356, Serial#: 1574
    public void m_or(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1574; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 357, Serial#: 1581
    public void m_or(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1581; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code or  }<i>destination</i>, <i>label</i>
     */
    // Template#: 358, Serial#: 1582
    public void m_or(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_or(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1582; }
            @Override
            protected void assemble() throws AssemblyException {
                m_or(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 359, Serial#: 1593
    public void m_sbb(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1593; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>label</i>, <i>source</i>
     */
    // Template#: 360, Serial#: 1594
    public void m_sbb(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1594; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 361, Serial#: 1602
    public void m_sbb(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1602; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>label</i>, <i>source</i>
     */
    // Template#: 362, Serial#: 1603
    public void m_sbb(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1603; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 363, Serial#: 1611
    public void m_sbb(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1611; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>label</i>, <i>source</i>
     */
    // Template#: 364, Serial#: 1612
    public void m_sbb(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1612; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 365, Serial#: 1620
    public void m_sbb(final IA32GeneralRegister8 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1620; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 366, Serial#: 1621
    public void m_sbb(final IA32GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1621; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 367, Serial#: 1628
    public void m_sbb(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1628; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 368, Serial#: 1629
    public void m_sbb(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1629; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 369, Serial#: 1636
    public void m_sbb(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1636; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sbb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 370, Serial#: 1637
    public void m_sbb(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sbb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1637; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sbb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 371, Serial#: 1649
    public void m_sub(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1649; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>label</i>, <i>source</i>
     */
    // Template#: 372, Serial#: 1650
    public void m_sub(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1650; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 373, Serial#: 1658
    public void m_sub(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1658; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>label</i>, <i>source</i>
     */
    // Template#: 374, Serial#: 1659
    public void m_sub(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1659; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 375, Serial#: 1667
    public void m_sub(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1667; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>label</i>, <i>source</i>
     */
    // Template#: 376, Serial#: 1668
    public void m_sub(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1668; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 377, Serial#: 1676
    public void m_sub(final IA32GeneralRegister8 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1676; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 378, Serial#: 1677
    public void m_sub(final IA32GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1677; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 379, Serial#: 1684
    public void m_sub(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1684; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 380, Serial#: 1685
    public void m_sub(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1685; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 381, Serial#: 1692
    public void m_sub(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1692; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sub  }<i>destination</i>, <i>label</i>
     */
    // Template#: 382, Serial#: 1693
    public void m_sub(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sub(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1693; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sub(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 383, Serial#: 1705
    public void m_cmp(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1705; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>label</i>, <i>source</i>
     */
    // Template#: 384, Serial#: 1706
    public void m_cmp(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1706; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 385, Serial#: 1714
    public void m_cmp(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1714; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>label</i>, <i>source</i>
     */
    // Template#: 386, Serial#: 1715
    public void m_cmp(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1715; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 387, Serial#: 1723
    public void m_cmp(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1723; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>label</i>, <i>source</i>
     */
    // Template#: 388, Serial#: 1724
    public void m_cmp(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1724; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 389, Serial#: 1732
    public void m_cmp(final IA32GeneralRegister8 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1732; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 390, Serial#: 1733
    public void m_cmp(final IA32GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1733; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 391, Serial#: 1740
    public void m_cmp(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1740; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 392, Serial#: 1741
    public void m_cmp(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1741; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 393, Serial#: 1748
    public void m_cmp(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1748; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 394, Serial#: 1749
    public void m_cmp(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmp(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1749; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmp(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imull  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>, <i>imm32</i>
     */
    // Template#: 395, Serial#: 1767
    public void m_imul(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder, index, scale, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1767; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt(), index, scale, imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imull  }<i>destination</i>, <i>label</i>, <i>imm32</i>
     */
    // Template#: 396, Serial#: 1768
    public void m_imul(final IA32GeneralRegister32 destination, final Label label, final int imm32) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder, imm32);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1768; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt(), imm32);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imulw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>, <i>imm16</i>
     */
    // Template#: 397, Serial#: 1776
    public void m_imul(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder, index, scale, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1776; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt(), index, scale, imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imulw  }<i>destination</i>, <i>label</i>, <i>imm16</i>
     */
    // Template#: 398, Serial#: 1777
    public void m_imul(final IA32GeneralRegister16 destination, final Label label, final short imm16) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder, imm16);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1777; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt(), imm16);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 399, Serial#: 1786
    public void m_imul(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1786; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 400, Serial#: 1787
    public void m_imul(final IA32GeneralRegister32 destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1787; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 401, Serial#: 1795
    public void m_imul(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1795; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 402, Serial#: 1796
    public void m_imul(final IA32GeneralRegister16 destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1796; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code js  }<i>label</i>
     */
    // Template#: 403, Serial#: 1808
    public void js(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        js(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 1808; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        js(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        js(labelOffsetAsShort());
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
    // Template#: 404, Serial#: 1809
    public void jns(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jns(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 1809; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jns(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jns(labelOffsetAsShort());
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
    // Template#: 405, Serial#: 1810
    public void jp(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jp(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 1810; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jp(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jp(labelOffsetAsShort());
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
    // Template#: 406, Serial#: 1811
    public void jnp(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnp(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 1811; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnp(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jnp(labelOffsetAsShort());
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
    // Template#: 407, Serial#: 1812
    public void jl(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 1812; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jl(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jl(labelOffsetAsShort());
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
    // Template#: 408, Serial#: 1813
    public void jnl(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnl(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 1813; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnl(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jnl(labelOffsetAsShort());
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
    // Template#: 409, Serial#: 1814
    public void jle(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jle(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 1814; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jle(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jle(labelOffsetAsShort());
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
    // Template#: 410, Serial#: 1815
    public void jnle(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jnle(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 1815; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jnle(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jnle(labelOffsetAsShort());
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
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 411, Serial#: 1818
    public void m_mov(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1818; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>source</i>
     */
    // Template#: 412, Serial#: 1819
    public void m_mov(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1819; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 413, Serial#: 1827
    public void m_mov(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1827; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>source</i>
     */
    // Template#: 414, Serial#: 1828
    public void m_mov(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1828; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 415, Serial#: 1836
    public void m_mov(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1836; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>source</i>
     */
    // Template#: 416, Serial#: 1837
    public void m_mov(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1837; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 417, Serial#: 1845
    public void m_mov(final IA32GeneralRegister8 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1845; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>
     */
    // Template#: 418, Serial#: 1846
    public void m_mov(final IA32GeneralRegister8 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1846; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 419, Serial#: 1853
    public void m_mov(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1853; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>
     */
    // Template#: 420, Serial#: 1854
    public void m_mov(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1854; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 421, Serial#: 1861
    public void m_mov(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1861; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>
     */
    // Template#: 422, Serial#: 1862
    public void m_mov(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1862; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 423, Serial#: 1869
    public void m_mov(final Label label, final IA32IndexRegister32 index, final Scale scale, final SegmentRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1869; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>label</i>, <i>source</i>
     */
    // Template#: 424, Serial#: 1870
    public void m_mov(final Label label, final SegmentRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1870; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lea  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 425, Serial#: 1878
    public void m_lea(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lea(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1878; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lea(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lea  }<i>destination</i>, <i>label</i>
     */
    // Template#: 426, Serial#: 1879
    public void m_lea(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lea(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1879; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lea(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lea  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 427, Serial#: 1886
    public void m_lea(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lea(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1886; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lea(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lea  }<i>destination</i>, <i>label</i>
     */
    // Template#: 428, Serial#: 1887
    public void m_lea(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lea(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1887; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lea(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 429, Serial#: 1894
    public void m_mov(final SegmentRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1894; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code mov  }<i>destination</i>, <i>label</i>
     */
    // Template#: 430, Serial#: 1895
    public void m_mov(final SegmentRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_mov(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1895; }
            @Override
            protected void assemble() throws AssemblyException {
                m_mov(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pop  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 431, Serial#: 1903
    public void m_pop(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pop(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1903; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pop(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pop  }<i>label</i>
     */
    // Template#: 432, Serial#: 1904
    public void m_pop(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pop(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1904; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pop(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code call  }<i>label</i>
     */
    // Template#: 433, Serial#: 1913
    public void m_call(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_call(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1913; }
            @Override
            protected void assemble() throws AssemblyException {
                m_call(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fadds  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 434, Serial#: 1945
    public void m_fadds(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fadds(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1945; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fadds(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fadds  }<i>label</i>
     */
    // Template#: 435, Serial#: 1946
    public void m_fadds(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fadds(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1946; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fadds(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fmuls  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 436, Serial#: 1949
    public void m_fmuls(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fmuls(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1949; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fmuls(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fmuls  }<i>label</i>
     */
    // Template#: 437, Serial#: 1950
    public void m_fmuls(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fmuls(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1950; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fmuls(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcoms  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 438, Serial#: 1953
    public void m_fcoms(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fcoms(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1953; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fcoms(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcoms  }<i>label</i>
     */
    // Template#: 439, Serial#: 1954
    public void m_fcoms(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fcoms(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1954; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fcoms(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcomps  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 440, Serial#: 1957
    public void m_fcomps(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fcomps(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1957; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fcomps(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcomps  }<i>label</i>
     */
    // Template#: 441, Serial#: 1958
    public void m_fcomps(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fcomps(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1958; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fcomps(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubs  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 442, Serial#: 1961
    public void m_fsubs(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsubs(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1961; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsubs(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubs  }<i>label</i>
     */
    // Template#: 443, Serial#: 1962
    public void m_fsubs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsubs(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1962; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsubs(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubrs  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 444, Serial#: 1965
    public void m_fsubrs(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsubrs(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1965; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsubrs(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubrs  }<i>label</i>
     */
    // Template#: 445, Serial#: 1966
    public void m_fsubrs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsubrs(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1966; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsubrs(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivs  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 446, Serial#: 1969
    public void m_fdivs(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fdivs(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1969; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fdivs(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivs  }<i>label</i>
     */
    // Template#: 447, Serial#: 1970
    public void m_fdivs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fdivs(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1970; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fdivs(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivrs  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 448, Serial#: 1973
    public void m_fdivrs(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fdivrs(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1973; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fdivrs(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivrs  }<i>label</i>
     */
    // Template#: 449, Serial#: 1974
    public void m_fdivrs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fdivrs(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 1974; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fdivrs(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code flds  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 450, Serial#: 2009
    public void m_flds(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_flds(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2009; }
            @Override
            protected void assemble() throws AssemblyException {
                m_flds(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code flds  }<i>label</i>
     */
    // Template#: 451, Serial#: 2010
    public void m_flds(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_flds(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2010; }
            @Override
            protected void assemble() throws AssemblyException {
                m_flds(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsts  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 452, Serial#: 2013
    public void m_fsts(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsts(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2013; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsts(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsts  }<i>label</i>
     */
    // Template#: 453, Serial#: 2014
    public void m_fsts(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsts(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2014; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsts(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstps  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 454, Serial#: 2017
    public void m_fstps(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstps(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2017; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstps(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstps  }<i>label</i>
     */
    // Template#: 455, Serial#: 2018
    public void m_fstps(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstps(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2018; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstps(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldenv  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 456, Serial#: 2021
    public void m_fldenv(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fldenv(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2021; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fldenv(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldenv  }<i>label</i>
     */
    // Template#: 457, Serial#: 2022
    public void m_fldenv(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fldenv(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2022; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fldenv(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldcw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 458, Serial#: 2025
    public void m_fldcw(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fldcw(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2025; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fldcw(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldcw  }<i>label</i>
     */
    // Template#: 459, Serial#: 2026
    public void m_fldcw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fldcw(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2026; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fldcw(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstenv  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 460, Serial#: 2029
    public void m_fstenv(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstenv(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2029; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstenv(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstenv  }<i>label</i>
     */
    // Template#: 461, Serial#: 2030
    public void m_fstenv(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstenv(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2030; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstenv(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstcw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 462, Serial#: 2033
    public void m_fstcw(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstcw(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2033; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstcw(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstcw  }<i>label</i>
     */
    // Template#: 463, Serial#: 2034
    public void m_fstcw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstcw(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2034; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstcw(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fiaddl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 464, Serial#: 2065
    public void m_fiaddl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fiaddl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2065; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fiaddl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fiaddl  }<i>label</i>
     */
    // Template#: 465, Serial#: 2066
    public void m_fiaddl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fiaddl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2066; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fiaddl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fimull  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 466, Serial#: 2069
    public void m_fimull(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fimull(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2069; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fimull(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fimull  }<i>label</i>
     */
    // Template#: 467, Serial#: 2070
    public void m_fimull(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fimull(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2070; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fimull(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficoml  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 468, Serial#: 2073
    public void m_ficoml(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_ficoml(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2073; }
            @Override
            protected void assemble() throws AssemblyException {
                m_ficoml(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficoml  }<i>label</i>
     */
    // Template#: 469, Serial#: 2074
    public void m_ficoml(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_ficoml(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2074; }
            @Override
            protected void assemble() throws AssemblyException {
                m_ficoml(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficompl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 470, Serial#: 2077
    public void m_ficompl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_ficompl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2077; }
            @Override
            protected void assemble() throws AssemblyException {
                m_ficompl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficompl  }<i>label</i>
     */
    // Template#: 471, Serial#: 2078
    public void m_ficompl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_ficompl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2078; }
            @Override
            protected void assemble() throws AssemblyException {
                m_ficompl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 472, Serial#: 2081
    public void m_fisubl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fisubl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2081; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fisubl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubl  }<i>label</i>
     */
    // Template#: 473, Serial#: 2082
    public void m_fisubl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fisubl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2082; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fisubl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubrl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 474, Serial#: 2085
    public void m_fisubrl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fisubrl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2085; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fisubrl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubrl  }<i>label</i>
     */
    // Template#: 475, Serial#: 2086
    public void m_fisubrl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fisubrl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2086; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fisubrl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 476, Serial#: 2089
    public void m_fidivl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fidivl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2089; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fidivl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivl  }<i>label</i>
     */
    // Template#: 477, Serial#: 2090
    public void m_fidivl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fidivl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2090; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fidivl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivrl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 478, Serial#: 2093
    public void m_fidivrl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fidivrl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2093; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fidivrl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivrl  }<i>label</i>
     */
    // Template#: 479, Serial#: 2094
    public void m_fidivrl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fidivrl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2094; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fidivrl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fildl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 480, Serial#: 2129
    public void m_fildl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fildl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2129; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fildl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fildl  }<i>label</i>
     */
    // Template#: 481, Serial#: 2130
    public void m_fildl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fildl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2130; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fildl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 482, Serial#: 2133
    public void m_fistl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fistl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2133; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fistl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistl  }<i>label</i>
     */
    // Template#: 483, Serial#: 2134
    public void m_fistl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fistl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2134; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fistl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistpl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 484, Serial#: 2137
    public void m_fistpl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fistpl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2137; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fistpl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistpl  }<i>label</i>
     */
    // Template#: 485, Serial#: 2138
    public void m_fistpl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fistpl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2138; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fistpl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldt  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 486, Serial#: 2141
    public void m_fldt(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fldt(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2141; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fldt(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldt  }<i>label</i>
     */
    // Template#: 487, Serial#: 2142
    public void m_fldt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fldt(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2142; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fldt(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstpt  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 488, Serial#: 2145
    public void m_fstpt(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstpt(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2145; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstpt(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstpt  }<i>label</i>
     */
    // Template#: 489, Serial#: 2146
    public void m_fstpt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstpt(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2146; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstpt(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code faddl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 490, Serial#: 2169
    public void m_faddl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_faddl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2169; }
            @Override
            protected void assemble() throws AssemblyException {
                m_faddl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code faddl  }<i>label</i>
     */
    // Template#: 491, Serial#: 2170
    public void m_faddl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_faddl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2170; }
            @Override
            protected void assemble() throws AssemblyException {
                m_faddl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fmull  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 492, Serial#: 2173
    public void m_fmull(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fmull(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2173; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fmull(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fmull  }<i>label</i>
     */
    // Template#: 493, Serial#: 2174
    public void m_fmull(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fmull(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2174; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fmull(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcoml  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 494, Serial#: 2177
    public void m_fcoml(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fcoml(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2177; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fcoml(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcoml  }<i>label</i>
     */
    // Template#: 495, Serial#: 2178
    public void m_fcoml(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fcoml(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2178; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fcoml(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcompl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 496, Serial#: 2181
    public void m_fcompl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fcompl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2181; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fcompl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fcompl  }<i>label</i>
     */
    // Template#: 497, Serial#: 2182
    public void m_fcompl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fcompl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2182; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fcompl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 498, Serial#: 2185
    public void m_fsubl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsubl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2185; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsubl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubl  }<i>label</i>
     */
    // Template#: 499, Serial#: 2186
    public void m_fsubl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsubl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2186; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsubl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubrl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 500, Serial#: 2189
    public void m_fsubrl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsubrl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2189; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsubrl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsubrl  }<i>label</i>
     */
    // Template#: 501, Serial#: 2190
    public void m_fsubrl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsubrl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2190; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsubrl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 502, Serial#: 2193
    public void m_fdivl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fdivl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2193; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fdivl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivl  }<i>label</i>
     */
    // Template#: 503, Serial#: 2194
    public void m_fdivl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fdivl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2194; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fdivl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivrl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 504, Serial#: 2197
    public void m_fdivrl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fdivrl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2197; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fdivrl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fdivrl  }<i>label</i>
     */
    // Template#: 505, Serial#: 2198
    public void m_fdivrl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fdivrl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2198; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fdivrl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 506, Serial#: 2233
    public void m_fldl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fldl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2233; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fldl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fldl  }<i>label</i>
     */
    // Template#: 507, Serial#: 2234
    public void m_fldl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fldl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2234; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fldl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 508, Serial#: 2237
    public void m_fstl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2237; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstl  }<i>label</i>
     */
    // Template#: 509, Serial#: 2238
    public void m_fstl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2238; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstpl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 510, Serial#: 2241
    public void m_fstpl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstpl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2241; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstpl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstpl  }<i>label</i>
     */
    // Template#: 511, Serial#: 2242
    public void m_fstpl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstpl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2242; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstpl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code frstor  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 512, Serial#: 2245
    public void m_frstor(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_frstor(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2245; }
            @Override
            protected void assemble() throws AssemblyException {
                m_frstor(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code frstor  }<i>label</i>
     */
    // Template#: 513, Serial#: 2246
    public void m_frstor(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_frstor(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2246; }
            @Override
            protected void assemble() throws AssemblyException {
                m_frstor(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsave  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 514, Serial#: 2249
    public void m_fsave(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsave(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2249; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsave(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fsave  }<i>label</i>
     */
    // Template#: 515, Serial#: 2250
    public void m_fsave(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fsave(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2250; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fsave(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstsw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 516, Serial#: 2253
    public void m_fstsw(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstsw(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2253; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstsw(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fstsw  }<i>label</i>
     */
    // Template#: 517, Serial#: 2254
    public void m_fstsw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fstsw(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2254; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fstsw(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fiadds  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 518, Serial#: 2281
    public void m_fiadds(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fiadds(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2281; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fiadds(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fiadds  }<i>label</i>
     */
    // Template#: 519, Serial#: 2282
    public void m_fiadds(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fiadds(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2282; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fiadds(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fimuls  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 520, Serial#: 2285
    public void m_fimuls(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fimuls(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2285; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fimuls(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fimuls  }<i>label</i>
     */
    // Template#: 521, Serial#: 2286
    public void m_fimuls(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fimuls(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2286; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fimuls(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficoms  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 522, Serial#: 2289
    public void m_ficoms(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_ficoms(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2289; }
            @Override
            protected void assemble() throws AssemblyException {
                m_ficoms(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficoms  }<i>label</i>
     */
    // Template#: 523, Serial#: 2290
    public void m_ficoms(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_ficoms(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2290; }
            @Override
            protected void assemble() throws AssemblyException {
                m_ficoms(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficomps  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 524, Serial#: 2293
    public void m_ficomps(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_ficomps(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2293; }
            @Override
            protected void assemble() throws AssemblyException {
                m_ficomps(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ficomps  }<i>label</i>
     */
    // Template#: 525, Serial#: 2294
    public void m_ficomps(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_ficomps(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2294; }
            @Override
            protected void assemble() throws AssemblyException {
                m_ficomps(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubs  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 526, Serial#: 2297
    public void m_fisubs(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fisubs(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2297; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fisubs(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubs  }<i>label</i>
     */
    // Template#: 527, Serial#: 2298
    public void m_fisubs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fisubs(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2298; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fisubs(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubrs  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 528, Serial#: 2301
    public void m_fisubrs(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fisubrs(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2301; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fisubrs(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fisubrs  }<i>label</i>
     */
    // Template#: 529, Serial#: 2302
    public void m_fisubrs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fisubrs(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2302; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fisubrs(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivs  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 530, Serial#: 2305
    public void m_fidivs(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fidivs(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2305; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fidivs(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivs  }<i>label</i>
     */
    // Template#: 531, Serial#: 2306
    public void m_fidivs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fidivs(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2306; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fidivs(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivrs  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 532, Serial#: 2309
    public void m_fidivrs(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fidivrs(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2309; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fidivrs(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fidivrs  }<i>label</i>
     */
    // Template#: 533, Serial#: 2310
    public void m_fidivrs(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fidivrs(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2310; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fidivrs(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code filds  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 534, Serial#: 2345
    public void m_filds(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_filds(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2345; }
            @Override
            protected void assemble() throws AssemblyException {
                m_filds(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code filds  }<i>label</i>
     */
    // Template#: 535, Serial#: 2346
    public void m_filds(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_filds(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2346; }
            @Override
            protected void assemble() throws AssemblyException {
                m_filds(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fists  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 536, Serial#: 2349
    public void m_fists(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fists(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2349; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fists(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fists  }<i>label</i>
     */
    // Template#: 537, Serial#: 2350
    public void m_fists(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fists(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2350; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fists(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistps  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 538, Serial#: 2353
    public void m_fistps(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fistps(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2353; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fistps(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistps  }<i>label</i>
     */
    // Template#: 539, Serial#: 2354
    public void m_fistps(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fistps(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2354; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fistps(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbld  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 540, Serial#: 2357
    public void m_fbld(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fbld(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2357; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fbld(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbld  }<i>label</i>
     */
    // Template#: 541, Serial#: 2358
    public void m_fbld(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fbld(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2358; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fbld(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fildq  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 542, Serial#: 2361
    public void m_fildq(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fildq(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2361; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fildq(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fildq  }<i>label</i>
     */
    // Template#: 543, Serial#: 2362
    public void m_fildq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fildq(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2362; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fildq(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbstp  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 544, Serial#: 2365
    public void m_fbstp(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fbstp(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2365; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fbstp(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbstp  }<i>label</i>
     */
    // Template#: 545, Serial#: 2366
    public void m_fbstp(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fbstp(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2366; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fbstp(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistpq  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 546, Serial#: 2369
    public void m_fistpq(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fistpq(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2369; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fistpq(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fistpq  }<i>label</i>
     */
    // Template#: 547, Serial#: 2370
    public void m_fistpq(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_fistpq(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2370; }
            @Override
            protected void assemble() throws AssemblyException {
                m_fistpq(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code call  }<i>label</i>
     */
    // Template#: 548, Serial#: 2399
    public void call(final Label label) {
        final int startOffset = currentOffset();
        final short placeHolder = 0;
        call(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 6) {
            @Override
            protected int templateSerial() { return 2399; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_16: {
                        call(labelOffsetAsShort());
                        break;
                    }
                    case BITS_32: {
                        call(labelOffsetAsInt());
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
     * Pseudo-external assembler syntax: {@code call  }<i>label</i>
     */
    // Template#: 549, Serial#: 2400
    /**
     * Pseudo-external assembler syntax: {@code jmp  }<i>label</i>
     */
    // Template#: 550, Serial#: 2401
    public void jmp(final Label label) {
        final int startOffset = currentOffset();
        final byte placeHolder = 0;
        jmp(placeHolder);
        new LabelOffsetInstruction(this, startOffset, currentOffset(), label, 7) {
            @Override
            protected int templateSerial() { return 2401; }
            @Override
            protected void assemble() throws AssemblyException {
                switch (labelWidth()) {
                    case BITS_8: {
                        jmp(labelOffsetAsByte());
                        break;
                    }
                    case BITS_16: {
                        jmp(labelOffsetAsShort());
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
    // Template#: 551, Serial#: 2402
    /**
     * Pseudo-external assembler syntax: {@code jmp  }<i>label</i>
     */
    // Template#: 552, Serial#: 2403
    public void m_jmp(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_jmp(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2403; }
            @Override
            protected void assemble() throws AssemblyException {
                m_jmp(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jmp  }<i>label</i>
     */
    // Template#: 553, Serial#: 2404
    /**
     * Pseudo-external assembler syntax: {@code incb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 554, Serial#: 2419
    public void m_incb(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_incb(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2419; }
            @Override
            protected void assemble() throws AssemblyException {
                m_incb(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code incb  }<i>label</i>
     */
    // Template#: 555, Serial#: 2420
    public void m_incb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_incb(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2420; }
            @Override
            protected void assemble() throws AssemblyException {
                m_incb(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code decb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 556, Serial#: 2423
    public void m_decb(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_decb(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2423; }
            @Override
            protected void assemble() throws AssemblyException {
                m_decb(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code decb  }<i>label</i>
     */
    // Template#: 557, Serial#: 2424
    public void m_decb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_decb(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2424; }
            @Override
            protected void assemble() throws AssemblyException {
                m_decb(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code incl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 558, Serial#: 2437
    public void m_incl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_incl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2437; }
            @Override
            protected void assemble() throws AssemblyException {
                m_incl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code incl  }<i>label</i>
     */
    // Template#: 559, Serial#: 2438
    public void m_incl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_incl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2438; }
            @Override
            protected void assemble() throws AssemblyException {
                m_incl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code decl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 560, Serial#: 2441
    public void m_decl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_decl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2441; }
            @Override
            protected void assemble() throws AssemblyException {
                m_decl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code decl  }<i>label</i>
     */
    // Template#: 561, Serial#: 2442
    public void m_decl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_decl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2442; }
            @Override
            protected void assemble() throws AssemblyException {
                m_decl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code call  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 562, Serial#: 2445
    public void m_call(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_call(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2445; }
            @Override
            protected void assemble() throws AssemblyException {
                m_call(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jmp  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 563, Serial#: 2448
    public void m_jmp(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_jmp(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2448; }
            @Override
            protected void assemble() throws AssemblyException {
                m_jmp(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code push  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 564, Serial#: 2451
    public void m_push(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_push(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2451; }
            @Override
            protected void assemble() throws AssemblyException {
                m_push(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code push  }<i>label</i>
     */
    // Template#: 565, Serial#: 2452
    public void m_push(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_push(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2452; }
            @Override
            protected void assemble() throws AssemblyException {
                m_push(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code incw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 566, Serial#: 2479
    public void m_incw(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_incw(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2479; }
            @Override
            protected void assemble() throws AssemblyException {
                m_incw(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code incw  }<i>label</i>
     */
    // Template#: 567, Serial#: 2480
    public void m_incw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_incw(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2480; }
            @Override
            protected void assemble() throws AssemblyException {
                m_incw(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code decw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 568, Serial#: 2483
    public void m_decw(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_decw(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2483; }
            @Override
            protected void assemble() throws AssemblyException {
                m_decw(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code decw  }<i>label</i>
     */
    // Template#: 569, Serial#: 2484
    public void m_decw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_decw(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2484; }
            @Override
            protected void assemble() throws AssemblyException {
                m_decw(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sldt  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 570, Serial#: 2499
    public void m_sldt(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sldt(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2499; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sldt(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sldt  }<i>label</i>
     */
    // Template#: 571, Serial#: 2500
    public void m_sldt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sldt(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2500; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sldt(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code str  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 572, Serial#: 2503
    public void m_str(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_str(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2503; }
            @Override
            protected void assemble() throws AssemblyException {
                m_str(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code str  }<i>label</i>
     */
    // Template#: 573, Serial#: 2504
    public void m_str(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_str(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2504; }
            @Override
            protected void assemble() throws AssemblyException {
                m_str(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lldt  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 574, Serial#: 2507
    public void m_lldt(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lldt(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2507; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lldt(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lldt  }<i>label</i>
     */
    // Template#: 575, Serial#: 2508
    public void m_lldt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lldt(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2508; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lldt(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ltr  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 576, Serial#: 2511
    public void m_ltr(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_ltr(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2511; }
            @Override
            protected void assemble() throws AssemblyException {
                m_ltr(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ltr  }<i>label</i>
     */
    // Template#: 577, Serial#: 2512
    public void m_ltr(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_ltr(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2512; }
            @Override
            protected void assemble() throws AssemblyException {
                m_ltr(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code verr  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 578, Serial#: 2515
    public void m_verr(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_verr(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2515; }
            @Override
            protected void assemble() throws AssemblyException {
                m_verr(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code verr  }<i>label</i>
     */
    // Template#: 579, Serial#: 2516
    public void m_verr(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_verr(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2516; }
            @Override
            protected void assemble() throws AssemblyException {
                m_verr(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code verw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 580, Serial#: 2519
    public void m_verw(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_verw(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2519; }
            @Override
            protected void assemble() throws AssemblyException {
                m_verw(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code verw  }<i>label</i>
     */
    // Template#: 581, Serial#: 2520
    public void m_verw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_verw(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2520; }
            @Override
            protected void assemble() throws AssemblyException {
                m_verw(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sgdt  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 582, Serial#: 2555
    public void m_sgdt(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sgdt(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2555; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sgdt(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sgdt  }<i>label</i>
     */
    // Template#: 583, Serial#: 2556
    public void m_sgdt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sgdt(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2556; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sgdt(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sidt  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 584, Serial#: 2559
    public void m_sidt(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sidt(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2559; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sidt(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sidt  }<i>label</i>
     */
    // Template#: 585, Serial#: 2560
    public void m_sidt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sidt(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2560; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sidt(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lgdt  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 586, Serial#: 2563
    public void m_lgdt(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lgdt(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2563; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lgdt(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lgdt  }<i>label</i>
     */
    // Template#: 587, Serial#: 2564
    public void m_lgdt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lgdt(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2564; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lgdt(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lidt  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 588, Serial#: 2567
    public void m_lidt(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lidt(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2567; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lidt(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lidt  }<i>label</i>
     */
    // Template#: 589, Serial#: 2568
    public void m_lidt(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lidt(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2568; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lidt(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code smsw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 590, Serial#: 2571
    public void m_smsw(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_smsw(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2571; }
            @Override
            protected void assemble() throws AssemblyException {
                m_smsw(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code smsw  }<i>label</i>
     */
    // Template#: 591, Serial#: 2572
    public void m_smsw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_smsw(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2572; }
            @Override
            protected void assemble() throws AssemblyException {
                m_smsw(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lmsw  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 592, Serial#: 2575
    public void m_lmsw(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lmsw(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2575; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lmsw(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lmsw  }<i>label</i>
     */
    // Template#: 593, Serial#: 2576
    public void m_lmsw(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lmsw(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2576; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lmsw(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code invlpg  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 594, Serial#: 2579
    public void m_invlpg(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_invlpg(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2579; }
            @Override
            protected void assemble() throws AssemblyException {
                m_invlpg(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code invlpg  }<i>label</i>
     */
    // Template#: 595, Serial#: 2580
    public void m_invlpg(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_invlpg(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2580; }
            @Override
            protected void assemble() throws AssemblyException {
                m_invlpg(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lar  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 596, Serial#: 2614
    public void m_lar(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lar(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2614; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lar(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lar  }<i>destination</i>, <i>label</i>
     */
    // Template#: 597, Serial#: 2615
    public void m_lar(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lar(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2615; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lar(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lar  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 598, Serial#: 2623
    public void m_lar(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lar(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2623; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lar(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lar  }<i>destination</i>, <i>label</i>
     */
    // Template#: 599, Serial#: 2624
    public void m_lar(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lar(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2624; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lar(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lsl  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 600, Serial#: 2632
    public void m_lsl(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lsl(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2632; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lsl(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lsl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 601, Serial#: 2633
    public void m_lsl(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lsl(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2633; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lsl(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lsl  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 602, Serial#: 2641
    public void m_lsl(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lsl(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2641; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lsl(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lsl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 603, Serial#: 2642
    public void m_lsl(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lsl(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2642; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lsl(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovo  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 604, Serial#: 2659
    public void m_cmovo(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovo(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2659; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovo(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovo  }<i>destination</i>, <i>label</i>
     */
    // Template#: 605, Serial#: 2660
    public void m_cmovo(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovo(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2660; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovo(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovo  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 606, Serial#: 2668
    public void m_cmovo(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovo(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2668; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovo(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovo  }<i>destination</i>, <i>label</i>
     */
    // Template#: 607, Serial#: 2669
    public void m_cmovo(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovo(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2669; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovo(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovno  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 608, Serial#: 2677
    public void m_cmovno(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovno(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2677; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovno(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovno  }<i>destination</i>, <i>label</i>
     */
    // Template#: 609, Serial#: 2678
    public void m_cmovno(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovno(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2678; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovno(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovno  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 610, Serial#: 2686
    public void m_cmovno(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovno(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2686; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovno(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovno  }<i>destination</i>, <i>label</i>
     */
    // Template#: 611, Serial#: 2687
    public void m_cmovno(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovno(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2687; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovno(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 612, Serial#: 2695
    public void m_cmovb(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2695; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 613, Serial#: 2696
    public void m_cmovb(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2696; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 614, Serial#: 2704
    public void m_cmovb(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2704; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 615, Serial#: 2705
    public void m_cmovb(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2705; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 616, Serial#: 2713
    public void m_cmovnb(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2713; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 617, Serial#: 2714
    public void m_cmovnb(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2714; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 618, Serial#: 2722
    public void m_cmovnb(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2722; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 619, Serial#: 2723
    public void m_cmovnb(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2723; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovz  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 620, Serial#: 2731
    public void m_cmovz(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovz(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2731; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovz(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovz  }<i>destination</i>, <i>label</i>
     */
    // Template#: 621, Serial#: 2732
    public void m_cmovz(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovz(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2732; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovz(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovz  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 622, Serial#: 2740
    public void m_cmovz(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovz(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2740; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovz(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovz  }<i>destination</i>, <i>label</i>
     */
    // Template#: 623, Serial#: 2741
    public void m_cmovz(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovz(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2741; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovz(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnz  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 624, Serial#: 2749
    public void m_cmovnz(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnz(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2749; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnz(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnz  }<i>destination</i>, <i>label</i>
     */
    // Template#: 625, Serial#: 2750
    public void m_cmovnz(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnz(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2750; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnz(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnz  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 626, Serial#: 2758
    public void m_cmovnz(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnz(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2758; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnz(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnz  }<i>destination</i>, <i>label</i>
     */
    // Template#: 627, Serial#: 2759
    public void m_cmovnz(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnz(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2759; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnz(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovbe  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 628, Serial#: 2767
    public void m_cmovbe(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovbe(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2767; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovbe(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovbe  }<i>destination</i>, <i>label</i>
     */
    // Template#: 629, Serial#: 2768
    public void m_cmovbe(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovbe(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2768; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovbe(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovbe  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 630, Serial#: 2776
    public void m_cmovbe(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovbe(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2776; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovbe(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovbe  }<i>destination</i>, <i>label</i>
     */
    // Template#: 631, Serial#: 2777
    public void m_cmovbe(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovbe(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2777; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovbe(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnbe  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 632, Serial#: 2785
    public void m_cmovnbe(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnbe(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2785; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnbe(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnbe  }<i>destination</i>, <i>label</i>
     */
    // Template#: 633, Serial#: 2786
    public void m_cmovnbe(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnbe(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2786; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnbe(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnbe  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 634, Serial#: 2794
    public void m_cmovnbe(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnbe(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2794; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnbe(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnbe  }<i>destination</i>, <i>label</i>
     */
    // Template#: 635, Serial#: 2795
    public void m_cmovnbe(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnbe(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2795; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnbe(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpcklbw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 636, Serial#: 2803
    public void m_punpcklbw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpcklbw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2803; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpcklbw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpcklbw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 637, Serial#: 2804
    public void m_punpcklbw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpcklbw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2804; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpcklbw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpcklwd  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 638, Serial#: 2812
    public void m_punpcklwd(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpcklwd(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2812; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpcklwd(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpcklwd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 639, Serial#: 2813
    public void m_punpcklwd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpcklwd(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2813; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpcklwd(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckldq  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 640, Serial#: 2821
    public void m_punpckldq(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpckldq(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2821; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpckldq(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckldq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 641, Serial#: 2822
    public void m_punpckldq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpckldq(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2822; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpckldq(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packsswb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 642, Serial#: 2830
    public void m_packsswb(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_packsswb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2830; }
            @Override
            protected void assemble() throws AssemblyException {
                m_packsswb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packsswb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 643, Serial#: 2831
    public void m_packsswb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_packsswb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2831; }
            @Override
            protected void assemble() throws AssemblyException {
                m_packsswb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 644, Serial#: 2839
    public void m_pcmpgtb(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpgtb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2839; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpgtb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 645, Serial#: 2840
    public void m_pcmpgtb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpgtb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2840; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpgtb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 646, Serial#: 2848
    public void m_pcmpgtw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpgtw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2848; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpgtw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 647, Serial#: 2849
    public void m_pcmpgtw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpgtw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2849; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpgtw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtd  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 648, Serial#: 2857
    public void m_pcmpgtd(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpgtd(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2857; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpgtd(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpgtd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 649, Serial#: 2858
    public void m_pcmpgtd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpgtd(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2858; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpgtd(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packuswb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 650, Serial#: 2866
    public void m_packuswb(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_packuswb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2866; }
            @Override
            protected void assemble() throws AssemblyException {
                m_packuswb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packuswb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 651, Serial#: 2867
    public void m_packuswb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_packuswb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2867; }
            @Override
            protected void assemble() throws AssemblyException {
                m_packuswb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pshufw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 652, Serial#: 2875
    public void m_pshufw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pshufw(destination, placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2875; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pshufw(destination, labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pshufw  }<i>destination</i>, <i>label</i>, <i>imm8</i>
     */
    // Template#: 653, Serial#: 2876
    public void m_pshufw(final MMXRegister destination, final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pshufw(destination, placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2876; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pshufw(destination, labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 654, Serial#: 2892
    public void m_pcmpeqb(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpeqb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2892; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpeqb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 655, Serial#: 2893
    public void m_pcmpeqb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpeqb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2893; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpeqb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 656, Serial#: 2901
    public void m_pcmpeqw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpeqw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2901; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpeqw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 657, Serial#: 2902
    public void m_pcmpeqw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpeqw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2902; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpeqw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqd  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 658, Serial#: 2910
    public void m_pcmpeqd(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpeqd(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2910; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpeqd(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pcmpeqd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 659, Serial#: 2911
    public void m_pcmpeqd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pcmpeqd(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2911; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pcmpeqd(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code jo  }<i>label</i>
     */
    // Template#: 660, Serial#: 2918
    /**
     * Pseudo-external assembler syntax: {@code jo  }<i>label</i>
     */
    // Template#: 661, Serial#: 2919
    /**
     * Pseudo-external assembler syntax: {@code jno  }<i>label</i>
     */
    // Template#: 662, Serial#: 2920
    /**
     * Pseudo-external assembler syntax: {@code jno  }<i>label</i>
     */
    // Template#: 663, Serial#: 2921
    /**
     * Pseudo-external assembler syntax: {@code jb  }<i>label</i>
     */
    // Template#: 664, Serial#: 2922
    /**
     * Pseudo-external assembler syntax: {@code jb  }<i>label</i>
     */
    // Template#: 665, Serial#: 2923
    /**
     * Pseudo-external assembler syntax: {@code jnb  }<i>label</i>
     */
    // Template#: 666, Serial#: 2924
    /**
     * Pseudo-external assembler syntax: {@code jnb  }<i>label</i>
     */
    // Template#: 667, Serial#: 2925
    /**
     * Pseudo-external assembler syntax: {@code jz  }<i>label</i>
     */
    // Template#: 668, Serial#: 2926
    /**
     * Pseudo-external assembler syntax: {@code jz  }<i>label</i>
     */
    // Template#: 669, Serial#: 2927
    /**
     * Pseudo-external assembler syntax: {@code jnz  }<i>label</i>
     */
    // Template#: 670, Serial#: 2928
    /**
     * Pseudo-external assembler syntax: {@code jnz  }<i>label</i>
     */
    // Template#: 671, Serial#: 2929
    /**
     * Pseudo-external assembler syntax: {@code jbe  }<i>label</i>
     */
    // Template#: 672, Serial#: 2930
    /**
     * Pseudo-external assembler syntax: {@code jbe  }<i>label</i>
     */
    // Template#: 673, Serial#: 2931
    /**
     * Pseudo-external assembler syntax: {@code jnbe  }<i>label</i>
     */
    // Template#: 674, Serial#: 2932
    /**
     * Pseudo-external assembler syntax: {@code jnbe  }<i>label</i>
     */
    // Template#: 675, Serial#: 2933
    /**
     * Pseudo-external assembler syntax: {@code seto  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 676, Serial#: 2936
    public void m_seto(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_seto(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2936; }
            @Override
            protected void assemble() throws AssemblyException {
                m_seto(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code seto  }<i>label</i>
     */
    // Template#: 677, Serial#: 2937
    public void m_seto(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_seto(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2937; }
            @Override
            protected void assemble() throws AssemblyException {
                m_seto(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setno  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 678, Serial#: 2945
    public void m_setno(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setno(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2945; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setno(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setno  }<i>label</i>
     */
    // Template#: 679, Serial#: 2946
    public void m_setno(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setno(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2946; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setno(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 680, Serial#: 2954
    public void m_setb(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setb(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2954; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setb(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setb  }<i>label</i>
     */
    // Template#: 681, Serial#: 2955
    public void m_setb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setb(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2955; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setb(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnb  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 682, Serial#: 2963
    public void m_setnb(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnb(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2963; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnb(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnb  }<i>label</i>
     */
    // Template#: 683, Serial#: 2964
    public void m_setnb(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnb(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2964; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnb(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setz  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 684, Serial#: 2972
    public void m_setz(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setz(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2972; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setz(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setz  }<i>label</i>
     */
    // Template#: 685, Serial#: 2973
    public void m_setz(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setz(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2973; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setz(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnz  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 686, Serial#: 2981
    public void m_setnz(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnz(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2981; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnz(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnz  }<i>label</i>
     */
    // Template#: 687, Serial#: 2982
    public void m_setnz(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnz(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2982; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnz(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setbe  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 688, Serial#: 2990
    public void m_setbe(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setbe(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2990; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setbe(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setbe  }<i>label</i>
     */
    // Template#: 689, Serial#: 2991
    public void m_setbe(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setbe(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2991; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setbe(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnbe  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 690, Serial#: 2999
    public void m_setnbe(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnbe(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 2999; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnbe(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnbe  }<i>label</i>
     */
    // Template#: 691, Serial#: 3000
    public void m_setnbe(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnbe(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3000; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnbe(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 692, Serial#: 3011
    public void m_bt(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bt(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3011; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bt(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt  }<i>label</i>, <i>source</i>
     */
    // Template#: 693, Serial#: 3012
    public void m_bt(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bt(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3012; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bt(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 694, Serial#: 3020
    public void m_bt(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bt(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3020; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bt(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt  }<i>label</i>, <i>source</i>
     */
    // Template#: 695, Serial#: 3021
    public void m_bt(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bt(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3021; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bt(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 696, Serial#: 3029
    public void m_shld(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shld(placeHolder, index, scale, source, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3029; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shld(labelAddressAsInt(), index, scale, source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 697, Serial#: 3030
    public void m_shld(final Label label, final IA32GeneralRegister32 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shld(placeHolder, source, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3030; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shld(labelAddressAsInt(), source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 698, Serial#: 3038
    public void m_shld(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shld(placeHolder, index, scale, source, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3038; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shld(labelAddressAsInt(), index, scale, source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 699, Serial#: 3039
    public void m_shld(final Label label, final IA32GeneralRegister16 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shld(placeHolder, source, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3039; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shld(labelAddressAsInt(), source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 700, Serial#: 3047
    public void m_shld_CL(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shld_CL(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3047; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shld_CL(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>source</i>
     */
    // Template#: 701, Serial#: 3048
    public void m_shld_CL(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shld_CL(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3048; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shld_CL(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 702, Serial#: 3056
    public void m_shld_CL(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shld_CL(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3056; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shld_CL(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shld  }<i>label</i>, <i>source</i>
     */
    // Template#: 703, Serial#: 3057
    public void m_shld_CL(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shld_CL(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3057; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shld_CL(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 704, Serial#: 3065
    public void m_cmpxchg(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpxchg(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3065; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpxchg(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 705, Serial#: 3066
    public void m_cmpxchg(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpxchg(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3066; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpxchg(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 706, Serial#: 3074
    public void m_cmpxchg(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpxchg(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3074; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpxchg(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 707, Serial#: 3075
    public void m_cmpxchg(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpxchg(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3075; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpxchg(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 708, Serial#: 3083
    public void m_cmpxchg(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpxchg(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3083; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpxchg(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg  }<i>label</i>, <i>source</i>
     */
    // Template#: 709, Serial#: 3084
    public void m_cmpxchg(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpxchg(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3084; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpxchg(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lss  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 710, Serial#: 3092
    public void m_lss(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lss(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3092; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lss(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 711, Serial#: 3093
    public void m_lss(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lss(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3093; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lss(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lss  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 712, Serial#: 3100
    public void m_lss(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lss(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3100; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lss(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lss  }<i>destination</i>, <i>label</i>
     */
    // Template#: 713, Serial#: 3101
    public void m_lss(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lss(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3101; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lss(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btr  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 714, Serial#: 3108
    public void m_btr(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btr(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3108; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btr(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btr  }<i>label</i>, <i>source</i>
     */
    // Template#: 715, Serial#: 3109
    public void m_btr(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btr(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3109; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btr(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btr  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 716, Serial#: 3117
    public void m_btr(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btr(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3117; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btr(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btr  }<i>label</i>, <i>source</i>
     */
    // Template#: 717, Serial#: 3118
    public void m_btr(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btr(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3118; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btr(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lfs  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 718, Serial#: 3126
    public void m_lfs(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lfs(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3126; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lfs(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lfs  }<i>destination</i>, <i>label</i>
     */
    // Template#: 719, Serial#: 3127
    public void m_lfs(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lfs(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3127; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lfs(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lfs  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 720, Serial#: 3134
    public void m_lfs(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lfs(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3134; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lfs(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lfs  }<i>destination</i>, <i>label</i>
     */
    // Template#: 721, Serial#: 3135
    public void m_lfs(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lfs(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3135; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lfs(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lgs  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 722, Serial#: 3142
    public void m_lgs(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lgs(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3142; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lgs(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lgs  }<i>destination</i>, <i>label</i>
     */
    // Template#: 723, Serial#: 3143
    public void m_lgs(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lgs(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3143; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lgs(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lgs  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 724, Serial#: 3150
    public void m_lgs(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lgs(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3150; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lgs(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code lgs  }<i>destination</i>, <i>label</i>
     */
    // Template#: 725, Serial#: 3151
    public void m_lgs(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_lgs(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3151; }
            @Override
            protected void assemble() throws AssemblyException {
                m_lgs(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzx  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 726, Serial#: 3158
    public void m_movzxb(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movzxb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3158; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movzxb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzx  }<i>destination</i>, <i>label</i>
     */
    // Template#: 727, Serial#: 3159
    public void m_movzxb(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movzxb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3159; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movzxb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzx  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 728, Serial#: 3167
    public void m_movzxb(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movzxb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3167; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movzxb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzx  }<i>destination</i>, <i>label</i>
     */
    // Template#: 729, Serial#: 3168
    public void m_movzxb(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movzxb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3168; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movzxb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzxw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 730, Serial#: 3176
    public void m_movzxw(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movzxw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3176; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movzxw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzxw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 731, Serial#: 3177
    public void m_movzxw(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movzxw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3177; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movzxw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzxw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 732, Serial#: 3185
    public void m_movzxw(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movzxw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3185; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movzxw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movzxw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 733, Serial#: 3186
    public void m_movzxw(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movzxw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3186; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movzxw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xadd  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 734, Serial#: 3194
    public void m_xadd(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xadd(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3194; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xadd(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xadd  }<i>label</i>, <i>source</i>
     */
    // Template#: 735, Serial#: 3195
    public void m_xadd(final Label label, final IA32GeneralRegister8 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xadd(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3195; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xadd(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xadd  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 736, Serial#: 3203
    public void m_xadd(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xadd(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3203; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xadd(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xadd  }<i>label</i>, <i>source</i>
     */
    // Template#: 737, Serial#: 3204
    public void m_xadd(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xadd(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3204; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xadd(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xadd  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 738, Serial#: 3212
    public void m_xadd(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xadd(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3212; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xadd(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code xadd  }<i>label</i>, <i>source</i>
     */
    // Template#: 739, Serial#: 3213
    public void m_xadd(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_xadd(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3213; }
            @Override
            protected void assemble() throws AssemblyException {
                m_xadd(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg8b  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 740, Serial#: 3221
    public void m_cmpxchg8b(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpxchg8b(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3221; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpxchg8b(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmpxchg8b  }<i>label</i>
     */
    // Template#: 741, Serial#: 3222
    public void m_cmpxchg8b(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmpxchg8b(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3222; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmpxchg8b(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrlw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 742, Serial#: 3229
    public void m_psrlw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psrlw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3229; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psrlw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrlw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 743, Serial#: 3230
    public void m_psrlw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psrlw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3230; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psrlw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrld  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 744, Serial#: 3238
    public void m_psrld(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psrld(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3238; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psrld(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrld  }<i>destination</i>, <i>label</i>
     */
    // Template#: 745, Serial#: 3239
    public void m_psrld(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psrld(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3239; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psrld(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrlq  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 746, Serial#: 3247
    public void m_psrlq(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psrlq(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3247; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psrlq(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrlq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 747, Serial#: 3248
    public void m_psrlq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psrlq(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3248; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psrlq(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmullw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 748, Serial#: 3256
    public void m_pmullw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pmullw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3256; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pmullw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmullw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 749, Serial#: 3257
    public void m_pmullw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pmullw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3257; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pmullw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psraw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 750, Serial#: 3265
    public void m_psraw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psraw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3265; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psraw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psraw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 751, Serial#: 3266
    public void m_psraw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psraw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3266; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psraw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrad  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 752, Serial#: 3274
    public void m_psrad(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psrad(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3274; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psrad(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psrad  }<i>destination</i>, <i>label</i>
     */
    // Template#: 753, Serial#: 3275
    public void m_psrad(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psrad(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3275; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psrad(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmulhw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 754, Serial#: 3283
    public void m_pmulhw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pmulhw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3283; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pmulhw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmulhw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 755, Serial#: 3284
    public void m_pmulhw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pmulhw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3284; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pmulhw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psllw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 756, Serial#: 3292
    public void m_psllw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psllw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3292; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psllw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psllw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 757, Serial#: 3293
    public void m_psllw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psllw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3293; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psllw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pslld  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 758, Serial#: 3301
    public void m_pslld(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pslld(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3301; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pslld(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pslld  }<i>destination</i>, <i>label</i>
     */
    // Template#: 759, Serial#: 3302
    public void m_pslld(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pslld(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3302; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pslld(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psllq  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 760, Serial#: 3310
    public void m_psllq(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psllq(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3310; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psllq(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psllq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 761, Serial#: 3311
    public void m_psllq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psllq(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3311; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psllq(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmaddwd  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 762, Serial#: 3319
    public void m_pmaddwd(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pmaddwd(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3319; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pmaddwd(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pmaddwd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 763, Serial#: 3320
    public void m_pmaddwd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pmaddwd(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3320; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pmaddwd(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovs  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 764, Serial#: 3331
    public void m_cmovs(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovs(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3331; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovs(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovs  }<i>destination</i>, <i>label</i>
     */
    // Template#: 765, Serial#: 3332
    public void m_cmovs(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovs(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3332; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovs(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovs  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 766, Serial#: 3340
    public void m_cmovs(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovs(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3340; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovs(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovs  }<i>destination</i>, <i>label</i>
     */
    // Template#: 767, Serial#: 3341
    public void m_cmovs(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovs(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3341; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovs(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovns  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 768, Serial#: 3349
    public void m_cmovns(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovns(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3349; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovns(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovns  }<i>destination</i>, <i>label</i>
     */
    // Template#: 769, Serial#: 3350
    public void m_cmovns(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovns(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3350; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovns(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovns  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 770, Serial#: 3358
    public void m_cmovns(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovns(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3358; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovns(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovns  }<i>destination</i>, <i>label</i>
     */
    // Template#: 771, Serial#: 3359
    public void m_cmovns(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovns(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3359; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovns(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovp  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 772, Serial#: 3367
    public void m_cmovp(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovp(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3367; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovp(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 773, Serial#: 3368
    public void m_cmovp(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovp(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3368; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovp(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovp  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 774, Serial#: 3376
    public void m_cmovp(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovp(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3376; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovp(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 775, Serial#: 3377
    public void m_cmovp(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovp(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3377; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovp(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnp  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 776, Serial#: 3385
    public void m_cmovnp(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnp(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3385; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnp(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 777, Serial#: 3386
    public void m_cmovnp(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnp(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3386; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnp(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnp  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 778, Serial#: 3394
    public void m_cmovnp(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnp(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3394; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnp(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnp  }<i>destination</i>, <i>label</i>
     */
    // Template#: 779, Serial#: 3395
    public void m_cmovnp(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnp(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3395; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnp(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovl  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 780, Serial#: 3403
    public void m_cmovl(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovl(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3403; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovl(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 781, Serial#: 3404
    public void m_cmovl(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovl(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3404; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovl(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovl  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 782, Serial#: 3412
    public void m_cmovl(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovl(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3412; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovl(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 783, Serial#: 3413
    public void m_cmovl(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovl(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3413; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovl(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnl  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 784, Serial#: 3421
    public void m_cmovnl(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnl(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3421; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnl(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 785, Serial#: 3422
    public void m_cmovnl(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnl(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3422; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnl(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnl  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 786, Serial#: 3430
    public void m_cmovnl(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnl(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3430; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnl(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnl  }<i>destination</i>, <i>label</i>
     */
    // Template#: 787, Serial#: 3431
    public void m_cmovnl(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnl(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3431; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnl(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovle  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 788, Serial#: 3439
    public void m_cmovle(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovle(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3439; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovle(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovle  }<i>destination</i>, <i>label</i>
     */
    // Template#: 789, Serial#: 3440
    public void m_cmovle(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovle(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3440; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovle(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovle  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 790, Serial#: 3448
    public void m_cmovle(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovle(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3448; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovle(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovle  }<i>destination</i>, <i>label</i>
     */
    // Template#: 791, Serial#: 3449
    public void m_cmovle(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovle(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3449; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovle(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnle  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 792, Serial#: 3457
    public void m_cmovnle(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnle(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3457; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnle(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnle  }<i>destination</i>, <i>label</i>
     */
    // Template#: 793, Serial#: 3458
    public void m_cmovnle(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnle(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3458; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnle(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnle  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 794, Serial#: 3466
    public void m_cmovnle(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnle(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3466; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnle(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code cmovnle  }<i>destination</i>, <i>label</i>
     */
    // Template#: 795, Serial#: 3467
    public void m_cmovnle(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_cmovnle(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3467; }
            @Override
            protected void assemble() throws AssemblyException {
                m_cmovnle(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhbw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 796, Serial#: 3475
    public void m_punpckhbw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpckhbw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3475; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpckhbw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhbw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 797, Serial#: 3476
    public void m_punpckhbw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpckhbw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3476; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpckhbw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhwd  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 798, Serial#: 3484
    public void m_punpckhwd(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpckhwd(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3484; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpckhwd(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhwd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 799, Serial#: 3485
    public void m_punpckhwd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpckhwd(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3485; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpckhwd(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhdq  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 800, Serial#: 3493
    public void m_punpckhdq(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpckhdq(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3493; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpckhdq(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code punpckhdq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 801, Serial#: 3494
    public void m_punpckhdq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_punpckhdq(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3494; }
            @Override
            protected void assemble() throws AssemblyException {
                m_punpckhdq(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packssdw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 802, Serial#: 3502
    public void m_packssdw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_packssdw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3502; }
            @Override
            protected void assemble() throws AssemblyException {
                m_packssdw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code packssdw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 803, Serial#: 3503
    public void m_packssdw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_packssdw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3503; }
            @Override
            protected void assemble() throws AssemblyException {
                m_packssdw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movd  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 804, Serial#: 3511
    public void m_movd(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movd(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3511; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movd(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 805, Serial#: 3512
    public void m_movd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movd(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3512; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movd(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movq  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 806, Serial#: 3520
    public void m_movq(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movq(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3520; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movq(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movq  }<i>destination</i>, <i>label</i>
     */
    // Template#: 807, Serial#: 3521
    public void m_movq(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movq(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3521; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movq(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movd  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 808, Serial#: 3529
    public void m_movd(final Label label, final IA32IndexRegister32 index, final Scale scale, final MMXRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movd(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3529; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movd(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movd  }<i>label</i>, <i>source</i>
     */
    // Template#: 809, Serial#: 3530
    public void m_movd(final Label label, final MMXRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movd(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3530; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movd(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movq  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 810, Serial#: 3538
    public void m_movq(final Label label, final IA32IndexRegister32 index, final Scale scale, final MMXRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movq(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3538; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movq(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movq  }<i>label</i>, <i>source</i>
     */
    // Template#: 811, Serial#: 3539
    public void m_movq(final Label label, final MMXRegister source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movq(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3539; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movq(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code js  }<i>label</i>
     */
    // Template#: 812, Serial#: 3544
    /**
     * Pseudo-external assembler syntax: {@code js  }<i>label</i>
     */
    // Template#: 813, Serial#: 3545
    /**
     * Pseudo-external assembler syntax: {@code jns  }<i>label</i>
     */
    // Template#: 814, Serial#: 3546
    /**
     * Pseudo-external assembler syntax: {@code jns  }<i>label</i>
     */
    // Template#: 815, Serial#: 3547
    /**
     * Pseudo-external assembler syntax: {@code jp  }<i>label</i>
     */
    // Template#: 816, Serial#: 3548
    /**
     * Pseudo-external assembler syntax: {@code jp  }<i>label</i>
     */
    // Template#: 817, Serial#: 3549
    /**
     * Pseudo-external assembler syntax: {@code jnp  }<i>label</i>
     */
    // Template#: 818, Serial#: 3550
    /**
     * Pseudo-external assembler syntax: {@code jnp  }<i>label</i>
     */
    // Template#: 819, Serial#: 3551
    /**
     * Pseudo-external assembler syntax: {@code jl  }<i>label</i>
     */
    // Template#: 820, Serial#: 3552
    /**
     * Pseudo-external assembler syntax: {@code jl  }<i>label</i>
     */
    // Template#: 821, Serial#: 3553
    /**
     * Pseudo-external assembler syntax: {@code jnl  }<i>label</i>
     */
    // Template#: 822, Serial#: 3554
    /**
     * Pseudo-external assembler syntax: {@code jnl  }<i>label</i>
     */
    // Template#: 823, Serial#: 3555
    /**
     * Pseudo-external assembler syntax: {@code jle  }<i>label</i>
     */
    // Template#: 824, Serial#: 3556
    /**
     * Pseudo-external assembler syntax: {@code jle  }<i>label</i>
     */
    // Template#: 825, Serial#: 3557
    /**
     * Pseudo-external assembler syntax: {@code jnle  }<i>label</i>
     */
    // Template#: 826, Serial#: 3558
    /**
     * Pseudo-external assembler syntax: {@code jnle  }<i>label</i>
     */
    // Template#: 827, Serial#: 3559
    /**
     * Pseudo-external assembler syntax: {@code sets  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 828, Serial#: 3562
    public void m_sets(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sets(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3562; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sets(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code sets  }<i>label</i>
     */
    // Template#: 829, Serial#: 3563
    public void m_sets(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_sets(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3563; }
            @Override
            protected void assemble() throws AssemblyException {
                m_sets(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setns  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 830, Serial#: 3571
    public void m_setns(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setns(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3571; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setns(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setns  }<i>label</i>
     */
    // Template#: 831, Serial#: 3572
    public void m_setns(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setns(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3572; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setns(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setp  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 832, Serial#: 3580
    public void m_setp(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setp(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3580; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setp(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setp  }<i>label</i>
     */
    // Template#: 833, Serial#: 3581
    public void m_setp(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setp(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3581; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setp(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnp  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 834, Serial#: 3589
    public void m_setnp(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnp(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3589; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnp(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnp  }<i>label</i>
     */
    // Template#: 835, Serial#: 3590
    public void m_setnp(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnp(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3590; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnp(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 836, Serial#: 3598
    public void m_setl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3598; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setl  }<i>label</i>
     */
    // Template#: 837, Serial#: 3599
    public void m_setl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3599; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnl  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 838, Serial#: 3607
    public void m_setnl(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnl(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3607; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnl(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnl  }<i>label</i>
     */
    // Template#: 839, Serial#: 3608
    public void m_setnl(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnl(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3608; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnl(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setle  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 840, Serial#: 3616
    public void m_setle(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setle(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3616; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setle(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setle  }<i>label</i>
     */
    // Template#: 841, Serial#: 3617
    public void m_setle(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setle(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3617; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setle(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnle  }<i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 842, Serial#: 3625
    public void m_setnle(final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnle(placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3625; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnle(labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code setnle  }<i>label</i>
     */
    // Template#: 843, Serial#: 3626
    public void m_setnle(final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_setnle(placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3626; }
            @Override
            protected void assemble() throws AssemblyException {
                m_setnle(labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bts  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 844, Serial#: 3637
    public void m_bts(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bts(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3637; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bts(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bts  }<i>label</i>, <i>source</i>
     */
    // Template#: 845, Serial#: 3638
    public void m_bts(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bts(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3638; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bts(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bts  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 846, Serial#: 3646
    public void m_bts(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bts(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3646; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bts(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bts  }<i>label</i>, <i>source</i>
     */
    // Template#: 847, Serial#: 3647
    public void m_bts(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bts(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3647; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bts(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 848, Serial#: 3655
    public void m_shrd(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrd(placeHolder, index, scale, source, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3655; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrd(labelAddressAsInt(), index, scale, source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 849, Serial#: 3656
    public void m_shrd(final Label label, final IA32GeneralRegister32 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrd(placeHolder, source, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3656; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrd(labelAddressAsInt(), source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 850, Serial#: 3664
    public void m_shrd(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrd(placeHolder, index, scale, source, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3664; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrd(labelAddressAsInt(), index, scale, source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>source</i>, <i>imm8</i>
     */
    // Template#: 851, Serial#: 3665
    public void m_shrd(final Label label, final IA32GeneralRegister16 source, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrd(placeHolder, source, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3665; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrd(labelAddressAsInt(), source, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 852, Serial#: 3673
    public void m_shrd_CL(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrd_CL(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3673; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrd_CL(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>source</i>
     */
    // Template#: 853, Serial#: 3674
    public void m_shrd_CL(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrd_CL(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3674; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrd_CL(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 854, Serial#: 3682
    public void m_shrd_CL(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrd_CL(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3682; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrd_CL(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code shrd  }<i>label</i>, <i>source</i>
     */
    // Template#: 855, Serial#: 3683
    public void m_shrd_CL(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_shrd_CL(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3683; }
            @Override
            protected void assemble() throws AssemblyException {
                m_shrd_CL(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 856, Serial#: 3691
    public void m_imul(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3691; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>
     */
    // Template#: 857, Serial#: 3692
    public void m_imul(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3692; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 858, Serial#: 3700
    public void m_imul(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3700; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code imul  }<i>destination</i>, <i>label</i>
     */
    // Template#: 859, Serial#: 3701
    public void m_imul(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_imul(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3701; }
            @Override
            protected void assemble() throws AssemblyException {
                m_imul(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 860, Serial#: 3709
    public void m_bt(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bt(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3709; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bt(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 861, Serial#: 3710
    public void m_bt(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bt(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3710; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bt(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bts  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 862, Serial#: 3713
    public void m_bts(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bts(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3713; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bts(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bts  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 863, Serial#: 3714
    public void m_bts(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bts(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3714; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bts(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btr  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 864, Serial#: 3717
    public void m_btr(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btr(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3717; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btr(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btr  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 865, Serial#: 3718
    public void m_btr(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btr(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3718; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btr(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btc  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>imm8</i>
     */
    // Template#: 866, Serial#: 3721
    public void m_btc(final Label label, final IA32IndexRegister32 index, final Scale scale, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btc(placeHolder, index, scale, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3721; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btc(labelAddressAsInt(), index, scale, imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btc  }<i>label</i>, <i>imm8</i>
     */
    // Template#: 867, Serial#: 3722
    public void m_btc(final Label label, final byte imm8) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btc(placeHolder, imm8);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3722; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btc(labelAddressAsInt(), imm8);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btc  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 868, Serial#: 3749
    public void m_btc(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btc(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3749; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btc(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btc  }<i>label</i>, <i>source</i>
     */
    // Template#: 869, Serial#: 3750
    public void m_btc(final Label label, final IA32GeneralRegister32 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btc(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3750; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btc(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btc  }<i>label</i>, <i>index</i>, <i>scale</i>, <i>source</i>
     */
    // Template#: 870, Serial#: 3758
    public void m_btc(final Label label, final IA32IndexRegister32 index, final Scale scale, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btc(placeHolder, index, scale, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3758; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btc(labelAddressAsInt(), index, scale, source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btc  }<i>label</i>, <i>source</i>
     */
    // Template#: 871, Serial#: 3759
    public void m_btc(final Label label, final IA32GeneralRegister16 source) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_btc(placeHolder, source);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3759; }
            @Override
            protected void assemble() throws AssemblyException {
                m_btc(labelAddressAsInt(), source);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsf  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 872, Serial#: 3767
    public void m_bsf(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bsf(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3767; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bsf(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsf  }<i>destination</i>, <i>label</i>
     */
    // Template#: 873, Serial#: 3768
    public void m_bsf(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bsf(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3768; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bsf(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsf  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 874, Serial#: 3776
    public void m_bsf(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bsf(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3776; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bsf(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsf  }<i>destination</i>, <i>label</i>
     */
    // Template#: 875, Serial#: 3777
    public void m_bsf(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bsf(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3777; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bsf(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsr  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 876, Serial#: 3785
    public void m_bsr(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bsr(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3785; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bsr(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsr  }<i>destination</i>, <i>label</i>
     */
    // Template#: 877, Serial#: 3786
    public void m_bsr(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bsr(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3786; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bsr(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsr  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 878, Serial#: 3794
    public void m_bsr(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bsr(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3794; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bsr(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsr  }<i>destination</i>, <i>label</i>
     */
    // Template#: 879, Serial#: 3795
    public void m_bsr(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_bsr(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3795; }
            @Override
            protected void assemble() throws AssemblyException {
                m_bsr(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsx  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 880, Serial#: 3803
    public void m_movsxb(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movsxb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3803; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movsxb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsx  }<i>destination</i>, <i>label</i>
     */
    // Template#: 881, Serial#: 3804
    public void m_movsxb(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movsxb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3804; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movsxb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsx  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 882, Serial#: 3812
    public void m_movsxb(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movsxb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3812; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movsxb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsx  }<i>destination</i>, <i>label</i>
     */
    // Template#: 883, Serial#: 3813
    public void m_movsxb(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movsxb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3813; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movsxb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsxw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 884, Serial#: 3821
    public void m_movsxw(final IA32GeneralRegister32 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movsxw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3821; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movsxw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsxw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 885, Serial#: 3822
    public void m_movsxw(final IA32GeneralRegister32 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movsxw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3822; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movsxw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsxw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 886, Serial#: 3830
    public void m_movsxw(final IA32GeneralRegister16 destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movsxw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3830; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movsxw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code movsxw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 887, Serial#: 3831
    public void m_movsxw(final IA32GeneralRegister16 destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_movsxw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3831; }
            @Override
            protected void assemble() throws AssemblyException {
                m_movsxw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubusb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 888, Serial#: 3840
    public void m_psubusb(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubusb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3840; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubusb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubusb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 889, Serial#: 3841
    public void m_psubusb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubusb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3841; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubusb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubusw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 890, Serial#: 3849
    public void m_psubusw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubusw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3849; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubusw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubusw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 891, Serial#: 3850
    public void m_psubusw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubusw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3850; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubusw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pand  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 892, Serial#: 3858
    public void m_pand(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pand(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3858; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pand(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pand  }<i>destination</i>, <i>label</i>
     */
    // Template#: 893, Serial#: 3859
    public void m_pand(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pand(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3859; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pand(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddusb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 894, Serial#: 3867
    public void m_paddusb(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddusb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3867; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddusb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddusb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 895, Serial#: 3868
    public void m_paddusb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddusb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3868; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddusb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddusw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 896, Serial#: 3876
    public void m_paddusw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddusw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3876; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddusw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddusw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 897, Serial#: 3877
    public void m_paddusw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddusw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3877; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddusw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pandn  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 898, Serial#: 3885
    public void m_pandn(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pandn(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3885; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pandn(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pandn  }<i>destination</i>, <i>label</i>
     */
    // Template#: 899, Serial#: 3886
    public void m_pandn(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pandn(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3886; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pandn(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubsb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 900, Serial#: 3894
    public void m_psubsb(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubsb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3894; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubsb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubsb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 901, Serial#: 3895
    public void m_psubsb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubsb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3895; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubsb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubsw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 902, Serial#: 3903
    public void m_psubsw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubsw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3903; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubsw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubsw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 903, Serial#: 3904
    public void m_psubsw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubsw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3904; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubsw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code por  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 904, Serial#: 3912
    public void m_por(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_por(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3912; }
            @Override
            protected void assemble() throws AssemblyException {
                m_por(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code por  }<i>destination</i>, <i>label</i>
     */
    // Template#: 905, Serial#: 3913
    public void m_por(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_por(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3913; }
            @Override
            protected void assemble() throws AssemblyException {
                m_por(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddsb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 906, Serial#: 3921
    public void m_paddsb(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddsb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3921; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddsb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddsb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 907, Serial#: 3922
    public void m_paddsb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddsb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3922; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddsb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddsw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 908, Serial#: 3930
    public void m_paddsw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddsw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3930; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddsw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddsw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 909, Serial#: 3931
    public void m_paddsw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddsw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3931; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddsw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pxor  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 910, Serial#: 3939
    public void m_pxor(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pxor(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3939; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pxor(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code pxor  }<i>destination</i>, <i>label</i>
     */
    // Template#: 911, Serial#: 3940
    public void m_pxor(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_pxor(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3940; }
            @Override
            protected void assemble() throws AssemblyException {
                m_pxor(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 912, Serial#: 3948
    public void m_psubb(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3948; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 913, Serial#: 3949
    public void m_psubb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3949; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 914, Serial#: 3957
    public void m_psubw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3957; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 915, Serial#: 3958
    public void m_psubw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3958; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubd  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 916, Serial#: 3966
    public void m_psubd(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubd(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3966; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubd(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code psubd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 917, Serial#: 3967
    public void m_psubd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_psubd(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3967; }
            @Override
            protected void assemble() throws AssemblyException {
                m_psubd(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddb  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 918, Serial#: 3975
    public void m_paddb(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddb(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3975; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddb(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddb  }<i>destination</i>, <i>label</i>
     */
    // Template#: 919, Serial#: 3976
    public void m_paddb(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddb(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3976; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddb(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddw  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 920, Serial#: 3984
    public void m_paddw(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddw(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3984; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddw(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddw  }<i>destination</i>, <i>label</i>
     */
    // Template#: 921, Serial#: 3985
    public void m_paddw(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddw(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3985; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddw(destination, labelAddressAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddd  }<i>destination</i>, <i>label</i>, <i>index</i>, <i>scale</i>
     */
    // Template#: 922, Serial#: 3993
    public void m_paddd(final MMXRegister destination, final Label label, final IA32IndexRegister32 index, final Scale scale) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddd(destination, placeHolder, index, scale);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3993; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddd(destination, labelAddressAsInt(), index, scale);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code paddd  }<i>destination</i>, <i>label</i>
     */
    // Template#: 923, Serial#: 3994
    public void m_paddd(final MMXRegister destination, final Label label) {
        final int startOffset = currentOffset();
        final int placeHolder = 0;
        m_paddd(destination, placeHolder);
        new LabelAddressInstruction(this, startOffset, currentOffset(), label) {
            @Override
            protected int templateSerial() { return 3994; }
            @Override
            protected void assemble() throws AssemblyException {
                m_paddd(destination, labelAddressAsInt());
            }
        };
    }

}
// END GENERATED CONTENT
