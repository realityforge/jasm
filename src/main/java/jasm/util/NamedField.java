/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/** Class that is the base class of all fields that receive names based on the name of the field they are stored in. */
public abstract class NamedField implements Nameable {
  private String _name;

  protected NamedField() {
  }

  protected NamedField(final String name) {
    _name = name;
  }

  public String name() {
    return _name;
  }

  public static List<NamedField> initStaticFieldNames(Class<?> type) {
    final ArrayList<NamedField> result = new ArrayList<NamedField>();
    for (Field field : type.getDeclaredFields()) {
      if ((field.getModifiers() & Modifier.STATIC) != 0 && Nameable.class.isAssignableFrom(field.getType())) {
        field.setAccessible(true);
        try {
          final NamedField value = (NamedField) field.get(null);
          if (null == value._name) {
            value._name = field.getName();
          }
          result.add(value);
        } catch (final IllegalAccessException iae) {
          throw new IllegalStateException("could not name value of field: " + field, iae);
        }
      }
    }
    return result;
  }
}
