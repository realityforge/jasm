/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=45696b8e-aa08-46e0-9312-621bff625922*/
package jasm.sparc;

import com.sun.max.collect.ArraySequence;
import com.sun.max.collect.Sequence;
import jasm.AbstractSymbolicArgument;
import jasm.util.Symbolizer;
import java.util.Iterator;

/**
 * The components of the argument to the Memory Barrier (i.e. {@code membar}) instruction.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class MembarOperand extends AbstractSymbolicArgument {

    private String _externalName;

    private MembarOperand(String name, String externalName, int value) {
        super(name, value);
        _externalName = externalName;
    }

    private MembarOperand(MembarOperand addend1, MembarOperand addend2) {
        super(addend1.name() + "_" + addend2.name(), addend1.value() | addend2.value());
        _externalName = addend1._externalName + " | " + addend2._externalName;
    }

    @Override
    public String externalValue() {
        return _externalName;
    }

    @Override
    public String toString() {
        return externalValue();
    }

    public MembarOperand or(MembarOperand other) {
        return new MembarOperand(this, other);
    }

    public static final MembarOperand NO_MEMBAR = new MembarOperand("None", "0", 0);
    public static final MembarOperand LOAD_LOAD = new MembarOperand("LoadLoad", "#LoadLoad", 1);
    public static final MembarOperand STORE_LOAD = new MembarOperand("StoreLoad", "#StoreLoad", 2);
    public static final MembarOperand LOAD_STORE = new MembarOperand("LoadStore", "#LoadStore", 4);
    public static final MembarOperand STORE_STORE = new MembarOperand("StoreStore", "#StoreStore", 8);
    public static final MembarOperand LOOKASIDE = new MembarOperand("Lookaside", "#Lookaside", 16);
    public static final MembarOperand MEM_ISSUE = new MembarOperand("MemIssue", "#MemIssue", 32);
    public static final MembarOperand SYNC = new MembarOperand("Sync", "#Sync", 64);

    public static final Symbolizer<MembarOperand> SYMBOLIZER = new Symbolizer<MembarOperand>() {

        private final Sequence<MembarOperand> _values = new ArraySequence<MembarOperand>(new MembarOperand[]{NO_MEMBAR, LOAD_LOAD, STORE_LOAD, LOAD_STORE, STORE_STORE, LOOKASIDE, MEM_ISSUE, SYNC});

        public Class<MembarOperand> type() {
            return MembarOperand.class;
        }

        public MembarOperand fromValue(int value) {
            MembarOperand result = NO_MEMBAR;
            for (MembarOperand operand : _values) {
                if ((value & operand.value()) != 0) {
                    if (result == NO_MEMBAR) {
                        result = operand;
                    } else {
                        result = new MembarOperand(result, operand);
                    }
                }
            }
            return result;
        }

        public Iterator<MembarOperand> iterator() {
            return _values.iterator();
        }
    };

}
