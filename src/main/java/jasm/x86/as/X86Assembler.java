package jasm.x86.as;

import jasm.LittleEndianAssembler;
import jasm.annotations.Inline;

public abstract class X86Assembler
    extends LittleEndianAssembler {

  protected X86Assembler(final int initialMachineCodeCapacity) {
    super(initialMachineCodeCapacity);
  }

  //TODO: Move into AbstractAMD64Assembler
  @Inline
  protected final void emitRexPrefix(final boolean force,
                                     final boolean wBit,
                                     final boolean rBit,
                                     final boolean bBit,
                                     final boolean xBit) {
    if (!force && !wBit && !rBit && !bBit && !xBit) {
      return;
    }
    byte rex = (byte) 0x40;
    if (bBit) { rex |= 1; }
    if (xBit) { rex |= 1 << 1; }
    if (rBit) { rex |= 1 << 2; }
    if (wBit) { rex |= 1 << 3; }
    emitByte(rex);
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
