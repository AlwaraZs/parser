package com.company.expression.binaryOperators;

import com.company.expression.Generics.AbstractGenericArithmetic;
import com.company.expression.TripleExpression;

public final class Multiply<T extends Number> extends BinaryOperators<T> {
    public Multiply(TripleExpression<T> firstArg, TripleExpression<T> secondArg){
        super(firstArg, secondArg, "*");
    }


    @Override
    public AbstractGenericArithmetic<T> evaluate(AbstractGenericArithmetic<T> x, AbstractGenericArithmetic<T> y, AbstractGenericArithmetic<T> z) {
        return firstArg.evaluate(x, y, z).multiply(secondArg.evaluate(x, y, z));
    }
}
