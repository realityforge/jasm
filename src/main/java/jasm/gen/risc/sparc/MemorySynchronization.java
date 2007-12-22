/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.sparc;

import static jasm.gen.risc.sparc.SPARCFields._membarMask;
import static jasm.gen.risc.sparc.SPARCFields._res_12_0;
import static jasm.gen.risc.sparc.SPARCFields._res_12_7;
import static jasm.gen.risc.sparc.SPARCFields._res_29_25;
import static jasm.gen.risc.sparc.SPARCFields.bits_18_14;
import static jasm.gen.risc.sparc.SPARCFields.i;
import static jasm.gen.risc.sparc.SPARCFields.op;
import static jasm.gen.risc.sparc.SPARCFields.op3;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
final class MemorySynchronization extends SPARCInstructionDescriptionCreator {

    private void create_A32() {
        define("membar", op(0x2), _res_29_25, op3(0x28), bits_18_14(0xf), i(1), _res_12_7, _membarMask);
    }

    private void create_A51() {
        if (assembly().generatingDeprecatedInstructions()) {
            define("stbar", op(0x2), _res_29_25, op3(0x28), bits_18_14(0xf), i(0), _res_12_0);
        }
    }

    MemorySynchronization(SPARCTemplateCreator templateCreator) {
        super(templateCreator);

        setCurrentArchitectureManualSection("A.32");
        create_A32();

        setCurrentArchitectureManualSection("A.51");
        create_A51();
    }
}
