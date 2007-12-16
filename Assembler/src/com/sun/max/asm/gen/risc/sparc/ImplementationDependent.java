/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f49743b0-2b20-41a5-86cf-30236142e371*/
package com.sun.max.asm.gen.risc.sparc;

import static com.sun.max.asm.gen.risc.sparc.SPARCFields._impl_dep;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields.op;
import static com.sun.max.asm.gen.risc.sparc.SPARCFields.op3;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public class ImplementationDependent extends SPARCInstructionDescriptionCreator {

    private void create_A23() {
        define("impdep1", op(0x2), op3(0x36), _impl_dep);
        define("impdep2", op(0x2), op3(0x37), _impl_dep);
    }

    ImplementationDependent(SPARCTemplateCreator templateCreator) {
        super(templateCreator);

        setCurrentArchitectureManualSection("A.23");
        create_A23();
    }
}
