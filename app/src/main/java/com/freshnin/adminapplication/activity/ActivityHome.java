package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.freshnin.adminapplication.adapter.AdapterAdminOptions;
import com.freshnin.adminapplication.callbacks.AdapterAdminOptionsCallbacks;
import com.freshnin.adminapplication.databinding.ActivityHomeBinding;
import com.freshnin.adminapplication.tools.GlobalKey;
import com.freshnin.adminapplication.tools.Tools;

import java.util.ArrayList;
import java.util.List;

public class ActivityHome extends AppCompatActivity implements AdapterAdminOptionsCallbacks {
    private static final String TAG = "ActivityHome";
    private ActivityHomeBinding binding;

    List<String> options;
    AdapterAdminOptions adapterAdminOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        init();
    }

    void init(){

        options=generateOptions();
        adapterAdminOptions=new AdapterAdminOptions(this,options,this);

        binding.recycOptions.setAdapter(adapterAdminOptions);
        binding.recycOptions.setLayoutManager(new LinearLayoutManager(this));
    }

    List<String> generateOptions(){
        List<String> temp=new ArrayList<>();
        temp.add("Pre-Order Sessions");
        temp.add("Regular Item");
        temp.add("Pre-Order Booking Info");
        temp.add("Regular-Order Booking Info");
        temp.add("Logout");
        return temp;
    }

    @Override
    public void onOptionClicked(int pos) {
        switch (pos){
            case 0:
                startActivity(new Intent(ActivityHome.this, ActivityPreOrderAllSession.class));
                break;
            case 1:
                startActivity(new Intent(ActivityHome.this, ActivityAllRegularItemsList.class));
                break;
            case 2:
                startActivity(new Intent(ActivityHome.this,ActivityPreOrderHistory.class));
                break;
            case 3:
                startActivity(new Intent(ActivityHome.this,ActivityRegularOrderHistory.class));
                break;
            case 4:
                Tools.savePrefBoolean(GlobalKey.IS_LOGGED_IN,false);
                startActivity(new Intent(ActivityHome.this,ActivityLogIn.class));finish();
                break;
        }
    }
}