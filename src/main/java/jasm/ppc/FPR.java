/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ppc;

import jasm.EnumerableArgument;
import jasm.util.SymbolSet;

/**
 * The floating point registers.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public enum FPR implements EnumerableArgument {

    F0,   F1,  F2,  F3,  F4,  F5,  F6,  F7,
    F8,   F9,  F10, F11, F12, F13, F14, F15,
    F16, F17, F18, F19, F20, F21, F22, F23,
    F24, F25, F26, F27, F28, F29, F30, F31;

    public int value() {
        return ordinal();
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return name().toLowerCase();
    }

    public String disassembledValue() {
        return externalValue();
    }

  public static final SymbolSet<FPR> SYMBOLS = SymbolSet.fromEnum(FPR.class);

}
