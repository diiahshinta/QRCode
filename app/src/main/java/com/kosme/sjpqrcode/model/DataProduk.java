package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class DataProduk {
        @SerializedName("produk")
        private String produk;

        @SerializedName("level")
        private String level;

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
        private String pcs;

        @SerializedName("total")
        private String total;

    public String getPcs() {
        return pcs;
    }

    public String getTotal() {
        return total;
    }

    public String getBatch() {
        return batch;
    }

    public String getLevel() {
        return level;
    }

    public String getSerialisasi() {
        return serialisasi;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getUsername() {
        return username;
    }

    public String getLine() {
        return line;
    }

    public String getPo() {
        return po;
    }

    public String getProduk() {
        return produk;
    }

    public String getWeight() {
        return weight;
    }

    public String getScannedDate() {
        return scannedDate;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }
}
