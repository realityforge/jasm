/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.risc.field;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.program.ProgramError;
import jasm.ExternalMnemonicSuffixArgument;
import jasm.SymbolicArgument;
import jasm.gen.risc.Option;
import jasm.gen.risc.RiscConstant;
import jasm.gen.risc.bitRange.BitRange;
import jasm.gen.risc.bitRange.BitRangeOrder;

/**
 * An OptionField is a field whose value is specified as an optional part of the assembler
 * mnemonic or assembler method name. The field has a default value if it is not specified.
 * An example of an optional field is the {@link jasm.gen.risc.sparc.SPARCFields#_p_option
 * predict bit} for the SPARC Branch on Equal with Prediction instruction:
 *
 *     bge        // predict that branch will be taken (default)
 *     bge,pt     // predict that branch will be taken
 *     bge,pn     // predict that branch will not be taken
 *
 * The definition of this field therefore has three {@link Option options}.
 *
 * @author Dave Ungar
 * @author Bernd Mathiske
 * @author Adam Spitz
 * @author Doug Simon
 */
public class OptionField extends RiscField {

    public OptionField(BitRange bitRange) {
        super(bitRange);
    }

    public static OptionField createAscending(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.ASCENDING);
        return new OptionField(bitRange);
    }

    public RiscConstant constant(int value) {
        return new RiscConstant(this, value);
    }

    protected Option _defaultOption;

    public Option defaultOption() {
        return _defaultOption;
    }

    protected AppendableSequence<Option> _options = new ArrayListSequence<Option>();

    public Iterable<Option> options() {
        return _options;
    }

    @Override
    public OptionField clone() {
        final OptionField result = (OptionField) super.clone();
        result._options = (AppendableSequence<Option>) _options.clone();
        return result;
    }

    /**
     * Creates a copy of this field that can take an additional value.
     *
     * @param name   addition to the assembler method's name used to specify the option value
     * @param value  the option value
     * @param externalName addition to the external assembler syntax used to specify the option value
     * @return the extended field
     */
    public OptionField withOption(String name, int value, String externalName) {
        final OptionField result = clone();
        final Option newOption = new Option(name, value, externalName, result);
        for (Option option : _options) {
            if (option.equals(newOption)) {
                throw new ProgramError("duplicate option: " + option);
            }
        }
        result._options.append(newOption);

        if (name.equals("")) {
            result._defaultOption = newOption;
        }
        return result;
    }

    /**
     * Creates a copy of this field that can take an additional value.
     *
     * @param name   addition to the assembler method's name used to specify the option value
     * @param value  the option value
     * @return the extended field
     */
    public OptionField withOption(String name, int value) {
        return withOption(name, value, name);
    }

    /**
     * Creates a copy of this field that can take an additional value.
     *
     * @param value  the option value
     * @return the extended field
     */
    public OptionField withOption(int value) {
        return withOption("", value);
    }

    /**
     * Creates a copy of this field that can take an additional value.
     *
     * @param name       addition to the assembler method's name used to specify the option value
     * @param argument   the option value represented as a symbol
     * @return the extended field
     */
    public OptionField withOption(String name, SymbolicArgument argument) {
        if (argument instanceof ExternalMnemonicSuffixArgument) {
            return withOption(name, argument.value(), argument.externalValue());
        }
        return withOption(name, argument.value());
    }
}
