/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0604bcb6-0146-46c6-a99a-ab5f1f2ddf5c*/
package com.sun.max.asm.dis.risc;

import com.sun.max.asm.gen.risc.RiscTemplate;
import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.IntHashMap;
import com.sun.max.collect.Sequence;
import java.util.HashSet;
import java.util.Set;

/**
 * An opcode mask group is a collection of templates that share the same opcode mask.
 * Some templates in the group may also share the same opcode.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class OpcodeMaskGroup<Template_Type extends RiscTemplate> {

    private final int _mask;

    public OpcodeMaskGroup(int mask) {
        _mask = mask;
    }

    public int mask() {
        return _mask;
    }

    private final Set<Template_Type> _templates = new HashSet<Template_Type>();

    private final IntHashMap<AppendableSequence<Template_Type>> _templatesForOpcodes = new IntHashMap<AppendableSequence<Template_Type>>();
    private final Sequence<Template_Type> _empty = new ArrayListSequence<Template_Type>();

    public void add(Template_Type template) {
        assert template.opcodeMask() == _mask;
        _templates.add(template);
        AppendableSequence<Template_Type> templatesForOpcode = _templatesForOpcodes.get(template.opcode());
        if (templatesForOpcode == null) {
            templatesForOpcode = new ArrayListSequence<Template_Type>();
            _templatesForOpcodes.put(template.opcode(), templatesForOpcode);
        }
        templatesForOpcode.append(template);
    }

    public Sequence<Template_Type> templatesFor(int opcode) {
        final Sequence<Template_Type> result = _templatesForOpcodes.get(opcode);
        if (result == null) {
            return _empty;
        }
        return result;
    }

    public Sequence<Template_Type> templates() {
        return new ArrayListSequence<Template_Type>(_templates);
    }
}
