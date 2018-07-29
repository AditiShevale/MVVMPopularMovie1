package com.example.aditishevale.mvvmpopularmovie1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aditishevale.mvvmpopularmovie1.model.Example;
import com.example.aditishevale.mvvmpopularmovie1.model.Result;
import com.example.aditishevale.mvvmpopularmovie1.service.ApiCLient;
import com.example.aditishevale.mvvmpopularmovie1.service.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadMovies("popular");




    }

    private void loadMovies(String sort) {


        ApiInterface apiService =
                ApiCLient.getClient().create(ApiInterface.class);

        Call<Example> call = apiService.getMovies(sort, ApiCLient.api_key);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, final Response<Example> response) {
                int statusCode = response.code();
                List<Result> results = response.body().getResults();


                Log.d("hula", String.valueOf(results));

                //Log.d("RemoteIN", String.valueOf(data));


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }


        });






    }
}
