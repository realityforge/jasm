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
package jasm.util;

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

    public Class<Symbol_Type> type() {
        return _symbolType;
    }

    public Symbol_Type fromValue(int value) {
        for (Symbol_Type symbol : _symbols) {
            if (symbol.value() == value) {
                return symbol;
            }
        }
        return null;
    }

    public Iterator<Symbol_Type> iterator() {
        return _symbols.iterator();
    }
}
