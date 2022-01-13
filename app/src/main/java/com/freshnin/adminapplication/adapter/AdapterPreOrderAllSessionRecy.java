package com.freshnin.adminapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.callbacks.AdapterPreOrderAllSessionCallbacks;
import com.freshnin.adminapplication.model.ModelPreOrder;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdapterPreOrderAllSessionRecy extends RecyclerView.Adapter<AdapterPreOrderAllSessionRecy.ViewHolderAdapterActivityPreOrderAllSession> {

    private static final String TAG = "AdapterActivityPreOrderAllSessionRecy";

    List<ModelPreOrder> preOrderSessionList;
    Context context;
    AdapterPreOrderAllSessionCallbacks callbacks;

    public AdapterPreOrderAllSessionRecy(List<ModelPreOrder> preOrderSessionList, Context context, AdapterPreOrderAllSessionCallbacks callbacks) {
        this.preOrderSessionList = preOrderSessionList;
        this.context = context;
        this.callbacks=callbacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterActivityPreOrderAllSession onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.layout_preorder_session,parent,false);
        ViewHolderAdapterActivityPreOrderAllSession viewHolderAdapterActivityPreOrderAllSession = new ViewHolderAdapterActivityPreOrderAllSession(view);

        return viewHolderAdapterActivityPreOrderAllSession;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterActivityPreOrderAllSession holder, int position) {
        Picasso.with(context).load(preOrderSessionList.get(position).getProductPicUrl()).into(holder.ivPreOrderFoodImage);
        switch (preOrderSessionList.get(position).getSessionStatus()){
            case 1:
                holder.status.setText("Created");
                break;
            case 2:
                holder.status.setText("Published");
                break;
            case 3:
                holder.status.setText("Unpublished");
                break;
        }

        holder.apasHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return preOrderSessionList.size();
    }

    public class ViewHolderAdapterActivityPreOrderAllSession extends RecyclerView.ViewHolder{
        ImageView ivPreOrderFoodImage;
        TextView status;
        CardView apasHolder;

        public ViewHolderAdapterActivityPreOrderAllSession(@NonNull View itemView) {
            super(itemView);
            ivPreOrderFoodImage = itemView.findViewById(R.id.apas_ivFoodImage);
            status=itemView.findViewById(R.id.tvPreOrderFoodStatus);
            apasHolder=itemView.findViewById(R.id.apasHolder);
        }
    }
}
