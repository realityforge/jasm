/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=3bb70d99-9ed6-4b2d-8e11-7434d1ba9f9b*/
package com.sun.max.ide.eclipse;

import java.io.*;
import java.util.*;

import org.eclipse.jdt.core.compiler.*;
import org.eclipse.jdt.internal.compiler.*;
import org.eclipse.jdt.internal.compiler.Compiler;
import org.eclipse.jdt.internal.compiler.classfmt.*;
import org.eclipse.jdt.internal.compiler.env.*;
import org.eclipse.jdt.internal.compiler.impl.*;
import org.eclipse.jdt.internal.compiler.problem.*;

import com.sun.max.annotate.*;
import com.sun.max.ide.*;
import com.sun.max.lang.*;
import com.sun.max.program.*;
import com.sun.max.util.*;

/**
 * Compiles a Java source file ("*.java") to a Java class file ("*.class"), using the same input and output directories
 * as the IDE would when building the project.
 * 
 * @author Bernd Mathiske
 */
class EclipseJavaCompiler {

    private final EclipseJavaCompilationUnit _compilationUnit;

    EclipseJavaCompiler(String className) throws IOException {
        _compilationUnit = new EclipseJavaCompilationUnit(className);
    }

    private boolean _foundErrors;
    private boolean _foundWarnings;

    private class NameEnvironment implements INameEnvironment {

        private final AccessRestriction _noAccessRestriction = null;

        private NameEnvironmentAnswer findType(String className) {
            try {
                if (className.equals(_compilationUnit.className())) {
                    return new NameEnvironmentAnswer(_compilationUnit, _noAccessRestriction);
                }
                final InputStream inputStream = Classpath.fromSystem().findClassFile(className);
                if (inputStream != null) {
                    return new NameEnvironmentAnswer(new ClassFileReader(Bytes.fromInputStream(inputStream), className.toCharArray(), true), _noAccessRestriction);
                }
            } catch (IOException ioException) {
                _foundErrors = true;
            } catch (ClassFormatException classFormatException) {
                _foundErrors = true;
            }
            return null;
        }

        @Implement(INameEnvironment.class)
        public NameEnvironmentAnswer findType(char[][] compoundTypeName) {
            return findType(JavaIdentifier.linkQualifiedIdentifier(compoundTypeName));
        }

        @Implement(INameEnvironment.class)
        public NameEnvironmentAnswer findType(char[] typeName, char[][] packageName) {
            return findType(JavaIdentifier.linkQualifiedIdentifier(packageName) + "." + new String(typeName));
        }

        @Implement(INameEnvironment.class)
        public boolean isPackage(char[][] parentPackageName, char[] packageName) {
            if (findType(parentPackageName) != null) {
                return false;
            }
            return findType(packageName, parentPackageName) == null;
        }

        @Implement(INameEnvironment.class)
        public void cleanup() {
        }
    }

    private class CompilerRequestor implements ICompilerRequestor {
        @Implement(ICompilerRequestor.class)
        public void acceptResult(CompilationResult result) {
            if (result.hasProblems()) {
                for (IProblem problem : result.getProblems()) {
                    if (problem.isError()) {
                        _foundErrors = true;
                    } else if (problem.isWarning()) {
                        _foundWarnings = true;
                    }
                }
            }
            if (!_foundErrors) {
                for (ClassFile classfile : result.getClassFiles()) {
                    final char[][] compoundName = classfile.getCompoundName();
                    String className = "";
                    String separator = "";
                    for (int j = 0; j < compoundName.length; j++) {
                        className += separator;
                        className += new String(compoundName[j]);
                        separator = ".";
                    }
                    final String classfileName = JavaProject.findClassesDirectory() + File.separator + className.replace('.', File.separatorChar) + Classpath.CLASS_FILE_EXTENSION;
                    try {
                        final BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(classfileName));
                        try {
                            outputStream.write(classfile.getBytes());
                        } finally {
                            outputStream.close();
                        }
                    } catch (IOException ioException) {
                        _foundErrors = true;
                    }
                }
            }
        }
    }

    public boolean run() {
        final INameEnvironment nameEnvironment = new NameEnvironment();
        final IErrorHandlingPolicy errorHandlingPolicy = DefaultErrorHandlingPolicies.proceedWithAllProblems();

        final Map<String, String> compilerSettings = new HashMap<String, String>();
        compilerSettings.put(CompilerOptions.OPTION_Source, CompilerOptions.VERSION_1_5);
        compilerSettings.put(CompilerOptions.OPTION_TargetPlatform, CompilerOptions.VERSION_1_5);
        compilerSettings.put(CompilerOptions.OPTION_Compliance, CompilerOptions.VERSION_1_5);
        compilerSettings.put(CompilerOptions.OPTION_LocalVariableAttribute, CompilerOptions.GENERATE);
        compilerSettings.put(CompilerOptions.OPTION_LineNumberAttribute, CompilerOptions.GENERATE);
        compilerSettings.put(CompilerOptions.OPTION_SourceFileAttribute, CompilerOptions.GENERATE);
        compilerSettings.put(CompilerOptions.OPTION_ReportDeprecation, CompilerOptions.ENABLED);
        compilerSettings.put(CompilerOptions.OPTION_ReportUnusedImport, CompilerOptions.ENABLED);

        final CompilerOptions compilerOptions = new CompilerOptions(compilerSettings);
        final CompilerRequestor compilerRequestor = new CompilerRequestor();
        final IProblemFactory problemFactory = new DefaultProblemFactory(Locale.getDefault());
        final Compiler compiler = new Compiler(nameEnvironment, errorHandlingPolicy, compilerOptions, compilerRequestor, problemFactory);
        compiler.compile(new ICompilationUnit[] {_compilationUnit});       
        return !_foundErrors && !_foundWarnings;
    }
}
