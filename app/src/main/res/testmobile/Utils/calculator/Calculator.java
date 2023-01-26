package com.example.testmobile.utils.calculator;

import java.math.BigDecimal;
import static com.example.testmobile.utils.values.ResultDefault.EMPTY_DEFAULT_TEXT;

import com.example.testmobile.exceptions.DivisionByZeroException;

public class Calculator {
    private BigDecimal first, second;

    public Calculator() {
    }

    public void add(String amount){
        if(this.first == null){
            this.first = new BigDecimal(amount);
            return;
        }

        this.second = new BigDecimal(amount);
    }

    public String sum() {
        if (!isPossible()){
            return EMPTY_DEFAULT_TEXT;
        }

        this.first = first.add(this.second);
        this.clearSecondField();

        return this.first.toString();
    }

    public String subtract() {
        if (!isPossible()){
            return EMPTY_DEFAULT_TEXT;
        }
        first = first.subtract(second);
        this.clearSecondField();

        return this.first.toString();
    }

    public String multiply() {
        if (!isPossible()){
            return EMPTY_DEFAULT_TEXT;
        }
        first = first.multiply(second);
        this.clearSecondField();

        return this.first.toString();
    }

    public String divide() {
        try {
            if (!isPossible()){
                return EMPTY_DEFAULT_TEXT;
            }
            first = first.divide(second);
            this.clearSecondField();

            return this.first.toString();
        } catch (ArithmeticException e) {
            return DivisionByZeroException.SYNTAX_ERROR;
        }
    }

    private boolean isPossible() {
        return this.first != null && this.second != null;
    }

    private void clearSecondField(){
        this.second = null;
    }

    public void clearAllField(){
        this.first = null;
        this.second = null;
    }
}