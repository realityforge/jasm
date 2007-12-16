/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ff991ed8-c1b1-47e6-91ff-1cfed3e09048*/
package com.sun.max.program.option.gui;

import com.sun.max.program.option.*;

/**
 * The GUI class corresponding to {@link AssignmentProgramOption}.
 *
 * @author Doug Simon
 */
public abstract class AssignmentProgramOptionInput<AssignmentProgramOption_Type extends AssignmentProgramOption> extends ProgramOptionInput<AssignmentProgramOption_Type> {
    protected AssignmentProgramOptionInput(AssignmentProgramOption_Type programOption) {
        super(programOption);
        programOption.update();
    }
    
    @Override
    public String asCommandLineArgument() {
        final String value = value();
        if (value == null) {
            return null;
        }
        return programOption().prefix() + "=" + value;
    }
    
    public abstract String value();
}
