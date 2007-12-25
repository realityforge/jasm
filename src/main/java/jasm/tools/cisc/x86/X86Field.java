/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

public final class X86Field {

  public static final X86Field RM = new X86Field(0, 3);
  public static final X86Field REG = new X86Field(3, 3);
  public static final X86Field MOD = new X86Field(6, 2);

  public static final X86Field BASE = new X86Field(0, 3);
  public static final X86Field INDEX = new X86Field(3, 3);
  public static final X86Field SCALE = new X86Field(6, 2);

  public static final int REX_B_BIT_INDEX = 0;
  public static final int REX_X_BIT_INDEX = 1;
  public static final int REX_R_BIT_INDEX = 2;
  public static final int REX_W_BIT_INDEX = 3;

  private final int _shift;
  private final int _mask;

  private X86Field(int shift, int width) {
    _shift = shift;
    _mask = ~(0xffffffff << width);
  }

  public int shift() {
    return _shift;
  }

  public int extract(byte byteValue) {
    return (byteValue >> _shift) & _mask;
  }

  public static int extractRexValue(int rexBitIndex, byte rexByte) {
    return ((rexByte >> rexBitIndex) & 1) << 3;
  }
}
