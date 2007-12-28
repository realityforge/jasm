/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

import java.util.Arrays;
import java.util.List;

/** Static type loophole that prevents "unchecked" compiler warnings but that does not circumvent dynamic type checks. */
public final class StaticLoophole {
  @SuppressWarnings("unchecked")
  public static <T> T cast(Object object) {
    return (T) object;
  }

  @SuppressWarnings("unchecked")
  public static <T> List<T> asList(T object) {
    return Arrays.asList(object);
  }
}
