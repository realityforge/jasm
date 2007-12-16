/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0b1a9456-e5f5-4814-9e1a-e71e160a2ff7*/
package com.sun.max.util;

import com.sun.max.annotate.Implement;
import com.sun.max.collect.Sequence;
import com.sun.max.program.ProgramError;
import java.util.Iterator;

final class SequenceSymbolizer<Symbol_Type extends Symbol> implements Symbolizer<Symbol_Type> {

    private final Class<Symbol_Type> _symbolType;
    private final Sequence<Symbol_Type> _symbols;

    SequenceSymbolizer(Class<Symbol_Type> symbolType, Sequence<Symbol_Type> symbols) {
        if (symbolType.getName().startsWith("com.sun.max.asm") && Symbolizer.Static.hasPackageExternalAccessibleConstructors(symbolType)) {
            // This test ensures that values passed for symbolic parameters of methods in the
            // generated assemblers are guaranteed to be legal (assuming client code does not
            // inject its own classes into the package where the symbol classes are defined).
            ProgramError.unexpected("type of assembler symbol can have values constructed outside of defining package: " + symbolType);
        }
        _symbolType = symbolType;
        _symbols = symbols;
        ProgramError.check(!_symbols.isEmpty());
    }

    @Implement(Symbolizer.class)
    public Class<Symbol_Type> type() {
        return _symbolType;
    }

    @Implement(Symbolizer.class)
    public Symbol_Type fromValue(int value) {
        for (Symbol_Type symbol : _symbols) {
            if (symbol.value() == value) {
                return symbol;
            }
        }
        return null;
    }

    @Implement(Iterable.class)
    public Iterator<Symbol_Type> iterator() {
        return _symbols.iterator();
    }
}
