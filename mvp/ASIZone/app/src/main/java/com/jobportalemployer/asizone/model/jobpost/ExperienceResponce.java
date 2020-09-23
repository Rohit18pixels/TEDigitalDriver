package com.jobportalemployer.asizone.model.jobpost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExperienceResponce {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("data")
    @Expose
    private List<ExperienceDataum> data = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<ExperienceDataum> getData() {
        return data;
    }

    public void setData(List<ExperienceDataum> data) {
        this.data = data;
    }

}
