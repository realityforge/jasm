/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=03e43ed8-09e0-46e6-968f-ee3b3d7c83b5*/
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
