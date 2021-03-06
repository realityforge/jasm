/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.Argument;
import jasm.SymbolSet;
import jasm.tools.ArgumentRange;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.TestArgumentExclusion;
import static jasm.tools.cisc.x86.AddressingMethodCode.*;
import static jasm.tools.cisc.x86.OperandTypeCode.*;
import jasm.tools.util.CollectionUtil;
import jasm.util.StaticLoophole;
import java.util.HashSet;
import java.util.Set;

public enum StandardOperandCode {

  Ap(A, p),
  Cd(C, d),
  Cq(C, q),
  Dd(D, d),
  Dq(D, q),
  Eb(E, b),
  Ed(E, d),
  Ed_q(E, d_q),
  Ev(E, v),
  Ew(E, w),
  Fv(F, v),
  Gb(G, b),
  Gd(G, d),
  Gd_q(G, d_q),
  Gv(G, v),
  Gw(G, w),
  Gq(G, q),
  Gz(G, z),
  Ib(I, b),
  ICb(IC, b),
  Iv(I, v),
  Iw(I, w),
  Iz(I, z),
  Jb(J, b),
  Jv(J, v),
  Jz(J, z),
  Ma(M, a),
  Mb(M, b),
  Md(M, d),
  Md_q(M, d_q),
  Mp(M, p),
  Mq(M, q),
  Mdq(M, dq),
  Ms(M, s),
  Mv(M, v),
  Mw(M, w),
  Gob(Go, b),
  God(Go, d),
  God_q(Go, d_q),
  Gov(Go, v),
  Ob(O, b),
  Ov(O, v),
  Pd(P, d),
  Pdq(P, dq),
  Pq(P, q),
  PRq(PR, q),
  Qd(Q, d),
  Qq(Q, q),
  Rd(R, d),
  Rq(R, q),
  Rv(R, v),
  Sw(S, w),
  Udq(U, dq),
  Upd(U, pd),
  Ups(U, ps),
  Uq(U, q),
  Vdq(V, dq),
  Vpd(V, pd),
  Vps(V, ps),
  Vq(V, q),
  Vsd(V, sd),
  Vss(V, ss),
  Wdq(W, dq),
  Wpd(W, pd),
  Wps(W, ps),
  Wq(W, q),
  Wsd(W, sd),
  Wss(W, ss),
  Xb(X, b),
  Xv(X, v),
  Xz(X, z),
  Yb(Y, b),
  Yv(Y, v),
  Yz(Y, z);

  private final AddressingMethodCode _addressingMethodCode;
  private final OperandTypeCode _operandTypeCode;

  private StandardOperandCode(AddressingMethodCode addressingMethodCode, OperandTypeCode operandTypeCode) {
    _addressingMethodCode = addressingMethodCode;
    _operandTypeCode = operandTypeCode;
  }

  public AddressingMethodCode addressingMethodCode() {
    return _addressingMethodCode;
  }

  public OperandTypeCode operandTypeCode() {
    return _operandTypeCode;
  }

  public TestArgumentExclusion excludeDisassemblerTestArguments(Argument... arguments) {
    return new TestArgumentExclusion(AssemblyTestComponent.DISASSEMBLER, this, CollectionUtil.hashSetFrom(arguments));
  }

  public TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
    return new TestArgumentExclusion(AssemblyTestComponent.EXTERNAL_ASSEMBLER, this, CollectionUtil.hashSetFrom(arguments));
  }

  public TestArgumentExclusion excludeExternalTestArguments(SymbolSet... argumentEnumerators) {
    final Set<Argument> arguments = new HashSet<Argument>();
    for (SymbolSet argumentEnumerator : argumentEnumerators) {
      final Set<Argument> set = StaticLoophole.cast(argumentEnumerator.asCollection());
      arguments.addAll(set);
    }
    return new TestArgumentExclusion(AssemblyTestComponent.EXTERNAL_ASSEMBLER, this, arguments);
  }

  public ArgumentRange range(long minValue, long maxValue) {
    return new ArgumentRange(this, minValue, maxValue);
  }

  public ArgumentRange externalRange(long minValue, long maxValue) {
    final ArgumentRange argumentRange = new ArgumentRange(this, minValue, maxValue);
    argumentRange.doNotApplyInternally();
    return argumentRange;
  }
}
