package com.company.expression;

import com.company.expression.Generics.AbstractGenericArithmetic;
import com.company.expression.Parser;
import com.company.expression.TripleExpression;
import com.company.expression.args.Const;
import com.company.expression.args.Variable;
import com.company.expression.binaryOperators.*;
import com.company.expression.unaryOperators.UnaryMinus;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ExpressionParser<T> implements Parser {
        private final ArrayList<String> binaryOperators = new ArrayList<>(Arrays.asList("-", "+", "*", "/"));
        private final ArrayList<String> unaryOperators =  new ArrayList<>(Arrays.asList("-"));
        private final ArrayList<String> parameters =  new ArrayList<>(Arrays.asList("x", "y", "z", "."));
        private Function<String, AbstractGenericArithmetic<T>> functionToInfer;
        ExpressionParser(){}

        @Override
        public TripleExpression parse(String expression) {
            if (!(normolizeBracket(expression)));
            expression = normolizeExpression(expression);
            return parsing(expression);
        }

        private TripleExpression parsing(String expression){
            expression = skipBracket(expression);
            int indexNextOperator = getIndexNextBinaryOperator(expression);
            if (indexNextOperator != -1){
                String firstArg = expression.substring(0, indexNextOperator);
                String secondArg = expression.substring(indexNextOperator + 1);
                switch (String.valueOf(expression.charAt(indexNextOperator))){
                    case "*":
                        return new Multiply(parsing(firstArg), parsing(secondArg));
                    case "/":
                        return new Divide(parsing(firstArg), parsing(secondArg));
                    case "+":
                        return new Add(parsing(firstArg), parsing(secondArg));
                    case "-":
                        return new Subtract(parsing(firstArg), parsing(secondArg));
                }
            } else if ((indexNextOperator = getIndexNextUnaryOperator(expression)) != -1){
                switch (String.valueOf(expression.charAt(indexNextOperator))){
                    case "-":
                        return new UnaryMinus(parsing(expression.substring(1)));
                }
            }else {
                if (parameters.contains(expression) || (expression.length() == 1 && Character.isDigit(expression.charAt(0)))){
                    if (parameters.contains(expression)) {
                        return new Variable(expression);
                    } else return new Const(functionToInfer.apply(expression));
                }
            }
            //throw exseption
            return null; // never
        }

        //?????????????? ?????? ???????????????? ??????????????
        private String normolizeExpression(String expression){
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < expression.length(); ++i){
                String nextLetter = String.valueOf(expression.charAt(i));
                if (Character.isDigit(expression.charAt(i)) || parameters.contains(nextLetter) || binaryOperators.contains(nextLetter) ||
                        unaryOperators.contains(nextLetter) || nextLetter.equals(")") || nextLetter.equals("(")){
                    result.append(expression.charAt(i));
                }
            }
            return result.toString();
        }

        /*
            return index next binary operator
            if couldn't find return -1
         */
        private int getIndexNextBinaryOperator(String expression){
            for (int indexOperator = 0; indexOperator < binaryOperators.size(); ++indexOperator) { // ???????????????????? ???? ???????? ???????????????????? ?? ?????????????? ????????????????????
                for (int indexInExpression = 0; indexInExpression < expression.length(); ++indexInExpression) {
                    if((indexOperator == 0 && expression.charAt(indexInExpression) == '-') &&( indexInExpression == 0 || // ???????? ?????????????? ?????????? ?? ????????????, ???? ??????????????
                            binaryOperators.contains(String.valueOf(expression.charAt(indexInExpression - 1))))) continue;//???????? ?????????????? ?????????? ?? ???????????????? - ??????????????
                    if (expression.charAt(indexInExpression) == '(') {
                        indexInExpression = getIndexNextBracket(expression, indexInExpression);
                    } else if (String.valueOf(expression.charAt(indexInExpression)).equals(binaryOperators.get(indexOperator))) {
                        return indexInExpression;
                    }
                }
            }
            return -1;
        }

        private int getIndexNextUnaryOperator(String expression){
            for (int indexOperator = 0; indexOperator < unaryOperators.size(); ++indexOperator){ // ???????????????????? ???? ???????? ???????????????????? ?? ?????????????? ????????????????????
                if (String.valueOf(expression.charAt(0)).equals(unaryOperators.get(indexOperator))){
                    return 0;
                }
            }
            return -1;
        }
        /*
         pre: ???????????????? ???????????? ?????????????????????? ????????????
         post: ???????????????????? ???????????? ???? ??????????????????????
         */
        private int getIndexNextBracket(String str, int index){
            int count = 1;
            for(int i = index + 1; i < str.length(); ++i){
                if (str.charAt(i) == '(') count++; // ?????? ?????????? ???????????????????? ?? ???????? ????????????
                if (str.charAt(i) == ')') count--;
                if (count ==  0) return i;
            }
            return -1;// never
        }

        // ???????????????? ?????? ???????????? ?????????????????????? ??????????????????
        private boolean normolizeBracket(String str){
            int numb = 0;
            for (int i = 0; i < str.length(); ++i){
                if (str.charAt(i) == '(') numb++;
                if (str.charAt(i) == ')') numb--;
                if (numb < 0) return false;
            }
            return numb == 0;
        }

        //?????????????? ?????????????? ???????????? ?????????? ?? ????????????
        private String skipBracket(String expression) {
            if (expression.length() == 0) return expression;
            int beginCount = 0;
            while (expression.charAt(beginCount) == '(') {
                beginCount++;
            }
            int endCount = expression.length() - 1;
            while (expression.charAt(endCount) == ')') {
                endCount--;
            }
            int min = Math.min(beginCount, expression.length() - endCount - 1);
            return expression.substring(min, expression.length() - min);
        }
}