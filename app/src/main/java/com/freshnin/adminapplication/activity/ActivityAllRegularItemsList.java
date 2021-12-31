package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.adapter.AdapterAllRegularItemsRecy;
import com.freshnin.adminapplication.model.ModelRegularItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityAllRegularItemsList extends AppCompatActivity {

    private Toolbar toolbar;
    TextView btnAddNewItem;

    private RecyclerView allRegularItemRecy;
    private AdapterAllRegularItemsRecy adapterAllRegularItemsRecy;
    private List<ModelRegularItem> modelRegularItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_regular_items_list);

        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnAddNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityAllRegularItemsList.this, ActivityAddRegularItem.class));
            }
        });
    }

    private void init(){
        toolbar=findViewById(R.id.aaril_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("All Items");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        modelRegularItemList=new ArrayList<>();

        btnAddNewItem=findViewById(R.id.aaril_btn_add_new_item);

        modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Doi"
        ));

        modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Khirsha"
        ));
        modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Doi"
        ));

        modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Khirsha"
        ));
        modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Doi"
        ));

        modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Khirsha"
        ));
        modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Doi"
        ));

        modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Doi"
        ));

        modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Khirsha"
        ));modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Doi"
        ));

        modelRegularItemList.add(new ModelRegularItem(
                "Bogurar Khirsha"
        ));

        allRegularItemRecy=findViewById(R.id.aaril_recyc);
        allRegularItemRecy.setLayoutManager(new GridLayoutManager(this,2));
        adapterAllRegularItemsRecy=new AdapterAllRegularItemsRecy(modelRegularItemList,this);
        allRegularItemRecy.setAdapter(adapterAllRegularItemsRecy);

    }
}