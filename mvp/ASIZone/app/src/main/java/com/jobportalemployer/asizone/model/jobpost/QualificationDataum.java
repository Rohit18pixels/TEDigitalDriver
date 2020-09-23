package com.jobportalemployer.asizone.model.jobpost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QualificationDataum {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("POS")
    @Expose
    private Integer pOS;
    @SerializedName("STATUS")
    @Expose
    private Boolean sTATUS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPOS() {
        return pOS;
    }

    public void setPOS(Integer pOS) {
        this.pOS = pOS;
    }

    public Boolean getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(Boolean sTATUS) {
        this.sTATUS = sTATUS;
    }

}
