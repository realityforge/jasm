/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1b5e687b-dc13-4007-8ca2-a10129ff77c0*/
package com.sun.max.program.option.gui;

import javax.swing.*;

import com.sun.max.program.option.*;

/**
 * The GUI class corresponding to {@link EnumProgramOption}.
 *
 * @author Doug Simon
 */
class EnumProgramOptionInput extends AssignmentProgramOptionInput<EnumProgramOption> {

    private final JComboBox _values;
    
    public EnumProgramOptionInput(EnumProgramOption programOption) {
        super(programOption);
        _values = new JComboBox(programOption.values());
        _values.setSelectedItem(programOption.value());
    }
    

    @Override
    public String value() {
        return _values.getSelectedItem().toString();
    }

    @Override
    protected JComponent inputComponent() {
        return _values;
    }

    @Override
    public void setEnabled(boolean enabled) {
        _values.setEnabled(enabled);
    }


    @Override
    public void restoreFrom(String value) {
        for (Enum enumValue : programOption().values()) {
            if (enumValue.toString().equals(value)) {
                _values.setSelectedItem(enumValue);
            }
        }
    }

    @Override
    public String saveTo() {
        return value();
    }
}
