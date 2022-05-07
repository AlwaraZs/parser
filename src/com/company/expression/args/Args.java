package com.company.expression.args;

import com.company.expression.Generics.AbstractGenericArithmetic;
import com.company.expression.TripleExpression;

public abstract class Args<T extends Number> implements TripleExpression<T> {
    protected String name;
    protected AbstractGenericArithmetic<T> value;

    Args(String name) {
        this.name = name;
    }

    Args(AbstractGenericArithmetic<T> value){
        this.value = value;
    }

}
