/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.WordWidth;

public final class X86DisplacementParameter extends X86OffsetParameter {

    public X86DisplacementParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, width);
    }

    @Override
    public final String variableName() {
        return "disp" + width().numberOfBits();
    }

}
