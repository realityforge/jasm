/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1bb4e20a-3421-427b-9702-faaff0849fd9*/
package com.sun.max.asm.sparc;

import com.sun.max.asm.AssemblyException;
import com.sun.max.asm.InstructionSet;
import static com.sun.max.asm.sparc.GPR.G0;

/**
 * The base class for the 32-bit and 64-bit SPARC assemblers. This class also defines
 * the more complex synthetic SPARC instructions.
 *
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 * @author Greg Wright
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

    public void setuw(int imm, GPR rd) throws AssemblyException {
        if (lo(imm) == 0) {
            sethi(hi(imm), rd);
        } else if (0 <= imm && imm <= 4095) {
            or(G0, imm, rd);
        } else {
            sethi(hi(imm), rd);
            or(rd, lo(imm), rd);
        }
    }

    public void set(int imm, GPR rd) throws AssemblyException {
        setuw(imm, rd);
    }

    public void setsw(int imm, GPR rd) throws AssemblyException {
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

    public void setx(long imm, GPR temp, GPR rd) throws AssemblyException {
        sethi(uhi(imm), temp);
        or(temp, ulo(imm), temp);
        sllx(temp, 32, temp);
        sethi(hi(imm), rd);
        or(rd, temp, rd);
        or(rd, lo(imm), rd);
    }

}
