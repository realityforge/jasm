/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=aa916e9d-f2b6-432f-bbf0-596a9046227c*/
package jasm.gen.cisc.x86;

import com.sun.max.program.ProgramError;
import jasm.InstructionSet;
import jasm.gen.Assembly;
import jasm.gen.risc.bitRange.BitRangeOrder;

/**
 * @author Bernd Mathiske
 */
public abstract class X86Assembly<Template_Type extends X86Template> extends Assembly<Template_Type> {

    public X86Assembly(InstructionSet instructionSet, Class<Template_Type> templateType) {
        super(instructionSet, templateType);
    }

    @Override
    public BitRangeOrder bitRangeEndianness() {
        return BitRangeOrder.DESCENDING;
    }

    /**
     * Whether to support 16 bit addressing.
     */
    private static boolean _are16BitAddressesSupported;

    public static boolean are16BitAddressesSupported() {
        return _are16BitAddressesSupported;
    }

    public static void support16BitAddresses() {
        _are16BitAddressesSupported = true;
    }

    /**
     * Whether to support 16 bit addressing.
     */
    private static boolean _are16BitOffsetsSupported;

    public static boolean are16BitOffsetsSupported() {
        return _are16BitOffsetsSupported;
    }

    public static void support16BitOffsets() {
        _are16BitOffsetsSupported = true;
    }

    private static <Template_Type extends X86Template> boolean parametersMatching(Template_Type original, Template_Type candidate, Class argumentType) {
        int i = 0;
        int j = 0;
        while (i < original.parameters().length()) {
            final Class originalType = original.parameters().get(i).type();
            Class candidateType = candidate.parameters().get(j).type();
            if (originalType == argumentType) {
                if (candidateType != byte.class) {
                    return false;
                }
                j++;
                candidateType = candidate.parameters().get(j).type();
            }
            if (originalType != candidateType) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static <Template_Type extends X86Template> Template_Type getModVariantTemplate(Iterable<Template_Type> templates, Template_Type original, Class argumentType) {
        for (Template_Type candidate : templates) {
            if (candidate.opcode1() == original.opcode1() && candidate.opcode2() == original.opcode2() &&
                    candidate.instructionSelectionPrefix() == original.instructionSelectionPrefix() &&
                    candidate.modRMGroupOpcode() == original.modRMGroupOpcode() &&
                    candidate.addressSizeAttribute() == original.addressSizeAttribute() &&
                    candidate.operandSizeAttribute() == original.operandSizeAttribute() &&
                    parametersMatching(original, candidate, argumentType)) {
                return candidate;
            }
        }
        ProgramError.unexpected("could not find mod variant for: " + original);
        return null;
    }

}