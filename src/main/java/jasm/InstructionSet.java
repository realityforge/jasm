/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public enum InstructionSet {
  AMD64(Category.CISC, Endianness.LITTLE, RelativeAddressing.FROM_INSTRUCTION_END, WordWidth.BITS_64),
  IA32(Category.CISC, Endianness.LITTLE, RelativeAddressing.FROM_INSTRUCTION_END, WordWidth.BITS_32),
  PPC(Category.RISC, Endianness.BIG, RelativeAddressing.FROM_INSTRUCTION_START, WordWidth.BITS_32, WordWidth.BITS_64),
  SPARC(Category.RISC, Endianness.BIG, RelativeAddressing.FROM_INSTRUCTION_START, WordWidth.BITS_32, WordWidth.BITS_64);

  public enum Category {
    CISC, RISC
  }

  public enum RelativeAddressing {
    FROM_INSTRUCTION_START, FROM_INSTRUCTION_END
  }

  private final Category _category;
  private final Endianness _endianness;
  private final RelativeAddressing _relativeAddressing;
  private final Collection<WordWidth> _wordWidths;

  private InstructionSet(final Category category, final Endianness endianness, RelativeAddressing relativeAddressing, WordWidth... wordWidths) {
    _category = category;
    _endianness = endianness;
    _relativeAddressing = relativeAddressing;
    _wordWidths = Collections.unmodifiableCollection(Arrays.asList(wordWidths));
  }

  public WordWidth[] wordWidths() {
    return _wordWidths.toArray(new WordWidth[_wordWidths.size()]);
  }

  public Category category() { return _category; }

  public Endianness endianness() { return _endianness; }

  public RelativeAddressing relativeAddressing() { return _relativeAddressing; }

  @Override
  public String toString() {
    return name();
  }
}
