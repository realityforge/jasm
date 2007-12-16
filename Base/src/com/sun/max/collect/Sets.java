/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=89fb4b21-d209-49a8-98ce-ed07ffe4a64f*/
package com.sun.max.collect;

import com.sun.max.util.Predicate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Set operations that one could expect in java.util.
 *
 * @author Bernd Mathiske
 */
public final class Sets {

    private Sets() {

    }

    /**
     * Gets an immutable empty set.
     */
    public static <Element_Type> Set<Element_Type> empty(Class<Element_Type> elementType) {
        return Collections.emptySet();
    }

    public static <Element_Type> Set<Element_Type> from(Element_Type... elements) {
        return new HashSet<Element_Type>(java.util.Arrays.asList(elements));
    }

    public static <Element_Type> Set<Element_Type> from(Class<Element_Type> elementType, Element_Type... elements) {
        return new HashSet<Element_Type>(java.util.Arrays.asList(elements));
    }

    public static <Element_Type> void addAll(Set<Element_Type> set, Element_Type[] elements) {
        for (Element_Type element : elements) {
            set.add(element);
        }
    }

    public static <Element_Type> Set<Element_Type> union(Set<Element_Type> set1, Set<Element_Type> set2) {
        final Set<Element_Type> result = new HashSet<Element_Type>(set1);
        result.addAll(set2);
        return result;
    }

    public static <Element_Type> Set<Element_Type> filter(Iterable<Element_Type> elements, Predicate<Element_Type> predicate) {
        final Set<Element_Type> result = new HashSet<Element_Type>();
        for (Element_Type element : elements) {
            if (predicate.evaluate(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static <From_Type, To_Type> Set<To_Type> map(Set<From_Type> from, Class<To_Type> toType, MapFunction<From_Type, To_Type> mapFunction) {
        final Set<To_Type> to = new HashSet<To_Type>();
        for (From_Type element : from) {
            to.add(mapFunction.map(element));
        }
        return to;
    }
}
