/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

import jasm.annotations.NoInline;
import jasm.util.Longs;
import java.util.LinkedList;

/**
 * Super class of generated assemblers.
 */
public abstract class Assembler {

  private final LinkedList<LabelInstruction> _labelInstructions = new LinkedList<LabelInstruction>();
  private final LinkedList<LabelOffsetInstruction> _spanDependentLabelInstructions = new LinkedList<LabelOffsetInstruction>();
  private final LabelSet _boundLabels = new LabelSet();

  private boolean _selectingLabelInstructions = true;

  // index into current machineCode array
  private int _machineCodeIndex;
  private byte[] _machineCode;

  protected Assembler(final int initialMachineCodeCapacity) {
    //Enforce constraint required by emit*Long
    if( initialMachineCodeCapacity < 8 ) {
      throw new IllegalArgumentException("initialMachineCodeCapacity MUST be 8 or more");
    }
    _machineCode = new byte[initialMachineCodeCapacity];
  }

  public abstract InstructionSet instructionSet();

  protected final int currentOffset() {
    return _machineCodeIndex;
  }

  protected final void emitByte(byte value) {
    if (_machineCodeIndex == _machineCode.length) {
      _machineCode = growMachineCode();
    }
    _machineCode[_machineCodeIndex++] = value;
  }

  @NoInline
  private byte[] growMachineCode() {
    final byte[] bytes = new byte[2 * _machineCode.length];
    System.arraycopy(_machineCode, 0, bytes, 0, _machineCode.length);
    return bytes;
  }

  protected abstract void emitShort(short shortValue);

  protected abstract void emitInt(int intValue);

  protected abstract void emitLong(long longValue);

  final boolean selectingLabelInstructions() {
    return _selectingLabelInstructions;
  }

  /**
   * Binds a given label to the address in the assembler's instruction stream of the start of the next instruction.
   * The assembler may update the address if any emitted instructions change lengths, so that this label keeps
   * addressing the same logical instruction.
   *
   * @param label the label that is to be bound to the address of the next instruction
   * @see Label#fix32
   */
  public final void bindLabel(Label label) {
    label.bind(currentOffset());
    _boundLabels.add(label);
  }

  /**
   * The size of label instruction is know past the initial generation of code. This may invalidate annotations to target code that
   * might have been produced during translation from the previous IR form. Annotation systems need to have access to the
   * set of label instructions so they can adjust appropriately the offsets within the target code of their annotations.
   *
   * @return list of label instructions
   */
  public final LinkedList<LabelInstruction> labelInstructions() {
    return _labelInstructions;
  }

  final void addFixedLengthLabelInstruction(LabelInstruction fixedLengthLabelInstruction) {
    _labelInstructions.addLast(fixedLengthLabelInstruction);
  }

  final void addSpanDependentLabelInstruction(LabelOffsetInstruction spanDependentLabelInstruction) {
    _labelInstructions.addLast(spanDependentLabelInstruction);
    _spanDependentLabelInstructions.addLast(spanDependentLabelInstruction);
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
    //UGLY hackery.
    // We assemble the label instruction at the end of our machineCode
    // to figure out length then we roll it back by reseting the machineCodeIndex
    final int oldMCI = _machineCodeIndex;
    instruction.assemble();
    final int newSize = _machineCodeIndex - oldMCI;
    _machineCodeIndex = oldMCI;
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

  private byte[] writeOutput() throws AssemblyException {
    _selectingLabelInstructions = false;

    final int size;
    if (_labelInstructions.size() > 0) {
      final LabelInstruction lastEnd = _labelInstructions.getLast();
      size = (lastEnd.endOffset() + _machineCodeIndex - lastEnd.initialEndOffset());
    } else {
      size = _machineCodeIndex;
    }

    final byte[] output = new byte[size];

    int mcOffset = 0;
    int outputOffset = 0;
    for (LabelInstruction labelInstruction : _labelInstructions) {
      //Copy content prior to current label but after last label
      final int preDataLength = labelInstruction.initialStartOffset() - mcOffset;
      System.arraycopy(_machineCode, mcOffset, output, outputOffset, preDataLength);
      outputOffset += preDataLength;

      //UGLY hackery.
      // We assemble the label instruction at the end of our machineCode
      // to figure out length then we roll it back by reseting the machineCodeIndex
      final int oldMCI = _machineCodeIndex;
      labelInstruction.assemble();
      System.arraycopy(_machineCode, oldMCI, output, outputOffset, _machineCodeIndex - oldMCI);
      outputOffset += _machineCodeIndex - oldMCI;
      _machineCodeIndex = oldMCI;
      mcOffset = labelInstruction.initialEndOffset();
    }
    System.arraycopy(_machineCode, mcOffset, output, outputOffset, _machineCodeIndex - mcOffset);
    return output;
  }

  /**
   * Returns the object code assembled so far in a byte array.
   *
   * @throws AssemblyException if there any problem with binding labels to addresses
   */
  public final byte[] toByteArray() throws AssemblyException {
    gatherLabels();
    updateSpanDependentLabelInstructions();
    return writeOutput();
  }

  protected final void fixLabel32(Label label, int address32) {
    label.fix32(address32);
  }

  protected final void fixLabel64(Label label, long address64) {
    label.fix64(address64);
  }

  protected final int address32(Label label) throws AssemblyException {
    return label.address32();
  }

  protected final long address64(Label label) throws AssemblyException {
    return label.address64();
  }

  protected final void constraintFailed(final String expression) {
    throw new IllegalArgumentException(expression);
  }

  /**
   * Calculate the difference between a Label and an offset within our assembled code.
   *
   * @throws AssemblyException
   */
  public final int labelOffsetRelative(Label label, int offset) throws AssemblyException {
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
   *
   * @throws AssemblyException
   */
  public final int labelOffsetInstructionRelative(Label label, AssemblyInstruction instruction) throws AssemblyException {
    switch (instructionSet().relativeAddressing()) {
      case FROM_INSTRUCTION_START:
        return labelOffsetRelative(label, instruction.startOffset());
      case FROM_INSTRUCTION_END:
        return labelOffsetRelative(label, instruction.endOffset());
    }
    throw new IllegalStateException();
  }
}
