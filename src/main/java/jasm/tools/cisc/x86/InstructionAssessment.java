/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

/**
 * Some information about a family of instructions that have the same basic opcode.
 *
 * @see OpcodeAssessor
 */
final class InstructionAssessment {

  private boolean _hasAddressSizeVariants;
  private boolean _hasModRMByte;
  private ModRMGroup _modRMGroup;
  private boolean _isJump;

  final void haveAddressSizeVariants() {
    _hasAddressSizeVariants = true;
  }

  final boolean hasAddressSizeVariants() {
    return _hasAddressSizeVariants;
  }

  final void haveModRMByte() {
    _hasModRMByte = true;
  }

  final boolean hasModRMByte() {
    return _hasModRMByte;
  }

  final void setModRMGroup(ModRMGroup modRMGroup) {
    _modRMGroup = modRMGroup;
    _hasModRMByte = modRMGroup != null;
  }

  final ModRMGroup modRMGroup() {
    return _modRMGroup;
  }

  final void beJump() {
    _isJump = true;
  }

  final boolean isJump() {
    return _isJump;
  }
}
