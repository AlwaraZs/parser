package com.company.expression;

import com.company.expression.Generics.AbstractGenericArithmetic;

public interface TripleExpression<T extends Number>{
    AbstractGenericArithmetic<T> evaluate(AbstractGenericArithmetic<T> x, AbstractGenericArithmetic<T> y, AbstractGenericArithmetic<T> z);
}