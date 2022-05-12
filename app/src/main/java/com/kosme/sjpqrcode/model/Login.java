package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private User user;

    @SerializedName("auth")
    private Auth auth;

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public Auth getAuth() {
        return auth;
    }


}
