/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0104d7bb-4b4f-44c4-ba4a-3efcfb7c7bbd*/
package com.sun.max.io;

import java.io.ByteArrayOutputStream;

/**
 * A {@link ByteArrayOutputStream} that can have its write position {@linkplain #seek(int) updated}.
 *
 * @author Doug Simon
 */
public class SeekableByteArrayOutputStream extends ByteArrayOutputStream {

    private int _highestCount;

    /**
     * @see ByteArrayOutputStream#ByteArrayOutputStream()
     */
    public SeekableByteArrayOutputStream() {
    }

    /**
     * @see ByteArrayOutputStream#ByteArrayOutputStream(int)
     */
    public SeekableByteArrayOutputStream(int size) {
        super(size);
    }

    /**
     * Updates the write position of this stream. The stream can only be repositioned between 0 and
     * the {@linkplain #endOfStream() end of the stream}.
     *
     * @param index
     *            the index to which the write position of this stream will be set
     * @throws IllegalArgumentException
     *             if {@code index > highestSeekIndex()}
     */
    public void seek(int index) throws IllegalArgumentException {
        if (endOfStream() < index) {
            throw new IllegalArgumentException();
        }
        count = index;
    }

    /**
     * Gets the index one past the highest index that has been written to in this stream.
     */
    public int endOfStream() {
        if (_highestCount < count) {
            _highestCount = count;
        }
        return _highestCount;
    }

    @Override
    public void reset() {
        super.reset();
        _highestCount = 0;
    }
}
