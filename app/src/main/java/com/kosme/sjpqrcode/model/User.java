package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("email_verified_at")
    private String verif;

    @SerializedName("created_at")
    private String created;

    @SerializedName("updated_at")
    private String updated;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCreated() {
        return created;
    }

    public String getName() {
        return name;
    }

    public String getUpdated() {
        return updated;
    }

    public String getVerif() {
        return verif;
    }
}
