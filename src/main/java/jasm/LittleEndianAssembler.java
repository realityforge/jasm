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
 * @author Bernd Mathiske
 */
public abstract class LittleEndianAssembler extends Assembler {

  protected LittleEndianAssembler() {
    super();
  }

  @Override
  protected final void emitShort(short shortValue) {
    emitByte((byte) (shortValue & 0xff));
    emitByte((byte) (shortValue >> 8));
  }

  @Override
  protected final void emitInt(int intValue) {
    emitShort((short) (intValue & 0xffff));
    emitShort((short) (intValue >> 16));
  }

  @Override
  protected final void emitLong(long longValue) {
    emitInt((int) (longValue & 0xffffffffL));
    emitInt((int) (longValue >> 32));
  }
}
