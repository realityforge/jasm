/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=60a3c717-bbb4-480f-a692-e7cb8d85fb95*/
package com.sun.max.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Iterators {
  public static <Element_Type> Iterator<Element_Type> empty() {
    return new Iterator<Element_Type>() {
      public boolean hasNext() {
        return false;
      }

      public Element_Type next() {
        throw new NoSuchElementException();
      }

      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
}
