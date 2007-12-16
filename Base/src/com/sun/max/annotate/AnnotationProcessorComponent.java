/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f0f777f5-3e04-4652-af37-6b2533436317*/
package com.sun.max.annotate;

import com.sun.max.MaxPackage;
import com.sun.max.PackageLoader;
import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.ide.JavaProject;
import com.sun.max.io.Streams;
import com.sun.max.program.Classpath;
import com.sun.max.program.ProgramError;
import com.sun.max.program.Trace;
import com.sun.max.program.option.FileProgramOption;
import com.sun.max.program.option.ProgramArgumentsParser;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

/**
 * Indicates that a class is part of an annotation processor.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationProcessorComponent {

    public static final class Static {

        private Static() {

        }

        private static boolean isAnnotationProcessorComponent(Class clazz) {
            Class<?> thisClass = clazz;
            while (thisClass != null) {
                if (thisClass.isAnnotationPresent(AnnotationProcessorComponent.class)) {
                    return true;
                }
                thisClass = thisClass.getEnclosingClass();
            }
            return false;
        }

        public static void main(String[] args) throws Exception {
            final ProgramArgumentsParser programArgumentsParser = new ProgramArgumentsParser("makeApfJar");
            final FileProgramOption jarFile = new FileProgramOption("-out", "the path of the jar file to create") {
                @Override
                protected File unassignedDefaultValue() {
                    return new File(JavaProject.findProjectDirectory(), "apf.jar");
                }
            };

            programArgumentsParser.addProgramOption(new Trace());
            programArgumentsParser.addProgramOption(jarFile);
            programArgumentsParser.parse(args);

            final AppendableSequence<Class> classes = new ArrayListSequence<Class>();
            final AppendableSequence<String> factories = new ArrayListSequence<String>();

            final PackageLoader packageLoader = new PackageLoader(AnnotationProcessorComponent.Static.class.getClassLoader(), Classpath.fromSystem());
            for (MaxPackage maxPackage : new com.sun.max.Package().getTransitiveSubPackages(Classpath.fromSystem())) {
                for (Class clazz : packageLoader.load(maxPackage)) {
                    if (isAnnotationProcessorComponent(clazz)) {
                        classes.append(clazz);
                        if (AnnotationProcessorFactory.class.isAssignableFrom(clazz)) {
                            factories.append(clazz.getName());
                        }
                    }
                }
            }

            ProgramError.check(factories.length() != 0, "Could not find any classes implementing " + AnnotationProcessorFactory.class);

            final FileOutputStream fileOutputStream = new FileOutputStream(jarFile.value());
            final JarOutputStream jarOutputStream = new JarOutputStream(fileOutputStream);

            jarOutputStream.putNextEntry(new JarEntry("META-INF/services/com.sun.mirror.apt.AnnotationProcessorFactory"));
            final PrintStream ps = new PrintStream(jarOutputStream);
            for (String factory : factories) {
                ps.println(factory);
            }
            jarOutputStream.closeEntry();

            for (Class clazz : classes) {
                final String classfilePath = clazz.getName().replace('.', '/') + ".class";
                final InputStream classfileInputStream = Classpath.fromSystem().findClassFile(clazz.getName());
                ProgramError.check(classfileInputStream != null, "Could not get input stream for " + classfilePath);
                jarOutputStream.putNextEntry(new JarEntry(classfilePath));
                Streams.copy(classfileInputStream, jarOutputStream);
                jarOutputStream.closeEntry();

                if (clazz.getEnclosingClass() == null) {
                    final String sourcefilePath = clazz.getName().replace('.', '/') + ".java";
                    final InputStream sourcefileInputStream = JavaProject.getSourcePath(true).findSourceFile(clazz.getName());
                    ProgramError.check(sourcefileInputStream != null, "Could not get input stream for " + sourcefilePath);
                    jarOutputStream.putNextEntry(new JarEntry(sourcefilePath));
                    Streams.copy(sourcefileInputStream, jarOutputStream);
                    jarOutputStream.closeEntry();
                }
            }

            jarOutputStream.close();

            System.out.println("Created " + jarFile.value());
        }
    }
}

