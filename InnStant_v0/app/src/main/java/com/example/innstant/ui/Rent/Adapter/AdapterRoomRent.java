package com.example.innstant.ui.Rent.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innstant.R;
import com.example.innstant.data.model.Room;
import com.example.innstant.data.model.Transaction;

import java.util.ArrayList;

public class AdapterRoomRent extends RecyclerView.Adapter<AdapterRoomRent.MyViewHolder>  {
    Context context;
    ArrayList<Transaction> Mhost;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Transaction item);
    }

    public AdapterRoomRent(Context context, ArrayList<Transaction> pencarian, OnItemClickListener listener) {
        this.context = context;
        Mhost = pencarian;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(Mhost.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return Mhost.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView transaksiID,hosID,guessID,transaksiTimestamp,bookStart,bookEnd,statusPembayaran,roomID;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            transaksiID = itemView.findViewById(R.id.transaksiID);
            hosID = itemView.findViewById(R.id.hostID);
            guessID = itemView.findViewById(R.id.guessID);
            roomID = itemView.findViewById(R.id.roomID);
            transaksiTimestamp = itemView.findViewById(R.id.timestampTransaction);
            bookStart = itemView.findViewById(R.id.bookStart);
            bookEnd =itemView.findViewById(R.id.bookEnd);
            statusPembayaran=itemView.findViewById(R.id.statusBayar);
        }

        public void bind(final Transaction item, final OnItemClickListener listener) {
            transaksiID.setText(item.getTransactionId());
            hosID.setText(item.getHostId());
            guessID.setText(item.getGuestId());
            roomID.setText(item.getRoomId());
            transaksiTimestamp.setText((CharSequence) item.getTransactionTimestamp());
            bookStart.setText((CharSequence) item.getBookStartDate());
            bookEnd.setText((CharSequence) item.getBookEndDate());
            statusPembayaran.setText(item.getPaymentStatus());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
