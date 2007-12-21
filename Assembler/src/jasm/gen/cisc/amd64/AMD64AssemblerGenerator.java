/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.amd64;

import jasm.util.io.IndentWriter;
import jasm.util.program.ProgramError;
import jasm.amd64.AMD64BaseRegister32;
import jasm.amd64.AMD64BaseRegister64;
import jasm.amd64.AMD64GeneralRegister8;
import jasm.amd64.AMD64IndirectRegister32;
import jasm.amd64.AMD64IndirectRegister64;
import jasm.gen.cisc.x86.X86AssemblerGenerator;
import jasm.gen.cisc.x86.X86Field;
import jasm.gen.cisc.x86.X86Opcode;
import jasm.gen.cisc.x86.X86Parameter;
import jasm.gen.cisc.x86.X86Template;
import jasm.gen.cisc.x86.X86TemplateContext;
import jasm.util.WordWidth;
import jasm.util.HexUtil;

/**
 * Run this program to generate the AMD64RawAssembler and AMD64LabelAssembler classes.
 *
 * @author Bernd Mathiske
 */
public class AMD64AssemblerGenerator extends X86AssemblerGenerator<AMD64Template> {

    public AMD64AssemblerGenerator() {
        super(AMD64Assembly.ASSEMBLY, WordWidth.BITS_64);
    }

    private static final String REX_BYTE_NAME = "rex";

    private String basicRexValue(X86Template template) {
        if (template.operandSizeAttribute() == WordWidth.BITS_64 && template.instructionDescription().defaultOperandSize() != WordWidth.BITS_64) {
            return HexUtil.toHexLiteral((byte) (X86Opcode.REX_MIN.ordinal() + (1 << X86Field.REX_W_BIT_INDEX)));
        }
        return HexUtil.toHexLiteral((byte) X86Opcode.REX_MIN.ordinal());
    }

    private void printUnconditionalRexBit(IndentWriter writer, X86Parameter parameter, int bitIndex) {
        writer.print(REX_BYTE_NAME + " |= (" + parameter.valueString() + " & 8) >> " + (3 - bitIndex) + ";");
        writer.println(" // " + parameter.place().comment());
    }

    private void checkGeneralRegister8Values(IndentWriter writer, X86Template template) {
        for (X86Parameter parameter : template.parameters()) {
            if (parameter.type() == AMD64GeneralRegister8.class) {
                writer.println("if (" + parameter.variableName() + ".isHighByte()) {");
                writer.indent();
                writer.println("throw new IllegalArgumentException(\"Cannot encode \" + " + parameter.variableName() + ".name() + \" in the presence of a REX prefix\");");
                writer.outdent();
                writer.println("}");
            }
        }
    }

    private void printUnconditionalRexPrefix(IndentWriter writer, X86Template template) {
        writer.println("byte " + REX_BYTE_NAME + " = (byte) " + basicRexValue(template) + ";");
        for (X86Parameter parameter : template.parameters()) {
            switch (parameter.place()) {
                case MOD_REG_REXR:
                    printUnconditionalRexBit(writer, parameter, X86Field.REX_R_BIT_INDEX);
                    break;
                case MOD_RM_REXB:
                case SIB_BASE_REXB:
                case OPCODE1_REXB:
                case OPCODE2_REXB:
                    printUnconditionalRexBit(writer, parameter, X86Field.REX_B_BIT_INDEX);
                    break;
                case SIB_INDEX_REXX:
                    printUnconditionalRexBit(writer, parameter, X86Field.REX_X_BIT_INDEX);
                    break;
                default:
                    break;
            }
        }
        checkGeneralRegister8Values(writer, template);
        emitByte(writer, REX_BYTE_NAME);
        writer.println();
    }

    private void printConditionalRexBit(IndentWriter writer, X86Template template, X86Parameter parameter, int bitIndex) {
        if (parameter.type() == AMD64GeneralRegister8.class) {
            writer.println("if (" + parameter.variableName() + ".requiresRexPrefix()) {");
            writer.indent();
            writer.println(REX_BYTE_NAME + " |= " + basicRexValue(template) + ";");
            writer.println("if (" + parameter.valueString() + " >= 8) {");
            writer.indent();
            writer.println(REX_BYTE_NAME + " |= 1 << " + bitIndex + "; // " + parameter.place().comment());
            writer.outdent();
            writer.println("}");
            writer.outdent();
            writer.println("}");
        } else {
            writer.println("if (" + parameter.valueString() + " >= 8) {");
            writer.indent();
            writer.println(REX_BYTE_NAME + " |= (1 << " + bitIndex + ") + " + basicRexValue(template) + "; // " + parameter.place().comment());
            writer.outdent();
            writer.println("}");
        }
    }

    private void printConditionalRexPrefix(IndentWriter writer, X86Template template) {
        writer.println("byte " + REX_BYTE_NAME + " = (byte) 0;");
        for (X86Parameter parameter : template.parameters()) {
            switch (parameter.place()) {
                case MOD_REG_REXR:
                    printConditionalRexBit(writer, template, parameter, X86Field.REX_R_BIT_INDEX);
                    break;
                case MOD_RM_REXB:
                case SIB_BASE_REXB:
                case OPCODE1_REXB:
                case OPCODE2_REXB:
                    printConditionalRexBit(writer, template, parameter, X86Field.REX_B_BIT_INDEX);
                    break;
                case SIB_INDEX_REXX:
                    printConditionalRexBit(writer, template, parameter, X86Field.REX_X_BIT_INDEX);
                    break;
                default:
                    break;
            }
        }
        writer.println("if (" + REX_BYTE_NAME + " != (byte) 0) {");
        writer.indent();
        checkGeneralRegister8Values(writer, template);
        emitByte(writer, REX_BYTE_NAME);
        writer.println();
        writer.outdent();
        writer.println("}");
    }

    @Override
    protected void printPrefixes(IndentWriter writer, AMD64Template template) {
        super.printPrefixes(writer, template);
        if (template.operandSizeAttribute() == WordWidth.BITS_64 && template.instructionDescription().defaultOperandSize() != WordWidth.BITS_64) {
            printUnconditionalRexPrefix(writer, template);
        } else {
            for (X86Parameter parameter : template.parameters()) {
                switch (parameter.place()) {
                    case MOD_REG_REXR:
                    case MOD_RM_REXB:
                    case SIB_BASE_REXB:
                    case SIB_INDEX_REXX:
                    case OPCODE1_REXB:
                    case OPCODE2_REXB:
                        printConditionalRexPrefix(writer, template);
                        return;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    protected void printModVariants(IndentWriter writer, AMD64Template template) {
        if (template.modCase() != X86TemplateContext.ModCase.MOD_0 || template.parameters().length() == 0) {
            return;
        }
        switch (template.rmCase()) {
            case NORMAL: {
                switch (template.addressSizeAttribute()) {
                    case BITS_32:
                        printModVariant(writer, template, AMD64IndirectRegister32.EBP_INDIRECT);
                        break;
                    case BITS_64:
                        printModVariant(writer, template, AMD64IndirectRegister64.RBP_INDIRECT, AMD64IndirectRegister64.R13_INDIRECT);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case SIB: {
                switch (template.sibBaseCase()) {
                    case GENERAL_REGISTER:
                        switch (template.addressSizeAttribute()) {
                            case BITS_32:
                                printModVariant(writer, template, AMD64BaseRegister32.EBP_BASE);
                                break;
                            case BITS_64:
                                printModVariant(writer, template, AMD64BaseRegister64.RBP_BASE, AMD64BaseRegister64.R13_BASE);
                                break;
                            default:
                                ProgramError.unexpected();
                                break;
                        }
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
    protected void printSibVariants(IndentWriter writer, AMD64Template template) {
        if (template.parameters().length() == 0 ||
                        template.modCase() == null || template.modCase() == X86TemplateContext.ModCase.MOD_3 ||
                template.rmCase() != X86TemplateContext.RMCase.NORMAL) {
            return;
        }
        switch (template.modCase()) {
            case MOD_0:
            case MOD_1:
            case MOD_2: {
                switch (template.addressSizeAttribute()) {
                    case BITS_32:
                        printSibVariant(writer, template, AMD64IndirectRegister32.ESP_INDIRECT);
                        break;
                    case BITS_64:
                        printSibVariant(writer, template, AMD64IndirectRegister64.RSP_INDIRECT, AMD64IndirectRegister64.R12_INDIRECT);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            default: {
                break;
            }
        }
    }
}
