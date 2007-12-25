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
import java.util.List;

/**
 * An expression can provide the value of an operand field. This enables synthetic instructions to be
 * generated where the parameters of the generated assembler method are part of an expression whose
 * value is encoded into an operand field.
 */
public interface Expression {
  /**
   * Evaluates the expression given a template and a set of arguments.
   */
  long evaluate(Template template, List<Argument> arguments);

  /**
   * @return a Java expression that performs the {@link #evaluate evaluation}
   */
  String valueString();

  public static final class Static {

    private Static() {
    }

    /**
     * Evaluates a given expression term to a {@code long} value.
     *
     * @param term a {@link Number}, {@link Expression} or {@link Parameter} instance
     */
    public static long evaluateTerm(Object term, Template template, List<Argument> arguments) {
      if (term instanceof Number) {
        return ((Number) term).longValue();
      }
      if (term instanceof Expression) {
        return ((Expression) term).evaluate(template, arguments);
      }
      assert term instanceof Parameter;
      return template.bindingFor((Parameter) term, arguments).asLong();
    }

    /**
     * Gets the Java source code representation of a given expression term.
     *
     * @param term a {@link Number}, {@link Expression} or {@link Parameter} instance
     */
    public static String termValueString(Object term) {
      if (term instanceof Parameter) {
        return ((Parameter) term).valueString();
      }
      if (term instanceof Expression) {
        return "(" + ((Expression) term).valueString() + ")";
      }
      assert term instanceof Number;
      return term.toString();
    }

    /**
     * Creates and returns an expression that adds its two terms.
     *
     * @param first  the first term of the addition
     * @param second the second term of the addition
     */
    public static Expression add(final Object first, final Object second) {
      return new Expression() {

        public long evaluate(Template template, List<Argument> arguments) {
          return evaluateTerm(first, template, arguments) + evaluateTerm(second, template, arguments);
        }

        public String valueString() {
          return termValueString(first) + " + " + termValueString(second);
        }
      };
    }

    /**
     * Creates and returns an expression that subtracts its second term from its first term.
     *
     * @param first  the first term of the subtraction
     * @param second the second term of the subtraction
     */
    public static Expression sub(final Object first, final Object second) {
      return new Expression() {

        public long evaluate(Template template, List<Argument> arguments) {
          return evaluateTerm(first, template, arguments) - evaluateTerm(second, template, arguments);
        }

        public String valueString() {
          return termValueString(first) + " - " + termValueString(second);
        }
      };
    }

    /**
     * Creates and returns an expression that negates its term.
     *
     * @param term the term of the negation
     */
    public static Expression neg(final Object term) {
      return new Expression() {

        public long evaluate(Template template, List<Argument> arguments) {
          return -evaluateTerm(term, template, arguments);
        }

        public String valueString() {
          return "-" + termValueString(term);
        }
      };
    }
  }
}
