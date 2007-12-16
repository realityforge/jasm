/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=27ae5e5b-ecb3-4411-9de2-a95708b4adc3*/
package com.sun.max.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.LOCAL_VARIABLE, ElementType.TYPE, ElementType.METHOD })

/**
 * Mere comment indicating that Sun's javac has "special" syntax requirements
 * due to which we regretfully have to write more code than we normally would like to.
 *
 * @author Bernd Mathiske
 */
public @interface JavacSyntax {

    String value();
}
