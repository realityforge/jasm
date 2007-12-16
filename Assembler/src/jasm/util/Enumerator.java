/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @see Enumerable
 *
 * @author Bernd Mathiske
 */
public class Enumerator<Enumerable_Type extends Enum<Enumerable_Type> & Enumerable<Enumerable_Type>>
    implements Symbolizer<Enumerable_Type> {

    private final Class<Enumerable_Type> _type;
    private final EnumSet<Enumerable_Type> _enumSet;

    public Enumerator(Class<Enumerable_Type> type) {
        _type = type;
        _enumSet = EnumSet.allOf(type);
    }

    public Enumerator(Class<Enumerable_Type> type, EnumSet<Enumerable_Type> enumSet) {
        _type = type;
        _enumSet = enumSet;
    }

    public Class<Enumerable_Type> type() {
        return _type;
    }

    public Set<Enumerable_Type> asSet() {
        return _enumSet;
    }

    public Iterator<Enumerable_Type> iterator() {
        return _enumSet.iterator();
    }

    public Enumerable_Type fromValue(int value) {
        for (Enumerable_Type enumerable : this) {
            if (enumerable.value() == value && _enumSet.contains(enumerable)) {
                return enumerable;
            }
        }
        return null;
    }

}
