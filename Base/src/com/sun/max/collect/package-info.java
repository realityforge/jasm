/*
 * Copyright (c) 2005 Sun Microsystems, Inc.  All rights reserved.  U.S. Government Rights - Commercial software.
 * Government users are subject to the Sun Microsystems, Inc. standard license agreement and applicable provisions
 * of the FAR and its supplements. Use is subject to license terms. Sun, Sun Microsystems, the Sun logo and
 * Java are trademarks or registered trademarks of Sun Microsystems, Inc. in the U.S. and other countries. All SPARC
 * trademarks are used under license and are trademarks or registered trademarks of SPARC International, Inc. in the
 * U.S. and other countries.
 */
/*VCSID=f21509ce-5067-4d03-a711-ef499b35c011*/
/**
 * More conservative collection classes than in java.util:
 * Instead of relying on dynamic checks, we make more use of static interfaces to narrow down the available set of operations
 * 
 * Also, we are much more "stingy" wrt. offering functionality.
 * 
 * @author Bernd Mathiske
 */
package com.sun.max.collect;
