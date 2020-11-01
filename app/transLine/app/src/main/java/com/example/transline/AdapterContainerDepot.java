package com.example.transline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContainerDepot extends RecyclerView.Adapter<AdapterContainerDepot.ViewHolder> {
    List<ContainerDepot> mListDepot;
    OnContainerDepotClickListener onContainerDepotClickListener;
    Context mContext;
    public AdapterContainerDepot(List<ContainerDepot> mListDepot,OnContainerDepotClickListener onContainerDepotClickListener, Context mContext){
        this.mListDepot = mListDepot;
        this.mContext = mContext;
        this.onContainerDepotClickListener = onContainerDepotClickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_depot,parent,false);
        mContext = parent.getContext();
        return new ViewHolder(view,onContainerDepotClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContainerDepot containerDepot = mListDepot.get(position);
        holder.textViewName.setText(containerDepot.getName());
        holder.textViewDetails.setText(containerDepot.getDetails());
        holder.textViewClearance.setText(containerDepot.getClearance());
        holder.textViewTransit.setText(containerDepot.getTransit());
        holder.textViewDriver.setText(containerDepot.getDriver());
    }

    @Override
    public int getItemCount() {
        return mListDepot.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
private TextView textViewName, textViewDetails, textViewClearance, textViewTransit,textViewDriver, checkBoxdepot;
OnContainerDepotClickListener onContainerDepotClickListener;

        public ViewHolder(@NonNull View itemView,OnContainerDepotClickListener onContainerDepotClickListener) {
            super(itemView);
            this.onContainerDepotClickListener = onContainerDepotClickListener;
            textViewName = itemView.findViewById(R.id.textViewDepot1);
            textViewDetails = itemView.findViewById(R.id.textViewDepot2);
            textViewClearance = itemView.findViewById(R.id.textViewDepot3);
            textViewTransit = itemView.findViewById(R.id.textViewDepot4);
            textViewDriver = itemView.findViewById(R.id.textViewDepot5);
            checkBoxdepot = itemView.findViewById(R.id.checkBoxdepot);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onContainerDepotClickListener.onContainerDepot(getAdapterPosition());
        }
    }
    public interface OnContainerDepotClickListener{
        void onContainerDepot(int position);
    }
}
