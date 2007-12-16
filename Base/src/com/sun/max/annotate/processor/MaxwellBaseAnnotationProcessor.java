/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=100b41e1-ee40-4deb-91d6-ef2253278237*/
package com.sun.max.annotate.processor;

import java.util.*;

import com.sun.max.annotate.*;
import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;
import com.sun.mirror.type.*;
import com.sun.mirror.util.*;

/**
 * An annotation processor that validates the use of the compile-time annotations
 * in the MaxwellBase project such as the {@link Implement} annotation. 
 *
 * @author Doug Simon
 */
@AnnotationProcessorComponent
public class MaxwellBaseAnnotationProcessor implements AnnotationProcessor {

    private final AnnotationProcessorEnvironment _environment;
    private final Messager _messager;
    private final Types _typeUtils;
    private final Declarations _declarationUtils;
    private final AnnotationTypeDeclaration _overrideAnnotationDeclaration;
    private final AnnotationTypeDeclaration _implementAnnotationDeclaration;
    
    private boolean _reportAsWarning;
    private boolean _reportToConsole;
    private boolean _reportToMessager = true;
    
    public MaxwellBaseAnnotationProcessor(AnnotationProcessorEnvironment environment) {
        _environment = environment;
        _messager = _environment.getMessager();
        _typeUtils = _environment.getTypeUtils();
        _declarationUtils = _environment.getDeclarationUtils();
        _overrideAnnotationDeclaration = (AnnotationTypeDeclaration) _environment.getTypeDeclaration("java.lang.Override");
        _implementAnnotationDeclaration = (AnnotationTypeDeclaration) _environment.getTypeDeclaration("com.sun.max.annotate.Implement");
        
        // The current state of 'apt' is a little strange in that -A options are not parsed.
        // For example, specifying "-AreportToConsole=true" on the apt command line will
        // result in an entry with key "-AreportToConsole=true" and a null value in the
        // options map. This will apparently be remedied in JDK 6.
        final Map<String, String> options = environment.getOptions();
        for (String option : options.keySet()) {
            if (option.startsWith("-A")) {
                if (option.startsWith("-AreportToConsole=")) {
                    _reportToConsole = option.substring("-AreportToConsole=".length()).equalsIgnoreCase("true");
                } else if (option.startsWith("-AreportToMessager=")) {
                    _reportToMessager = option.substring("-AreportToMessager=".length()).equalsIgnoreCase("true");
                } else if (option.startsWith("-AreportAsWarning=")) {
                    _reportAsWarning = option.substring("-AreportAsWarning=".length()).equalsIgnoreCase("true");
                } else {
                    System.err.println("Ignored unknown option: " + option);
                }
            }
        }
    }

    protected void log(String message) {
//        System.err.println(message);
    }
    
    protected AnnotationProcessorEnvironment environment() {
        return _environment;
    }

    protected Types typeUtils() {
        return _typeUtils;
    }

    protected Messager messager() {
        return _messager;
    }

    protected void printConsole(String prefix, Declaration declaration, String message) {
        final TypeDeclaration declaringType;
        if (declaration instanceof TypeDeclaration) {
            declaringType = (TypeDeclaration) declaration;
        } else {
            declaringType = ((MemberDeclaration) declaration).getDeclaringType();
        }
        System.err.println(prefix + ": In " + declaringType.getQualifiedName() + "." + declaration.getSimpleName() +
                        "(" + declaration.getPosition().file().getName() + ":" + declaration.getPosition().line() + "): " + message);
    }

    protected void warning(Declaration declaration, String message) {
        if (_reportToConsole) {
            printConsole("Warning", declaration, message);
        }
        if (_reportToMessager) {
            _messager.printWarning(declaration.getPosition(), message);
        }
    }

    protected void error(Declaration declaration, String message) {
        if (_reportToConsole) {
            printConsole("Error", declaration, message);
        }
        if (_reportToMessager) {
            _messager.printError(declaration.getPosition(), message);
        }
    }
    
    protected void problem(Declaration declaration, String message) {
        if (_reportAsWarning) {
            warning(declaration, message);
        } else {
            error(declaration, message);
        }
    }

    public static class UnknownDeclaration extends RuntimeException {
        private final DeclaredType _declaredType;
        public UnknownDeclaration(DeclaredType declaredType) {
            super(declaredType.toString());
            _declaredType = declaredType;
        }
        
        public DeclaredType declaredType() {
            return _declaredType;
        }
    }
    
    protected static TypeDeclaration getDeclaration(DeclaredType declaredType) {
        final TypeDeclaration typeDeclaration = declaredType.getDeclaration();
        if (typeDeclaration == null) {
            throw new UnknownDeclaration(declaredType);
        }
        return typeDeclaration;
    }
    
    /**
     * Searches for a method in {@code typeDeclaration} that is overridden by {@code overridingMethod}.
     */
    private MethodDeclaration findOverridingMethod(MethodDeclaration overridingMethod, TypeDeclaration typeDeclaration) {
        for (MethodDeclaration method : typeDeclaration.getMethods()) {
            if (_declarationUtils.overrides(overridingMethod, method)) {
                return method;
            }
        }
        return null;
    }
    
    private MethodDeclaration getOverriddenMethod(MethodDeclaration subMethod) {
        final DeclaredType declaredType = _typeUtils.getDeclaredType(subMethod.getDeclaringType());
        if (!(declaredType instanceof ClassType)) {
            return null;
        }
        final ClassType classType = (ClassType) declaredType;
        ClassType superType = classType.getSuperclass();
        while (superType != null && getDeclaration(superType) != null) {
            final MethodDeclaration superMethod = findOverridingMethod(subMethod, getDeclaration(superType));
            if (superMethod != null) {
                return superMethod;
            }
            superType = superType.getSuperclass();
        }
        return null;
    }

    private MethodDeclaration getInterfaceMethod(MethodDeclaration method, InterfaceDeclaration interfaceDeclaration) {
        MethodDeclaration interfaceMethod = findOverridingMethod(method, interfaceDeclaration);
        if (interfaceMethod != null) {
            return interfaceMethod;
        }
        final InterfaceType interfaceType = (InterfaceType) _typeUtils.getDeclaredType(interfaceDeclaration);
        for (InterfaceType superInterface : interfaceType.getSuperinterfaces()) {
            interfaceMethod = getInterfaceMethod(method, (InterfaceDeclaration) getDeclaration(superInterface));
            if (interfaceMethod != null) {
                return interfaceMethod;
            }
        }
        return null;
    }

    private MethodDeclaration getImplementedMethod(MethodDeclaration subMethod) {
        final DeclaredType declaredType = _typeUtils.getDeclaredType(subMethod.getDeclaringType());
        if (!(declaredType instanceof ClassType)) {
            return null;
        }
        ClassType classType = (ClassType) declaredType;
        while (classType != null) {
            for (InterfaceType superInterface : classType.getSuperinterfaces()) {
                final MethodDeclaration interfaceMethod = getInterfaceMethod(subMethod, (InterfaceDeclaration) getDeclaration(superInterface));
                if (interfaceMethod != null) {
                    return interfaceMethod;
                }
            }
            classType = classType.getSuperclass();
        }
        return null;
    }

    protected AnnotationMirror getAnnotation(Declaration declaration, AnnotationTypeDeclaration annotationTypeDeclaration) {
        for (AnnotationMirror annotation : declaration.getAnnotationMirrors()) {
            if (getDeclaration(annotation.getAnnotationType()).equals(annotationTypeDeclaration)) {
                return annotation;
            }
        }
        return null;
    }

    protected String format(MemberDeclaration declaration, boolean qualified) {
        final StringBuilder sb = new StringBuilder(declaration.getSimpleName());
        if (declaration instanceof ExecutableDeclaration) {
            sb.append("(");
            final Collection<ParameterDeclaration> parameters = ((ExecutableDeclaration) declaration).getParameters();
            for (ParameterDeclaration parameter : parameters) {
                if (sb.charAt(sb.length() - 1) != '(') {
                    sb.append(", ");
                }
                final TypeMirror parameterType = parameter.getType();
                if (parameterType instanceof DeclaredType) {
                    sb.append(getDeclaration((DeclaredType) parameterType).getSimpleName());
                } else {
                    sb.append(parameterType);
                }
            }
            sb.append(")");
        }
        sb.append(" in ").append(qualified ? declaration.getDeclaringType().getQualifiedName() : declaration.getDeclaringType().getSimpleName());
        return sb.toString();
    }

    protected AnnotationValue elementValue(AnnotationMirror annotationMirror, String name, Class expectedType) {
        for (Map.Entry<AnnotationTypeElementDeclaration, AnnotationValue> entry : annotationMirror.getElementValues().entrySet()) {
            if (entry.getKey().getSimpleName().equals(name)) {
                final AnnotationValue annotationValue = entry.getValue();
                final Object value = annotationValue.getValue();
                if (expectedType.isInstance(value)) {
                    return annotationValue;
                }
                log("warning: annotation element " + annotationMirror.getAnnotationType().getDeclaration().getQualifiedName() +
                                "." + name + " has type " + value.getClass() + ", not " + expectedType);
                assert false;
            }
        }
        return null;
    }
    
    private TypeMirror getImplementedType(AnnotationMirror implementAnnotation) {
        if (implementAnnotation != null) {
            final AnnotationValue element = elementValue(implementAnnotation, "value", TypeMirror.class);
            if (element != null) {
                return (TypeMirror) element.getValue();
            }
        }
        return null;
    }
    
    private void checkImplementAnnotation(MethodDeclaration method, MethodDeclaration overriddenMethod, MethodDeclaration implementedMethod, TypeMirror implementedType) {
        if (implementedType != null) {
            if (!(implementedType instanceof InterfaceType)) {
                problem(method, "The @Implement annotation specifies non-interface type " + implementedType + ".");
            }
            if (implementedMethod == null) {
                problem(method, "The method " + format(method, false) + " does not implement a method in " + implementedType + ".");
            }
            if (method.getDeclaringType() instanceof InterfaceDeclaration) {
                problem(method, "The @Implement annotation cannot be applied to an interface method.");
            }
        }

        if (implementedMethod != null) {
            if (implementedType == null) {
                if (getAnnotation(method, _overrideAnnotationDeclaration) == null) {
                    // If there is no @Implement (or @Override) annotation is present, then there must be an overridden method and it must have an @Implement annotation
                    boolean foundSuperMethodWithImplementAnnotation = false;
                    MethodDeclaration superMethod = overriddenMethod;
                    while (!foundSuperMethodWithImplementAnnotation && superMethod != null) {
                        foundSuperMethodWithImplementAnnotation = getAnnotation(superMethod, _implementAnnotationDeclaration) != null;
                        superMethod = getOverriddenMethod(superMethod);
                    }
                    if (!foundSuperMethodWithImplementAnnotation) {
                        problem(method, "The method " + format(method, false) + " should be tagged with @Implement(" + implementedMethod.getDeclaringType().getSimpleName() + ".class).");
                    }
                }
            } else {
                final TypeMirror implementedClass = _typeUtils.getDeclaredType(implementedMethod.getDeclaringType());
                if (!implementedType.equals(implementedClass)) {
                    if (findOverridingMethod(method, getDeclaration((DeclaredType) implementedType)) == null) {
                        problem(method, "The method " + format(method, false) + " tagged with @Implement should specify " + implementedClass + ", not " + implementedType + ".");
                    }
                }
            }
        }
    }

    private void checkImplementAnnotation() {
        final Collection<TypeDeclaration> typeDeclarations = _environment.getTypeDeclarations();
        for (TypeDeclaration typeDecl : typeDeclarations) {
//            if (typeDecl != null) {
            
                /* 
                 * This is a workaround for a bug in the Eclipse implementation of APT which is explained by the following extract
                 * from an email exchange with Walter Harley, one of the JDP-APT implementors:
                 *
                 * "The question basically amounts to which AST evaluation environment (internal to the JDT) a given
                 *  TypeDeclaration's binding came from.  Two TypeDeclaration objects for
                 *  the same declaration may have non-matching bindings - bindings that are
                 *  not == but that would be .equals() if only .equals() were implemented.
                 *  The problem seems to be that the TypeDeclarations that are coming out of
                 *  AnnotationProcessorEnvironment.getTypeDeclarations() aren't matching
                 *  those that are subsequently generated from actions like
                 *  DeclaredType.getDeclaration(), when in reconcile.  "Washing" those
                 *  declarations by running them through getDeclaredType().getDeclaration()
                 *  seemed to put everything in the same pipeline, for me."
                 */
//                final DeclaredType declaredType = _typeUtils.getDeclaredType(typeDecl);
//                if (declaredType == null) {
//                    // Not sure why this happens, but in Eclipse it does so we defend against it here.
//                    continue;
//                }
//                final TypeDeclaration typeDeclaration = declaredType.getDeclaration();
            
                final TypeDeclaration typeDeclaration = typeDecl;

                log("checking methods in " + typeDeclaration.getQualifiedName());
                for (MethodDeclaration method : typeDeclaration.getMethods()) {
                    if (!method.getModifiers().contains(Modifier.STATIC)) {
                        try {
                            final MethodDeclaration overriddenMethod = getOverriddenMethod(method);
                            final MethodDeclaration implementedMethod = getImplementedMethod(method);
                            final AnnotationMirror implementAnnotation = getAnnotation(method, _implementAnnotationDeclaration);
                            final TypeMirror implementedType = getImplementedType(implementAnnotation);
                            
                            log("    checking " + method);
                            log("        overriddenMethod: " + overriddenMethod);
                            log("        implementedMethod: " + implementedMethod);
                            log("        implementAnnotation: " + implementAnnotation);
                            
                            checkImplementAnnotation(method, overriddenMethod, implementedMethod, implementedType);
                        } catch (UnknownDeclaration e) {
                            warning(method, "Could not resolve declaration for type '" + e.declaredType() + "' [usually caused by incomplete classpath]");
                        }
                    }
                }
//            }
        }
    }

    @Implement(AnnotationProcessor.class)
    public void process() {
        log("processing MaxwellBase annotations ...");
        checkImplementAnnotation();
    }
}
