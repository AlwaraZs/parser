package com.company.expression;

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
        Parser parser = new Parser();
        System.out.println(parser.parse("x * 2 + -1").evaluate(1));
    }
}