/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.examples.answer;

import static jasm.ia32.IA32GeneralRegister32.EAX;
import jasm.ia32.as.IA32Assembler;
import java.io.FileOutputStream;

public class Main {

  public static void main(String[] args) {
    if (1 != args.length) {
      System.out.println("Expects a single parameter for name of output file.");
    } else {
      try {
        final FileOutputStream output = new FileOutputStream(args[0]);
        output.write(assemble());
        output.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private static byte[] assemble() throws Exception {
    final int address = 0x5B000000;
    final IA32Assembler asm = new IA32Assembler(address);
    asm.mov(EAX, 42);
    asm.ret();
    return asm.toByteArray();
  }
}
