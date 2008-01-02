/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.tools.InstructionDescription;
import java.util.List;

public final class ModRMDescription
    extends InstructionDescription<ModRMDescription> {

  private final ModRMOpcode _opcode;
  private final String _name;

  public ModRMDescription(ModRMOpcode opcode, String name, List<Object> specifications) {
    super(null, specifications);
    _opcode = opcode;
    _name = name;
  }

  public ModRMOpcode opcode() {
    return _opcode;
  }

  public String name() {
    return _name;
  }
}
