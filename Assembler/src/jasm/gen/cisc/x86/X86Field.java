/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=cd2c36ce-369c-4b9d-b685-58b30dd0af30*/
package jasm.gen.cisc.x86;


/**
 * @author Bernd Mathiske
 */
public final class X86Field {

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

    public static int extractRexValue(int rexBitIndex, byte rexByte) {
        return ((rexByte >> rexBitIndex) & 1) << 3;
    }

}
