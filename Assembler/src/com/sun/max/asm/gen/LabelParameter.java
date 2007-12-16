/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=17d2ff05-5070-45f5-b398-8bd296e1b2a6*/
package com.sun.max.asm.gen;

import java.util.*;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.collect.*;

/**
 * @author Bernd Mathiske
 */
public class LabelParameter implements Parameter {

    public LabelParameter() {
    }
    
    @Implement(Operand.class)
    public Class type() {
        return Label.class;
    }

    @Implement(Parameter.class)
    public String variableName() {
        return "label";
    }

    @Implement(Parameter.class)
    public String valueString() {
        return variableName();
    }

    @Implement(Parameter.class)
    public ArgumentRange argumentRange() {
        return null;
    }

    
    @Implement(Parameter.class)
    public Iterable<Label> getLegalTestArguments() {
        return Iterables.empty();
    }
    
    @Implement(Parameter.class)
    public Iterable<? extends Argument> getIllegalTestArguments() {
        return Iterables.empty();
    }

    @Implement(Parameter.class)
    public Set<Argument> excludedDisassemblerTestArguments() {
        return Sets.empty(Argument.class);        
    }

    @Implement(Parameter.class)
    public Set<Argument> excludedExternalTestArguments() {
        return Sets.empty(Argument.class);                
    }

    @Implement(Comparable.class)
    public int compareTo(Parameter other) {
        return type().getName().compareTo(other.type().getName());
    }
    
    @Override
    public String toString() {
        return "<LabelParameter>";
    }
    
}
