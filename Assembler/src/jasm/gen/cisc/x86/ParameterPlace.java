/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=046acd74-5c99-4041-a95b-88c5d440c777*/
package jasm.gen.cisc.x86;

/**
 * The place/field into which the argument value passed to a parameter is to be assembled.
 *
 * @author Bernd Mathiske
 */
public enum ParameterPlace {

    MOD_REG("reg field of the modR/M byte"),
    MOD_REG_REXR("mod field extension by REX.R bit"),
    MOD_RM("rm field of the modR/M byte"),
    MOD_RM_REXB("rm field extension by REX.B bit"),
    SIB_SCALE("scale field of the SIB byte"),
    SIB_INDEX("index field of the SIB byte"),
    SIB_INDEX_REXX("SIB index field extension by REX.X bit"),
    SIB_BASE("base field of the SIB byte"),
    SIB_BASE_REXB("SIB base field extension by REX.B bit"),
    APPEND("appended to the instruction"),
    OPCODE1("added to the first opcode"),
    OPCODE1_REXB("opcode1 extension by REX.B bit"),
    OPCODE2("added to the second opcode"),
    OPCODE2_REXB("opcode2 extension by REX.B bit");

    private final String _comment;

    private ParameterPlace(String comment) {
        _comment = comment;
    }

    public String comment() {
        return _comment;
    }
}
