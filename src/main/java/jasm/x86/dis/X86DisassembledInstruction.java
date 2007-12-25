/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.x86.dis;

import jasm.Argument;
import jasm.WordWidth;
import jasm.dis.DisassembledInstruction;
import jasm.dis.DisassembledLabel;
import jasm.dis.GlobalLabelMapper;
import jasm.tools.ImmediateArgument;
import jasm.tools.ImplicitOperand;
import jasm.tools.cisc.x86.ParameterPlace;
import jasm.tools.cisc.x86.X86AddressParameter;
import jasm.tools.cisc.x86.X86DisplacementParameter;
import jasm.tools.cisc.x86.X86ImmediateParameter;
import jasm.tools.cisc.x86.X86OffsetParameter;
import jasm.tools.cisc.x86.X86Operand;
import jasm.tools.cisc.x86.X86Parameter;
import jasm.tools.cisc.x86.X86Template;
import jasm.tools.cisc.x86.X86TemplateContext;
import jasm.util.StringUtil;
import jasm.x86.IndirectRegister;
import jasm.x86.Scale;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * An x86 instruction, given as an x86 template and a sequence of arguments.
 * <p/>
 * The string representation for disassembler output has the following format,
 * which borrows from both Intel and AT&T syntax and differs from either
 * regarding indirect addressing and indexing.
 * <p/>
 * Operand order follows Intel syntax:
 * <p/>
 * mnemonic argument
 * mnemonic destination, source
 * mnemonic argument1, argument2, argument3
 * <p/>
 * Some mnemonics may have operand size suffixes as in AT&T (gas) syntax.
 * Suffix    Intel size     Java size    # bits
 * ------    -----------    ---------    ------
 * b         byte           byte          8
 * w         word           short        16
 * l         long word      int          32
 * q         quad word      long         64
 * <p/>
 * Using this AT&T syntax feature, there is no need for operand size indicators
 * (e.g. DWORD PTR) for pointers as in Intel syntax.
 * <p/>
 * Registers etc. are named as in Intel syntax,
 * in lower case without AT&T's "%" prefix.
 * <p/>
 * Indexing is indicated by '[' and ']', similiar to array access in the Java(TM) Programming Language:
 * <p/>
 * base[index], e.g. eax[ebx]
 * <p/>
 * Indirect access looks like indexing without a base (or with implicit base 0):
 * <p/>
 * [indirect], e.g. [ecx]
 * <p/>
 * Displacements are added/subtracted from the index/indirect operand:
 * <p/>
 * base[index + displacement], e.g. ebp[eax - 12]
 * [indirect + displacement], e.g. [esi + 100]
 * <p/>
 * Scale is displayed as multiplication of the index:
 * <p/>
 * [base[index * scale] or base[index * scale + displacement], e.g. ecx[ebx * 4 + 10]
 * <p/>
 * A scale of 1 is left implicit, i.e. not printed.
 * Scale literals are the unsigned decimal integer numbers 2, 4, 8.
 * <p/>
 * Displacement literals are signed decimal integer numbers.
 * <p/>
 * Direct memory references (pointer literals) are unsigned hexadecimal integer numbers, e.g.:
 * <p/>
 * [0x12345678], 0x12345678[eax]
 * <p/>
 * Immediate operands are unsigned hexadecimal integer numbers, e.g.:
 * <p/>
 * 0x12, 0xffff, 0x0, 0x123456789abcdef
 * <p/>
 * Offset operands are signed decimal integer numbers, like displacements, but without space between the sign and the number, e.g.:
 * <p/>
 * jmp +12
 * call -2048
 * <p/>
 * RIP (Relative to Instruction Pointer) addressing is a combination of an offset operand and indirect addressing, e.g.:
 * <p/>
 * add [+20], eax
 * mov ebx, [-200]
 * <p/>
 * The disassembler displays synthetic labels for all target addresses
 * within the disassembled address range that hit the start address of an instruction.
 * Operands that coincide with such a label are displayed with the respective Label prepended. e.g.:
 * <p/>
 * jmp L1: +100
 * adc [L2: +128], ESI
 */
public abstract class X86DisassembledInstruction<Template_Type extends X86Template> extends DisassembledInstruction<Template_Type> {

  protected X86DisassembledInstruction(int offset, byte[] bytes, Template_Type template, List<Argument> arguments) {
    super(offset, bytes, template, arguments);
  }

  private String getSibIndexAndScale(Queue<X86Operand> operands, Queue<Argument> arguments) {
    X86Parameter parameter = (X86Parameter) operands.remove();
    assert parameter.place() == ParameterPlace.SIB_INDEX || parameter.place() == ParameterPlace.SIB_INDEX_REXX;
    final String result = arguments.remove().disassembledValue();
    parameter = (X86Parameter) operands.remove();
    assert parameter.place() == ParameterPlace.SIB_SCALE;
    final Scale scale = (Scale) arguments.remove();
    if (scale == Scale.SCALE_1) {
      return result;
    }
    return result + " * " + scale.disassembledValue();
  }

  private String addition(Argument argument, String space) {
    assert argument instanceof ImmediateArgument;
    final long value = argument.asLong();
    final String s = Long.toString(value);
    if (value >= 0) {
      return "+" + space + s;
    }
    return "-" + space + s.substring(1);
  }

  private String getOperand(Queue<X86Operand> operands, Queue<Argument> arguments, List<DisassembledLabel> labels) {
    final X86Operand operand = operands.remove();
    if (operand instanceof ImplicitOperand) {
      final ImplicitOperand implicitOperand = (ImplicitOperand) operand;
      return implicitOperand.argument().disassembledValue();
    }
    final X86Parameter parameter = (X86Parameter) operand;
    final Argument argument = arguments.remove();
    if (parameter instanceof X86DisplacementParameter) {
      assert parameter.place() == ParameterPlace.APPEND;
      final X86Parameter nextParameter = (X86Parameter) operands.element();
      String prefix = "";
      if (IndirectRegister.class.isAssignableFrom(nextParameter.type())) {
        operands.remove();
        prefix += "[" + arguments.remove().disassembledValue();
      } else {
        if (nextParameter.place() == ParameterPlace.SIB_BASE || nextParameter.place() == ParameterPlace.SIB_BASE_REXB) {
          operands.remove();
          prefix += arguments.remove().disassembledValue();
        }
        prefix += "[" + getSibIndexAndScale(operands, arguments);
      }
      return prefix + " " + addition(argument, " ") + "]";
    }
    if (parameter.place() == ParameterPlace.SIB_BASE || parameter.place() == ParameterPlace.SIB_BASE_REXB) {
      return argument.disassembledValue() + "[" + getSibIndexAndScale(operands, arguments) + "]";
    }
    if (IndirectRegister.class.isAssignableFrom(parameter.type())) {
      return "[" + argument.disassembledValue() + "]";
    }
    if (parameter instanceof X86AddressParameter) {
      String address = argument.disassembledValue();
      final DisassembledLabel label = addressArgumentToLabel((ImmediateArgument) argument, labels);
      if (label != null) {
        address = label.name() + ": " + address;
      }
      final X86Operand nextOperand = operands.peek();
      if (nextOperand instanceof X86Parameter) {
        final X86Parameter nextParameter = (X86Parameter) nextOperand;
        if (nextParameter.place() == ParameterPlace.SIB_INDEX || nextParameter.place() == ParameterPlace.SIB_INDEX_REXX) {
          return address + "[" + getSibIndexAndScale(operands, arguments) + "]";
        }
      }
      return "[" + address + "]";
    }
    if (parameter instanceof X86OffsetParameter) {
      String offset = addition(argument, "");
      final DisassembledLabel label = offsetArgumentToLabel((ImmediateArgument) argument, labels);
      if (label != null) {
        offset = label.name() + ": " + offset;
      }
      if (template().addressSizeAttribute() == WordWidth.BITS_64 && template().rmCase() == X86TemplateContext.RMCase.SDWORD) {
        return "[" + offset + "]"; // RIP
      }
      return offset;
    }
    if (parameter.getClass() == X86ImmediateParameter.class) {
      return argument.disassembledValue();
    }
    return argument.disassembledValue();
  }

  @Override
  public final String externalName() {
    return template().externalName();
  }

  @Override
  public final String operandsToString(List<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
    final LinkedList<X86Operand> operandQueue = new LinkedList<X86Operand>(template().operands());
    final LinkedList<Argument> argumentQueue = new LinkedList<Argument>(arguments());
    String result = "";
    String separator = "";
    while (!operandQueue.isEmpty()) {
      result += separator + getOperand(operandQueue, argumentQueue, labels);
      separator = ", ";
    }
    return result;
  }

  @Override
  public final String toString(List<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
    String s = operandsToString(labels, globalLabelMapper);
    if (s.length() > 0) {
      s = "  " + s;
    }
    return StringUtil.padLengthWithSpaces(externalName(), 8) + s;
  }

  @Override
  public final int offsetForRelativeAddressing() {
    return startOffset() + bytes().length;
  }
}
