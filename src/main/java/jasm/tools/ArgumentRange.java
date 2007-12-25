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

public final class ArgumentRange {

  private final WrappableSpecification _specification;
  private final long _minValue;
  private final long _maxValue;

  public ArgumentRange(WrappableSpecification specification, long minValue, long maxValue) {
    _specification = specification;
    _minValue = minValue;
    _maxValue = maxValue;
  }

  public final WrappableSpecification wrappedSpecification() {
    return _specification;
  }

  public final long minValue() {
    return _minValue;
  }

  public final long maxValue() {
    return _maxValue;
  }

  public final boolean includes(Argument argument) {
    return _minValue <= argument.asLong() && argument.asLong() <= _maxValue;
  }

  private boolean _appliesInternally = true;

  public final boolean appliesInternally() {
    return _appliesInternally;
  }

  public final void doNotApplyInternally() {
    _appliesInternally = false;
  }

  public static final ArgumentRange UNSPECIFIED = null;
}
