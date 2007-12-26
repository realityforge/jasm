/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.Assembler;
import jasm.EnumerableArgument;
import jasm.LabelAddressInstruction;
import jasm.LabelOffsetInstruction;
import jasm.WordWidth;
import jasm.tools.Assembly;
import jasm.tools.Parameter;
import jasm.tools.gen.as.AssemblerGenerator;
import jasm.tools.util.IndentWriter;
import jasm.util.ArrayUtil;
import jasm.util.Enums;
import jasm.util.HexUtil;
import jasm.util.StaticLoophole;
import jasm.x86.as.X86Assembler;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class X86AssemblerGenerator<Template_Type extends X86Template>
    extends AssemblerGenerator<Template_Type> {
  private static final String OPCODE1_VARIABLE_NAME = "opcode1";
  private static final String OPCODE2_VARIABLE_NAME = "opcode2";
  private static final String MODRM_GROUP_OPCODE_VARIABLE_NAME = "modRmOpcode";

  private final WordWidth _addressWidth;
  private final boolean _promoteEnumerableParameters;
  private final Map<String, String> _subroutineToName = new HashMap<String, String>();
  private int _subroutineSerial;

  protected X86AssemblerGenerator(Assembly<Template_Type> assembly,
                                  WordWidth addressWidth,
                                  final boolean promoteEnumerableParameters) {
    super(assembly, true);
    _addressWidth = addressWidth;
    _promoteEnumerableParameters = promoteEnumerableParameters;
  }

  @Override
  public final X86Assembly<Template_Type> assembly() {
    return StaticLoophole.cast(super.assembly());
  }

  public final WordWidth addressWidth() {
    return _addressWidth;
  }

  @Override
  protected final Class<? extends Assembler> parentAssemblerClass() {
    return X86Assembler.class;
  }

  protected final X86Parameter getParameter(Template_Type template, Class parameterType) {
    for (X86Parameter parameter : template.parameters()) {
      if (parameter.type() == parameterType) {
        return parameter;
      }
    }
    throw new IllegalStateException("found no parameter of type: " + parameterType);
  }

  private void printCallWithByteDisplacement(IndentWriter writer, Template_Type template, Class argumentType) {
    final Template_Type modVariantTemplate = X86Assembly.getModVariantTemplate(assembly().templates(), template, argumentType);
    final String subroutineName = makeSubroutine(modVariantTemplate);
    writer.print(subroutineName + "(");
    if (template.opcode2() != null) {
      writer.print(OPCODE2_VARIABLE_NAME);
    } else {
      writer.print(OPCODE1_VARIABLE_NAME);
    }
    if (template.modRMGroupOpcode() != null) {
      writer.print(", " + MODRM_GROUP_OPCODE_VARIABLE_NAME);
    }
    for (X86Parameter parameter : template.parameters()) {
      if (parameter.type() == argumentType) {
        writer.print(", (byte) 0");
      }
      writer.print(", " + parameter.variableName());
    }
    writer.println(");");
  }

  protected final String asIdentifier(EnumerableArgument argument) {
    return argument.getClass().getSimpleName() + "." +
           argument.name() + (_promoteEnumerableParameters ? ".value()" : "");
  }

  protected final <Argument_Type extends Enum<Argument_Type> & EnumerableArgument> void printModVariant(IndentWriter writer,
                                                                                                        final Template_Type template, Argument_Type... arguments) {
    final Class argumentType = arguments[0].getClass();
    final X86Parameter parameter = getParameter(template, argumentType);
    writer.print("if (");
    String separator = "";
    for (EnumerableArgument argument : arguments) {
      writer.print(separator + parameter.variableName() + " == " + asIdentifier(argument));
      separator = " || ";
    }
    writer.println(") {");
    writer.indent();
    printCallWithByteDisplacement(writer, template, argumentType);
    writer.println("return;");
    writer.outdent();
    writer.println("}");
  }

  protected abstract void printModVariants(IndentWriter writer, Template_Type template);

  protected void printPrefixes(IndentWriter writer, Template_Type template) {
    if (template.addressSizeAttribute() != addressWidth()) {
      emitByte(writer, X86InstructionPrefix.ADDRESS_SIZE.getValue().byteValue());
      writer.println(" // address size prefix");
    }
    if (template.operandSizeAttribute() == WordWidth.BITS_16) {
      emitByte(writer, X86InstructionPrefix.OPERAND_SIZE.getValue().byteValue());
      writer.println(" // operand size prefix");
    }
    if (template.instructionSelectionPrefix() != null) {
      emitByte(writer, template.instructionSelectionPrefix().getValue().byteValue());
      writer.println(" // instruction selection prefix");
    }
  }

  protected final String subroutineEnumUse(X86Parameter parameter) {
    return _promoteEnumerableParameters ? parameter.variableName() : parameter.valueString();
  }

  private void printOpcode(IndentWriter writer, Template_Type template, String opcodeVarName,
                           final ParameterPlace parameterPlace32, ParameterPlace parameterPlace64) {
    String comment = "";
    String opcodeVariableName = opcodeVarName;
    for (X86Parameter parameter : template.parameters()) {
      if (parameter.place() == parameterPlace32) {
        opcodeVariableName += " + " + subroutineEnumUse(parameter);
        comment = " // " + parameterPlace32.name().toLowerCase();
      } else if (parameter.place() == parameterPlace64) {
        opcodeVariableName += " + (" + subroutineEnumUse(parameter) + "& 7)";
        comment = " // " + parameterPlace64.name().toLowerCase();
      }
    }
    if (comment.length() == 0) {
      emitByte(writer, opcodeVariableName);
      writer.println();
    } else {
      emitByte(writer, "(byte) (" + opcodeVariableName + ")");
      writer.println(comment);
    }
  }

  private void printModRMByte(IndentWriter writer, Template_Type template) {
    String mod = String.valueOf(template.modCase().ordinal());
    String rm = "0";
    String reg = "0";

    final ModRMGroup.Opcode opcode = template.modRMGroupOpcode();
    if (opcode != null) {
      reg = MODRM_GROUP_OPCODE_VARIABLE_NAME;
    }
    switch (template.rmCase()) {
      case SIB:
      case SWORD:
      case SDWORD: {
        rm = String.valueOf(template.rmCase().value());
        break;
      }
      default:
        break;
    }
    for (X86Parameter parameter : template.parameters()) {
      switch (parameter.place()) {
        case MOD_REG:
        case MOD_REG_REXR: {
          reg = subroutineEnumUse(parameter);
          break;
        }
        case MOD_RM:
        case MOD_RM_REXB: {
          rm = subroutineEnumUse(parameter);
          break;
        }
        default:
          break;
      }
    }
    writer.println("emitModRM(" + mod + "," + rm + "," + reg + ");");
  }

  private void printSibByte(IndentWriter writer, Template_Type template) {
    String base = (template.sibBaseCase() == SibBaseCase.SPECIAL) ? "5" : "0";
    String index = "0";
    String scale = "0";
    for (X86Parameter parameter : template.parameters()) {
      switch (parameter.place()) {
        case SIB_BASE:
        case SIB_BASE_REXB:
          base += " | " + subroutineEnumUse(parameter);
          break;
        case SIB_INDEX:
        case SIB_INDEX_REXX:
          index = subroutineEnumUse(parameter);
          break;
        case SIB_SCALE:
          scale = subroutineEnumUse(parameter);
          break;
        default:
          break;
      }
    }
    writer.println("emitSibByte(" + base + "," + index + "," + scale + ");");
  }

  protected final <Argument_Type extends Enum<Argument_Type> & EnumerableArgument>
  void printSibVariant(IndentWriter writer, Template_Type template, Argument_Type... arguments) {
    final Class argumentType = arguments[0].getClass();
    final X86Parameter parameter = getParameter(template, argumentType);
    writer.print("if (");
    String separator = "";
    for (EnumerableArgument argument : arguments) {
      writer.print(separator + parameter.variableName() + " == " + asIdentifier(argument));
      separator = " || ";
    }
    writer.println(") {");
    writer.indent();
    emitByte(writer, (byte) 0x24);
    writer.println(" // SIB byte");
    writer.outdent();
    writer.println("}");
  }

  protected abstract void printSibVariants(IndentWriter writer, Template_Type template);

  private void printImmediateParameter(IndentWriter writer, X86NumericalParameter parameter) {
    switch (parameter.width().numberOfBytes() )
    {
      case 8: writer.println("emitLong(" + parameter.variableName() + ");"); break;
      case 4: writer.println("emitInt(" + parameter.variableName() + ");"); break;
      case 2: writer.println("emitShort(" + parameter.variableName() + ");"); break;
      case 1: writer.println("emitByte(" + parameter.variableName() + ");"); break;
      default:
        throw new IllegalStateException("Unexpected byte count: " + parameter.width().numberOfBytes());
    }
  }

  private void printAppendedEnumerableParameter(IndentWriter writer, X86EnumerableParameter parameter) {
    emitByte(writer, "(byte) " + parameter.variableName() + ".value()");
    writer.println(" // appended");
  }

  private void printAppendedParameter(IndentWriter writer, Template_Type template) {
    for (X86Parameter parameter : template.parameters()) {
      if (parameter.place() == ParameterPlace.IMMEDIATE ||
          parameter.place() == ParameterPlace.DISPLACEMENT) {
        printImmediateParameter(writer, (X86NumericalParameter) parameter);
      }
      else if (parameter.place() == ParameterPlace.APPEND) {
        printAppendedEnumerableParameter(writer, (X86EnumerableParameter) parameter);
      }
    }
  }

  private String createSubroutineName() {
    ++_subroutineSerial;
    String number = Integer.toString(_subroutineSerial);
    while (number.length() < 4) {
      number = "0" + number;
    }
    return "assemble" + number;
  }

  private void printSubroutine(IndentWriter writer, Template_Type template) {
    writer.print("(byte ");
    if (template.opcode2() != null) {
      writer.print(OPCODE2_VARIABLE_NAME);
    } else {
      writer.print(OPCODE1_VARIABLE_NAME);
    }
    if (template.modRMGroupOpcode() != null) {
      writer.print(", byte " + MODRM_GROUP_OPCODE_VARIABLE_NAME);
    }
    writer.print(formatParameterList(", ", template.parameters(), false, _promoteEnumerableParameters));
    writer.println(") {");
    writer.indent();
    writer.indent();
    printModVariants(writer, template);
    printPrefixes(writer, template);
    if (template.opcode2() != null) {
      emitByte(writer, "(byte) (" + HexUtil.toHexLiteral(template.opcode1().byteValue()) + ")");
      writer.println(" // " + OPCODE1_VARIABLE_NAME);
      printOpcode(writer, template, OPCODE2_VARIABLE_NAME, ParameterPlace.OPCODE2, ParameterPlace.OPCODE2_REXB);
    } else {
      printOpcode(writer, template, OPCODE1_VARIABLE_NAME, ParameterPlace.OPCODE1, ParameterPlace.OPCODE1_REXB);
    }
    if (template.hasModRMByte()) {
      printModRMByte(writer, template);
      if (template.hasSibByte()) {
        printSibByte(writer, template);
      } else {
        printSibVariants(writer, template);
      }
    }
    printAppendedParameter(writer, template);
    writer.outdent();
    writer.println("}");
    writer.outdent();
  }

  private String makeSubroutine(Template_Type template) {
    final StringWriter stringWriter = new StringWriter();
    printSubroutine(new IndentWriter(new PrintWriter(stringWriter)), template);
    final String subroutine = stringWriter.toString();
    String name = _subroutineToName.get(subroutine);
    if (name == null) {
      name = createSubroutineName();
      _subroutineToName.put(subroutine, name);
    }
    return name;
  }

  @Override
  protected final int printMethod(IndentWriter writer, Template_Type template) {
    final int startLineCount = writer.lineCount();
    writer.print("@Inline");
    writer.println();
    writer.print("public final void ");
    writer.print(template.assemblerMethodName() + "(");
    writer.print(formatParameterList("", template.parameters(), false));
    writer.println(") {");
    writer.indent();
    final String subroutineName = makeSubroutine(template);
    writer.print(subroutineName + "(");
    if (template.opcode2() != null) {
      writer.print("(byte) " + HexUtil.toHexLiteral(template.opcode2().byteValue()));
    } else {
      writer.print("(byte) " + HexUtil.toHexLiteral(template.opcode1().byteValue()));
    }
    if (template.modRMGroupOpcode() != null) {
      writer.print(", (byte) " + HexUtil.toHexLiteral(template.modRMGroupOpcode().byteValue()));
    }
    for (X86Parameter parameter : template.parameters()) {
      if (_promoteEnumerableParameters && parameter instanceof X86EnumerableParameter) {
        writer.print(", " + parameter.valueString());
      } else {
        writer.print(", " + parameter.variableName());
      }
    }
    writer.println(");");
    writer.outdent();
    writer.println("}");
    return writer.lineCount() - startLineCount;
  }

  @Override
  protected final int printSubroutines(IndentWriter writer) {
    final Set<String> subroutineSet = _subroutineToName.keySet();
    final String[] subroutines = subroutineSet.toArray(new String[subroutineSet.size()]);
    for (int i = 0; i < subroutines.length; i++) {
      subroutines[i] = _subroutineToName.get(subroutines[i]) + subroutines[i];
    }
    Arrays.sort(subroutines);
    for (String subroutine : subroutines) {
      writer.print("private void " + subroutine);
      writer.println();
    }
    return subroutines.length;
  }

  private boolean parametersMatching(Template_Type candidate, Template_Type original) {
    if (candidate.parameters().size() != original.parameters().size()) {
      return false;
    }
    for (int i = 0; i < candidate.parameters().size(); i++) {
      if (i == original.labelParameterIndex()) {
        assert candidate.parameters().get(i).getClass() == X86OffsetParameter.class || candidate.parameters().get(i).getClass() == X86AddressParameter.class;
        assert candidate.parameters().get(i).getClass() == original.parameters().get(i).getClass();
      } else if (candidate.parameters().get(i).type() != original.parameters().get(i).type()) {
        return false;
      }
    }
    return true;
  }

  private final class LabelWidthCase {
    private final WordWidth _width;
    private final Template_Type _template;

    private LabelWidthCase(WordWidth width, Template_Type template) {
      _width = width;
      _template = template;
    }
  }

  private int getLabelWidthSequenceIndex(List<LabelWidthCase> labelWidthCases) {
    final EnumSet<WordWidth> enumSet = EnumSet.noneOf(WordWidth.class);
    for (LabelWidthCase labelWidthCase : labelWidthCases) {
      enumSet.add(labelWidthCase._width);
    }
    return Enums.powerSequenceIndex(enumSet);
  }

  private List<LabelWidthCase> getRelatedLabelTemplatesByWidth(Template_Type template,
                                                               List<Template_Type> labelTemplates) {
    final LabelWidthCase[] array = ArrayUtil.create(LabelWidthCase.class, WordWidth.values().length);
    for (Template_Type t : labelTemplates) {
      if (t.assemblerMethodName().equals(template.assemblerMethodName()) &&
          t.labelParameterIndex() == template.labelParameterIndex() &&
          parametersMatching(t, template)) {
        final X86NumericalParameter numericalParameter =
            (X86NumericalParameter) t.parameters().get(template.labelParameterIndex());
        final WordWidth width = numericalParameter.width();
        array[width.ordinal()] = new LabelWidthCase(width, t);
        t._isLabelMethodWritten = true;
      }
    }
    // Report the found cases in the order of ascending width:
    final ArrayList<LabelWidthCase> result = new ArrayList<LabelWidthCase>();
    for (final LabelWidthCase labelWidthCase : array) {
      if (labelWidthCase != null) {
        assert result.isEmpty() || labelWidthCase._width.greaterThan(result.get(result.size() - 1)._width);
        result.add(labelWidthCase);
      }
    }
    assert result.size() > 0;
    return result;
  }

  private void printOffsetLabelMethod(IndentWriter writer, Template_Type template, List<Template_Type> labelTemplates) {
    Template_Type thisTemplate = template;
    final List<Parameter> parameters = printLabelMethodHead(writer, thisTemplate);
    final List<LabelWidthCase> labelWidthCases = getRelatedLabelTemplatesByWidth(thisTemplate, labelTemplates);
    thisTemplate = labelWidthCases.get(0)._template; // first use the template that will produce the least bytes
    writer.println("final int startOffset = currentOffset();");
    printInitialRawCall(writer, thisTemplate);
    writer.print("new " + LabelOffsetInstruction.class.getSimpleName());
    writer.println("(this, startOffset, currentOffset(), " + parameters.get(thisTemplate.labelParameterIndex()).variableName() + ", " + getLabelWidthSequenceIndex(labelWidthCases) + ") {");
    writer.indent();
    writer.println("@Override");
    writer.println("protected int templateSerial() { return " + template.serial() + "; }");
    writer.println("@Override");
    writer.println("protected void assemble() throws AssemblyException {");
    writer.indent();
    if (labelWidthCases.size() == 1) {
      printRawCall(writer, thisTemplate, parameters);
    } else {
      writer.println("switch (labelWidth()) {");
      writer.indent();
      for (LabelWidthCase labelWidthCase : labelWidthCases) {
        writer.println("case " + labelWidthCase._width.name() + ": {");
        writer.indent();
        printRawCall(writer, labelWidthCase._template, parameters);
        writer.println("break;");
        writer.outdent();
        writer.println("}");
      }
      if (labelWidthCases.size() < WordWidth.values().length) {
        writer.println("default: {");
        writer.indent();
        writer.println("break;");
        writer.outdent();
        writer.println("}");
      }
      writer.outdent();
      writer.println("}");
    }
    writer.outdent();
    writer.println("}");
    writer.outdent();
    writer.println("};");
    writer.outdent();
    writer.println("}");
    writer.println();
  }

  private void printAddressLabelMethod(IndentWriter writer, Template_Type template) {
    final List<Parameter> parameters = printLabelMethodHead(writer, template);
    template._isLabelMethodWritten = true;
    writer.println("final int startOffset = currentOffset();");
    printInitialRawCall(writer, template);
    writer.print("new " + LabelAddressInstruction.class.getSimpleName());
    writer.println("(this, startOffset, currentOffset(), " + parameters.get(template.labelParameterIndex()).variableName() + ") {");
    writer.indent();
    writer.println("@Override");
    writer.println("protected int templateSerial() { return " + template.serial() + "; }");
    writer.println("@Override");
    writer.println("protected void assemble() throws AssemblyException {");
    writer.indent();
    printRawCall(writer, template, parameters);
    writer.outdent();
    writer.println("}");
    writer.outdent();
    writer.println("};");
    writer.outdent();
    writer.println("}");
    writer.println();
  }

  @Override
  protected final int printLabelMethod(IndentWriter writer, Template_Type labelTemplate, List<Template_Type> labelTemplates) {
    final int startLineCount = writer.lineCount();
    if (labelTemplate.addressSizeAttribute() == addressWidth()) {
      if (!labelTemplate._isLabelMethodWritten) {
        final X86Parameter parameter = labelTemplate.parameters().get(labelTemplate.labelParameterIndex());
        if (parameter instanceof X86OffsetParameter) {
          printOffsetLabelMethod(writer, labelTemplate, labelTemplates);
        } else {
          printAddressLabelMethod(writer, labelTemplate);
        }
      }
    }
    return writer.lineCount() - startLineCount;
  }
}

