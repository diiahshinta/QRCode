package com.kosme.sjpqrcode.model;

public class Batch {

    private String batch, total;

    public Batch(String batch, String total){
        this.batch = batch;
        this.total = total;
    }

    public String getBatch() {
        return batch;
    }

    public String getTotal() {
        return total;
    }
}
