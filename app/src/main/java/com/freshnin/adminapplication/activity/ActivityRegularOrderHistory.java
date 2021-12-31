package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.adapter.AdapterOnGoingOrderRecy;
import com.freshnin.adminapplication.model.ModelOnGoingOrder;

import java.util.ArrayList;
import java.util.List;

public class ActivityRegularOrderHistory extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView onGoingOrdersRecy;
    private AdapterOnGoingOrderRecy adapterOnGoingOrderRecy;
    private List<ModelOnGoingOrder> onGoingOrderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.activity_regular_order_history);

        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void init(){
        toolbar=findViewById(R.id.aroh_regularOrder_history_list_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        onGoingOrderList=new ArrayList<>();
        onGoingOrdersRecy=findViewById(R.id.aroh_regularOrderHistoryRecy);
        onGoingOrdersRecy.setLayoutManager(new LinearLayoutManager(this));
        adapterOnGoingOrderRecy=new AdapterOnGoingOrderRecy(onGoingOrderList,ActivityRegularOrderHistory.this);
        onGoingOrdersRecy.setAdapter(adapterOnGoingOrderRecy);
    }
}