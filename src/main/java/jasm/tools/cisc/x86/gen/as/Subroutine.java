/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86.gen.as;

import java.util.HashSet;
import jasm.tools.cisc.x86.X86Template;

public final class Subroutine<Template_Type extends X86Template<Template_Type>> {

  final HashSet<Template_Type> templates = new HashSet<Template_Type>();
  int id;
  //set to true for mod variants (for the moment)
  boolean required;

  String name() {
    final StringBuilder sb = new StringBuilder();
    sb.append("assemble");
    final String idString = Integer.toString(id);
    final int size = idString.length();
    for(int i = size; i < 4; i++ ) {
      sb.append('0');
    }
    sb.append(idString);
    return sb.toString();
  }

  boolean required() { return required || templates.size() > 1; }

  Template_Type template() { return templates.iterator().next(); }

  public String toString() { return "[Subroutine id=" + id + " templateCount=" + templates.size() + "]"; }
}
