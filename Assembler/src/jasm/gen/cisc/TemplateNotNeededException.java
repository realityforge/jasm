/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0908e1b4-15f2-4895-ad56-a93f7729ce49*/
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
