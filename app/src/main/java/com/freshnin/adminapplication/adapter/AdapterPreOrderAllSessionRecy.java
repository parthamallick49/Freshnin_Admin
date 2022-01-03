package com.freshnin.adminapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.adminapplication.R;
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

    public AdapterPreOrderAllSessionRecy(List<ModelPreOrder> preOrderSessionList, Context context) {
        this.preOrderSessionList = preOrderSessionList;
        this.context = context;
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
        //Picasso.with(context).load(preOrderSessionList.get(position).getProductPicUrl()).into(holder.ivPreOrderFoodImage);
        holder.tvPreOrderFoodTitle.setText(preOrderSessionList.get(position).getProductName());
        //holder.tvOrderGoingOnTillDay.setText(preOrderSessionList.get(position).getSessionEndDate());
        /*try {
            holder.tvOrderGoingOnTillDay.setText(getDayName(preOrderSessionList.get(position).getSessionEndDate()));
        } catch (ParseException e) {
            Log.d(TAG, "AdapterPreOrderFoodRecy: error"+e.getMessage());;
        }*/
    }

    @Override
    public int getItemCount() {
        return preOrderSessionList.size();
    }

    public class ViewHolderAdapterActivityPreOrderAllSession extends RecyclerView.ViewHolder{
        TextView tvPreOrderFoodTitle, tvOrderGoingOnTillDay;
        ImageView ivPreOrderFoodImage;

        public ViewHolderAdapterActivityPreOrderAllSession(@NonNull View itemView) {
            super(itemView);
            tvPreOrderFoodTitle =itemView.findViewById(R.id.apas_tvFoodTitle);
            //tvOrderGoingOnTillDay=itemView.findViewById(R.id.apas_tvOrderRemainday);
            ivPreOrderFoodImage = itemView.findViewById(R.id.apas_ivFoodImage);


        }
    }

    /*private String getDayName(String sessionEndDate) throws ParseException {
        SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = inFormat.parse(sessionEndDate);
        SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
        String dayName = outFormat.format(date);

        return dayName;
    }*/
}
