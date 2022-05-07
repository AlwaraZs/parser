package com.company.expression.Generics;


import java.util.function.BiFunction;

public class IntegerGenericArithmetic extends AbstractGenericArithmetic<Integer> {

    public IntegerGenericArithmetic(Number val) {
        super(val.intValue());
    }

    @Override
    public AbstractGenericArithmetic<Integer> add(AbstractGenericArithmetic<Integer> second) {
        return abstractBinaryOp(second, add);
    }

    @Override
    public AbstractGenericArithmetic<Integer> subtract(AbstractGenericArithmetic<Integer> second) {
        return abstractBinaryOp(second, subtract);
    }

    @Override
    public AbstractGenericArithmetic<Integer> divide(AbstractGenericArithmetic<Integer> second) {
        return abstractBinaryOp(second, divide);
    }

    @Override
    public AbstractGenericArithmetic<Integer> multiply(AbstractGenericArithmetic<Integer> second) {
        return abstractBinaryOp(second, multiply);
    }

    @Override
    public AbstractGenericArithmetic<Integer> negate() {
        return abstractBinaryOp(null, negate);
    }

    private BiFunction<AbstractGenericArithmetic<Integer>, AbstractGenericArithmetic<Integer>, AbstractGenericArithmetic<Integer>> add = (
            first, second) -> new IntegerGenericArithmetic(first.getValue() + second.getValue());

    private BiFunction<AbstractGenericArithmetic<Integer>, AbstractGenericArithmetic<Integer>, AbstractGenericArithmetic<Integer>> subtract = (
            first, second) -> new IntegerGenericArithmetic(first.getValue() - second.getValue());

    private BiFunction<AbstractGenericArithmetic<Integer>, AbstractGenericArithmetic<Integer>, AbstractGenericArithmetic<Integer>> multiply = (
            first, second) -> new IntegerGenericArithmetic(first.getValue() * second.getValue());

    private BiFunction<AbstractGenericArithmetic<Integer>, AbstractGenericArithmetic<Integer>, AbstractGenericArithmetic<Integer>> divide = (
            first, second) -> new IntegerGenericArithmetic(first.getValue() / second.getValue());

    private BiFunction<AbstractGenericArithmetic<Integer>, AbstractGenericArithmetic<Integer>, AbstractGenericArithmetic<Integer>> negate = (
            first, second) -> new IntegerGenericArithmetic(-first.getValue());

}