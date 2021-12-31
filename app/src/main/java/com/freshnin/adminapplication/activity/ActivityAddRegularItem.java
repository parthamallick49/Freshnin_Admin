package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.freshnin.adminapplication.R;

public class ActivityAddRegularItem extends AppCompatActivity {


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_regular_item);

        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void init(){
        toolbar=findViewById(R.id.aari_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}