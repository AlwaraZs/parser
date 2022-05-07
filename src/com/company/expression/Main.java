package com.company.expression;

import com.company.expression.Generics.AbstractGenericArithmetic;
import com.company.expression.Generics.DoubleGenericArithmetic;

public class Main {

    public static void main(String[] args) {
        /*int a = new Subtract(
                new Multiply(
                        new Const(2),
                        new Variable("x")
                ),
                new Const(3)
        ).evaluate(5);

        String str = new Subtract(
                new Multiply(
                        new Const(2),
                        new Variable("x")
                ),
                new Const(3)
        ).toString();
        System.out.println(a + "/n" + str);
         */
        ExpressionParser<Double> parser = new ExpressionParser<Double>();
        DoubleGenericArithmetic arg1 = new DoubleGenericArithmetic(1);
        DoubleGenericArithmetic arg2 = new DoubleGenericArithmetic(1);
        DoubleGenericArithmetic arg3 = new DoubleGenericArithmetic(1);
        System.out.println(parser.parse("-(-1 - -3)") .evaluate(arg1, arg2, arg3));
    }
}
