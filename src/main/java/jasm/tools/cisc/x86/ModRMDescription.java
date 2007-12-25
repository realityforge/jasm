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

public final class ModRMDescription extends InstructionDescription {

    private final ModRMGroup.Opcode _opcode;
    private final String _name;

    public ModRMDescription(ModRMGroup.Opcode opcode, String name, List<Object> specifications) {
        super(specifications);
        _opcode = opcode;
        _name = name;
    }

    public ModRMGroup.Opcode opcode() {
        return _opcode;
    }

    public String name() {
        return _name;
    }
}
