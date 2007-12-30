package jasm.x86.as;

import jasm.LittleEndianAssembler;
import jasm.annotations.Inline;
import jasm.x86.X86InstructionPrefix;

public abstract class X86Assembler
    extends LittleEndianAssembler {

  protected X86Assembler(final int initialMachineCodeCapacity) {
    super(initialMachineCodeCapacity);
  }

  @Inline
  protected final void emitPrefix(final X86InstructionPrefix prefix) {
    emitByte(prefix.getValue().byteValue());
  }

  @Inline
  protected final void emitAddressSizePrefix() {
    emitPrefix(X86InstructionPrefix.ADDRESS_SIZE);
  }

  @Inline
  protected final void emitOperandSizePrefix() {
    emitPrefix(X86InstructionPrefix.OPERAND_SIZE);
  }

  @Inline
  protected final void emitOpcode2(final byte opcode2) {
    emitByte((byte) (0x0F)); // opcode1
    emitByte(opcode2);
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
