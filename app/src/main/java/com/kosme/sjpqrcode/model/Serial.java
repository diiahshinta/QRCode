package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class Serial {

    @SerializedName("barcode")
    private String barcode;

    @SerializedName("serialisasi")
    private String serialisasi;

    public String getBarcode() {
        return barcode;
    }

    public String getSerialisasi() {
        return serialisasi;
    }
}
