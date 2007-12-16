/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f63924d4-6f98-4cca-b27a-16200d740db0*/
package com.sun.max.program.option.gui;

import com.sun.max.MaxPackage;
import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.program.Classpath;
import com.sun.max.program.option.PackageProgramOption;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 * The GUI class corresponding to {@link PackageProgramOption}.
 *
 * @author Doug Simon
 */
class PackageProgramOptionInput extends AssignmentProgramOptionInput<PackageProgramOption<? extends MaxPackage>> {

    private final JComboBox _values;

    public PackageProgramOptionInput(PackageProgramOption<? extends MaxPackage> programOption) {
        super(programOption);

        final AppendableSequence<MaxPackage> maxPackages = new ArrayListSequence<MaxPackage>();
        for (MaxPackage maxPackage : programOption.superPackage().getTransitiveSubPackages(Classpath.fromSystem())) {
            if (programOption.packageType().isAssignableFrom(maxPackage.getClass())) {
                if (maxPackage.schemeTypeToImplementation(programOption.schemeType()) != null) {
                    maxPackages.append(maxPackage);
                }
            }
        }

        final MaxPackage[] values = Sequence.Static.toArray(maxPackages, MaxPackage.class);
        Arrays.sort(values, new Comparator<MaxPackage>() {
            public int compare(MaxPackage o1, MaxPackage o2) {
                return o1.name().compareTo(o2.name());
            }
        });

        _values = new JComboBox(values);

        // The combo box must be editable as the prepopulated items are just those packages found from the super package
        _values.setEditable(true);

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
        _values.setSelectedItem(value);
    }

    @Override
    public String saveTo() {
        return value();
    }
}
