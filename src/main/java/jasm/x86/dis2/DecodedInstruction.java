/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.x86.dis2;

/** Representation of a decoded instruction, suitable for display to user. */
public final class DecodedInstruction {

  private final String _addressAsString;
  private final int _offset;
  private final String _operation;
  private final String[] _operands;
  private final byte[] _bytes;

  public DecodedInstruction(final String addressAsString,
                            final int offset,
                            final String operation,
                            final String[] operands,
                            final byte[] bytes) {
    _addressAsString = addressAsString;
    _offset = offset;
    _operation = operation;
    _operands = operands;
    _bytes = bytes;
  }

  public String addressAsString() { return _addressAsString; }

  public int offset() { return _offset; }

  public String operation() { return _operation; }

  public String[] operands() { return _operands; }

  public byte[] bytes() { return _bytes; }
}

