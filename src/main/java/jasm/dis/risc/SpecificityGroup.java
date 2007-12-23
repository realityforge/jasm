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
import java.util.Collection;

public final class SpecificityGroup<Template_Type extends RiscTemplate> {

  private final int _specificity;
  private final Collection<OpcodeMaskGroup<Template_Type>> _opcodeMaskGroups;

  public SpecificityGroup(int specificity, Collection<OpcodeMaskGroup<Template_Type>> opcodeMaskGroups) {
    _specificity = specificity;
    _opcodeMaskGroups = opcodeMaskGroups;
  }

  public final int specificity() {
    return _specificity;
  }

  public final Collection<OpcodeMaskGroup<Template_Type>> opcodeMaskGroups() {
    return _opcodeMaskGroups;
  }

  public String toString() {
    return
        "[SpecificityGroup specificity=" + _specificity +
            ", opcodeMaskGroups=" + _opcodeMaskGroups + "]";
  }
}
