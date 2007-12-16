/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f854e221-d0d8-48d9-b773-3f03570511e2*/
// START GENERATED CONTENT

package jasm.ppc;

import jasm.AssemblyException;
import jasm.Label;
import jasm.LabelOffsetInstruction;

public abstract class PPCLabelAssembler extends PPCRawAssembler {

    protected PPCLabelAssembler() {
        super();
    }

    /**
     * Pseudo-external assembler syntax: {@code b  }<i>label</i>
     * <p>
     * Constraint: {@code (-33554432 <= li && li <= 33554428) && ((li % 4) == 0)}<br />
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section 2.4.1 [Book 1]"
     */
    // Template#: 1, Serial#: 1
    public void b(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 1; }
            @Override
            protected void assemble() throws AssemblyException {
                b(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ba  }<i>label</i>
     * <p>
     * Constraint: {@code (-33554432 <= li && li <= 33554428) && ((li % 4) == 0)}<br />
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section 2.4.1 [Book 1]"
     */
    // Template#: 2, Serial#: 2
    public void ba(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 2; }
            @Override
            protected void assemble() throws AssemblyException {
                ba(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bl  }<i>label</i>
     * <p>
     * Constraint: {@code (-33554432 <= li && li <= 33554428) && ((li % 4) == 0)}<br />
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section 2.4.1 [Book 1]"
     */
    // Template#: 3, Serial#: 3
    public void bl(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 3; }
            @Override
            protected void assemble() throws AssemblyException {
                bl(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bla  }<i>label</i>
     * <p>
     * Constraint: {@code (-33554432 <= li && li <= 33554428) && ((li % 4) == 0)}<br />
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section 2.4.1 [Book 1]"
     */
    // Template#: 4, Serial#: 4
    public void bla(final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 4; }
            @Override
            protected void assemble() throws AssemblyException {
                bla(labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bc  }<i>bo</i>, <i>bi</i>, <i>label</i>
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section 2.4.1 [Book 1]"
     */
    // Template#: 5, Serial#: 5
    public void bc(final BOOperand bo, final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 5; }
            @Override
            protected void assemble() throws AssemblyException {
                bc(bo, bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bca  }<i>bo</i>, <i>bi</i>, <i>label</i>
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section 2.4.1 [Book 1]"
     */
    // Template#: 6, Serial#: 6
    public void bca(final BOOperand bo, final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 6; }
            @Override
            protected void assemble() throws AssemblyException {
                bca(bo, bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bcl  }<i>bo</i>, <i>bi</i>, <i>label</i>
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section 2.4.1 [Book 1]"
     */
    // Template#: 7, Serial#: 7
    public void bcl(final BOOperand bo, final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 7; }
            @Override
            protected void assemble() throws AssemblyException {
                bcl(bo, bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bcla  }<i>bo</i>, <i>bi</i>, <i>label</i>
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section 2.4.1 [Book 1]"
     */
    // Template#: 8, Serial#: 8
    public void bcla(final BOOperand bo, final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 8; }
            @Override
            protected void assemble() throws AssemblyException {
                bcla(bo, bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bt{++|--}  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRTrue | prediction, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 9, Serial#: 342
    public void bt(final int bi, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 342; }
            @Override
            protected void assemble() throws AssemblyException {
                bt(bi, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bta{++|--}  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRTrue | prediction, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 10, Serial#: 343
    public void bta(final int bi, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 343; }
            @Override
            protected void assemble() throws AssemblyException {
                bta(bi, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btl{++|--}  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRTrue | prediction, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 11, Serial#: 344
    public void btl(final int bi, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 344; }
            @Override
            protected void assemble() throws AssemblyException {
                btl(bi, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code btla{++|--}  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRTrue | prediction, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 12, Serial#: 345
    public void btla(final int bi, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 345; }
            @Override
            protected void assemble() throws AssemblyException {
                btla(bi, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bf{++|--}  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRFalse | prediction, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 13, Serial#: 346
    public void bf(final int bi, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 346; }
            @Override
            protected void assemble() throws AssemblyException {
                bf(bi, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bfa{++|--}  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRFalse | prediction, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 14, Serial#: 347
    public void bfa(final int bi, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 347; }
            @Override
            protected void assemble() throws AssemblyException {
                bfa(bi, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bfl{++|--}  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRFalse | prediction, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 15, Serial#: 348
    public void bfl(final int bi, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 348; }
            @Override
            protected void assemble() throws AssemblyException {
                bfl(bi, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bfla{++|--}  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRFalse | prediction, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 16, Serial#: 349
    public void bfla(final int bi, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 349; }
            @Override
            protected void assemble() throws AssemblyException {
                bfla(bi, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnz{++|--}  }<i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CTRNonZero | (prediction & 0x1) | (((prediction >>> 1) & 0x1) << 3), 0, label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 17, Serial#: 350
    public void bdnz(final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 350; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnz(labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnza{++|--}  }<i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CTRNonZero | (prediction & 0x1) | (((prediction >>> 1) & 0x1) << 3), 0, label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 18, Serial#: 351
    public void bdnza(final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 351; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnza(labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnzl{++|--}  }<i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CTRNonZero | (prediction & 0x1) | (((prediction >>> 1) & 0x1) << 3), 0, label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 19, Serial#: 352
    public void bdnzl(final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 352; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnzl(labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnzla{++|--}  }<i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CTRNonZero | (prediction & 0x1) | (((prediction >>> 1) & 0x1) << 3), 0, label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 20, Serial#: 353
    public void bdnzla(final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 353; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnzla(labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdz{++|--}  }<i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CTRZero | (prediction & 0x1) | (((prediction >>> 1) & 0x1) << 3), 0, label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 21, Serial#: 354
    public void bdz(final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 354; }
            @Override
            protected void assemble() throws AssemblyException {
                bdz(labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdza{++|--}  }<i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CTRZero | (prediction & 0x1) | (((prediction >>> 1) & 0x1) << 3), 0, label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 22, Serial#: 355
    public void bdza(final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 355; }
            @Override
            protected void assemble() throws AssemblyException {
                bdza(labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdzl{++|--}  }<i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CTRZero | (prediction & 0x1) | (((prediction >>> 1) & 0x1) << 3), 0, label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 23, Serial#: 356
    public void bdzl(final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 356; }
            @Override
            protected void assemble() throws AssemblyException {
                bdzl(labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdzla{++|--}  }<i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CTRZero | (prediction & 0x1) | (((prediction >>> 1) & 0x1) << 3), 0, label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 24, Serial#: 357
    public void bdzla(final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 357; }
            @Override
            protected void assemble() throws AssemblyException {
                bdzla(labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnzt  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CTRNonZero_CRTrue, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 25, Serial#: 358
    public void bdnzt(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 358; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnzt(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnzta  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CTRNonZero_CRTrue, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 26, Serial#: 359
    public void bdnzta(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 359; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnzta(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnztl  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CTRNonZero_CRTrue, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 27, Serial#: 360
    public void bdnztl(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 360; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnztl(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnztla  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CTRNonZero_CRTrue, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 28, Serial#: 361
    public void bdnztla(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 361; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnztla(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnzf  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CTRNonZero_CRFalse, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 29, Serial#: 362
    public void bdnzf(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 362; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnzf(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnzfa  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CTRNonZero_CRFalse, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 30, Serial#: 363
    public void bdnzfa(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 363; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnzfa(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnzfl  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CTRNonZero_CRFalse, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 31, Serial#: 364
    public void bdnzfl(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 364; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnzfl(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdnzfla  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CTRNonZero_CRFalse, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 32, Serial#: 365
    public void bdnzfla(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 365; }
            @Override
            protected void assemble() throws AssemblyException {
                bdnzfla(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdzt  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CTRZero_CRTrue, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 33, Serial#: 366
    public void bdzt(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 366; }
            @Override
            protected void assemble() throws AssemblyException {
                bdzt(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdzta  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CTRZero_CRTrue, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 34, Serial#: 367
    public void bdzta(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 367; }
            @Override
            protected void assemble() throws AssemblyException {
                bdzta(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdztl  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CTRZero_CRTrue, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 35, Serial#: 368
    public void bdztl(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 368; }
            @Override
            protected void assemble() throws AssemblyException {
                bdztl(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdztla  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CTRZero_CRTrue, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 36, Serial#: 369
    public void bdztla(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 369; }
            @Override
            protected void assemble() throws AssemblyException {
                bdztla(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdzf  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CTRZero_CRFalse, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 37, Serial#: 370
    public void bdzf(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 370; }
            @Override
            protected void assemble() throws AssemblyException {
                bdzf(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdzfa  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CTRZero_CRFalse, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 38, Serial#: 371
    public void bdzfa(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 371; }
            @Override
            protected void assemble() throws AssemblyException {
                bdzfa(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdzfl  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CTRZero_CRFalse, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 39, Serial#: 372
    public void bdzfl(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 372; }
            @Override
            protected void assemble() throws AssemblyException {
                bdzfl(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bdzfla  }<i>bi</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CTRZero_CRFalse, bi, label)}
     * <p>
     * Constraint: {@code 0 <= bi && bi <= 31}<br />
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.2 [Book 1]"
     */
    // Template#: 40, Serial#: 373
    public void bdzfla(final int bi, final Label label) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 373; }
            @Override
            protected void assemble() throws AssemblyException {
                bdzfla(bi, labelOffsetAsInt());
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code blt{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRTrue | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 41, Serial#: 398
    public void blt(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 398; }
            @Override
            protected void assemble() throws AssemblyException {
                blt(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code blta{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRTrue | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 42, Serial#: 399
    public void blta(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 399; }
            @Override
            protected void assemble() throws AssemblyException {
                blta(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bltl{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRTrue | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 43, Serial#: 400
    public void bltl(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 400; }
            @Override
            protected void assemble() throws AssemblyException {
                bltl(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bltla{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRTrue | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 44, Serial#: 401
    public void bltla(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 401; }
            @Override
            protected void assemble() throws AssemblyException {
                bltla(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code ble{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRFalse | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 45, Serial#: 402
    public void ble(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 402; }
            @Override
            protected void assemble() throws AssemblyException {
                ble(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code blea{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRFalse | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 46, Serial#: 403
    public void blea(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 403; }
            @Override
            protected void assemble() throws AssemblyException {
                blea(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code blel{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRFalse | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 47, Serial#: 404
    public void blel(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 404; }
            @Override
            protected void assemble() throws AssemblyException {
                blel(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code blela{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRFalse | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 48, Serial#: 405
    public void blela(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 405; }
            @Override
            protected void assemble() throws AssemblyException {
                blela(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code beq{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRTrue | prediction, 2 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 49, Serial#: 406
    public void beq(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 406; }
            @Override
            protected void assemble() throws AssemblyException {
                beq(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code beqa{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRTrue | prediction, 2 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 50, Serial#: 407
    public void beqa(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 407; }
            @Override
            protected void assemble() throws AssemblyException {
                beqa(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code beql{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRTrue | prediction, 2 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 51, Serial#: 408
    public void beql(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 408; }
            @Override
            protected void assemble() throws AssemblyException {
                beql(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code beqla{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRTrue | prediction, 2 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 52, Serial#: 409
    public void beqla(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 409; }
            @Override
            protected void assemble() throws AssemblyException {
                beqla(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bge{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRFalse | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 53, Serial#: 410
    public void bge(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 410; }
            @Override
            protected void assemble() throws AssemblyException {
                bge(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgea{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRFalse | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 54, Serial#: 411
    public void bgea(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 411; }
            @Override
            protected void assemble() throws AssemblyException {
                bgea(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgel{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRFalse | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 55, Serial#: 412
    public void bgel(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 412; }
            @Override
            protected void assemble() throws AssemblyException {
                bgel(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgela{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRFalse | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 56, Serial#: 413
    public void bgela(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 413; }
            @Override
            protected void assemble() throws AssemblyException {
                bgela(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgt{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRTrue | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 57, Serial#: 414
    public void bgt(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 414; }
            @Override
            protected void assemble() throws AssemblyException {
                bgt(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgta{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRTrue | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 58, Serial#: 415
    public void bgta(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 415; }
            @Override
            protected void assemble() throws AssemblyException {
                bgta(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgtl{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRTrue | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 59, Serial#: 416
    public void bgtl(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 416; }
            @Override
            protected void assemble() throws AssemblyException {
                bgtl(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bgtla{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRTrue | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 60, Serial#: 417
    public void bgtla(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 417; }
            @Override
            protected void assemble() throws AssemblyException {
                bgtla(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnl{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRFalse | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 61, Serial#: 418
    public void bnl(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 418; }
            @Override
            protected void assemble() throws AssemblyException {
                bnl(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnla{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRFalse | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 62, Serial#: 419
    public void bnla(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 419; }
            @Override
            protected void assemble() throws AssemblyException {
                bnla(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnll{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRFalse | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 63, Serial#: 420
    public void bnll(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 420; }
            @Override
            protected void assemble() throws AssemblyException {
                bnll(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnlla{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRFalse | prediction, (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 64, Serial#: 421
    public void bnlla(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 421; }
            @Override
            protected void assemble() throws AssemblyException {
                bnlla(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bne{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRFalse | prediction, 2 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 65, Serial#: 422
    public void bne(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 422; }
            @Override
            protected void assemble() throws AssemblyException {
                bne(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnea{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRFalse | prediction, 2 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 66, Serial#: 423
    public void bnea(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 423; }
            @Override
            protected void assemble() throws AssemblyException {
                bnea(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnel{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRFalse | prediction, 2 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 67, Serial#: 424
    public void bnel(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 424; }
            @Override
            protected void assemble() throws AssemblyException {
                bnel(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnela{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRFalse | prediction, 2 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 68, Serial#: 425
    public void bnela(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 425; }
            @Override
            protected void assemble() throws AssemblyException {
                bnela(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bng{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRFalse | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 69, Serial#: 426
    public void bng(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 426; }
            @Override
            protected void assemble() throws AssemblyException {
                bng(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnga{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRFalse | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 70, Serial#: 427
    public void bnga(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 427; }
            @Override
            protected void assemble() throws AssemblyException {
                bnga(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bngl{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRFalse | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 71, Serial#: 428
    public void bngl(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 428; }
            @Override
            protected void assemble() throws AssemblyException {
                bngl(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bngla{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRFalse | prediction, 1 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 72, Serial#: 429
    public void bngla(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 429; }
            @Override
            protected void assemble() throws AssemblyException {
                bngla(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bso{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRTrue | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 73, Serial#: 430
    public void bso(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 430; }
            @Override
            protected void assemble() throws AssemblyException {
                bso(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsoa{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRTrue | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 74, Serial#: 431
    public void bsoa(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 431; }
            @Override
            protected void assemble() throws AssemblyException {
                bsoa(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsol{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRTrue | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 75, Serial#: 432
    public void bsol(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 432; }
            @Override
            protected void assemble() throws AssemblyException {
                bsol(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bsola{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRTrue | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 76, Serial#: 433
    public void bsola(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 433; }
            @Override
            protected void assemble() throws AssemblyException {
                bsola(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bns{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRFalse | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 77, Serial#: 434
    public void bns(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 434; }
            @Override
            protected void assemble() throws AssemblyException {
                bns(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnsa{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRFalse | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 78, Serial#: 435
    public void bnsa(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 435; }
            @Override
            protected void assemble() throws AssemblyException {
                bnsa(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnsl{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRFalse | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 79, Serial#: 436
    public void bnsl(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 436; }
            @Override
            protected void assemble() throws AssemblyException {
                bnsl(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnsla{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRFalse | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 80, Serial#: 437
    public void bnsla(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 437; }
            @Override
            protected void assemble() throws AssemblyException {
                bnsla(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bun{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRTrue | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 81, Serial#: 438
    public void bun(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 438; }
            @Override
            protected void assemble() throws AssemblyException {
                bun(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code buna{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRTrue | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 82, Serial#: 439
    public void buna(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 439; }
            @Override
            protected void assemble() throws AssemblyException {
                buna(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bunl{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRTrue | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 83, Serial#: 440
    public void bunl(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 440; }
            @Override
            protected void assemble() throws AssemblyException {
                bunl(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bunla{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRTrue | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 84, Serial#: 441
    public void bunla(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 441; }
            @Override
            protected void assemble() throws AssemblyException {
                bunla(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnu{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bc(CRFalse | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bc(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 85, Serial#: 442
    public void bnu(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 442; }
            @Override
            protected void assemble() throws AssemblyException {
                bnu(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnua{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bca(CRFalse | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bca(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 86, Serial#: 443
    public void bnua(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 443; }
            @Override
            protected void assemble() throws AssemblyException {
                bnua(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnul{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcl(CRFalse | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcl(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 87, Serial#: 444
    public void bnul(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 444; }
            @Override
            protected void assemble() throws AssemblyException {
                bnul(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

    /**
     * Pseudo-external assembler syntax: {@code bnula{++|--}  }<i>crf</i>, <i>label</i>
     * <p>
     * This is a synthetic instruction equivalent to: {@code bcla(CRFalse | prediction, 3 | (crf * 4), label)}
     * <p>
     * Constraint: {@code (-32768 <= bd && bd <= 32764) && ((bd % 4) == 0)}<br />
     *
     * @see #bcla(BOOperand, int, Label)
     *
     * @see "<a href="http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html">PowerPC Architecture Book, Version 2.02</a> - Section B.2.3 [Book 1]"
     */
    // Template#: 88, Serial#: 445
    public void bnula(final CRF crf, final Label label, final BranchPredictionBits prediction) {
        emitInt(0); // instruction place holder
        new LabelOffsetInstruction(this, label) {
            @Override
            protected int templateSerial() { return 445; }
            @Override
            protected void assemble() throws AssemblyException {
                bnula(crf, labelOffsetAsInt(), prediction);
            }
        };
    }

}
// END GENERATED CONTENT
