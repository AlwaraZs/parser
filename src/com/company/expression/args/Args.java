package com.company.expression.args;

import com.company.expression.TripleExpression;

public abstract class Args implements TripleExpression {
    protected String name;
    protected int value;

    Args(String name) {
        this.name = name;
    }

    Args(int value){
        this.value = value;
    }

}
