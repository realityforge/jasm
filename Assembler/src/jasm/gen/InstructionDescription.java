/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6bb2987b-e8ef-4213-9d67-491c6e945f3f*/
package jasm.gen;

import com.sun.max.collect.MutableSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.program.ProgramError;
import jasm.gen.cisc.x86.X86InstructionDescriptionVisitor;
import jasm.gen.risc.RiscInstructionDescriptionVisitor;
import jasm.gen.risc.field.InputOperandField;
import jasm.util.WordWidth;
import java.util.Iterator;

/**
 * A sequence of objects that describe group of closely related instructions. An
 * {@link #Template instruction template} is created for each instruction in the
 * group.
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
    private final MutableSequence<Object> _specifications;

    public InstructionDescription(MutableSequence<Object> specifications) {
        _specifications = specifications;
        _serial = _nextSerial++;
    }

    public int serial() {
        return _serial;
    }

    /**
     * @return the objects from which this description is composed
     */
    public MutableSequence<Object> specifications() {
        return _specifications;
    }

    private Sequence<InstructionConstraint> _constraints;

    /**
     * @return the {@link InstructionConstraint} instances (if any) within this description
     */
    public Sequence<InstructionConstraint> constraints() {
        if (_constraints == null) {
            _constraints = Sequence.Static.filter(_specifications, InstructionConstraint.class);
        }
        return _constraints;
    }

    private String _architectureManualSection;

    public InstructionDescription setArchitectureManualSection(String section) {
        _architectureManualSection = section;
        return this;
    }

    public String architectureManualSection() {
        return _architectureManualSection;
    }

    private String _externalName;

    public String externalName() {
        return _externalName;
    }

    public InstructionDescription setExternalName(String externalName) {
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
    public boolean isDisassemblable() {
        return _isDisassemblable;
    }

    public InstructionDescription beNotDisassemblable() {
        _isDisassemblable = false;
        return this;
    }

    public boolean isSynthetic() {
        return false;
    }

    private boolean _isExternallyTestable = true;

    public boolean isExternallyTestable() {
        return _isExternallyTestable;
    }

    public InstructionDescription beNotExternallyTestable() {
        _isExternallyTestable = false;
        return this;
    }

    private WordWidth _requiredAddressSize;

    public WordWidth requiredAddressSize() {
        return _requiredAddressSize;
    }

    public InstructionDescription requireAddressSize(WordWidth requiredAddressSize) {
        _requiredAddressSize = requiredAddressSize;
        return this;
    }

    private WordWidth _requiredOperandSize;

    public WordWidth requiredOperandSize() {
        return _requiredOperandSize;
    }

    public InstructionDescription requireOperandSize(WordWidth requiredOperandSize) {
        _requiredOperandSize = requiredOperandSize;
        return this;
    }

    public Iterator<Object> iterator() {
        return _specifications.iterator();
    }

    @Override
    public InstructionDescription clone() {
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