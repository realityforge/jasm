/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.sparc;

import jasm.AbstractSymbolicArgument;
import jasm.util.Symbolizer;

/**
 * The argument to the Write State Register and Read State Register instructions.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class StateRegister extends AbstractSymbolicArgument {

    StateRegister(int value) {
        super(value);
    }

    public static final class Writable extends StateRegister {
        private Writable(int value) {
            super(value);
        }
    }

    /**
     * @return true if this is the Y register or an Ancillary State register
     */
    public boolean isYorASR() {
        return this == Y || value() >= 16 && value() <= 31;
    }

    public static final Writable Y = new Writable(0);
    public static final Writable CCR = new Writable(2);
    public static final Writable ASI = new Writable(3);
    public static final StateRegister TICK = new StateRegister(4);
    public static final StateRegister PC = new StateRegister(5);
    public static final Writable FPRS = new Writable(6);
    public static final Writable ASR16 = new Writable(16);
    public static final Writable ASR17 = new Writable(17);
    public static final Writable ASR18 = new Writable(18);
    public static final Writable ASR19 = new Writable(19);
    public static final Writable ASR20 = new Writable(20);
    public static final Writable ASR21 = new Writable(21);
    public static final Writable ASR22 = new Writable(22);
    public static final Writable ASR23 = new Writable(23);
    public static final Writable ASR24 = new Writable(24);
    public static final Writable ASR25 = new Writable(25);
    public static final Writable ASR26 = new Writable(26);
    public static final Writable ASR27 = new Writable(27);
    public static final Writable ASR28 = new Writable(28);
    public static final Writable ASR29 = new Writable(29);
    public static final Writable ASR30 = new Writable(30);
    public static final Writable ASR31 = new Writable(31);

    public static final Symbolizer<StateRegister> SYMBOLIZER = Symbolizer.Static.initialize(StateRegister.class);
    public static final Symbolizer<Writable> WRITE_ONLY_SYMBOLIZER = Symbolizer.Static.initialize(StateRegister.class, Writable.class);
}
