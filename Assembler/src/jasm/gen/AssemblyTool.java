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
package jasm.gen;

/**
 * @author Bernd Mathiske
 */
public abstract class AssemblyTool<Template_Type extends Template> {

    private final Assembly<Template_Type> _assembly;

    protected AssemblyTool(Assembly<Template_Type> assembly) {
        _assembly = assembly;
    }

    public Assembly<Template_Type> assembly() {
        return _assembly;
    }

}
