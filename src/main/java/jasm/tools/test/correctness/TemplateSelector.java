/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.test.correctness;

import jasm.tools.Template;

final class TemplateSelector<Template_Type extends Template> {
  enum State {
    TEST, SKIP, DONE
  }

  private int _startSerial;
  private int _endSerial = Integer.MAX_VALUE;
  private String _pattern;

  public void setStartSerial(final int startSerial) {
    _startSerial = startSerial;
  }

  public void setEndSerial(final int endSerial) {
    _endSerial = endSerial;
  }

  /**
   * Sets the pattern that restricts which templates are tested.
   *
   * @param pattern if non-null, only templates whose {@link Template#internalName() name} contains
   *                {@code pattern} as a substring are tested
   */
  public void setPattern(String pattern) {
    _pattern = pattern;
  }

  State select(Template_Type template) {
    if (template.serial() > _endSerial) {
      return State.DONE;
    } else if (template.serial() >= _startSerial &&
               (_pattern == null || template.internalName().contains(_pattern))) {
      return State.TEST;
    } else {
      return State.SKIP;
    }
  }
}
