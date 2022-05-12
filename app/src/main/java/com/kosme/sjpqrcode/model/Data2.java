package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class Data2 {

    @SerializedName("data")
    private ProductData productData;

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

    public ProductData getProductData() {
        return productData;
    }
}
