/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

import jasm.Argument;
import jasm.WordWidth;

public abstract class ImmediateArgument implements Argument {

    public abstract WordWidth width();

    public abstract String signedExternalValue();

    public abstract Object boxedJavaValue();

    @Override
    public final String toString() {
        return "<" + getClass().getSimpleName() + ": " + externalValue() + ">";
    }

}
