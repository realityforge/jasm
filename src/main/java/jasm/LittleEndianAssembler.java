/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

import jasm.annotations.Inline;

public abstract class LittleEndianAssembler extends Assembler {

  protected LittleEndianAssembler(final int initialMachineCodeCapacity) {
    super(initialMachineCodeCapacity);
  }

  @Override
  protected final void emitShort(short value) {
    emitLEShort(value);
  }

  @Override
  @Inline
  protected final void emitInt(int value) {
    emitLEInt(value);
  }

  @Override
  @Inline
  protected final void emitLong(long value) {
    emitLELong(value);
  }
}
