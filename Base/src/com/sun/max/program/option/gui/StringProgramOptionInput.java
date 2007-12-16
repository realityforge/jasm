/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=9e8dc196-52cd-4128-aabc-343f575f2c8a*/
package com.sun.max.program.option.gui;

import javax.swing.*;

import com.sun.max.program.option.*;

/**
 * The GUI class corresponding to {@link StringProgramOption}.
 *
 * @author Doug Simon
 */
class StringProgramOptionInput extends AssignmentProgramOptionInput<StringProgramOption> {

    private final JTextField _value;
    
    public StringProgramOptionInput(StringProgramOption programOption) {
        super(programOption);
        _value = new JTextField(TEXT_FIELD_COLUMNS);
        final String value = programOption.value();
        if (value != null) {
            _value.setText(value);
        }
    }
    

    @Override
    public String value() {
        return _value.getText();
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
        _value.setText(value);
    }

    @Override
    public String saveTo() {
        return value();
    }
}
