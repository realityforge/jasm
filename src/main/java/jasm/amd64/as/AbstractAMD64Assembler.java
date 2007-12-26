/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.amd64.as;

import jasm.amd64.AMD64GeneralRegister8;
import jasm.annotations.Inline;
import jasm.annotations.NoInline;
import jasm.x86.as.X86Assembler;

public abstract class AbstractAMD64Assembler
    extends X86Assembler {

  protected AbstractAMD64Assembler(final int initialMachineCodeCapacity) {
    super(initialMachineCodeCapacity);
  }

  @NoInline
  protected final void checkRexCompatibility(final AMD64GeneralRegister8 register) {
    if (register.isHighByte()) {
      throw new IllegalArgumentException("Cannot encode " + register.name() + " in the presence of a REX prefix");
    }
  }

  @Inline
  protected final void emitRexPrefix(final boolean force,
                                     final boolean wBit,
                                     final boolean rBit,
                                     final boolean bBit,
                                     final boolean xBit) {
    if (!force && !wBit && !rBit && !bBit && !xBit) {
      return;
    }
    byte rex = (byte) 0x40;
    if (bBit) { rex |= 1; }
    if (xBit) { rex |= 1 << 1; }
    if (rBit) { rex |= 1 << 2; }
    if (wBit) { rex |= 1 << 3; }
    emitByte(rex);
  }
}
