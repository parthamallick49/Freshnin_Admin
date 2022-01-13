package com.freshnin.adminapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.callbacks.AdapterAllRegularItemsRecyCallBacks;
import com.freshnin.adminapplication.model.ModelRegularItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterAllRegularItemsRecy extends RecyclerView.Adapter<AdapterAllRegularItemsRecy.ViewHolderAdapterAllRegularItemsRecy> {


    List<ModelRegularItem> modelRegularItems;
    Context context;
    AdapterAllRegularItemsRecyCallBacks callBacks;

    public AdapterAllRegularItemsRecy(List<ModelRegularItem> modelRegularItems, Context context,AdapterAllRegularItemsRecyCallBacks callBacks) {
        this.modelRegularItems = modelRegularItems;
        this.context = context;
        this.callBacks=callBacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterAllRegularItemsRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_raguler_item_cardview,parent,false);
        ViewHolderAdapterAllRegularItemsRecy viewHolderAdapterAllRegularItemsRecy=new ViewHolderAdapterAllRegularItemsRecy(view);

        return viewHolderAdapterAllRegularItemsRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterAllRegularItemsRecy holder, int position) {
        holder.tvItemName.setText(modelRegularItems.get(position).getProductName());
        Picasso.with(context).load(modelRegularItems.get(position).getProductPicUrl()).into(holder.ivItemImage);
        holder.iconDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBacks.onDeleteClicked(position);
            }
        });

        holder.aarilHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBacks.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelRegularItems.size();
    }

    public class ViewHolderAdapterAllRegularItemsRecy extends RecyclerView.ViewHolder{

        ImageView ivItemImage;
        TextView tvItemName;
        ImageView iconDelete;
        CardView aarilHolder;

        public ViewHolderAdapterAllRegularItemsRecy(@NonNull View itemView) {
            super(itemView);
            ivItemImage=itemView.findViewById(R.id.aaril_ivFoodImage);
            tvItemName=itemView.findViewById(R.id.aaril_tvFoodName);
            iconDelete=itemView.findViewById(R.id.aaril_DeleteItem);
            aarilHolder=itemView.findViewById(R.id.aarilHolder);
        }
    }
}
