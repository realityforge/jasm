/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=65f9c573-4904-4d65-99bf-89e5b8158a6a*/
package jasm;

import com.sun.max.collect.Enums;
import com.sun.max.collect.Sequence;
import jasm.util.Ints;
import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 * @author Greg Wright
 */
public abstract class LabelOffsetInstruction extends LabelInstruction {

    private static final Sequence<Sequence<WordWidth>> LABEL_WIDTH_SEQUENCES = Enums.powerSequence(WordWidth.class);

    private final Sequence<WordWidth> _labelWidthSequence;
    private int _labelWidthIndex;

    protected LabelOffsetInstruction(Assembler assembler, int startOffset, int endOffset, Label label, int labelWidthSequenceIndex) {
        super(assembler, startOffset, endOffset, label);
        _labelWidthSequence = LABEL_WIDTH_SEQUENCES.get(labelWidthSequenceIndex);
        assert !_labelWidthSequence.isEmpty();
        if (_labelWidthSequence.length() == 1) {
            assembler.addFixedLengthLabelInstruction(this);
        } else {
            assembler.addSpanDependentLabelInstruction(this);
        }
    }

    protected LabelOffsetInstruction(Assembler assembler, Label label) {
        super(assembler, assembler.currentOffset() - 4, assembler.currentOffset(), label);
        _labelWidthSequence = null;
        assembler.addFixedLengthLabelInstruction(this);
    }

    void setSize(int nBytes) {
        _size = nBytes;
    }


    protected WordWidth labelWidth() {
        return _labelWidthSequence.get(_labelWidthIndex);
    }

    void setLabelWidth(WordWidth width) throws AssemblyException {
        for (int i = 0; i < _labelWidthSequence.length(); i++) {
            if (_labelWidthSequence.get(i).greaterEqual(width)) {
                _labelWidthIndex = i;
                return;
            }
        }
        throw new AssemblyException("label instruction cannot accomodate number of argument bits");
    }

    private int labelOffset() throws AssemblyException {
        return assembler().labelOffsetInstructionRelative(label(), this);
    }

    WordWidth requiredLabelWidth() throws AssemblyException {
        return WordWidth.signedEffective(labelOffset());
    }

    protected byte labelOffsetAsByte() throws AssemblyException {
        if (assembler().selectingLabelInstructions()) {
            return (byte) 0;
        }
        final int result = labelOffset();
        if (Ints.numberOfEffectiveSignedBits(result) > 8) {
            throw new AssemblyException("label out of 8-bit range");
        }
        return (byte) result;
    }

    protected short labelOffsetAsShort() throws AssemblyException {
        if (assembler().selectingLabelInstructions()) {
            return (short) 0;
        }
        final int result = labelOffset();
        if (Ints.numberOfEffectiveSignedBits(result) > 16) {
            throw new AssemblyException("label out of 16-bit range");
        }
        return (short) result;
    }

    protected int labelOffsetAsInt() throws AssemblyException {
        if (assembler().selectingLabelInstructions()) {
            return 0;
        }
        return labelOffset();
    }

}
