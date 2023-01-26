package com.example.testmobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testmobile.utils.calculator.Calculator;
import com.example.testmobile.utils.listeners.EditorListenerImpl;
import com.example.testmobile.utils.operators.ClearOperations;
import com.example.testmobile.utils.operators.MoneyOperations;
import com.example.testmobile.utils.managers.TextCalculator;
import com.example.testmobile.utils.operators.NumbersOperations;
import com.example.testmobile.utils.operators.Operations;
import com.example.testmobile.utils.operators.SignalOperations;
import com.example.testmobile.utils.operators.SpecialButtonOperations;

public class CalculatorActivity extends AppCompatActivity {

    private TextCalculator resultView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_design_body);

//TextView
        TextView results = findViewById(R.id.tv_results);

//        Create the view manage the textView.
        this.resultView = new TextCalculator(results);

//        Money convertors buttons.
        Button dopDefaultButton;
        Button[] buttonsConvertors = {
                dopDefaultButton = findViewById(R.id.btn_dop),
                findViewById(R.id.btn_dollar),
                findViewById(R.id.btn_euro),
                findViewById(R.id.btn_franc)
        };
//      Manager to the MoneyConvertor
        SpecialButtonOperations moneyOperators = new MoneyOperations(this.resultView, buttonsConvertors, dopDefaultButton);
        moneyOperators.setOnclickListener();

        Button[] buttonsNumbers = {
                findViewById(R.id.btn_one),
                findViewById(R.id.btn_two),
                findViewById(R.id.btn_three),
                findViewById(R.id.btn_four),
                findViewById(R.id.btn_five),
                findViewById(R.id.btn_six),
                findViewById(R.id.btn_seven),
                findViewById(R.id.btn_eight),
                findViewById(R.id.btn_nine),
                findViewById(R.id.btn_zero),
                findViewById(R.id.btn_point)
        };
//      Manager to the numeric pad.
        Operations numbersOperations = new NumbersOperations(buttonsNumbers, this.resultView);
        numbersOperations.setOnclickListener();

        Calculator calculator = new Calculator();

//        Operations buttons
        Button[] buttonsSigns = {
                findViewById(R.id.btn_sum),
                findViewById(R.id.btn_subtract),
                findViewById(R.id.btn_multiply),
                findViewById(R.id.btn_divide),
                findViewById(R.id.btn_equals)
        };
//      Manager of the operations calculator.
        SpecialButtonOperations signsOperations = new SignalOperations(buttonsSigns, this.resultView, calculator);
        signsOperations.setOnclickListener();

        Button[] clearButtons = {
                findViewById(R.id.btn_simple_clear),
                findViewById(R.id.btn_full_clear)
        };

        ClearOperations.ExternalActions fullClearActions = () -> ((SignalOperations) signsOperations).clearComponentsActions();
        Operations clearOperations = new ClearOperations(resultView, clearButtons, calculator, fullClearActions);
        clearOperations.setOnclickListener();

//      Check this for latest versions
        EditText userNameEditable = findViewById(R.id.edit_username);
        Operations[] buttonsOperations = {numbersOperations, signsOperations, moneyOperators, clearOperations};

        TextView.OnEditorActionListener textWatcher = new EditorListenerImpl(buttonsOperations);
        userNameEditable.setOnEditorActionListener(textWatcher);
    }
}