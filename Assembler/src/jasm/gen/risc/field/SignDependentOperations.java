/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=204a4ce5-d0c0-4cd4-af1c-b6187ed8d782*/
package jasm.gen.risc.field;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import jasm.gen.risc.bitRange.BitRange;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public enum SignDependentOperations {

    UNSIGNED {
        @Override
        public int minArgumentValue(BitRange bitRange) {
            return 0;
        }

        @Override
        public int maxArgumentValue(BitRange bitRange) {
            return bitRange.valueMask();
        }

        @Override
        public int assemble(int unsignedInt, BitRange bitRange) throws IndexOutOfBoundsException {
            return bitRange.assembleUnsignedInt(unsignedInt);
        }

        @Override
        public int extract(int instruction, BitRange bitRange) {
            return bitRange.extractUnsignedInt(instruction);
        }

        @Override
        public AppendableSequence<Integer> legalTestArgumentValues(int min, int max, int grain) {
            assert min == 0;
            assert grain > 0;
            assert max >= grain;
            final AppendableSequence<Integer> result = smallContiguousRange(min, max, grain);
            return result == null ? new ArrayListSequence<Integer>(new Integer[] {0, grain, max - grain, max }) : result;
        }
    },

    SIGNED {

        @Override
        public int minArgumentValue(BitRange bitRange) {
            return -1 << (bitRange.width() - 1);
        }

        @Override
        public int maxArgumentValue(BitRange bitRange) {
            return bitRange.valueMask() >>> 1;
        }

        @Override
        public int assemble(int signedInt, BitRange bitRange) throws IndexOutOfBoundsException {
            return bitRange.assembleSignedInt(signedInt);
        }

        @Override
        public int extract(int instruction, BitRange bitRange) {
            return bitRange.extractSignedInt(instruction);
        }

        @Override
        public AppendableSequence<Integer> legalTestArgumentValues(int min, int max, int grain) {
            assert min < 0;
            assert grain > 0;
            assert max >= grain;
            final AppendableSequence<Integer> result = smallContiguousRange(min, max, grain);
            return result == null ? new ArrayListSequence<Integer>(new Integer[] {min, min + grain, -grain, 0, grain, max - grain, max }) : null;
        }
    },

    SIGNED_OR_UNSIGNED {

        @Override
        public int minArgumentValue(BitRange bitRange) {
            return SIGNED.minArgumentValue(bitRange);
        }

        @Override
        public int maxArgumentValue(BitRange bitRange) {
            return UNSIGNED.maxArgumentValue(bitRange);
        }

        @Override
        public int assemble(int value, BitRange bitRange) throws IndexOutOfBoundsException {
            return (value >= 0) ? UNSIGNED.assemble(value, bitRange) : SIGNED.assemble(value, bitRange);
        }

        @Override
        public int extract(int instruction, BitRange bitRange) {
            return UNSIGNED.extract(instruction, bitRange);
        }

        @Override
        public AppendableSequence<Integer> legalTestArgumentValues(int min, int max, int grain) {
            assert min < 0;
            assert grain > 0;
            assert max >= grain;
            final AppendableSequence<Integer> result = smallContiguousRange(min, max, grain);
            return result == null ? new ArrayListSequence<Integer>(new Integer[] {
                // We only test positive arguments, since negative ones would be returned as positive by extract()
                // and that is correct, because there is no way to tell just by the instruction which sign was meant
                0, grain, max / 2, max - grain, max
            }) : null;
        }
    };

    /**
     * Creates a sequence of all the integers inclusive between a given min and max if the
     * sequence contains 32 or less items. Otherwise, this method returns null.
     */
    public static AppendableSequence<Integer> smallContiguousRange(int min, int max, int grain) {
        final long range = (((long) max - (long) min) + 1) / grain;
        if (range > 0 && range <= 32) {
            final AppendableSequence<Integer> result = new ArrayListSequence<Integer>((int) range);
            for (int i = min; i <= max; i += grain * 2) {
                result.append(i);
            }
            return result;
        }
        return null;
    }

    public abstract int minArgumentValue(BitRange bitRange);

    public abstract int maxArgumentValue(BitRange bitRange);

    /**
     * @return instruction
     * @throws IndexOutOfBoundsException
     */
    public abstract int assemble(int value, BitRange bitRange) throws IndexOutOfBoundsException;

    public abstract int extract(int instruction, BitRange bitRange);

    public abstract AppendableSequence<Integer> legalTestArgumentValues(int min, int max, int grain);
}
