package com.freshnin.adminapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.model.ModelRegularItem;

import java.util.List;

public class AdapterOnGoingOrderDetailsBillingRecy extends RecyclerView.Adapter<AdapterOnGoingOrderDetailsBillingRecy.ViewHolderAdapterOnGoingOrderDetailsBillingRecy>{

    List<ModelRegularItem> itemBillingList;
    Context context;

    public AdapterOnGoingOrderDetailsBillingRecy(List<ModelRegularItem> itemBillingList, Context context) {
        this.itemBillingList = itemBillingList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterOnGoingOrderDetailsBillingRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_on_going_order_details_billing_cardview,parent,false);
        ViewHolderAdapterOnGoingOrderDetailsBillingRecy viewHolderAdapterOnGoingOrderDetailsBillingRecy=new ViewHolderAdapterOnGoingOrderDetailsBillingRecy(view);

        return viewHolderAdapterOnGoingOrderDetailsBillingRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterOnGoingOrderDetailsBillingRecy holder, int position) {
        holder.tvFoodName.setText(itemBillingList.get(position).getProductName());
        holder.tvFoodPrice.setText(itemBillingList.get(position).getProductUnitPrice());
    }

    @Override
    public int getItemCount() {
        return itemBillingList.size();
    }

    public class ViewHolderAdapterOnGoingOrderDetailsBillingRecy extends RecyclerView.ViewHolder{
        TextView tvFoodName, tvFoodPrice;

        public ViewHolderAdapterOnGoingOrderDetailsBillingRecy(@NonNull View itemView) {
            super(itemView);
            tvFoodName=itemView.findViewById(R.id.aogod_billingList_tvProductName);
            tvFoodPrice=itemView.findViewById(R.id.aogod_billingList_tvProductPrice);
        }
    }
}
