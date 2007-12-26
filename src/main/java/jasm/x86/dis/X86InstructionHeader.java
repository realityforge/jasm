/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.x86.dis;

import jasm.WordWidth;
import jasm.tools.Assembly;
import jasm.tools.cisc.x86.X86InstructionPrefix;
import jasm.tools.cisc.x86.X86Parameter;
import jasm.tools.cisc.x86.X86Template;
import jasm.util.HexByte;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Info about the first few bytes of an x86 instruction,
 * narrowing the set of possible instructions to probe by the disassembler.
 */
public final class X86InstructionHeader {

  boolean _hasAddressSizePrefix;
  HexByte _rexPrefix;
  X86InstructionPrefix _instructionSelectionPrefix;
  HexByte _opcode1;
  HexByte _opcode2;

  X86InstructionHeader() {
  }

  @Override
  public String toString() {
    return "X86InstructionHeader[AddressPrefix=" + _hasAddressSizePrefix +
           ",rexPrefix=" + _rexPrefix +
           ",instructionSelectionPrefix=" + _instructionSelectionPrefix +
           ",opcode1=" + _opcode1 +
           ",opcode2=" + _opcode2 +
           "]";
  }

  private X86InstructionHeader(WordWidth addressWidth, X86Template template) {
    _hasAddressSizePrefix = template.addressSizeAttribute() != addressWidth;
    _instructionSelectionPrefix = template.instructionSelectionPrefix();
    if (template.operandSizeAttribute() == WordWidth.BITS_16) {
      assert _instructionSelectionPrefix == null;
      _instructionSelectionPrefix = X86InstructionPrefix.OPERAND_SIZE;
    }
    _opcode1 = template.opcode1();
    _opcode2 = template.opcode2();
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof X86InstructionHeader) {
      final X86InstructionHeader header = (X86InstructionHeader) other;
      return _hasAddressSizePrefix == header._hasAddressSizePrefix &&
             _instructionSelectionPrefix == header._instructionSelectionPrefix &&
             _opcode1 == header._opcode1 &&
             _opcode2 == header._opcode2;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = _hasAddressSizePrefix ? -1 : 1;
    if (_instructionSelectionPrefix != null) {
      result *= _instructionSelectionPrefix.ordinal();
    }
    if (_opcode1 != null) {
      result *= _opcode1.ordinal();
    }
    if (_opcode2 != null) {
      result ^= _opcode2.ordinal();
    }
    if (_instructionSelectionPrefix != null) {
      result += _instructionSelectionPrefix.ordinal() * 1024;
    }
    if (_opcode2 != null) {
      result += _opcode2.ordinal() * 256;
    }
    if (_opcode1 != null) {
      result += _opcode1.ordinal();
    }
    return result;
  }

  public static <Template_Type extends X86Template> Map<X86InstructionHeader, LinkedList<Template_Type>> createMapping(
      Assembly<Template_Type> assembly, WordWidth addressWidth) {
    final Map<X86InstructionHeader, LinkedList<Template_Type>> result =
        new HashMap<X86InstructionHeader, LinkedList<Template_Type>>();
    for (Template_Type template : assembly.templates()) {
      X86InstructionHeader header = new X86InstructionHeader(addressWidth, template);
      LinkedList<Template_Type> matchingTemplates = result.get(header);
      if (matchingTemplates == null) {
        matchingTemplates = new LinkedList<Template_Type>();
        result.put(header, matchingTemplates);
      }
      matchingTemplates.addLast(template);
      for (X86Parameter parameter : template.parameters()) {
        switch (parameter.place()) {
          case OPCODE1_REXB:
          case OPCODE1:
            for (int i = 0; i < 8; i++) {
              header = new X86InstructionHeader(addressWidth, template);
              header._opcode1 = HexByte.values()[header._opcode1.ordinal() + i];
              result.put(header, matchingTemplates);
            }
            break;
          case OPCODE2_REXB:
          case OPCODE2:
            for (int i = 0; i < 8; i++) {
              header = new X86InstructionHeader(addressWidth, template);
              header._opcode2 = HexByte.values()[header._opcode2.ordinal() + i];
              result.put(header, matchingTemplates);
            }
            break;
          default:
            break;
        }
      }
    }
    return result;
  }
}
