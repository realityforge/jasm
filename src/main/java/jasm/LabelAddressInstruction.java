/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

public abstract class LabelAddressInstruction extends LabelInstruction {

  protected LabelAddressInstruction(Assembler assembler, int startOffset, int endOffset, Label label) {
    super(assembler, startOffset, endOffset, label);
    assembler.addFixedLengthLabelInstruction(this);
  }

  public final int labelAddressAsInt() throws AssemblyException {
    final Assembler32 assembler = (Assembler32) assembler();
    switch (label().state()) {
      case BOUND: {
        return assembler.startAddress() + label().offset();
      }
      case FIXED_32: {
        return assembler.address(label());
      }
      case FIXED_64: {
        throw new IllegalStateException("64-bit address requested for 32-bit assembler");
      }
      default: {
        throw new AssemblyException("unassigned label");
      }
    }
  }

  public final long labelAddressAsLong() throws AssemblyException {
    final Assembler64 assembler = (Assembler64) assembler();
    switch (label().state()) {
      case BOUND: {
        return assembler.startAddress() + label().offset();
      }
      case FIXED_64: {
        return assembler.address(label());
      }
      case FIXED_32: {
        throw new IllegalStateException("32-bit address requested for 64-bit assembler");
      }
      default: {
        throw new AssemblyException("unassigned label");
      }
    }
  }
}
