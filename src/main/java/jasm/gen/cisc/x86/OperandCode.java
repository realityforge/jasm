/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.Argument;
import jasm.SymbolSet;
import jasm.gen.ArgumentRange;
import jasm.gen.AssemblyTestComponent;
import jasm.gen.TestArgumentExclusion;
import jasm.gen.WrappableSpecification;
import static jasm.gen.cisc.x86.AddressingMethodCode.A;
import static jasm.gen.cisc.x86.AddressingMethodCode.C;
import static jasm.gen.cisc.x86.AddressingMethodCode.D;
import static jasm.gen.cisc.x86.AddressingMethodCode.E;
import static jasm.gen.cisc.x86.AddressingMethodCode.F;
import static jasm.gen.cisc.x86.AddressingMethodCode.G;
import static jasm.gen.cisc.x86.AddressingMethodCode.I;
import static jasm.gen.cisc.x86.AddressingMethodCode.IC;
import static jasm.gen.cisc.x86.AddressingMethodCode.J;
import static jasm.gen.cisc.x86.AddressingMethodCode.M;
import static jasm.gen.cisc.x86.AddressingMethodCode.N;
import static jasm.gen.cisc.x86.AddressingMethodCode.O;
import static jasm.gen.cisc.x86.AddressingMethodCode.P;
import static jasm.gen.cisc.x86.AddressingMethodCode.PR;
import static jasm.gen.cisc.x86.AddressingMethodCode.Q;
import static jasm.gen.cisc.x86.AddressingMethodCode.R;
import static jasm.gen.cisc.x86.AddressingMethodCode.S;
import static jasm.gen.cisc.x86.AddressingMethodCode.V;
import static jasm.gen.cisc.x86.AddressingMethodCode.VR;
import static jasm.gen.cisc.x86.AddressingMethodCode.W;
import static jasm.gen.cisc.x86.AddressingMethodCode.X;
import static jasm.gen.cisc.x86.AddressingMethodCode.Y;
import static jasm.gen.cisc.x86.OperandTypeCode.a;
import static jasm.gen.cisc.x86.OperandTypeCode.b;
import static jasm.gen.cisc.x86.OperandTypeCode.d;
import static jasm.gen.cisc.x86.OperandTypeCode.d_q;
import static jasm.gen.cisc.x86.OperandTypeCode.dq;
import static jasm.gen.cisc.x86.OperandTypeCode.p;
import static jasm.gen.cisc.x86.OperandTypeCode.pd;
import static jasm.gen.cisc.x86.OperandTypeCode.ps;
import static jasm.gen.cisc.x86.OperandTypeCode.q;
import static jasm.gen.cisc.x86.OperandTypeCode.s;
import static jasm.gen.cisc.x86.OperandTypeCode.sd;
import static jasm.gen.cisc.x86.OperandTypeCode.ss;
import static jasm.gen.cisc.x86.OperandTypeCode.v;
import static jasm.gen.cisc.x86.OperandTypeCode.w;
import static jasm.gen.cisc.x86.OperandTypeCode.z;
import jasm.util.collect.CollectionUtil;
import jasm.util.lang.StaticLoophole;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bernd Mathiske
 */
public enum OperandCode implements WrappableSpecification {

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
    Nb(N, b),
    Nd(N, d),
    Nd_q(N, d_q),
    Nv(N, v),
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
    Vdq(V, dq),
    Vpd(V, pd),
    Vps(V, ps),
    Vq(V, q),
    Vsd(V, sd),
    Vss(V, ss),
    VRdq(VR, dq),
    VRpd(VR, pd),
    VRps(VR, ps),
    VRq(VR, q),
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

    private OperandCode(AddressingMethodCode addressingMethodCode, OperandTypeCode operandTypeCode) {
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
