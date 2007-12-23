#!/bin/bash
#
#  This file is part of the jasm project (http://code.google.com/p/jasm).
#
#  This file is licensed to you under the BSD License; You may not use
#  this file except in compliance with the License. See the LICENSE.txt
#  file distributed with this work for a copy of the License.
#
#  See the COPYRIGHT.txt file distributed with this work for information
#  regarding copyright ownership.
#

#
# Script to normalize svn properties, identify files missing a license etc.
#

export MY_FIND="find . -name .svn -prune -o -name manuals -prune -o -name generated -prune -o -name target -prune -o -name dist -prune -o -type f"

echo "Missing License Header:"
echo ""
$MY_FIND ! -exec grep -L "This file is licensed to you under the BSD License" {} \; | awk -f `dirname "$0"`/headerExceptionsFilter.awk
echo ""

echo "Fixing SVN properties."
for extension in .txt .xml .html .java; do
$MY_FIND -name "*$extension" -print | xargs svn -q propset svn:eol-style native
done

for extension in .txt .java; do
$MY_FIND -name "*$extension" -print | xargs svn -q propset svn:mime-type text/plain
done

$MY_FIND -name "*.xml" -print | xargs svn -q propset svn:mime-type text/xml
$MY_FIND -name "*.html" -print | xargs svn -q propset svn:mime-type text/html
echo ""
