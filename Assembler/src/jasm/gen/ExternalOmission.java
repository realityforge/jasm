/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen;

/**
 * Wrapper for a specification in an instruction description that indicates that whatever
 * is specified is omitted in the external assembler syntax.
 *
 * @author Bernd Mathiske
 */
public class ExternalOmission {

    private final Object _specification;

    public ExternalOmission(Object specification) {
        _specification = specification;
    }

    public Object wrappedSpecification() {
        return _specification;
    }

}
