/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools;

import jasm.Argument;
import jasm.util.StaticLoophole;
import java.util.Collections;
import java.util.Set;

public final class TestArgumentExclusion {

  public static final TestArgumentExclusion NONE = none();

  private final AssemblyTestComponent _component;
  private final Object _specification;
  private final Set<Argument> _arguments;

  public TestArgumentExclusion(AssemblyTestComponent component,
                               Object specification,
                               Set<Argument> arguments) {
    _component = component;
    _specification = specification;
    _arguments = arguments;
  }

  public final AssemblyTestComponent component() {
    return _component;
  }

  public final Object wrappedSpecification() {
    return _specification;
  }

  public final Set<Argument> arguments() {
    return _arguments;
  }

  public String toString() {
    return "Exclusion[From " + _component +
           " for " + _specification +
           " args=" + _arguments+ "]";
  }

  private static TestArgumentExclusion none() {
    final Set<Argument> args = StaticLoophole.cast(Collections.emptySet());
    return new TestArgumentExclusion(AssemblyTestComponent.EXTERNAL_ASSEMBLER, null, args);
  }
}
