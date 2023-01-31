package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface DogsApi {
    @GET("feeds/application/json")
    Call<List<dog>> getData();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://petstore.swagger.io/v2/pet")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

