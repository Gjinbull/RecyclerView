package com.example.gaurav.recyclerviewexample.customRecyclerView.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaurav.recyclerviewexample.R;
import com.example.gaurav.recyclerviewexample.customRecyclerView.model.CustomDataModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private ArrayList<CustomDataModel> dataModelArrayList;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userName.setText(dataModelArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        TextView userName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPicture = itemView.findViewById(R.id.ivPicture);
            userName = itemView.findViewById(R.id.user_name);
        }
    }

    public void setContentListData(ArrayList<CustomDataModel> dataModelArrayList) {
        notifyItemRangeChanged(0, dataModelArrayList.size());
    }
}
