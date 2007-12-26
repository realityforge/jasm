package jasm.x86.as;

import jasm.LittleEndianAssembler;

public abstract class X86Assembler
    extends LittleEndianAssembler {

  protected X86Assembler(final int initialMachineCodeCapacity) {
    super(initialMachineCodeCapacity);
  }

  
}
