package com.freshnin.adminapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelUploaInfo {
    @SerializedName("userid")
    @Expose
    private String $userid;

    public ModelUploaInfo(String $userid) {
        this.$userid = $userid;
    }
}
