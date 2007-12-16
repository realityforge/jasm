/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5076f98f-bb62-4b73-ba29-51a72ac4101d*/
package com.sun.max.collect;

import java.util.List;
import java.util.Vector;

/**
 * Since java.util.IdentityHashMap seems to be buggy in JDK 1.5.0,
 * (containsKey() sometimes does not return, seems to be looping)
 * here is a more reliable substitute.
 *
 * Note that this implementation here may have very poor performance,
 * but at least it gets the job done at all.
 *
 * @author Bernd Mathiske
 */
public class IdentityMapping<Key_Type, Value_Type> implements Mapping<Key_Type, Value_Type> {

    private final Class<Key_Type> _keyType;

    private final List<Key_Type> _keys = new Vector<Key_Type>();
    private final List<Value_Type> _values = new Vector<Value_Type>();

    private static boolean _isAsserting;

    private static boolean enableAsserting() {
        _isAsserting = true;
        return true;
    }

    static {
        assert enableAsserting();
    }

    public IdentityMapping(Class<Key_Type> keyType, Class<Value_Type> valueType) {
        _keyType = keyType;
    }

    public synchronized Value_Type put(Key_Type key, Value_Type value) {
        assert key != null;
        assert value != null;
        for (int i = 0; i < _keys.size(); i++) {
            final Key_Type current = _keys.get(i);
            assert _keyType.isInstance(current);
            if (current == key) {
                final Value_Type oldValue = _values.get(i);
                _values.set(i, value);
                return oldValue;
            }
        }
        _keys.add(key);
        _values.add(value);
        assert _keys.size() == _values.size();
        return null;
    }

    public synchronized Value_Type get(Key_Type key) {
        assert key != null;
        assert _keys.size() == _values.size();
        Value_Type result = null;
        for (int i = 0; i < _keys.size(); i++) {
            final Key_Type current = _keys.get(i);
            assert _keyType.isInstance(current);
            if (current == key) {
                assert result == null;
                result = _values.get(i);
                assert result != null;
                if (!_isAsserting) {
                    return result;
                }
            }
        }
        return result;
    }

    public synchronized boolean containsKey(Key_Type key) {
        return get(key) != null;
    }
}
