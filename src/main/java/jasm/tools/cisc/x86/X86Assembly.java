/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.InstructionSet;
import jasm.tools.Assembly;
import jasm.tools.util.ProgramError;

public abstract class X86Assembly<Template_Type extends X86Template> extends Assembly<Template_Type> {

    public X86Assembly(InstructionSet instructionSet, Class<Template_Type> templateType) {
        super(instructionSet, templateType);
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
        while (i < original.parameters().size()) {
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
