/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=425ebed9-3c8c-4f9e-abac-34b47588605b*/
package jasm.gen.cisc;

import jasm.gen.Parameter;
import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public interface AppendedParameter extends Parameter {

    WordWidth width();

}
