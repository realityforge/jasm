/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc;

import static jasm.tools.risc.sparc.SPARCFields.bits_29_27;
import static jasm.tools.risc.sparc.SPARCFields.dfrd;
import static jasm.tools.risc.sparc.SPARCFields.dfrs1;
import static jasm.tools.risc.sparc.SPARCFields.dfrs2;
import static jasm.tools.risc.sparc.SPARCFields.fcc_26_25;
import static jasm.tools.risc.sparc.SPARCFields.op;
import static jasm.tools.risc.sparc.SPARCFields.op3;
import static jasm.tools.risc.sparc.SPARCFields.opf;
import static jasm.tools.risc.sparc.SPARCFields.qfrd;
import static jasm.tools.risc.sparc.SPARCFields.qfrs1;
import static jasm.tools.risc.sparc.SPARCFields.qfrs2;
import static jasm.tools.risc.sparc.SPARCFields.res_18_14;
import static jasm.tools.risc.sparc.SPARCFields.sfrd;
import static jasm.tools.risc.sparc.SPARCFields.sfrs1;
import static jasm.tools.risc.sparc.SPARCFields.sfrs2;

public final class FloatingPointOperate extends SPARCInstructionDescriptionCreator {

  private void createCompare(String name, String type, Object frs1Field, Object frs2Field, int opfContents) {
    define("f" + name + type, op(0x2), bits_29_27(0), fcc_26_25, op3(0x35), frs1Field, frs2Field, opf(opfContents));
  }

  private void createBinaryArithmetic(String name, String type, Object[] head, Object frs1Field, Object frs2Field,
                                      final Object frdField, int opfContents) {
    define("f" + name + type, head, opf(opfContents), frs1Field, frs2Field, frdField);
  }

  private void createToX(String type, Object[] head, Object frs2Field, int opfContents) {
    define("f" + type + "tox", head, opf(opfContents), frs2Field, dfrd);
  }

  private void createToI(String type, Object[] head, Object frs2Field, int opfContents) {
    define("f" + type + "toi", head, opf(opfContents), frs2Field, sfrd);
  }

  private void createFromTo(String fromType, String toType, Object[] head, Object frs2Field, Object frdField, int opfContents) {
    define("f" + fromType + "to" + toType, head, opf(opfContents), frs2Field, frdField);
  }

  private void createXorITo(String type, Object[] head, Object frdField, int opfContents) {
    define("fxto" + type, head, opf(opfContents | 0x80), dfrs2, frdField);
    define("fito" + type, head, opf(opfContents | 0xc0), sfrs2, frdField);
  }

  private void createUnaryArithmetic(String name, String type, Object[] head, Object frs2Field, Object frdField, int opfContents) {
    define("f" + name + type, head, opf(opfContents), frs2Field, frdField);
  }

  private void create_A12(Object[] head) {
    createBinaryArithmetic("add", "s", head, sfrs1, sfrs2, sfrd, 0x41);
    createBinaryArithmetic("add", "d", head, dfrs1, dfrs2, dfrd, 0x42);
    createBinaryArithmetic("add", "q", head, qfrs1, qfrs2, qfrd, 0x43);
    createBinaryArithmetic("sub", "s", head, sfrs1, sfrs2, sfrd, 0x45);
    createBinaryArithmetic("sub", "d", head, dfrs1, dfrs2, dfrd, 0x46);
    createBinaryArithmetic("sub", "q", head, qfrs1, qfrs2, qfrd, 0x47);
  }

  private void create_A13() {
    createCompare("cmp", "s", sfrs1, sfrs2, 0x51);
    createCompare("cmp", "d", dfrs1, dfrs2, 0x52);
    createCompare("cmp", "q", qfrs1, qfrs2, 0x53);
    createCompare("cmpe", "s", sfrs1, sfrs2, 0x55);
    createCompare("cmpe", "d", dfrs1, dfrs2, 0x56);
    createCompare("cmpe", "q", qfrs1, qfrs2, 0x57);
  }

  private void create_A14(Object[] head) {
    createToX("s", head, sfrs2, 0x81);
    createToX("d", head, dfrs2, 0x82);
    createToX("q", head, qfrs2, 0x83);
    createToI("s", head, sfrs2, 0xd1);
    createToI("d", head, dfrs2, 0xd2);
    createToI("q", head, qfrs2, 0xd3);
  }

  private void create_A15(Object[] head) {
    createFromTo("s", "d", head, sfrs2, dfrd, 0xc9);
    createFromTo("s", "q", head, sfrs2, qfrd, 0xcd);
    createFromTo("d", "s", head, dfrs2, sfrd, 0xc6);
    createFromTo("d", "q", head, dfrs2, qfrd, 0xce);
    createFromTo("q", "s", head, qfrs2, sfrd, 0xc7);
    createFromTo("q", "d", head, qfrs2, dfrd, 0xcb);
  }

  private void create_A16(Object[] head) {
    createXorITo("s", head, sfrd, 0x4);
    createXorITo("d", head, dfrd, 0x8);
    createXorITo("q", head, qfrd, 0xc);
  }

  private void create_A17(Object[] head) {
    createUnaryArithmetic("mov", "s", head, sfrs2, sfrd, 0x1);
    createUnaryArithmetic("mov", "d", head, dfrs2, dfrd, 0x2);
    createUnaryArithmetic("mov", "q", head, qfrs2, qfrd, 0x3);
    createUnaryArithmetic("neg", "s", head, sfrs2, sfrd, 0x5);
    createUnaryArithmetic("neg", "d", head, dfrs2, dfrd, 0x6);
    createUnaryArithmetic("neg", "q", head, qfrs2, qfrd, 0x7);
    createUnaryArithmetic("abs", "s", head, sfrs2, sfrd, 0x9);
    createUnaryArithmetic("abs", "d", head, dfrs2, dfrd, 0xa);
    createUnaryArithmetic("abs", "q", head, qfrs2, qfrd, 0xb);
  }

  private void create_A18(Object[] head) {
    createBinaryArithmetic("mul", "s", head, sfrs1, sfrs2, sfrd, 0x49);
    createBinaryArithmetic("mul", "d", head, dfrs1, dfrs2, dfrd, 0x4a);
    createBinaryArithmetic("mul", "q", head, qfrs1, qfrs2, qfrd, 0x4b);
    createBinaryArithmetic("div", "s", head, sfrs1, sfrs2, sfrd, 0x4d);
    createBinaryArithmetic("div", "d", head, dfrs1, dfrs2, dfrd, 0x4e);
    createBinaryArithmetic("div", "q", head, qfrs1, qfrs2, qfrd, 0x4f);

    define("fsmuld", head, opf(0x69), sfrs1, sfrs2, dfrd);
    define("fdmulq", head, opf(0x6e), dfrs1, dfrs2, qfrd);
  }

  private void create_A19(Object[] head) {
    createUnaryArithmetic("sqrt", "s", head, sfrs2, sfrd, 0x29);
    createUnaryArithmetic("sqrt", "d", head, dfrs2, dfrd, 0x2a);
    createUnaryArithmetic("sqrt", "q", head, qfrs2, qfrd, 0x2b);
  }

  FloatingPointOperate(SPARCTemplateCreator templateCreator) {
    super(templateCreator);

    final Object[] head1 = {op(0x2), op3(0x34)};
    final Object[] head2 = {res_18_14, head1};

    setCurrentArchitectureManualSection("A.12");
    create_A12(head1);

    setCurrentArchitectureManualSection("A.13");
    create_A13();

    setCurrentArchitectureManualSection("A.14");
    create_A14(head2);

    setCurrentArchitectureManualSection("A.15");
    create_A15(head2);

    setCurrentArchitectureManualSection("A.16");
    create_A16(head2);

    setCurrentArchitectureManualSection("A.17");
    create_A17(head2);

    setCurrentArchitectureManualSection("A.18");
    create_A18(head1);

    setCurrentArchitectureManualSection("A.19");
    create_A19(head2);
  }

}