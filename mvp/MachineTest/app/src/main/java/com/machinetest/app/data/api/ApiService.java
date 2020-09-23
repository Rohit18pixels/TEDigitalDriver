package com.machinetest.app.data.api;


import com.machinetest.app.data.model.HeroesResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface ApiService {

//    @Field(view-flipper/heroes.php)
    @GET("view-flipper/heroes.php")
    Call<HeroesResponse> fetcHeroes();
}
