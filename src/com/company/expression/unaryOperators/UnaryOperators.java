package com.company.expression.unaryOperators;

import com.company.expression.TripleExpression;

public abstract class UnaryOperators implements TripleExpression {
    String name;
    TripleExpression expression;

    UnaryOperators(TripleExpression expression, String name){
        this.expression = expression;
        this.name = name;
    }
    @Override
    public String toString(){
        return String.format("(%s(%s))", name, expression.toString());
    }
}
