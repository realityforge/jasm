/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc;

import com.sun.max.collect.MutableQueue;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.Strings;
import jasm.Argument;
import jasm.ExternalMnemonicSuffixArgument;
import jasm.dis.DisassembledLabel;
import jasm.dis.GlobalLabelMapper;
import jasm.gen.ImmediateArgument;
import jasm.gen.InstructionConstraint;
import jasm.gen.risc.field.BranchDisplacementOperandField;
import jasm.gen.risc.field.OperandField;
import jasm.gen.risc.field.RiscField;

/**
 * Output of RISC instructions in external assembler format
 * We use exactly the same syntax as Sun's SPARC assembler "as"
 * and GNU's assembler "gas", except for branches to detected labels.
 * In the latter case, the label's name followed by ":"
 * is printed instead of ".".
 *
 * Examples of branch instructions without labels:
 *
 *     brz,a  . +20
 *     bne    . -200
 *
 * Examples of branch instructions with detected labels:
 *
 *     ba     L1: +112
 *     be,pt  L2: -50
 *
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 * @author Greg Wright
 */
public abstract class RiscExternalInstruction implements RiscInstructionDescriptionVisitor {

    protected final RiscTemplate _template;
    protected final MutableQueue<Argument> _arguments;
    protected final int _offset;
    protected final Sequence<DisassembledLabel> _labels;
    protected final GlobalLabelMapper _globalLabelMapper;

    public RiscExternalInstruction(RiscTemplate template, Sequence<Argument> arguments) {
        _template = template;
        _arguments = MutableQueue.create(arguments);
        _offset = -1;
        _labels = Sequence.Static.empty(DisassembledLabel.class);
        _globalLabelMapper = null;
    }

    public RiscExternalInstruction(RiscTemplate template, Sequence<Argument> arguments, int offset, Sequence<DisassembledLabel> labels) {
        _template = template;
        _arguments = MutableQueue.create(arguments);
        _offset = offset;
        _labels = labels;
        _globalLabelMapper = null;
    }

    public RiscExternalInstruction(RiscTemplate template, Sequence<Argument> arguments, int offset, Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
        _template = template;
        _arguments = MutableQueue.create(arguments);
        _offset = offset;
        _labels = labels;
        _globalLabelMapper = globalLabelMapper;
    }

    private String _nameString;

    public String name() {
        if (_nameString == null) {
            _nameString = _template.externalName();
            for (Argument argument : _arguments) {
                if (argument instanceof ExternalMnemonicSuffixArgument) {
                  _nameString += argument.externalValue();
                }
            }
        }
        return _nameString;
    }

    private String _operandsString;

    public String operands() {
        if (_operandsString == null) {
            _operandsString = "";
            RiscInstructionDescriptionVisitor.Static.visitInstructionDescription(this, _template.instructionDescription());
        }
        return _operandsString;
    }

    @Override
    public String toString() {
        return Strings.padLengthWithSpaces(name(), 10) + "    " + operands();
    }

    private void print(String s) {
        _operandsString += s;
    }

    protected abstract boolean isAbsoluteBranch();

    /**
     * @return the symbol used to represent the value of the current location counter
     */
    protected String locationCounterSymbol() {
        return ".";
    }

    private void printBranchDisplacement(ImmediateArgument immediateArgument) {
        final int delta = (int) immediateArgument.asLong();
        if (_offset > 0) {
            final int targetOffset = _offset + delta;
            String globalName = null;
            if (_globalLabelMapper != null) {
                globalName = _globalLabelMapper.map(targetOffset);
            }
            if (globalName != null) {
                print(globalName + ": ");
            } else {
                for (DisassembledLabel label : _labels) {
                    if (label.offset() == targetOffset) {
                        print(label.name() + ": ");
                    }
                }
            }
        } else {
            if (!isAbsoluteBranch()) {
                print(locationCounterSymbol() + " ");
            }
        }
        if (delta >= 0) {
            print("+");
        }
        print(Integer.toString(delta));
    }

    private Object _previousSpecification;

    public void visitField(RiscField field) {
        if (field instanceof OperandField) {
            final OperandField operandField = (OperandField) field;
            if (operandField.boundTo() != null) {
                return;
            }
            final Argument argument = _arguments.remove();
            if (argument instanceof ExternalMnemonicSuffixArgument) {
                return;
            }
            if (_previousSpecification != null && !(_previousSpecification instanceof String)) {
                print(", ");
            }
            if (argument instanceof ImmediateArgument) {
                final ImmediateArgument immediateArgument = (ImmediateArgument) argument;
                if (field instanceof BranchDisplacementOperandField) {
                    printBranchDisplacement(immediateArgument);
                } else {
                    if (operandField.isSigned()) {
                        print(immediateArgument.signedExternalValue());
                    } else {
                        print(immediateArgument.externalValue());
                    }
                }
            } else {
                print(argument.externalValue());
            }
            _previousSpecification = field;
        }
    }

    public void visitConstant(RiscConstant constant) {
    }

    private boolean _writingStrings;

    public void visitString(String string) {
        if (_writingStrings) {
            print(string);
            _previousSpecification = string;
        }
        _writingStrings = true;
    }

    public void visitConstraint(InstructionConstraint constraint) {
    }

}
