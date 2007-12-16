/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4850c5f4-3904-4dc1-bd37-ef486e453d9b*/
package com.sun.max.asm.gen.cisc.x86;

import com.sun.max.asm.gen.InstructionDescription;
import com.sun.max.collect.MutableSequence;

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
