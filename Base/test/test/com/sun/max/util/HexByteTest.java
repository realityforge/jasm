/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e487f44c-fe5d-40c3-bc00-c9ff17a183db*/
package test.com.sun.max.util;

import com.sun.max.ide.MaxTestCase;
import com.sun.max.util.HexByte;
import java.util.EnumSet;

/**
 * Tests for {@link HexByte}.
 *
 * @author Hiroshi Yamauchi
 */
public class HexByteTest extends MaxTestCase {

    public HexByteTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(HexByteTest.class);
    }

    public void test_value() {
        final EnumSet<HexByte> enumSet = EnumSet.allOf(HexByte.class);
        for (Enum e : enumSet) {
            assertTrue(Integer.parseInt(e.name().substring(1), 16) == e.ordinal());
        }
    }
}
