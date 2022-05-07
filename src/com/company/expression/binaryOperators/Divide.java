package com.company.expression.binaryOperators;

import com.company.expression.Generics.AbstractGenericArithmetic;
import com.company.expression.TripleExpression;

public final class Divide<T extends Number> extends BinaryOperators<T> {

    public Divide (TripleExpression<T> firstArg, TripleExpression<T> secondArg){
        super(firstArg, secondArg, "/");
    }

    @Override
    public AbstractGenericArithmetic<T> evaluate(AbstractGenericArithmetic<T> x, AbstractGenericArithmetic<T> y, AbstractGenericArithmetic<T> z) {
        return firstArg.evaluate(x, y, z).divide(secondArg.evaluate(x, y, z));
    }
}
