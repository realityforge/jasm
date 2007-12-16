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
package jasm.dis.risc;

import com.sun.max.collect.Sequence;
import jasm.gen.risc.RiscTemplate;

/**
 *
 *
 * @author Dave Ungar
 * @author Bernd Mathiske
 */
public class SpecificityGroup<Template_Type extends RiscTemplate> {

    private final int _specificity;
    private final Sequence<OpcodeMaskGroup<Template_Type>> _opcodeMaskGroups;

    public SpecificityGroup(int specificity, Sequence<OpcodeMaskGroup<Template_Type>> opcodeMaskGroups) {
        _specificity = specificity;
        _opcodeMaskGroups = opcodeMaskGroups;
    }

    public int specificity() {
        return _specificity;
    }

    public Sequence<OpcodeMaskGroup<Template_Type>> opcodeMaskGroups() {
        return _opcodeMaskGroups;
    }

}
