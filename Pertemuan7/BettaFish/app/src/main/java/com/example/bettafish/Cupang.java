package com.example.bettafish;

import android.os.Parcel;
import android.os.Parcelable;

public class Cupang implements Parcelable {
    private String nama, detail, foto, detail2, jenis, harga;

    protected Cupang(Parcel in){
        nama = in.readString();
        detail = in.readString();
        foto = in.readString();
        detail2 = in.readString();
        jenis = in.readString();
        harga = in.readString();
    }

    public static final Parcelable.Creator<Cupang> CREATOR = new Parcelable.Creator<Cupang>(){
        @Override
        public Cupang createFromParcel(Parcel in){
            return new Cupang(in);
        }

        @Override
        public Cupang[] newArray(int size){
            return new Cupang[size];
        }
    };

    public Cupang(){

    }

    public String getNama() {

        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nama);
        parcel.writeString(this.detail);
        parcel.writeString(this.foto);
        parcel.writeString(this.detail2);
        parcel.writeString(this.jenis);
        parcel.writeString(this.harga);


    }


}
