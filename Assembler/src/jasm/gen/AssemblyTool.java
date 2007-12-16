/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7b3d5ba7-0b41-4e33-bb0f-5bb1b384d42c*/
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
