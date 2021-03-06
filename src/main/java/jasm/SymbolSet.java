/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

import jasm.util.NamedField;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 * A symbolizer is used to group a set of {@link Symbol symbols}. The members of the
 * group can be iterated and the symbol corresponding to a given value can be
 * retrieved from the group.
 * <p/>
 * This class is similiar to the semantics of {@code enum}s in Java but adds
 * the ability to have a set of predefined symbols whose primitive values are not
 * necessarily contiguous and starting at 0.
 */
public class SymbolSet<Symbol_Type extends Symbol>
    implements Iterable<Symbol_Type> {

  private final Class<Symbol_Type> _symbolType;
  private final Collection<Symbol_Type> _symbols;

  protected SymbolSet(Class<Symbol_Type> symbolType, Collection<Symbol_Type> symbols) {
    if (symbolType.getName().startsWith("jasm") &&
        hasAccessibleConstructors(symbolType)) {
      // This test ensures that values passed for symbolic parameters of methods in the
      // generated assemblers are guaranteed to be legal (assuming client code does not
      // inject its own classes into the package where the symbol classes are defined).
      throw new IllegalStateException("type of assembler symbol can have values constructed outside of defining package: " + symbolType);
    }
    _symbolType = symbolType;
    _symbols = symbols;
    if (_symbols.isEmpty()) {
      throw new IllegalStateException("Attempted to create SymbolSet with no symbols for " + symbolType);
    }
  }

  /** @return the concrete type of the symbols in the group */
  public final Class<Symbol_Type> type() {
    return _symbolType;
  }

  /**
   * Gets the symbol in the group whose primitive value equals {@code value}.
   *
   * @param value the search key
   * @return the found symbol or {@code null} if no symbol is found for {@code value}
   */
  public Symbol_Type fromValue(int value) {
    for (Symbol_Type symbol : _symbols) {
      if (symbol.value() == value) {
        return symbol;
      }
    }
    return null;
  }

  public final Iterator<Symbol_Type> iterator() {
    return _symbols.iterator();
  }

  public final Collection<Symbol_Type> asCollection() {
    return _symbols;
  }

  public final int size() {
    return _symbols.size();
  }

  private static boolean hasAccessibleConstructors(Class type) {
    final int publicOrProtected = Modifier.PUBLIC | Modifier.PROTECTED;
    for (Constructor constructor : type.getConstructors()) {
      if ((constructor.getModifiers() & publicOrProtected) != 0) {
        return true;
      }
    }
    return false;
  }

  public static <Symbol_Type extends Enum<Symbol_Type> & Symbol> SymbolSet<Symbol_Type> fromEnum(Class<Symbol_Type> symbolType) {
    final EnumSet<Symbol_Type> symbols = EnumSet.allOf(symbolType);
    return new SymbolSet<Symbol_Type>(symbolType, symbols);
  }

  public static <Symbol_Type extends Symbol> SymbolSet<Symbol_Type> fromCollection(Class<Symbol_Type> symbolType, Collection<Symbol_Type> collection) {
    return new SymbolSet<Symbol_Type>(symbolType, collection);
  }

  public static <Symbol_Type extends Symbol> SymbolSet<Symbol_Type> fromStaticFields(Class<?> source, Class<Symbol_Type> type) {
    final ArrayList<Symbol_Type> sequence = new ArrayList<Symbol_Type>();
    final List<NamedField> fields = NamedField.initStaticFieldNames(source);
    for (NamedField field : fields) {
      if (type.isInstance(field)) {
        sequence.add(type.cast(field));
      }
    }
    return new SymbolSet<Symbol_Type>(type, sequence);
  }

  public static <Symbol_Type extends Symbol> SymbolSet<Symbol_Type> fromStaticFields(Class<Symbol_Type> symbolType) {
    return fromStaticFields(symbolType, symbolType);
  }
}
