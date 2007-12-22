/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.ia32;

import jasm.gen.cisc.x86.X86AssemblerGenerator;
import jasm.gen.cisc.x86.X86TemplateContext;
import jasm.ia32.IA32BaseRegister32;
import jasm.ia32.IA32IndirectRegister16;
import jasm.ia32.IA32IndirectRegister32;
import jasm.util.WordWidth;
import jasm.util.io.IndentWriter;

/**
 * Run this program to generate the IA32RawAssembler and IA32LabelAssembler classes.
 *
 * @author Bernd Mathiske
 */
public class IA32AssemblerGenerator
    extends X86AssemblerGenerator<IA32Template> {

    public IA32AssemblerGenerator() {
        super(IA32Assembly.ASSEMBLY, WordWidth.BITS_32);
    }

    @Override
    protected void printModVariants(IndentWriter stream, IA32Template template) {
        if (template.modCase() != X86TemplateContext.ModCase.MOD_0) {
            return;
        }
        switch (template.rmCase()) {
            case NORMAL: {
                switch (template.addressSizeAttribute()) {
                    case BITS_16:
                        printModVariant(stream, template, IA32IndirectRegister16.BP_INDIRECT);
                        break;
                    default:
                        printModVariant(stream, template, IA32IndirectRegister32.EBP_INDIRECT);
                        break;
                }
                break;
            }
            case SIB: {
                switch (template.sibBaseCase()) {
                    case GENERAL_REGISTER:
                        printModVariant(stream, template, IA32BaseRegister32.EBP_BASE);
                        break;
                    default:
                        break;
                }
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    protected void printSibVariants(IndentWriter stream, IA32Template template) {
        if (template.modCase() != null && template.modCase() != X86TemplateContext.ModCase.MOD_3 &&
                                          template.rmCase() == X86TemplateContext.RMCase.NORMAL &&
                                          template.addressSizeAttribute() == WordWidth.BITS_32) {
            printSibVariant(stream, template, IA32IndirectRegister32.ESP_INDIRECT);
        }
    }
}
