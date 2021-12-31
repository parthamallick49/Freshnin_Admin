package com.freshnin.adminapplication.activity;

import static android.media.CamcorderProfile.get;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.freshnin.adminapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ActivityCreateNewSession extends AppCompatActivity {

    final Calendar myCalendar= Calendar.getInstance();
    EditText etSessionStartDate,etSessionEndDate;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_session);

        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        DatePickerDialog.OnDateSetListener sessionStart = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                sessionStartDate();
            }
        };

        DatePickerDialog.OnDateSetListener sessionEnd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                sessionEndDate();
            }
        };


        etSessionStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ActivityCreateNewSession.this,sessionStart,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        etSessionEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ActivityCreateNewSession.this,sessionEnd,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void init(){
        toolbar=findViewById(R.id.acns_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etSessionStartDate =findViewById(R.id.acns_et_product_session_startDate);
        etSessionEndDate=findViewById(R.id.acns_et_product_session_endDate);
    }

    private void sessionStartDate(){
        String myFormat="dd/MM/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        etSessionStartDate.setText(dateFormat.format(myCalendar.getTime()));

    }

    private void sessionEndDate(){
        String myFormat="dd/MM/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        etSessionEndDate.setText(dateFormat.format(myCalendar.getTime()));
    }
}