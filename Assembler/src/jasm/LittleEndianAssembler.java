/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm;

/**
 * @author Bernd Mathiske
 */
public abstract class LittleEndianAssembler extends Assembler {

    protected LittleEndianAssembler() {
        super();
    }

    @Override
    protected void emitShort(short shortValue) {
        emitByte((byte) (shortValue & 0xff));
        emitByte((byte) (shortValue >> 8));
    }

    @Override
    protected void emitInt(int intValue) {
        emitShort((short) (intValue & 0xffff));
        emitShort((short) (intValue >> 16));
    }

    @Override
    protected void emitLong(long longValue) {
        emitInt((int) (longValue & 0xffffffffL));
        emitInt((int) (longValue >> 32));
    }

}
