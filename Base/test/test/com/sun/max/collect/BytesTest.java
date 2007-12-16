/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package test.com.sun.max.collect;

import com.sun.max.ide.MaxTestCase;
import com.sun.max.lang.Bytes;

/**
 * Tests for com.sun.max.util.Bytes.
 *
 * @author Hiroshi Yamauchi
 */
public class BytesTest extends MaxTestCase {

    public BytesTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(BytesTest.class);
    }

    public static byte[] makeByteArray(int length) {
        final byte[] bytes = new byte[length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (i % 127);
        }
        return bytes;
    }

    public static final int TEST_LENGTH = 98;

    public void test_copy() {
        final byte[] bytes1 = makeByteArray(TEST_LENGTH);
        final byte[] bytes2 = new byte[TEST_LENGTH];
        final byte[] bytes3 = new byte[TEST_LENGTH];
        final byte[] bytes4 = new byte[TEST_LENGTH];
        Bytes.copy(bytes1, 0, bytes2, 0, TEST_LENGTH);
        for (int i = 0; i < TEST_LENGTH; i++) {
            assertTrue(bytes1[i] == bytes2[i]);
        }
        Bytes.copy(bytes1, TEST_LENGTH / 2, bytes3, TEST_LENGTH / 2, TEST_LENGTH / 4);
        for (int i = TEST_LENGTH / 2; i < TEST_LENGTH / 4; i++) {
            assertTrue(bytes1[i] == bytes3[i]);
        }
        Bytes.copy(bytes1, bytes4, TEST_LENGTH);
        for (int i = 0; i < TEST_LENGTH; i++) {
            assertTrue(bytes1[i] == bytes4[i]);
        }
    }

    public void test_copyAll() {
        final byte[] bytes1 = makeByteArray(TEST_LENGTH);
        final byte[] bytes2 = new byte[TEST_LENGTH];
        final byte[] bytes3 = new byte[TEST_LENGTH + 100];
        Bytes.copyAll(bytes1, bytes2);
        for (int i = 0; i < TEST_LENGTH; i++) {
            assertTrue(bytes1[i] == bytes2[i]);
        }
        Bytes.copyAll(bytes1, bytes3, 100);
        for (int i = 0; i < TEST_LENGTH; i++) {
            assertTrue(bytes1[i] == bytes3[i + 100]);
        }
    }

    public void test_getSection() {
        final byte[] bytes1 = makeByteArray(TEST_LENGTH);
        final byte[] bytes2 = Bytes.getSection(bytes1, 0, TEST_LENGTH);
        for (int i = 0; i < TEST_LENGTH; i++) {
            assertTrue(bytes1[i] == bytes2[i]);
        }
        final byte[] bytes3 = Bytes.getSection(bytes1, TEST_LENGTH / 8, 2 * TEST_LENGTH / 3);
        for (int i = 0; i < (13 * TEST_LENGTH) / 24; i++) {
            assertTrue(bytes1[i + TEST_LENGTH / 8] == bytes3[i]);
        }
    }
}
