/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

/**
 * Wrapper for a specification in an instruction description that indicates that whatever
 * is specified is omitted in the external assembler syntax.
 */
public final class ExternalOmission {

  private final Object _specification;

  public ExternalOmission(Object specification) {
    _specification = specification;
  }

  public final Object wrappedSpecification() {
    return _specification;
  }
}
