package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.adapter.AdapterOnGoingOrderDetailsBillingRecy;
import com.freshnin.adminapplication.adapter.AdapterOnGoingOrderDetailsFoodListRecy;
import com.freshnin.adminapplication.model.ModelRegularItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityOnGoingOrderDetails extends AppCompatActivity {
    private static final String TAG = "Cannot invoke method length() on null object";

    private Toolbar toolbar;


    private RecyclerView onGoingOrderProdeuctRecy;
    private AdapterOnGoingOrderDetailsFoodListRecy adapterOnGoingOrderDetailsFoodListRecy;
    private List<ModelRegularItem> foodItemList;

    private RecyclerView onGoingOrderBillingRecy;
    private AdapterOnGoingOrderDetailsBillingRecy adapterOnGoingOrderDetailsBillingRecy;
    private List<ModelRegularItem> billingFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_going_order_details);

        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void init(){
        toolbar=findViewById(R.id.aogod_onGOingOrder_details_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodItemList=new ArrayList<>();
        billingFoodList=new ArrayList<>();

        onGoingOrderProdeuctRecy =findViewById(R.id.aogod_productList_recy);
        onGoingOrderProdeuctRecy.setLayoutManager(new LinearLayoutManager(ActivityOnGoingOrderDetails.this));
        adapterOnGoingOrderDetailsFoodListRecy=new AdapterOnGoingOrderDetailsFoodListRecy(foodItemList,ActivityOnGoingOrderDetails.this);
        onGoingOrderProdeuctRecy.setAdapter(adapterOnGoingOrderDetailsFoodListRecy);

        onGoingOrderBillingRecy=findViewById(R.id.aogod_billing_list_recy);
        onGoingOrderBillingRecy.setLayoutManager(new LinearLayoutManager(ActivityOnGoingOrderDetails.this));
        adapterOnGoingOrderDetailsBillingRecy=new AdapterOnGoingOrderDetailsBillingRecy(billingFoodList,ActivityOnGoingOrderDetails.this);
        onGoingOrderBillingRecy.setAdapter(adapterOnGoingOrderDetailsBillingRecy);
    }
}