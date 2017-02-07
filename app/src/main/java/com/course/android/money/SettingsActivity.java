package com.course.android.money;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class SettingsActivity extends AppCompatActivity {
    private static final String TAG = "Settings_Main";
    private Button btn_budget,btn_export;
    private NumberPicker mNumberPicker;
    Intent intent = new Intent();
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_budget:
                    Log.d(TAG,"budget");
                    break;
                case R.id.btn_export:
                    Log.d(TAG,"export");
                    break;

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        init();
        Log.d(TAG,"onCreate");
    }

    private void init(){
        btn_budget = (Button)findViewById(R.id.btn_budget);
        btn_export = (Button)findViewById(R.id.btn_export);
        //mNumberPicker = (NumberPicker)findViewById(R.id.show_num_picker);

        btn_budget.setOnClickListener(clickListener);
        btn_export.setOnClickListener(clickListener);
        /*mNumberPicker.setOnClickListener(clickListener);
        mNumberPicker.setOnScrollListener(this);
        mNumberPicker.setMinValue(1);
        mNumberPicker.setMaxValue(31);
        mNumberPicker.setValue(10);*/
    }

    public void onScrollStateChanged(NumberPicker view, int scrollState){
        switch (scrollState){
            //case SCROLL_STA;
        }
    }

    public  boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                intent.setClass(SettingsActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.calendar_statistics:
                intent.setClass(SettingsActivity.this,CalendarActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.income:
                intent.setClass(SettingsActivity.this,IncomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.expense:
                intent.setClass(SettingsActivity.this,ExpenseActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.settings:
                //do nothing
                break;
            default:
                return false;
        }
        return super.onOptionsItemSelected(item);
    }
}
