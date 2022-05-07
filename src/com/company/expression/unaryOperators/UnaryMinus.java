package com.company.expression.unaryOperators;

import com.company.expression.Generics.AbstractGenericArithmetic;
import com.company.expression.TripleExpression;

public final class UnaryMinus<T extends Number> extends UnaryOperators<T> {

    public UnaryMinus(TripleExpression<T> expression) {
        super(expression, "-");
    }

    @Override
    public AbstractGenericArithmetic<T> evaluate(AbstractGenericArithmetic<T> x, AbstractGenericArithmetic<T> y, AbstractGenericArithmetic<T> z) {
        return expression.evaluate(x, y, z).negate();
    }

}
