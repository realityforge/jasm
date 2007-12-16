/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package jasm.dis;

/**
 * A label deduced from one or more disassembled instructions.
 *
 * @author Bernd Mathiske
 */
public class DisassembledLabel {

    private final int _instructionIndex;

    public DisassembledLabel(int instructionIndex) {
        super();
        _instructionIndex = instructionIndex;
    }

    public int instructionIndex() {
        return _instructionIndex;
    }

    public static final String PREFIX = "L";

    private int _serial = -1;

    public void setSerial(int index) {
        _serial = index;
    }

    public String name() {
        return PREFIX + _serial;
    }

    private int _offset = -1;

    public void bind(int offset) {
        _offset = offset;
    }

    public int offset() {
        return _offset;
    }
}
