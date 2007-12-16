/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
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
