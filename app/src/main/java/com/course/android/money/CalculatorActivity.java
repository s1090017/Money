package com.course.android.money;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {
    private static final String TAG = "Calculator_Main";
    private Button btn_zero,btn_one,btn_two,btn_three,btn_four,btn_five,btn_six,btn_seven,btn_eight,btn_nine,btn_dot,btn_equal,btn_divide,btn_multiply,btn_subtract,btn_add,btn_cancel,btn_ok;
    private EditText et_input_money;
    String input = "0",intent_income_name = "0",intent_expense_name="0";
    int result = 0;
    char operator = ' ';


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_zero:
                case R.id.btn_one:
                case R.id.btn_two:
                case R.id.btn_three:
                case R.id.btn_four:
                case R.id.btn_five:
                case R.id.btn_six:
                case R.id.btn_seven:
                case R.id.btn_eight:
                case R.id.btn_nine:
                    String digit = ((Button) view).getText().toString();
                            if (input.equals("0")) {
                                input = digit;
                            }
                            else {
                                input = input + digit;
                            }
                            et_input_money.setText(input);
                            if (operator == '=') {
                                result = 0;
                                operator = ' ';
                            }
                            break;

                //case R.id.btn_dot:
                case R.id.btn_equal:
                    compute();
                    operator = '=';
                    break;
                case R.id.btn_divide:
                    compute();
                    operator = '/';
                    break;
                case R.id.btn_multiply:
                    compute();
                    operator = '*';
                    break;
                case R.id.btn_subtract:
                    compute();
                    operator = '-';
                    break;
                case R.id.btn_add:
                    compute();
                    operator = '+';
                    break;
                case R.id.btn_cancel:
                    result = 0;
                    input = "0";
                    operator = ' ';
                    et_input_money.setText("0");
                    break;
                case R.id.btn_ok:
                    intent_income_name = getIntent().getExtras().getString("IncomeActivity");
                    intent_expense_name = getIntent().getExtras().getString("ExpenseActivity");
                    Log.d(TAG,"intent_income_name="+intent_income_name);
                    Log.d(TAG,"intent_expense_name="+intent_expense_name);
                    if(intent_income_name == null){
                        intent_income_name = "no income";
                    }
                    else if(intent_expense_name == null){
                        intent_expense_name = "no expense";
                    }

                    if(intent_income_name.compareTo("IncomeActivity") == 0){
                        Intent intent = new Intent(CalculatorActivity.this,IncomeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("input_money",Integer.toString(result));
                        intent.putExtras(bundle);
                        startActivity(intent);
                        Log.d(TAG,"btn_ok_result="+result);
                        finish();
                    }
                    else if(intent_expense_name.compareTo("ExpenseActivity") == 0){
                        Intent intent = new Intent(CalculatorActivity.this,ExpenseActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("input_money",Integer.toString(result));
                        intent.putExtras(bundle);
                        startActivity(intent);
                        Log.d(TAG,"btn_ok_result="+result);
                        finish();
                    }

                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();
        Log.d(TAG,"onCreate");
    }

    private void init(){
        et_input_money = (EditText)findViewById(R.id.et_input_money);
        btn_zero = (Button)findViewById(R.id.btn_zero);
        btn_one = (Button)findViewById(R.id.btn_one);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_five = (Button)findViewById(R.id.btn_five);
        btn_six = (Button)findViewById(R.id.btn_six);
        btn_seven = (Button)findViewById(R.id.btn_seven);
        btn_eight = (Button)findViewById(R.id.btn_eight);
        btn_nine = (Button)findViewById(R.id.btn_nine);
        btn_dot = (Button)findViewById(R.id.btn_dot);
        btn_equal = (Button)findViewById(R.id.btn_equal);
        btn_divide = (Button)findViewById(R.id.btn_divide);
        btn_multiply = (Button)findViewById(R.id.btn_multiply);
        btn_subtract = (Button)findViewById(R.id.btn_subtract);
        btn_add = (Button)findViewById(R.id.btn_add);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_ok = (Button)findViewById(R.id.btn_ok);

        btn_zero.setOnClickListener(clickListener);
        btn_one.setOnClickListener(clickListener);
        btn_two.setOnClickListener(clickListener);
        btn_three.setOnClickListener(clickListener);
        btn_four.setOnClickListener(clickListener);
        btn_five.setOnClickListener(clickListener);
        btn_six.setOnClickListener(clickListener);
        btn_seven.setOnClickListener(clickListener);
        btn_eight.setOnClickListener(clickListener);
        btn_nine.setOnClickListener(clickListener);
        btn_dot.setOnClickListener(clickListener);
        btn_equal.setOnClickListener(clickListener);
        btn_divide.setOnClickListener(clickListener);
        btn_multiply.setOnClickListener(clickListener);
        btn_subtract.setOnClickListener(clickListener);
        btn_add.setOnClickListener(clickListener);
        btn_cancel.setOnClickListener(clickListener);
        btn_ok.setOnClickListener(clickListener);

        et_input_money.addTextChangedListener(textWatcher);
    }

    private void compute() {
        int num = Integer.parseInt(input);
        input = "0";
        if (operator == ' ') {
            result = num;
        }
        else if (operator == '/') {
            result = result / num;
        }
        else if (operator == '*') {
            result = result * num;
        }
        else if (operator == '-') {
            result = result - num;
        }
        else if (operator == '+') {
            result = result + num;
        }
        et_input_money.setText(String.valueOf(result));
        Log.d(TAG,"after num="+num+",result="+result);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            try {
                //tv_show_money.setText(et_input_money.getText().toString());
            } catch (Exception e){
                Log.d(TAG,"error");
            }
        }
    };
}
