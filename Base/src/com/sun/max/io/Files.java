/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f330ef41-93b6-437f-a1e3-2a1cc618aa44*/
package com.sun.max.io;

import java.io.*;
import java.util.*;

import com.sun.max.annotate.*;
import com.sun.max.collect.*;
import com.sun.max.util.*;

public final class Files {

    private Files() {
    }

    public static void copy(File from, File to) throws FileNotFoundException, IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(from);
            outputStream = new FileOutputStream(to);
            Streams.copy(inputStream, outputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    public static boolean equals(File file1, File file2) throws FileNotFoundException, IOException {
        InputStream inputStream1 = null;
        InputStream inputStream2 = null;
        try {
            inputStream1 = new BufferedInputStream(new FileInputStream(file1), (int) file1.length());
            inputStream2 = new BufferedInputStream(new FileInputStream(file2), (int) file2.length());
            return Streams.equals(inputStream1, inputStream2);
        } finally {
            if (inputStream1 != null) {
                inputStream1.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
        }
    }

    public static boolean equals(File file, Iterator<String> lines) throws FileNotFoundException, IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!lines.hasNext()) {
                    return false;
                }
                if (!line.equals(lines.next())) {
                    return false;
                }
            }
        } finally {
            bufferedReader.close();
        }
        return !lines.hasNext();
    }
    
    public static byte[] toBytes(File file) throws IOException {
        if (file.length() > Integer.MAX_VALUE) {
            throw new IOException("file is too big to read into an array: " + file);
        }
        final InputStream stream = new FileInputStream(file);
        try {
            return Streams.readFully(stream, new byte[(int) file.length()]);
        } finally {
            stream.close();
        }
    }

    /**
     * Creates/overwrites a file with a given string.
     */
    public static void fill(File file, String content) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try {
            bufferedWriter.write(content);
        } finally {
            bufferedWriter.close();
        }
    }
    
    /**
     * Creates/overwrites a file from a reader.
     */
    public static void fill(File file, Reader reader, boolean append) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try {
            int ch;
            while ((ch = reader.read()) != -1) {
                bufferedWriter.write(ch);
            }
        } finally {
            bufferedWriter.close();
        }
    }

    public static char[] toChars(File file) throws IOException {
        if (file.length() > Integer.MAX_VALUE) {
            throw new IOException("file is too big to read into an array: " + file);
        }
        final FileReader fileReader = new FileReader(file);
        try {
            final int length = (int) file.length();
            final char[] chars = Streams.readFully(fileReader, new char[length]);
            return chars;
        } finally {
            fileReader.close();            
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
    public static boolean updateGeneratedContent(File file, ReadableSource content, String start, String end) throws IOException {
        
        if (!file.exists()) {
            final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            try {
                final Reader reader = content.reader(true);
                try {
                    Streams.copy(reader, printWriter);
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

    private static void quietClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }            
    }
    
    public static Sequence<File> find(File directory, final String suffix, AppendableSequence<File> listing) {
        final Predicate<File> suffixPredicate = new Predicate<File>() {
            @Implement(Predicate.class)
            public boolean evaluate(File file) {
                return file.getName().endsWith(suffix);
            }
            
        };
        return find(directory, suffixPredicate, listing);
    }
    
    public static Sequence<File> find(File directory, Predicate<File> filter, AppendableSequence<File> listing) {
        assert directory.isDirectory();
        return find(directory, listing == null ? new ArrayListSequence<File>() : listing, filter);
    }

    private static AppendableSequence<File> find(File directory, AppendableSequence<File> listing, Predicate<File> filter) {
        assert directory.isDirectory();
        final File[] entries = directory.listFiles();
        if (entries != null) {
            for (File entry : entries) {
                if (!entry.isDirectory()) {
                    if (filter == null || filter.evaluate(entry)) {
                        listing.append(entry);
                    }
                } else {
                    find(entry, listing, filter);
                }
            }
        }
        return listing;
    }
    
}

