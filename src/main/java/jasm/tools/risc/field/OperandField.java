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
import jasm.ExternalMnemonicSuffixArgument;
import jasm.tools.Parameter;
import jasm.tools.Template;
import jasm.tools.risc.RiscConstant;
import jasm.tools.risc.bitRange.BitRange;
import jasm.util.StaticLoophole;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * An operand field defines an instruction field whose value is given as a parameter in the generated
 * assembler method. The field is also a parameter in the external assembler syntax unless
 * it's {@link #type value type} implements {@link ExternalMnemonicSuffixArgument} in which
 * case, the field's value is represented as a suffix of the mnemonic in the external assembler syntax.
 */
public abstract class OperandField<Argument_Type extends Argument> extends RiscField implements Parameter, Expression {

  private SignDependentOperations _signDependentOperations;
  private String _variableName;
  private Set<Argument> _excludedDisassemblerTestArguments = Collections.emptySet();
  private Set<Argument> _excludedExternalTestArguments = Collections.emptySet();
  private Expression _expression;

  protected OperandField(BitRange bitRange) {
    super(bitRange);
    _signDependentOperations = SignDependentOperations.UNSIGNED;
  }

  public final RiscConstant constant(int value) {
    return new RiscConstant(new ConstantField(name(), bitRange()), value);
  }

  protected final SignDependentOperations signDependentOperations() {
    return _signDependentOperations;
  }

  protected final void setSignDependentOperations(SignDependentOperations signDependentOperations) {
    _signDependentOperations = signDependentOperations;
  }

  public int maxArgumentValue() {
    return _signDependentOperations.maxArgumentValue(bitRange());
  }

  public int minArgumentValue() {
    return _signDependentOperations.minArgumentValue(bitRange());
  }

  public final int extract(int instruction) {
    return _signDependentOperations.extract(instruction, bitRange());
  }

  public abstract Argument_Type disassemble(int instruction);

  /** @return the minimal difference between any two potential operands */
  public final int grain() {
    return 1 << zeroes();
  }

  /** @return implied zeroes to be "appended" to respective operands */
  public int zeroes() {
    return 0;
  }

  @Override
  public final OperandField<Argument_Type> clone() {
    return StaticLoophole.cast(super.clone());
  }

  public OperandField<Argument_Type> beSigned() {
    final OperandField<Argument_Type> result = clone();
    result.setSignDependentOperations(SignDependentOperations.SIGNED);
    return result;
  }

  public OperandField<Argument_Type> beSignedOrUnsigned() {
    final OperandField<Argument_Type> result = clone();
    result.setSignDependentOperations(SignDependentOperations.SIGNED_OR_UNSIGNED);
    return result;
  }

  public final boolean isSigned() {
    return _signDependentOperations == SignDependentOperations.SIGNED;
  }

  public final String variableName() {
    if (_variableName != null) {
      return _variableName;
    }
    return name();
  }

  public OperandField<Argument_Type> setVariableName(String name) {
    _variableName = name;
    return this;
  }

  public final Set<Argument> excludedDisassemblerTestArguments() {
    return _excludedDisassemblerTestArguments;
  }

  public final Set<Argument> excludedExternalTestArguments() {
    return _excludedExternalTestArguments;
  }

  public final int compareTo(Parameter other) {
    return type().getName().compareTo(other.type().getName());
  }

  public final long evaluate(Template<?> template, List<Argument> arguments) {
    if (boundTo() != null) {
      return boundTo().evaluate(template, arguments);
    }
    return template.bindingFor(this, arguments).asLong();
  }

  public OperandField<Argument_Type> bindTo(Expression expression) {
    final OperandField<Argument_Type> result = clone();
    result._expression = expression;
    return result;
  }

  public final Expression boundTo() {
    return _expression;
  }
}
