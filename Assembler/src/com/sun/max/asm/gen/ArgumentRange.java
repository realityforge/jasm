/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d0cc276b-199c-4283-b307-837c13f75a44*/
package com.sun.max.asm.gen;

import com.sun.max.asm.Argument;

/**
 * @author Bernd Mathiske
 */
public class ArgumentRange {

    private final WrappableSpecification _specification;
    private final long _minValue;
    private final long _maxValue;

    public ArgumentRange(WrappableSpecification specification, long minValue, long maxValue) {
        _specification = specification;
        _minValue = minValue;
        _maxValue = maxValue;
    }

    public WrappableSpecification wrappedSpecification() {
        return _specification;
    }

    public long minValue() {
        return _minValue;
    }

    public long maxValue() {
        return _maxValue;
    }

    public boolean includes(Argument argument) {
        return _minValue <= argument.asLong() && argument.asLong() <= _maxValue;
    }

    private boolean _appliesInternally = true;

    public boolean appliesInternally() {
        return _appliesInternally;
    }

    public void doNotApplyInternally() {
        _appliesInternally = false;
    }

    public static final ArgumentRange UNSPECIFIED = null;

}
