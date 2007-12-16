/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b71d6b2c-b088-4150-bd89-b299e0b272c7*/
package test.com.sun.max.asm.amd64;

import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.gen.cisc.amd64.AMD64AssemblyTester;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumSet;
import test.com.sun.max.asm.ExternalAssemblerTestCase;

/**
 * JUnit harness for testing the generated AMD64 assembler against an external assembler.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class RawExternalTest extends ExternalAssemblerTestCase {
  public void test_assemble() throws FileNotFoundException, IOException {
    run(new AMD64AssemblyTester(EnumSet.of(AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
  }
}
