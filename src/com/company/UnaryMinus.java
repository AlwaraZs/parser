package com.company;

public class UnaryMinus extends UnaryOperators {

    UnaryMinus(Expression expression) {
        super(expression, "-");
    }

    @Override
    public int evaluate(int x) {
        return expression.evaluate(x)*-1;
    }

}
