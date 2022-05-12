package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LevelProduct {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Data3 products;

    @SerializedName("auth")
    private Auth auth;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Auth getAuth() {
        return auth;
    }

    public Data3 getProducts() {
        return products;
    }
}


