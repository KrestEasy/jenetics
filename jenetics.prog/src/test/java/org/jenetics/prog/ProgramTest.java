/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics.prog;

import org.testng.annotations.Test;

import org.jenetics.ext.util.TreeNode;
import org.jenetics.prog.op.Const;
import org.jenetics.prog.op.MathOps;
import org.jenetics.prog.op.Op;
import org.jenetics.prog.op.Program;
import org.jenetics.prog.op.Var;
import org.jenetics.util.ISeq;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 */
public class ProgramTest {

    private static final ISeq<Op<Double>> OPERATIONS = ISeq.of(
        MathOps.ADD,
        MathOps.SUB,
        MathOps.MUL,
        MathOps.DIV,
        MathOps.EXP,
        MathOps.SIN,
        MathOps.COS
    );

    private static final ISeq<Op<Double>> TERMINALS = ISeq.of(
        Var.of("x", 0),
        Var.of("y", 1),
        Var.of("z", 2),
        //Const.of("π", Math.PI),
        Const.of(1.0)
    );

    @Test
    public void eval() {
        final TreeNode<Op<Double>> tree = Program.of(
            0,
            OPERATIONS,
            TERMINALS
        );

        System.out.println(tree);
        final double result = Program.eval(tree, 1.0, 2.0, 3.0);
        System.out.println(result);

    }

}
