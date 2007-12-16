/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package jasm.dis;

import com.sun.max.collect.ArraySequence;
import com.sun.max.collect.MutableSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.Endianness;
import com.sun.max.lang.Strings;
import com.sun.max.program.ProgramError;
import jasm.Argument;
import jasm.Assembler;
import jasm.AssemblyException;
import jasm.gen.Assembly;
import jasm.gen.ImmediateArgument;
import jasm.gen.OffsetParameter;
import jasm.gen.Parameter;
import jasm.gen.Template;
import jasm.util.WordWidth;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Disassemblers scan machine code, discern and decode individual instructions
 * and represent them in an abstract representation (DisassembledInstruction),
 * which they can then render in human-readable form, an assembly listing.
 *
 * @see DisassembledInstruction
 *
 * @author Bernd Mathiske
 * @author Greg Wright
 */
public abstract class Disassembler<Template_Type extends Template, DisassembledInstruction_Type extends DisassembledInstruction<Template_Type>> {

    private final Assembly<Template_Type> _assembly;
    private final WordWidth _addressWidth;
    private final Endianness _endianness;

    protected Disassembler(Assembly<Template_Type> assembly, WordWidth addressWidth, Endianness endianness) {
        super();
        _assembly = assembly;
        _addressWidth = addressWidth;
        _endianness = endianness;
    }

    public Assembly<Template_Type> assembly() {
        return _assembly;
    }

    public WordWidth addressWidth() {
        return _addressWidth;
    }

    public Endianness endianness() {
        return _endianness;
    }

    protected abstract DisassembledInstruction_Type createDisassembledInstruction(int offset, byte[] bytes, Template_Type template, Sequence<Argument> arguments);

    protected abstract Assembler createAssembler(int offset);

    /**
     * Scans an instruction stream and disassembles the first encoded instruction.
     * <p>
     * @return the disassembled forms that match the first encoded instruction in {@code stream}
     */
    public abstract Sequence<DisassembledInstruction_Type> scanOneInstruction(BufferedInputStream stream) throws IOException, AssemblyException;

    /**
     * Scans an instruction stream and disassembles the encoded instructions. If an encoded instruction has
     * more than one matching disassembled form, an abitrary choice of one of the disassembled forms is
     * appended to the returned sequence.
     * <p>
     * The {@link #scanOneInstruction} method can be used to obtain all the disassembled forms
     * for each instruction in an instruction stream.
     */
    public abstract Sequence<DisassembledInstruction_Type> scan(BufferedInputStream stream) throws IOException, AssemblyException;

    private int findTargetInstructionIndex(int offset, Sequence<DisassembledInstruction_Type> disassembledInstructions) {
        if (offset >= 0 && offset <= disassembledInstructions.last().startOffset()) {
            for (int i = 0; i < disassembledInstructions.length(); i++) {
                if (disassembledInstructions.get(i).startOffset() == offset) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * A label map is a sequence of labels that matches a sequence of disassembled instructions,
     * containing either a label or null at the index of each instruction.
     */
    public Sequence<DisassembledLabel> createLabelMap(Sequence<DisassembledInstruction_Type> disassembledInstructions) {
        final MutableSequence<DisassembledLabel> labels = new ArraySequence<DisassembledLabel>(disassembledInstructions.length());
        for (DisassembledInstruction_Type disassembledInstruction : disassembledInstructions) {
            final Template_Type template = disassembledInstruction.template();
            final int parameterIndex = template.labelParameterIndex();
            if (parameterIndex >= 0) {
                final ImmediateArgument immediateArgument = (ImmediateArgument) disassembledInstruction.arguments().get(parameterIndex);
                final Parameter parameter = template.parameters().get(parameterIndex);
                final int offset = (parameter instanceof OffsetParameter) ?
                                (int) immediateArgument.asLong() + disassembledInstruction.offsetForRelativeAddressing() :
                                disassembledInstruction.addressToOffset(immediateArgument);
                final int targetInstructionIndex = findTargetInstructionIndex(offset, disassembledInstructions);
                if (targetInstructionIndex >= 0 && labels.get(targetInstructionIndex) == null) {
                    labels.set(targetInstructionIndex, new DisassembledLabel(targetInstructionIndex));
                }
            }
        }
        return labels;
    }

    /**
     * Assigns serial numbers to these labels and calculates the maximum number of chars needed to print any one of these labels.
     */
    public int updateLabels(Sequence<DisassembledLabel> labels, Sequence<DisassembledInstruction_Type> disassembledInstructions) {
        int result = 0;
        int serial = 1;
        for (DisassembledLabel label : labels) {
            label.setSerial(serial);
            serial++;
            label.bind(disassembledInstructions.get(label.instructionIndex()).startOffset());
            if (label.name().length() > result) {
                result = label.name().length();
            }
        }
        return result;
    }

    private static final String SPACE = "   ";
    private static final int NUMBER_OF_INSTRUCTION_CHARS = 48;

    private void printHeading(PrintStream stream, int nOffsetChars, int nLabelChars)  {
        String s = Strings.padLengthWithSpaces("Address", (addressWidth().numberOfBytes() * 2) + 2) + SPACE;
        s += Strings.padLengthWithSpaces("+", nOffsetChars) + SPACE;
        s += Strings.padLengthWithSpaces(":", nLabelChars + 1) + SPACE;
        s += Strings.padLengthWithSpaces("Instruction", NUMBER_OF_INSTRUCTION_CHARS) + SPACE;
        s += "Bytes";
        stream.println(s);
        stream.println(Strings.times('-', s.length()));
    }

    private boolean _isHeadingEnabled;

    public void enableHeading() {
        _isHeadingEnabled = true;
    }

    public void disableHeading() {
        _isHeadingEnabled = false;
    }

    public void print(OutputStream outputStream, Sequence<DisassembledInstruction_Type> disassembledInstructions, GlobalLabelMapper globalLabelMapper) throws IOException {
        final PrintStream stream = new PrintStream(outputStream);
        final int nOffsetChars = Integer.toString(disassembledInstructions.last().startOffset()).length();
        final Sequence<DisassembledLabel> labelMap = createLabelMap(disassembledInstructions);
        final Sequence<DisassembledLabel> labels = Sequence.Static.filterNonNull(labelMap);
        final int nLabelChars = updateLabels(labels, disassembledInstructions);
        if (_isHeadingEnabled) {
            printHeading(stream, nOffsetChars, nLabelChars);
        }
        for (int i = 0; i < disassembledInstructions.length(); i++) {
            final DisassembledInstruction_Type disassembledInstruction = disassembledInstructions.get(i);
            stream.print(disassembledInstruction.addressString());
            stream.print(SPACE);
            stream.printf("%0" + nOffsetChars + "d", disassembledInstruction.startOffset());
            stream.print(SPACE);
            if (labelMap.get(i) != null) {
                stream.print(Strings.padLengthWithSpaces(labelMap.get(i).name(), nLabelChars) + ":");
            } else {
                stream.print(Strings.spaces(nLabelChars) + " ");
            }
            stream.print(SPACE);
            stream.print(Strings.padLengthWithSpaces(disassembledInstruction.toString(labels, globalLabelMapper), NUMBER_OF_INSTRUCTION_CHARS));
            stream.print(SPACE);
            stream.print(DisassembledInstruction.toHexString(disassembledInstruction.bytes()));
            stream.println();
        }
    }

    public void print(OutputStream outputStream, Sequence<DisassembledInstruction_Type> disassembledInstructions) throws IOException {
        print(outputStream, disassembledInstructions, null);
    }

    public void scanAndPrint(BufferedInputStream bufferedInputStream, OutputStream outputStream, GlobalLabelMapper globalLabelMapper) throws IOException, AssemblyException {
        final Sequence<DisassembledInstruction_Type> disassembledInstructions = scan(bufferedInputStream);
        print(outputStream, disassembledInstructions, globalLabelMapper);
    }

    public void scanAndPrint(BufferedInputStream bufferedInputStream, OutputStream outputStream) throws IOException, AssemblyException {
        scanAndPrint(bufferedInputStream, outputStream, null);
    }

    public enum AbstractionPreference {
        RAW, SYNTHETIC;
    }

    private AbstractionPreference _abstractionPreference = AbstractionPreference.SYNTHETIC;

    protected AbstractionPreference abstractionPreference() {
        return _abstractionPreference;
    }

    public void setAbstractionPreference(AbstractionPreference abstractionPreference) {
        _abstractionPreference = abstractionPreference;
    }

    private int _expectedNumberOfArguments = -1;

    protected int expectedNumberOfArguments() {
        return _expectedNumberOfArguments;
    }

    public void setExpectedNumberOfArguments(int expectedNumberOfArguments) {
        _expectedNumberOfArguments = expectedNumberOfArguments;
    }

    /**
     * @return the offset in the instruction stream at the given offset from the given instruction
     */
    public long getRelativeOffsetFromInstruction(DisassembledInstruction_Type disassembledInstruction, long offset) {
        switch (assembly().instructionSet().relativeAddressing()) {
            case FROM_INSTRUCTION_START:
                return disassembledInstruction.startOffset() + offset;
            case FROM_INSTRUCTION_END:
                return disassembledInstruction.endOffset() + offset;
        }
        ProgramError.unknownCase();
        return 0;
    }
}
