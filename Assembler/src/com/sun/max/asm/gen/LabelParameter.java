/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=17d2ff05-5070-45f5-b398-8bd296e1b2a6*/
package com.sun.max.asm.gen;

import com.sun.max.asm.Argument;
import com.sun.max.asm.Label;
import com.sun.max.collect.Iterables;
import com.sun.max.collect.Sets;
import java.util.Set;

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
        return Sets.empty(Argument.class);
    }

    public Set<Argument> excludedExternalTestArguments() {
        return Sets.empty(Argument.class);
    }

    public int compareTo(Parameter other) {
        return type().getName().compareTo(other.type().getName());
    }

    @Override
    public String toString() {
        return "<LabelParameter>";
    }

}
