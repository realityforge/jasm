/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b590a09e-7c6a-4b49-b2bb-cf66d89e23b8*/
package jasm.gen;

import jasm.Argument;
import java.util.Set;

/**
 * An operand that represents a formal parameter of an assembler method.
 *
 * @author Bernd Mathiske
 */
public interface Parameter extends Operand, Comparable<Parameter> {

    /**
     * @return source code variable name
     */
    String variableName();

    /**
     * @return source code for raw int value access
     */
    String valueString();

    Iterable<? extends Argument> getLegalTestArguments();

    Iterable<? extends Argument> getIllegalTestArguments();

    ArgumentRange argumentRange();

    Set<Argument> excludedDisassemblerTestArguments();

    Set<Argument> excludedExternalTestArguments();
}
