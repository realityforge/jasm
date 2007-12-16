/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f2b96038-8d56-4135-b871-5ea6550bc7e2*/
package com.sun.max.collect;

import com.sun.max.annotate.Implement;
import java.util.ArrayList;
import java.util.Collections;

/**
 * An implementation of a pool based on {@link ArrayList}.
 *
 * @author Doug Simon
 */
public class ArrayListPool<PoolObject_Type extends PoolObject> extends ArrayList<PoolObject_Type> implements Pool<PoolObject_Type> {

    public ArrayListPool() {
        super();
    }

    public ArrayListPool(PoolObject_Type[] elements) {
        super();
        Collections.addAll(this, elements);
    }

    /**
     * Enforces the precondition for {@link Pool#append(PoolObject)}.
     */
    @Implement(Pool.class)
    public void append(PoolObject_Type element) {
        assert element.serial() == size();
        super.add(element);
    }

}
