/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=43a1b28f-058a-4394-890a-8f39336951c4*/
package test.jasm.ia32;

import jasm.gen.AssemblyTestComponent;
import jasm.gen.cisc.ia32.IA32AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.jasm.ExternalAssemblerTestCase;

/**
 * JUnit harness for testing the generated IA32 assembler against an external assembler.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class RawExternalTest extends ExternalAssemblerTestCase {
    public void test_assemble() throws IOException {
        run(new IA32AssemblyTester(EnumSet.of(AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }

}
