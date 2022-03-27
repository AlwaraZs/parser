package com.company.expression;

public abstract class UnaryOperators implements Expression {
    String name;
    Expression expression;

    UnaryOperators(Expression expression, String name){
        this.expression = expression;
        this.name = name;
    }
    @Override
    public String toString(){
        return String.format("(%s(%s))", name, expression.toString());
    }
}
