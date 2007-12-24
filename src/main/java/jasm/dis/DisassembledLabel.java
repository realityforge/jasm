/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis;

/**
 * A label deduced from one or more disassembled instructions.
 */
public final class DisassembledLabel {

  private final int _instructionIndex;

  public DisassembledLabel(int instructionIndex) {
    super();
    _instructionIndex = instructionIndex;
  }

  public final int instructionIndex() {
    return _instructionIndex;
  }

  public static final String PREFIX = "L";

  private int _serial = -1;

  public final void setSerial(int index) {
    _serial = index;
  }

  public final String name() {
    return PREFIX + _serial;
  }

  private int _offset = -1;

  public final void bind(int offset) {
    _offset = offset;
  }

  public final int offset() {
    return _offset;
  }
}
