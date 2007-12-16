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
package jasm.gen.risc;

import jasm.gen.risc.field.OptionField;

/**
 * An Option is one of the values that an {@link OptionField optional field} can take.
 * An example is the value of the <i>predict bit</i> for the SPARC Branch on Equal with
 * Prediction instruction that specifies the bit is set. The format of this instruction is:
 *
 *    bge_pt(...)  // assembler method
 *    bge,pt ...   // external assembler syntax
 *
 * @author Dave Ungar
 * @author Adam Spitz
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class Option {

    /**
     * The addition to the assembler method's name used to specify this option value.
     */
    protected final String _name;

    /**
     * The addition to the external assembler syntax used to specify this option value.
     */
    protected final String _externalName;

    /**
     * The value of the option.
     */
    protected final int _value;

    /**
     * The field to which this option applies.
     */
    private final OptionField _field;

    public String name() {
        return _name;
    }

    public String externalName() {
        return _externalName;
    }

    public int value() {
        return _value;
    }

    public Option() {
        this("");
    }

    public Option(String name) {
        this(name, 0);
    }

    public Option(String name, int value) {
        this(name, value, "");
    }

    public Option(String name, int value, String externalName) {
        this(name, value, externalName, null);
    }

    public Option(String name, int value, String externalName, OptionField field) {
        _name = name;
        _value = value;
        _externalName = externalName;
        _field = field;
    }

    public OptionField field() {
        return _field;
    }

    public boolean isRedundant() {
        return (_field.defaultOption() != null) && (_value == _field.defaultOption()._value) && (!(equals(_field.defaultOption())));
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Option && _name.equals(((Option) other)._name);
    }

    @Override
    public int hashCode() {
        return _name.hashCode();
    }
}
