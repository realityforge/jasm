/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.gen.as;

import jasm.Argument;
import jasm.Assembler;
import jasm.ExternalMnemonicSuffixArgument;
import jasm.Label;
import jasm.annotations.Inline;
import jasm.tools.AddressParameter;
import jasm.tools.Assembly;
import jasm.tools.LabelParameter;
import jasm.tools.OffsetParameter;
import jasm.tools.Parameter;
import jasm.tools.Template;
import jasm.tools.util.IndentWriter;
import jasm.util.StaticLoophole;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Source code generator for both the raw assembler and the label assembler. */
public abstract class AssemblerGenerator<Template_Type extends Template<Template_Type>>
    extends AbstractGenerator {

  private final Assembly<Template_Type> _assembly;
  private final List<Template_Type> _templates;

  private boolean _generatingLabelAssembler;

  protected AssemblerGenerator(Assembly<Template_Type> assembly) {
    super(new File("."), "jasm." + assembly.instructionSet().name().toLowerCase() + ".as");
    _assembly = assembly;
    _templates = sort(assembly.templates());
  }

  protected IndentWriter fileProlog(final String name, final String parentClass, final Set<String> imports) throws IOException {
    final IndentWriter writer = super.fileProlog(name, parentClass, imports);
    printAssemblerConstructor(writer, name);
    return writer;
  }

  private void printAssemblerConstructor(IndentWriter writer, String classSimpleName) {
    writer.println("protected " + classSimpleName + "(final int initialMachineCodeCapacity) {");
    writer.indent();
    writer.println("super(initialMachineCodeCapacity);");
    writer.outdent();
    writer.println("}");
  }

  public final Assembly<Template_Type> assembly() {
    return _assembly;
  }

  protected final String formatParameterList(String separator,
                                             List<? extends Parameter> parameters,
                                             boolean typesOnly) {
    String sep = separator;
    final StringBuilder sb = new StringBuilder();
    for (Parameter parameter : parameters) {
      sb.append(sep);
      if (parameter.type().isMemberClass()) {
        sb.append(parameter.type().getEnclosingClass().getSimpleName());
        sb.append(".");
      }
      sb.append(parameter.type().getSimpleName());
      if (!typesOnly) {
        sb.append(" ");
        sb.append(parameter.variableName());
      }
      if (!sep.startsWith(", ")) {
        sep = ", " + sep;
      }
    }
    return sb.toString();
  }

  protected abstract Class<? extends Assembler> parentAssemblerClass();

  private List<Template_Type> templates() {
    return _templates;
  }

  private void printMethodComment(IndentWriter writer, Template_Type template, int number) {
    printMethodJavadoc(writer, template);
    writer.println("// Template#: " + number + ", Serial#: " + template.serial());
  }

  /**
   * Gets a reference to the architecture manual section describing the given template. The
   * returned string should conform to the format of the {@code @see} Javadoc tag.
   */
  protected String getJavadocManualReference(Template_Type template) {
    return null;
  }

  /**
   * Allows subclasses to print ISA specific details for a template. For example, RISC synthetic instructions
   * print what raw instruction they are derived from.
   *
   * @param extraLinks a sequence to which extra javadoc links should be appended
   */
  protected void printExtraMethodJavadoc(IndentWriter writer, Template_Type template, ArrayList<String> extraLinks) {
  }

  /**
   * Writes the javadoc comment for an assembler method.
   *
   * @param template the template from which the assembler method is generated
   */
  protected final void printMethodJavadoc(IndentWriter writer, Template_Type template) {
    final ArrayList<String> extraLinks = new ArrayList<String>();
    final List<? extends Parameter> parameters = getParameters(template);
    writer.println("/**");
    writer.print(" * Pseudo-external assembler syntax: {@code ");
    writer.print(template.externalName() + externalMnemonicSuffixes(parameters));
    writer.println("  }" + externalParameters(parameters));
    printExtraMethodJavadoc(writer, template, extraLinks);

    if (!extraLinks.isEmpty()) {
      writer.println(" *");
      for (String link : extraLinks) {
        writer.println(" * @see " + link);
      }
    }

    final String ref = getJavadocManualReference(template);
    if (ref != null) {
      writer.println(" *");
      writer.println(" * @see " + ref);
    }
    writer.println(" */");
  }

  private String externalParameters(List<? extends Parameter> parameters) {
    final StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (Parameter parameter : parameters) {
      if (!ExternalMnemonicSuffixArgument.class.isAssignableFrom(parameter.type())) {
        if (!first) {
          sb.append(", ");
        }
        sb.append("<i>").append(parameter.variableName()).append("</i>");
        first = false;
      }
    }
    return sb.toString();
  }

  private String externalMnemonicSuffixes(List<? extends Parameter> parameters) {
    final StringBuilder sb = new StringBuilder();
    for (Parameter parameter : parameters) {
      if (ExternalMnemonicSuffixArgument.class.isAssignableFrom(parameter.type())) {
        boolean first = true;
        String close = "]";
        for (Argument argument : parameter.getLegalTestArguments()) {
          final String externalValue = argument.externalValue();
          if (externalValue.length() != 0) {
            if (!first) {
              sb.append("|");
            } else {
              if (((ExternalMnemonicSuffixArgument) argument).isOptional()) {
                sb.append("{");
                close = "}";
              } else {
                sb.append("[");
              }
            }
            sb.append(externalValue);
            first = false;
          }
        }
        sb.append(close);
      }
    }
    return sb.toString();
  }

  /**
   * Gets the parameters for a template, replacing the label parameter with a LabelParameter instance
   * if the template has a label parameter and this generator is currently generating the label assembler.
   */
  protected final List<? extends Parameter> getParameters(Template<?> template) {
    if (!_generatingLabelAssembler || template.labelParameterIndex() == -1) {
      return StaticLoophole.cast(template.parameters());
    }
    final ArrayList<Parameter> parameters = new ArrayList<Parameter>(template.parameters());
    parameters.set(template.labelParameterIndex(), new LabelParameter());
    return parameters;
  }

  protected final List<? extends Parameter> printLabelMethodHead(IndentWriter writer, Template_Type template) {
    final List<? extends Parameter> parameters = getParameters(template);
    writer.print("public final void " + template.assemblerMethodName() + "(");
    writer.print(formatParameterList("final ", parameters, false));
    writer.println(") {");
    writer.indent();
    return parameters;
  }

  protected final void printInitialRawCall(IndentWriter writer, Template_Type template) {
    final List<? extends Parameter> parameters = template.parameters();
    writer.println("final " + parameters.get(template.labelParameterIndex()).type() + " placeHolder = 0;");
    writer.print(template.assemblerMethodName() + "(");
    String separator = "";
    final int parameterCount = parameters.size();
    for (int i = 0; i < parameterCount; i++) {
      writer.print(separator);
      if (i == template.labelParameterIndex()) {
        writer.print("placeHolder");
      } else {
        writer.print(parameters.get(i).variableName());
      }
      separator = ", ";
    }
    writer.println(");");
  }

  protected final void printRawCall(IndentWriter writer,
                                    Template_Type template,
                                    List<? extends Parameter> parameters) {
    writer.print(template.assemblerMethodName() + "(");
    String separator = "";
    for (int i = 0; i < parameters.size(); i++) {
      writer.print(separator);
      if (i == template.labelParameterIndex()) {
        writer.print("label");
        if (template.parameters().get(template.labelParameterIndex()) instanceof OffsetParameter) {
          writer.print("Offset");
        } else {
          assert template.parameters().get(template.labelParameterIndex()) instanceof AddressParameter;
          writer.print("Address");
        }
        writer.print("As" + firstCharToUpperCase(template.parameters().get(i).type().getSimpleName()) + "()");
      } else {
        writer.print(parameters.get(i).variableName());
      }
      separator = ", ";
    }
    writer.println(");");
  }

  private static String firstCharToUpperCase(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }

  protected final boolean generatingLabelAssembler() {
    return _generatingLabelAssembler;
  }

  public final void generate() throws Exception {
    _generatingLabelAssembler = false;
    final String isaName = _assembly.instructionSet().name();
    final String rawName = isaName + "RawAssembler";
    generateRawAssemblerClass(rawName);
    _generatingLabelAssembler = true;
    generateLabelAssemblerClass(isaName + "LabelAssembler", rawName);
  }

  protected void generateRawAssemblerClass(final String name)
      throws IOException {
    final List<Template_Type> templates = templates();
    final Set<String> imports = getRawAssemblerImports(templates);
    final IndentWriter writer =
        fileProlog(name, parentAssemblerClass().getSimpleName(), imports);

    final int templateCount = templates.size();
    for (int i = 0; i < templateCount; i++) {
      writer.println();
      final Template_Type template = templates.get(i);
      printMethodComment(writer, template, i + 1);
      printMethod(writer, template);
    }
    printSubroutines(writer);
    fileEpilog(name, writer);
  }

  protected abstract void printMethod(IndentWriter writer, Template_Type template);

  protected void printSubroutines(IndentWriter writer) {
  }

  protected Set<String> getRawAssemblerImports(final List<Template_Type> templates) {
    final Set<String> importPackages = getImportPackages(templates);
    importPackages.add(Assembler.class.getPackage().getName()); // for the assembler's super class
    importPackages.add(parentAssemblerClass().getPackage().getName()); // for the assembler's super class
    importPackages.add(Inline.class.getPackage().getName());
    return importPackages;
  }

  private void generateLabelAssemblerClass(final String name, String parentName) throws IOException {
    final List<Template_Type> templates = assembly().getLabelTemplates();
    final Set<String> imports = getLabelAssemblerImports(templates);

    final IndentWriter writer = fileProlog(name, parentName, imports);

    final int templateCount = templates.size();
    for (int i = 0; i < templateCount; i++) {
      printMethodComment(writer, templates.get(i), i + 1);
      printLabelMethod(writer, templates.get(i), templates);
    }
    fileEpilog(name, writer);
  }

  protected abstract void printLabelMethod(IndentWriter writer, Template_Type labelTemplate, List<Template_Type> labelTemplates);

  private Set<String> getLabelAssemblerImports(final List<Template_Type> labelTemplates) {
    final Set<String> imports = getImportPackages(labelTemplates);
    imports.add(Label.class.getPackage().getName());
    return imports;
  }

  private Set<String> getImportPackages(Iterable<Template_Type> templates) {
    final Set<String> packages = new HashSet<String>();
    for (Template_Type template : templates) {
      for (Parameter parameter : template.parameters()) {
        final Class type = parameter.type();
        if (!type.isPrimitive()) {
          packages.add(type.getPackage().getName());
        }
      }
    }
    return packages;
  }

  private static <Sort_Type extends Template<Sort_Type> & Comparable<Sort_Type>> List<Sort_Type> sort(final List<Sort_Type> templates) {
    final ArrayList<Sort_Type> results = new ArrayList<Sort_Type>(templates.size());
    results.addAll(templates);
    Arrays.sort(templates.toArray());
    Collections.sort(results);
    return results;
  }
}
