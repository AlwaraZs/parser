package com.company.expression.args;

import com.company.expression.Generics.AbstractGenericArithmetic;

public final class Variable<T extends Number> extends Args<T> {

    public Variable(String name){
        super(name);
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public AbstractGenericArithmetic<T> evaluate(AbstractGenericArithmetic<T> x, AbstractGenericArithmetic<T> y, AbstractGenericArithmetic<T> z){
        switch (name){
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
        }
        //exception
        return null;//never
    }
}
