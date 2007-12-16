/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=519ffd11-07de-4cd5-868c-df3b45e257b6*/
package com.sun.max.program.option.gui;

import com.sun.max.program.option.IntegerProgramOption;
import java.text.NumberFormat;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

/**
 * The GUI class corresponding to {@link IntegerProgramOption}.
 *
 * @author Doug Simon
 */
class IntegerProgramOptionInput extends AssignmentProgramOptionInput<IntegerProgramOption> {

    private final JFormattedTextField _value;

    public IntegerProgramOptionInput(IntegerProgramOption programOption) {
        super(programOption);
        _value = new JFormattedTextField(NumberFormat.getNumberInstance());
        _value.setColumns(TEXT_FIELD_COLUMNS);
        final Integer value = programOption.value();
        if (value != null) {
            _value.setText(value.toString());
        }
    }


    @Override
    public String value() {
        if (_value.getText().length() == 0) {
            return null;
        }
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
        return _value.getText();
    }
}
