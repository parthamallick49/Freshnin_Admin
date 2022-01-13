package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.databinding.ActivityPreOrderProductDetailsBinding;
import com.freshnin.adminapplication.model.ModelPreOrder;
import com.freshnin.adminapplication.model.ModelResponse;
import com.freshnin.adminapplication.tools.Tools;
import com.freshnin.adminapplication.viewmodel.ViewModelAdminApp;
import com.squareup.picasso.Picasso;

public class ActivityPreOrderProductDetails extends AppCompatActivity {
    private static final String TAG = "ActivityPreOrderProductDetails";
    private ActivityPreOrderProductDetailsBinding binding;
    private ModelPreOrder preOrderItemDetails;

    Dialog dialogLoading;
    ViewModelAdminApp viewModelAdminApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPreOrderProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.apopdStopSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSession();
            }
        });
    }

    private void init(){
        dialogLoading= Tools.setupLoadingDialog(ActivityPreOrderProductDetails.this);
        viewModelAdminApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelAdminApp.class);
        preOrderItemDetails=getIntent().getParcelableExtra("data");
        if(preOrderItemDetails!=null)updateUI(preOrderItemDetails);
    }

    void updateUI(ModelPreOrder order){
        Picasso.with(this).load(order.getProductPicUrl()).into(binding.apopdFoodImage);
        switch (order.getSessionStatus()){
            case 1:
                binding.textView.setText("Created");
                binding.apopdStopSession.setText("Publish\nSession");
                break;
            case 2:
                binding.textView.setText("Published");
                binding.apopdStopSession.setText("Unpublish\nSession");
                break;
            case 3:
                binding.textView.setText("Unpublished");
                binding.apopdStopSession.setText("Publish\nSession");
                break;
        }

        binding.apopdEtProductName.setText(order.getProductName());
        binding.apopdEtProductDescription.setText(order.getProductShortDes());
        binding.apopdEtProductPrice.setText(order.getProductUnitPrice()+"");
        binding.apopdEtProductWeight.setText(order.getProductUnitWeight()+"");
        binding.apopdTvSessionStartDate.setText(order.getSessionStartDate());
        binding.apopdTvSessionEndDate.setText(order.getSessionEndDate());
    }

    void updateSession(){
        if(preOrderItemDetails.getSessionStatus()==1){
            preOrderItemDetails.setSessionStatus(2);
        }else if(preOrderItemDetails.getSessionStatus()==2){
            preOrderItemDetails.setSessionStatus(3);
        }else if(preOrderItemDetails.getSessionStatus()==3){
            preOrderItemDetails.setSessionStatus(2);
        }

        dialogLoading.show();
        viewModelAdminApp.updatePreOrderSessionStatus(preOrderItemDetails).observe(this, new Observer<ModelResponse>() {
            @Override
            public void onChanged(ModelResponse modelResponse) {
                dialogLoading.dismiss();
                if(modelResponse!=null && modelResponse.getResponse()==1){
                    updateUI(preOrderItemDetails);
                    Toast.makeText(ActivityPreOrderProductDetails.this, "Status Updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ActivityPreOrderProductDetails.this, "Status Update Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}