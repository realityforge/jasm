/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=9da43812-0d8e-4262-8f2b-662e48921351*/
package jasm.gen.cisc.x86;

import com.sun.max.collect.MutableSequence;
import jasm.gen.InstructionDescription;
import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public final class X86InstructionDescription extends InstructionDescription {

    public X86InstructionDescription(MutableSequence<Object> specifications) {
        super(specifications);
    }

    private boolean _isExternalOperandOrderingInverted = true;

    public boolean isExternalOperandOrderingInverted() {
        return _isExternalOperandOrderingInverted;
    }

    public void revertExternalOperandOrdering() {
        _isExternalOperandOrderingInverted = false;
    }

    private WordWidth _defaultOperandSize = WordWidth.BITS_32;

    public WordWidth defaultOperandSize() {
        return _defaultOperandSize;
    }

    public X86InstructionDescription setDefaultOperandSize(WordWidth defaultOperandSize) {
        _defaultOperandSize = defaultOperandSize;
        return this;
    }

}
