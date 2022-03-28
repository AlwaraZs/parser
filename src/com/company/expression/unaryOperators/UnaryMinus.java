package com.company.expression.unaryOperators;

import com.company.expression.Expression;

public final class UnaryMinus extends UnaryOperators {

    public UnaryMinus(Expression expression) {
        super(expression, "-");
    }

    @Override
    public int evaluate(int x) {
        return expression.evaluate(x)*-1;
    }

}
