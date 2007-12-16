/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=03ca55d7-109a-49bd-a065-8fd1033f0460*/
package com.sun.max.asm.sparc;

import com.sun.max.asm.*;
import com.sun.max.util.*;

/**
 * The argument to a Branch on Integer Register with Prediction instruction specifying
 * the conditional test to be performed.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class BPr extends NameSuffixSymbolicArgument {

    private BPr(int value) {
        super(value);
    }
    
    public static final BPr Z = new BPr(1);
    public static final BPr LEZ = new BPr(2);
    public static final BPr LZ = new BPr(3);
    public static final BPr NZ = new BPr(5);
    public static final BPr GZ = new BPr(6);
    public static final BPr GEZ = new BPr(7);
    
    public static final Symbolizer<BPr> SYMBOLIZER = Symbolizer.Static.initialize(BPr.class);

}
