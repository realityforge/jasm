/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc;

/**
 * Thrown to abruptly stop template creation in some corner cases
 * that would otherwise be hard to describe.
 *
 * @author Bernd Mathiske
 */
public class TemplateNotNeededException extends Exception {

    public TemplateNotNeededException() {
        super();
    }
}
