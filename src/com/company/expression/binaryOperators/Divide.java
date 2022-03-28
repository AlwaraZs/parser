package com.company.expression.binaryOperators;

import com.company.expression.Expression;
import com.company.expression.binaryOperators.BinaryOperators;

public class Divide extends BinaryOperators {

    Divide (Expression firstArg, Expression secondArg){
        super(firstArg, secondArg, "/");
    }

    @Override
    public int evaluate(int x) {
        return firstArg.evaluate(x) / secondArg.evaluate(x);
    }
}
