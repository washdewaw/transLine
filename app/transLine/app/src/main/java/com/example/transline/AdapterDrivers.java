package com.example.transline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDrivers extends RecyclerView.Adapter<AdapterDrivers.ViewHolder> {
    List<ContainerDrivers> mListDrivers;
    AdapterDrivers.OnDriverClickListener onDriverClickListener;
    Context mContext;
    public AdapterDrivers(List<ContainerDrivers> mListDrivers, AdapterDrivers.OnDriverClickListener onDriverClickListener, Context mContext){
        this.mListDrivers = mListDrivers;
        this.mContext = mContext;
        this.onDriverClickListener = onDriverClickListener;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_drivers,parent,false);
        mContext = parent.getContext();
        return new AdapterDrivers.ViewHolder(view,onDriverClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContainerDrivers containerDrivers = mListDrivers.get(position);
        holder.textViewName.setText(containerDrivers.getName());
        holder.textViewDetails.setText(containerDrivers.getDetails());
        holder.textViewClearance.setText(containerDrivers.getClearance());
        holder.textViewTransit.setText(containerDrivers.getTransit());
    }

    @Override
    public int getItemCount() {
        return mListDrivers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textViewName, textViewDetails, textViewClearance, textViewTransit;
        OnDriverClickListener onDriverClickListener;
        public ViewHolder(@NonNull View itemView,OnDriverClickListener onDriverClickListener) {
            super(itemView);
            this.onDriverClickListener = onDriverClickListener;
            textViewName = itemView.findViewById(R.id.textViewDrivers1);
            textViewDetails =itemView.findViewById(R.id.textViewDrivers2);
            textViewClearance =itemView.findViewById(R.id.textViewDrivers3);
            textViewTransit =itemView.findViewById(R.id.textViewDriver4);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onDriverClickListener.onDriverClick(getAdapterPosition());
        }
    }
    public interface OnDriverClickListener{
        void onDriverClick(int position);
    }
}
