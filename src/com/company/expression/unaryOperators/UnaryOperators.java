package com.company.expression.unaryOperators;

import com.company.expression.TripleExpression;

public abstract class UnaryOperators<T extends Number> implements TripleExpression<T> {
    String name;
    TripleExpression<T> expression;

    UnaryOperators(TripleExpression<T> expression, String name){
        this.expression = expression;
        this.name = name;
    }
    @Override
    public String toString(){
        return String.format("(%s(%s))", name, expression.toString());
    }
}
