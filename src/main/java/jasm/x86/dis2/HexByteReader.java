/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.x86.dis2;

import jasm.util.HexByte;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/** A simplified interface to read bytes from a stream. Used by the decoders. */
public final class HexByteReader {
  private final InputStream _input;
  private HexByte _nextByte;
  private int _offset;

  public HexByteReader(InputStream input) { _input = input; }

  public void pushBack(HexByte byteValue) { _nextByte = byteValue; }

  public int offset() { return _offset; }

  public HexByte nextByte()
      throws IOException {
    if (_nextByte != null) {
      final HexByte value = _nextByte;
      _nextByte = null;
      return value;
    } else {
      final int value = _input.read();
      if (-1 == value) {
        throw new EOFException();
      } else {
        _offset++;
        return HexByte.values()[value];
      }
    }
  }

  public int available() throws IOException {
    return _input.available() + ((null != _nextByte) ? 1 : 0);
  }
}
