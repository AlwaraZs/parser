package com.company.expression.unaryOperators;

import com.company.expression.TripleExpression;

public final class UnaryMinus extends UnaryOperators {

    public UnaryMinus(TripleExpression expression) {
        super(expression, "-");
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return expression.evaluate(x, y, z) * -1;
    }

}
