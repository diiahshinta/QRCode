package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class Data3 {

    @SerializedName("data")
    private DataMS productData;

    @SerializedName("produk")
    private String produk;

    @SerializedName("inheritance")
    private Inheritance inheritance;

    public String getProduk() {
        return produk;
    }

    public Inheritance getInheritance() {
        return inheritance;
    }

    public DataMS getProductData() {
        return productData;
    }
}
