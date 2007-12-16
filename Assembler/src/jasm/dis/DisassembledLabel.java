/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
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
