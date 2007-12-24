/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.sparc.as;

import jasm.Assembler64;
import jasm.AssemblyException;
import jasm.Label;

/**
 * The concrete class for a 64-bit SPARC assembler.
 */
public final class SPARC64Assembler extends SPARCAssembler implements Assembler64 {

  private long _startAddress; // address of first instruction

  public SPARC64Assembler() {
  }

  public SPARC64Assembler(long startAddress) {
    _startAddress = startAddress;
  }

  public final long startAddress() {
    return _startAddress;
  }

  public final void setStartAddress(long address) {
    _startAddress = address;
  }

  public final void fixLabel(Label label, long address) {
    fixLabel64(label, address);
  }

  public final long address(Label label) throws AssemblyException {
    return address64(label);
  }
}
