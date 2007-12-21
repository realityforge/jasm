/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

import jasm.util.collect.Iterables;
import jasm.Argument;
import jasm.Label;
import java.util.Set;
import java.util.Collections;

/**
 * @author Bernd Mathiske
 */
public class LabelParameter implements Parameter {

    public LabelParameter() {
    }

    public Class type() {
        return Label.class;
    }

    public String variableName() {
        return "label";
    }

    public String valueString() {
        return variableName();
    }

    public ArgumentRange argumentRange() {
        return null;
    }


    public Iterable<Label> getLegalTestArguments() {
        return Iterables.empty();
    }

    public Iterable<? extends Argument> getIllegalTestArguments() {
        return Iterables.empty();
    }

    public Set<Argument> excludedDisassemblerTestArguments() {
      return Collections.emptySet();
    }

    public Set<Argument> excludedExternalTestArguments() {
      return Collections.emptySet();
    }

    public int compareTo(Parameter other) {
        return type().getName().compareTo(other.type().getName());
    }

    @Override
    public String toString() {
        return "<LabelParameter>";
    }

}
