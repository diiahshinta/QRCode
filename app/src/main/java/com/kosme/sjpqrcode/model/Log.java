package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

public class Log {

    @SerializedName("name")
    private String name;

    @SerializedName("date")
    private String date;

    @SerializedName("note")
    private String note;

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }
}
