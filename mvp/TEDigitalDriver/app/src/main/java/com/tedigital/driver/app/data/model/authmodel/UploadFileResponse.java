package com.tedigital.driver.app.data.model.authmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UploadFileResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("keys")
    @Expose
    private List<String> keys = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }
}
