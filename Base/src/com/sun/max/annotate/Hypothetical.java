/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4f1e5e6a-1a97-43b7-9190-202f469b409c*/
package com.sun.max.annotate;

import java.lang.annotation.*;

@Target(ElementType.PACKAGE)

/**
 * Marks a package as untested, non-functioning code that is not ready for anything yet.
 * Don't waste your time reading that package.
 *
 * @author Bernd Mathiske
 */
public @interface Hypothetical {
}
