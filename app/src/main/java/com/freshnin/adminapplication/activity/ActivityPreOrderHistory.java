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
import com.freshnin.adminapplication.adapter.AdapterPreorderHistoryRecy;
import com.freshnin.adminapplication.callbacks.AdapterPreorderHistoryRecyCallbacks;
import com.freshnin.adminapplication.model.ModelOngoingPreOrder;
import com.freshnin.adminapplication.tools.Tools;
import com.freshnin.adminapplication.viewmodel.ViewModelAdminApp;

import java.util.ArrayList;
import java.util.List;

public class ActivityPreOrderHistory extends AppCompatActivity implements AdapterPreorderHistoryRecyCallbacks {

    private static final String TAG = "ActivityPreOrderHistory";
    private Toolbar toolbar;
    private RecyclerView preOrderHistoryRecy;
    private AdapterPreorderHistoryRecy adapterPreOrderHistoryRecy;
    private List<ModelOngoingPreOrder> preOrderHistoryList;
    private Dialog dialogLoading;
    private ViewModelAdminApp viewModelAdminApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_order_history);

        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    private void init(){
        toolbar=findViewById(R.id.apoh_preOrder_history_list_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewModelAdminApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelAdminApp.class);
        dialogLoading= Tools.setupLoadingDialog(ActivityPreOrderHistory.this);

        preOrderHistoryRecy=findViewById(R.id.apoh_preOrderHistoryRecy);
        preOrderHistoryRecy.setLayoutManager(new LinearLayoutManager(ActivityPreOrderHistory.this));
        preOrderHistoryList=new ArrayList<>();
        adapterPreOrderHistoryRecy=new AdapterPreorderHistoryRecy(preOrderHistoryList, ActivityPreOrderHistory.this,this);
        preOrderHistoryRecy.setAdapter(adapterPreOrderHistoryRecy);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllOngoingOrders();
    }

    void getAllOngoingOrders(){
        dialogLoading.show();
        viewModelAdminApp.getAllPreOrders().observe(this, new Observer<List<ModelOngoingPreOrder>>() {
            @Override
            public void onChanged(List<ModelOngoingPreOrder> modelOngoingPreOrders) {
                dialogLoading.dismiss();
                if(modelOngoingPreOrders!=null){
                    preOrderHistoryList.clear();
                    for(ModelOngoingPreOrder order:modelOngoingPreOrders){
                        if(Integer.parseInt(order.getOrderStatus())<3){
                            Log.d(TAG, "onChanged: "+order.getItemName());
                            preOrderHistoryList.add(order);
                        }
                    }
                    adapterPreOrderHistoryRecy.notifyDataSetChanged();
                }else {
                    Toast.makeText(ActivityPreOrderHistory.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemClicked(int pos) {
        startActivity(new Intent(ActivityPreOrderHistory.this,ActivityPreOrderDetails.class)
          .putExtra("data",preOrderHistoryList.get(pos)));
    }
}