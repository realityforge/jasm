/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.x86;

import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class X86DisplacementParameter extends X86OffsetParameter {

    public X86DisplacementParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, width);
    }

    @Override
    public String variableName() {
        return "disp" + width().numberOfBits();
    }

}
