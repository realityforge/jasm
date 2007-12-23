/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.sparc;

import jasm.gen.InstructionDescription;
import jasm.gen.risc.RiscTemplateCreator;

public final class SPARCTemplateCreator extends RiscTemplateCreator<SPARCTemplate> {

  SPARCTemplateCreator() {
    super();
  }

  @Override
  protected final SPARCTemplate createTemplate(InstructionDescription instructionDescription) {
    return new SPARCTemplate(instructionDescription);
  }
}
