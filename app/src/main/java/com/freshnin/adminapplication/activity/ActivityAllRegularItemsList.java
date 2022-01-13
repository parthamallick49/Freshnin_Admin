package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.adapter.AdapterAllRegularItemsRecy;
import com.freshnin.adminapplication.callbacks.AdapterAllRegularItemsRecyCallBacks;
import com.freshnin.adminapplication.databinding.ActivityAllRegularItemsListBinding;
import com.freshnin.adminapplication.model.ModelRegularItem;
import com.freshnin.adminapplication.model.ModelResponse;
import com.freshnin.adminapplication.tools.Tools;
import com.freshnin.adminapplication.viewmodel.ViewModelAdminApp;

import java.util.ArrayList;
import java.util.List;

public class ActivityAllRegularItemsList extends AppCompatActivity implements AdapterAllRegularItemsRecyCallBacks {
    private static final String TAG = "ActivityAllRegularItemsList";
    private ActivityAllRegularItemsListBinding binding;


    private AdapterAllRegularItemsRecy adapterAllRegularItemsRecy;
    private List<ModelRegularItem> regularItemList;

    private Dialog dialogLoading;
    private ViewModelAdminApp viewModelAdminApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAllRegularItemsListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        binding.aarilToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.aarilBtnAddNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityAllRegularItemsList.this, ActivityAddRegularItem.class));
            }
        });
    }

    private void init(){
        setSupportActionBar(binding.aarilToolbar);
        getSupportActionBar().setTitle("All Items");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewModelAdminApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelAdminApp.class);
        dialogLoading= Tools.setupLoadingDialog(ActivityAllRegularItemsList.this);

        regularItemList =new ArrayList<>();
        adapterAllRegularItemsRecy=new AdapterAllRegularItemsRecy(regularItemList,this,this);
        binding.aarilRecyc.setAdapter(adapterAllRegularItemsRecy);
        binding.aarilRecyc.setLayoutManager(new GridLayoutManager(this,2));

    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllItems();
    }

    void getAllItems(){
        dialogLoading.show();
        viewModelAdminApp.getAllItem().observe(this, new Observer<List<ModelRegularItem>>() {
            @Override
            public void onChanged(List<ModelRegularItem> modelRegularItems) {
                dialogLoading.dismiss();
                if(modelRegularItems!=null){
                    regularItemList.clear();
                    regularItemList.addAll(modelRegularItems);
                    adapterAllRegularItemsRecy.notifyDataSetChanged();
                }else{
                    Toast.makeText(ActivityAllRegularItemsList.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onDeleteClicked(int pos) {
        dialogLoading.show();
        viewModelAdminApp.deleteRegularItemById(regularItemList.get(pos)).observe(this, new Observer<ModelResponse>() {
            @Override
            public void onChanged(ModelResponse modelResponse) {
                dialogLoading.dismiss();
                if(modelResponse!=null && modelResponse.getResponse()==1){
                    Toast.makeText(ActivityAllRegularItemsList.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                    regularItemList.remove(pos);
                    adapterAllRegularItemsRecy.notifyDataSetChanged();
                }else{
                    Toast.makeText(ActivityAllRegularItemsList.this, "Failed to Delete Item!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemClicked(int pos) {
        startActivity(new Intent(ActivityAllRegularItemsList.this,ActivityFoodItemDetails.class)
            .putExtra("data",regularItemList.get(pos)));
    }
}