package com.example.testmobile.utils.validator;

import android.text.Editable;
import android.text.TextWatcher;

import com.example.testmobile.utils.operators.Operations;

@Deprecated
public class TextValidatorImpl implements TextWatcher, Validator {

    private Operations numbers, signs, money, clears;

    public TextValidatorImpl(Operations numbers, Operations signs, Operations money, Operations clears) {
        this.numbers = numbers;
        this.signs = signs;
        this.money = money;
        this.clears = clears;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        boolean isAccessible = charSequence.toString().isEmpty() || isMatchNameMinLength(charSequence);
        numbers.setAccessible(isAccessible);
        signs.setAccessible(isAccessible);
        money.setAccessible(isAccessible);
        clears.setAccessible(isAccessible);
    }

    private boolean isMatchNameMinLength(CharSequence charSequence) {
        return charSequence.toString().trim().length() > 3;
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}