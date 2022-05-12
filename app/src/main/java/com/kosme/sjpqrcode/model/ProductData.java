package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductData {

    @SerializedName("level")
    private String level;

    @SerializedName("status")
    private String status;

    @SerializedName("batch")
    private String batch;

    @SerializedName("serialisasi")
    private String serialisasi;

    @SerializedName("barcode")
    private String barcode;

    @SerializedName("process_order")
    private String po;

    @SerializedName("line")
    private String line;

    @SerializedName("weight")
    private String weight;

    @SerializedName("scanned_date")
    private String scannedDate;

    @SerializedName("production_date")
    private String productionDate;

    @SerializedName("expired_date")
    private String expiredDate;

    @SerializedName("username")
    private String username;

    @SerializedName("pcs")
    private ArrayList<Pcs> pcs;

    @SerializedName("total")
    private String total;

    @SerializedName("log")
    private Log log;

    @SerializedName("nie")
    private String nie;

    @SerializedName("sku")
    private String sku;

    public String getSku() {
        return sku;
    }

    public String getNie() {
        return nie;
    }

    public Log getLog() {
        return log;
    }

    public String getTotal() {
        return total;
    }

    public ArrayList<Pcs> getPcs() {
        return pcs;
    }

    public String getUsername() {
        return username;
    }

    public String getSerialisasi() {
        return serialisasi;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getBatch() {
        return batch;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public String getLevel() {
        return level;
    }

    public String getStatus() {
        return status;
    }

    public String getLine() {
        return line;
    }

    public String getPo() {
        return po;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public String getScannedDate() {
        return scannedDate;
    }

    public String getWeight() {
        return weight;
    }
}
