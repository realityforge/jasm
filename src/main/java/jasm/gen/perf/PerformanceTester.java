/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.perf;

import jasm.dis.Disassembler;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Base class for performance testers.
 * Each subclass assembles a specific set of instructions.
 */
public abstract class PerformanceTester {
  private final int _instructionCount;
  private int _machineCodeSize;

  protected PerformanceTester(final int instructionCount) {
    _instructionCount = instructionCount;
  }

  public final int getMachineCodeSize() {
    return _machineCodeSize;
  }

  public int getInstructionCount() {
    return _instructionCount;
  }

  public long runAssembleTest(final int iterations) throws Exception {
    final long start = System.nanoTime();
    for (int i = 0; i < iterations; i++) {
      final byte[] bytes = assemble();
      _machineCodeSize = bytes.length;
    }
    return System.nanoTime() - start;
  }

  public long runDisassembleTest(final int iterations) throws Exception {
    final byte[] bytes = assemble();
    _machineCodeSize = bytes.length;
    final long start = System.nanoTime();
    for (int i = 0; i < iterations; i++) {
      disassemble(bytes);
    }
    return System.nanoTime() - start;
  }

  protected abstract Disassembler<?, ?> getDisassembler();

  protected abstract byte[] assemble() throws Exception;

  protected void disassemble(byte[] bytes) throws Exception
  {
    final Disassembler<?,?> disassembler = getDisassembler();
    final BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(bytes));
    disassembler.scanAndPrint(inputStream, new NullOutputStream());
  }

  static final class NullOutputStream extends OutputStream {
    public void write(int b) throws IOException {
    }
  }
}
