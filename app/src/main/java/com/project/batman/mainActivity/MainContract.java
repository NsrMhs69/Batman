package com.project.batman.mainActivity;

import com.project.batman.BasePresenter;
import com.project.batman.BaseView;
import com.project.batman.model.Movie;

import java.util.ArrayList;

public class MainContract {


    interface MainView extends BaseView {


        void setDataToRecyclerView(ArrayList<Movie> movieArrayList);


    }

    interface presenter extends BasePresenter<MainView> {


        void requestDataFromServer();

    }

    interface GetMovieIntractor {
        interface OnFinishedListener {
            void onFinished(ArrayList<Movie> movieArrayList);
            void onFailure(Throwable t);
        }
        void getMovieArrayList(OnFinishedListener onFinishedListener);
    }
}
