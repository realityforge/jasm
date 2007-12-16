/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=c167a4dc-c0a2-4c6b-b2b8-51dba67fc2b9*/
package com.sun.max.ide;

import com.sun.max.Scheme;
import java.io.IOException;

/**
 * @author Bernd Mathiske
 */
public interface ToolChainScheme extends Scheme {

    /**
     * Compiles a given class.
     *
     * @param className
     * @throws IOException
     */
    boolean compile(String className) throws IOException;
}
