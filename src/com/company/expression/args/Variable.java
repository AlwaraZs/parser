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
    public int evaluate(int x, int y, int z){
        switch (name){
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
        }
        //exseption
        return -1;//never
    }
}
