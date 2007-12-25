/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.field;

import jasm.ExternalMnemonicSuffixArgument;
import jasm.SymbolicArgument;
import jasm.tools.risc.Option;
import jasm.tools.risc.RiscConstant;
import jasm.tools.risc.bitRange.BitRange;
import jasm.tools.risc.bitRange.BitRangeOrder;
import jasm.util.StaticLoophole;
import java.util.ArrayList;

/**
 * An OptionField is a field whose value is specified as an optional part of the assembler
 * mnemonic or assembler method name. The field has a default value if it is not specified.
 * An example of an optional field is the {@link jasm.tools.risc.sparc.SPARCFields#p predict bit}
 * for the SPARC Branch on Equal with Prediction instruction:
 *
 *     bge        // predict that branch will be taken (default)
 *     bge,pt     // predict that branch will be taken
 *     bge,pn     // predict that branch will not be taken
 *
 * The definition of this field therefore has three {@link Option options}.
 */
public final class OptionField extends RiscField {

    public OptionField(BitRange bitRange) {
        super(bitRange);
    }

    public static OptionField createAscending(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.ASCENDING);
        return new OptionField(bitRange);
    }

    public final RiscConstant constant(int value) {
        return new RiscConstant(this, value);
    }

    protected Option _defaultOption;

    public final Option defaultOption() {
        return _defaultOption;
    }

    protected ArrayList<Option> _options = new ArrayList<Option>();

    public final Iterable<Option> options() {
        return _options;
    }

    @Override
    public final OptionField clone() {
        final OptionField result = (OptionField) super.clone();
        result._options = StaticLoophole.cast(_options.clone());
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
    public final OptionField withOption(String name, int value, String externalName) {
        final OptionField result = clone();
        final Option newOption = new Option(name, value, externalName, result);
        for (Option option : _options) {
            if (option.equals(newOption)) {
                throw new IllegalStateException("duplicate option: " + option);
            }
        }
        result._options.add(newOption);

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
    public final OptionField withOption(String name, int value) {
        return withOption(name, value, name);
    }

  /**
     * Creates a copy of this field that can take an additional value.
     *
     * @param name       addition to the assembler method's name used to specify the option value
     * @param argument   the option value represented as a symbol
     * @return the extended field
     */
    public final OptionField withOption(String name, SymbolicArgument argument) {
        if (argument instanceof ExternalMnemonicSuffixArgument) {
            return withOption(name, argument.value(), argument.externalValue());
        }
        return withOption(name, argument.value());
    }
}
