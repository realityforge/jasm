/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.tools.Assembly;
import jasm.tools.InstructionDescriptionCreator;
import jasm.util.HexByte;
import static jasm.util.HexByte.*;
import java.util.ArrayList;
import java.util.Arrays;

public class X86InstructionDescriptionCreator
    extends InstructionDescriptionCreator<X86InstructionDescription> {

  public X86InstructionDescriptionCreator(Assembly<? extends X86Template> assembly) {
    super(assembly);
  }

  protected final X86InstructionDescription define1B(HexByte opcode1,
                                                     Object... specifications) {
    return defineInstruction(opcode1, null, specifications);
  }

  protected final X86InstructionDescription define2B(HexByte opcode2,
                                                     Object... specifications) {
    return defineInstruction(_0F, opcode2, specifications);
  }

  protected final X86InstructionDescription defineFP(HexByte opcode1,
                                                     HexByte opcode2,
                                                     String name,
                                                     Object... specifications) {
    final ArrayList<Object> specs = new ArrayList<Object>(specifications.length + 1);
    specs.add(name);
    specs.addAll(Arrays.asList(specifications));
    return defineInstruction(opcode1, opcode2, specs.toArray());
  }

  private X86InstructionDescription defineInstruction(HexByte opcode1,
                                                     HexByte opcode2,
                                                     Object... specifications )
  {
    final X86InstructionDescription description = new X86InstructionDescription(opcode1, opcode2, Arrays.asList(specifications));
    registerDescription(description);
    return description;
  }
}
