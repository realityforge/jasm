/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e224da89-a223-4600-88c4-635b134e519f*/
package com.sun.max.collect;

/**
 * @author Bernd Mathiske
 */
public interface Mapping<Key_Type, Value_Type> {

    Value_Type put(Key_Type key, Value_Type value);
    
    Value_Type get(Key_Type key);
    
    boolean containsKey(Key_Type key);
    
}
