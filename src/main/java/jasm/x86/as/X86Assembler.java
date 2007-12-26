package jasm.x86.as;

import jasm.LittleEndianAssembler;
import jasm.annotations.Inline;

public abstract class X86Assembler
    extends LittleEndianAssembler {

  protected X86Assembler(final int initialMachineCodeCapacity) {
    super(initialMachineCodeCapacity);
  }

  @Inline
  protected final void emitModRM(final int mod, final int rm, final int reg) {
    byte modRMByte = (byte) ((mod & 3) << 6); // mod field
    modRMByte |= (rm & 7); // rm field
    modRMByte |= (reg & 7) << 3; // reg field
    emitByte(modRMByte);
  }

  @Inline
  protected final void emitSibByte(final int base, final int index, final int scale) {
    byte sibByte = (byte) 0;
    sibByte |= (base & 7); // base field
    sibByte |= (index & 7) << 3; // index field
    sibByte |= scale << 6; // scale field
    emitByte(sibByte);
  }
}
