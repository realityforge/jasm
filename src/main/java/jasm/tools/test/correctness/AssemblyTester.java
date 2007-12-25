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
import jasm.Assembler;
import jasm.AssemblyException;
import jasm.WordWidth;
import jasm.dis.DisassembledInstruction;
import jasm.dis.Disassembler;
import jasm.tools.ArgumentRange;
import jasm.tools.Assembly;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.Parameter;
import jasm.tools.Template;
import jasm.tools.util.IndentWriter;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * A test framework for assemblers and disassemblers.
 * <p/>
 * For a given instruction set, you can run the assembler
 * and the corresponding external GNU assembler (gas)
 * with the same set of arguments and compare the two generated byte arrays for equality.
 * This requires running on a platform on which the respective GNU assembler is installed
 * or configuring SSH to enable remote execution on a machine with the
 * respective GNU assembler installed.
 * <p/>
 * You can also run the assembler and then apply the disassembler to its result
 * and see if you end up with the same method and arguments that you assembled.
 * <p/>
 * Both these tests can be combined in one pass.
 * <p/>
 * A test run iterates over every template in the assembly, and for each of those:
 * - locates the assembler method in the raw assembler that corresponds to the current template
 * - generates a sequence of test argument lists based on the current template,
 * - performs the above described checks for each test argument list,
 * invoking the located raw assembler method with it
 * <p/>
 * A sequence of test argument lists is constructed by building the cross product of eligible argument values.
 * The eligible values of symbolic arguments comprise all values of the respective argument type.
 * The eligible values of numeric arguments better just be
 * a subset of the whole range defined by their argument type...
 * They are a handful of values representing all important boundary cases.
 * <p/>
 * As with the original tester in the Klein assembly framework, this framework also features
 * "negative" tests, i.e. calls with illegal arguments that should be caught and reported.
 * The number of negative tests is far fewer than in the Klein assembly framework as the use
 * of static typing in this framework leaves far fewer opportunities to specify illegal arguments
 * without incurring a syntax or type error from javac. The majority of the remaining possibilities
 * for specifying illegal arguments lies in RISC assemblers' featuring immediate fields whose
 * ranges of legal values is not exactly described by a Java primitive type (e.g. int, short, char, etc).
 */
public abstract class AssemblyTester<Template_Type extends Template, DisassembledInstruction_Type extends DisassembledInstruction<Template_Type>> {

  private static final int NOOP_COUNT = 10;

  private final String _tmpFilePrefix;
  private final Assembly<Template_Type> _assembly;
  private final WordWidth _addressWidth;
  private final EnumSet<AssemblyTestComponent> _components;
  private final ExternalAssembler _externalAssembler = new ExternalAssembler();
  private final TemplateSelector<Template_Type> _selector = new TemplateSelector<Template_Type>();
  private boolean _createExternalSource;

  protected AssemblyTester(Assembly<Template_Type> assembly, WordWidth addressWidth,
                           EnumSet<AssemblyTestComponent> components) {
    _assembly = assembly;
    _addressWidth = addressWidth;
    _components = components;
    _tmpFilePrefix = _assembly.instructionSet().name().toLowerCase() + "-asmTest-";
  }

  public final void setCreateExternalSource(final boolean createExternalSource) {
    _createExternalSource = createExternalSource;
  }

  public final ExternalAssembler getExternalAssembler() {
    return _externalAssembler;
  }

  public final TemplateSelector<Template_Type> getSelector() {
    return _selector;
  }

  public Assembly<Template_Type> assembly() {
    return _assembly;
  }

  public final WordWidth addressWidth() {
    return _addressWidth;
  }

  /**
   * Determines if a given set of arguments for a given template is legal.
   */
  protected abstract boolean isLegalArgumentList(Template_Type template, List<Argument> arguments);

  protected abstract void assembleExternally(IndentWriter stream, Template_Type template,
                                             List<Argument> argumentList, String label);

  private boolean findExcludedDisassemblerTestArgument(List<? extends Parameter> parameters,
                                                       List<Argument> arguments) {
    for (int i = 0; i < parameters.size(); i++) {
      if (parameters.get(i).excludedDisassemblerTestArguments().contains(arguments.get(i))) {
        return true;
      }
    }
    return false;
  }

  private boolean findExcludedExternalTestArgument(List<? extends Parameter> parameters,
                                                   List<Argument> arguments) {
    for (int i = 0; i < parameters.size(); i++) {
      final Parameter parameter = parameters.get(i);
      if (parameter.excludedExternalTestArguments().contains(arguments.get(i))) {
        return true;
      }
      final ArgumentRange argumentRange = parameters.get(i).argumentRange();
      if (argumentRange != null && !argumentRange.includes(arguments.get(i))) {
        return true;
      }
    }
    return false;
  }

  private File createExternalSourceFile(Template_Type template, Iterator<List<Argument>> argumentLists)
      throws IOException {
    final File sourceFile =
        File.createTempFile(_tmpFilePrefix + template.internalName(), ExternalAssembler.SOURCE_EXTENSION);
    final IndentWriter stream = new IndentWriter(new PrintWriter(new BufferedWriter(new FileWriter(sourceFile))));
    stream.indent();
    for (int i = 0; i < NOOP_COUNT; i++) {
      stream.println("nop");
    }
    createExternalSource(template, argumentLists, stream);
    for (int i = 0; i < NOOP_COUNT; i++) {
      stream.println("nop");
    }
    stream.outdent();
    stream.close();
    return sourceFile;
  }

  private void createExternalSource(Template_Type template,
                                    Iterator<List<Argument>> argumentLists,
                                    IndentWriter stream) {
    int i = 0;
    while (argumentLists.hasNext()) {
      final List<Argument> argumentList = argumentLists.next();
      if (!findExcludedExternalTestArgument(template.parameters(), argumentList)) {
        final String label = "label" + i;
        assembleExternally(stream, template, argumentList, label);
      }
      ++i;
    }
  }

  protected abstract String assemblerCommand();

  protected abstract boolean readNop(InputStream stream) throws IOException;

  private boolean findStart(InputStream stream) throws IOException {
    while (stream.available() > 0) {
      if (readNop(stream)) {
        boolean found = true;
        for (int i = 1; i < NOOP_COUNT; i++) {
          if (!readNop(stream)) {
            found = false;
            break;
          }
        }
        if (found) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Gets a string representation of the value and bitrange of each field in an assembled instruction.
   * For example, the returned value for an assembled Power PC {@code rldimi} instruction may be
   * {@code "opcd[0:5]=31{011111} fxm[12:19]=1{00000001} rs[6:10]=1{00001} bit_11[11:11]=-1{1} res_20[20:20]=0{0} xo_21_30[21:30]=144{0010010000} res_31[31:31]=0{0}"}.
   */
  protected abstract String disassembleFields(Template_Type template, byte[] assembledInstruction);

  protected abstract byte[] readExternalInstruction(PushbackInputStream stream, Template_Type template,
                                                    byte[] internalBytes) throws IOException;

  protected abstract Assembler createTestAssembler();

  protected abstract Disassembler<Template_Type, DisassembledInstruction_Type> createTestDisassembler();

  /**
   * We use this more complicated comparison instead of 'Sequence.equals()',
   * because some arguments with different identity may have equal values,
   * e.g. 'FPStackRegister.ST.value() == FPStackRegister.ST_0.value()'.
   * It would have been much more clean to override 'equals()' of those argument classes,
   * but they are enums and Java predeclares methods inherited via Enum final :-(
   */
  private boolean matches(List<Argument> arguments1, List<Argument> arguments2) {
    if (arguments1.size() != arguments2.size()) {
      return false;
    }
    for (int i = 0; i < arguments1.size(); i++) {
      final Argument argument1 = arguments1.get(i);
      final Argument argument2 = arguments2.get(i);
      if (!argument1.equals(argument2)) {
        Class<?> class1 = argument1.getClass();
        Class<?> class2 = argument2.getClass();
        if (!(class1.isAssignableFrom(class2) || class2.isAssignableFrom(class1)) ||
            argument1.asLong() != argument2.asLong()) {
          return false;
        }
      }
    }
    return true;
  }

  private void testDisassembler(Template_Type template, List<Argument> argumentList, byte[] internalResult)
      throws IOException, AssemblyException {
    final BufferedInputStream disassemblyStream = new BufferedInputStream(new ByteArrayInputStream(internalResult));
    final Disassembler<Template_Type, DisassembledInstruction_Type> disassembler = createTestDisassembler();
    disassembler.setAbstractionPreference(template.instructionDescription().isSynthetic() ? Disassembler.AbstractionPreference.SYNTHETIC : Disassembler.AbstractionPreference.RAW);
    disassembler.setExpectedNumberOfArguments(argumentList.size());
    final List<DisassembledInstruction_Type> disassembledInstructions =
        disassembler.scanOneInstruction(disassemblyStream);

    boolean matchFound = false;
    for (DisassembledInstruction_Type disassembledInstruction : disassembledInstructions) {
      matchFound =
          matchFound ||
          (disassembledInstruction.template().isEquivalentTo(template) &&
           matches(disassembledInstruction.arguments(), argumentList) &&
           Arrays.equals(disassembledInstruction.bytes(), internalResult));
    }

    if (disassemblyStream.available() != 0 || !matchFound) {
      System.err.println("internal disassembler test failed - " +
                         disassembledInstructions.size() +
                         " false matches found:");
      if (disassemblyStream.available() != 0) {
        System.err.print("extra bytes at end of disassembly stream:");
        for (final int b = disassemblyStream.read(); b != -1;) {
          System.err.print(" 0x" + Integer.toHexString(b));
        }
        System.err.println();
      }
      int matchNumber = 1;
      for (DisassembledInstruction_Type disassembledInstruction : disassembledInstructions) {
        System.err.println();
        System.err.println("False match number " + matchNumber + ":");
        System.err.println("    assembled template: " + template);
        System.err.println(" disassembled template: " + disassembledInstruction.template());
        System.err.println("   assembled arguments: " + argumentList);
        System.err.println("disassembled arguments: " + disassembledInstruction.arguments());
        System.err.println("       assembled bytes: " + DisassembledInstruction.toHexString(internalResult));
        System.err.println("    disassembled bytes: " +
                           DisassembledInstruction.toHexString(disassembledInstruction.bytes()));
        ++matchNumber;
      }
      throw new IllegalStateException("mismatch between internal assembler and disassembler");
    }
    disassemblyStream.close();
  }

  private void testTemplate(final Template_Type template) throws IOException, AssemblyException {
    final boolean testingExternally =
        _components.contains(AssemblyTestComponent.EXTERNAL_ASSEMBLER) && template.isExternallyTestable();

    // Process legal test cases
    final ArgumentListIterator<Template_Type> argumentLists =
        new ArgumentListIterator<Template_Type>(this, template, TestCaseLegality.LEGAL);
    if(!argumentLists.hasNext()) throw new IllegalStateException("no test cases were generated for template: " + template);
    File binaryFile = null;
    PushbackInputStream externalInputStream = null;
    if (testingExternally) {
      ExternalAssembler.cleanupTempFiles(_tmpFilePrefix);
      final File sourceFile = createExternalSourceFile(template, argumentLists);
      binaryFile = getExternalAssembler().assemble(sourceFile, assemblerCommand());
      externalInputStream = new PushbackInputStream(new BufferedInputStream(new FileInputStream(binaryFile)));
      if (!findStart(externalInputStream)) {
        throw new IllegalStateException("could not find start sequence in: " + binaryFile.getAbsolutePath());
      }
    }

    int testCaseCount = 0;
    for (final ArgumentListIterator<Template_Type> iterator =
        new ArgumentListIterator<Template_Type>(this, template, TestCaseLegality.LEGAL); iterator.hasNext();) {
      final List<Argument> argumentList = iterator.next();
      final Assembler assembler = createTestAssembler();

      final byte[] internalResult;
      assembly().assemble(assembler, template, argumentList);
      internalResult = assembler.toByteArray();

      if (_components.contains(AssemblyTestComponent.DISASSEMBLER) &&
          template.isDisassemblable() &&
          !findExcludedDisassemblerTestArgument(template.parameters(), argumentList)) {

        try {
          testDisassembler(template, argumentList, internalResult);
        } catch (IOException e) {
          throw new AssemblyException(e.toString());
        }
      }

      if (testingExternally && !findExcludedExternalTestArgument(template.parameters(), argumentList)) {
        final byte[] externalResult = readExternalInstruction(externalInputStream, template, internalResult);
        for (int i = 0; i < externalResult.length; i++) {
          if (internalResult[i] != externalResult[i]) {
            System.err.println("external assembler test case " + testCaseCount + " failed for template: " + template);
            System.err.println("arguments: " + argumentList);
            System.err.println("internal result: " + DisassembledInstruction.toHexString(internalResult));
            System.err.println("external result: " + DisassembledInstruction.toHexString(externalResult));
            System.err.println("internal result fields: " + disassembleFields(template, internalResult));
            System.err.println("external result fields: " + disassembleFields(template, externalResult));
            throw new IllegalStateException("mismatch between internal and external assembler");
          }
        }
      }
      ++testCaseCount;
    }

    // Process illegal test cases
    final Set<String> uniqueExceptionMessages = new HashSet<String>();
    final int illegalTestCaseCount = testIllegalCases(template, uniqueExceptionMessages);

    final String msg = "[" + testCaseCount + " test cases, " + illegalTestCaseCount + " illegal test cases]";
    notice(template, msg);
    for (String message : uniqueExceptionMessages) {
      notice(template, "Caught expected IllegalArgumentException: " + message);
    }
    if (testingExternally) {
      for (int i = 0; i < NOOP_COUNT; i++) {
        if (!readNop(externalInputStream)) {
          throw new IllegalStateException("end pattern missing in: " + binaryFile.getAbsolutePath());
        }
      }
      externalInputStream.close();
    }
  }

  private void notice(final Template_Type template, final String msg) {
    System.err.println("template: " + template + " " + msg);
  }

  private int testIllegalCases(final Template_Type template, final Set<String> uniqueExceptionMessages)
      throws AssemblyException {
    int illegalTestCaseNumber = 0;
    for (TestCaseLegality legality : new TestCaseLegality[]{TestCaseLegality.ILLEGAL_BY_CONSTRAINT,
                                                            TestCaseLegality.ILLEGAL_BY_ARGUMENT}) {
      final ArgumentListIterator<Template_Type> iterator =
          new ArgumentListIterator<Template_Type>(this, template, legality);
      while (iterator.hasNext()) {
        final List<Argument> argumentList = iterator.next();
        ++illegalTestCaseNumber;
        final Assembler assembler = createTestAssembler();
        try {
          assembly().assemble(assembler, template, argumentList);
        } catch (IllegalArgumentException e) {
          final String exceptionMessage = e.getMessage();
          uniqueExceptionMessages.add(exceptionMessage);
          continue;
        }

        final int tcn = illegalTestCaseNumber - 1;
        final String msg = "illegal test case " + tcn + " did not throw an exception. arguments: " + argumentList;
        notice(template, msg);
        throw new IllegalStateException("failed illegal test case");
      }
    }
    return illegalTestCaseNumber;
  }

  public final void run() throws IOException {
    IndentWriter stream = null;

    final String externalSourceFilename = _tmpFilePrefix + "all" + ExternalAssembler.SOURCE_EXTENSION;
    File sourceFile;
    if (_createExternalSource) {
      sourceFile = new File(externalSourceFilename);
      stream = new IndentWriter(new PrintWriter(new BufferedWriter(new FileWriter(sourceFile))));
      stream.indent();
    }

    final ArrayList<Template_Type> errors = new ArrayList<Template_Type>();

    for (Template_Type template : assembly().templates()) {
      final TemplateSelector.State state = _selector.select(template);
      if (state == TemplateSelector.State.DONE) { break; }
      if (state == TemplateSelector.State.SKIP) { continue; }
      try {
        if (_createExternalSource) {
          createExternalSource(template, stream);
        }
        testTemplate(template);
      } catch (Throwable throwable) {
        notice(template, "Failed tests.");
        throwable.printStackTrace();
        errors.add(template);
      }
    }

    if (_createExternalSource) {
      System.err.println("External source generated at: " + externalSourceFilename);
      stream.close();
    }

    if (!errors.isEmpty()) {
      System.err.println("Errors occurred when testing the following templates:");
      for (Template_Type template : errors) {
        System.err.println("    " + template);
      }
      throw new IllegalStateException(errors.size() + " templates failed testing: see previous stack dumps in test output");
    }
  }

  private void createExternalSource(Template_Type template, IndentWriter stream) {
    if (template.isExternallyTestable()) {
      final ArgumentListIterator<Template_Type> argumentLists =
          new ArgumentListIterator<Template_Type>(this, template, TestCaseLegality.LEGAL);
      createExternalSource(template, argumentLists, stream);
      notice(template, "[" + argumentLists.iterations() + " test cases]");
    }
  }
}
