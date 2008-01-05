/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.amd64;

import jasm.Argument;
import jasm.WordWidth;
import jasm.amd64.AMD64BaseRegister32;
import jasm.amd64.AMD64BaseRegister64;
import jasm.amd64.AMD64GeneralRegister16;
import jasm.amd64.AMD64GeneralRegister32;
import jasm.amd64.AMD64GeneralRegister64;
import jasm.amd64.AMD64GeneralRegister8;
import jasm.amd64.AMD64IndexRegister32;
import jasm.amd64.AMD64IndexRegister64;
import jasm.amd64.AMD64IndirectRegister32;
import jasm.amd64.AMD64IndirectRegister64;
import jasm.amd64.AMD64XMMComparison;
import jasm.amd64.AMD64XMMRegister;
import jasm.tools.ArgumentRange;
import jasm.tools.ExternalPresence;
import jasm.tools.TestArgumentExclusion;
import jasm.tools.cisc.TemplateNotNeededException;
import jasm.tools.cisc.x86.Designation;
import jasm.tools.cisc.x86.ModCase;
import jasm.tools.cisc.x86.OperandCode;
import jasm.tools.cisc.x86.ParameterPlace;
import jasm.tools.cisc.x86.X86AddressParameter;
import jasm.tools.cisc.x86.X86DisplacementParameter;
import jasm.tools.cisc.x86.X86EnumerableParameter;
import jasm.tools.cisc.x86.X86ImmediateParameter;
import jasm.tools.cisc.x86.X86ImplicitOperand;
import jasm.tools.cisc.x86.X86InstructionDescription;
import jasm.tools.cisc.x86.X86OffsetParameter;
import jasm.tools.cisc.x86.X86RegisterOperandCode;
import jasm.tools.cisc.x86.X86Template;
import jasm.tools.cisc.x86.X86TemplateContext;
import jasm.x86.ControlRegister;
import jasm.x86.DebugRegister;
import jasm.x86.GeneralRegister;
import jasm.x86.MMXRegister;
import jasm.x86.Scale;
import jasm.x86.SegmentRegister;
import java.util.List;

public final class AMD64Template
    extends X86Template<AMD64Template> {

  AMD64Template(X86InstructionDescription instructionDescription,
                int serial,
                X86TemplateContext context) {
    super(instructionDescription, serial, context);
  }

  private void addSib(Designation designation) throws TemplateNotNeededException {
    assert context().addressSizeAttribute() != WordWidth.BITS_16;
    switch (context().sibBaseCase()) {
      case GENERAL_REGISTER: {
        switch (context().addressSizeAttribute()) {
          case BITS_32:
            setExternalCodeSizeAttribute(context().addressSizeAttribute());
            addEnumerableParameter(designation, ParameterPlace.SIB_BASE, AMD64BaseRegister32.SYMBOLS);
            break;
          case BITS_64:
            addEnumerableParameter(designation, ParameterPlace.SIB_BASE_REXB, AMD64BaseRegister64.SYMBOLS);
            break;
          default:
            throw new IllegalStateException();
        }
        break;
      }
      case SPECIAL: {
        switch (context().modCase()) {
          case MOD_0: {
            setExternalCodeSizeAttribute(context().addressSizeAttribute());
            addOperand(new X86AddressParameter(designation, WordWidth.BITS_32));
            break;
          }
          default: {
            throw new IllegalStateException("no special SIB base for mod != 0");
          }
        }
        break;
      }
    }
    switch (context().sibIndexCase()) {
      case GENERAL_REGISTER:
        switch (context().addressSizeAttribute()) {
          case BITS_32:
            setExternalCodeSizeAttribute(context().addressSizeAttribute());
            addEnumerableParameter(designation, ParameterPlace.SIB_INDEX, AMD64IndexRegister32.SYMBOLS);
            break;
          case BITS_64:
            addEnumerableParameter(designation, ParameterPlace.SIB_INDEX_REXX, AMD64IndexRegister64.SYMBOLS);
            break;
          default:
            throw new IllegalStateException();
        }
        break;
      case NONE:
        // Our external assembler (gas) cannot generate these cases and they seem redundant anyway,
        // so for now we do not produce them:
        throw new TemplateNotNeededException();
    }
    addOperand(new X86EnumerableParameter<Scale>(designation, ParameterPlace.SIB_SCALE, Scale.SYMBOLS));
  }

  @Override
  protected final void organize_M(Designation designation) throws TemplateNotNeededException {
    switch (context().modCase()) {
      case MOD_0: {
        switch (context().rmCase()) {
          case NORMAL:
            switch (context().addressSizeAttribute()) {
              case BITS_32:
                setExternalCodeSizeAttribute(context().addressSizeAttribute());
                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister32.SYMBOLS);
                break;
              case BITS_64:
                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister64.SYMBOLS);
                break;
              default:
                throw new IllegalStateException();
            }
            break;
          case SWORD:
            switch (context().addressSizeAttribute()) {
              case BITS_16:
                addOperand(new X86AddressParameter(designation, WordWidth.BITS_16));
                break;
              default:
                throw new TemplateNotNeededException();
            }
            break;
          case SDWORD:
            switch (context().addressSizeAttribute()) {
              case BITS_64:
                useNamePrefix("rip_");
                setLabelParameterIndex();
                addOperand(new X86OffsetParameter(designation, WordWidth.BITS_32));
                break;
              case BITS_32:
                setExternalCodeSizeAttribute(context().addressSizeAttribute());
                addOperand(new X86AddressParameter(designation, WordWidth.BITS_32));
                break;
              default:
                throw new TemplateNotNeededException();
            }
            break;
          case SIB:
            addSib(designation);
            break;
        }
        break;
      }
      case MOD_1: {
        addOperand(new X86DisplacementParameter(designation, WordWidth.BITS_8));
        switch (context().rmCase()) {
          case NORMAL:
            switch (context().addressSizeAttribute()) {
              case BITS_32:
                setExternalCodeSizeAttribute(context().addressSizeAttribute());
                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister32.SYMBOLS);
                break;
              case BITS_64:
                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister64.SYMBOLS);
                break;
              default:
                throw new IllegalStateException();
            }
            break;
          case SIB:
            addSib(designation);
            break;
          default:
            throw new TemplateNotNeededException();
        }
        break;
      }
      case MOD_2: {
        switch (context().addressSizeAttribute()) {
          case BITS_16:
            addOperand(new X86DisplacementParameter(designation, WordWidth.BITS_16));
            break;
          case BITS_32:
          case BITS_64:
            addOperand(new X86DisplacementParameter(designation, WordWidth.BITS_32));
            break;
          default:
            throw new IllegalStateException();
        }
        switch (context().rmCase()) {
          case NORMAL:
            switch (context().addressSizeAttribute()) {
              case BITS_32:
                setExternalCodeSizeAttribute(context().addressSizeAttribute());
                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister32.SYMBOLS);
                break;
              case BITS_64:
                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister64.SYMBOLS);
                break;
              default:
                throw new IllegalStateException();
            }
            break;
          case SIB:
            addSib(designation);
            break;
          default:
            throw new TemplateNotNeededException();
        }
        break;
      }
      case MOD_3: {
        throw new TemplateNotNeededException();
      }
    }
  }

  public final void visitOperandCode(OperandCode operandCode, Designation designation, ArgumentRange argumentRange, TestArgumentExclusion testArgumentExclusion)
      throws TemplateNotNeededException {
    switch (operandCode) {
      case Cq: {
        addOperand(new X86EnumerableParameter<ControlRegister>(designation, ParameterPlace.MOD_REG, ControlRegister.SYMBOLS));
        break;
      }
      case Dq: {
        addOperand(new X86EnumerableParameter<DebugRegister>(designation, ParameterPlace.MOD_REG, DebugRegister.SYMBOLS));
        break;
      }
      case Eb: {
        organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister8.SYMBOLS, testArgumentExclusion);
        break;
      }
      case Ed: {
        organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister32.SYMBOLS, testArgumentExclusion);
        break;
      }
      case Ed_q: {
        visitOperandTypeCode(operandCode.operandTypeCode());
        switch (context().operandSizeAttribute()) {
          case BITS_32:
            organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister32.SYMBOLS, testArgumentExclusion);
            break;
          case BITS_64:
            organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister64.SYMBOLS, testArgumentExclusion);
            break;
          default:
            throw new TemplateNotNeededException();
        }
        break;
      }
      case Ev: {
        switch (context().operandSizeAttribute()) {
          case BITS_16:
            organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister16.SYMBOLS, testArgumentExclusion);
            break;
          case BITS_32:
            organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister32.SYMBOLS, testArgumentExclusion);
            break;
          case BITS_64:
            organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister64.SYMBOLS, testArgumentExclusion);
            break;
          default:
            throw new IllegalStateException();
        }
        break;
      }
      case Ew: {
        organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister16.SYMBOLS, testArgumentExclusion);
        break;
      }
      case Fv: {
        break;
      }
      case Gb: {
        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister8.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case Gd: {
        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister32.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case Gd_q: {
        switch (context().operandSizeAttribute()) {
          case BITS_32:
            addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister32.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          case BITS_64:
            addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister64.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          default:
            throw new TemplateNotNeededException();
        }
        break;
      }
      case Gq: {
        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister64.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case Gv: {
        switch (context().operandSizeAttribute()) {
          case BITS_16:
            addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister16.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          case BITS_32:
            addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister32.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          case BITS_64:
            addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister64.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          default:
            throw new IllegalStateException();
        }
        break;
      }
      case Gw: {
        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister16.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case Gz: {
        switch (context().operandSizeAttribute()) {
          case BITS_16:
            addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister16.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          case BITS_32:
          case BITS_64:
            addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister32.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          default:
            throw new IllegalStateException();
        }
        break;
      }
      case Ib: {
        addParameter(new X86ImmediateParameter(designation, WordWidth.BITS_8), argumentRange, testArgumentExclusion);
        break;
      }
      case ICb: {
        addEnumerableParameter(designation, ParameterPlace.APPEND, AMD64XMMComparison.SYMBOLS);
        break;
      }
      case Iv: {
        addParameter(new X86ImmediateParameter(designation, context().operandSizeAttribute()), argumentRange, testArgumentExclusion);
        break;
      }
      case Iw: {
        addParameter(new X86ImmediateParameter(designation, WordWidth.BITS_16), argumentRange, testArgumentExclusion);
        break;
      }
      case Iz: {
        WordWidth operandSizeAttribute = context().operandSizeAttribute();
        if (operandSizeAttribute.greaterThan(WordWidth.BITS_32)) {
          operandSizeAttribute = WordWidth.BITS_32;
        }
        addParameter(new X86ImmediateParameter(designation, operandSizeAttribute), argumentRange, testArgumentExclusion);
        break;
      }
      case Jb: {
        setLabelParameterIndex();
        addOperand(new X86OffsetParameter(designation, WordWidth.BITS_8));
        break;
      }
      case Jv: {
        switch (context().operandSizeAttribute()) {
          case BITS_16:
            setLabelParameterIndex();
            addOperand(new X86OffsetParameter(designation, WordWidth.BITS_16));
            break;
          case BITS_32:
            setLabelParameterIndex();
            addOperand(new X86OffsetParameter(designation, WordWidth.BITS_32));
            break;
          case BITS_64:
            setLabelParameterIndex();
            addOperand(new X86OffsetParameter(designation, WordWidth.BITS_64));
            break;
          default:
            throw new IllegalStateException();
        }
        break;
      }
      case Jz: {
        switch (context().operandSizeAttribute()) {
          case BITS_16:
            setExternalCodeSizeAttribute(context().operandSizeAttribute());
            setLabelParameterIndex();
            addOperand(new X86OffsetParameter(designation, WordWidth.BITS_16));
            break;
          case BITS_32:
          case BITS_64:
            setLabelParameterIndex();
            addOperand(new X86OffsetParameter(designation, WordWidth.BITS_32));
            break;
          default:
            throw new IllegalStateException();
        }
        break;
      }
      case Md_q: {
        if (operandSizeAttribute() == WordWidth.BITS_16) {
          throw new TemplateNotNeededException();
        }
        organize_M(designation);
        break;
      }
      case Mb:
      case Md:
      case Mq:
      case Mdq:
      case Ms:
      case Mv:
      case Mw: {
        organize_M(designation);
        break;
      }
      case Gob: {
        addEnumerableParameter(designation, ParameterPlace.OPCODE1_REXB, AMD64GeneralRegister8.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case God_q: {
        final ParameterPlace place = (description().opcode2() != null) ? ParameterPlace.OPCODE2_REXB : ParameterPlace.OPCODE1_REXB;
        switch (context().operandSizeAttribute()) {
          case BITS_32:
            addEnumerableParameter(designation, place, AMD64GeneralRegister32.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          case BITS_64:
            addEnumerableParameter(designation, place, AMD64GeneralRegister64.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          default:
            throw new TemplateNotNeededException();
        }
        break;
      }
      case Gov:
        final ParameterPlace place = (description().opcode2() != null) ? ParameterPlace.OPCODE2_REXB : ParameterPlace.OPCODE1_REXB;
        switch (context().operandSizeAttribute()) {
          case BITS_16:
            addEnumerableParameter(designation, place, AMD64GeneralRegister16.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          case BITS_32:
            addEnumerableParameter(designation, place, AMD64GeneralRegister32.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          case BITS_64:
            addEnumerableParameter(designation, place, AMD64GeneralRegister64.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          default:
            throw new IllegalStateException();
        }
        break;
      case Ob:
      case Ov: {
        switch (context().addressSizeAttribute()) {
          case BITS_32:
            setExternalCodeSizeAttribute(context().addressSizeAttribute());
            addParameter(new X86AddressParameter(designation, WordWidth.BITS_32), argumentRange);
            break;
          case BITS_64:
            setLabelParameterIndex();
            addParameter(new X86AddressParameter(designation, WordWidth.BITS_64), argumentRange);
            break;
          default:
            throw new IllegalStateException();
        }
        break;
      }
      case Pdq: {
        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64XMMRegister.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case Pq: {
        addEnumerableParameter(designation, ParameterPlace.MOD_REG, MMXRegister.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case PRq: {
        if (context().modCase() != ModCase.MOD_3) {
          throw new TemplateNotNeededException();
        }
        addEnumerableParameter(designation, ParameterPlace.MOD_RM, MMXRegister.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case Qd:
      case Qq: {
        organize_E(designation, ParameterPlace.MOD_RM, MMXRegister.SYMBOLS, testArgumentExclusion);
        break;
      }
      case Rq: {
        if (context().modCase() != ModCase.MOD_3) {
          throw new TemplateNotNeededException();
        }
        addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister64.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case Rv:
        if (context().modCase() != ModCase.MOD_3) {
          throw new TemplateNotNeededException();
        }
        switch (context().operandSizeAttribute()) {
          case BITS_16:
            addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister16.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          case BITS_32:
            addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister32.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          case BITS_64:
            addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister64.SYMBOLS).excludeTestArguments(testArgumentExclusion);
            break;
          default:
            throw new IllegalStateException();
        }
        break;
      case Sw: {
        addEnumerableParameter(designation, ParameterPlace.MOD_REG, SegmentRegister.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case Vpd:
      case Vps:
      case Vq:
      case Vdq:
      case Vsd:
      case Vss: {
        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64XMMRegister.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case Uq:
      case Udq:
      case Upd:
      case Ups: {
        if (context().modCase() != ModCase.MOD_3) {
          throw new TemplateNotNeededException();
        }
        addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64XMMRegister.SYMBOLS).excludeTestArguments(testArgumentExclusion);
        break;
      }
      case Wdq:
      case Wpd:
      case Wps:
      case Wq:
      case Wsd:
      case Wss: {
        switch (context().operandSizeAttribute()) {
          case BITS_32:
          case BITS_64:
            organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64XMMRegister.SYMBOLS, testArgumentExclusion);
            break;
          default:
            throw new TemplateNotNeededException();
        }
        break;
      }
      case Xz:
      case Yz: {
        switch (operandSizeAttribute()) {
          case BITS_16:
            setOperandTypeSuffix("w");
            break;
          case BITS_32:
            setOperandTypeSuffix("l");
            break;
          default:
            throw new TemplateNotNeededException();
        }
        break;
      }
      case Xb:
      case Xv:
      case Yb:
      case Yv: {
        visitOperandTypeCode(operandCode.operandTypeCode());
        break;
      }
      default:
        throw new IllegalStateException("undefined operand code: " + operandCode);
    }
  }

  public final void visitRegisterOperandCode(X86RegisterOperandCode registerOperandCode, Designation designation, ExternalPresence externalPresence) {
    switch (operandSizeAttribute()) {
      case BITS_16:
        addOperand(new X86ImplicitOperand(designation, externalPresence, AMD64GeneralRegister16.values()[registerOperandCode.regField()]));
        break;
      case BITS_32:
        addOperand(new X86ImplicitOperand(designation, externalPresence, AMD64GeneralRegister32.values()[registerOperandCode.regField()]));
        break;
      case BITS_64:
        addOperand(new X86ImplicitOperand(designation, externalPresence, AMD64GeneralRegister64.values()[registerOperandCode.regField()]));
        break;
      default:
        throw new IllegalStateException();
    }
  }

  public final boolean hasRexPrefix(List<Argument> arguments) {
    if (description().defaultOperandSize() == WordWidth.BITS_64) {
      return false;
    }
    if (operandSizeAttribute() == WordWidth.BITS_64) {
      return true;
    }
    for (Argument argument : arguments) {
      if (argument instanceof GeneralRegister) {
        if (argument instanceof AMD64GeneralRegister8) {
          final AMD64GeneralRegister8 generalRegister8 = (AMD64GeneralRegister8) argument;
          if (generalRegister8.requiresRexPrefix()) {
            return true;
          }
        } else {
          final GeneralRegister generalRegister = (GeneralRegister) argument;
          if (generalRegister.value() >= 8) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
