package com.freshnin.adminapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.model.ModelOnGoingOrder;

import java.util.List;

public class AdapterOnGoingOrderRecy extends RecyclerView.Adapter<AdapterOnGoingOrderRecy.ViewHolderAdapterOnGoingOrderRecy> {

    List<ModelOnGoingOrder> onGoingOrderList;
    Context context;

    public AdapterOnGoingOrderRecy(List<ModelOnGoingOrder> onGoingOrderList, Context context) {
        this.onGoingOrderList = onGoingOrderList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderAdapterOnGoingOrderRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_regular_order_history_cardview,parent,false);
        ViewHolderAdapterOnGoingOrderRecy viewHolderAdapterOnGoingOrderRecy=new ViewHolderAdapterOnGoingOrderRecy(view);

        return viewHolderAdapterOnGoingOrderRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterOnGoingOrderRecy holder, int position) {
        holder.tvOrderId.setText(onGoingOrderList.get(position).getOrderId());
        holder.tvOrderStatus.setText(onGoingOrderList.get(position).getOrderStatus());

        //todo need to add
        /*holder.tvUserName.setText();
        holder.tvUserPhoneNumber.setText();
        holder.tvOrderedItems.setText();*/
    }

    @Override
    public int getItemCount() {
        return onGoingOrderList.size();
    }

    public class ViewHolderAdapterOnGoingOrderRecy extends RecyclerView.ViewHolder{
        TextView tvOrderId,tvOrderStatus, tvUserName, tvUserPhoneNumber, tvOrderedItems;

        public ViewHolderAdapterOnGoingOrderRecy(@NonNull View itemView) {
            super(itemView);
            tvOrderId=itemView.findViewById(R.id.aroh_tvRegularOrderId);
            tvOrderStatus=itemView.findViewById(R.id.aroh_orderStatus);
            tvUserName=itemView.findViewById(R.id.aroh_tvUserName);
            tvUserPhoneNumber=itemView.findViewById(R.id.aroh_userPhoneNumber);
            tvOrderedItems=itemView.findViewById(R.id.aroh_ordered_items);
        }
    }
}
