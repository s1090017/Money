package com.course.android.money;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import static com.course.android.money.R.id.cv;
import static com.course.android.money.R.id.tv_to_day;


public class IncomeActivity extends AppCompatActivity {
    private static final String TAG = "Income_Activity";
    private Button btn_add_money,btn_regular_income,btn_nonfixed_income,btn_note,btn_cancel,btn_ok,btn_choice_day;
    private TextView tv_total_money,tv_add_result;
    private EditText et_note;
    CalendarView cv;
    String str="",str_day="";
    int Myear,Mmonth,Mday;
    Intent intent = new Intent();

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_add_money:
                    intent.setClass(IncomeActivity.this,CalculatorActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("IncomeActivity","IncomeActivity");
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                    Log.d(TAG,"button add_money");
                    break;
                case R.id.btn_regular_income:
                    str = "regular income";
                    cv.setVisibility(View.GONE);
                    //Log.d(TAG,"button regular_income");
                    break;
                case R.id.btn_nonfixed_income:
                    str = "non-fixed income";
                    cv.setVisibility(View.GONE);
                    //Log.d(TAG,"button non-fixed_income");
                    break;
                case R.id.btn_note:
                    et_note.setVisibility(View.VISIBLE);
                    cv.setVisibility(View.GONE);
                    break;
                case R.id.btn_cancel:
                    tv_total_money.setText("");
                    et_note.setText("");
                    tv_add_result.setText("");
                    et_note.setVisibility(View.GONE);
                    str = "";
                    cv.setVisibility(View.GONE);
                    Log.d(TAG,"button cancel");
                    break;
                case R.id.btn_ok:
                    cv.setVisibility(View.GONE);
                    tv_add_result.setText(str_day+"\n"+tv_total_money.getText().toString()+"\n"+str+"\n"+et_note.getText().toString());
                    Log.d(TAG,"button ok");
                    break;
                case R.id.btn_choice_day:
                    cv.setVisibility(View.VISIBLE);
                    et_note.setVisibility(View.GONE);
                    cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                        @Override
                        public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                            Myear = year;
                            Mmonth = month;
                            Mday = dayOfMonth;
                            str_day = new StringBuilder().append(Myear).append("-").append(Mmonth+1).append("-").append(Mday).toString();
                        }
                    });
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        init();
        Log.d(TAG,"onCreate");
    }

    private void init(){
        tv_total_money = (TextView)findViewById(R.id.tv_total_money);
        btn_add_money = (Button)findViewById(R.id.btn_add_money);
        btn_regular_income = (Button)findViewById(R.id.btn_regular_income);
        btn_nonfixed_income = (Button)findViewById(R.id.btn_nonfixed_income);
        btn_note = (Button)findViewById(R.id.btn_note);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_ok = (Button)findViewById(R.id.btn_ok);
        btn_choice_day = (Button)findViewById(R.id.btn_choice_day);
        et_note = (EditText)findViewById(R.id.et_note);
        tv_add_result = (TextView)findViewById(R.id.tv_add_result);
        cv = (CalendarView)findViewById(R.id.cv);

        btn_add_money.setOnClickListener(clickListener);
        btn_regular_income.setOnClickListener(clickListener);
        btn_nonfixed_income.setOnClickListener(clickListener);
        btn_note.setOnClickListener(clickListener);
        btn_cancel.setOnClickListener(clickListener);
        btn_ok.setOnClickListener(clickListener);
        btn_choice_day.setOnClickListener(clickListener);
        et_note.setVisibility(View.GONE);
        cv.setVisibility(View.GONE);

        Intent intent = this.getIntent();
        Log.d(TAG,"intent="+intent);
        if(intent != null){
            Log.d(TAG,"intent != null");
            Bundle bundle = intent.getExtras();
            if (bundle != null){
                tv_total_money.setText("add income is "+bundle.getString("input_money")+" "+"dollars");
            }
        }
        else{
            Log.d(TAG,"intent is null");
        }
    }

    public  boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                intent.setClass(IncomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.calendar_statistics:
                intent.setClass(IncomeActivity.this,CalendarActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.income:
                //do nothing
                break;
            case R.id.expense:
                intent.setClass(IncomeActivity.this,ExpenseActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.settings:
                intent.setClass(IncomeActivity.this,SettingsActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

}
