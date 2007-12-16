/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=40c950ce-4842-4735-84ab-e408af4c58ae*/
package com.sun.max.program.option.gui;

import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import com.sun.max.annotate.*;
import com.sun.max.program.option.*;

/**
 * The GUI class corresponding to {@link FileProgramOption}.
 *
 * @author Doug Simon
 */
class FileProgramOptionInput extends AssignmentProgramOptionInput<FileProgramOption> {

    private final JTextField _value;
    private final JButton _fileChooserButton;
    private final JPanel _inputPanel;
    private JFileChooser _fileChooser;

    public FileProgramOptionInput(FileProgramOption programOption) {
        super(programOption);
        _value = new JTextField(TEXT_FIELD_COLUMNS);
        final File value = programOption.value();
        if (value != null) {
            _value.setText(value.getAbsolutePath());
        }
        _fileChooserButton = new JButton(new AbstractAction("...") {
            @Implement(Action.class)
            public void actionPerformed(ActionEvent e) {
                if (_fileChooser == null) {
                    _fileChooser = new JFileChooser(new File("."));
                    _fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                    _fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                }

                final File file = new File(_value.getText());
                final File parent = file.getParentFile();
                if (parent.isDirectory()) {
                    _fileChooser.setCurrentDirectory(parent);
                }
                if (file.isFile() || file.isDirectory()) {
                    if (file.exists()) {
                        _fileChooser.ensureFileIsVisible(file);
                        _fileChooser.setSelectedFile(file);
                    }
                }
                if (_fileChooser.showDialog(_fileChooserButton, "Select") == JFileChooser.APPROVE_OPTION) {
                    _value.setText(_fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
        _inputPanel = new JPanel();
        _inputPanel.add(_value);
        _inputPanel.add(_fileChooserButton);
    }


    @Override
    public String value() {
        return _value.getText();
    }

    @Override
    protected JComponent inputComponent() {
        return _inputPanel;
    }

    @Override
    public void setEnabled(boolean enabled) {
        _value.setEnabled(enabled);
        _fileChooserButton.setEnabled(enabled);
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
