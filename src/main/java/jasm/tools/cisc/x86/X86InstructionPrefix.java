package jasm.tools.cisc.x86;

import jasm.Symbol;
import jasm.util.HexByte;

/**
 * x86 instruction prefix bytes.
 *
 * See Section 2.2.1 in manual.
 */
public enum X86InstructionPrefix implements Symbol {

  //Lock and repeat prefixes
  LOCK(1, HexByte._F0),
  REPNE(1, HexByte._F2),
  REPE(1, HexByte._F3),

  //Segment override prefixes
  SEG_CS(2, HexByte._2E),
  SEG_SS(2, HexByte._36),
  SEG_DS(2, HexByte._3E),
  SEG_ES(2, HexByte._26),
  SEG_FS(2, HexByte._64),
  SEG_GS(2, HexByte._65),

  //Branch hints
  BRANCH_NOT_TAKEN_HINT(2, HexByte._2E),
  BRANCH_TAKEN_HINT(2, HexByte._3E),

  //Operand size prefix
  // Also used to escape opcode OFH which is mandatory prefix
  // for some SIMD instructions
  OPERAND_SIZE(3, HexByte._66),

  //Address-size override prefix
  ADDRESS_SIZE(4, HexByte._67);

  private final int _group;
  private final HexByte _value;

  X86InstructionPrefix(final int group, final HexByte value) {
    _group = group;
    _value = value;
  }

  public int getGroup() {
    return _group;
  }
  public HexByte getValue() {
    return _value;
  }

  public int value() {
    return _value.byteValue();
  }
}
