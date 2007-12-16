/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4bedbc88-83fb-4972-a736-f7fb0e308897*/
package jasm.gen.cisc.x86;

import jasm.gen.AddressParameter;
import com.sun.max.lang.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class X86AddressParameter extends X86NumericalParameter implements AddressParameter {

    public X86AddressParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, width);
        setVariableName("m" + width().numberOfBits());
    }

}
