package com.company.expression.binaryOperators;

import com.company.expression.TripleExpression;

public abstract class BinaryOperators<T extends Number> implements TripleExpression<T> {
    protected String name;
    protected TripleExpression<T> firstArg;
    protected TripleExpression<T> secondArg;

    BinaryOperators(TripleExpression<T> firstArg, TripleExpression<T> secondArg, String name){
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("(%s %s %s)", firstArg.toString(), name, secondArg.toString());
    }

}
