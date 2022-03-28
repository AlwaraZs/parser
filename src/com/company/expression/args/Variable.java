package com.company.expression.args;

public final class Variable extends Args {

    public Variable(String name){
        super(name);
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int evaluate(int x){
        return x;
    }
}
