package com.kosme.sjpqrcode.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Inheritance {
    @SerializedName("parent")
    private Serial parent;

    @SerializedName("child")
    private ArrayList<Serial> child;

    public ArrayList<Serial> getChild() {
        return child;
    }

    public Serial getParent() {
        return parent;
    }
}
