package com.company.expression;

import com.company.expression.args.Const;
import com.company.expression.args.Variable;
import com.company.expression.binaryOperators.*;
import com.company.expression.unaryOperators.UnaryMinus;

import java.util.*;

public class ExpressionParser implements Parser{
    private final ArrayList<String> binaryOperators = new ArrayList<>(Arrays.asList("-", "+", "*", "/"));
    private final ArrayList<String> unaryOperators =  new ArrayList<>(Arrays.asList("-"));
    private final ArrayList<String> parameters =  new ArrayList<>(Arrays.asList("x", "y", "z"));

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
                } else return new Const(Integer.parseInt(expression));
            }
        }
        //throw exseption
       return null; // never
    }

    //убираем все ненужные символы
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
        for (int indexOperator = 0; indexOperator < binaryOperators.size(); ++indexOperator) { // проходимся по всем операторам в порядке преоритета
            if(indexOperator == 0 && expression.charAt(0) == '-') continue; // если унарный минус в начале, то скипаем
            for (int indexInExpression = 0; indexInExpression < expression.length(); ++indexInExpression) {
                if(indexOperator == 0 && expression.charAt(indexInExpression) == '-' &&
                        binaryOperators.contains(String.valueOf(expression.charAt(indexInExpression - 1)))) continue;//если унарный минус в середине - скипаем
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
        for (int indexOperator = 0; indexOperator < unaryOperators.size(); ++indexOperator){ // проходимся по всем операторам в порядке преоритета
            if (String.valueOf(expression.charAt(0)).equals(unaryOperators.get(indexOperator))){
                return 0;
            }
        }
        return -1;
    }
/*
 pre: получаем индекс открывающей скобки
 post: возвращаем индекс на закрывающую
 */
    private int getIndexNextBracket(String str, int index){
        int count = 1;
        for(int i = index + 1; i < str.length(); ++i){
            if (str.charAt(i) == '(') count++; // обе можно объединить в одну лямбду
            if (str.charAt(i) == ')') count--;
            if (count ==  0) return i;
        }
        return -1;// never
    }

    // првоерка что скобки расставлены правильно
    private boolean normolizeBracket(String str){
        int numb = 0;
        for (int i = 0; i < str.length(); ++i){
            if (str.charAt(i) == '(') numb++;
            if (str.charAt(i) == ')') numb--;
            if (numb < 0) return false;
        }
        return numb == 0;
    }

    //убираем крайние скобки слева и справа
    private String skipBracket(String expression){// нужн опосчитать скобки и кинуть ошибку
        if(expression.length() == 0) return "";
        if(expression.charAt(0) != '(') return expression;
        int count = 1, i = 0;
        while (expression.charAt(i) == '('){
            ++i;
            count++;
        }
        int min = count;
        for (; i < expression.length(); ++i){
            if(expression.charAt(i) == '(') count++;
            if(expression.charAt(i) == ')') count--;
            min = Math.min(min, count);
        }
        return expression.substring(min, expression.length() - min);
    }
}
