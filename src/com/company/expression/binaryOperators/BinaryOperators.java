package com.company.expression.binaryOperators;

import com.company.expression.TripleExpression;

public abstract class BinaryOperators implements TripleExpression {
    protected String name;
    protected TripleExpression firstArg;
    protected TripleExpression secondArg;

    BinaryOperators(TripleExpression firstArg, TripleExpression secondArg, String name){
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("(%s %s %s)", firstArg.toString(), name, secondArg.toString());
    }

}
