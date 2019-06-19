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
import com.example.innstant.ui.HostRoom.Adapter.AdapterRoomHosting;
import com.example.innstant.ui.HostRoom.Model.ModelHost;
import com.example.innstant.ui.Rent.Model.ModelRent;
import com.example.innstant.ui.Rent.RentRoomActivity;

import java.util.ArrayList;
import java.util.Date;

public class AdapterRoomRent extends RecyclerView.Adapter<AdapterRoomRent.MyViewHolder> {
    Context context;
    ArrayList<ModelRent> Mrent;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ModelRent item);
    }

    public AdapterRoomRent(Context context, ArrayList<ModelRent> pencarian, RentRoomActivity listener) {
        this.context = context;
        Mrent = pencarian;
//        this.listener = (AdapterView.OnItemClickListener) listener;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rent, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(Mrent.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return Mrent.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView gambarRent,gambarPenyewa;
        TextView namaKamar,status,lokasi,awal,akhir,namaPenyewa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gambarPenyewa = itemView.findViewById(R.id.gambarPenyewa);
            gambarRent = itemView.findViewById(R.id.GambarRent);
            namaKamar=itemView.findViewById(R.id.namaKamar);
            status=itemView.findViewById(R.id.statusKamar);
            lokasi =itemView.findViewById(R.id.lokasi);
            awal=itemView.findViewById(R.id.tanggalMasuk);
            akhir=itemView.findViewById(R.id.tanggalKeluar);
            namaPenyewa=itemView.findViewById(R.id.penyewa);

        }

        public void bind(final ModelRent item, final AdapterRoomRent.OnItemClickListener listener) {
            gambarPenyewa.setImageBitmap(item.getGambarPenyewa());
            gambarRent.setImageBitmap(item.getGambarKamar());
            namaKamar.setText(item.getNamaKamar());
            status.setText(item.getStatus());
            lokasi.setText(item.getLocation());
            awal.setText(item.getAwal().toLocalizedPattern());
            akhir.setText(item.getAkhir().format(new Date()));
            namaPenyewa.setText(item.getNamaKamar());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

}
