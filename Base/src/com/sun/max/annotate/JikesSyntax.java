/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=45caa88e-341d-46cd-a4c4-743a3869312e*/
package com.sun.max.annotate;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.LOCAL_VARIABLE, ElementType.METHOD })

/**
 * Mere comment indicating that IBM's Jikes compiler has "special" syntax requirements 
 * due to which we regretfully have to write more code than we normally would like to.
 *
 * @author Bernd Mathiske
 */
public @interface JikesSyntax {
    
    String value();
}
