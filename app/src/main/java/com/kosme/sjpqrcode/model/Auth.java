package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Auth {

    @SerializedName("user")
    private String user;

    @SerializedName("token")
    private String token;

    @SerializedName("permission")
    private ArrayList<String> permission;

    public String getUser() {
        return user;
    }

    public ArrayList<String> getPermission() {
        return permission;
    }

    public String getToken() {
        return token;
    }
}
