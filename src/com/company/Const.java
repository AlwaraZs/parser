package com.company;

public class Const extends Variables{
    Const (int value) {
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
