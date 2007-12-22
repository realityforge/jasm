/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
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

    public final Designation designation() {
        return _designation;
    }

}
