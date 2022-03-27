package com.company;

public class Multiply extends BinaryOperators {

    Multiply(Expression firstArg, Expression secondArg){
        super(firstArg, secondArg, "*");
    }

    @Override
    public int evaluate(int x) {
        return firstArg.evaluate(x) * secondArg.evaluate(x);
    }
}