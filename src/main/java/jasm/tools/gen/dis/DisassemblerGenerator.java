/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.gen.dis;

import jasm.InstructionSet;
import jasm.WordWidth;
import jasm.annotations.Inline;
import jasm.dis.DecoderException;
import jasm.tools.Assembly;
import jasm.tools.gen.as.AbstractGenerator;
import jasm.tools.util.IndentWriter;
import jasm.x86.dis2.AbstractDisassembler;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/** Source code generator for both the raw assembler and the label assembler. */
public abstract class DisassemblerGenerator<Assembly_Type extends Assembly<?>>
    extends AbstractGenerator {

  private final Assembly_Type _assembly;

  protected DisassemblerGenerator(Assembly_Type assembly) {
    super(new File("."), "jasm." + assembly.instructionSet().name().toLowerCase() + ".dis2");
    _assembly = assembly;
  }

  protected IndentWriter fileProlog(final String name, final String parentClass, final Set<String> imports) throws IOException {
    final IndentWriter writer = super.fileProlog(name, parentClass, imports);
    printConstructor(writer, name);
    return writer;
  }

  private void printConstructor(IndentWriter writer, String classSimpleName) {
    final InstructionSet instructionSet = assembly().instructionSet();
    final WordWidth[] wordWidths = instructionSet.wordWidths();
    writer.print("protected " + classSimpleName + "(");
    if (1 < wordWidths.length) writer.print("WordWidth addressSize");
    writer.println(") {");
    writer.indent();
    writer.print("super(InstructionSet." + instructionSet.name());
    if (1 == wordWidths.length) writer.print(", WordWidth." + wordWidths[0].name());
    writer.println(");");
    writer.outdent();
    writer.println("}");
    writer.println();
  }

  public final Assembly_Type assembly() {
    return _assembly;
  }

  protected Class<? extends AbstractDisassembler> parentDisassemblerClass() {
    return AbstractDisassembler.class;
  }

  public final void generate() throws Exception {
    final String isaName = _assembly.instructionSet().name();
    final String rawName = isaName + "Disassembler";
    generateDisassembler(rawName);
  }

  protected void generateDisassembler(final String name)
      throws IOException {
    final Set<String> imports = getImports();
    final IndentWriter writer =
        fileProlog(name, parentDisassemblerClass().getName(), imports);

    generateBody(writer);

    fileEpilog(name, writer);
  }

  protected abstract void generateBody(final IndentWriter writer);

  protected Set<String> getImports() {
    final Set<String> imports = new HashSet<String>();
    imports.add("jasm");
    imports.add(parentDisassemblerClass().getPackage().getName());
    imports.add(Inline.class.getPackage().getName());
    imports.add(DecoderException.class.getPackage().getName());
    imports.add(IOException.class.getPackage().getName());
    return imports;
  }
}