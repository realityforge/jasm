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
  private static final String PREFIX = "L";

  private final int _instructionIndex;
  private int _serial = -1;
  private int _offset = -1;

  public DisassembledLabel(int instructionIndex) {
    _instructionIndex = instructionIndex;
  }

  public final int instructionIndex() {
    return _instructionIndex;
  }

  final void setSerial(int index) {
    _serial = index;
  }

  public final String name() {
    return PREFIX + _serial;
  }

  final void bind(int offset) {
    _offset = offset;
  }

  public final int offset() {
    return _offset;
  }
}
