package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.databinding.ActivityPreOrderDetailsBinding;
import com.freshnin.adminapplication.model.ModelOngoingPreOrder;
import com.freshnin.adminapplication.model.ModelResponse;
import com.freshnin.adminapplication.tools.Tools;
import com.freshnin.adminapplication.viewmodel.ViewModelAdminApp;
import com.squareup.picasso.Picasso;

public class ActivityPreOrderDetails extends AppCompatActivity {
    private static final String TAG = "ActivityPreOrderDetails";
    private ActivityPreOrderDetailsBinding binding;

    private ModelOngoingPreOrder orderDetails;

    private Dialog dialogLoading;
    private ViewModelAdminApp viewModelAdminApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPreOrderDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        binding.apodPreOrderDetailsMainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStatus();
            }
        });

    }

    void updateStatus(){
        dialogLoading.show();

        switch (orderDetails.getOrderStatus()){
            case "1"://confirm
                //binding.btnConfirm.setText("Confirm Order");
                orderDetails.setAdvancePaymentStatus("2");
                orderDetails.setOrderStatus("2");
                break;

            case "2"://mark as delevered
                //binding.btnConfirm.setText("Finish Order");
                orderDetails.setOrderStatus("3");
                break;
        }


        viewModelAdminApp.updatePreOrderStatus(orderDetails).observe(ActivityPreOrderDetails.this, new Observer<ModelResponse>() {
            @Override
            public void onChanged(ModelResponse modelResponse) {
                dialogLoading.dismiss();
                if(modelResponse!=null && modelResponse.getResponse()==1){
                    updateUI(orderDetails);
                    Toast.makeText(ActivityPreOrderDetails.this, "Status Updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ActivityPreOrderDetails.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init(){

        viewModelAdminApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelAdminApp.class);
        dialogLoading= Tools.setupLoadingDialog(ActivityPreOrderDetails.this);

        setSupportActionBar(binding.apodPreOrderDetailsMainToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        orderDetails=getIntent().getParcelableExtra("data");

        if(orderDetails!=null) updateUI(orderDetails);

    }

    void updateUI(ModelOngoingPreOrder order){

        int deliveryCharge=Integer.parseInt(order.getDeliveryCharge());
        int totalBill=Integer.parseInt(order.getTotalBill());


        binding.apodTvPreOrderIdFromHistoryDetails.setText("OrderId: "+order.getOrderId());
        binding.apodTvItemName.setText(order.getItemName());
        binding.apodTvItemQuantity.setText(order.getOrderQuantity()+"");
        Picasso.with(this).load(order.getUrl()).into(binding.apodIvItemImage);

        binding.apodTransactionId.setText(order.getTransactionId()+"("+order.getAdvancePaymentMethod()+")");

        switch (order.getAdvancePaymentStatus()+""){
            case "1":
                binding.apodOrderSatus.setText("Verification Pending");
                break;
            case "2":
                binding.apodOrderSatus.setText("Verified");
                break;
            case "3":
                binding.apodOrderSatus.setText("Declined");
                break;
        }
        binding.apodTvItemName.setText(order.getItemName());
        binding.apodTvItemPrice.setText((totalBill-deliveryCharge)+" Tk");
        binding.apodTvItemDeliveryCharge.setText(order.getDeliveryCharge()+" Tk");
        binding.apodTvPaidAmount.setText(order.getAdvancePyamentAmount()+" Tk");
        binding.apodTvTotalBill.setText(order.getTotalBill()+" Tk");

        binding.apodTvuserName.setText("Customer Phone Number");
        binding.apodTvUserPhoneNumber.setText(order.getUserId());
        binding.apodTvDeliveryAddress.setText(order.getDeliveryAddress());
        binding.apodTvDeliveryDate.setText(order.getOrderDeliveryDate());
        binding.apodTvPaymentType.setText(order.getPaymnetMethod());

        switch (order.getOrderStatus()){
            case "1":
                binding.btnConfirm.setText("Confirm Order");
                break;

            case "2":
                binding.btnConfirm.setText("Finish Order");
                break;
        }

    }


}