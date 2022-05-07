package com.company.expression.Generics;

import java.math.BigInteger;
import java.util.function.BiFunction;

public class BigIntegerGenericArithmetic extends AbstractGenericArithmetic<BigInteger> {

    public BigIntegerGenericArithmetic(Number val) {
        super(new BigInteger(val.toString()));
    }

    @Override
    public AbstractGenericArithmetic<BigInteger> add(AbstractGenericArithmetic<BigInteger> second) {
        return abstractBinaryOp(second, add);
    }

    @Override
    public AbstractGenericArithmetic<BigInteger> subtract(AbstractGenericArithmetic<BigInteger> second) {
        return abstractBinaryOp(second, subtract);
    }

    @Override
    public AbstractGenericArithmetic<BigInteger> divide(AbstractGenericArithmetic<BigInteger> second) {
        return abstractBinaryOp(second, divide);
    }

    @Override
    public AbstractGenericArithmetic<BigInteger> multiply(AbstractGenericArithmetic<BigInteger> second) {
        return abstractBinaryOp(second, multiply);
    }

    @Override
    public AbstractGenericArithmetic<BigInteger> negate() {
        return abstractBinaryOp(null, negate);
    }

    private BiFunction<AbstractGenericArithmetic<BigInteger>, AbstractGenericArithmetic<BigInteger>, AbstractGenericArithmetic<BigInteger>> add = (
            first, second) -> new BigIntegerGenericArithmetic(first.getValue().add(second.getValue()));

    private BiFunction<AbstractGenericArithmetic<BigInteger>, AbstractGenericArithmetic<BigInteger>, AbstractGenericArithmetic<BigInteger>> subtract = (
            first, second) -> new BigIntegerGenericArithmetic(first.getValue().subtract(second.getValue()));

    private BiFunction<AbstractGenericArithmetic<BigInteger>, AbstractGenericArithmetic<BigInteger>, AbstractGenericArithmetic<BigInteger>> multiply = (
            first, second) -> new BigIntegerGenericArithmetic(first.getValue().multiply(second.getValue()));

    private BiFunction<AbstractGenericArithmetic<BigInteger>, AbstractGenericArithmetic<BigInteger>, AbstractGenericArithmetic<BigInteger>> divide = (
            first, second) -> new BigIntegerGenericArithmetic(first.getValue().divide(second.getValue()));

    private BiFunction<AbstractGenericArithmetic<BigInteger>, AbstractGenericArithmetic<BigInteger>, AbstractGenericArithmetic<BigInteger>> negate = (
            first, second) -> new BigIntegerGenericArithmetic(first.getValue().negate());

}