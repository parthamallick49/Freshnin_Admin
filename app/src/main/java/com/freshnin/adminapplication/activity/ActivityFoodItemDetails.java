package com.freshnin.adminapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.databinding.ActivityFoodItemDetailsBinding;
import com.freshnin.adminapplication.model.ModelRegularItem;
import com.squareup.picasso.Picasso;

public class ActivityFoodItemDetails extends AppCompatActivity {
    private static final String TAG = "ActivityFoodItemDetails";
    private ActivityFoodItemDetailsBinding binding;

    private ModelRegularItem itemDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFoodItemDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_food_item_details);
        init();

        binding.afidBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void init(){
        itemDetails=getIntent().getParcelableExtra("data");
        if(itemDetails!=null)updateUI(itemDetails);
    }

    void updateUI(ModelRegularItem item){
        Picasso.with(this).load(item.getProductPicUrl()).into(binding.afidFoodImage);
        binding.afidEtProductName.setText(item.getProductName());
        binding.afidEtProductDescription.setText(item.getProductDes());
        binding.afidEtProductPrice.setText(item.getProductUnitPrice()+"");
        binding.afidEtProductWeight.setText(item.getProductUnitWeight()+"");
    }
}