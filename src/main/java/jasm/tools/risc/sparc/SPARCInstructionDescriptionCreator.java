/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc;

import jasm.tools.Assembly;
import jasm.tools.risc.RiscInstructionDescriptionCreator;

public abstract class SPARCInstructionDescriptionCreator extends RiscInstructionDescriptionCreator {

  protected SPARCInstructionDescriptionCreator(SPARCTemplateCreator templateCreator) {
    super(SPARCAssembly.ASSEMBLY, templateCreator);
  }

  @Override
  public final SPARCAssembly assembly() {
    final Assembly assembly = super.assembly();
    return (SPARCAssembly) assembly;
  }
}
