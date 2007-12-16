/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.collect.Sets;
import com.sun.max.lang.Classes;
import com.sun.max.lang.Strings;
import com.sun.max.program.Classpath;
import com.sun.max.program.ProgramError;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * Describes a package in the com.sun.max project,
 * providing programmatic package information manipulation,
 * which is lacking in java.lang.Package.
 * <p>
 * You must create a class called 'Package extends MaxPackage'
 * in each and every package in this project.
 * <p>
 * For example you can call:
 *
 *     new com.sun.max.program.Package().superPackage()
 *
 * Also make sure that you have a file called 'package-info.java' in every package.
 * This is where you can put package-related JavaDoc comments.
 *
 * @author Bernd Mathiske
 */
public abstract class MaxPackage implements Comparable<MaxPackage> {

    private final String _packageName;

    protected MaxPackage() {
        _packageName = toJava().getName();
    }

    public static MaxPackage fromName(String packageName) {
        final String name = packageName + ".Package";
        if (name.equals(java.lang.Package.class.getName())) {
            // Special case!
            return null;
        }
        try {
            final Class packageClass = Class.forName(name);
            return (MaxPackage) packageClass.newInstance();
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private MaxPackage(String packageName) {
        _packageName = packageName;
    }

    public static MaxPackage fromJava(String name) {
        return new MaxPackage(name) {
            @Override
            public java.lang.Package toJava() {
                return java.lang.Package.getPackage(name());
            }
        };
    }

    public static MaxPackage fromClass(Class javaClass) {
        return fromName(javaClass.getPackage().getName());
    }

    public java.lang.Package toJava() {
        return getClass().getPackage();
    }

    public String name() {
        return _packageName;
    }

    public String lastIdentifier() {
        return _packageName.substring(_packageName.lastIndexOf('.') + 1);
    }

    public MaxPackage superPackage() {
        final int end = name().lastIndexOf('.');
        if (end < 0) {
            return null;
        }
        return fromName(name().substring(0, end));
    }

    public MaxPackage subPackage(String... suffices) {
        String name = name();
        for (String suffix : suffices) {
            name += "." + suffix;
        }
        return fromName(name);
    }

    public boolean isSubPackageOf(MaxPackage superPackage) {
        return name().startsWith(superPackage.name());
    }

    private Sequence<MaxPackage> getDirectorySubPackages(Classpath classpath) {
        final AppendableSequence<MaxPackage> result = new ArrayListSequence<MaxPackage>();
        for (String path : classpath.paths()) {
            final File directory = new File(path);
            if (directory.isDirectory()) {
                final String superPackageDirectorySuffix = name().replace('.', File.separatorChar);
                final File superPackageDirectory = new File(path + File.separator + superPackageDirectorySuffix);
                if (superPackageDirectory.isDirectory()) {
                    for (File subDirectory : superPackageDirectory.listFiles()) {
                        if (subDirectory.isDirectory()) {
                            final String subPackageName = name() + '.' + subDirectory.getName();
                            final MaxPackage p = MaxPackage.fromName(subPackageName);
                            if (p == null) {
                                System.err.println("WARNING: missing Package class in package: " + subPackageName);
                            } else {
                                result.append(p);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private void addDirectoryTransitiveSubPackages(Set<MaxPackage> packages, Classpath classpath) {
        final Sequence<MaxPackage> subPackages = getDirectorySubPackages(classpath);
        for (MaxPackage subPackage : subPackages) {
            packages.add(subPackage);
            subPackage.addDirectoryTransitiveSubPackages(packages, classpath);
        }
    }

    private void addZipTransitiveSubPackages(Set<MaxPackage> packages, Classpath classpath) {
        for (String path : classpath.paths()) {
            final File file = new File(path);
            if (file.isFile() && path.endsWith(".jar") || path.endsWith(".zip")) {
                try {
                    final ZipFile zipFile = new ZipFile(file);
                    for (final Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {
                        final ZipEntry zipEntry = e.nextElement();
                        final String nameWithSlashes = zipEntry.getName();
                        if (nameWithSlashes.endsWith(".class")) {
                            final String nameWithDots = Strings.chopSuffix(nameWithSlashes, ".class".length()).replace('/', '.');
                            if (nameWithDots.startsWith(name())) {
                                final String subPackageName = nameWithDots.substring(0, nameWithDots.lastIndexOf('.'));
                                packages.add(MaxPackage.fromName(subPackageName));
                            }
                        }
                    }
                } catch (ZipException zipException) {
                    //
                } catch (IOException ioException) {
                    //
                }
            }
        }
    }

    public Sequence<MaxPackage> getTransitiveSubPackages(Classpath classpath) {
        final Set<MaxPackage> packages = new HashSet<MaxPackage>();
        packages.add(this);
        addDirectoryTransitiveSubPackages(packages, classpath);
        addZipTransitiveSubPackages(packages, classpath);
        return new ArrayListSequence<MaxPackage>(packages);
    }

    private Map<Class<? extends Scheme>, Class<? extends Scheme>> _schemeTypeToImplementation;

    public synchronized <Scheme_Type extends Scheme> void registerScheme(Class<Scheme_Type> schemeType, Class<? extends Scheme_Type> schemeImplementation) {
        assert schemeType.isInterface() || Modifier.isAbstract(schemeType.getModifiers());
        assert schemeImplementation.getPackage().getName().equals(name());
        if (_schemeTypeToImplementation == null) {
            _schemeTypeToImplementation = new IdentityHashMap<Class<? extends Scheme>, Class<? extends Scheme>>();
        }
        _schemeTypeToImplementation.put(schemeType, schemeImplementation);
    }

    /**
     * Gets the class within this package implementing a given scheme type (represented as an as abstract class or interface).
     *
     * @return the class directly within this package that implements {@code scheme} or null if no such class
     *         exists
     */
    public synchronized <Scheme_Type extends Scheme> Class<? extends Scheme_Type> schemeTypeToImplementation(Class<Scheme_Type> schemeType) {
        if (_schemeTypeToImplementation == null) {
            return null;
        }
        return _schemeTypeToImplementation.get(schemeType).asSubclass(schemeType);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof MaxPackage) {
            return getClass() == other.getClass();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name().hashCode();
    }

    public Set<MaxPackage> prerequisites() {
        return Sets.empty(MaxPackage.class);
    }

    public int compareTo(MaxPackage other) {
        final Set<MaxPackage> myPrerequisites = prerequisites();
        final Set<MaxPackage> otherPrerequisites = other.prerequisites();
        if (myPrerequisites.isEmpty()) {
            if (otherPrerequisites.isEmpty()) {
                return _packageName.compareTo(other._packageName);
            }
            return -1;
        }
        for (MaxPackage myPrerequisite : myPrerequisites) {
            if (other.equals(myPrerequisite)) {
                return 1;
            }
        }
        if (otherPrerequisites.isEmpty()) {
            return 1;
        }
        for (MaxPackage otherPrerequisite : otherPrerequisites) {
            if (equals(otherPrerequisite)) {
                return -1;
            }
        }
        return _packageName.compareTo(other._packageName);
    }

    private synchronized <Scheme_Type extends Scheme> Class<? extends Scheme_Type> loadSchemeImplementation(Class<Scheme_Type> schemeType) {
        final Class<? extends Scheme_Type> schemeImplementation = schemeTypeToImplementation(schemeType);
        if (schemeImplementation == null) {
            throw new ProgramError("could not find subclass of " + schemeType + " in " + this);
        }
        try {
            final Class<?> loadedImplementation = schemeType.getClassLoader().loadClass(schemeImplementation.getName());
            return loadedImplementation.asSubclass(schemeType);
        } catch (ClassNotFoundException e) {
            throw new ProgramError("Problem loading " + schemeImplementation, e);
        }
    }

    /**
     * Instantiates the scheme implementation class in this package implementing a given scheme type.
     *
     * @param schemeType
     *                the interface or abstract class defining a scheme type
     * @param arguments
     *                arguments passed to constructor of the scheme implementation class
     * @return a new instance of the scheme implementation class
     */
    public synchronized <Scheme_Type extends Scheme> Scheme_Type loadAndInstantiateScheme(Class<Scheme_Type> schemeType, Object... arguments) {
        final Class<? extends Scheme_Type> schemeImplementation = loadSchemeImplementation(schemeType);
        try {
            final Class[] argumentTypes = new Class[arguments.length];
            for (int i = 0; i < arguments.length; i++) {
                argumentTypes[i] = arguments[i].getClass();
            }
            final Constructor constructor = Classes.findConstructor(schemeImplementation, arguments);
            if (constructor != null) {
                return schemeImplementation.cast(constructor.newInstance(arguments));
            }
            throw new ProgramError("could not find matching constructor of class: " + schemeImplementation.getName());
        } catch (Throwable throwable) {
            throw new ProgramError("could not instantiate class: " + schemeImplementation.getName(), throwable);
        }
    }

    @Override
    public String toString() {
        return name();
    }
}
