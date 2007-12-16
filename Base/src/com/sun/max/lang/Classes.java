/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5bbc9ca1-8d94-4829-9767-462dd8a55104*/
package com.sun.max.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Methods that might be members of java.lang.Class.
 *
 * @author Bernd Mathiske
 */
public final class Classes {

    private Classes() {
    }

    public static boolean areRelated(Class<?> class1, Class<?> class2) {
        return class1.isAssignableFrom(class2) || class2.isAssignableFrom(class1);
    }

    public static boolean areAssignableFrom(Class<?>[] superTypes, Class<?>... subTypes) {
        if (superTypes.length != subTypes.length) {
            return false;
        }
        for (int i = 0; i < superTypes.length; i++) {
            if (!superTypes[i].isAssignableFrom(subTypes[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Extends the functionality of {@link Class#getConstructor(Class...)} to find a constructor whose formal parameter
     * types are assignable from the types of a list of arguments.
     *
     * @param javaClass
     *                the class to search in
     * @param arguments
     *                the list of arguments that will be passed to the constructor
     * @return the first constructor in {@link Class#getConstructors() javaClass.getConstructors()} that will accept
     *         {@code arguments} or null if no such constructor exists
     */
    public static Constructor<?> findConstructor(Class<?> javaClass, Object... arguments) {
        nextConstructor:
        for (Constructor<?> constructor : javaClass.getConstructors()) {
            final Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == arguments.length) {
                for (int i = 0; i != arguments.length; ++i) {
                    if (!parameterTypes[i].isAssignableFrom(arguments[i].getClass())) {
                        continue nextConstructor;
                    }
                }
                return constructor;
            }
        }
        return null;
    }

    /**
     * Extends the functionality of {@link Class#getMethod(String, Class...)} to find a method whose formal parameter
     * types are assignable from the types of a list of arguments.
     *
     * @param javaClass
     *                the class to search in
     * @param name
     *                the name of the method to search for
     * @param arguments
     *                the list of arguments that will be passed to the constructor
     * @return the first constructor in {@link Class#getMethods() javaClass.getMethods()} that will accept
     *         {@code arguments} or null if no such method exists
     */
    public static Method findMethod(Class<?> javaClass, String name, Object... arguments) {
        nextMethod:
        for (Method method : javaClass.getMethods()) {
            final Class<?>[] parameterTypes = method.getParameterTypes();
            if (method.getName().equals(name) && parameterTypes.length == arguments.length) {
                for (int i = 0; i != arguments.length; ++i) {
                    if (!parameterTypes[i].isAssignableFrom(arguments[i].getClass())) {
                        continue nextMethod;
                    }
                }
                return method;
            }
        }
        return null;
    }

    /**
     * Extends the functionality of {@link Class#getDeclaredMethod(String, Class...)} to find a method whose formal parameter
     * types are assignable from the types of a list of arguments.
     *
     * @param javaClass
     *                the class to search in
     * @param name
     *                the name of the method to search for
     * @param arguments
     *                the list of arguments that will be passed to the constructor
     * @return the first constructor in {@link Class#getDeclaredMethods() javaClass.getDeclaredMethods()} that will accept
     *         {@code arguments} or null if no such method exists
     */
    public static Method findDeclaredMethod(Class<?> javaClass, String name, Object... arguments) {
        nextMethod:
        for (Method declaredMethod : javaClass.getDeclaredMethods()) {
            final Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            if (declaredMethod.getName().equals(name) && parameterTypes.length == arguments.length) {
                for (int i = 0; i != arguments.length; ++i) {
                    if (!parameterTypes[i].isAssignableFrom(arguments[i].getClass())) {
                        continue nextMethod;
                    }
                }
                return declaredMethod;
            }
        }
        return null;
    }

    /**
     * Get hold of a non-public inner class.
     */
    public static Class getInnerClass(Class outerClass, String innerClassSimpleName) {
        for (Class innerClass : outerClass.getDeclaredClasses()) {
            if (innerClass.getSimpleName().equals(innerClassSimpleName)) {
                return innerClass;
            }
        }
        return null;
    }
}
