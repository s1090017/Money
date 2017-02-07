package com.course.android.money;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Money_Main";
    private Button btn_calendar,btn_income,btn_expense,btn_settings;
    Intent intent = new Intent();
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_calendar:
                    intent.setClass(MainActivity.this,CalendarActivity.class);
                    startActivity(intent);
                    finish();
                    Log.d(TAG,"button calendar");
                    break;
                case R.id.btn_income:
                    intent.setClass(MainActivity.this,IncomeActivity.class);
                    startActivity(intent);
                    finish();
                    Log.d(TAG,"button income");
                    break;
                case R.id.btn_expense:
                    intent.setClass(MainActivity.this,ExpenseActivity.class);
                    startActivity(intent);
                    finish();
                    Log.d(TAG,"button expense");
                    break;
                case R.id.btn_settings:
                    intent.setClass(MainActivity.this,SettingsActivity.class);
                    startActivity(intent);
                    finish();
                    Log.d(TAG,"button settings");
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Log.d(TAG,"onCreate");
    }

    private void init() {
        btn_calendar = (Button)findViewById(R.id.btn_calendar);
        btn_income = (Button)findViewById(R.id.btn_income);
        btn_expense = (Button)findViewById(R.id.btn_expense);
        btn_settings = (Button)findViewById(R.id.btn_settings);

        btn_calendar.setOnClickListener(clickListener);
        btn_income.setOnClickListener(clickListener);
        btn_expense.setOnClickListener(clickListener);
        btn_settings.setOnClickListener(clickListener);
    }

    public  boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                //do nothing
                break;
            case R.id.calendar_statistics:
                intent.setClass(MainActivity.this,CalendarActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.income:
                intent.setClass(MainActivity.this,IncomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.expense:
                intent.setClass(MainActivity.this,ExpenseActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.settings:
                intent.setClass(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

}
