/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package com.sun.max.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Writes the same output to several streams.
 *
 * @author Bernd Mathiske
 */
public class MultiOutputStream extends OutputStream {

    private OutputStream[] _streams;

    public MultiOutputStream(OutputStream... streams) {
        _streams = streams;
    }

    @Override
    public void write(int b) throws IOException {
        for (OutputStream stream : _streams) {
            stream.write(b);
        }
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        for (OutputStream stream : _streams) {
            stream.write(bytes);
        }
    }

    @Override
    public void write(byte[] bytes, int startOffset, int numberOfBytes) throws IOException {
        for (OutputStream stream : _streams) {
            stream.write(bytes, startOffset, numberOfBytes);
        }
    }

    @Override
    public void flush() throws IOException {
        for (OutputStream stream : _streams) {
            stream.flush();
        }
    }

    @Override
    public void close() throws IOException {
        for (OutputStream stream : _streams) {
            stream.close();
        }
    }
}
