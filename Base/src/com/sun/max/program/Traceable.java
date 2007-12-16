/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=069ff522-d989-42a9-93bf-be7e246f383f*/
package com.sun.max.program;

import java.io.*;

/**
 * @author Bernd Mathiske
 */
public interface Traceable {

    void printTrace(PrintStream stream, Object... arguments);
    
}
