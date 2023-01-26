package com.example.testmobile.utils.convertors;

import static java.math.RoundingMode.HALF_EVEN;
import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MoneyConvertor {

    //    Change the amount for the actual in case to refactor.
    public static final double DOP_DOLLAR_AMOUNT = 53.38D;
    public static final double DOP_EURO_AMOUNT = 52.51D;
    public static final double DOP_FRANC_AMOUNT = 54.57D;

    public static final double DOLLAR_FRANC_AMOUNT = 0.97D;
    public static final double DOLLAR_EURO_AMOUNT = 1.01D;

    public static final double EURO_FRANC_AMOUNT = 1.03D;

    public static final int DEFAULT_SCALE = 4;

    public MoneyConvertor() {
    }

    //    DOP conversion
    public BigDecimal DOPtoDollar(double amount) {
        return getDivide(amount, DOP_DOLLAR_AMOUNT, DEFAULT_SCALE);
    }

    public BigDecimal DOLLARtoDOP(double amount) {
        return getMultiply(amount, DOP_DOLLAR_AMOUNT);
    }

    public BigDecimal DOPtoEURO(double amount) {
        return getDivide(amount,DOP_EURO_AMOUNT, DEFAULT_SCALE);
    }

    public BigDecimal EUROtoDOP(double amount) {
        return getMultiply(amount, DOP_EURO_AMOUNT);
    }

    public BigDecimal DOPtoFRANC(double amount) {
        return getDivide(amount,DOP_FRANC_AMOUNT, DEFAULT_SCALE);
    }

    public BigDecimal FRANCtoDOP(double amount) {
        return getMultiply(amount, DOP_FRANC_AMOUNT);
    }


    //    DOLLAR conversion
    public BigDecimal DOLLARtoFRANC(double amount) {
        return getDivide(amount, DOLLAR_FRANC_AMOUNT, DEFAULT_SCALE);
    }

    public BigDecimal FRANCtoDOLLAR(double amount) {
        return getMultiply(amount, DOLLAR_FRANC_AMOUNT);
    }

    public BigDecimal DOLLARtoEURO(double amount) {
        return getDivide(amount, DOLLAR_EURO_AMOUNT, DEFAULT_SCALE);
    }

    public BigDecimal EUROtoDOLLAR(double amount) {
        return getMultiply(amount, DOLLAR_EURO_AMOUNT);
    }

    //    FRANC corversion

    public BigDecimal FRANCtoEURO(double amount) {
        return getDivide(amount, EURO_FRANC_AMOUNT, DEFAULT_SCALE);
    }
    public BigDecimal EUROtoFRANC(double amount) {
        return getMultiply(amount, EURO_FRANC_AMOUNT);
    }

//    Privates values

    private BigDecimal getDivide(double amount, double amountToConvert, int scale) {
        return getBigDecimal(amount)
                .divide(getDefaultBigDecimal(amountToConvert), scale, HALF_UP);
    }

    private BigDecimal getMultiply(double amount, double amountToConvert) {
        return getBigDecimal(amount)
                .multiply(getDefaultBigDecimal(amountToConvert), MathContext.DECIMAL128)
                .setScale(DEFAULT_SCALE, HALF_EVEN);
    }

    private BigDecimal getBigDecimal(double amount) {
        return BigDecimal.valueOf(amount).setScale(2, HALF_UP);
    }

    private BigDecimal getDefaultBigDecimal(double amount) {
        return BigDecimal.valueOf(amount);
    }

}
