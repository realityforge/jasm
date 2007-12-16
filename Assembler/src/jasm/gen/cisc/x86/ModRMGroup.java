/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.x86;

/**
 * @author Bernd Mathiske
 */
public interface ModRMGroup {

    public enum Opcode {
        _0, _1, _2, _3, _4, _5, _6, _7;

        public byte byteValue() {
            return (byte) ordinal();
        }
    }

    ModRMDescription getInstructionDescription(Opcode opcode);
}
