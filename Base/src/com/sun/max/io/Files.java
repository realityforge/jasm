/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public final class Files {
  private static void copy(File from, File to) throws IOException {
    InputStream inputStream = null;
    OutputStream outputStream = null;
    try {
      inputStream = new FileInputStream(from);
      outputStream = new FileOutputStream(to);
      copy(inputStream, outputStream);
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
      if (outputStream != null) {
        outputStream.close();
      }
    }
  }

  /**
   * Updates the generated content part of a file. A generated content part is delimited by a line containing
   * only {@code start} and a line containing only {@code end}. If the given file already exists and
   * has these delimiters, the content between these lines is compared with {@code content} and replaced
   * if it is different. If the file does not exist, a new file is created with {@code content} surrounded
   * by the specified delimiters. If the file exists and does not currently have the specified delimiters, an
   * IOException is thrown.
   *
   * @return true if the file was modified or created
   */
  public static boolean updateGeneratedContent(File file, ReadableSource content, String start, String end)
      throws IOException {

    if (!file.exists()) {
      final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
      try {
        final Reader reader = content.reader(true);
        try {
          copy(reader, printWriter);
          printWriter.println(end);
        } finally {
          reader.close();
        }
      } finally {
        printWriter.close();
      }
      return true;
    }

    final File tempFile = File.createTempFile(file.getName() + ".", null);
    PrintWriter printWriter = null;
    BufferedReader contentReader = null;
    BufferedReader existingFileReader = null;
    try {
      printWriter = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));
      contentReader = (BufferedReader) content.reader(true);
      existingFileReader = new BufferedReader(new FileReader(file));

      // Copy existing file up to generated content opening delimiter
      String line;
      while ((line = existingFileReader.readLine()) != null) {
        printWriter.println(line);
        if (line.equals(start)) {
          break;
        }
      }

      if (line == null) {
        throw new IOException("generated content starting delimiter not found in existing file: " + file);
      }

      boolean changed = false;
      boolean seenEnd = false;

      // Copy new content, noting if it differs from existing generated content
      while ((line = contentReader.readLine()) != null) {
        if (!seenEnd) {
          final String existingLine = existingFileReader.readLine();
          if (existingLine != null) {
            if (end.equals(existingLine)) {
              seenEnd = true;
              changed = true;
            } else {
              changed = changed || !line.equals(existingLine);
            }
          }
        }
        printWriter.println(line);
      }

      // Find the generated content closing delimiter
      if (!seenEnd) {
        while ((line = existingFileReader.readLine()) != null) {
          if (line.equals(end)) {
            seenEnd = true;
            break;
          }
          changed = true;
        }
        if (!seenEnd) {
          throw new IOException("generated content ending delimiter not found in existing file: " + file);
        }
      }
      printWriter.println(end);

      // Copy existing file after generated content closing delimiter
      while ((line = existingFileReader.readLine()) != null) {
        printWriter.println(line);
      }

      printWriter.close();
      printWriter = null;
      existingFileReader.close();
      existingFileReader = null;

      if (changed) {
        copy(tempFile, file);
        return true;
      }
      return false;
    } finally {
      quietClose(printWriter);
      quietClose(contentReader);
      quietClose(existingFileReader);
      if (!tempFile.delete()) {
        throw new IOException("could not delete file for update: " + file);
      }
    }
  }

  private static void copy(Reader reader, Writer writer) throws IOException {
    final char[] buffer = new char[8192];
    int count;
    while ((count = reader.read(buffer, 0, buffer.length)) > 0) {
      writer.write(buffer, 0, count);
    }
    writer.flush();
  }

  private static void quietClose(Closeable closeable) {
    if (closeable != null) {
      try {
        closeable.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
    final byte[] buffer = new byte[8192];
    int count;
    while ((count = inputStream.read(buffer, 0, buffer.length)) > 0) {
      outputStream.write(buffer, 0, count);
    }
    outputStream.flush();
  }

}

