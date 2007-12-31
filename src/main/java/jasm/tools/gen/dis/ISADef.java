/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.gen.dis;

enum ISADef {
  ia32("jasm.tools.cisc.ia32.gen.dis.IA32DisassemblerGenerator");

  private final String _generatorClassname;

  ISADef(final String generatorClassname) {
    _generatorClassname = generatorClassname;
  }

  public String getGeneratorClassname() {
    return _generatorClassname;
  }
}