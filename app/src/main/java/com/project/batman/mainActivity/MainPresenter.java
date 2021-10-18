package com.project.batman.mainActivity;


import com.project.batman.Apps;
import com.project.batman.db.SqliteDatabase;
import com.project.batman.model.Movie;

import java.util.ArrayList;

public class MainPresenter implements MainContract.presenter, MainContract.GetMovieIntractor.OnFinishedListener {

    private MainContract.MainView mainView;

    private MainContract.GetMovieIntractor getMovieIntractor;
    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    private SqliteDatabase sqliteDatabase = new SqliteDatabase(Apps.context);

    public MainPresenter(MainContract.MainView mainView, MainContract.GetMovieIntractor getNoticeIntractor) {
        this.mainView = mainView;
        this.getMovieIntractor = getNoticeIntractor;
    }

    @Override
    public void requestDataFromServer() {
        mainView.showProgress();
        getMovieIntractor.getMovieArrayList(this);
    }


    @Override
    public void onFinished(ArrayList<Movie> movieArrayList) {
        if (mainView != null) {
            mainView.setDataToRecyclerView(movieArrayList);
            for (int i = 0; i < movieArrayList.size(); i++) {
                if (!sqliteDatabase.rowIdExistsInMovie(movieArrayList.get(i).getImdbID())) {
                    sqliteDatabase.insertMovie(movieArrayList.get(i));
                }
            }
            mainView.hideProgress();
        }
    }


    @Override
    public void onFailure(Throwable t) {

        if (mainView != null) {

            movieArrayList = sqliteDatabase.movieList();
            if (movieArrayList.size() > 0) {
                mainView.setDataToRecyclerView(movieArrayList);
            } else {
                mainView.onResponseFailure(t);
            }


            mainView.hideProgress();

        }
    }

    @Override
    public void onDetach(MainContract.MainView view) {
        mainView = null;
    }
}
