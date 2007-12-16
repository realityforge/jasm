/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.x86;

import jasm.gen.Operand;

/**
 * Description of an assembly instruction operand.
 *
 * @author Bernd Mathiske
 */
public abstract class X86Operand implements Operand {

    public enum Designation {
        DESTINATION, SOURCE, OTHER;
    }

    private Designation _designation;

    protected X86Operand(Designation designation) {
        _designation = designation;
    }

    public Designation designation() {
        return _designation;
    }

}
