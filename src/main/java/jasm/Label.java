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
 * Assembler labels for symbolic addressing.
 * <p/>
 * This class provides combined functionality for both 32-bit and 64-bit address spaces.
 * The respective assembler narrows the usable interface to either.
 *
 * @see Assembler32
 * @see Assembler64
 */
public final class Label implements Argument {

  public enum State {
    UNASSIGNED, BOUND, FIXED_32, FIXED_64
  }

  protected State _state = State.UNASSIGNED;

  public Label() {
  }

  public final State state() {
    return _state;
  }

  private int _offset;

  /**
   * Must only be called when the label is bound!
   */
  public final int offset() throws AssemblyException {
    if (_state != State.BOUND) {
      throw new AssemblyException("unassigned or unbound label");
    }
    return _offset;
  }

  /**
   * Binds this label to an address in the assembler's instruction stream that represents the start of an instruction.
   * The assembler may update the address if any emitted instructions change lengths, so that this label keeps
   * addressing the same logical instruction.
   * <p/>
   * Only to be called by {@link Assembler#bindLabel(Label)}.
   *
   * @param offset an instruction's start address in the assembler's instruction stream
   * @see Assembler#bindLabel(Label)
   */
  final void bind(int offset) {
    _offset = offset;
    _state = State.BOUND;
  }

  final void adjust(int delta) {
    assert _state == State.BOUND;
    _offset += delta;
  }

  private int _address32;
  private long _address64;

  /**
   * Assigns a fixed, absolute 32-bit address to this label.
   * If used in a 64-bit assembler,
   * the effective address value would be unsigned-extended.
   *
   * @param address32 an absolute memory location
   * @see Assembler#bindLabel(Label)
   */
  final void fix32(int address32) {
    _address32 = address32;
    _state = State.FIXED_32;
  }

  /**
   * Assigns a fixed, absolute 64-bit address to this label.
   *
   * @param address64 an absolute memory location
   * @see Assembler#bindLabel(Label)
   */
  final void fix64(long address64) {
    _address64 = address64;
    _state = State.FIXED_64;
  }

  /**
   * Must only be called if this label has been {@link #fix32 fixed}.
   */
  public final int address32() throws AssemblyException {
    if (State.FIXED_32 == _state) {
      return _address32;
    } else if (State.FIXED_64 == _state) {
      throw new AssemblyException("64-bit address in 32-bit assembler");
    } else {
      throw new AssemblyException("unassigned or unfixed label");
    }
  }

  /**
   * Must only be called if this label has been {@link #fix64 fixed}.
   */
  public final long address64() throws AssemblyException {
    if (State.FIXED_64 == _state) {
      return _address64;
    } else if (State.FIXED_32 == _state) {
      throw new AssemblyException("32-bit address in 64-bit assembler");
    } else {
      throw new AssemblyException("unassigned or unfixed label");
    }
  }

  public final String externalValue() {
    throw new UnsupportedOperationException();
  }

  public final String disassembledValue() {
    throw new UnsupportedOperationException();
  }

  public final long asLong() {
    throw new UnsupportedOperationException();
  }

  @Override
  public final boolean equals(Object other) {
    if (other instanceof Label) {
      final Label label = (Label) other;
      if (_state != label._state) {
        return false;
      }
      switch (_state) {
        case UNASSIGNED:
          return this == label;
        case BOUND:
          return _offset == label._offset;
        case FIXED_32:
          return _address32 == label._address32;
        case FIXED_64:
          return _address64 == label._address64;
        default:
          throw new IllegalStateException();
      }
    }
    return false;
  }

  @Override
  public final int hashCode() {
    switch (_state) {
      case BOUND:
        return _offset;
      case FIXED_32:
        return _address32;
      case FIXED_64:
        return (int) (_address64 ^ (_address64 >> 32));
      default:
        return super.hashCode();
    }
  }
}
