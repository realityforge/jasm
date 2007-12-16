/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.x86;

import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class X86ImmediateParameter extends X86NumericalParameter {

    public X86ImmediateParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, width);
        setVariableName("imm" + width.numberOfBits());
    }
}
