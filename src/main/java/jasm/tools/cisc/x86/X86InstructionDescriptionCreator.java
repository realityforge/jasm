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
import static jasm.util.HexByte._0F;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class X86InstructionDescriptionCreator
    extends InstructionDescriptionCreator<X86InstructionDescription> {

  public X86InstructionDescriptionCreator(Assembly<? extends X86Template> assembly) {
    super(assembly);
  }

  protected final X86InstructionDescription define1B(HexByte opcode1,
                                                     Object... specifications) {
    final ArrayList<Object> specs = new ArrayList<Object>(specifications.length + 1);
    specs.add(opcode1);
    specs.addAll(Arrays.asList(specifications));
    return super.define(specs.toArray());
  }

  protected final X86InstructionDescription define2B(HexByte opcode2,
                                                     Object... specifications) {
    final ArrayList<Object> specs = new ArrayList<Object>(specifications.length + 1);
    specs.add(_0F);
    specs.add(opcode2);
    specs.addAll(Arrays.asList(specifications));
    return super.define(specs.toArray());
  }

  protected final X86InstructionDescription defineFP(HexByte opcode1,
                                                     HexByte opcode2,
                                                     String name,
                                                     Object... specifications) {
    final ArrayList<Object> specs = new ArrayList<Object>(specifications.length + 1);
    specs.add(opcode1);
    specs.add(opcode2);
    specs.add(name);    
    specs.addAll(Arrays.asList(specifications));
    return super.define(specs.toArray());
  }

  @Override
  protected final X86InstructionDescription createInstructionDescription(final String currentArchitectureManualSection,
                                                                         List<Object> specifications) {
    return new X86InstructionDescription(currentArchitectureManualSection, specifications);
  }
}
