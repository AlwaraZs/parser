package com.company.expression.args;

import com.company.expression.Generics.AbstractGenericArithmetic;

public final class Const<T extends Number> extends Args<T> {

    public Const (AbstractGenericArithmetic<T> value) {
        super(value);
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }

    @Override
    public AbstractGenericArithmetic<T> evaluate(AbstractGenericArithmetic<T> x, AbstractGenericArithmetic<T> y, AbstractGenericArithmetic<T> z) {
        return value;
    }
}
