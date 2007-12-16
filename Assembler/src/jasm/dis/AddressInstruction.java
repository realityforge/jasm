/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.dis;

import jasm.gen.ImmediateArgument;

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
