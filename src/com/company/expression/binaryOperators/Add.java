package com.company.expression.binaryOperators;

import com.company.expression.Expression;

public final class Add extends BinaryOperators {

    public Add (Expression firstArg, Expression secondArg){
        super(firstArg, secondArg, "+");
    }

    @Override
    public int evaluate(int x) {
        return firstArg.evaluate(x) + secondArg.evaluate(x);
    }
}
