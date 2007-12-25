/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.test.correctness;

import jasm.Argument;
import jasm.tools.ArgumentRange;
import jasm.tools.Parameter;
import jasm.tools.Template;
import jasm.tools.util.CollectionUtil;
import jasm.util.StaticLoophole;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is an iterator over a (lazily generated) selection of test cases for a given template.
 * Using an iterator means that each test case is generated as needed and does not
 * use up memory longer than necessary. This helps prevent out of memory errors
 * for templates where the number of test cases can be very large.
 * <p/>
 * It is important to note that the value returned by {@link #next()} is only valid
 * until {@code next()} is called again. That is, the same <code>Sequence<Argument></code>
 * object is returned by each call to {@code next()}, only its contents have changed.
 */
final class ArgumentListIterator<Template_Type extends Template> implements Iterator<List<Argument>> {

  private final Template_Type _template;
  private final Parameter[] _parameters;
  private final Iterator<? extends Argument>[] _testArgumentIterators;
  private final int _count;
  private final Argument[] _arguments;
  private final List<Argument> _next;
  private final TestCaseLegality _testCaseLegality;

  private boolean _hasNext;
  private boolean _advanced;
  private int _iterations;
  private AssemblyTester<Template_Type, ?> tester;

  /**
   * Creates an iterator over a set of test cases for a given template.
   */
  ArgumentListIterator(final AssemblyTester<Template_Type, ?> tester, Template_Type template,
                       TestCaseLegality testCaseLegality) {
    this.tester = tester;
    _testCaseLegality = testCaseLegality;
    _template = template;
    _parameters = CollectionUtil.toArray(template.parameters(), Parameter.class);
    _count = template.parameters().size();
    _arguments = new Argument[_count];
    _next = Arrays.asList(_arguments);
    _testArgumentIterators = StaticLoophole.cast(new Iterator[_count]);
    _hasNext = advance();
  }

  /**
   * @return the number of times {@link #next} has been invoked on this iterator without throwing a NoSuchElementException.
   */
  public final int iterations() {
    return _iterations;
  }

  public final boolean hasNext() {
    if (_count == 0) {
      return _testCaseLegality == TestCaseLegality.LEGAL && _iterations == 0;
    }
    if (!_advanced) {
      _hasNext = advance();
    }
    return _hasNext;
  }

  /**
   * The returned sequence is only valid for a single iteration and so should be copied
   * if needed after this iteration.
   */
  public final List<Argument> next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    _advanced = false;
    ++_iterations;
    return _next;
  }

  /**
   * Advances this iterator to the next argument list.
   *
   * @return true if the iterator could advance
   */
  private boolean advance() {
    assert !_advanced;
    _advanced = true;
    if (_count == 0) {
      return _testCaseLegality == TestCaseLegality.LEGAL;
    }
    boolean result;
    do {
      result = advance0();
    } while (result && tester.isLegalArgumentList(_template, _next) !=
        (_testCaseLegality == TestCaseLegality.LEGAL));
    return result;
  }

  /**
   * Advances the test argument iterator for parameter {@code i}.
   *
   * @return true if the iterator could advance
   */
  private boolean advanceArgumentFor(int i) {
    if (_testArgumentIterators[i].hasNext()) {
      _arguments[i] = _testArgumentIterators[i].next();
      return true;
    }
    return false;
  }

  /**
   * Advances this iterator to the next (potentially invalid) argument list.
   *
   * @return true if the iterator could advance
   */
  private boolean advance0() {
    for (int i = _count - 1; i >= 0; --i) {
      if (_testArgumentIterators[i] != null) {
        if (advanceArgumentFor(i)) {
          return true;
        }
        if (i == 0) {
          return false;
        }
      }

      // Reset iterator over test arguments of the i'th parameter
      final Parameter parameter = _parameters[i];
      if (_testCaseLegality != TestCaseLegality.ILLEGAL_BY_ARGUMENT) {
        final Iterable<? extends Argument> arguments = parameter.getLegalTestArguments();
        final ArgumentRange argumentRange = parameter.argumentRange();
        if (argumentRange == null || !argumentRange.appliesInternally()) {
          _testArgumentIterators[i] = arguments.iterator();
        } else {
          _testArgumentIterators[i] = new ArgInRangeFilterIterator(arguments.iterator(), argumentRange);
        }
      } else {
        Iterator<? extends Argument> iterator = parameter.getIllegalTestArguments().iterator();
        if (!iterator.hasNext()) {
          // For parameters that have no illegal values (e.g. a symbolic register parameter)
          // at least one argument must be returned otherwise illegal test cases where only
          // one argument is illegal will never be returned by this iterator.
          //
          // Instead of iterating over all the legal arguments for such a parameter, only
          // the last legal value is used. This involves retrieving the iterator twice but
          // that's much cheaper than many more redundant iterations.
          iterator = parameter.getLegalTestArguments().iterator();
          int count = 0;
          while (iterator.hasNext()) {
            ++count;
            ((Iterator) iterator).next();
          }
          int n = count;
          iterator = parameter.getLegalTestArguments().iterator();
          while (n-- > 1) {
            iterator.next();
          }
          assert iterator.hasNext();
          _testArgumentIterators[i] = iterator;
        } else {
          _testArgumentIterators[i] = iterator;
        }
      }
      if (!advanceArgumentFor(i)) {
        return false;
      }
    }
    return true;
  }

  public final void remove() {
    throw new UnsupportedOperationException();
  }
}
