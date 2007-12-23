/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.sparc.as;

import jasm.AssemblyException;
import jasm.InstructionSet;
import jasm.sparc.GPR;
import static jasm.sparc.GPR.G0;

/**
 * The base class for the 32-bit and 64-bit SPARC assemblers. This class also defines
 * the more complex synthetic SPARC instructions.
 */
public abstract class SPARCAssembler extends SPARCLabelAssembler {

    @Override
    public final InstructionSet instructionSet() {
        return InstructionSet.SPARC;
    }

    // Utilities:

    private int hi(int i) {
        return (i & 0xfffffc00) >> 10;
    }

    private int lo(int i) {
        return i & 0x000003ff;
    }

    private int hi(long i) {
        return hi((int) i);
    }

    private int lo(long i) {
        return lo((int) i);
    }

    private int uhi(long i) {
        return hi((int) (i >> 32));
    }

    private int ulo(long i) {
        return lo((int) (i >> 32));
    }

    // Complex synthetic instructions according to appendix G3 of the SPARC Architecture Manual V9:

    public final void setuw(int imm, GPR rd) {
        if (lo(imm) == 0) {
            sethi(hi(imm), rd);
        } else if (0 <= imm && imm <= 4095) {
            or(G0, imm, rd);
        } else {
            sethi(hi(imm), rd);
            or(rd, lo(imm), rd);
        }
    }

    public final void set(int imm, GPR rd) throws AssemblyException {
        setuw(imm, rd);
    }

    public final void setsw(int imm, GPR rd) {
        if (0 <= imm && lo(imm) == 0) {
            sethi(hi(imm), rd);
        } else if (-4096 <= imm && imm <= 4095) {
            or(G0, imm, rd);
        } else if (imm < 0 && lo(imm) == 0) {
            sethi(hi(imm), rd);
            sra(rd, G0, rd);
        } else if (imm >= 0) {
            sethi(hi(imm), rd);
            or(rd, lo(imm), rd);
        } else {
            sethi(hi(imm), rd);
            or(rd, lo(imm), rd);
            sra(rd, G0, rd);
        }
    }

    public final void setx(long imm, GPR temp, GPR rd) {
        sethi(uhi(imm), temp);
        or(temp, ulo(imm), temp);
        sllx(temp, 32, temp);
        sethi(hi(imm), rd);
        or(rd, temp, rd);
        or(rd, lo(imm), rd);
    }

}
