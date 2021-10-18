package com.project.batman;

public interface BasePresenter<T extends BaseView> {
    void onDetach(T view);
}
