/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ia32.as;

import jasm.Assembler32;
import jasm.AssemblyException;
import jasm.Config;
import jasm.InstructionSet;
import jasm.Label;

/** Instatiate this class to assemble IA32 instructions. */
public final class IA32Assembler
    extends IA32LabelAssembler
    implements Assembler32 {

  private final int _startAddress; // address of first instruction

  public IA32Assembler(int startAddress) {
    this(Config.DEFAULT_INITIAL_MACHINE_CODE_SIZE, startAddress);
  }

  public IA32Assembler(int initialMachineCodeCapacity, int startAddress) {
    super(initialMachineCodeCapacity);
    _startAddress = startAddress;
  }

  @Override
  public final InstructionSet instructionSet() {
    return InstructionSet.IA32;
  }

  public final int startAddress() {
    return _startAddress;
  }

  public final void fixLabel(Label label, int address) {
    fixLabel32(label, address);
  }

  public final int address(Label label) throws AssemblyException {
    return address32(label);
  }
}
