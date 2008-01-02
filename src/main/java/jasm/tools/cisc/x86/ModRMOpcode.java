package jasm.tools.cisc.x86;

public enum ModRMOpcode {
  _0, _1, _2, _3, _4, _5, _6, _7;

  public byte value() {
    return (byte) ordinal();
  }
}
