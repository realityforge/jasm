/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a6a14461-c5a6-4700-b7c4-c989a9f9ad7e*/
package jasm;


/**
 * @author Bernd Mathiske
 */
public abstract class BigEndianAssembler extends Assembler {

    protected BigEndianAssembler() {
        super();
    }

    @Override
    protected void emitShort(short shortValue) {
        emitByte((byte) (shortValue >> 8));
        emitByte((byte) (shortValue & 0xff));
    }

    @Override
    protected void emitInt(int intValue) {
        emitShort((short) (intValue >> 16));
        emitShort((short) (intValue & 0xffff));
    }

    @Override
    protected void emitLong(long longValue) {
        emitInt((int) (longValue >> 32));
        emitInt((int) (longValue & 0xffffffffL));
    }

}
