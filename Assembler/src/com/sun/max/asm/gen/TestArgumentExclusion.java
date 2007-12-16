/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=80269177-832e-439b-8801-a9cf03ba427f*/
package com.sun.max.asm.gen;

import java.util.*;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.collect.*;

/**
 * @author Bernd Mathiske
 */
public class TestArgumentExclusion {

    private final AssemblyTestComponent _component;
    private final WrappableSpecification _specification;
    private final Set<Argument> _arguments;
    
    public TestArgumentExclusion(AssemblyTestComponent component, WrappableSpecification specification, Set<Argument> arguments) {
        _component = component;
        _specification = specification;
        _arguments = arguments;
    }
    
    public AssemblyTestComponent component() {
        return _component;
    }
    
    public WrappableSpecification wrappedSpecification() {
        return _specification;
    }

    public Set<Argument> arguments() {
        return _arguments;
    }
    
    public static final TestArgumentExclusion NONE = new TestArgumentExclusion(AssemblyTestComponent.EXTERNAL_ASSEMBLER, new WrappableSpecification() {
        @Implement(WrappableSpecification.class)
        public TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
            return TestArgumentExclusion.NONE;
        }
    }, Sets.empty(Argument.class));
}
