/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7d24f766-685c-4324-bf89-5c3838f4de80*/
package jasm.gen.cisc.x86;

import jasm.gen.OffsetParameter;
import com.sun.max.lang.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class X86OffsetParameter extends X86NumericalParameter implements OffsetParameter {

    public X86OffsetParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, width);
        setVariableName("rel" + width.numberOfBits());
    }
}
