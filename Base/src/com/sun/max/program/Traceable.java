/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.program;

import java.io.PrintStream;

/**
 * @author Bernd Mathiske
 */
public interface Traceable {

    void printTrace(PrintStream stream, Object... arguments);

}
