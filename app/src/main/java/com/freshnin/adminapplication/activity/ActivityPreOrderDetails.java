package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.freshnin.adminapplication.R;

public class ActivityPreOrderDetails extends AppCompatActivity {

    private static final String TAG = "ActivityPreOrderDetails";
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_order_details);

        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void init(){
        toolbar=findViewById(R.id.apod_preOrder_Details_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

    }
}