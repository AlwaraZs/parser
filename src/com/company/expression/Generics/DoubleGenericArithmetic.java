package com.company.expression.Generics;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class DoubleGenericArithmetic extends AbstractGenericArithmetic<Double> {

    public DoubleGenericArithmetic(Number val) {
        super(val.doubleValue());
    }

    public DoubleGenericArithmetic(String val) {
        super(Double.valueOf(val));
    }

    @Override
    public AbstractGenericArithmetic<Double> add(AbstractGenericArithmetic<Double> second) {
        return abstractBinaryOp(second, add);
    }

    @Override
    public AbstractGenericArithmetic<Double> subtract(AbstractGenericArithmetic<Double> second) {
        return abstractBinaryOp(second, subtract);
    }

    @Override
    public AbstractGenericArithmetic<Double> divide(AbstractGenericArithmetic<Double> second) {
        return abstractBinaryOp(second, divide);
    }

    @Override
    public AbstractGenericArithmetic<Double> multiply(AbstractGenericArithmetic<Double> second) {
        return abstractBinaryOp(second, multiply);
    }

    @Override
    public AbstractGenericArithmetic<Double> negate() {
        return abstractBinaryOp(null, negate);
    }

    private BiFunction<AbstractGenericArithmetic<Double>, AbstractGenericArithmetic<Double>, AbstractGenericArithmetic<Double>> add = (
            first, second) -> new DoubleGenericArithmetic(first.getValue() + second.getValue());

    private BiFunction<AbstractGenericArithmetic<Double>, AbstractGenericArithmetic<Double>, AbstractGenericArithmetic<Double>> subtract = (
            first, second) -> new DoubleGenericArithmetic(first.getValue() - second.getValue());

    private BiFunction<AbstractGenericArithmetic<Double>, AbstractGenericArithmetic<Double>, AbstractGenericArithmetic<Double>> multiply = (
            first, second) -> new DoubleGenericArithmetic(first.getValue() * second.getValue());

    private BiFunction<AbstractGenericArithmetic<Double>, AbstractGenericArithmetic<Double>, AbstractGenericArithmetic<Double>> divide = (
            first, second) -> new DoubleGenericArithmetic(first.getValue() / second.getValue());

    private BiFunction<AbstractGenericArithmetic<Double>, AbstractGenericArithmetic<Double>, AbstractGenericArithmetic<Double>> negate = (
            first, second) -> new DoubleGenericArithmetic(-first.getValue());

}