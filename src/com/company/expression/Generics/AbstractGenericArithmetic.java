package com.company.expression.Generics;

import java.util.function.BiFunction;

    public abstract class AbstractGenericArithmetic<T> implements GenericArithmetic<T> {

        protected T val;

        public T getValue() {
            return val;
        }

        public AbstractGenericArithmetic(T val) {
            this.val = val;
        }

        protected AbstractGenericArithmetic<T> abstractBinaryOp(AbstractGenericArithmetic<T> second,
              BiFunction<AbstractGenericArithmetic<T>, AbstractGenericArithmetic<T>, AbstractGenericArithmetic<T>> calc) {
            return calc.apply(this, second);
        }
    }

