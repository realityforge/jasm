/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
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
