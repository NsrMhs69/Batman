package com.project.batman.detailActivity;


import com.project.batman.apiInterface.GetMovieDataService;
import com.project.batman.mainActivity.MainContract;
import com.project.batman.model.MovieDetail;
import com.project.batman.model.MovieList;
import com.project.batman.retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetDetailMovieIntractorImpl implements DetailContract.GetDetailMovieIntractor{

    @Override
    public void getMovieDetail(final OnFinishedListener onFinishedListener ,String id) {

        GetMovieDataService service = RetrofitInstance.getRetrofitInstance().create(GetMovieDataService.class);
        Call<MovieDetail> call = service.getMovieDetail(id);
        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                onFinishedListener.onFinished(response.body());
            }
            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
