/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.test;

import jasm.util.program.ProgramWarning;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InterruptedIOException;

final class ExternalAssembler {

  static final String SOURCE_EXTENSION = ".s";
  private static final String BINARY_EXTENSION = ".o";

  private String _remoteAssemblerPath = "";
  private String _remoteUserAndHost;

  /**
   * Sets the path of the directory on a remote machine containing the assembler command.
   *
   * @param path the absolute path to the directory containing the assembler executable (must not be null)
   */
  public void setRemoteAssemblerPath(String path) {
    assert path != null;
    _remoteAssemblerPath = path;
  }

  /**
   * Sets the {@code user@host} string that will be used to execute the external
   * assembler on a remote host via SSH. If this value is not set or set to null, the
   * external assembler will be executed on the local machine. Requires the presence
   * of ssh+scp commands configured to connect to specified host.
   *
   * @param remoteUserAndHost a {@code user@host} value denoting a machine that
   *        supports remote execution via SSH2 using public key authentication
   */
  public void setRemoteUserAndHost(String remoteUserAndHost) {
    _remoteUserAndHost = remoteUserAndHost;
  }

  File assemble(final File source, final String assemblerCommand)
      throws IOException {
    try {
      final String sourcePath = source.getPath();
      final String filename =
          sourcePath.substring(0, sourcePath.length() - SOURCE_EXTENSION.length()) + BINARY_EXTENSION;
      final File binary = new File(filename);
      if (_remoteUserAndHost != null) {
        // Copy input source to remote machine
        ExecUtil.exec("scp -C " + source.getAbsolutePath() + " " + _remoteUserAndHost + ":" + source.getName());

        // Execute assembler remotely
        final String ras = _remoteAssemblerPath + assemblerCommand;
        final String cmd2 =
            "ssh " + _remoteUserAndHost + " " + ras + " -o " + binary.getName() + " " + source.getName();
        ExecUtil.exec(cmd2);

        // Copy output binary to local machine
        ExecUtil.exec("scp -C " + _remoteUserAndHost + ":" + binary.getName() + " " + binary.getAbsolutePath());

        // Delete input source and output binary from remote machine
        ExecUtil.exec("ssh " + _remoteUserAndHost + " rm " + binary.getName() + " " + source.getName());
      } else {
        ExecUtil.exec(assemblerCommand + " " + source.getAbsolutePath() + " -o " + binary.getAbsolutePath());
      }
      return binary;
    } catch (InterruptedException e) {
      throw new InterruptedIOException(e.toString());
    }
  }

  static void cleanupTempFiles(final String prefix) {
    if (prefix == null || prefix.length() == 0) {
      return;
    }
    try {
      final File tempFile = File.createTempFile(prefix, null);
      final File directory = tempFile.getParentFile();
      final FilenameFilter filter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return !(prefix != null && prefix.length() > 0 && !name.startsWith(prefix));
        }
      };
      for (File file : directory.listFiles(filter)) {
        if (!file.delete()) {
          ProgramWarning.message("could not delete temporary file: " + file.getAbsolutePath());
        }
      }
    } catch (IOException ioException) {
      ProgramWarning.message("could not delete temporary files");
    }
  }
}
