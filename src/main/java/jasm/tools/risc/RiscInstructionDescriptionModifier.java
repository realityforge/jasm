/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc;

import jasm.tools.util.CollectionUtil;
import java.util.List;

/** This class provides a mechanism for making modifications to a set of RISC instruction descriptions. */
public final class RiscInstructionDescriptionModifier {

  private final List<RiscInstructionDescription> _instructionDescriptions;

  public RiscInstructionDescriptionModifier(List<RiscInstructionDescription> instructionDescriptions) {
    _instructionDescriptions = instructionDescriptions;
  }

  /**
   * Replaces a specification in the set of instruction descriptions.
   *
   * @param before the specification to be replaced (matched with {@link Object#equals})
   * @param after  the replacement value
   */
  public final RiscInstructionDescriptionModifier replace(Object before, Object after) {
    for (RiscInstructionDescription instructionDescription : _instructionDescriptions) {
      final List<Object> specifications = instructionDescription.specifications();
      for (int i = 0; i < specifications.size(); i++) {
        if (specifications.get(i).equals(before)) {
          specifications.set(i, after);
        }
      }
    }
    return this;
  }

  public final RiscInstructionDescriptionModifier swap(Object a, Object b) {
    for (RiscInstructionDescription instructionDescription : _instructionDescriptions) {
      final List<Object> specifications = instructionDescription.specifications();
      final int aIndex = CollectionUtil.indexOfIdentical(specifications, a);
      final int bIndex = CollectionUtil.indexOfIdentical(specifications, b);
      if (aIndex != -1 && bIndex != -1) {
        specifications.set(aIndex, b);
        specifications.set(bIndex, a);
      }
    }
    return this;
  }

  public final RiscInstructionDescriptionModifier setExternalName(String externalName) {
    for (RiscInstructionDescription instructionDescription : _instructionDescriptions) {
      instructionDescription.setExternalName(externalName);
    }
    return this;
  }
}
