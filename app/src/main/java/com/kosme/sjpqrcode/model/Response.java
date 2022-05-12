package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response{

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Data2 products;

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

    public Data2 getProducts() {
        return products;
    }
}
