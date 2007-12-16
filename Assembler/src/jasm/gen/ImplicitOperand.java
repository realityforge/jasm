/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

import jasm.Argument;

/**
 * An operand that does not correspond to a parameter.
 *
 * @author Bernd Mathiske
 */
public interface ImplicitOperand extends Operand {

    Argument argument();

    /**
     * Determines whether the operand is to be omitted or explicitly stated in external syntax.
     *
     * @author Bernd Mathiske
     */
    public enum ExternalPresence {
        OMITTED, EXPLICIT;
    }

    ExternalPresence externalPresence();
}
