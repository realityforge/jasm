/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc;

import jasm.tools.InstructionDescription;
import jasm.tools.InstructionConstraint;
import jasm.tools.risc.field.InputOperandField;
import jasm.tools.risc.field.RiscField;
import java.util.List;
import java.util.ArrayList;

public final class RiscInstructionDescription
    extends InstructionDescription<RiscInstructionDescription> {

  private boolean _synthetic;
  private List<InstructionConstraint> _constraints;

  RiscInstructionDescription(final String architectureManualSection,
                             final List<Object> specifications) {
    super(architectureManualSection, specifications);

    int bits = 0;
    int mask = 0;
    for (Object specification : specifications) {
      final RiscField field;
      if (specification instanceof RiscField) {
        field = (RiscField) specification;
        if (field instanceof InputOperandField) {
          // Cannot recover the value of these fields from an assembled instruction
          // with support for a simultaneous equation solver
          beNotDisassemblable();
        }
      } else if (specification instanceof RiscConstant) {
        field = ((RiscConstant) specification).field();
      } else {
        continue;
      }
      bits += field.bitRange().encodedWidth();
      final int fieldMask = field.bitRange().instructionMask();
      if ((fieldMask & mask) != 0) {
        throw new IllegalStateException("RISC instruction field defines bits also defined by another field: " + field.name() + "[" + field.bitRange() + "]");
      }
      mask |= fieldMask;
    }

    if (bits != 32) {
      throw new IllegalStateException("RISC instruction description describes " + bits + " instruction field bits: " + specifications);
    }
  }

  public InstructionDescription beSynthetic() {
    _synthetic = true;
    return this;
  }

  public boolean isSynthetic() {
    return _synthetic;
  }

  /** @return the {@link InstructionConstraint} instances (if any) within this description */
    public final List<InstructionConstraint> constraints() {
      if (_constraints == null) {
        final ArrayList<InstructionConstraint> result = new ArrayList<InstructionConstraint>();
        for (Object element : specifications()) {
          if (InstructionConstraint.class.isInstance(element)) {
            result.add(InstructionConstraint.class.cast(element));
          }
        }
        _constraints = result;
      }
      return _constraints;
    }
}
