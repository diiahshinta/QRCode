package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class Replace {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
