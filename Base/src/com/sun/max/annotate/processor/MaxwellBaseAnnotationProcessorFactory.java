/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4be9c1ab-eaf8-4251-8c60-c17b635e1331*/
package com.sun.max.annotate.processor;

import java.util.*;

import com.sun.max.annotate.*;
import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;

/**
 * Factory for creating processors of annotations defined in the MaxwellBase project. 
 *
 * @author Doug Simon
 */
@AnnotationProcessorComponent
public class MaxwellBaseAnnotationProcessorFactory implements AnnotationProcessorFactory {

    @Implement(AnnotationProcessorFactory.class)
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> declarations, AnnotationProcessorEnvironment environment) {
        if (declarations.isEmpty()) {
            return AnnotationProcessors.NO_OP;
        }
        return new MaxwellBaseAnnotationProcessor(environment);
    }
    
    @Implement(AnnotationProcessorFactory.class)
    public Collection<String> supportedAnnotationTypes() {
        return Arrays.asList("com.sun.max.annotate.*");
    }

    @Implement(AnnotationProcessorFactory.class)
    public Collection<String> supportedOptions() {
        return Arrays.asList("-AreportToConsole", "-AreportToMessager", "reportAsWarning");
    }
}
