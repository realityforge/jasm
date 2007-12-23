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
import jasm.util.HexUtil;
import jasm.util.lang.StaticLoophole;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * An opcode mask group is a collection of templates that share the same opcode mask.
 * Some templates in the group may also share the same opcode.
 */
public final class OpcodeMaskGroup<Template_Type extends RiscTemplate> {

  private final HashMap<Integer, LinkedList<Template_Type>> _templatesForOpcodes = new HashMap<Integer, LinkedList<Template_Type>>();
  private final int _mask;

  public OpcodeMaskGroup(int mask) {
    _mask = mask;
  }

  public final int mask() {
    return _mask;
  }

  public final void add(Template_Type template) {
    if (template.opcodeMask() != _mask) {
      throw new IllegalStateException();
    }
    LinkedList<Template_Type> templatesForOpcode = _templatesForOpcodes.get(template.opcode());
    if (templatesForOpcode == null) {
      templatesForOpcode = new LinkedList<Template_Type>();
      _templatesForOpcodes.put(template.opcode(), templatesForOpcode);
    }
    templatesForOpcode.addLast(template);
  }

  public final List<Template_Type> templatesFor(int opcode) {
    final LinkedList<Template_Type> result = _templatesForOpcodes.get(opcode);
    if (result == null) {
      return StaticLoophole.cast(Collections.EMPTY_LIST);
    }
    return result;
  }

  public String toString() {
    return "[OpcodeMaskGroup mask=" + HexUtil.toHexLiteral(_mask) + "]";
  }
}
