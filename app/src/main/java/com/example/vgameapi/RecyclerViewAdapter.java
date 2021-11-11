package com.example.vgameapi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
                                 implements View.OnClickListener {
    private ArrayList<String> array_noms;
    private View.OnClickListener listener;

    public RecyclerViewAdapter(ArrayList<String> arrN){
        array_noms = arrN;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);

        view.setOnClickListener(this);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(array_noms.get(position));
    }

    @Override
    public int getItemCount() {
        return array_noms.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null) {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.userName);
        }
    }
}

