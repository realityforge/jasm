/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=88d4e596-8076-427a-83c3-1503cd9b11f5*/
package com.sun.max.util;

/**
 * Signals that something went wrong regarding UTF8 encoding or decoding.
 *
 * @author Bernd Mathiske
 */
public class Utf8Exception extends Exception {

    Utf8Exception() {
        super();
    }
    
    Utf8Exception(String message) {
        super(message);
    }

    Utf8Exception(String message, Throwable cause) {
        super(message, cause);
    }

    Utf8Exception(Throwable cause) {
        super(cause);
    }
    
}
