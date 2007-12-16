/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
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
