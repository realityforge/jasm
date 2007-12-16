/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen;

import jasm.Argument;

/**
 * @author Bernd Mathiske
 */
public interface WrappableSpecification {

    TestArgumentExclusion excludeExternalTestArguments(Argument... arguments);

}
