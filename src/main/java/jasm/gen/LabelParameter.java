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
import jasm.Label;
import java.util.Collections;
import java.util.Set;

/**
 * @author Bernd Mathiske
 */
public final class LabelParameter implements Parameter {

    public LabelParameter() {
    }

    public final Class type() {
        return Label.class;
    }

    public final String variableName() {
        return "label";
    }

    public final String valueString() {
        return variableName();
    }

    public final ArgumentRange argumentRange() {
        return null;
    }


    public final Iterable<Label> getLegalTestArguments() {
      return Collections.emptySet();
    }

    public final Iterable<? extends Argument> getIllegalTestArguments() {
      return Collections.emptySet();
    }

    public final Set<Argument> excludedDisassemblerTestArguments() {
      return Collections.emptySet();
    }

    public final Set<Argument> excludedExternalTestArguments() {
      return Collections.emptySet();
    }

    public final int compareTo(Parameter other) {
        return type().getName().compareTo(other.type().getName());
    }

    @Override
    public final String toString() {
        return "<LabelParameter>";
    }

}
