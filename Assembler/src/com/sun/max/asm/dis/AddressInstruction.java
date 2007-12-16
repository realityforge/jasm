/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6a2c73cb-9eb6-4f30-801d-91f640d8f48f*/
package com.sun.max.asm.dis;

import com.sun.max.asm.gen.*;

/**
 * Delegation interface (for lack of multiple class inheritance in the Java(TM) Programming Language).
 *
 * @author Bernd Mathiske
 */
public interface AddressInstruction {

    int startOffset();
    
    String addressString();
        
    int addressToOffset(ImmediateArgument argument);
}
