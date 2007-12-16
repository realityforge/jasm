/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.com.sun.max.io;

import com.sun.max.io.Streams;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import junit.framework.TestCase;

public class StreamsTest extends TestCase {

    public StreamsTest(String name) {
        super(name);
    }

    private static BufferedInputStream asStream(String s) {
        return new BufferedInputStream(new ByteArrayInputStream(s.getBytes()));
    }

    private static boolean streamSearch(String content, String... keys) {
        try {
            final BufferedInputStream stream = asStream(content);
            for (String key : keys) {
                if (!Streams.search(stream, key.getBytes())) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void test_search() {
        assertTrue(streamSearch("search", "search"));
        assertTrue(streamSearch("search", ""));
        assertTrue(streamSearch("", ""));
        assertTrue(streamSearch("search", "sea"));
        assertTrue(streamSearch("seasearch", "search"));
        assertTrue(streamSearch("one two three", "one", "two", "three"));

        assertFalse(streamSearch("se arch", "sea"));
        assertFalse(streamSearch("", "key"));
    }
}
