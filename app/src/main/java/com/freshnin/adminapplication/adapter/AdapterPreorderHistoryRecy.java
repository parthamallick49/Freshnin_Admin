package com.freshnin.adminapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.callbacks.AdapterPreorderHistoryRecyCallbacks;
import com.freshnin.adminapplication.model.ModelOngoingPreOrder;

import java.util.List;

public class AdapterPreorderHistoryRecy extends RecyclerView.Adapter<AdapterPreorderHistoryRecy.ViewHolderAdapterPreorderHistoryRecy> {
    private static final String TAG = "AdapterPreorderHistoryRecy";
    List<ModelOngoingPreOrder> onGoingPreOrder;
    Context context;
    AdapterPreorderHistoryRecyCallbacks callbacks;

    public AdapterPreorderHistoryRecy(List<ModelOngoingPreOrder> onGoingPreOrder, Context context,AdapterPreorderHistoryRecyCallbacks callbacks) {
        this.onGoingPreOrder = onGoingPreOrder;
        this.context = context;
        this.callbacks=callbacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterPreorderHistoryRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_preorder_history_cardview,parent,false);
        ViewHolderAdapterPreorderHistoryRecy viewHolderAdapterPreorderHistoryRecy=new ViewHolderAdapterPreorderHistoryRecy(view);

        return viewHolderAdapterPreorderHistoryRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterPreorderHistoryRecy holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+onGoingPreOrder.get(position).getItemName());
        holder.tvPreOrderProductName.setText(onGoingPreOrder.get(position).getItemName());
        holder.tvPreOrderId.setText(onGoingPreOrder.get(position).getOrderId());
        holder.tvPreOrderDeliveryDate.setText(onGoingPreOrder.get(position).getOrderDeliveryDate());

        switch (onGoingPreOrder.get(position).getAdvancePaymentStatus()+""){
            case "1":
                holder.tvPreOrderPaymentStatus.setText("Verification Pending");
                break;
            case "2":
                holder.tvPreOrderPaymentStatus.setText("Verified");
                break;
            case "3":
                holder.tvPreOrderPaymentStatus.setText("Declined");
                break;
        }

        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onItemClicked(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return onGoingPreOrder.size();
    }

    public class ViewHolderAdapterPreorderHistoryRecy extends RecyclerView.ViewHolder{
        TextView tvPreOrderId, tvPreOrderProductName,tvPreOrderDeliveryDate,tvPreOrderPaymentStatus;
        TextView btnDetails;

        public ViewHolderAdapterPreorderHistoryRecy(@NonNull View itemView) {
            super(itemView);
            tvPreOrderId=itemView.findViewById(R.id.apoh_tvPreOrderId);
            tvPreOrderProductName=itemView.findViewById(R.id.apoh_tvProductName);
            tvPreOrderDeliveryDate=itemView.findViewById(R.id.apoh_tvDeliveryDate);
            tvPreOrderPaymentStatus=itemView.findViewById(R.id.apoh_tvVerificationStatus);
            btnDetails=itemView.findViewById(R.id.apoh_btnPreorderDetailsView);
        }
    }
}
