/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5fc47e8b-c106-44f7-bc2b-328ec5ebabcc*/
// START GENERATED CONTENT

package com.sun.max.asm.sparc;

import com.sun.max.asm.*;

public abstract class SPARCLabelAssembler extends SPARCRawAssembler {

    protected SPARCLabelAssembler() {
        super();
    }

    /**
     * Pseudo-external assembler syntax: {@code brz{,a}{,pn|,pt}  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 1, Serial#: 190
    public void brz(final AnnulBit a, final BranchPredictionBit p, final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 190; }
            @Override
            protected void assemble() throws AssemblyException {
                brz(a, p, rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brlez{,a}{,pn|,pt}  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 2, Serial#: 191
    public void brlez(final AnnulBit a, final BranchPredictionBit p, final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 191; }
            @Override
            protected void assemble() throws AssemblyException {
                brlez(a, p, rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brlz{,a}{,pn|,pt}  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 3, Serial#: 192
    public void brlz(final AnnulBit a, final BranchPredictionBit p, final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 192; }
            @Override
            protected void assemble() throws AssemblyException {
                brlz(a, p, rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brnz{,a}{,pn|,pt}  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 4, Serial#: 193
    public void brnz(final AnnulBit a, final BranchPredictionBit p, final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 193; }
            @Override
            protected void assemble() throws AssemblyException {
                brnz(a, p, rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brgz{,a}{,pn|,pt}  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 5, Serial#: 194
    public void brgz(final AnnulBit a, final BranchPredictionBit p, final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 194; }
            @Override
            protected void assemble() throws AssemblyException {
                brgz(a, p, rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brgez{,a}{,pn|,pt}  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 6, Serial#: 195
    public void brgez(final AnnulBit a, final BranchPredictionBit p, final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 195; }
            @Override
            protected void assemble() throws AssemblyException {
                brgez(a, p, rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brz  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 7, Serial#: 196
    public void brz(final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 196; }
            @Override
            protected void assemble() throws AssemblyException {
                brz(rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brlez  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 8, Serial#: 197
    public void brlez(final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 197; }
            @Override
            protected void assemble() throws AssemblyException {
                brlez(rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brlz  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 9, Serial#: 198
    public void brlz(final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 198; }
            @Override
            protected void assemble() throws AssemblyException {
                brlz(rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brnz  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 10, Serial#: 199
    public void brnz(final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 199; }
            @Override
            protected void assemble() throws AssemblyException {
                brnz(rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brgz  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 11, Serial#: 200
    public void brgz(final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 200; }
            @Override
            protected void assemble() throws AssemblyException {
                brgz(rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code brgez  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 12, Serial#: 201
    public void brgez(final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 201; }
            @Override
            protected void assemble() throws AssemblyException {
                brgez(rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code br[z|lez|lz|nz|gz|gez]{,a}{,pn|,pt}  }<i>rs1</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-131072 <= label && label <= 131068) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.3"
     */
    // Template#: 13, Serial#: 202
    public void br(final BPr cond, final AnnulBit a, final BranchPredictionBit p, final GPR rs1, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 202; }
            @Override
            protected void assemble() throws AssemblyException {
                br(cond, a, p, rs1, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fba{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 14, Serial#: 203
    public void fba(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 203; }
            @Override
            protected void assemble() throws AssemblyException {
                fba(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbn{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 15, Serial#: 204
    public void fbn(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 204; }
            @Override
            protected void assemble() throws AssemblyException {
                fbn(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbu{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 16, Serial#: 205
    public void fbu(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 205; }
            @Override
            protected void assemble() throws AssemblyException {
                fbu(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbg{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 17, Serial#: 206
    public void fbg(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 206; }
            @Override
            protected void assemble() throws AssemblyException {
                fbg(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbug{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 18, Serial#: 207
    public void fbug(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 207; }
            @Override
            protected void assemble() throws AssemblyException {
                fbug(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbl{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 19, Serial#: 208
    public void fbl(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 208; }
            @Override
            protected void assemble() throws AssemblyException {
                fbl(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbul{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 20, Serial#: 209
    public void fbul(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 209; }
            @Override
            protected void assemble() throws AssemblyException {
                fbul(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fblg{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 21, Serial#: 210
    public void fblg(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 210; }
            @Override
            protected void assemble() throws AssemblyException {
                fblg(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbne{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 22, Serial#: 211
    public void fbne(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 211; }
            @Override
            protected void assemble() throws AssemblyException {
                fbne(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbe{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 23, Serial#: 212
    public void fbe(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 212; }
            @Override
            protected void assemble() throws AssemblyException {
                fbe(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbue{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 24, Serial#: 213
    public void fbue(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 213; }
            @Override
            protected void assemble() throws AssemblyException {
                fbue(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbge{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 25, Serial#: 214
    public void fbge(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 214; }
            @Override
            protected void assemble() throws AssemblyException {
                fbge(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbuge{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 26, Serial#: 215
    public void fbuge(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 215; }
            @Override
            protected void assemble() throws AssemblyException {
                fbuge(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fble{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 27, Serial#: 216
    public void fble(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 216; }
            @Override
            protected void assemble() throws AssemblyException {
                fble(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbule{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 28, Serial#: 217
    public void fbule(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 217; }
            @Override
            protected void assemble() throws AssemblyException {
                fbule(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbo{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 29, Serial#: 218
    public void fbo(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 218; }
            @Override
            protected void assemble() throws AssemblyException {
                fbo(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fba  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 30, Serial#: 219
    public void fba(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 219; }
            @Override
            protected void assemble() throws AssemblyException {
                fba(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbn  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 31, Serial#: 220
    public void fbn(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 220; }
            @Override
            protected void assemble() throws AssemblyException {
                fbn(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbu  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 32, Serial#: 221
    public void fbu(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 221; }
            @Override
            protected void assemble() throws AssemblyException {
                fbu(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbg  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 33, Serial#: 222
    public void fbg(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 222; }
            @Override
            protected void assemble() throws AssemblyException {
                fbg(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbug  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 34, Serial#: 223
    public void fbug(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 223; }
            @Override
            protected void assemble() throws AssemblyException {
                fbug(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbl  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 35, Serial#: 224
    public void fbl(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 224; }
            @Override
            protected void assemble() throws AssemblyException {
                fbl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbul  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 36, Serial#: 225
    public void fbul(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 225; }
            @Override
            protected void assemble() throws AssemblyException {
                fbul(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fblg  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 37, Serial#: 226
    public void fblg(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 226; }
            @Override
            protected void assemble() throws AssemblyException {
                fblg(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbne  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 38, Serial#: 227
    public void fbne(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 227; }
            @Override
            protected void assemble() throws AssemblyException {
                fbne(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbe  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 39, Serial#: 228
    public void fbe(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 228; }
            @Override
            protected void assemble() throws AssemblyException {
                fbe(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbue  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 40, Serial#: 229
    public void fbue(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 229; }
            @Override
            protected void assemble() throws AssemblyException {
                fbue(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbge  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 41, Serial#: 230
    public void fbge(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 230; }
            @Override
            protected void assemble() throws AssemblyException {
                fbge(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbuge  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 42, Serial#: 231
    public void fbuge(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 231; }
            @Override
            protected void assemble() throws AssemblyException {
                fbuge(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fble  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 43, Serial#: 232
    public void fble(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 232; }
            @Override
            protected void assemble() throws AssemblyException {
                fble(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbule  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 44, Serial#: 233
    public void fbule(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 233; }
            @Override
            protected void assemble() throws AssemblyException {
                fbule(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbo  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 45, Serial#: 234
    public void fbo(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 234; }
            @Override
            protected void assemble() throws AssemblyException {
                fbo(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fb[a|n|u|g|ug|l|ul|lg|ne|e|ue|ge|uge|le|ule|o]{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.4"
     */
    // Template#: 46, Serial#: 235
    public void fb(final FBfcc cond, final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 235; }
            @Override
            protected void assemble() throws AssemblyException {
                fb(cond, a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fba{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 47, Serial#: 236
    public void fba(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 236; }
            @Override
            protected void assemble() throws AssemblyException {
                fba(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbn{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 48, Serial#: 237
    public void fbn(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 237; }
            @Override
            protected void assemble() throws AssemblyException {
                fbn(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbu{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 49, Serial#: 238
    public void fbu(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 238; }
            @Override
            protected void assemble() throws AssemblyException {
                fbu(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbg{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 50, Serial#: 239
    public void fbg(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 239; }
            @Override
            protected void assemble() throws AssemblyException {
                fbg(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbug{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 51, Serial#: 240
    public void fbug(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 240; }
            @Override
            protected void assemble() throws AssemblyException {
                fbug(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbl{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 52, Serial#: 241
    public void fbl(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 241; }
            @Override
            protected void assemble() throws AssemblyException {
                fbl(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbul{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 53, Serial#: 242
    public void fbul(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 242; }
            @Override
            protected void assemble() throws AssemblyException {
                fbul(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fblg{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 54, Serial#: 243
    public void fblg(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 243; }
            @Override
            protected void assemble() throws AssemblyException {
                fblg(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbne{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 55, Serial#: 244
    public void fbne(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 244; }
            @Override
            protected void assemble() throws AssemblyException {
                fbne(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbe{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 56, Serial#: 245
    public void fbe(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 245; }
            @Override
            protected void assemble() throws AssemblyException {
                fbe(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbue{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 57, Serial#: 246
    public void fbue(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 246; }
            @Override
            protected void assemble() throws AssemblyException {
                fbue(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbge{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 58, Serial#: 247
    public void fbge(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 247; }
            @Override
            protected void assemble() throws AssemblyException {
                fbge(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbuge{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 59, Serial#: 248
    public void fbuge(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 248; }
            @Override
            protected void assemble() throws AssemblyException {
                fbuge(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fble{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 60, Serial#: 249
    public void fble(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 249; }
            @Override
            protected void assemble() throws AssemblyException {
                fble(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbule{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 61, Serial#: 250
    public void fbule(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 250; }
            @Override
            protected void assemble() throws AssemblyException {
                fbule(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbo{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 62, Serial#: 251
    public void fbo(final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 251; }
            @Override
            protected void assemble() throws AssemblyException {
                fbo(a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fba  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 63, Serial#: 252
    public void fba(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 252; }
            @Override
            protected void assemble() throws AssemblyException {
                fba(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbn  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 64, Serial#: 253
    public void fbn(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 253; }
            @Override
            protected void assemble() throws AssemblyException {
                fbn(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbu  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 65, Serial#: 254
    public void fbu(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 254; }
            @Override
            protected void assemble() throws AssemblyException {
                fbu(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbg  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 66, Serial#: 255
    public void fbg(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 255; }
            @Override
            protected void assemble() throws AssemblyException {
                fbg(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbug  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 67, Serial#: 256
    public void fbug(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 256; }
            @Override
            protected void assemble() throws AssemblyException {
                fbug(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbl  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 68, Serial#: 257
    public void fbl(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 257; }
            @Override
            protected void assemble() throws AssemblyException {
                fbl(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbul  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 69, Serial#: 258
    public void fbul(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 258; }
            @Override
            protected void assemble() throws AssemblyException {
                fbul(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fblg  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 70, Serial#: 259
    public void fblg(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 259; }
            @Override
            protected void assemble() throws AssemblyException {
                fblg(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbne  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 71, Serial#: 260
    public void fbne(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 260; }
            @Override
            protected void assemble() throws AssemblyException {
                fbne(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbe  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 72, Serial#: 261
    public void fbe(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 261; }
            @Override
            protected void assemble() throws AssemblyException {
                fbe(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbue  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 73, Serial#: 262
    public void fbue(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 262; }
            @Override
            protected void assemble() throws AssemblyException {
                fbue(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbge  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 74, Serial#: 263
    public void fbge(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 263; }
            @Override
            protected void assemble() throws AssemblyException {
                fbge(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbuge  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 75, Serial#: 264
    public void fbuge(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 264; }
            @Override
            protected void assemble() throws AssemblyException {
                fbuge(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fble  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 76, Serial#: 265
    public void fble(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 265; }
            @Override
            protected void assemble() throws AssemblyException {
                fble(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbule  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 77, Serial#: 266
    public void fbule(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 266; }
            @Override
            protected void assemble() throws AssemblyException {
                fbule(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fbo  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 78, Serial#: 267
    public void fbo(final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 267; }
            @Override
            protected void assemble() throws AssemblyException {
                fbo(n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code fb[a|n|u|g|ug|l|ul|lg|ne|e|ue|ge|uge|le|ule|o]{,a}{,pn|,pt}  }<i>n</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.5"
     */
    // Template#: 79, Serial#: 268
    public void fb(final FBfcc cond, final AnnulBit a, final BranchPredictionBit p, final FCCOperand n, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 268; }
            @Override
            protected void assemble() throws AssemblyException {
                fb(cond, a, p, n, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ba{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 80, Serial#: 269
    public void ba(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 269; }
            @Override
            protected void assemble() throws AssemblyException {
                ba(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bn{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 81, Serial#: 270
    public void bn(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 270; }
            @Override
            protected void assemble() throws AssemblyException {
                bn(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bne{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 82, Serial#: 271
    public void bne(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 271; }
            @Override
            protected void assemble() throws AssemblyException {
                bne(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code be{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 83, Serial#: 272
    public void be(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 272; }
            @Override
            protected void assemble() throws AssemblyException {
                be(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bg{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 84, Serial#: 273
    public void bg(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 273; }
            @Override
            protected void assemble() throws AssemblyException {
                bg(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ble{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 85, Serial#: 274
    public void ble(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 274; }
            @Override
            protected void assemble() throws AssemblyException {
                ble(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bge{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 86, Serial#: 275
    public void bge(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 275; }
            @Override
            protected void assemble() throws AssemblyException {
                bge(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bl{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 87, Serial#: 276
    public void bl(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 276; }
            @Override
            protected void assemble() throws AssemblyException {
                bl(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgu{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 88, Serial#: 277
    public void bgu(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 277; }
            @Override
            protected void assemble() throws AssemblyException {
                bgu(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bleu{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 89, Serial#: 278
    public void bleu(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 278; }
            @Override
            protected void assemble() throws AssemblyException {
                bleu(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bcc{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 90, Serial#: 279
    public void bcc(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 279; }
            @Override
            protected void assemble() throws AssemblyException {
                bcc(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bcs{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 91, Serial#: 280
    public void bcs(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 280; }
            @Override
            protected void assemble() throws AssemblyException {
                bcs(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bpos{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 92, Serial#: 281
    public void bpos(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 281; }
            @Override
            protected void assemble() throws AssemblyException {
                bpos(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bneg{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 93, Serial#: 282
    public void bneg(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 282; }
            @Override
            protected void assemble() throws AssemblyException {
                bneg(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bvc{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 94, Serial#: 283
    public void bvc(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 283; }
            @Override
            protected void assemble() throws AssemblyException {
                bvc(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bvs{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 95, Serial#: 284
    public void bvs(final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 284; }
            @Override
            protected void assemble() throws AssemblyException {
                bvs(a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ba  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 96, Serial#: 285
    public void ba(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 285; }
            @Override
            protected void assemble() throws AssemblyException {
                ba(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bn  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 97, Serial#: 286
    public void bn(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 286; }
            @Override
            protected void assemble() throws AssemblyException {
                bn(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bne  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 98, Serial#: 287
    public void bne(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 287; }
            @Override
            protected void assemble() throws AssemblyException {
                bne(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code be  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 99, Serial#: 288
    public void be(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 288; }
            @Override
            protected void assemble() throws AssemblyException {
                be(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bg  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 100, Serial#: 289
    public void bg(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 289; }
            @Override
            protected void assemble() throws AssemblyException {
                bg(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ble  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 101, Serial#: 290
    public void ble(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 290; }
            @Override
            protected void assemble() throws AssemblyException {
                ble(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bge  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 102, Serial#: 291
    public void bge(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 291; }
            @Override
            protected void assemble() throws AssemblyException {
                bge(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bl  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 103, Serial#: 292
    public void bl(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 292; }
            @Override
            protected void assemble() throws AssemblyException {
                bl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgu  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 104, Serial#: 293
    public void bgu(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 293; }
            @Override
            protected void assemble() throws AssemblyException {
                bgu(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bleu  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 105, Serial#: 294
    public void bleu(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 294; }
            @Override
            protected void assemble() throws AssemblyException {
                bleu(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bcc  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 106, Serial#: 295
    public void bcc(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 295; }
            @Override
            protected void assemble() throws AssemblyException {
                bcc(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bcs  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 107, Serial#: 296
    public void bcs(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 296; }
            @Override
            protected void assemble() throws AssemblyException {
                bcs(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bpos  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 108, Serial#: 297
    public void bpos(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 297; }
            @Override
            protected void assemble() throws AssemblyException {
                bpos(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bneg  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 109, Serial#: 298
    public void bneg(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 298; }
            @Override
            protected void assemble() throws AssemblyException {
                bneg(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bvc  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 110, Serial#: 299
    public void bvc(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 299; }
            @Override
            protected void assemble() throws AssemblyException {
                bvc(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bvs  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 111, Serial#: 300
    public void bvs(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 300; }
            @Override
            protected void assemble() throws AssemblyException {
                bvs(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code b[a|n|ne|e|g|le|ge|l|gu|leu|cc|cs|pos|neg|vc|vs]{,a}  }<i>label</i>
     * <p>
     * Constraint: {@code (-8388608 <= label && label <= 8388604) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.6"
     */
    // Template#: 112, Serial#: 301
    public void b(final Bicc cond, final AnnulBit a, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 301; }
            @Override
            protected void assemble() throws AssemblyException {
                b(cond, a, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ba{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 113, Serial#: 302
    public void ba(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 302; }
            @Override
            protected void assemble() throws AssemblyException {
                ba(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bn{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 114, Serial#: 303
    public void bn(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 303; }
            @Override
            protected void assemble() throws AssemblyException {
                bn(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bne{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 115, Serial#: 304
    public void bne(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 304; }
            @Override
            protected void assemble() throws AssemblyException {
                bne(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code be{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 116, Serial#: 305
    public void be(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 305; }
            @Override
            protected void assemble() throws AssemblyException {
                be(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bg{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 117, Serial#: 306
    public void bg(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 306; }
            @Override
            protected void assemble() throws AssemblyException {
                bg(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ble{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 118, Serial#: 307
    public void ble(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 307; }
            @Override
            protected void assemble() throws AssemblyException {
                ble(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bge{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 119, Serial#: 308
    public void bge(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 308; }
            @Override
            protected void assemble() throws AssemblyException {
                bge(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bl{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 120, Serial#: 309
    public void bl(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 309; }
            @Override
            protected void assemble() throws AssemblyException {
                bl(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgu{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 121, Serial#: 310
    public void bgu(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 310; }
            @Override
            protected void assemble() throws AssemblyException {
                bgu(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bleu{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 122, Serial#: 311
    public void bleu(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 311; }
            @Override
            protected void assemble() throws AssemblyException {
                bleu(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bcc{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 123, Serial#: 312
    public void bcc(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 312; }
            @Override
            protected void assemble() throws AssemblyException {
                bcc(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bcs{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 124, Serial#: 313
    public void bcs(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 313; }
            @Override
            protected void assemble() throws AssemblyException {
                bcs(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bpos{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 125, Serial#: 314
    public void bpos(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 314; }
            @Override
            protected void assemble() throws AssemblyException {
                bpos(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bneg{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 126, Serial#: 315
    public void bneg(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 315; }
            @Override
            protected void assemble() throws AssemblyException {
                bneg(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bvc{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 127, Serial#: 316
    public void bvc(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 316; }
            @Override
            protected void assemble() throws AssemblyException {
                bvc(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bvs{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 128, Serial#: 317
    public void bvs(final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 317; }
            @Override
            protected void assemble() throws AssemblyException {
                bvs(a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ba  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 129, Serial#: 318
    public void ba(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 318; }
            @Override
            protected void assemble() throws AssemblyException {
                ba(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bn  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 130, Serial#: 319
    public void bn(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 319; }
            @Override
            protected void assemble() throws AssemblyException {
                bn(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bne  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 131, Serial#: 320
    public void bne(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 320; }
            @Override
            protected void assemble() throws AssemblyException {
                bne(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code be  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 132, Serial#: 321
    public void be(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 321; }
            @Override
            protected void assemble() throws AssemblyException {
                be(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bg  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 133, Serial#: 322
    public void bg(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 322; }
            @Override
            protected void assemble() throws AssemblyException {
                bg(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ble  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 134, Serial#: 323
    public void ble(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 323; }
            @Override
            protected void assemble() throws AssemblyException {
                ble(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bge  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 135, Serial#: 324
    public void bge(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 324; }
            @Override
            protected void assemble() throws AssemblyException {
                bge(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bl  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 136, Serial#: 325
    public void bl(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 325; }
            @Override
            protected void assemble() throws AssemblyException {
                bl(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgu  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 137, Serial#: 326
    public void bgu(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 326; }
            @Override
            protected void assemble() throws AssemblyException {
                bgu(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bleu  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 138, Serial#: 327
    public void bleu(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 327; }
            @Override
            protected void assemble() throws AssemblyException {
                bleu(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bcc  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 139, Serial#: 328
    public void bcc(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 328; }
            @Override
            protected void assemble() throws AssemblyException {
                bcc(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bcs  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 140, Serial#: 329
    public void bcs(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 329; }
            @Override
            protected void assemble() throws AssemblyException {
                bcs(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bpos  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 141, Serial#: 330
    public void bpos(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 330; }
            @Override
            protected void assemble() throws AssemblyException {
                bpos(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bneg  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 142, Serial#: 331
    public void bneg(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 331; }
            @Override
            protected void assemble() throws AssemblyException {
                bneg(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bvc  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 143, Serial#: 332
    public void bvc(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 332; }
            @Override
            protected void assemble() throws AssemblyException {
                bvc(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bvs  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 144, Serial#: 333
    public void bvs(final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 333; }
            @Override
            protected void assemble() throws AssemblyException {
                bvs(i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code b[a|n|ne|e|g|le|ge|l|gu|leu|cc|cs|pos|neg|vc|vs]{,a}{,pn|,pt}  }<i>i_or_x_cc</i>, <i>label</i>
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.7"
     */
    // Template#: 145, Serial#: 334
    public void b(final Bicc cond, final AnnulBit a, final BranchPredictionBit p, final ICCOperand i_or_x_cc, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 334; }
            @Override
            protected void assemble() throws AssemblyException {
                b(cond, a, p, i_or_x_cc, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code call  }<i>label</i>
     * <p>
     * Constraint: {@code (-2147483648 <= label && label <= 2147483644) && ((label % 4) == 0)}<br />
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section A.8"
     */
    // Template#: 146, Serial#: 335
    public void call(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 335; }
            @Override
            protected void assemble() throws AssemblyException {
                call(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code iprefetch  }<i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code b(N, A, PT, XCC, label)}
     * <p>
     * Constraint: {@code (-1048576 <= label && label <= 1048572) && ((label % 4) == 0)}<br />
     *
     * @see #b(Bicc, AnnulBit, BranchPredictionBit, ICCOperand, Label)
     *
     * @see "<a href="http://developers.sun.com/solaris/articles/sparcv9.pdf">The SPARC Architecture Manual, Version 9</a> - Section G.3"
     */
    // Template#: 147, Serial#: 638
    public void iprefetch(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 638; }
            @Override
            protected void assemble() throws AssemblyException {
                iprefetch(labelOffsetAsInt());
            }
        };
    }

}
// END GENERATED CONTENT
