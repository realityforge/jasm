/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.util;

import java.io.PrintWriter;
import java.io.Writer;

/** A line oriented character writer that indents line output on the left. */
public final class IndentWriter {

  private static final int INDENTATION = 4;
  private final PrintWriter _writer;
  private int _prefix;
  private boolean _isCurrentLineIndented;

  public IndentWriter(Writer writer) {
    _writer = (writer instanceof PrintWriter) ? (PrintWriter) writer : new PrintWriter(writer);
  }

  public void close() {
    _writer.close();
  }

  public void indent() {
    _prefix += INDENTATION;
  }

  public void outdent() {
    _prefix -= INDENTATION;
    assert _prefix >= 0;
  }

  public void resetIndentation() {
    _isCurrentLineIndented = false;
    _prefix = 0;
  }

  public void setIndentationLevel(final int level) {
    _prefix = INDENTATION * level;
  }

  private void writeIndentation() {
    if (!_isCurrentLineIndented) {
      for (int i = 0; i < _prefix; i++) {
        _writer.print(" ");
      }
      _isCurrentLineIndented = true;
    }
  }

  public void print(String s) {
    writeIndentation();
    _writer.print(s);
  }

  public void println() {
    _writer.println();
    _isCurrentLineIndented = false;
  }

  public void println(String s) {
    writeIndentation();
    _writer.println(s);
    _isCurrentLineIndented = false;
  }
}
