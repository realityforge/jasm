/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.field;

import jasm.Argument;
import jasm.tools.Immediate32Argument;
import jasm.tools.Template;
import jasm.tools.risc.bitRange.BitRange;
import java.util.List;

/**
 * An instruction field whose encoded value does not include bits for
 * the low-order 0 bits of the aligned values that the field represents.
 * This class can convert between the field's <i>argument</i> (i.e.
 * the represented value) and it's <i>operand</i> (i.e. the encoded value).
 */
public class AlignedImmediateOperandField extends ImmediateOperandField {

  protected int _zeroes;

  public AlignedImmediateOperandField(BitRange bitRange, int zeroes) {
    super(bitRange);
    _zeroes = zeroes;
  }

  @Override
  public final String asJavaExpression() {
    final String value = valueString();
    return "(" + super.asJavaExpression() + ") && ((" + value + " % " + grain() + ") == 0)";
  }

  @Override
  public final boolean check(Template template, List<Argument> arguments) {
    if (!super.check(template, arguments)) {
      return false;
    }
    final long value = template.bindingFor(this, arguments).asLong();
    return (value % grain()) == 0;
  }

  @Override
  public final int maxArgumentValue() {
    return super.maxArgumentValue() << zeroes();
  }

  @Override
  public final int minArgumentValue() {
    return super.minArgumentValue() << zeroes();
  }

  @Override
  public final int zeroes() {
    return _zeroes;
  }

  /**
   * Converts an operand value to the argument value that includes
   * low-order 0 bits for the alignment of this field.
   * For example, if this field represents a 4-byte aligned value,
   * then {@code operandToArgument(134) == 536}.
   */
  private int operandToArgument(int operand) {
    return operand << zeroes();
  }

  @Override
  public final Immediate32Argument disassemble(int instruction) {
    return new Immediate32Argument(operandToArgument(extract(instruction)));
  }
}
