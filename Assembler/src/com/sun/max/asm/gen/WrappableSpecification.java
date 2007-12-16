/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=24a4b40a-a8ca-490c-bd75-67209d02e72b*/
package com.sun.max.asm.gen;

import com.sun.max.asm.*;



/**
 * @author Bernd Mathiske
 */
public interface WrappableSpecification {

    TestArgumentExclusion excludeExternalTestArguments(Argument... arguments);
    
}
