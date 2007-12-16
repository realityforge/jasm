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
package com.sun.max.ide;

import com.sun.max.MaxPackage;
import java.io.IOException;

/**
 * @author Bernd Mathiske
 */
public final class ToolChain {

    private ToolChain() {
    }

    private static ToolChainScheme _toolChainScheme;

    private static ToolChainScheme toolChain() {
        if (_toolChainScheme == null) {
            final MaxPackage toolChainPackage = MaxPackage.fromName(IDE.current().idePackageName());
            _toolChainScheme = toolChainPackage.loadAndInstantiateScheme(ToolChainScheme.class);
        }
        return _toolChainScheme;
    }

    public static boolean compile(String className) throws IOException {
        return toolChain().compile(className);
    }

}
