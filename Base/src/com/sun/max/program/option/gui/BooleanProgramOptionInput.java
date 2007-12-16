/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7622db3b-b1b8-436d-a4f2-4c2fec3ca6b0*/
package com.sun.max.program.option.gui;

import javax.swing.*;

import com.sun.max.program.option.*;

/**
 * The GUI class corresponding to {@link BooleanProgramOption}.
 *
 * @author Doug Simon
 */
class BooleanProgramOptionInput extends ProgramOptionInput<BooleanProgramOption> {

    private final JCheckBox _value;
    
    public BooleanProgramOptionInput(BooleanProgramOption programOption) {
        super(programOption);
        _value = new JCheckBox();
        _value.setSelected(programOption.value());
    }
    
    @Override
    public String asCommandLineArgument() {
        if (_value.isSelected()) {
            return programOption().prefix();
        }
        return null;
    }

    @Override
    protected JComponent inputComponent() {
        return _value;
    }

    @Override
    public void setEnabled(boolean enabled) {
        _value.setEnabled(enabled);
    }

    @Override
    public void restoreFrom(String value) {
        _value.setSelected(Boolean.valueOf(value));
    }

    @Override
    public String saveTo() {
        return "" + _value.isSelected();
    }
}
