/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.risc;

import jasm.gen.risc.RiscTemplate;
import jasm.util.collect.IntHashMap;
import jasm.util.lang.StaticLoophole;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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

    private final IntHashMap<LinkedList<Template_Type>> _templatesForOpcodes = new IntHashMap<LinkedList<Template_Type>>();

    public void add(Template_Type template) {
        assert template.opcodeMask() == _mask;
        _templates.add(template);
        LinkedList<Template_Type> templatesForOpcode = _templatesForOpcodes.get(template.opcode());
        if (templatesForOpcode == null) {
            templatesForOpcode = new LinkedList<Template_Type>();
            _templatesForOpcodes.put(template.opcode(), templatesForOpcode);
        }
        templatesForOpcode.addLast(template);
    }

    public List<Template_Type> templatesFor(int opcode) {
        final LinkedList<Template_Type> result = _templatesForOpcodes.get(opcode);
        if (result == null) {
            return StaticLoophole.cast(Collections.EMPTY_LIST);
        }
        return result;
    }

    public List<Template_Type> templates() {
        return new ArrayList<Template_Type>(_templates);
    }
}
