/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.ide;

import com.sun.max.Scheme;

/**
 * @author Bernd Mathiske
 */
public interface TestProgramArgumentScheme extends Scheme {

    String[] getProgramArguments();

}
