/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package com.sun.max.collect;


/**
 * Similar to java.util.HashMap, but with plain primitive ints as keys.
 * Unsynchronized.
 *
 * @author Bernd Mathiske
 */
public class IntHashMap<Value_Type> {

    private int[] _keys;
    private MutableSequence<Value_Type> _values;
    private int _numberOfValues;
    private int _threshold;

    public IntHashMap() {
    }

    public Value_Type get(int key) {
        if (_keys == null) {
            return null;
        }
        int index = key % _keys.length;
        if (index < 0) {
            index *= -1;
        }
        final int start = index;
        do {
            final Value_Type value = _values.get(index);
            if (value == null) {
                return null;
            }
            if (_keys[index] == key) {
                return _values.get(index);
            }
            index++;
            index %= _keys.length;
        } while (index != start);
        return null;
    }

    private static final int INITIAL_SIZE = 4;

    private void setThreshold() {
        assert _keys.length == _values.length();
        _threshold = (_keys.length * 3) / 4;
    }

    public void grow() {
        if (_keys == null) {
            _keys = new int[INITIAL_SIZE];
            _values = new ArraySequence<Value_Type>(INITIAL_SIZE);
            setThreshold();
        } else {
            final int[] keys = _keys;
            final Sequence<Value_Type> values = _values;
            final int length = _keys.length * 2;
            _keys = new int[length];
            _values = new ArraySequence<Value_Type>(length);
            _numberOfValues = 0;
            setThreshold();
            for (int i = 0; i < keys.length; i++) {
                final Value_Type value = values.get(i);
                if (value != null) {
                    put(keys[i], value);
                }
            }
        }
    }

    public Value_Type put(int key, Value_Type value) {
        assert value != null;
        if (_numberOfValues >= _threshold) {
            grow();
        }
        int index = key % _keys.length;
        if (index < 0) {
            index *= -1;
        }
        final int start = index;
        while (_values.get(index) != null) {
            if (_keys[index] == key) {
                return _values.set(index, value);
            }
            index++;
            index %= _keys.length;
            assert index != start;
        }
        _keys[index] = key;
        _values.set(index, value);
        _numberOfValues++;
        return null;
    }

    public Sequence<Value_Type> toSequence() {
        final MutableSequence<Value_Type> sequence = new ArraySequence<Value_Type>(_numberOfValues);
        if (_values == null) {
            return sequence;
        }
        int n = 0;
        for (int i = 0; i < _values.length(); i++) {
            final Value_Type value = _values.get(i);
            if (value != null) {
                sequence.set(n, value);
                n++;
            }
        }
        return sequence;
    }
}
