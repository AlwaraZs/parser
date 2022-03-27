package com.company;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.Set;

public class Parser {

    Parser(){}

    Predicate<Character> checlOpenBroken = (letter) -> letter == '(';
    Predicate<Character> checlCloseBroken = (letter) -> letter == ')';
    HashSet<String> bibaryOperators = new HashSet<String>();

    public String parse(String expression)  {
        if (!(normolizeBroken(expression)));/// throw exception
        expression = skipBroken(expression);
        return expression;
    }
/*
    null - if can't find more operators
    Integer - number of next operator
 */
    private Optional<Integer> getIndexNextOperator(String str){
        // в выражении может бть в середине унарный минус без скобок и тогда просблема ???
        if (str.charAt(0) == '-') ; // проверит на унарную операцию
        int index = 0;
        for (;index < str.length(); ++index){
            if (str.charAt(index) == '('){
                index = getIndexNextBroken(str, index);
            }else{
                if(isOperator(str.charAt(index)));
                return Optional.of(index);
            }
        }
        return Optional.empty();// haven't got next operator
    }

    private boolean isOperator(char letter){
        if (letter == '+' || letter == '-' || letter == '*' || letter == '/') return true;
        return false;
    }

    private int getIndexNextBroken(String str, int index){ // индекс на первую скобку
        int count = 1;
        for(int i = index + 1; i < str.length(); i++){
            if (str.charAt(i) == '(') count++; // обе можно объединить в одну лямбду
            if (str.charAt(i) == ')') count--;
            if (count ==  0) return i;
        }
        return -1;// never
    }

    private boolean normolizeBroken(String str){
        int numb = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(') numb++;
            if (str.charAt(i) == ')') numb--;
            if (numb < 0) return false;
        }
        return numb != 0 ? false : true;
    }

    private String skipBroken(String expression){// нужн опосчитать скобки и кинуть ошибку
        if(expression.length() == 0) return "";
        if(expression.charAt(0) != '(') return expression;
        int count = 1, i = 0;
        while (expression.charAt(i) == '('){
            i++;
            count++;
        }
        int min = count;
        for (; i < expression.length(); i++){
            if(expression.charAt(i) == '(') count++;
            if(expression.charAt(i) == ')') count--;
            min = Math.min(min, count);
        }
        return expression.substring(min, expression.length() - min);
    }
}
