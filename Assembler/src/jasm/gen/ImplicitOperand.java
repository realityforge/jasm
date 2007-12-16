/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
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
