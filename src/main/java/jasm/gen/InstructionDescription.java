/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

import jasm.gen.cisc.x86.X86InstructionDescriptionVisitor;
import jasm.gen.risc.RiscInstructionDescriptionVisitor;
import jasm.gen.risc.field.InputOperandField;
import jasm.WordWidth;
import jasm.util.program.ProgramError;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * A sequence of objects that describe group of closely related instructions. An
 * instruction template is created for each instruction in the group.
 * <p>
 * The types of objects that an instruction description contains
 * depend on the whether the underlying platform is CISC or RISC.
 * The types for these two instruction categories are enumerated by
 * the {@code visit...} methods in the {@link RiscInstructionDescriptionVisitor}
 * and {@link X86InstructionDescriptionVisitor} classes.
 *
 * @author Bernd Mathiske
 */
public abstract class InstructionDescription implements Iterable<Object>, Cloneable {

    private static int _nextSerial;

    private int _serial;

    /**
     * The components of the description.
     */
    private final List<Object> _specifications;

    public InstructionDescription(List<Object> specifications) {
        _specifications = specifications;
        _serial = _nextSerial++;
    }

    public final int serial() {
        return _serial;
    }

    /**
     * @return the objects from which this description is composed
     */
    public final List<Object> specifications() {
        return _specifications;
    }

    private List<InstructionConstraint> _constraints;

    /**
     * @return the {@link InstructionConstraint} instances (if any) within this description
     */
    public final List<InstructionConstraint> constraints() {
        if (_constraints == null) {
          final ArrayList<InstructionConstraint> result = new ArrayList<InstructionConstraint>();
          for (Object element : _specifications) {
            if (InstructionConstraint.class.isInstance(element)) {
              result.add(InstructionConstraint.class.cast(element));
            }
          }
          _constraints = result;
        }
        return _constraints;
    }

    private String _architectureManualSection;

    public final InstructionDescription setArchitectureManualSection(String section) {
        _architectureManualSection = section;
        return this;
    }

    public final String architectureManualSection() {
        return _architectureManualSection;
    }

    private String _externalName;

    public final String externalName() {
        return _externalName;
    }

    public final InstructionDescription setExternalName(String externalName) {
        _externalName = externalName;
        return this;
    }

    private boolean _isDisassemblable = true;

    /**
     * Determines if the templates created from the description can be recovered from an assembled instruction.
     * This is almost always possible. One example where it isn't is an instruction description that
     * has a parameter that is not correlated one-to-one with some bits in the encoded instruction.
     * In RISC architectures, this will be any instruction that has at least one {@link InputOperandField}
     * parameter.
     */
    public final boolean isDisassemblable() {
        return _isDisassemblable;
    }

    public final InstructionDescription beNotDisassemblable() {
        _isDisassemblable = false;
        return this;
    }

    public boolean isSynthetic() {
        return false;
    }

    private boolean _isExternallyTestable = true;

    public final boolean isExternallyTestable() {
        return _isExternallyTestable;
    }

    public final InstructionDescription beNotExternallyTestable() {
        _isExternallyTestable = false;
        return this;
    }

    private WordWidth _requiredAddressSize;

    public final WordWidth requiredAddressSize() {
        return _requiredAddressSize;
    }

    public final InstructionDescription requireAddressSize(WordWidth requiredAddressSize) {
        _requiredAddressSize = requiredAddressSize;
        return this;
    }

    private WordWidth _requiredOperandSize;

    public final WordWidth requiredOperandSize() {
        return _requiredOperandSize;
    }

    public final InstructionDescription requireOperandSize(WordWidth requiredOperandSize) {
        _requiredOperandSize = requiredOperandSize;
        return this;
    }

    public final Iterator<Object> iterator() {
        return _specifications.iterator();
    }

    @Override
    public final InstructionDescription clone() {
        try {
            final InstructionDescription clone = (InstructionDescription) super.clone();
            clone._serial = ++_nextSerial;
            return clone;
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            ProgramError.unexpected(cloneNotSupportedException);
        }
        return null;
    }

    @Override
    public final int hashCode() {
        return _serial;
    }

    @Override
    public final boolean equals(Object object) {
        if (object instanceof InstructionDescription) {
            return _serial == ((InstructionDescription) object)._serial;
        }
        return false;
    }
}
