package com.company.expression.binaryOperators;

import com.company.expression.TripleExpression;

public final class Divide extends BinaryOperators {

    public Divide (TripleExpression firstArg, TripleExpression secondArg){
        super(firstArg, secondArg, "/");
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return firstArg.evaluate(x, y, z) / secondArg.evaluate(x, y, z);
    }
}
