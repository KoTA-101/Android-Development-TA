package com.example.innstant.ui.Rent.Model;

import android.graphics.Bitmap;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelRent {
    private String namaKamar;
    private Bitmap GambarKamar;
    private Float Distance;
    private String location;
    private SimpleDateFormat Awal;
    private SimpleDateFormat Akhir;
    private Bitmap gambarPenyewa;
    private String Status;

    public String getNamaKamar() {
        return namaKamar;
    }

    public void setNamaKamar(String namaKamar) {
        this.namaKamar = namaKamar;
    }

    public Bitmap getGambarKamar() {
        return GambarKamar;
    }

    public void setGambarKamar(Bitmap gambarKamar) {
        GambarKamar = gambarKamar;
    }

    public Float getDistance() {
        return Distance;
    }

    public void setDistance(Float distance) {
        Distance = distance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SimpleDateFormat getAwal() {
        return Awal;
    }

    public void setAwal(SimpleDateFormat awal) {
        Awal = awal;
    }

    public SimpleDateFormat getAkhir() {
        return Akhir;
    }

    public void setAkhir(SimpleDateFormat akhir) {
        Akhir = akhir;
    }

    public Bitmap getGambarPenyewa() {
        return gambarPenyewa;
    }

    public void setGambarPenyewa(Bitmap gambarPenyewa) {
        this.gambarPenyewa = gambarPenyewa;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
