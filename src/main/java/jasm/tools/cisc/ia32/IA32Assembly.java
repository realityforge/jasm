/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.ia32;

import jasm.InstructionSet;
import jasm.tools.cisc.x86.FloatingPointOpcodeMap;
import jasm.tools.cisc.x86.X86Assembly;
import jasm.tools.cisc.x86.X86InstructionDescription;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class IA32Assembly extends X86Assembly<IA32Template> {

  public static final IA32Assembly ASSEMBLY = new IA32Assembly();

  private IA32Assembly() {
    super(InstructionSet.IA32, IA32Template.class);
  }

  @Override
  protected List<IA32Template> createTemplates() {
    final IA32TemplateCreator creator = new IA32TemplateCreator();
    creator.createTemplates(new OneByteOpcodeMap());
    creator.createTemplates(new TwoByteOpcodeMap());
    creator.createTemplates(new FloatingPointOpcodeMap(this));
    return creator.templates();
  }

  public final Collection<X86InstructionDescription> instructionDescriptions() {
    final LinkedList<X86InstructionDescription> desc1 = new OneByteOpcodeMap().instructionDescriptions();
    final LinkedList<X86InstructionDescription> desc2 = new TwoByteOpcodeMap().instructionDescriptions();
    final LinkedList<X86InstructionDescription> desc3 = new FloatingPointOpcodeMap(this).instructionDescriptions();
    final ArrayList<X86InstructionDescription> descriptions =
        new ArrayList<X86InstructionDescription>(desc1.size() + desc2.size() + desc3.size());
    descriptions.addAll(desc1);
    descriptions.addAll(desc2);
    descriptions.addAll(desc3);
    return descriptions;
  }
}
