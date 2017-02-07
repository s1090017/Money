package com.course.android.money;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import static com.course.android.money.R.id.btn_add_money;
import static com.course.android.money.R.id.btn_ok;
import static com.course.android.money.R.id.tv_add_result;
import static com.course.android.money.R.id.tv_from_day;
import static com.course.android.money.R.id.tv_to_day;
import static com.course.android.money.R.id.tv_to_day;

public class CalendarActivity extends AppCompatActivity {
    private Button btn_start,btn_end,btn_cancel,btn_ok;
    TextView tv_from_day,tv_to_day,tv_total;
    CalendarView cv;
    int Myear,Mmonth,Mday;
    String str_from_day="",str_to_day="";
    Intent intent = new Intent();

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_start:
                    cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                        @Override
                        public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                            Myear = year;
                            Mmonth = month;
                            Mday = dayOfMonth;
                            str_from_day = new StringBuilder().append(Myear).append("-").append(Mmonth+1).append("-").append(Mday).toString();
                            tv_from_day.setText(str_from_day);
                        }
                    });
                    break;
                case R.id.btn_end:
                    cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                        @Override
                        public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                            Myear = year;
                            Mmonth = month;
                            Mday = dayOfMonth;
                            str_to_day = new StringBuilder().append(Myear).append("-").append(Mmonth+1).append("-").append(Mday).toString();
                            tv_to_day.setText(str_to_day);
                        }
                    });
                    break;
                case R.id.btn_cancel:
                    tv_from_day.setText("");
                    tv_to_day.setText("");
                    cv.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_ok:
                    cv.setVisibility(View.GONE);
                    tv_total.setText("from "+str_from_day+" to "+str_to_day+"\n"+"income: 10000"+"\n"+"expense: 5000");
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        init();
    }
    private void init(){
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_end = (Button)findViewById(R.id.btn_end);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_ok = (Button)findViewById(R.id.btn_ok);
        tv_from_day = (TextView)findViewById(R.id.tv_from_day);
        tv_to_day = (TextView)findViewById(R.id.tv_to_day);
        cv = (CalendarView)findViewById(R.id.cv);
        tv_total = (TextView)findViewById(R.id.tv_total);

        btn_start.setOnClickListener(clickListener);
        btn_end.setOnClickListener(clickListener);
        btn_cancel.setOnClickListener(clickListener);
        btn_ok.setOnClickListener(clickListener);

    }

    public  boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                intent.setClass(CalendarActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.calendar_statistics:
                //do nothing
                break;
            case R.id.income:
                intent.setClass(CalendarActivity.this,IncomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.expense:
                intent.setClass(CalendarActivity.this,ExpenseActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.settings:
                intent.setClass(CalendarActivity.this,SettingsActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                return false;
        }
        return super.onOptionsItemSelected(item);
    }
}
