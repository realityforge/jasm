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

  private final PrintWriter _writer;
  private int _lineCount;
  private int _indentation = 4;
  private int _prefix;
  private boolean _isCurrentLineIndented;

  public IndentWriter(Writer writer) {
    _writer = (writer instanceof PrintWriter) ? (PrintWriter) writer : new PrintWriter(writer);
  }

  public void close() {
    _writer.close();
  }

  public void indent() {
    _prefix += _indentation;
  }

  public void outdent() {
    _prefix -= _indentation;
    assert _prefix >= 0;
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
    ++_lineCount;
  }

  public void println(String s) {
    writeIndentation();
    _writer.println(s);
    _isCurrentLineIndented = false;
    ++_lineCount;
  }

  public int lineCount() {
    return _lineCount;
  }
}
