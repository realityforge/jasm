/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.x86;

import jasm.gen.AddressParameter;
import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class X86AddressParameter extends X86NumericalParameter implements AddressParameter {

    public X86AddressParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, width);
        setVariableName("m" + width().numberOfBits());
    }

}
