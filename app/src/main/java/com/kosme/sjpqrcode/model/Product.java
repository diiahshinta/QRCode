package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    private String id_produk;

    @SerializedName("kode")
    private String kode_produk;

    @SerializedName("nama")
    private String nama_produk;

    @SerializedName("nie")
    private String nomor_ijin_edar;

    @SerializedName("sku")
    private String sku;

    public String getId_produk() {
        return id_produk;
    }

    public String getKode_produk() {
        return kode_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public String getNomor_ijin_edar() {
        return nomor_ijin_edar;
    }

    public String getSku() {
        return sku;
    }
}
