package com.company;

public abstract class Variables implements Expression{
    protected String name;
    protected int value;

    Variables (String name) {
        this.name = name;
    }

    Variables (int value){
        this.value = value;
    }

}
