package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class Reject {
    @SerializedName("palet")
    private String palet;

    @SerializedName("box")
    private String box;

    @SerializedName("inner")
    private String inner;

    @SerializedName("produk")
    private String produk;

    @SerializedName("barcode")
    private String barcode;

    @SerializedName("serialisasi")
    private String serialisasi;

    @SerializedName("batch")
    private String batch;

    @SerializedName("expired_date")
    private String ed;

    @SerializedName("production_date")
    private String md;

    @SerializedName("scanned_date")
    private String scanned;

    @SerializedName("process_order")
    private String po;

    @SerializedName("line")
    private String line;

    public String getSerialisasi() {
        return serialisasi;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getProduk() {
        return produk;
    }

    public String getPo() {
        return po;
    }

    public String getLine() {
        return line;
    }

    public String getBatch() {
        return batch;
    }

    public String getScanned() {
        return scanned;
    }

    public String getEd() {
        return ed;
    }

    public String getMd() {
        return md;
    }

    public String getBox() {
        return box;
    }

    public String getInner() {
        return inner;
    }

    public String getPalet() {
        return palet;
    }
}
