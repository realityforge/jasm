/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0a0f17cb-4413-4670-bdf6-992e9d86981f*/
package com.sun.max.ide;

import com.sun.max.*;

/**
 * @author Bernd Mathiske
 */
public interface TestProgramArgumentScheme extends Scheme {

    String[] getProgramArguments();
    
}
