package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.adapter.AdapterPreOrderAllSessionRecy;
import com.freshnin.adminapplication.model.ModelPreOrder;

import java.util.ArrayList;
import java.util.List;

public class ActivityPreOrderAllSession extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView preOrderSessionRecy;
    private AdapterPreOrderAllSessionRecy adapterPreOrderAllSessionRecy;
    private List<ModelPreOrder> preOrderList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_order_all_session);
        init();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void init(){
        toolbar = findViewById(R.id.apsa_preOrder_list_toolbar);
        setSupportActionBar(toolbar);

        preOrderList=new ArrayList<>();
        preOrderList.add(new ModelPreOrder(
                "Bogurar Doi"
        ));
        preOrderList.add(new ModelPreOrder(
                "Bogurar Khirsha"
        ));
        preOrderList.add(new ModelPreOrder(
                "Bogurar ChomChom"
        ));
        preOrderList.add(new ModelPreOrder(
                "Bogurar Doi"
        ));
        preOrderSessionRecy=findViewById(R.id.apsa_pre_Order_FoodRecy);
        preOrderSessionRecy.setLayoutManager(new LinearLayoutManager(this));
        adapterPreOrderAllSessionRecy =new AdapterPreOrderAllSessionRecy(preOrderList,this);
        preOrderSessionRecy.setAdapter(adapterPreOrderAllSessionRecy);


    }
}