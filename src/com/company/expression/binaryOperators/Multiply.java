package com.company.expression.binaryOperators;

import com.company.expression.Expression;
import com.company.expression.binaryOperators.BinaryOperators;

public final class Multiply extends BinaryOperators {

    public Multiply(Expression firstArg, Expression secondArg){
        super(firstArg, secondArg, "*");
    }

    @Override
    public int evaluate(int x) {
        return firstArg.evaluate(x) * secondArg.evaluate(x);
    }
}
