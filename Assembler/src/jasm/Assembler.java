/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.IdentityHashSet;
import com.sun.max.collect.Sequence;
import com.sun.max.program.ProgramError;
import jasm.util.Longs;
import jasm.util.WordWidth;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Super class of generated assemblers.
 *
 * @author Bernd Mathiske
 * @author Greg Wright
 */
public abstract class Assembler {

    protected Assembler() {
    }

    public abstract InstructionSet instructionSet();

    private int _currentOffset; // address of current instruction

    protected int currentOffset() {
        return _currentOffset;
    }

    private ByteArrayOutputStream _stream = new ByteArrayOutputStream();

    protected ByteArrayOutputStream stream() {
        return _stream;
    }

    protected void emitByte(byte byteValue) {
        _stream.write(byteValue);
        _currentOffset++;
    }

    protected abstract void emitShort(short shortValue);

    protected abstract void emitInt(int intValue);

    protected abstract void emitLong(long longValue);

    private boolean _selectingLabelInstructions = true;

    boolean selectingLabelInstructions() {
        return _selectingLabelInstructions;
    }

    private final IdentityHashSet<Label> _boundLabels = new IdentityHashSet<Label>();

    protected IdentityHashSet<Label> boundLabels() {
        return _boundLabels;
    }

    /**
     * Binds a given label to the address in the assembler's instruction stream of the start of the next instruction.
     * The assembler may update the address if any emitted instructions change lengths, so that this label keeps
     * addressing the same logical instruction.
     *
     * @param label
     *            the label that is to be bound to the address of the next instruction
     *
     * @see Label#fix32
     */
    public final void bindLabel(Label label) {
        label.bind(currentOffset());
        _boundLabels.add(label);
    }

    private final AppendableSequence<LabelInstruction> _labelInstructions = new ArrayListSequence<LabelInstruction>();
    private final AppendableSequence<LabelOffsetInstruction> _spanDependentLabelInstructions = new ArrayListSequence<LabelOffsetInstruction>();

    /**
     * The size of label instruction is know past the initial generation of code. This may invalidate annotations to target code that
     * might have been produced during translation from the previous IR form. Annotation systems need to have access to the
     * set of label instructions so they can adjust appropriately the offsets within the target code of their annotations.
     * @return list of label instructions
     */
    public Sequence<LabelInstruction> labelInstructions() {
        return _labelInstructions;
    }

    void addFixedLengthLabelInstruction(LabelInstruction fixedLengthLabelInstruction) {
        _labelInstructions.append(fixedLengthLabelInstruction);
    }

    void addSpanDependentLabelInstruction(LabelOffsetInstruction spanDependentLabelInstruction) {
        _labelInstructions.append(spanDependentLabelInstruction);
        _spanDependentLabelInstructions.append(spanDependentLabelInstruction);
    }

    private void gatherLabels() throws AssemblyException {
        for (LabelInstruction labelInstruction : _labelInstructions) {
          final Label label = labelInstruction.label();
          switch (label.state()) {
                case UNASSIGNED:
                    throw new AssemblyException("unassigned label");
                case BOUND:
                    _boundLabels.add(label);
                    break;
                default:
                    break;
            }
        }
    }

    private boolean updateSpanDependentLabelInstruction(LabelOffsetInstruction instruction) throws AssemblyException {
        final WordWidth requiredWidth = instruction.requiredLabelWidth();
        if (instruction.labelWidth().greaterEqual(requiredWidth)) {
            return false;
        }
        final int oldSize = instruction.size();
        instruction.setLabelWidth(requiredWidth);
        _stream.reset();
        instruction.assemble();
        final int newSize = _stream.toByteArray().length;
        instruction.setSize(newSize);
        final int delta = newSize - oldSize;
        updateSuccessorLabels(instruction, delta);
        return true;
    }

  private void updateSuccessorLabels(final LabelOffsetInstruction instruction, final int delta) throws AssemblyException {
    for (Label label : _boundLabels) {
        if (label.offset() > instruction.startOffset()) {
            label.adjust(delta);
        }
    }
    for (LabelInstruction labelInstruction : _labelInstructions) {
        if (labelInstruction.startOffset() > instruction.startOffset()) {
            labelInstruction.adjust(delta);
        }
    }
  }

  private void updateSpanDependentLabelInstructions() throws AssemblyException {
        while (true) {
            boolean updatedAny = false;
            for (LabelOffsetInstruction instruction : _spanDependentLabelInstructions) {
                if (updateSpanDependentLabelInstruction(instruction)) {
                    updatedAny = true;
                }
            }
            if (!updatedAny) {
                return;
            }
        }
    }

    private void writeOutput(OutputStream outputStream, byte[] initialBytes) throws IOException, AssemblyException {
        _selectingLabelInstructions = false;
        int offset = 0;
        for (LabelInstruction labelInstruction : _labelInstructions) {
            outputStream.write(initialBytes, offset, labelInstruction.initialStartOffset() - offset);
            _stream.reset();
            labelInstruction.assemble();
            final byte[] labelInstructionBytes = _stream.toByteArray();
            outputStream.write(labelInstructionBytes, 0, labelInstructionBytes.length);
            offset = labelInstruction.initialEndOffset();
        }
        outputStream.write(initialBytes, offset, initialBytes.length - offset);
    }

    /**
     * Writes the object code assembled so far to a given output stream.
     *
     * @throws AssemblyException
     *             if there any problem with binding labels to addresses
     */
    public void output(OutputStream outputStream) throws IOException, AssemblyException {
        final byte[] initialBytes = _stream.toByteArray();
        gatherLabels();
        updateSpanDependentLabelInstructions();
        writeOutput(outputStream, initialBytes);
    }

    public int upperLimitForCurrentOutputSize() {
        // A span-dependent instruction's offset operand can potentially grow from 8 bits to 32 bits.
        // Also, some instructions need an extra byte for encoding when not using an 8-bit operand.
        // Together, this might enlarge every span-dependent instruction by maximally 4 bytes.
        return currentOffset() + (_spanDependentLabelInstructions.length() * 4);
    }

    /**
     * Returns the object code assembled so far in a byte array.
     *
     * @throws AssemblyException
     *             if there any problem with binding labels to addresses
     */
    public byte[] toByteArray() throws AssemblyException {
        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            output(stream);
            stream.close();
          return stream.toByteArray();
        } catch (IOException ioException) {
            ProgramError.unexpected("IOException during output to byte array", ioException);
        }
        return new byte[0];
    }

    /**
     * @see Label#fix32(int)
     */
    protected void fixLabel32(Label label, int address32) {
        label.fix32(address32);
    }

    /**
     * @see Label#fix64(long)
     */
    protected void fixLabel64(Label label, long address64) {
        label.fix64(address64);
    }

    protected int address32(Label label) throws AssemblyException {
        return label.address32();
    }

    protected long address64(Label label) throws AssemblyException {
        return label.address64();
    }

    protected void checkConstraint(boolean passed, String expression) {
        if (!passed) {
            throw new IllegalArgumentException(expression);
        }
    }

    /**
     * Calculate the difference between a Label and an offset within our assembled code.
     * @throws AssemblyException
     */
    public int labelOffsetRelative(Label label, int offset) throws AssemblyException {
        switch (label.state()) {
            case BOUND: {
                return label.offset() - offset;
            }
            case FIXED_32: {
                final Assembler32 assembler32 = (Assembler32) this;
                return assembler32.address(label) - (assembler32.startAddress() + offset);
            }
            case FIXED_64: {
                final Assembler64 assembler64 = (Assembler64) this;
                final long offset64 = assembler64.address(label) - (assembler64.startAddress() + offset);
                if (Longs.numberOfEffectiveSignedBits(offset64) > 32) {
                    throw new AssemblyException("fixed 64-bit label out of 32-bit range");
                }
                return (int) offset64;
            }
            default: {
                throw new AssemblyException("unassigned label");
            }
        }
    }

    /**
     * Calculate the difference between a Label and an instruction.
     * Different CPUs have different conventions for which end of an
     * instruction to measure from.
     * @throws AssemblyException
     */
    public final int labelOffsetInstructionRelative(Label label, AssemblyInstruction instruction) throws AssemblyException {
        switch (instructionSet().relativeAddressing()) {
            case FROM_INSTRUCTION_START:
                return labelOffsetRelative(label, instruction.startOffset());
            case FROM_INSTRUCTION_END:
                return labelOffsetRelative(label, instruction.endOffset());
        }
        ProgramError.unknownCase();
        return 0;
    }
}
