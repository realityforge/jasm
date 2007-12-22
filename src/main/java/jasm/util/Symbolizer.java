/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

import jasm.util.collect.AppendableSequence;
import jasm.util.collect.ArrayListSequence;
import jasm.util.collect.ArraySequence;
import jasm.util.collect.Sequence;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * A symbolizer is used to group a set of {@link Symbol symbols}. The members of the
 * group can be iterated and the symbol corresponding to a given value can be
 * retrieved from the group.
 *
 * This class is similiar to the semantics of {@code enum}s in Java but adds
 * the ability to have a set of predefined symbols whose primitive values are not
 * necessarily contiguous and starting at 0.
 *
 * @author Bernd Mathiske
 */
public interface Symbolizer<Symbol_Type extends Symbol> extends Iterable<Symbol_Type> {

    /**
     * @return the concrete type of the symbols in the group
     */
    Class<Symbol_Type> type();

    /**
     * Gets the symbol in the group whose primitive value equals {@code value}.
     *
     * @param value  the search key
     * @return the found symbol or {@code null} if no symbol is found for {@code value}
     */
    Symbol_Type fromValue(int value);

    public static final class Static {

        private Static() {

        }

        public static boolean hasPackageExternalAccessibleConstructors(Class type) {
            final int publicOrProtected = Modifier.PUBLIC | Modifier.PROTECTED;
            for (Constructor constructor : type.getConstructors()) {
                if ((constructor.getModifiers() & publicOrProtected) != 0) {
                    return true;
                }
            }
            return false;
        }

        public static <Symbol_Type extends Symbol> Symbolizer<Symbol_Type> from(Class<Symbol_Type> symbolType, Symbol_Type... symbols) {
            return new SequenceSymbolizer<Symbol_Type>(symbolType, new ArraySequence<Symbol_Type>(symbols));
        }

        public static <Symbol_Type extends Symbol> Symbolizer<Symbol_Type> fromSequence(Class<Symbol_Type> symbolType, Iterable< ? extends Symbol_Type> symbols,
                        final Symbol_Type... additionalSymbols) {
            final AppendableSequence<Symbol_Type> sequence = new ArrayListSequence<Symbol_Type>(additionalSymbols);
            for (Symbol_Type symbol : symbols) {
                sequence.append(symbol);
            }
            return new SequenceSymbolizer<Symbol_Type>(symbolType, sequence);
        }

      public static <Symbol_Type extends Symbol> Symbolizer<Symbol_Type> initialize(Class staticNameFieldClass, Class<Symbol_Type> symbolType) {
            final AppendableSequence<Symbol_Type> sequence = new ArrayListSequence<Symbol_Type>();
        final Sequence<StaticFieldName> staticFieldNames = StaticFieldName.Static.initialize(staticNameFieldClass, null);
            for (StaticFieldName staticFieldName : staticFieldNames) {
                if (symbolType.isInstance(staticFieldName)) {
                    sequence.append(symbolType.cast(staticFieldName));
                }
            }
            return new SequenceSymbolizer<Symbol_Type>(symbolType, sequence);
        }

        public static <Symbol_Type extends Symbol> Symbolizer<Symbol_Type> initialize(Class<Symbol_Type> symbolType) {
            return initialize(symbolType, symbolType);
        }

    }
}