/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=2198ad67-ecbb-4139-9ed7-fafc608ac668*/
package com.sun.max.asm.gen.cisc.x86;

import com.sun.max.asm.Argument;
import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.gen.TestArgumentExclusion;
import com.sun.max.asm.gen.WrappableSpecification;
import com.sun.max.collect.Sets;

/**
 * @author Bernd Mathiske
 */
public enum FloatingPointOperandCode implements WrappableSpecification {
    bytes_2(""),
    bytes_14_28(""),
    bytes_98_108(""),
    word_integer("s"),
    short_integer("l"),
    long_integer("q"),
    single_real("s"),
    double_real("l"),
    extended_real("t"),
    packed_bcd(""),
    ST_i("");

    private final String _operandTypeSuffix;

    private FloatingPointOperandCode(String operandTypeSuffix) {
        _operandTypeSuffix = operandTypeSuffix;
    }

    public String operandTypeSuffix() {
        return _operandTypeSuffix;
    }

    public TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
        return new TestArgumentExclusion(AssemblyTestComponent.EXTERNAL_ASSEMBLER, this, Sets.from(arguments));
    }
}
