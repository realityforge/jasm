/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.gen.dis;

import jasm.annotations.Inline;
import jasm.tools.Assembly;
import jasm.tools.Template;
import jasm.tools.gen.as.AbstractGenerator;
import jasm.tools.util.IndentWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/** Source code generator for both the raw assembler and the label assembler. */
public abstract class DisassemblerGenerator<Template_Type extends Template<Template_Type>>
    extends AbstractGenerator {

  private final Assembly<Template_Type> _assembly;

  protected DisassemblerGenerator(Assembly<Template_Type> assembly ) {
    super(new File("."), "jasm." + assembly.instructionSet().name().toLowerCase() + ".dis2");
    _assembly = assembly;
  }

  protected IndentWriter fileProlog(final String name, final String parentClass, final Set<String> imports) throws IOException {
    final IndentWriter writer = super.fileProlog(name, parentClass, imports);
    printConstructor(writer, name);
    return writer;
  }

  private void printConstructor(IndentWriter writer, String classSimpleName) {
    writer.println("protected " + classSimpleName + "() {");
    writer.indent();
    writer.println("super(InstructionSet." + assembly().instructionSet().name() + ");");
    writer.outdent();
    writer.println("}");
  }

  public final Assembly<Template_Type> assembly() {
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
        fileProlog(name, parentDisassemblerClass().getSimpleName(), imports);

    generateBody(writer);

    fileEpilog(name, writer);
  }

  protected abstract void generateBody(final IndentWriter writer);

  protected Set<String> getImports() {
    final Set<String> imports = new HashSet<String>();
    imports.add("jasm");
    imports.add(parentDisassemblerClass().getPackage().getName());
    imports.add(Inline.class.getPackage().getName());
    return imports;
  }
}