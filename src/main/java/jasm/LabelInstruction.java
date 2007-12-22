/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;


/**
 * An assembler instruction that has an offset argument which can be represented by a Label.
 *
 * @see Label
 *
 * @author Bernd Mathiske
 */
public abstract class LabelInstruction implements AssemblyInstruction {

    protected abstract void assemble() throws AssemblyException;

    private Assembler _assembler;
    private final int _initialStartOffset;
    private final int _initialEndOffset;
    private int _startOffset;
    protected int _size;
    private final Label _label;

    protected LabelInstruction(Assembler assembler, int startOffset, int endOffset, Label label) {
        _assembler = assembler;
        _initialStartOffset = startOffset;
        _initialEndOffset = endOffset;
        _startOffset = startOffset;
        _label = label;
        _size = endOffset - _startOffset;
    }

    protected final Assembler assembler() {
        return _assembler;
    }

    public final int initialStartOffset() {
        return _initialStartOffset;
    }

    public final int initialEndOffset() {
        return _initialEndOffset;
    }

    final void adjust(int delta) {
        _startOffset += delta;
    }

    public final int startOffset() {
        return _startOffset;
    }

    public final int endOffset() {
        return _startOffset + _size;
    }

    public final int size() {
        return _size;
    }

    protected final Label label() {
        return _label;
    }

    /**
     * This is so that, in the debugger, one may see which template
     * corresponds to the label instruction.
     */
    protected abstract int templateSerial();
}
