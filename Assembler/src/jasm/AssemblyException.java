/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d78ca00d-4453-4ae5-8aa2-7d445b91754c*/
package jasm;

/**
 * Thrown when an invalid argument is given to an assembler method.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class AssemblyException extends Exception {

    public AssemblyException(String message) {
        super(message);
    }
}
