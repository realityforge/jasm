/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=59620cd0-4825-403f-9ad0-9d1ad0379bd8*/
package com.sun.max.program.option;

import com.sun.max.MaxPackage;
import com.sun.max.Scheme;
import com.sun.max.program.ProgramError;

/**
 * An assignment option that expects a package name for a value.
 *
 * @author Bernd Mathiske
 */
public abstract class PackageProgramOption<Package_Type extends MaxPackage> extends AssignmentProgramOption<Package_Type> {

    private final Class<Package_Type> _packageType;
    private final MaxPackage _superPackage;
    private final Class<? extends Scheme> _schemeType;

    protected PackageProgramOption(String prefix, String description, Class<Package_Type> packageType, Package_Type superPackage, Class<? extends Scheme> schemeType) {
        super(prefix, description);
        _packageType = packageType;
        _superPackage = superPackage;
        _schemeType = schemeType;
    }

    public MaxPackage superPackage() {
        return _superPackage;
    }

    public Class<Package_Type> packageType() {
        return _packageType;
    }

    public Class<? extends Scheme> schemeType() {
        return _schemeType;
    }

    @Override
    public String usage() {
        return prefix() + "=<package>";
    }

    private Package_Type cast(MaxPackage maxPackage) {
        if (!_packageType.isInstance(maxPackage)) {
            throw new ProgramError("package " + maxPackage + " is not of type " + _packageType.getCanonicalName());
        }
        return _packageType.cast(maxPackage);
    }

    @Override
    protected Package_Type scanValue(String value) {
        final MaxPackage result = MaxPackage.fromName(_superPackage.name() + "." + value);
        if (result != null) {
            return cast(result);
        }
        return cast(MaxPackage.fromName(value));
    }
}
