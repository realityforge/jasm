/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.amd64.as;

import jasm.Assembler64;
import jasm.AssemblyException;
import jasm.Config;
import jasm.InstructionSet;
import jasm.Label;

/** Instantiate this class to assemble AMD64 instructions. */
public class AMD64Assembler
    extends AMD64LabelAssembler
    implements Assembler64 {

  private final long _startAddress; // address of first instruction

  public AMD64Assembler(long startAddress) {
    this(Config.DEFAULT_INITIAL_MACHINE_CODE_SIZE, startAddress);
  }

  public AMD64Assembler(int initialMachineCodeCapacity, long startAddress) {
    super(initialMachineCodeCapacity);
    _startAddress = startAddress;
  }

  public final long startAddress() {
    return _startAddress;
  }

  public final void fixLabel(Label label, long address) {
    fixLabel64(label, address);
  }

  public final long address(Label label) throws AssemblyException {
    return address64(label);
  }

  @Override
  public final InstructionSet instructionSet() {
    return InstructionSet.AMD64;
  }
}
