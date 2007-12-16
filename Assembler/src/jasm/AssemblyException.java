/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
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
