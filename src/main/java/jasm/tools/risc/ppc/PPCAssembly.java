/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.ppc;

import jasm.InstructionSet;
import jasm.tools.risc.RiscAssembly;
import java.util.List;

public final class PPCAssembly extends RiscAssembly<PPCTemplate> {

  private static final boolean GENERATING_64BIT_INSTRUCTIONS = true;
  private static final boolean GENERATING_POWER5_INSTRUCTIONS = false;

  private PPCAssembly() {
    super(InstructionSet.PPC, PPCTemplate.class);
  }

  public boolean generating64BitInstructions() {
    return GENERATING_64BIT_INSTRUCTIONS;
  }

  public boolean generatingPower5Instructions() {
    return GENERATING_POWER5_INSTRUCTIONS;
  }

  /**
   * The existence of this method documents a bug in the Apple version of GNU 'as' where bit 11
   * in an mtcrf instruction is encoded as 1 but specified as 0 in the architecture manual.
   * <p/>
   * This will have to be a non-constant method should another non-broken external assembler
   * be used for testing.
   */
  public boolean isExternalMTCRFEncodingBroken() {
    return true;
  }

  @Override
  protected List<PPCTemplate> createTemplates() {
    final PPCTemplateCreator creator = new PPCTemplateCreator();
    creator.createTemplates(new RawInstructions(creator));
    creator.createTemplates(new SyntheticInstructions(creator));
    return creator.templates();
  }

  public static final PPCAssembly ASSEMBLY = new PPCAssembly();
}
