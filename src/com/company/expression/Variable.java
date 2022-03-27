package com.company.expression;

public class Variable extends Variables{

    Variable(String name){
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
