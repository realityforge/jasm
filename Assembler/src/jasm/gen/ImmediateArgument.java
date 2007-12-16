/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen;

import jasm.Argument;
import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public abstract class ImmediateArgument implements Argument {

    public abstract WordWidth width();

    public abstract String signedExternalValue();

    public abstract Object boxedJavaValue();

    @Override
    public final String toString() {
        return "<" + getClass().getSimpleName() + ": " + externalValue() + ">";
    }

}
