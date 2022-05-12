package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class ResponseReject {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Reject reject;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Reject getReject() {
        return reject;
    }
}
