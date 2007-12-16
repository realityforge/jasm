/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen;

import com.sun.max.collect.Sets;
import jasm.Argument;
import java.util.Set;

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
        public TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
            return TestArgumentExclusion.NONE;
        }
    }, Sets.empty(Argument.class));
}
