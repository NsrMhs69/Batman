package com.project.batman.apiInterface;


import com.project.batman.model.MovieDetail;
import com.project.batman.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMovieDataService {

    @GET("?apikey=3e974fca&s=batman")
    Call<MovieList> MovieList();


    @GET("?apikey=3e974fca&i")
    Call<MovieDetail> getMovieDetail(@Query("i") String id);
}