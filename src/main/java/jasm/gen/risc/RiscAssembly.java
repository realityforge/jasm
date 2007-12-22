/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc;

import jasm.InstructionSet;
import jasm.dis.risc.OpcodeMaskGroup;
import jasm.dis.risc.SpecificityGroup;
import jasm.gen.Assembly;
import jasm.util.collect.IntHashMap;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public abstract class RiscAssembly<Template_Type extends RiscTemplate> extends Assembly<Template_Type> {

    protected RiscAssembly(InstructionSet instructionSet, Class<Template_Type> templateType) {
        super(instructionSet, templateType);
    }

    private ArrayList<SpecificityGroup<Template_Type>> _specificityGroups;

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
        _specificityGroups = new ArrayList<SpecificityGroup<Template_Type>>();
        for (int specificity = 33; specificity >= 0; specificity--) {
            final IntHashMap<OpcodeMaskGroup<Template_Type>> opcodeGroupTable = specificityTable.get(specificity);
            if (opcodeGroupTable != null) {
                final List<OpcodeMaskGroup<Template_Type>> opcodeMaskGroups = opcodeGroupTable.toList();
                final SpecificityGroup<Template_Type> specificityGroup = new SpecificityGroup<Template_Type>(specificity, opcodeMaskGroups);
                _specificityGroups.add(specificityGroup);
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

    public List<SpecificityGroup<Template_Type>> specificityGroups() {
        if (_specificityGroups == null) {
            initialize();
        }
        return _specificityGroups;
    }

}
