/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=680dc262-0a16-467f-8f1c-2121ab61505c*/
package com.sun.max.program.option.gui;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.gui.SpringUtilities;
import com.sun.max.lang.Classes;
import com.sun.max.program.ProgramError;
import com.sun.max.program.ProgramWarning;
import com.sun.max.program.option.ProgramArgumentsParser;
import com.sun.max.program.option.ProgramOption;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * A dialog used to present the {@linkplain ProgramOption options} defined by a {@link ProgramArgumentsParser}.
 * This dialog will be used by a {@code ProgramArgumentParser} if the system property "useProgamOptionDialog"
 * is not null when any of the {@linkplain ProgramArgumentsParser#parse(String[], String, AppendableSequence) parse}
 * methods are called on the parser.
 *
 * @author Doug Simon
 */
public class ProgramOptionDialog extends JDialog {

    private String[] _commandLineArguments;

    /**
     * A panel that presents controls for loading/saving the options from/to a file.
     */
    static class OptionsFilePanel extends JPanel {

        private static boolean canLoadFrom(String path) {
            final File file = new File(path);
            return file.exists() && file.isFile() && file.canRead();
        }

        OptionsFilePanel(final String programName, final Sequence<ProgramOptionInput> programOptionInputs, final Collection<ProgramOptionInput> enabledProgramOptionInputs) {

            final File homeDirectory = new File(System.getProperty("user.home"));
            final JTextField path = new JTextField(ProgramOptionInput.TEXT_FIELD_COLUMNS);
            final JFileChooser fileChooser = new JFileChooser(homeDirectory);
            fileChooser.setFileHidingEnabled(false);

            final JButton load = new JButton(new AbstractAction("Load") {
                public void actionPerformed(ActionEvent e) {
                    try {
                        final FileInputStream fileInputStream = new FileInputStream(path.getText());
                        final Properties properties = new Properties();
                        properties.load(fileInputStream);
                        fileInputStream.close();

                        for (final Enumeration names = properties.propertyNames(); names.hasMoreElements();) {
                            final String name = (String) names.nextElement();
                            final String value = properties.getProperty(name);
                            for (ProgramOptionInput programOptionInput : programOptionInputs) {
                                if (programOptionInput.programOption().prefix().equals(name)) {
                                    programOptionInput.restoreFrom(value);
                                }
                            }
                        }
                    } catch (IOException ioe) {
                        ProgramWarning.message("Problem loading options from " + path.getText() + ": " + ioe);
                    }
                }
            });

            final JButton save = new JButton(new AbstractAction("Save") {
                public void actionPerformed(ActionEvent e) {
                    try {
                        final Properties properties = new Properties();
                        for (ProgramOptionInput programOptionInput : enabledProgramOptionInputs) {
                            properties.setProperty(programOptionInput.programOption().prefix(), programOptionInput.saveTo());
                        }
                        final FileOutputStream fileOutputStream = new FileOutputStream(path.getText());
                        properties.store(fileOutputStream, null);
                        fileOutputStream.close();
                    } catch (IOException ioe) {
                        ProgramWarning.message("Problem saving options to " + path.getText() + ": " + ioe);
                    }
                    load.setEnabled(canLoadFrom(path.getText()));
                }
            });

            path.getDocument().addDocumentListener(new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    load.setEnabled(canLoadFrom(path.getText()));
                }
                public void insertUpdate(DocumentEvent e) {
                    load.setEnabled(canLoadFrom(path.getText()));
                }
                public void removeUpdate(DocumentEvent e) {
                    load.setEnabled(canLoadFrom(path.getText()));
                }
            });


            path.setText(new File(homeDirectory, "." + programName + ".options").getAbsolutePath());

            final JButton fileChooserButton = new JButton(new AbstractAction("...") {
                public void actionPerformed(ActionEvent e) {
                    final File file = new File(path.getText());
                    if (file.exists() && file.isFile()) {
                        fileChooser.setCurrentDirectory(file.getParentFile());
                        fileChooser.setSelectedFile(file);
                        fileChooser.ensureFileIsVisible(file);
                    }
                    if (fileChooser.showDialog(OptionsFilePanel.this, "Select") == JFileChooser.APPROVE_OPTION) {
                        path.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    }
                }

            });

            setLayout(new FlowLayout(FlowLayout.LEADING));
            add(new JLabel("Persistent options file:"));
            add(path);
            add(fileChooserButton);
            add(load);
            add(save);
        }
    }


    private static ProgramOptionInput createProgramOptionInput(final ProgramOption programOption) {

        Class c = programOption.getClass();
        while (c != null) {
            final String inputClassName = new com.sun.max.program.option.gui.Package().name() + "." + c.getSimpleName() + "Input";
            try {
                final Class<?> inputClass = Class.forName(inputClassName);
                final Constructor<?> constructor = Classes.findConstructor(inputClass, programOption);
                if (constructor != null) {
                    return (ProgramOptionInput) constructor.newInstance(programOption);
                }
            } catch (IllegalArgumentException e) {
                ProgramError.unexpected(e);
            } catch (ClassNotFoundException e) {
                // Continue on with super class
                c = c.getSuperclass();
            } catch (InstantiationException e) {
                ProgramError.unexpected(e);
            } catch (IllegalAccessException e) {
                ProgramError.unexpected(e);
            } catch (InvocationTargetException e) {
                ProgramError.unexpected(e);
            }
        }
        ProgramWarning.message("Could not find GUI class corresponding to " + programOption.getClass().getName());
        return null;
    }

    private String[] asCommandLineArguments(Collection<ProgramOptionInput> programOptionInputs) {
        final AppendableSequence<String> commandLineArguments = new ArrayListSequence<String>();
        for (ProgramOptionInput<?> programOptionInput : programOptionInputs) {
            final String argument = programOptionInput.asCommandLineArgument();
            if (argument != null) {
                commandLineArguments.append(argument);
            }
        }
        return Sequence.Static.toArray(commandLineArguments, String.class);
    }

    public ProgramOptionDialog(JFrame owner, final ProgramArgumentsParser programArgumentsParser) {
        super(owner, "Options for " + programArgumentsParser.programName(), true);

        final AppendableSequence<ProgramOptionInput> programOptionInputs = new ArrayListSequence<ProgramOptionInput>();
        final Collection<ProgramOptionInput> enabledProgramOptionInputs = new LinkedHashSet<ProgramOptionInput>();

        final Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Configure panel for loading/saving options to a file
        final OptionsFilePanel optionsFilePanel = new OptionsFilePanel(programArgumentsParser.programName(), programOptionInputs, enabledProgramOptionInputs);
        contentPane.add(optionsFilePanel, BorderLayout.NORTH);

        // Configure panel of options
        final JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new SpringLayout());
        optionsPanel.setBorder(BorderFactory.createTitledBorder(""));

        for (final ProgramOption programOption : programArgumentsParser.programOptions()) {
            final ProgramOptionInput programOptionInput = createProgramOptionInput(programOption);
            if (programOptionInput != null) {
                programOptionInputs.append(programOptionInput);
                enabledProgramOptionInputs.add(programOptionInput);

                final JCheckBox enabled = new JCheckBox();
                final JLabel label = new JLabel(programOption.description());

                // All options are enabled by default
                enabled.setSelected(true);
                programOptionInput.setEnabled(true);

                enabled.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        final boolean isSelected = enabled.isSelected();
                        programOptionInput.setEnabled(isSelected);
                        label.setEnabled(isSelected);
                        if (isSelected) {
                            enabledProgramOptionInputs.add(programOptionInput);
                        } else {
                            enabledProgramOptionInputs.remove(programOptionInput);
                        }
                    }
                });

                if (!programOption.isMandatory()) {
                    enabled.setToolTipText("Select to enable this option. Disabled options are not processed by the argument parser.");
                } else {
                    enabled.setToolTipText("This option is mandatory.");
                    enabled.setEnabled(false);
                    enabled.setSelected(true);
                }

                label.setToolTipText(programOption.usage());

                optionsPanel.add(enabled);
                optionsPanel.add(label);
                optionsPanel.add(programOptionInput.inputComponent());
            }
        }

        SpringUtilities.makeCompactGrid(optionsPanel, programOptionInputs.length(), 3, 0, 0, 5, 5);
        contentPane.add(optionsPanel, BorderLayout.CENTER);

        // Configure buttons
        final JButton ok = new JButton(new AbstractAction("OK") {
            public void actionPerformed(ActionEvent e) {
                _commandLineArguments = asCommandLineArguments(enabledProgramOptionInputs);
                ProgramOptionDialog.this.setVisible(false);
            }
        });

        final JButton cancel = new JButton(new AbstractAction("Cancel") {
            public void actionPerformed(ActionEvent e) {
                ProgramOptionDialog.this.setVisible(false);
            }
        });

        ok.setToolTipText("Apply options as configured in this dialog and ignore the command line arguments.");
        cancel.setToolTipText("Ignore options as configured in this dialog and use the command line arguments instead.");

        final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cancel);
        buttonPanel.add(ok);

        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        pack();

        // Places dialog in the middle of the screen if 'owner == null'
        setLocationRelativeTo(owner);
    }

    public String[] commandLineArguments() {
        return _commandLineArguments;
    }

    public static String[] show(JFrame owner, ProgramArgumentsParser programArgumentsParser) {
        final ProgramOptionDialog programOptionDialog = new ProgramOptionDialog(owner, programArgumentsParser);
        programOptionDialog.setVisible(true);
        programOptionDialog.dispose();
        return programOptionDialog.commandLineArguments();
    }
}
