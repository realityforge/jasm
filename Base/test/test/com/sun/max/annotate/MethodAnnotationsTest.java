/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6cd1c949-bf4d-4e87-9a64-e56a2b138729*/
package test.com.sun.max.annotate;

import java.io.*;
import java.util.*;

import com.sun.max.annotate.*;
import com.sun.max.annotate.processor.*;
import com.sun.max.collect.*;
import com.sun.max.ide.*;
import com.sun.max.io.*;
import com.sun.max.lang.*;
import com.sun.max.program.*;
import com.sun.mirror.apt.*;

/**
 * Uses the <a href="http://java.sun.com/j2se/1.5.0/docs/guide/apt/GettingStarted.html">apt</a> tool
 * to validate the usage of compile-time only Maxwell specific annotations such as the {@link Implement}
 * annotation.
 * 
 * @author Doug Simon
 * 
 * @see MaxwellBaseAnnotationProcessor
 * @see MaxwellBaseAnnotationProcessorFactory
 */
public class MethodAnnotationsTest extends MaxTestCase {
    
    public MethodAnnotationsTest(String name) {
        super(name);
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(MethodAnnotationsTest.class);
    }

    /**
     * Should be overridden by subclasses to add any options specific to the processors
     * created by the {@link #annotationProcessorFactory()}.
     */
    public void addProcessorOptions(AppendableSequence<String> args) {
        AppendableSequence.Static.appendAll(args, "-AreportToConsole=true", "-AreportToMessager=true");
    }
    
    public AnnotationProcessorFactory annotationProcessorFactory() {
        return new MaxwellBaseAnnotationProcessorFactory();
    }
    
    private int runProcessor(Sequence<String> sources) {
        final AppendableSequence<String> args = new ArrayListSequence<String>();
        addProcessorOptions(args);
        AppendableSequence.Static.appendAll(args, /*"-XListDeclarations", */"-nocompile", "-cp", Classpath.fromSystem().toString());
        AppendableSequence.Static.appendAll(args, sources);
        
        final AnnotationProcessorFactory factory = annotationProcessorFactory();
        final File argsFile = new File(getClass().getSimpleName() + ".args");
        try {
            Files.fill(argsFile, Sequence.Static.toString(args, null, "\n"));
            return com.sun.tools.apt.Main.process(factory, Sequence.Static.toArray(args, String.class));
        } catch (IOException e) {
            ProgramError.unexpected(e);
            return -1;
        } finally {
            argsFile.delete();
        }
        
    }
    
    public void test_annotations() {
        Trace.on(1);
        final Classpath sourcePath = JavaProject.getSourcePath(false);
        final Set<String> seenSources = new HashSet<String>();
        final AppendableSequence<String> sources = new ArrayListSequence<String>();
        for (String path : sourcePath.paths()) {
            final File pathFile = new File(path);
            if (pathFile.isDirectory()) {
                for (File file : Files.find(pathFile, ".java", null)) {
                    final String source = file.getPath().substring(pathFile.getPath().length());
                    
                    // Skip SCCS files
                    if (file.getParentFile().getName().equals("SCCS")) {
                        final String className = Strings.chopSuffix(file.getName(), ".java");
                        if (className.indexOf('.') != -1 || className.indexOf(',') != -1) {
                            continue;
                        }
                    }
                    
                    final boolean alreadyAdded = !seenSources.add(source);
                    if (!alreadyAdded) {
                        Trace.line(1, "Adding source: " + source);
                        sources.append(file.getPath());
                    } else {
                        System.out.println("ignoring Java source file: " + file);
                    }
                }
            }
        }
        
        assertTrue(runProcessor(sources) == 0);
    }
}
