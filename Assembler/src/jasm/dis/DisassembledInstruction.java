/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=fe70dae4-a119-4686-b750-d53d4b2f29e8*/
package jasm.dis;

import com.sun.max.collect.Sequence;
import jasm.Argument;
import jasm.AssemblyInstruction;
import jasm.gen.ImmediateArgument;
import jasm.gen.Template;

/**
 * A assembly instruction in internal format, combined with the bytes that it was disassembled from.
 *
 * @author Dave Ungar
 * @author Adam Spitz
 * @author Bernd Mathiske
 * @author Greg Wright
 */
public abstract class DisassembledInstruction<Template_Type extends Template> implements AssemblyInstruction, AddressInstruction {

    private final int _startOffset;
    private final byte[] _bytes;
    private final Template_Type _template;
    private final Sequence<Argument> _arguments;

    protected DisassembledInstruction(int offset, byte[] bytes, Template_Type template, Sequence<Argument> arguments) {
        _startOffset = offset;
        _bytes = bytes;
        _template = template;
        _arguments = arguments;
    }

    public int startOffset() {
        return _startOffset;
    }

    public int endOffset() {
        return _startOffset + _bytes.length;
    }

    public byte[] bytes() {
        return _bytes.clone();
    }

    public Template_Type template() {
        return _template;
    }

    public Sequence<Argument> arguments() {
        return _arguments;
    }

    public static String toHexString(byte[] bytes) {
        String result = "[";
        String separator = "";
        for (byte b : bytes) {
            result += separator + String.format("%02X", b);
            separator = " ";
        }
        result += "]";
        return result;
    }

    protected DisassembledLabel instructionOffsetToLabel(int instructionOffset, Sequence<DisassembledLabel> labels) {
        for (DisassembledLabel label : labels) {
            if (label.offset() == instructionOffset) {
                return label;
            }
        }
        return null;
    }

    protected DisassembledLabel offsetArgumentToLabel(ImmediateArgument argument, Sequence<DisassembledLabel> labels) {
        final int argumentOffset = (int) argument.asLong();
        final int targetOffset = argumentOffset + offsetForRelativeAddressing();
        return instructionOffsetToLabel(targetOffset, labels);
    }

    protected DisassembledLabel addressArgumentToLabel(ImmediateArgument argument, Sequence<DisassembledLabel> labels) {
        final long targetOffset = addressToOffset(argument);
        if (targetOffset < 0) {
            return null;
        }
        return instructionOffsetToLabel((int) targetOffset, labels);
    }

    public abstract String toString(Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper);

    public String toString(Sequence<DisassembledLabel> labels) {
        return toString(labels, null);
    }

    public abstract String externalName();

    public abstract String operandsToString(Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper);

    public String operandsToString(Sequence<DisassembledLabel> labels) {
        return operandsToString(labels, null);
    }

    public abstract int offsetForRelativeAddressing();

    /*
     * Return the byte array encoding this instruction.
     */
    protected byte[] rawInstruction() {
        return _bytes;
    }

}
