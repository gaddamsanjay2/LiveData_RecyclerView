package com.example.myapplication;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.DirectedAcyclicGraph;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    Context context;
    List<String> dataModelList=new ArrayList<String>();

    public UserAdapter(Context context, List<String> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);

        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {

        holder.ename.setText(dataModelList.get(position));



    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }


    public void setDataModelList(final List<String> dataModelList) {
        this.dataModelList.clear();
        this.dataModelList = dataModelList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ename;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ename=itemView.findViewById(R.id.recycler_name);

        }
    }
}
