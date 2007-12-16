/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6731a767-fe08-496a-9bc9-74873e86cc13*/
package com.sun.max.collect;

import java.util.*;

/**
 * @author Bernd Mathiske
 */
public class MutableQueue<Element_Type> extends LinkedList<Element_Type> {

    public MutableQueue(Iterable<Element_Type> elements) {
        super();
        for (Element_Type element : elements) {
            add(element);
        }
    }
    
}
