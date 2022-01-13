package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.databinding.ActivityLogInBinding;
import com.freshnin.adminapplication.tools.GlobalKey;
import com.freshnin.adminapplication.tools.Tools;

public class ActivityLogIn extends AppCompatActivity {
    private static final String TAG = "ActivityLogIn";
    private ActivityLogInBinding binding;


    private final String adminId="2580";
    private final String pass="ragib123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(checkLoginStatus()){
            startActivity(new Intent(ActivityLogIn.this,ActivityHome.class));finish();
        }

        binding.alBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.alTietUserPhoneNumber.getText().toString().isEmpty() || binding.alTietUserPassword.getText().toString().isEmpty()){

                    Toast.makeText(ActivityLogIn.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }else{
                    if(binding.alTietUserPhoneNumber.getText().toString().equals(adminId) && binding.alTietUserPassword.getText().toString().equals(pass)){
                        Tools.savePrefBoolean(GlobalKey.IS_LOGGED_IN,true);
                        startActivity(new Intent(ActivityLogIn.this,ActivityHome.class));finish();
                    }else{
                        Toast.makeText(ActivityLogIn.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    boolean checkLoginStatus(){
        return Tools.getPrefBoolean(GlobalKey.IS_LOGGED_IN,false);
    }
}