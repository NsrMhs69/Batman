package com.project.batman.detailActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.project.batman.R;
import com.project.batman.adapter.RatingAdapter;
import com.project.batman.model.MovieDetail;
import com.project.batman.model.Rating;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity implements DetailContract.DetailView {

    DetailContract.presenter presenter;
    RatingAdapter ratingAdapter;


    @BindView(R.id.circle_imageview)
    CircleImageView circleImageView;

    @BindView(R.id.movie_title)
    TextView titleTxt;

    @BindView(R.id.movie_year)
    TextView yearTxt;

    @BindView(R.id.movie_type)
    TextView typeTxt;

    @BindView(R.id.movie_actores)
    TextView actorsTxt;

    @BindView(R.id.movie_rated)
    TextView ratedTxt;

    @BindView(R.id.movie_released)
    TextView releasedTxt;

    @BindView(R.id.movie_runtime)
    TextView runtimeTxt;

    @BindView(R.id.movie_genre)
    TextView genreTxt;

    @BindView(R.id.movie_director)
    TextView directorTxt;

    @BindView(R.id.movie_writer)
    TextView writerTxt;

    @BindView(R.id.movie_plot)
    TextView plotTxt;


    @BindView(R.id.movie_award)
    TextView awardTxt;

    @BindView(R.id.movie_lanquage)
    TextView lanquageTxt;

    @BindView(R.id.movie_country)
    TextView countryTxt;

    @BindView(R.id.movie_imdbrating)
    TextView imdbRatingTxt;

    @BindView(R.id.movie_imdbvoting)
    TextView imdbVotingTxt;

    @BindView(R.id.movie_metascore)
    TextView metascoreTxt;

    @BindView(R.id.movie_dvd)
    TextView dvdTxt;

    @BindView(R.id.movie_boxoffilce)
    TextView boxOfficeTxt;

    @BindView(R.id.movie_production)
    TextView productionTxt;

    @BindView(R.id.movie_website)
    TextView websiteTxt;

    @BindView(R.id.ratinglist)
    RecyclerView ratingList;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    String id;
    String title;
    String year;
    String type;
    String poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initializeViews();
        presenter = new DetailPresenter(this, new GetDetailMovieIntractorImpl(), id);
        presenter.requestDataFromServer();

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
    public void setData(MovieDetail movieDetail) {


        titleTxt.setText(title);
        yearTxt.setText("Year : " + year);
        typeTxt.setText("Type : " +type);
        actorsTxt.setText("Actores : " +movieDetail.getActors());
        ratedTxt.setText("Rated : " +movieDetail.getRated());
        releasedTxt.setText("Released : " +movieDetail.getReleased());
        runtimeTxt.setText("Runtime : " +movieDetail.getRuntime());
        genreTxt.setText("Genre : " +movieDetail.getGenre());
        directorTxt.setText("Director : " +movieDetail.getDirector());
        writerTxt.setText("Writer : " +movieDetail.getWriter());
        plotTxt.setText("Plot : " +movieDetail.getPlot());
        awardTxt.setText("Awards : " +movieDetail.getAwards());
        lanquageTxt.setText("Language : " +movieDetail.getLanguage());
        countryTxt.setText("Country : " +movieDetail.getCountry());
        imdbRatingTxt.setText("ImdbRating : " +movieDetail.getImdbRating());
        imdbVotingTxt.setText("imdbVotes : " +movieDetail.getImdbVotes());
        metascoreTxt.setText("Metascore : " +movieDetail.getMetascore());
        dvdTxt.setText("DVD : " +movieDetail.getDVD());
        boxOfficeTxt.setText("BoxOffice : " +movieDetail.getBoxOffice());
        websiteTxt.setText("Production : " +movieDetail.getWebsite());
        productionTxt.setText("Website : " +movieDetail.getProduction());
        ratingAdapter = new RatingAdapter(movieDetail.getRatings());
        ratingList.setAdapter(ratingAdapter);


    }

    @Override
    public void setDataFromDb(ArrayList<MovieDetail> movieDetailArrayList) {

        titleTxt.setText(title);
        yearTxt.setText("Year : " + year);
        typeTxt.setText("Type : " + type);
        actorsTxt.setText("Actores : " +movieDetailArrayList.get(0).getActors());
        ratedTxt.setText("Rated : " +movieDetailArrayList.get(0).getRated());
        releasedTxt.setText("Released : " +movieDetailArrayList.get(0).getReleased());
        runtimeTxt.setText("Runtime : " +movieDetailArrayList.get(0).getRuntime());
        genreTxt.setText("Genre : " +movieDetailArrayList.get(0).getGenre());
        directorTxt.setText("Director : " +movieDetailArrayList.get(0).getDirector());
        writerTxt.setText("Writer : " +movieDetailArrayList.get(0).getWriter());
        plotTxt.setText("Plot : " +movieDetailArrayList.get(0).getPlot());
        awardTxt.setText("Awards : " +movieDetailArrayList.get(0).getAwards());
        lanquageTxt.setText("Language : " +(movieDetailArrayList.get(0).getLanguage()));
        countryTxt.setText("Country : " +movieDetailArrayList.get(0).getCountry());
        imdbRatingTxt.setText("ImdbRating : " +movieDetailArrayList.get(0).getImdbRating());
        imdbVotingTxt.setText("imdbVotes : " +movieDetailArrayList.get(0).getImdbVotes());
        metascoreTxt.setText("Metascore : " +movieDetailArrayList.get(0).getMetascore());
        dvdTxt.setText("DVD : " +movieDetailArrayList.get(0).getDVD());
        boxOfficeTxt.setText("BoxOffice : " +movieDetailArrayList.get(0).getBoxOffice());
        websiteTxt.setText("Production : " +movieDetailArrayList.get(0).getWebsite());
        productionTxt.setText("Website : " +movieDetailArrayList.get(0).getProduction());
        String s = movieDetailArrayList.get(0).getRatings1();
        ratingAdapter = new RatingAdapter(makeListRatings(s));
        ratingList.setAdapter(ratingAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(DetailActivity.this,
                "Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }


    private void initializeViews() {

        ButterKnife.bind(this);

        id = getIntent().getExtras().getString("ImdbID", "defaultKey");
        title = getIntent().getExtras().getString("title", "defaultKey");
        year = getIntent().getExtras().getString("year", "defaultKey");
        type = getIntent().getExtras().getString("type", "defaultKey");
        poster = getIntent().getExtras().getString("poster", "defaultKey");

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DetailActivity.this);
        ratingList.setLayoutManager(layoutManager);

        progressBar.setVisibility(View.INVISIBLE);

        Picasso.with(DetailActivity.this)
                .load(poster)
                .placeholder(R.drawable.logo)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(circleImageView);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach(this);
    }

    public ArrayList<Rating> makeListRatings(String s) {
        ArrayList<Rating> lstExtrextData = null;
        try {
            JSONArray jsonArr = new JSONArray(s);
            lstExtrextData = new ArrayList<>();
            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObj = jsonArr.getJSONObject(i);
                Rating data = new Rating();
                data.setSource(jsonObj.getString("Source"));
                data.setValue(jsonObj.getString("Value"));
                lstExtrextData.add(data);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lstExtrextData;
    }

}