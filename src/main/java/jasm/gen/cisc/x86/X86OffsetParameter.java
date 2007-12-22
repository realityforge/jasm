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
import jasm.gen.OffsetParameter;

/**
 * @author Bernd Mathiske
 */
public class X86OffsetParameter extends X86NumericalParameter implements OffsetParameter {

    public X86OffsetParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, width);
        setVariableName("rel" + width.numberOfBits());
    }
}
