package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.freshnin.adminapplication.R;

public class ActivityLogIn extends AppCompatActivity {

    private Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        init();

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityLogIn.this, ActivityPreOrderAllSession.class));
            }
        });


    }

    private void init(){
        btnLogIn = findViewById(R.id.al_btnLogin);
    }
}