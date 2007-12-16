/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d7e5848e-d370-4323-8be5-c9d9f452271f*/
package com.sun.max.annotate;
import java.lang.annotation.*;

@Target(ElementType.TYPE)

/**
 * Indicates that a class' source code has been generated, not manually written.
 */
public @interface Generated {
    Class value();    
}
