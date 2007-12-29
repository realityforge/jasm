/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.WordWidth;

final class LabelWidthCase<Template_Type extends X86Template<Template_Type>> {
  final WordWidth _width;
  final Template_Type _template;

  LabelWidthCase(WordWidth width, Template_Type template) {
    _width = width;
    _template = template;
  }
}
