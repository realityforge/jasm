/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

/**
 * This file is used to configure parameters for the entire framework.
 * It is deliberate that the fields are not final as otherwise code that
 * is guarded by booleans below could be removed by javac as dead code.
 * We want the code to exist so that the users of the system can choose
 * to enable the code without recompiling jasm.
 * 
 * <p>However, a production system will most likely replace this class
 * with a version that has final fields so that dead code can be removed.
 */
public final class Config {
  public static boolean ENABLE_CONSTRAINT_CHECKS = true;
}
