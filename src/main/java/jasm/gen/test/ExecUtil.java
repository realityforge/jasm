/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.test;

import jasm.util.ProgramError;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class ExecUtil {

  /**
   * Executes a command in a subprocess redirecting the standard streams of the
   * subprocess to/from the standard streams of the current process.
   *
   * @param command  the command line to execute
   */
  static void exec(String command) throws IOException, InterruptedException {
    exec(command, System.out, System.err, System.in);
  }

  /**
   * Executes a command in a subprocess redirecting the standard streams of the
   * subprocess to/from the supplied streams.
   *
   * @param command  the command line to execute
   * @param out   the stream to which standard output will be directed
   * @param err   the stream to which standard error output will be directed
   * @param in    the stream from which standard input will be read
   */
  private static void exec(String command, OutputStream out, OutputStream err, InputStream in)
      throws IOException, InterruptedException {
    final Process process = Runtime.getRuntime().exec(command);
    Redirector stderr = null;
    Redirector stdout = null;
    Redirector stdin = null;
    try {
      stderr =
          new Redirector(process, process.getErrorStream(), err, command + " [stderr]", 50);
      stdout =
          new Redirector(process, process.getInputStream(), out, command + " [stdout]", Integer.MAX_VALUE);
      stdin =
          new Redirector(process, in, process.getOutputStream(), command + " [stdin]", Integer.MAX_VALUE);
      final int exitValue = process.waitFor();
      if (exitValue != 0) {
        ProgramError.unexpected("execution of command failed: " + command + " [exit code = " + exitValue + "]");
      }
    } finally {
      if( null != stderr ) stderr.close();
      if( null != stdout ) stdout.close();
      if( null != stdin ) stdin.close();
      process.destroy();
    }
  }

  private static final class Redirector extends Thread {

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

    void close() {
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
}
