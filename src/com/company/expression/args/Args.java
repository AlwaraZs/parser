package com.company.expression.args;

import com.company.expression.Expression;

public abstract class Args implements Expression {
    protected String name;
    protected int value;

    Args(String name) {
        this.name = name;
    }

    Args(int value){
        this.value = value;
    }

}
