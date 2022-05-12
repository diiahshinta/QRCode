package com.kosme.sjpqrcode.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kosme.sjpqrcode.R;
import com.kosme.sjpqrcode.model.Serial;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {
    private static ClickListener clickListener;
    ArrayList<Serial> mList;
    Context context;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public ChildAdapter(Context context, ArrayList<Serial> mList) {
        this.mList = mList;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_child, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.serialisasi.setText(mList.get(position).getSerialisasi());
        holder.barcode.setText(mList.get(position).getBarcode());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mList.size();
    }


    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        ChildAdapter.clickListener = clickListener;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView barcode, serialisasi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            barcode = itemView.findViewById(R.id.txt_barcode);
            serialisasi = itemView.findViewById(R.id.txt_serial);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), itemView);
        }
    }
}
