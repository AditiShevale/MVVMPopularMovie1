package com.example.aditishevale.mvvmpopularmovie1.service;

import com.example.aditishevale.mvvmpopularmovie1.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    // query and url parameters

    @GET("movie/popular")
    Call<Example> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/{filter}")
    Call<Example> getMovies(@Path("filter") String filter, @Query("api_key")
            String apiKey);

}
