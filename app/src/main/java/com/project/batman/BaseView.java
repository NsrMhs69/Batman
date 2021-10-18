package com.project.batman;



public interface BaseView {

    void showProgress();

    void hideProgress();

    void onResponseFailure(Throwable throwable);

}
