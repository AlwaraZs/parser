package com.company.expression.binaryOperators;

import com.company.expression.Generics.AbstractGenericArithmetic;
import com.company.expression.TripleExpression;

public final class Subtract<T extends Number> extends BinaryOperators<T> {

    public Subtract(TripleExpression<T> firstArg, TripleExpression<T> secondArg){
        super(firstArg, secondArg, "-");
    }

    @Override
    public AbstractGenericArithmetic<T> evaluate(AbstractGenericArithmetic<T> x, AbstractGenericArithmetic<T> y, AbstractGenericArithmetic<T> z) {
        return firstArg.evaluate(x, y, z).subtract(secondArg.evaluate(x, y, z));
    }
}
