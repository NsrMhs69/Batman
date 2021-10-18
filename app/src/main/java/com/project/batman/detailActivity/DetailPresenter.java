package com.project.batman.detailActivity;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.batman.Apps;
import com.project.batman.db.SqliteDatabase;
import com.project.batman.model.Movie;
import com.project.batman.model.MovieDetail;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class DetailPresenter implements DetailContract.presenter, DetailContract.GetDetailMovieIntractor.OnFinishedListener {

    private DetailContract.DetailView detailView;
    private DetailContract.GetDetailMovieIntractor getDetailMovieIntractor;
    private String id;
    private ArrayList<MovieDetail> movieArrayList = new ArrayList<>();
    private SqliteDatabase sqliteDatabase = new SqliteDatabase(Apps.context);


    public DetailPresenter(DetailContract.DetailView detailView, DetailContract.GetDetailMovieIntractor getDetailMovieIntractor, String id) {
        this.detailView = detailView;
        this.getDetailMovieIntractor = getDetailMovieIntractor;
        this.id = id;
    }


    @Override
    public void requestDataFromServer() {
        detailView.showProgress();
        getDetailMovieIntractor.getMovieDetail(this, this.id);
    }


    @Override
    public void onFinished(MovieDetail movieDetail) {
        if (detailView != null) {
            detailView.setData(movieDetail);

            if (!sqliteDatabase.rowIdExistsInMovieDetail(movieDetail.getImdbID())) {
                sqliteDatabase.addMovieDetail(movieDetail);
            }
            detailView.hideProgress();
        }
    }


    @Override
    public void onFailure(Throwable t) {
        if (detailView != null) {

            movieArrayList.clear();
            movieArrayList = sqliteDatabase.movieDetails(this.id);
            if (movieArrayList.size() > 0) {
                detailView.setDataFromDb(movieArrayList);
            } else {
                detailView.onResponseFailure(t);
            }
            detailView.hideProgress();
        }
    }

    @Override
    public void onDetach(DetailContract.DetailView view) {
        detailView = null;
    }
}
