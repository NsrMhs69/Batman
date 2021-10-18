package com.project.batman.mainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.batman.R;
import com.project.batman.adapter.MovieAdapter;
import com.project.batman.detailActivity.DetailActivity;
import com.project.batman.model.Movie;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.MainView, RecyclerItemClickListener {


    @BindView(R.id.list)
    RecyclerView recyclerView;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    private MainContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        presenter = new MainPresenter(this, new GetMovieIntractorImpl());
        presenter.requestDataFromServer();

    }


    private void initializeViews() {

        ButterKnife.bind(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        progressBar.setVisibility(View.INVISIBLE);


    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void setDataToRecyclerView(ArrayList<Movie> movieArrayList) {
        MovieAdapter adapter = new MovieAdapter(movieArrayList, this, MainActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this, "Error message: "+throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach(this);
    }

    @Override
    public void onItemClick(Movie movie) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("ImdbID", movie.getImdbID());
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("year", movie.getYear());
        intent.putExtra("type", movie.getType());
        intent.putExtra("poster", movie.getPoster());
        startActivity(intent);
    }


}