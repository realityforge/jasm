/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.ArraySequence;
import com.sun.max.collect.MutableSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.Arrays;

/**
 * Wraps mere object arrays into instruction descriptions.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public abstract class InstructionDescriptionCreator<InstructionDescription_Type extends InstructionDescription> {

    private final Assembly _assembly;

    protected InstructionDescriptionCreator(Assembly assembly) {
        _assembly = assembly;
    }

    public Assembly assembly() {
        return _assembly;
    }

    protected abstract InstructionDescription_Type createInstructionDescription(MutableSequence<Object> specifications);

    protected InstructionDescription_Type defineInstructionDescription(MutableSequence<Object> specifications) {
        final InstructionDescription_Type instructionDescription = createInstructionDescription(specifications);
        _instructionDescriptions.append(instructionDescription);
        instructionDescription.setArchitectureManualSection(_currentArchitectureManualSection);
        return instructionDescription;
    }

    private final AppendableSequence<InstructionDescription_Type> _instructionDescriptions = new ArrayListSequence<InstructionDescription_Type>();

    protected InstructionDescription_Type define(Object... specifications) {
        return defineInstructionDescription(new ArraySequence<Object>(Arrays.flatten(specifications)));
    }

    private String _currentArchitectureManualSection;

    /**
     * Sets the name of the architecture manual section for which instruction descriptions are
     * currently being {@link #define defined}.
     */
    public void setCurrentArchitectureManualSection(String section) {
        _currentArchitectureManualSection = section;
    }

    public Sequence<InstructionDescription_Type> instructionDescriptions() {
        return _instructionDescriptions;
    }
}
