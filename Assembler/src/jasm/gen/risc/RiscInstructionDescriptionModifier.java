/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7f204dde-a229-4abc-bb03-9eaf09601f8c*/
package jasm.gen.risc;

import com.sun.max.collect.MutableSequence;
import com.sun.max.collect.Sequence;

/**
 * This class provides a mechanism for making modifications to a set of RISC instruction descriptions.
 *
 * @author Bernd Mathiske
 */
public class RiscInstructionDescriptionModifier {

    private final Sequence<RiscInstructionDescription> _instructionDescriptions;

    public RiscInstructionDescriptionModifier(Sequence<RiscInstructionDescription> instructionDescriptions) {
        _instructionDescriptions = instructionDescriptions;
    }

    /**
     * Replaces a specification in the set of instruction descriptions.
     *
     * @param before  the specification to be replaced (matched with {@link Object#equals})
     * @param after   the replacement value
     */
    public RiscInstructionDescriptionModifier replace(Object before, Object after) {
        for (RiscInstructionDescription instructionDescription : _instructionDescriptions) {
            final MutableSequence<Object> specifications = instructionDescription.specifications();
            for (int i = 0; i < specifications.length(); i++) {
                if (specifications.get(i).equals(before)) {
                    specifications.set(i, after);
                }
            }
        }
        return this;
    }


    public RiscInstructionDescriptionModifier swap(Object a, Object b) {
        for (RiscInstructionDescription instructionDescription : _instructionDescriptions) {
            final MutableSequence<Object> specifications = instructionDescription.specifications();
            final int aIndex = Sequence.Static.indexOfIdentical(specifications, a);
            final int bIndex = Sequence.Static.indexOfIdentical(specifications, b);
            if (aIndex != -1 && bIndex != -1) {
                specifications.set(aIndex, b);
                specifications.set(bIndex, a);
            }
        }
        return this;
    }

    public RiscInstructionDescriptionModifier setExternalName(String externalName) {
        for (RiscInstructionDescription instructionDescription : _instructionDescriptions) {
            instructionDescription.setExternalName(externalName);
        }
        return this;
    }
}