/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=2953c05d-70c7-4e45-a7ad-cde0ced73e86*/
package jasm.gen.risc;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.IntHashMap;
import com.sun.max.collect.Sequence;
import jasm.InstructionSet;
import jasm.dis.risc.OpcodeMaskGroup;
import jasm.dis.risc.SpecificityGroup;
import jasm.gen.Assembly;
import java.io.PrintStream;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public abstract class RiscAssembly<Template_Type extends RiscTemplate> extends Assembly<Template_Type> {

    protected RiscAssembly(InstructionSet instructionSet, Class<Template_Type> templateType) {
        super(instructionSet, templateType);
    }

    private AppendableSequence<SpecificityGroup<Template_Type>> _specificityGroups;

    private void initialize() {
        final IntHashMap<IntHashMap<OpcodeMaskGroup<Template_Type>>> specificityTable = new IntHashMap<IntHashMap<OpcodeMaskGroup<Template_Type>>>();
        for (Template_Type template : templates()) {
            if (!template.isRedundant()) {
                IntHashMap<OpcodeMaskGroup<Template_Type>> opcodeMaskGroups = specificityTable.get(template.specificity());
                if (opcodeMaskGroups == null) {
                    opcodeMaskGroups = new IntHashMap<OpcodeMaskGroup<Template_Type>>();
                    specificityTable.put(template.specificity(), opcodeMaskGroups);
                }
                final int opcodeMask = template.opcodeMask();
                OpcodeMaskGroup<Template_Type> opcodeMaskGroup = opcodeMaskGroups.get(opcodeMask);
                if (opcodeMaskGroup == null) {
                    opcodeMaskGroup = new OpcodeMaskGroup<Template_Type>(opcodeMask);
                    opcodeMaskGroups.put(opcodeMask, opcodeMaskGroup);
                }
                opcodeMaskGroup.add(template);
            }
        }
        _specificityGroups = new ArrayListSequence<SpecificityGroup<Template_Type>>();
        for (int specificity = 33; specificity >= 0; specificity--) {
            final IntHashMap<OpcodeMaskGroup<Template_Type>> opcodeGroupTable = specificityTable.get(specificity);
            if (opcodeGroupTable != null) {
                final Sequence<OpcodeMaskGroup<Template_Type>> opcodeMaskGroups = opcodeGroupTable.toSequence();
                final SpecificityGroup<Template_Type> specificityGroup = new SpecificityGroup<Template_Type>(specificity, opcodeMaskGroups);
                _specificityGroups.append(specificityGroup);
            }
        }
    }

    public void printSpecificityGroups(PrintStream out) {
        for (SpecificityGroup<Template_Type> specificityGroup : _specificityGroups) {
            out.println("Specificity group " + specificityGroup.specificity());
            for (OpcodeMaskGroup<Template_Type> opcodeMaskGroup : specificityGroup.opcodeMaskGroups()) {
                out.println("  Opcode mask group " + Integer.toBinaryString(opcodeMaskGroup.mask()));
                for (Template_Type template : opcodeMaskGroup.templates()) {
                    out.println("    " + template);
                }
            }
        }
    }

    public Sequence<SpecificityGroup<Template_Type>> specificityGroups() {
        if (_specificityGroups == null) {
            initialize();
        }
        return _specificityGroups;
    }

}
