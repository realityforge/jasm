/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1611afbc-aa55-4cc9-b557-3f14dc14d1c2*/
package com.sun.max.asm.gen.cisc.x86;

import java.io.*;
import java.util.*;

import com.sun.max.asm.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.cisc.amd64.*;
import com.sun.max.collect.*;
import com.sun.max.io.*;
import com.sun.max.lang.*;
import com.sun.max.program.*;
import com.sun.max.program.option.*;

/**
 * @author Bernd Mathiske
 */
public abstract class X86AssemblerGenerator<Template_Type extends X86Template> extends AssemblerGenerator<Template_Type> {
    
    private final BooleanProgramOption _support16BitAddressesOption = new BooleanProgramOption("-a16", "enables 16 bit addressing");
    private final BooleanProgramOption _support16BitOffsetOption = new BooleanProgramOption("-d16", "enables 16 bit offsets");

    private final WordWidth _addressWidth;
    
    protected X86AssemblerGenerator(Assembly<Template_Type> assembly, WordWidth addressWidth, String[] programArguments) {
        super(assembly, true);
        _addressWidth = addressWidth;
        final ProgramArgumentsParser programArgumentsParser = new ProgramArgumentsParser(AMD64AssemblerGenerator.class.getSimpleName());
        programArgumentsParser.addProgramOption(new Trace());
        programArgumentsParser.addProgramOption(_support16BitAddressesOption);
        programArgumentsParser.parse(programArguments);
    }
    
    @Override
    public X86Assembly<Template_Type> assembly() {
        final Class<X86Assembly<Template_Type>> type = null;
        return StaticLoophole.cast(type, super.assembly());
    }
    
    public WordWidth addressWidth() {
        return _addressWidth;
    }
    
    @Override
    protected Class<? extends Assembler> endiannessSpecificAssemblerClass() {
        return LittleEndianAssembler.class;
    }

    @Override
    protected void generate() {
        if (_support16BitAddressesOption.value() != null && _support16BitAddressesOption.value()) {
            X86Assembly.support16BitAddresses();
        }
        if (_support16BitOffsetOption.value() != null && _support16BitOffsetOption.value()) {
            X86Assembly.support16BitOffsets();
        }
        super.generate();
    }
    
    protected X86Parameter getParameter(Template_Type template, Class parameterType) {
        for (X86Parameter parameter : template.parameters()) {
            if (parameter.type() == parameterType) {
                return parameter;
            }
        }
        ProgramError.unexpected("found no parameter of type: " + parameterType);
        return null;
    }

    private void printCallWithByteDisplacement(IndentWriter writer, Template_Type template, Class argumentType) {
        final Template_Type modVariantTemplate = X86Assembly.getModVariantTemplate(assembly().templates(), template, argumentType);
        final String subroutineName = makeSubroutine(modVariantTemplate);
        writer.print(subroutineName + "(");
        if (template.opcode2() != null) {
            writer.print(OPCODE2_VARIABLE_NAME);
        } else {
            writer.print(OPCODE1_VARIABLE_NAME);  
        }
        if (template.modRMGroupOpcode() != null) {
            writer.print(", " + MODRM_GROUP_OPCODE_VARIABLE_NAME);
        }
        for (X86Parameter parameter : template.parameters()) {
            if (parameter.type() == argumentType) {
                writer.print(", (byte) 0");
            }
            writer.print(", " + parameter.variableName());
        }
        writer.println(");");
    }
    
    protected String asIdentifier(EnumerableArgument argument) {
        return argument.getClass().getSimpleName() + "." + argument.name();
    }
    
    protected <Argument_Type extends Enum<Argument_Type> & EnumerableArgument<Argument_Type>> void printModVariant(IndentWriter writer,
                    final Template_Type template, Argument_Type... arguments) {
        final Class argumentType = arguments[0].getClass();
        final X86Parameter parameter = getParameter(template, argumentType);
        writer.print("if (");
        String separator = "";
        for (EnumerableArgument argument : arguments) {
            writer.print(separator + parameter.variableName() + " == " + asIdentifier(argument));
            separator = " || ";
        }
        writer.println(") {");
        writer.indent();
        printCallWithByteDisplacement(writer, template, argumentType);
        writer.println("return;");
        writer.outdent();
        writer.println("}");        
    }
    
    protected abstract void printModVariants(IndentWriter writer, Template_Type template);
        
    protected void printPrefixes(IndentWriter writer, Template_Type template) {
        if (template.addressSizeAttribute() != addressWidth()) {
            emitByte(writer, X86Opcode.ADDRESS_SIZE.byteValue());
            writer.println(" // address size prefix");
        }
        if (template.operandSizeAttribute() == WordWidth.BITS_16) {
            emitByte(writer, X86Opcode.OPERAND_SIZE.byteValue());
            writer.println(" // operand size prefix");
        }
        if (template.instructionSelectionPrefix() != null) {
            emitByte(writer, template.instructionSelectionPrefix().byteValue());
            writer.println(" // instruction selection prefix");            
        }
    }
    
    private void printOpcode(IndentWriter writer, Template_Type template, String opcodeVarName,
                             final ParameterPlace parameterPlace32, ParameterPlace parameterPlace64) {
        String comment = "";
        String opcodeVariableName = opcodeVarName;
        for (X86Parameter parameter : template.parameters()) {
            if (parameter.place() == parameterPlace32) {
                opcodeVariableName += " + " + parameter.valueString();
                comment = " // " + parameterPlace32.name().toLowerCase();                
            } else if (parameter.place() == parameterPlace64) {
                opcodeVariableName += " + (" + parameter.valueString() + "& 7)";
                comment = " // " + parameterPlace64.name().toLowerCase();
            }
        }
        if (comment.length() == 0) {
            emitByte(writer, opcodeVariableName);
            writer.println();            
        } else {
            emitByte(writer, "(byte) (" + opcodeVariableName + ")");
            writer.println(comment);
        }
    }
    
    private static final String MODRM_BYTE_VARIABLE_NAME = "modRMByte";
    
    private void printModRMByte(IndentWriter writer, Template_Type template) {
        writer.print("byte " + MODRM_BYTE_VARIABLE_NAME + " = (byte) ((" + template.modCase().ordinal() + " << " + X86Field.MOD.shift() + ")");
        if (template.modRMGroupOpcode() != null) {
            writer.print(" | (" + MODRM_GROUP_OPCODE_VARIABLE_NAME + " << " + X86Field.REG.shift() + ")");
        }                        
        writer.print("); // mod field");        
        if (template.modRMGroupOpcode() != null) {
            writer.print(", group opcode in reg field");
        }
        writer.println();
        switch (template.rmCase()) {
            case SIB:
            case SWORD:
            case SDWORD: {
                writer.println(MODRM_BYTE_VARIABLE_NAME + " |= " + template.rmCase().value() + " << " + X86Field.RM.shift() + "; // rm field");             
                break;
            }
            default:
                break;
        }
        for (X86Parameter parameter : template.parameters()) {
            switch (parameter.place()) {
                case MOD_REG:
                case MOD_REG_REXR: {
                    writer.println(MODRM_BYTE_VARIABLE_NAME + " |= (" + parameter.valueString() + " & 7) << " + X86Field.REG.shift() + "; // reg field"); 
                    break;
                }
                case MOD_RM:
                case MOD_RM_REXB: {
                    writer.println(MODRM_BYTE_VARIABLE_NAME + " |= (" + parameter.valueString() + " & 7) << " + X86Field.RM.shift() + "; // rm field"); 
                    break;
                }
                default:
                    break;
            }
        }
        emitByte(writer, MODRM_BYTE_VARIABLE_NAME);
        writer.println();
    }
    
    private static final String SIB_BYTE_NAME = "sibByte";
    
    private void printSibByte(IndentWriter writer, Template_Type template) {
        writer.print("byte " + SIB_BYTE_NAME + " = ");
        if (template.sibBaseCase() == X86TemplateContext.SibBaseCase.SPECIAL) {
            writer.println("(byte) (5 << " + X86Field.BASE.shift() + "); // base field");            
        } else {
            writer.println("(byte) 0;");                
        }
        for (X86Parameter parameter : template.parameters()) {
            switch (parameter.place()) {
                case SIB_BASE:
                case SIB_BASE_REXB:
                    writer.println(SIB_BYTE_NAME + " |= (" + parameter.valueString() + " & 7) << " + X86Field.BASE.shift() + "; // base field"); 
                    break;
                case SIB_INDEX:
                case SIB_INDEX_REXX:
                    writer.println(SIB_BYTE_NAME + " |= (" + parameter.valueString() + " & 7) << " + X86Field.INDEX.shift() + "; // index field"); 
                    break;
                case SIB_SCALE:
                    writer.println(SIB_BYTE_NAME + " |= " + parameter.valueString() + " << " + X86Field.SCALE.shift() + "; // scale field");                         
                    break;
                default:
                    break;
            }
        }
        emitByte(writer, SIB_BYTE_NAME);
        writer.println();
    }

    protected <Argument_Type extends Enum<Argument_Type> & EnumerableArgument<Argument_Type>>
    void printSibVariant(IndentWriter writer, Template_Type template, Argument_Type... arguments) {
        final Class argumentType = arguments[0].getClass();
        final X86Parameter parameter = getParameter(template, argumentType);
        writer.print("if (");
        String separator = "";
        for (EnumerableArgument argument : arguments) {
            writer.print(separator + parameter.variableName() + " == " + asIdentifier(argument));
            separator = " || ";
        }
        writer.println(") {");
        writer.indent();
        emitByte(writer, (byte) 0x24);
        writer.println(" // SIB byte");
        writer.outdent();
        writer.println("}");        
    }
    
    protected abstract void printSibVariants(IndentWriter writer, Template_Type template);
    
    private void printImmediateParameter(IndentWriter writer, X86NumericalParameter parameter) {
        if (parameter.width() == WordWidth.BITS_8) {
            emitByte(writer, parameter.variableName());                    
            writer.println(" // appended");
        } else {
            writer.println("// appended:");
            for (int i = 0; i < parameter.width().numberOfBytes(); i++) {
                if (i > 0) {
                    writer.println(parameter.variableName() + " >>= 8;");
                }
                emitByte(writer, "(byte) (" + parameter.variableName() + " & 0xff)");
                writer.println();
            }
        }        
    }

    private void printAppendedEnumerableParameter(IndentWriter writer, X86EnumerableParameter parameter) {
        emitByte(writer, "(byte) " + parameter.variableName() + ".value()");                    
        writer.println(" // appended");
    }

    private void printAppendedParameter(IndentWriter writer, Template_Type template) {
        for (X86Parameter parameter : template.parameters()) {
            if (parameter.place() == ParameterPlace.APPEND) {
                if (parameter instanceof X86NumericalParameter) {
                    printImmediateParameter(writer, (X86NumericalParameter) parameter);
                } else if (parameter instanceof X86EnumerableParameter) {
                    printAppendedEnumerableParameter(writer, (X86EnumerableParameter) parameter);
                } else {
                    ProgramError.unexpected("appended parameter of unexpected type: " + parameter);
                }
            }
        }
    }

    private int _subroutineSerial;
    
    private String createSubroutineName() {
        ++_subroutineSerial;
        String number = Integer.toString(_subroutineSerial);
        while (number.length() < 4) {
            number = "0" + number;
        }
        return "assemble" + number;
    }
    
    private Map<String, String> _subroutineToName = new HashMap<String, String>();

    private static final String OPCODE1_VARIABLE_NAME = "opcode1";
    private static final String OPCODE2_VARIABLE_NAME = "opcode2";
    private static final String MODRM_GROUP_OPCODE_VARIABLE_NAME = "modRmOpcode";
    
    private void printSubroutine(IndentWriter writer, Template_Type template) {
        writer.print("(byte ");
        if (template.opcode2() != null) {
            writer.print(OPCODE2_VARIABLE_NAME);
        } else {
            writer.print(OPCODE1_VARIABLE_NAME);            
        }
        if (template.modRMGroupOpcode() != null) {
            writer.print(", byte " + MODRM_GROUP_OPCODE_VARIABLE_NAME);
        }
        writer.print(formatParameterList(", ", template.parameters(), false));
        writer.println(") {");
        writer.indent();
        writer.indent();
        printModVariants(writer, template);
        printPrefixes(writer, template);
        if (template.opcode2() != null) {
            emitByte(writer, "(byte) (" + Bytes.toHexLiteral(template.opcode1().byteValue()) + ")");
            writer.println(" // " + OPCODE1_VARIABLE_NAME);
            printOpcode(writer, template, OPCODE2_VARIABLE_NAME, ParameterPlace.OPCODE2, ParameterPlace.OPCODE2_REXB);
        } else {
            printOpcode(writer, template, OPCODE1_VARIABLE_NAME, ParameterPlace.OPCODE1, ParameterPlace.OPCODE1_REXB);            
        }
        if (template.hasModRMByte()) {
            printModRMByte(writer, template);
            if (template.hasSibByte()) {
                printSibByte(writer, template);
            } else {
                printSibVariants(writer, template);
            }
        }
        printAppendedParameter(writer, template);
        writer.outdent();
        writer.println("}");        
        writer.outdent();
    }
    
    private String makeSubroutine(Template_Type template) {
        final StringWriter stringWriter = new StringWriter();
        printSubroutine(new IndentWriter(new PrintWriter(stringWriter)), template);
        final String subroutine = stringWriter.toString();
        String name = _subroutineToName.get(subroutine);
        if (name == null) {
            name = createSubroutineName();
            _subroutineToName.put(subroutine, name);
        }
        return name;
    }
    
    @Override
    protected int printMethod(IndentWriter writer, Template_Type template) {
        final int startLineCount = writer.lineCount();
        writer.print("public void ");
        writer.print(template.assemblerMethodName() + "(");   
        writer.print(formatParameterList("", template.parameters(), false));
        writer.println(") {");
        writer.indent();
        final String subroutineName = makeSubroutine(template);
        writer.print(subroutineName + "(");
        if (template.opcode2() != null) {
            writer.print("(byte) " + Bytes.toHexLiteral(template.opcode2().byteValue()));            
        } else {
            writer.print("(byte) " + Bytes.toHexLiteral(template.opcode1().byteValue()));
        }
        if (template.modRMGroupOpcode() != null) {
            writer.print(", (byte) " + Bytes.toHexLiteral(template.modRMGroupOpcode().byteValue()));
        }
        for (X86Parameter parameter : template.parameters()) {
            writer.print(", " + parameter.variableName());
        }
        writer.println(");");
        writer.outdent();
        writer.println("}");
        return writer.lineCount() - startLineCount;
    }

    @Override
    protected int printSubroutines(IndentWriter writer) {
        final Set<String> subroutineSet = _subroutineToName.keySet();
        final String[] subroutines = subroutineSet.toArray(new String[subroutineSet.size()]);
        for (int i = 0; i < subroutines.length; i++) {
            subroutines[i] = _subroutineToName.get(subroutines[i]) + subroutines[i];
        }
        java.util.Arrays.sort(subroutines);
        for (String subroutine : subroutines) {
            writer.print("private void " + subroutine);
            writer.println();
        }
        return subroutines.length;
    }

    private boolean parametersMatching(Template_Type candidate, Template_Type original) {
        if (candidate.parameters().length() != original.parameters().length()) {
            return false;
        }
        for (int i = 0; i < candidate.parameters().length(); i++) {
            if (i == original.labelParameterIndex()) {
                assert candidate.parameters().get(i).getClass() == X86OffsetParameter.class || candidate.parameters().get(i).getClass() == X86AddressParameter.class;
                assert candidate.parameters().get(i).getClass() == original.parameters().get(i).getClass();
            } else if (candidate.parameters().get(i).type() != original.parameters().get(i).type()) {
                return false;
            }
        }
        return true;
    }

    private final class LabelWidthCase {
        private final WordWidth _width;
        private final Template_Type _template;
        
        private LabelWidthCase(WordWidth width, Template_Type template) {
            _width = width;
            _template = template;
        }
    }
    
    private int getLabelWidthSequenceIndex(Sequence<LabelWidthCase> labelWidthCases) {
        final EnumSet<WordWidth> enumSet = EnumSet.noneOf(WordWidth.class);
        for (LabelWidthCase labelWidthCase : labelWidthCases) {
            enumSet.add(labelWidthCase._width);
        }
        return Enums.powerSequenceIndex(enumSet);
    }
    
    private Sequence<LabelWidthCase> getRelatedLabelTemplatesByWidth(Template_Type template, Sequence<Template_Type> labelTemplates) {
        final MutableSequence<LabelWidthCase> array = new ArraySequence<LabelWidthCase>(WordWidth.values().length);
        for (Template_Type t : labelTemplates) {
            if (t.assemblerMethodName().equals(template.assemblerMethodName()) && t.labelParameterIndex() == template.labelParameterIndex() &&
                    parametersMatching(t, template)) {
                final X86NumericalParameter numericalParameter = (X86NumericalParameter) t.parameters().get(template.labelParameterIndex());
                final WordWidth width = numericalParameter.width();                
                array.set(width.ordinal(), new LabelWidthCase(width, t));
                t._isLabelMethodWritten = true;
            }
        }
        // Report the found cases in the order of ascending width:
        final AppendableSequence<LabelWidthCase> result = new ArrayListSequence<LabelWidthCase>();
        for (int i = 0; i < array.length(); i++) {
            final LabelWidthCase labelWidthCase = array.get(i);
            if (labelWidthCase != null) {
                assert result.isEmpty() || labelWidthCase._width.greaterThan(result.last()._width);
                result.append(labelWidthCase);
            }
        }
        assert result.length() > 0;
        return result;
    }
        
    private void printOffsetLabelMethod(IndentWriter writer, Template_Type template, Sequence<Template_Type> labelTemplates) {
        Template_Type thisTemplate = template;
        final Sequence<Parameter> parameters = printLabelMethodHead(writer, thisTemplate);
        final Sequence<LabelWidthCase> labelWidthCases = getRelatedLabelTemplatesByWidth(thisTemplate, labelTemplates);
        thisTemplate = labelWidthCases.first()._template; // first use the template that will produce the least bytes
        writer.println("final int startOffset = currentOffset();");
        printInitialRawCall(writer, thisTemplate);
        writer.print("new " + LabelOffsetInstruction.class.getSimpleName());
        writer.println("(this, startOffset, currentOffset(), " + parameters.get(thisTemplate.labelParameterIndex()).variableName() + ", " + getLabelWidthSequenceIndex(labelWidthCases) + ") {");            
        writer.indent();
        writer.println("@Override");
        writer.println("protected int templateSerial() { return " + template.serial() + "; }");
        writer.println("@Override");
        writer.println("protected void assemble() throws AssemblyException {");
        writer.indent();
        if (labelWidthCases.length() == 1) {
            printRawCall(writer, thisTemplate, parameters);
        } else {
            writer.println("switch (labelWidth()) {");
            writer.indent();
            for (LabelWidthCase labelWidthCase : labelWidthCases) {
                writer.println("case " + labelWidthCase._width.name() + ": {");
                writer.indent();
                printRawCall(writer, labelWidthCase._template, parameters);                    
                writer.println("break;");
                writer.outdent(); 
                writer.println("}");
            }
            if (labelWidthCases.length() < WordWidth.values().length) {
                writer.println("default: {");
                writer.indent();
                writer.println("break;");
                writer.outdent();
                writer.println("}");                
            }
            writer.outdent();
            writer.println("}");
        }
        writer.outdent();
        writer.println("}");
        writer.outdent();
        writer.println("};");
        writer.outdent();
        writer.println("}");
        writer.println();
    }
    
    private void printAddressLabelMethod(IndentWriter writer, Template_Type template) {
        final Sequence<Parameter> parameters = printLabelMethodHead(writer, template);      
        template._isLabelMethodWritten = true;
        writer.println("final int startOffset = currentOffset();");
        printInitialRawCall(writer, template);
        writer.print("new " + LabelAddressInstruction.class.getSimpleName());
        writer.println("(this, startOffset, currentOffset(), " + parameters.get(template.labelParameterIndex()).variableName() + ") {");            
        writer.indent();
        writer.println("@Override");
        writer.println("protected int templateSerial() { return " + template.serial() + "; }");
        writer.println("@Override");
        writer.println("protected void assemble() throws AssemblyException {");
        writer.indent();
        printRawCall(writer, template, parameters);
        writer.outdent();
        writer.println("}");
        writer.outdent();
        writer.println("};");
        writer.outdent();
        writer.println("}");
        writer.println();        
    }    
    
    @Override
    protected int printLabelMethod(IndentWriter writer, Template_Type labelTemplate, Sequence<Template_Type> labelTemplates) {
        final int startLineCount = writer.lineCount();
        if (labelTemplate.addressSizeAttribute() == addressWidth()) {
            if (!labelTemplate._isLabelMethodWritten) {
                final X86Parameter parameter = labelTemplate.parameters().get(labelTemplate.labelParameterIndex());
                if (parameter instanceof X86OffsetParameter) {
                    printOffsetLabelMethod(writer, labelTemplate, labelTemplates);
                } else {
                    printAddressLabelMethod(writer, labelTemplate);
                }
            }
        }
        return writer.lineCount() - startLineCount;
    }
}
