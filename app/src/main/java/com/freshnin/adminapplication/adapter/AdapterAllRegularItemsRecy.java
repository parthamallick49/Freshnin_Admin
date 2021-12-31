package com.freshnin.adminapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.adminapplication.R;
import com.freshnin.adminapplication.model.ModelRegularItem;

import java.util.List;

public class AdapterAllRegularItemsRecy extends RecyclerView.Adapter<AdapterAllRegularItemsRecy.ViewHolderAdapterAllRegularItemsRecy> {


    List<ModelRegularItem> modelRegularItems;
    Context context;

    public AdapterAllRegularItemsRecy(List<ModelRegularItem> modelRegularItems, Context context) {
        this.modelRegularItems = modelRegularItems;
        this.context = context;
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

        //todo need to add picasso
        //holder.ivItemImage
    }

    @Override
    public int getItemCount() {
        return modelRegularItems.size();
    }

    public class ViewHolderAdapterAllRegularItemsRecy extends RecyclerView.ViewHolder{

        ImageView ivItemImage;
        TextView tvItemName;

        public ViewHolderAdapterAllRegularItemsRecy(@NonNull View itemView) {
            super(itemView);
            ivItemImage=itemView.findViewById(R.id.aaril_ivFoodImage);
            tvItemName=itemView.findViewById(R.id.aaril_tvFoodName);
        }
    }
}
