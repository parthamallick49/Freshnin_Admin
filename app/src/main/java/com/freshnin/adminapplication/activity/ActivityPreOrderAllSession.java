package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.adapter.AdapterPreOrderAllSessionRecy;
import com.freshnin.adminapplication.callbacks.AdapterPreOrderAllSessionCallbacks;
import com.freshnin.adminapplication.databinding.ActivityPreOrderAllSessionBinding;
import com.freshnin.adminapplication.model.ModelPreOrder;
import com.freshnin.adminapplication.tools.Tools;
import com.freshnin.adminapplication.viewmodel.ViewModelAdminApp;

import java.util.ArrayList;
import java.util.List;

public class ActivityPreOrderAllSession extends AppCompatActivity implements AdapterPreOrderAllSessionCallbacks {

    private static final String TAG = "ActivityPreOrderAllSession";
    private ActivityPreOrderAllSessionBinding binding;

    private AdapterPreOrderAllSessionRecy adapterPreOrderAllSessionRecy;
    private List<ModelPreOrder> preOrderList;
    private Dialog dialogLoading;
    private ViewModelAdminApp viewModelAdminApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPreOrderAllSessionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();


        binding.apsaPreOrderListToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.apsaCreateNewSeeion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityPreOrderAllSession.this,ActivityCreateNewSession.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllPreOrderSession();
    }

    private void init(){
        setSupportActionBar(binding.apsaPreOrderListToolbar);
        getSupportActionBar().setTitle("Pre-Order Sessions");

        viewModelAdminApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelAdminApp.class);
        dialogLoading= Tools.setupLoadingDialog(ActivityPreOrderAllSession.this);


        preOrderList=new ArrayList<>();
        adapterPreOrderAllSessionRecy =new AdapterPreOrderAllSessionRecy(preOrderList,this,this);


        binding.apsaPreOrderFoodRecy.setLayoutManager(new LinearLayoutManager(this));
        binding.apsaPreOrderFoodRecy.setAdapter(adapterPreOrderAllSessionRecy);
    }

    void getAllPreOrderSession(){
        dialogLoading.show();
        viewModelAdminApp.getAllPreOrderSessions().observe(this, new Observer<List<ModelPreOrder>>() {
            @Override
            public void onChanged(List<ModelPreOrder> modelPreOrders) {
                Log.d(TAG, "onChanged: called");

                dialogLoading.dismiss();
                if(modelPreOrders!=null){
                    preOrderList.clear();
                    preOrderList.addAll(modelPreOrders);
                    adapterPreOrderAllSessionRecy.notifyDataSetChanged();
                }else {
                    Toast.makeText(ActivityPreOrderAllSession.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemClicked(int pos) {
        startActivity(new Intent(ActivityPreOrderAllSession.this,ActivityPreOrderProductDetails.class)
         .putExtra("data",preOrderList.get(pos)));
    }
}