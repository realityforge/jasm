/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=08ef1ab9-34cc-4c6a-836f-9aecbd61dd4b*/
package com.sun.max.asm;


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
    
    protected Assembler assembler() {
        return _assembler;
    }
    
    public int initialStartOffset() {
        return _initialStartOffset;
    }
    
    public int initialEndOffset() {
        return _initialEndOffset;
    }
    
    void adjust(int delta) {
        _startOffset += delta;
    }
    
    public int startOffset() {
        return _startOffset;
    }
    
    public int endOffset() {
        return _startOffset + _size;
    }
    
    public int size() {
        return _size;
    }        
        
    protected Label label() {        
        return _label;
    }
    
    /**
     * This is so that, in the debugger, one may see which template
     * corresponds to the label instruction.
     */
    protected abstract int templateSerial();
}
