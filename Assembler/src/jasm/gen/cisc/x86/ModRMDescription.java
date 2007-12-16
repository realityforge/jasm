/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.x86;

import com.sun.max.collect.MutableSequence;
import jasm.gen.InstructionDescription;

/**
 * @author Bernd Mathiske
 */
public final class ModRMDescription extends InstructionDescription {

    private final ModRMGroup.Opcode _opcode;
    private final String _name;

    public ModRMDescription(ModRMGroup.Opcode opcode, String name, MutableSequence<Object> specifications) {
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
