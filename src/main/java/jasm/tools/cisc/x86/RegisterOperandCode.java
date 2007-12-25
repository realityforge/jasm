/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.tools.ExternalOmission;

public enum RegisterOperandCode {

    eAX, eCX, eDX, eBX, eSP, eBP, eSI, eDI,
    rAX, rCX, rDX, rBX, rSP, rBP, rSI, rDI;

    public int id() {
        return ordinal() % 8;
    }

    public ExternalOmission omitExternally() {
        return new ExternalOmission(this);
    }

}
