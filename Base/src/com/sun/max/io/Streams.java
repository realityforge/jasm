/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.io;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Supplementary java.io utils.
 *
 * @author Bernd Mathiske
 */
public final class Streams {

  public static final class Redirector extends Thread {

    private final InputStream _inputStream;
    private final OutputStream _outputStream;
    private final String _name;
    private final int _maxLines;
    private final Process _process;
    private boolean _closed;

    private Redirector(Process process, InputStream inputStream, OutputStream outputStream, String name, int maxLines) {
      _inputStream = inputStream;
      _outputStream = outputStream;
      _name = name;
      _maxLines = maxLines;
      _process = process;
      start();
    }

    public void close() {
      _closed = true;
    }

    @Override
    public void run() {
      try {
        try {
          int line = 1;
          while (!_closed) {
            if (_inputStream.available() == 0) {
              // A busy yielding loop is used so that this thread can be
              // stopped via a call to close() by another thread. Otherwise,
              // this thread could be blocked forever on an input stream
              // that is not closed and does not have any available data.
              // The prime example of course is System.in.
              Thread.yield();
              continue;
            }

            final int b = _inputStream.read();
            if (b < 0) {
              return;
            }
            if (line <= _maxLines) {
              _outputStream.write(b);
            }
            if (b == '\n') {
              if (line == _maxLines) {
                _outputStream.write(("<redirected stream concatenated after " +
                                     _maxLines +
                                     " lines>" +
                                     System.getProperty("line.separator", "\n")).getBytes());
              }
              ++line;
            }
          }
          _outputStream.flush();
        } catch (IOException ioe) {
          try {
            _process.exitValue();

            // This just means the process was terminated and the relevant pipe no longer exists
          } catch (IllegalThreadStateException e) {
            // Some other unexpected IO error occurred -> rethrow
            throw e;
          }
        }
      } catch (Throwable throwable) {
        if (_name != null) {
          System.err.println("Error while redirecting sub-process stream for \"" + _name + "\"");
        }
        throwable.printStackTrace();
      }
    }

  }

  public static Redirector redirect(Process process, InputStream inputStream, OutputStream outputStream, String name,
                                    int maxLines) {
    return new Redirector(process, inputStream, outputStream, name, maxLines);
  }

  public static Redirector redirect(Process process, InputStream inputStream, OutputStream outputStream, String name) {
    return redirect(process, inputStream, outputStream, name, Integer.MAX_VALUE);
  }

  public static boolean startsWith(BufferedInputStream bufferedInputStream, byte[] bytes) throws IOException {
    final byte[] data = new byte[bytes.length];
    bufferedInputStream.mark(bytes.length);
    try {
      readFully(bufferedInputStream, data, 0, data.length);
      if (java.util.Arrays.equals(data, bytes)) {
        return true;
      }
    } catch (IOException ioException) {
      // This is OK
    }
    bufferedInputStream.reset();
    return false;
  }

  private static void readFully(InputStream stream, byte[] buffer, int offset, int len) throws IOException {
    if (len < 0) {
      throw new IndexOutOfBoundsException();
    }
    int n = 0;
    while (n < len) {
      final int count = stream.read(buffer, offset + n, len - n);
      if (count < 0) {
        throw new EOFException((len - n) + " of " + len + " bytes unread");
      }
      n += count;
    }
  }
}
