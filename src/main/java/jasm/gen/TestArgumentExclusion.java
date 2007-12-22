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
import jasm.util.lang.StaticLoophole;
import java.util.Collections;
import java.util.Set;

/**
 * @author Bernd Mathiske
 */
public class TestArgumentExclusion {

  private final AssemblyTestComponent _component;
  private final WrappableSpecification _specification;
  private final Set<Argument> _arguments;

  public TestArgumentExclusion(AssemblyTestComponent component, WrappableSpecification specification,
                               Set<Argument> arguments) {
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

  private static TestArgumentExclusion none() {
    final Set<Argument> args = StaticLoophole.cast(Collections.emptySet());
    return new TestArgumentExclusion(AssemblyTestComponent.EXTERNAL_ASSEMBLER, new WrappableSpecification() {
      public TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
        return TestArgumentExclusion.NONE;
      }
    }, args);
  }

  public static final TestArgumentExclusion NONE = none();
}
