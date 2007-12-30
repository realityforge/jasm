package jasm.tools.gen.as;

import jasm.tools.Trace;
import jasm.tools.util.IndentWriter;
import jasm.util.HexUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;

public abstract class AbstractGenerator {
  private final String _outputPackage;
  private  File _sourceDirectory;

  protected AbstractGenerator(final File sourceDirectory, final String outputPackage) {
    _outputPackage = outputPackage;
    _sourceDirectory = sourceDirectory;
  }

  private File getFile(String classSimpleName) {
    final String directory = _sourceDirectory + File.separator + _outputPackage.replace('.', File.separatorChar);
    return new File(directory, classSimpleName + ".java");
  }

  public final void setSourceDirectory(final File sourceDirectory) {
    _sourceDirectory = sourceDirectory;
  }

  protected IndentWriter fileProlog(final String name,
                                    final String parentClass,
                                    final Set<String> imports)
      throws IOException {
    final File file = getFile(name);
    Trace.line(1, "Generating file: " + file);
    final IndentWriter writer =
        new IndentWriter(new PrintWriter(new BufferedWriter(new FileWriter(file))));

    writer.println("/* Generated file. Do not edit. */");
    writer.println("package " + _outputPackage + ";");
    writer.println();
    final String[] array = imports.toArray(new String[imports.size()]);
    Arrays.sort(array);
    for (String p : array) {
      if (!p.equals(_outputPackage)) {
        writer.println("import " + p + ".*;");
      }
    }
    writer.println();
    writer.println("public abstract class " + name + " extends " + parentClass + " {");
    writer.println();
    writer.indent();
    return writer;
  }

  protected void fileEpilog(final String name, final IndentWriter writer) {
    writer.outdent();
    writer.println("}");
    writer.close();
    Trace.line(1, "Generated " + name);
  }

}
