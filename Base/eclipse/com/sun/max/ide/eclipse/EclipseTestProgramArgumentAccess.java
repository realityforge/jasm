/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=437e88d5-f3b9-43ce-bce4-c19b3fd42851*/
package com.sun.max.ide.eclipse;

import java.util.*;

import com.sun.max.annotate.*;
import com.sun.max.ide.*;

/**
 * @author Bernd Mathiske
 */
public final class EclipseTestProgramArgumentAccess implements TestProgramArgumentAccess {

    public EclipseTestProgramArgumentAccess() {
        super();
    }

    private static final String PROGRAM_ARGUMENTS_ENV_VARIABLE = "test.arguments";
    
    private static String[] split(String string) {
        String s = string;
        final List<String> result = new ArrayList<String>();
        if (s != null) {
            s = s.trim();
            while (true) {
                final int i = s.indexOf(' ');
                if (i < 0) {
                    result.add(s);
                    break;
                } 
                result.add(s.substring(0, i).trim());
                s = s.substring(i + 1);       
            }
        }
        return result.toArray(new String[result.size()]);
    }

    @Implement(TestProgramArgumentAccess.class)
    public String[] getProgramArguments() {
        return split(System.getenv(PROGRAM_ARGUMENTS_ENV_VARIABLE));
    }
}
