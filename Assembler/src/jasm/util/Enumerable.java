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

/**
 * Java enums are insufficient in that their ordinals have to be successive.
 * An Enumerable has an additional arbitrary int "value",
 * which may incur gaps between ordinal-successive Enumerables.
 *
 * An Enumerator can be called upon to provide the respective Enumerable matching a given value.
 *
 * @see Enumerator
 *
 * @author Bernd Mathiske
 */
public interface Enumerable<Enumerable_Type extends Enum<Enumerable_Type> & Enumerable<Enumerable_Type>> extends Symbol {

    // We are merely declaring this method to lock in the same parameter type for the corresponding enumerator,
    // not for any actual use
    Enumerator<Enumerable_Type> enumerator();

}
