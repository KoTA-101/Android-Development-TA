package com.example.innstant.ui.HostRoom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innstant.R;
import com.example.innstant.ui.HostRoom.Class.ModelHost;

import java.util.ArrayList;

public class AdapterRoomHosting  extends RecyclerView.Adapter<AdapterRoomHosting.MyViewHolder> {
    Context context;
    ArrayList<ModelHost> Mhost;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ModelHost item);
    }
    public AdapterRoomHosting(Context context, ArrayList<ModelHost> pencarian, OnItemClickListener listener) {
        this.context = context;
        Mhost = pencarian;
//        this.listener = (AdapterView.OnItemClickListener) listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_host, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(Mhost.get(i), listener);
    }



    @Override
    public int getItemCount() {
        return Mhost.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView gambarHost;
        TextView namaKamar,status,rating,totalrating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gambarHost = itemView.findViewById(R.id.GambarHost);
            namaKamar = itemView.findViewById(R.id.namaKamar);
            status = itemView.findViewById(R.id.statusKamar);
            rating = itemView.findViewById(R.id.rating);
            totalrating = itemView.findViewById(R.id.totalRating);
        }

        public void bind(final ModelHost item, final OnItemClickListener listener) {
            gambarHost.setImageBitmap(item.getGambar());
            namaKamar.setText(item.getNamaKamar());
            status.setText(item.getStatus());
            rating.setText(item.getRating().toString());
            totalrating.setText(item.getTotalRating().toString());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

}
