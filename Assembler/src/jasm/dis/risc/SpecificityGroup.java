/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d601df2b-a9ef-419b-b3b5-c7826513c664*/
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
