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
import jasm.Assembler;
import jasm.AssemblyException;
import jasm.ExternalMnemonicSuffixArgument;
import jasm.Label;
import jasm.util.HexUtil;
import jasm.util.collect.AppendableSequence;
import jasm.util.collect.ArrayListSequence;
import jasm.util.collect.ArraySequence;
import jasm.util.collect.MutableSequence;
import jasm.util.collect.Sequence;
import jasm.util.io.IndentWriter;
import jasm.util.io.ReadableSource;
import jasm.util.lang.StaticLoophole;
import jasm.util.lang.Strings;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Source code generator for both the raw assembler and the label assembler.
 *
 * @author Bernd Mathiske
 */
public abstract class AssemblerGenerator<Template_Type extends Template> {

    private final Assembly<Template_Type> _assembly;
    private final String _outputPackage;
    private final String _rawAssemblerClassSimpleName;
    private final String _labelAssemblerClassSimpleName;
    private final String _rawAssemblerClassName;
    private final String _labelAssemblerClassName;
    private final boolean _sortAssemblerMethods;
    private File _sourceDirectory;

  protected AssemblerGenerator(Assembly<Template_Type> assembly, boolean sortAssemblerMethods) {
        super();
        _assembly = assembly;
        _sourceDirectory = new File(".");
        _outputPackage = Assembler.class.getPackage().getName() + "." + assembly.instructionSet().name().toLowerCase();
        _rawAssemblerClassSimpleName = assembly.instructionSet().name() + "RawAssembler";
        _labelAssemblerClassSimpleName = assembly.instructionSet().name() + "LabelAssembler";
        _rawAssemblerClassName = _outputPackage + "." + _rawAssemblerClassSimpleName;
        _labelAssemblerClassName = _outputPackage + "." + _labelAssemblerClassSimpleName;
        _sortAssemblerMethods = sortAssemblerMethods;
    }

    public Assembly<Template_Type> assembly() {
        return _assembly;
    }

  private File getFile(String classSimpleName) {
    final String directory = findSourceDirectory() + File.separator + _outputPackage.replace('.', File.separatorChar);
    return new File(directory, classSimpleName + ".java");
  }

  public void setSourceDirectory(final File sourceDirectory) {
    _sourceDirectory = sourceDirectory;
  }

  private File findSourceDirectory() {
    return _sourceDirectory;
  }

  private void printPackageAffiliation(IndentWriter writer) {
        writer.println("package " + _outputPackage + ";");
    }

    private void printClassHeader(IndentWriter writer) {
        writer.println();
        printPackageAffiliation(writer);
        writer.println();
    }

    private void printImports(IndentWriter writer, Set<String> packages) {
        final String[] array = packages.toArray(new String[packages.size()]);
        java.util.Arrays.sort(array);
        for (String p : array) {
            if (!p.equals(_outputPackage)) {
                writer.println("import " + p + ".*;");
            }
        }
    }

    protected void printRawImports(IndentWriter writer, Set<String> packages) {
        printImports(writer, packages);
    }

    protected void printLabelImports(IndentWriter writer, Set<String> packages) {
        printImports(writer, packages);
    }

    private void printAssemblerConstructor(IndentWriter writer, String classSimpleName) {
        writer.println("protected " + classSimpleName + "() {");
        writer.indent();
        writer.println("super();");
        writer.outdent();
        writer.println("}");
    }

    protected String formatParameterList(String separator, Sequence<? extends Parameter> parameters, boolean typesOnly) {
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

    /**
     * Prints the source code for the assembler method corresponding to a given template.
     *
     * @return the number of source code lines printed
     */
    protected abstract int printMethod(IndentWriter writer, Template_Type template);

    /**
     * Prints the source code for support methods that are used by the methods printed by {@link #printMethod(IndentWriter, Template)}.
     *
     * @return the number of source code lines printed
     */
    protected int printSubroutines(IndentWriter writer) {
        return 0;
    }

    protected Set<String> getImportPackages(Iterable<Template_Type> templates) {
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

    protected abstract Class<? extends Assembler> endiannessSpecificAssemblerClass();

    private Sequence<Template_Type> _templates;

    private Sequence<Template_Type> templates() {
        if (_templates == null) {
            if (_sortAssemblerMethods) {
                final Template_Type[] array = Sequence.Static.toArray(assembly().templates(), assembly().templateType());
                java.util.Arrays.sort(array);
                _templates = new ArraySequence<Template_Type>(array);
            } else {
                _templates = assembly().templates();
            }
        }
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
     * @param extraLinks
     *                a sequence to which extra javadoc links should be appended
     */
    protected void printExtraMethodJavadoc(IndentWriter writer, Template_Type template, AppendableSequence<String> extraLinks) {
    }

    /**
     * Writes the javadoc comment for an assembler method.
     *
     * @param template the template from which the assembler method is generated
     */
    protected void printMethodJavadoc(IndentWriter writer, Template_Type template) {
        final AppendableSequence<String> extraLinks = new ArrayListSequence<String>();
        final Sequence<? extends Parameter> parameters = getParameters(template);
        writer.println("/**");
        writer.println(" * Pseudo-external assembler syntax: {@code " + template.externalName() + externalMnemonicSuffixes(parameters) + "  }" + externalParameters(parameters));
        printExtraMethodJavadoc(writer, template, extraLinks);
        final Sequence<InstructionConstraint> constraints = Sequence.Static.filter(template.instructionDescription().specifications(), InstructionConstraint.class);
        if (!constraints.isEmpty()) {
            writer.println(" * <p>");
            for (InstructionConstraint constraint : constraints) {
                final Method predicateMethod = constraint.predicateMethod();
                if (predicateMethod != null) {
                    extraLinks.append(predicateMethod.getDeclaringClass().getName() + "#" + predicateMethod.getName());
                }
                writer.println(" * Constraint: {@code " + constraint.asJavaExpression() + "}<br />");
            }
        }

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

    private String externalParameters(Sequence< ? extends Parameter> parameters) {
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

    private String externalMnemonicSuffixes(Sequence< ? extends Parameter> parameters) {
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

    private boolean generateRawAssemblerClass() throws IOException {
        Trace.line(1, "Generating raw assembler: " + _rawAssemblerClassSimpleName);
        final File rawAssemblerFile = getFile(_rawAssemblerClassSimpleName);
        final CharArraySource charArrayWriter = new CharArraySource((int) rawAssemblerFile.length());
        final IndentWriter writer = new IndentWriter(new PrintWriter(charArrayWriter));
        printClassHeader(writer);
        final Set<String> importPackages = getImportPackages(templates());
        importPackages.add(Assembler.class.getPackage().getName()); // for the assembler's super class
        importPackages.add(AssemblyException.class.getPackage().getName());
        printRawImports(writer, importPackages);
        writer.println();
        writer.println("public abstract class " + _rawAssemblerClassSimpleName + " extends " + endiannessSpecificAssemblerClass().getSimpleName() + " {");
        writer.println();
        writer.indent();
        printAssemblerConstructor(writer, _rawAssemblerClassSimpleName);
        writer.println();

        int codeLineCount = 0;
        final Map<InstructionDescription, Integer> instructionDescriptions = new HashMap<InstructionDescription, Integer>();
        int maxTemplatesPerDescription = 0;
        for (int i = 0; i < templates().length(); i++) {
            final Template_Type template = templates().get(i);
            printMethodComment(writer, template, i + 1);
            codeLineCount += printMethod(writer, template);
            writer.println();

            Integer count = instructionDescriptions.get(template.instructionDescription());
            if (count == null) {
                count = 1;
            } else {
                count = count + 1;
            }
            if (count > maxTemplatesPerDescription) {
                maxTemplatesPerDescription = count;
            }
            instructionDescriptions.put(template.instructionDescription(), count);
        }
        final int subroutineCount = printSubroutines(writer);
        writer.outdent();
        writer.println("}");
        writer.close();

        Trace.line(1, "Generated raw assembler: " + _rawAssemblerClassSimpleName +
                        " [code line count=" + codeLineCount + ", total line count=" + writer.lineCount() +
                        ", method count=" + (templates().length() + subroutineCount) +
                        ", instruction templates=" + templates().length() + ", max templates per description=" + maxTemplatesPerDescription +
                        "]");

        return markGeneratedContent(rawAssemblerFile, charArrayWriter);
    }

    /**
     * Gets the parameters for a template, replacing the label parameter with a LabelParameter instance
     * if the template has a label parameter and this generator is currently generating the label assembler.
     */
    protected Sequence<Parameter> getParameters(Template template) {
        if (!_generatingLabelAssembler || template.labelParameterIndex() == -1) {
            return StaticLoophole.cast(template.parameters());
        }
        final MutableSequence<Parameter> parameters = new ArrayListSequence<Parameter>(template.parameters());
        parameters.set(template.labelParameterIndex(), new LabelParameter());
        return parameters;
    }

    protected Sequence<Parameter> printLabelMethodHead(IndentWriter writer, Template_Type template) {
        final Sequence<Parameter> parameters = getParameters(template);
        writer.print("public void " + template.assemblerMethodName() + "(");
        writer.print(formatParameterList("final ", parameters, false));
        writer.println(") {");
        writer.indent();
        return parameters;
    }

    protected void printInitialRawCall(IndentWriter writer, Template_Type template) {
        writer.println("final " + template.parameters().get(template.labelParameterIndex()).type() + " placeHolder = 0;");
        writer.print(template.assemblerMethodName() + "(");
        String separator = "";
        for (int i = 0; i < template.parameters().length(); i++) {
            writer.print(separator);
            if (i == template.labelParameterIndex()) {
                writer.print("placeHolder");
            } else {
                writer.print(template.parameters().get(i).variableName());
            }
            separator = ", ";
        }
        writer.println(");");
    }

    protected void printRawCall(IndentWriter writer, Template_Type template, Sequence<Parameter> parameters) {
        writer.print(template.assemblerMethodName() + "(");
        String separator = "";
        for (int i = 0; i < parameters.length(); i++) {
            writer.print(separator);
            if (i == template.labelParameterIndex()) {
                writer.print("label");
                if (template.parameters().get(template.labelParameterIndex()) instanceof OffsetParameter) {
                    writer.print("Offset");
                } else {
                    assert template.parameters().get(template.labelParameterIndex()) instanceof AddressParameter;
                    writer.print("Address");
                }
                writer.print("As" + Strings.firstCharToUpperCase(template.parameters().get(i).type().getSimpleName()) + "()");
            } else {
                writer.print(parameters.get(i).variableName());
            }
            separator = ", ";
        }
        writer.println(");");
    }

    protected abstract int printLabelMethod(IndentWriter writer, Template_Type labelTemplate, Sequence<Template_Type> labelTemplates);

    private boolean _generatingLabelAssembler;

    protected boolean generatingLabelAssembler() {
        return _generatingLabelAssembler;
    }

  private static void copy(File from, File to) throws IOException {
    InputStream inputStream = null;
    OutputStream outputStream = null;
    try {
      inputStream = new FileInputStream(from);
      outputStream = new FileOutputStream(to);
      copy(inputStream, outputStream);
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
      if (outputStream != null) {
        outputStream.close();
      }
    }
  }

  /**
   * Updates the generated content part of a file. A generated content part is delimited by a line containing
   * only {@code start} and a line containing only {@code end}. If the given file already exists and
   * has these delimiters, the content between these lines is compared with {@code content} and replaced
   * if it is different. If the file does not exist, a new file is created with {@code content} surrounded
   * by the specified delimiters. If the file exists and does not currently have the specified delimiters, an
   * IOException is thrown.
   *
   * @return true if the file was modified or created
   */
  private static boolean markGeneratedContent(File file, ReadableSource content) throws IOException {
    final String start = "// START GENERATED CONTENT";
    final String end = "// END GENERATED CONTENT";
    if (!file.exists()) {
      final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
      try {
        final Reader reader = content.reader();
        try {
          copy(reader, printWriter);
          printWriter.println(end);
        } finally {
          reader.close();
        }
      } finally {
        printWriter.close();
      }
      return true;
    }

    final File tempFile = File.createTempFile(file.getName() + ".", null);
    PrintWriter printWriter = null;
    BufferedReader contentReader = null;
    BufferedReader existingFileReader = null;
    try {
      printWriter = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));
      contentReader = (BufferedReader) content.reader();
      existingFileReader = new BufferedReader(new FileReader(file));

      // Copy existing file up to generated content opening delimiter
      String line;
      while ((line = existingFileReader.readLine()) != null) {
        printWriter.println(line);
        if (line.equals(start)) {
          break;
        }
      }

      if (line == null) {
        throw new IOException("generated content starting delimiter not found in existing file: " + file);
      }

      boolean changed = false;
      boolean seenEnd = false;

      // Copy new content, noting if it differs from existing generated content
      while ((line = contentReader.readLine()) != null) {
        if (!seenEnd) {
          final String existingLine = existingFileReader.readLine();
          if (existingLine != null) {
            if (end.equals(existingLine)) {
              seenEnd = true;
              changed = true;
            } else {
              changed = changed || !line.equals(existingLine);
            }
          }
        }
        printWriter.println(line);
      }

      // Find the generated content closing delimiter
      if (!seenEnd) {
        while ((line = existingFileReader.readLine()) != null) {
          if (line.equals(end)) {
            seenEnd = true;
            break;
          }
          changed = true;
        }
        if (!seenEnd) {
          throw new IOException("generated content ending delimiter not found in existing file: " + file);
        }
      }
      printWriter.println(end);

      // Copy existing file after generated content closing delimiter
      while ((line = existingFileReader.readLine()) != null) {
        printWriter.println(line);
      }

      printWriter.close();
      printWriter = null;
      existingFileReader.close();
      existingFileReader = null;

      if (changed) {
        copy(tempFile, file);
        return true;
      }
      return false;
    } finally {
      quietClose(printWriter);
      quietClose(contentReader);
      quietClose(existingFileReader);
      if (!tempFile.delete()) {
        tempFile.deleteOnExit();
      }
    }
  }

  private static void copy(Reader reader, Writer writer) throws IOException {
    final char[] buffer = new char[8192];
    int count;
    while ((count = reader.read(buffer, 0, buffer.length)) > 0) {
      writer.write(buffer, 0, count);
    }
    writer.flush();
  }

  private static void quietClose(Closeable closeable) {
    if (closeable != null) {
      try {
        closeable.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
    final byte[] buffer = new byte[8192];
    int count;
    while ((count = inputStream.read(buffer, 0, buffer.length)) > 0) {
      outputStream.write(buffer, 0, count);
    }
    outputStream.flush();
  }

  private static class CharArraySource
        extends CharArrayWriter
        implements ReadableSource {
        CharArraySource(int initialSize) {
            super(initialSize);
        }
        public Reader reader() {
            final Reader reader = new CharArrayReader(buf, 0, count);
            return new BufferedReader(reader);
        }

    }

    private boolean generateLabelAssemblerClass() throws IOException {
        _generatingLabelAssembler = true;
        Trace.line(1, "Generating label assembler: " + _labelAssemblerClassSimpleName);
        final File labelAssemblerFile = getFile(_labelAssemblerClassSimpleName);
        final CharArraySource charArrayWriter = new CharArraySource((int) labelAssemblerFile.length());
        final IndentWriter writer = new IndentWriter(new PrintWriter(charArrayWriter));
        printClassHeader(writer);
        final Sequence<Template_Type> labelTemplates = assembly().getLabelTemplates();
        final Set<String> importPackages = getImportPackages(labelTemplates);
        importPackages.add(Label.class.getPackage().getName()); // for Label parameters
        printLabelImports(writer, importPackages);
        writer.println();
        writer.println("public abstract class " + _labelAssemblerClassSimpleName + " extends " + _rawAssemblerClassSimpleName + " {");
        writer.println();
        writer.indent();
        printAssemblerConstructor(writer, _labelAssemblerClassSimpleName);
        writer.println();

        int codeLineCount = 0;
        for (int i = 0; i < labelTemplates.length(); i++) {
            printMethodComment(writer, labelTemplates.get(i), i + 1);
            codeLineCount += printLabelMethod(writer, labelTemplates.get(i), labelTemplates);
        }
        writer.outdent();
        writer.println("}");
        writer.close();
        _generatingLabelAssembler = false;

        Trace.line(1, "Generated label assembler: " + _labelAssemblerClassSimpleName + " [code line count=" + codeLineCount + ", total line count=" +
                        writer.lineCount() + ", method count=" + templates().length() + ")");

        return markGeneratedContent(labelAssemblerFile, charArrayWriter);
    }

    protected void emitByte(IndentWriter writer, String byteValue) {
        writer.print("emitByte(" + byteValue + ");");
    }

    protected void emitByte(IndentWriter writer, byte value) {
        emitByte(writer, "((byte) " + HexUtil.toHexLiteral(value) + ")");
    }

    protected void generate() {
        try {
            if (!generateRawAssemblerClass()) {
                Trace.line(1, "unmodified: " + _rawAssemblerClassName);
            }

            if (!generateLabelAssemblerClass()) {
                Trace.line(1, "unmodified: " + _labelAssemblerClassName);
            }

            Trace.line(1, "done");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.err.println("something went wrong: " + throwable + ": " + throwable.getMessage());
        }
    }
}