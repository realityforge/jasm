/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=3ae8cc88-e204-49be-9e7a-ecda1f52dcbb*/
package com.sun.max.asm.gen.risc.sparc;

import static com.sun.max.asm.gen.risc.sparc.SPARCFields.*;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public class RegisterWindowManagement extends SPARCInstructionDescriptionCreator {

    private void createSaveOrRestore(String name, int op3Contents) {
        define(name, op(0x2), _rs1, op3(op3Contents), i(0), _res_12_5, _rs2, _rd);
        define(name, op(0x2), _rs1, op3(op3Contents), i(1), _simm13, _rd);
    }

    private void create_A21() {
        define("flushw", op(0x2), _res_29_25, op3(0x2b), _res_18_14, i(0), _res_12_0);
    }

    private void create_A45() {
        createSaveOrRestore("save", 0x3c);
        createSaveOrRestore("restore", 0x3d);
    }

    private void create_A46() {
        define("saved", op(0x2), fcnc(0), op3(0x31), _res_18_0);
        define("restored", op(0x2), fcnc(1), op3(0x31), _res_18_0);
    }

    RegisterWindowManagement(SPARCTemplateCreator templateCreator) {
        super(templateCreator);
        
        setCurrentArchitectureManualSection("A.21");
        create_A21();

        setCurrentArchitectureManualSection("A.45");
        create_A45();

        setCurrentArchitectureManualSection("A.46");
        create_A46();
    }
}
