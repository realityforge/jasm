/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b9c7a3df-318f-46b7-a143-78148e7cd0a6*/
package jasm.gen.cisc.x86;

import com.sun.max.lang.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class X86ImmediateParameter extends X86NumericalParameter {

    public X86ImmediateParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, width);
        setVariableName("imm" + width.numberOfBits());
    }
}
