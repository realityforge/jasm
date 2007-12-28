/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

final class Subroutine<Template_Type extends X86Template<Template_Type>>
    implements Comparable<Subroutine<Template_Type>> {

  final String name;
  final String code;
  final Template_Type template;
  int usageCount;

  Subroutine(String name, String code, Template_Type template) {
    this.name = name;
    this.code = code;
    this.template = template;
  }

  public int compareTo(final Subroutine o) {
    return name.compareTo(o.name);
  }
}
