package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class Pcs {

    @SerializedName("pcs")
    private String pcs;

    @SerializedName("Batch_No")
    private String batchNumber;

    public String getBatchNumber() {
        return batchNumber;
    }

    public String getPcs() {
        return pcs;
    }
}
