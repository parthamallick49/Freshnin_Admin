package com.freshnin.adminapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.freshnin.adminapplication.callbacks.AdapterAdminOptionsCallbacks;
import com.freshnin.adminapplication.databinding.LayoutAdminOptionBinding;

import java.util.List;

public class AdapterAdminOptions extends RecyclerView.Adapter<AdapterAdminOptions.AdapterAdminOptionsViewHolder>{

    Context context;
    List<String> options;
    AdapterAdminOptionsCallbacks callbacks;

    public AdapterAdminOptions(Context context, List<String> options, AdapterAdminOptionsCallbacks callbacks) {
        this.context = context;
        this.options = options;
        this.callbacks = callbacks;
    }

    @NonNull
    @Override
    public AdapterAdminOptionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutAdminOptionBinding layoutAdminOptionBindingl=LayoutAdminOptionBinding.inflate(LayoutInflater.from(context),parent,false);
        return new AdapterAdminOptionsViewHolder(layoutAdminOptionBindingl);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAdminOptionsViewHolder holder, int position) {
        holder.layoutAdminOptionBinding.option.setText(options.get(position));

        holder.layoutAdminOptionBinding.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onOptionClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    class  AdapterAdminOptionsViewHolder extends RecyclerView.ViewHolder{
        LayoutAdminOptionBinding layoutAdminOptionBinding;
        public AdapterAdminOptionsViewHolder(@NonNull LayoutAdminOptionBinding layoutAdminOptionBinding) {
            super(layoutAdminOptionBinding.getRoot());
            this.layoutAdminOptionBinding=layoutAdminOptionBinding;
        }
    }
}
