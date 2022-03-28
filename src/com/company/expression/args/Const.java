package com.company.expression.args;

public final class Const extends Args {

    public Const (int value) {
        super(value);
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }

    @Override
    public int evaluate(int x) {
        return value;
    }
}
