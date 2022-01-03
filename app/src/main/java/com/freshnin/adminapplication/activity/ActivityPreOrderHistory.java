package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.adapter.AdapterPreorderHistoryRecy;
import com.freshnin.adminapplication.model.ModelOngoingPreOrder;

import java.util.ArrayList;
import java.util.List;

public class ActivityPreOrderHistory extends AppCompatActivity {

    private static final String TAG = "ActivityPreOrderHistory";
    private Toolbar toolbar;
    private RecyclerView preOrderHistoryRecy;
    private AdapterPreorderHistoryRecy adapterPreOrderHistoryRecy;
    private List<ModelOngoingPreOrder> preOrderHistoryList;



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

        preOrderHistoryList=new ArrayList<>();
        preOrderHistoryList.add(new ModelOngoingPreOrder(
                "Bogurar Doi"
        ));
        preOrderHistoryList.add(new ModelOngoingPreOrder(
                "Bogurar Khirsha"
        ));
        preOrderHistoryList.add(new ModelOngoingPreOrder(
                "Bogurar Chomchom"
        ));
        preOrderHistoryList.add(new ModelOngoingPreOrder(
                "Bogurar Doi"
        ));

        preOrderHistoryRecy=findViewById(R.id.apoh_preOrderHistoryRecy);
        preOrderHistoryRecy.setLayoutManager(new LinearLayoutManager(ActivityPreOrderHistory.this));
        adapterPreOrderHistoryRecy=new AdapterPreorderHistoryRecy(preOrderHistoryList, ActivityPreOrderHistory.this);
        preOrderHistoryRecy.setAdapter(adapterPreOrderHistoryRecy);

    }
}