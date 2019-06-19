package com.example.innstant.ui.HostRoom.Model;

import android.graphics.Bitmap;

public class ModelHost {
    private String namaKamar ;
    private Bitmap Gambar;
    private Float Rating;
    private Integer TotalRating;
    private String Status;

    public String getNamaKamar() {
        return namaKamar;
    }

    public void setNamaKamar(String namaKamar) {
        this.namaKamar = namaKamar;
    }

    public Bitmap getGambar() {
        return Gambar;
    }

    public void setGambar(Bitmap gambar) {
        Gambar = gambar;
    }

    public Float getRating() {
        return Rating;
    }

    public void setRating(Float rating) {
        Rating = rating;
    }

    public Integer getTotalRating() {
        return TotalRating;
    }

    public void setTotalRating(Integer totalRating) {
        TotalRating = totalRating;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
