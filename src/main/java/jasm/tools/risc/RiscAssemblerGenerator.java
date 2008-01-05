/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc;

import jasm.Argument;
import jasm.LabelOffsetInstruction;
import jasm.SymbolicArgument;
import jasm.tools.Assembly;
import jasm.tools.ImmediateArgument;
import jasm.tools.InstructionConstraint;
import jasm.tools.LabelParameter;
import jasm.tools.OffsetParameter;
import jasm.tools.Parameter;
import jasm.tools.gen.as.AssemblerGenerator;
import jasm.tools.risc.bitRange.BitRange;
import jasm.tools.risc.field.InputOperandField;
import jasm.tools.risc.field.OperandField;
import jasm.tools.util.CollectionUtil;
import jasm.tools.util.IndentWriter;
import jasm.util.HexUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class RiscAssemblerGenerator<Template_Type extends RiscTemplate<Template_Type>>
    extends AssemblerGenerator<Template_Type> {

  protected RiscAssemblerGenerator(Assembly<Template_Type> assembly) {
    super(assembly);
  }

  private String encode(OperandField operandField, String val) {
    String value = val;
    // Convert the argument value to the operand value
    if (operandField.zeroes() != 0) {
      value = "(" + value + " >> " + operandField.zeroes() + ")";
    }
    return operandField.bitRange().encodingString(value, operandField.isSigned(), false);
  }

  @Override
  protected final void printMethod(IndentWriter writer, Template_Type template) {
    writer.print("public final void ");
    writer.print(template.assemblerMethodName() + "(");
    writer.print(formatParameterList("final ", template.parameters(), false));
    writer.println(") {");
    writer.indent();
    writer.println("int instruction = " + HexUtil.toHexLiteral(template.opcode()) + ";");

    // Print argument constraint checking statements
    final List<InstructionConstraint> constraints = template.description().constraints();
    for (InstructionConstraint constraint : constraints) {
      final String constraintExpr = constraint.asJavaExpression();
      writer.println("if( Config.ENABLE_CONSTRAINT_CHECKS && !(" + constraintExpr + ")) constraintFailed(\"" + constraintExpr + "\");");
    }

    for (OperandField operandField : template.operandFields()) {
      if (operandField instanceof InputOperandField) {
        continue;
      }
      writer.println("instruction |= " + encode(operandField, operandField.valueString()) + ";");
    }

    writer.println("emitInt(instruction);");
    writer.outdent();
    writer.println("}");
  }

  @Override
  protected final void printLabelMethod(IndentWriter writer, Template_Type labelTemplate, List<Template_Type> labelTemplates) {
    final List<? extends Parameter> parameters = printLabelMethodHead(writer, labelTemplate);
    writer.println("emitInt(0); // instruction place holder");
    writer.print("new " + LabelOffsetInstruction.class.getSimpleName());
    writer.println("(this, " + parameters.get(labelTemplate.labelParameterIndex()).variableName() + ") {");
    writer.indent();
    writer.println("@Override");
    writer.println("protected int templateSerial() { return " + labelTemplate.serial() + "; }");
    writer.println("@Override");
    writer.println("protected void assemble() throws AssemblyException {");
    writer.indent();
    printRawCall(writer, labelTemplate, parameters);
    writer.outdent();
    writer.println("}");
    writer.outdent();
    writer.println("};");
    writer.outdent();
    writer.println("}");
    writer.println();
  }

  /** Prints the reference to the raw method from which a synthetic method was defined. */
  @Override
  protected final void printExtraMethodJavadoc(IndentWriter writer,
                                               Template_Type template,
                                               ArrayList<String> extraLinks) {
    if (template.description().isSynthetic()) {
      final RiscTemplate<Template_Type> rawTemplate = template.synthesizedFrom();
      final List<? extends Parameter> parameters = getParameters(rawTemplate);
      final String ref = rawTemplate.internalName() + "(" + formatParameterList("", parameters, true) + ")";
      writer.println(" * <p>");
      writer.print(" * This is a synthetic instruction equivalent to: {@code " + rawTemplate.internalName() + "(");
      extraLinks.add("#" + ref);

      boolean firstOperand = true;
      for (OperandField rawOperand : rawTemplate.operandFields()) {
        if (!firstOperand) {
          writer.print(", ");
        }
        writer.print(getRawOperandReplacement(template, rawOperand));
        firstOperand = false;
      }

      writer.println(")}");
    }
    final List<InstructionConstraint> constraints = template.description().constraints();
    if (!constraints.isEmpty()) {
      writer.println(" * <p>");
      for (InstructionConstraint constraint : constraints) {
        final Method predicateMethod = constraint.predicateMethod();
        if (predicateMethod != null) {
          extraLinks.add(predicateMethod.getDeclaringClass().getName() + "#" + predicateMethod.getName());
        }
        writer.println(" * Constraint: {@code " + constraint.asJavaExpression() + "}<br />");
      }
    }
  }

  /**
   * Gets the expression in terms of the parameters and opcode of a synthetic instruction that replaces a parameter of
   * the raw instruction from which the synthetic operand was derived.
   *
   * @param syntheticTemplate the synthetic instruction
   * @param rawOperand        a parameter of {@code rawTemplate}
   */
  private String getRawOperandReplacement(RiscTemplate<Template_Type> syntheticTemplate,
                                          OperandField rawOperand) {
    if (-1 != CollectionUtil.indexOfIdentical(syntheticTemplate.operandFields(), rawOperand)) {
      if (rawOperand instanceof OffsetParameter && generatingLabelAssembler()) {
        return new LabelParameter().variableName();
      }
      return rawOperand.variableName();
    }

    final int rawOperandMask = rawOperand.bitRange().instructionMask();
    String expression = null;
    if ((syntheticTemplate.opcodeMask() & rawOperandMask) != 0) {
      // Some or all bits of the raw operand are encoded as part of the synthetic instruction opcode
      final Argument value = rawOperand.disassemble(syntheticTemplate.opcode());
      assert value != null;
      if (value instanceof SymbolicArgument) {
        expression = ((SymbolicArgument) value).name();
      } else if (value instanceof Enum) {
        expression = ((Enum) value).name();
      } else if (value instanceof ImmediateArgument) {
        expression = Long.toString(value.asLong());
      } else {
        throw new IllegalStateException("unknown type of disassembled value: " + value.getClass().getName());
      }
    }
    if ((syntheticTemplate.opcodeMask() & rawOperandMask) != rawOperandMask) {
      // Some or all bits of the raw operand are given as a parameter of the synthetic instruction
      for (OperandField syntheticOperand : syntheticTemplate.operandFields()) {
        final int syntheticOperandMask = syntheticOperand.bitRange().instructionMask();
        if ((syntheticOperandMask & rawOperandMask) != 0) {
          final String term;
          if (syntheticOperand.boundTo() != null) {
            term = syntheticOperand.boundTo().valueString();
          } else {
            assert (syntheticOperandMask & rawOperandMask) == syntheticOperandMask :
                "cannot handle synthetic parameter that defines bits that are not a subset of bits defined by a raw parameter";
            final BitRange subFieldRange = syntheticOperand.bitRange().move(false, syntheticOperand.bitRange().numberOfLessSignificantBits());
            final int shift = syntheticOperand.bitRange().numberOfLessSignificantBits() - rawOperand.bitRange().numberOfLessSignificantBits();
            final String value = syntheticOperand.variableName();
            final String assembledSubField = subFieldRange.encodingString(value, syntheticOperand.isSigned(), true);
            if (shift != 0) {
              term = "(" + assembledSubField + " * " + (1 << shift) + ")";
            } else {
              term = assembledSubField;
            }
          }

          if (expression != null && !expression.equals("0")) {
            expression += " | " + term;
          } else {
            expression = term;
          }
        }
      }
    }
    assert expression != null;
    return expression;
  }
}
