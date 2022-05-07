package com.company.expression.Generics;

public interface GenericArithmetic<T> {
    AbstractGenericArithmetic<T> add(AbstractGenericArithmetic<T> second);

    AbstractGenericArithmetic<T> subtract(AbstractGenericArithmetic<T> second);

    AbstractGenericArithmetic<T> divide(AbstractGenericArithmetic<T> second);

    AbstractGenericArithmetic<T> multiply(AbstractGenericArithmetic<T> second);

    AbstractGenericArithmetic<T> negate();
}
