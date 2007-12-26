package jasm.tools.cisc.x86;

import jasm.util.HexByte;
import static jasm.util.HexByte._40;
import static jasm.util.HexByte._4F;

public final class X86RexPrefix {
  public static final HexByte REX_MIN = _40;
  public static final HexByte REX_MAX = _4F;

  public static boolean isRexPrefix(HexByte opcode) {
    return REX_MIN.ordinal() <= opcode.ordinal() && opcode.ordinal() <= REX_MAX.ordinal();
  }
}
