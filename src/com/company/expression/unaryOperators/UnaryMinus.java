package com.company.expression.unaryOperators;

import com.company.expression.Expression;

public class UnaryMinus extends UnaryOperators {

    UnaryMinus(Expression expression) {
        super(expression, "-");
    }

    @Override
    public int evaluate(int x) {
        return expression.evaluate(x)*-1;
    }

}
