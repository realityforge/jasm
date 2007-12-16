/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.x86;

import jasm.gen.OffsetParameter;
import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class X86OffsetParameter extends X86NumericalParameter implements OffsetParameter {

    public X86OffsetParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, width);
        setVariableName("rel" + width.numberOfBits());
    }
}
