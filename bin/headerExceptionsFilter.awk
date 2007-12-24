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

# Licenses for external files and binary jars
/lib\// {next}

# IDEAs project files
/\.iml/ { next }

/LICENSE\.txt/ { next }
/CONTRIBUTORS\.txt/ { next }
/CHANGES\.txt/ { next }
/examples\/.*\/README\.txt/ { next }

# print everything else
{ print; }

