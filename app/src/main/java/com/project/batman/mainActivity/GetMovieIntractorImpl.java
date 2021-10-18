package com.project.batman.mainActivity;

import android.util.Log;


import com.project.batman.apiInterface.GetMovieDataService;
import com.project.batman.model.Movie;
import com.project.batman.model.MovieList;
import com.project.batman.retrofit.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetMovieIntractorImpl implements MainContract.GetMovieIntractor {

    @Override
    public void getMovieArrayList(final OnFinishedListener onFinishedListener) {

        GetMovieDataService service = RetrofitInstance.getRetrofitInstance().create(GetMovieDataService.class);
        Call<MovieList> call = service.MovieList();
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                onFinishedListener.onFinished(response.body().getSearch());
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
