/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=edefff78-cd4b-4022-87a9-1df67f355b77*/
package com.sun.max.program.option.gui;

import java.awt.*;

import javax.swing.*;

import com.sun.max.program.option.*;

/**
 * The root class in a hierarchy of GUI classes mirroring the {@link ProgramOption} class hierachy.
 *
 * @author Doug Simon
 */
abstract class ProgramOptionInput<ProgramOption_Type extends ProgramOption> {

    public static final int TEXT_FIELD_COLUMNS = 50;

    private final ProgramOption_Type _programOption;

    protected ProgramOptionInput(ProgramOption_Type programOption) {
        _programOption = programOption;
    }

    public ProgramOption_Type programOption() {
        return _programOption;
    }

    /**
     * Gets the argument that will be added to the command line representing this state of this option.
     *
     * @return null if the state of this option does not add a command line argument
     * @see ProgramOption#asCommandLineArgument()
     */
    public abstract String asCommandLineArgument();

    /**
     * Gets the component used to get the user's input. This may be a {@linkplain Container container}.
     */
    protected abstract JComponent inputComponent();

    /**
     * Called when this option's enabled state changes.
     *
     * @param enabled the new state
     */
    protected abstract void setEnabled(boolean enabled);
    
    public abstract void restoreFrom(String value);
    public abstract String saveTo();
}
