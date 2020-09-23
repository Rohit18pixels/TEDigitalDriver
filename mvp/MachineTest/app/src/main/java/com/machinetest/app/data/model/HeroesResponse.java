package com.machinetest.app.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeroesResponse {
    @SerializedName("heroes")
    @Expose
    private List<HeroDataum> HeroDataumes = null;

    public List<HeroDataum> getHeroDataumes() {
        return HeroDataumes;
    }

    public void setHeroDataumes(List<HeroDataum> HeroDataumes) {
        this.HeroDataumes = HeroDataumes;
    }

}
