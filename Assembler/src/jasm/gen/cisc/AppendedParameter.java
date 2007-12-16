/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc;

import jasm.gen.Parameter;
import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public interface AppendedParameter extends Parameter {

    WordWidth width();

}
