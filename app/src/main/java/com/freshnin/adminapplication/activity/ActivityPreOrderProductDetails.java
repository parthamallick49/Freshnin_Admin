package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.freshnin.adminapplication.R;

public class ActivityPreOrderProductDetails extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_order_product_details);

        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void init(){
        toolbar=findViewById(R.id.apopd_toolbarActivityProfuctDetails);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white,null));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }
}