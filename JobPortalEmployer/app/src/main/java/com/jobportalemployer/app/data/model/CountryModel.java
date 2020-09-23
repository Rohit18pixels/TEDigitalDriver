package com.jobportalemployer.app.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryModel {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("countries")
    @Expose
    private List<CountryResponce> countries = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CountryResponce> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryResponce> countries) {
        this.countries = countries;
    }


}
