/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.gen.InstructionDescription;
import jasm.WordWidth;
import java.util.List;

/**
 * @author Bernd Mathiske
 */
public final class X86InstructionDescription extends InstructionDescription {

    public X86InstructionDescription(List<Object> specifications) {
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
