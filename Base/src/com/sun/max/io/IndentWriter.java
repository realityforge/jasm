/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.io;

import com.sun.max.program.ProgramWarning;
import com.sun.max.program.Trace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * A line oriented character writer that indents line output on the left.
 *
 * @author Bernd Mathiske
 */
public class IndentWriter {

    private final PrintWriter _writer;
    private int _lineCount;

    /**
     * Gets an IndentWriter that wraps the {@linkplain Trace#stream() trace stream}.
     * @return
     */
    public static IndentWriter traceStreamWriter() {
        return new IndentWriter(new OutputStreamWriter(Trace.stream()));
    }

    public IndentWriter(Writer writer) {
        _writer = (writer instanceof PrintWriter) ? (PrintWriter) writer : new PrintWriter(writer);
    }

    public void close() {
        _writer.close();
    }

    public void flush() {
        _writer.flush();
    }

    private int _indentation = 4;

    public int indentation() {
        return _indentation;
    }

    public void setIndentation(int indentation) {
        _indentation = indentation;
    }

    private int _prefix;

    public void indent() {
        _prefix += _indentation;
    }

    public void outdent() {
        _prefix -= _indentation;
        assert _prefix >= 0;
    }

    private boolean _isCurrentLineIndented;

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

    public void printLines(InputStream inputStream) {
        printLines(new InputStreamReader(inputStream));
    }

    public void printLines(Reader reader) {
        final BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                println(line);
            }
        } catch (IOException e) {
            ProgramWarning.message(e.toString());
        }
    }

    public int lineCount() {
        return _lineCount;
    }
}
