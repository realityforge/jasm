/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.program.option;

/**
 * A command line option that takes the form "option=value".
 *
 * @author Bernd Mathiske
 */
public abstract class AssignmentProgramOption<Value_Type> extends ValueProgramOption<Value_Type> {

    protected AssignmentProgramOption(String prefix, String usage) {
        super(prefix, usage);
    }

    protected Value_Type unassignedDefaultValue() {
        return null;
    }

    public final void update() {
        if (value() == null) {
            final Value_Type value = unassignedDefaultValue();
            if (value != null) {
                setValue(value);
            }
        }
    }

    protected Value_Type assignedDefaultValue() {
        return null;
    }

  /**
     * Transforms the argument passed to this option to its intended type for further use.
     *
     * @param string the raw form of the option argument
     * @return the transformed value representing to the option argument; 'null' if the transformation failed
     */
    protected abstract Value_Type scanValue(String string);

    @Override
    protected void parse(ProgramArgumentsParser parser) {
        final String option = parser.nextArgument();
        if (option.equals(prefix())) {
            final Value_Type value = assignedDefaultValue();
            if (value != null) {
                setValue(value);
                return;
            }
        } else {
            final String assignment = option.substring(prefix().length());
            if (assignment.charAt(0) == '=') {
                final String valueString = assignment.substring(1);
                final Value_Type value = scanValue(valueString);
                if (value != null) {
                    setValue(value);
                    return;
                }
                parser.usage("invalid value for program option: " + prefix());
            }
        }
        parser.usage("expected '=' after program option: " + prefix());
    }

}
