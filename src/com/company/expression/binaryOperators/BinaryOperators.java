package com.company.expression.binaryOperators;

import com.company.expression.Expression;

public abstract class BinaryOperators implements Expression {
    protected String name;
    protected Expression firstArg;
    protected Expression secondArg;

    BinaryOperators(Expression firstArg, Expression secondArg, String name){
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("(%s %s %s)", firstArg.toString(), name, secondArg.toString());
    }

}
