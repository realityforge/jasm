/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.amd64;

import jasm.Assembler;
import jasm.WordWidth;
import jasm.amd64.AMD64BaseRegister32;
import jasm.amd64.AMD64BaseRegister64;
import jasm.amd64.AMD64GeneralRegister8;
import jasm.amd64.AMD64IndirectRegister32;
import jasm.amd64.AMD64IndirectRegister64;
import jasm.amd64.as.AbstractAMD64Assembler;
import jasm.tools.cisc.x86.ModCase;
import jasm.tools.cisc.x86.RMCase;
import jasm.tools.cisc.x86.X86AssemblerGenerator;
import jasm.tools.cisc.x86.X86Parameter;
import jasm.tools.cisc.x86.X86Template;
import jasm.tools.util.IndentWriter;

/** Run this program to generate the AMD64RawAssembler and AMD64LabelAssembler classes. */
public final class AMD64AssemblerGenerator
    extends X86AssemblerGenerator<AMD64Template> {

  public AMD64AssemblerGenerator() {
    super(AMD64Assembly.ASSEMBLY, WordWidth.BITS_64);
  }

  @Override
  protected final Class<? extends Assembler> parentAssemblerClass() {
    return AbstractAMD64Assembler.class;
  }

  private boolean isWBitRequired(final X86Template template) {
    return template.operandSizeAttribute() == WordWidth.BITS_64 &&
           template.instructionDescription().defaultOperandSize() != WordWidth.BITS_64;
  }

  private void checkGeneralRegister8Values(IndentWriter writer, AMD64Template template) {
    for (X86Parameter p : template.parameters()) {
      if (p.type() == AMD64GeneralRegister8.class) {
        writer.println("if (Config.ENABLE_CONSTRAINT_CHECKS) checkRexCompatibility(" + p.variableName() + ");");
      }
    }
  }

  private boolean needsToAddConstraintsFoGeneralRegister8Values(AMD64Template template) {
    for (X86Parameter parameter : template.parameters()) {
      if (parameter.type() == AMD64GeneralRegister8.class) {
        return true;
      }
    }
    return false;
  }

  private void printUnconditionalRexPrefix(IndentWriter writer, AMD64Template template) {
    String rBit = "false";
    String bBit = "false";
    String xBit = "false";

    for (X86Parameter parameter : template.parameters()) {
      switch (parameter.place()) {
        case MOD_REG_REXR:
          rBit = "(" + asValueInSubroutine(parameter) + " & 8) != 0";
          break;
        case MOD_RM_REXB:
        case SIB_BASE_REXB:
        case OPCODE1_REXB:
        case OPCODE2_REXB:
          bBit = "(" + asValueInSubroutine(parameter) + " & 8) != 0";
          break;
        case SIB_INDEX_REXX:
          xBit = "(" + asValueInSubroutine(parameter) + " & 8) != 0";
          break;
        default:
          break;
      }
    }
    checkGeneralRegister8Values(writer, template);
    writer.println("emitRexPrefix(false, true, " + rBit + "," + bBit + "," + xBit + ");");
  }

  private String genForceCheck(final X86Parameter parameter) {
    if (parameter.type() == AMD64GeneralRegister8.class) {
      return "if (" + parameter.variableName() + ".requiresRexPrefix()) force = true;";
    }
    return "";
  }

  private void printConditionalRexPrefix(IndentWriter writer, AMD64Template template) {
    String rBit = null;
    String bBit = null;
    String xBit = null;

    String force = "";
    for (X86Parameter parameter : template.parameters()) {
      switch (parameter.place()) {
        case MOD_REG_REXR:
          force += genForceCheck(parameter);
          rBit = "(" + asValueInSubroutine(parameter) + " >= 8)";
          break;
        case MOD_RM_REXB:
        case SIB_BASE_REXB:
        case OPCODE1_REXB:
        case OPCODE2_REXB:
          force += genForceCheck(parameter);
          bBit = "(" + asValueInSubroutine(parameter) + " >= 8)";
          break;
        case SIB_INDEX_REXX:
          force += genForceCheck(parameter);
          xBit = "(" + asValueInSubroutine(parameter) + " >= 8)";
          break;
        default:
          break;
      }
    }

    final boolean maybeForce = force.length() > 0;
    if (maybeForce) {
      writer.println("boolean force = false;");
      writer.println(force);
    }

    if (needsToAddConstraintsFoGeneralRegister8Values(template) &&
        (maybeForce || null != rBit || null != bBit || null != xBit)) {
      String separator = "";
      writer.print("if (");
      if (maybeForce) {
        writer.print("force");
        separator = " || ";
      }
      if (null != rBit) {
        writer.print(separator + rBit);
        separator = " || ";
      }
      if (null != bBit) {
        writer.print(separator + bBit);
        separator = " || ";
      }
      if (null != xBit) { writer.print(separator + xBit); }

      writer.println(") {");
      writer.indent();
      checkGeneralRegister8Values(writer, template);
      writer.println();
      writer.outdent();
      writer.println("}");
    }

    final String forceString = maybeForce ? "force" : "false";
    if (null == rBit) rBit = "false";
    if (null == rBit) rBit = "false";
    if (null == bBit) bBit = "false";
    if (null == xBit) xBit = "false";
    writer.println("emitRexPrefix(" + forceString + ",false," + rBit + "," + bBit + "," + xBit + ");");
  }

  @Override
  protected final void printPrefixes(IndentWriter writer, AMD64Template template) {
    super.printPrefixes(writer, template);
    if (isWBitRequired(template)) {
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
  protected final void printModVariants(IndentWriter writer, AMD64Template template) {
    if (template.modCase() != ModCase.MOD_0 || template.parameters().size() == 0) {
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
            throw new IllegalStateException();
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
                throw new IllegalStateException();
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
  protected final void printSibVariants(IndentWriter writer, AMD64Template template) {
    if (template.parameters().size() == 0 ||
        template.modCase() == null || template.modCase() == ModCase.MOD_3 ||
        template.rmCase() != RMCase.NORMAL) {
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
            throw new IllegalStateException();
        }
        break;
      }
      default: {
        break;
      }
    }
  }
}
