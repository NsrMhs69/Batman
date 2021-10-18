package com.project.batman.detailActivity;

import com.project.batman.BasePresenter;
import com.project.batman.BaseView;
import com.project.batman.model.MovieDetail;

import java.util.ArrayList;

public class DetailContract {

    interface DetailView  extends BaseView {

        void setData(MovieDetail movieDetail);

        void setDataFromDb(ArrayList<MovieDetail> movieDetailArrayList);


    }

    interface presenter extends BasePresenter<DetailView>  {

        void requestDataFromServer();
    }

    interface GetDetailMovieIntractor {

        interface OnFinishedListener {
            void onFinished(MovieDetail movieDetail);
            void onFailure(Throwable t);
        }

        void getMovieDetail(OnFinishedListener onFinishedListener, String id);
    }
}
