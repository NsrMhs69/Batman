package com.project.batman.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.project.batman.Apps;
import com.project.batman.model.Movie;
import com.project.batman.model.MovieDetail;

import java.util.ArrayList;

public class SqliteDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "movieData";

    private static final String TABLE_MOVIE = "movie";
    private static final String TABLE_MOVIEDTAIL = "movieDetail";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_IMDB = "imdb";
    private static final String COLUMN_Title = "title";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_POSTER = "poster";
    private static final String COLUMN_RATED = "rated";
    private static final String COLUMN_RELEASED = "released";
    private static final String COLUMN_RUNTIME = "runtime";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_DIRECTOR = "directors";
    private static final String COLUMN_WRITER = "writers";
    private static final String COLUMN_ACTORES = "actors";
    private static final String COLUMN_PLOT = "plot";
    private static final String COLUMN_LANQ = "lanquage";
    private static final String COLUMN_COUNTRY = "country";
    private static final String COLUMN_AWARDS = "award";
    private static final String COLUMN_METASCORE = "metascore";
    private static final String COLUMN_IMDBRATING = "imdbrate";
    private static final String COLUMN_IMDBVOTE = "imdvote";
    private static final String COLUMN_DVD = "dvd";
    private static final String COLUMN_BOXOFFICE = "boxoffice";
    private static final String COLUMN_PRODUCTION = "production";
    private static final String COLUMN_WEBSITE = "website";
    private static final String COLUMN_RATINGS = "ratings";

    public SqliteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE	TABLE " + TABLE_MOVIE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_IMDB + " TEXT," + COLUMN_Title + " TEXT," + COLUMN_YEAR + " TEXT," + COLUMN_TYPE + " TEXT," + COLUMN_POSTER + ")";
        String CREATE_TABLE2 = "CREATE	TABLE " + TABLE_MOVIEDTAIL + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_IMDB + " TEXT," + COLUMN_RATED + " TEXT," + COLUMN_RELEASED + " TEXT," + COLUMN_RUNTIME + " TEXT," + COLUMN_GENRE + " TEXT," + COLUMN_DIRECTOR + " TEXT," + COLUMN_WRITER + " TEXT," + COLUMN_ACTORES + " TEXT," + COLUMN_PLOT + " TEXT," + COLUMN_LANQ + " TEXT," + COLUMN_COUNTRY + " TEXT," + COLUMN_AWARDS + " TEXT," + COLUMN_METASCORE + " TEXT," + COLUMN_IMDBRATING + " TEXT," + COLUMN_IMDBVOTE + " TEXT," + COLUMN_DVD + " TEXT," + COLUMN_BOXOFFICE + " TEXT," + COLUMN_PRODUCTION + " TEXT," + COLUMN_WEBSITE + " TEXT," + COLUMN_RATINGS + ")";


        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIEDTAIL);
        onCreate(db);
    }

    public ArrayList<Movie> movieList() {
        String sql = "select * from " + TABLE_MOVIE;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Movie> movies = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String imdb = cursor.getString(1);
                String title = cursor.getString(2);
                String year = cursor.getString(3);
                String type = cursor.getString(4);
                String poster = cursor.getString(5);
                movies.add(new Movie(id, imdb, title, year, type, poster));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return movies;
    }

    public ArrayList<MovieDetail> movieDetails(String s) {
        String sql = "select * from " + TABLE_MOVIEDTAIL + " where imdb='" + s + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<MovieDetail> movieDetails = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String imdb = cursor.getString(1);
                String rated = cursor.getString(2);
                String released = cursor.getString(3);
                String runtime = cursor.getString(4);
                String genre = cursor.getString(5);
                String director = cursor.getString(6);
                String writer = cursor.getString(7);
                String actors = cursor.getString(8);
                String plot = cursor.getString(9);
                String lanquage = cursor.getString(10);
                String country = cursor.getString(11);
                String award = cursor.getString(12);
                String metascore = cursor.getString(13);
                String imdbrating = cursor.getString(14);
                String imdgvote = cursor.getString(15);
                String dvd = cursor.getString(16);
                String boxoffice = cursor.getString(17);
                String production = cursor.getString(18);
                String websie = cursor.getString(19);
                String ratings = cursor.getString(20);
                movieDetails.add(new MovieDetail(id, imdb, rated, released, runtime, genre, director, writer, actors, plot, lanquage, country, award, metascore, imdbrating, imdgvote, dvd, boxoffice, production, websie, ratings));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return movieDetails;
    }

    public void insertMovie(Movie movie) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_IMDB, movie.getImdbID());
        values.put(COLUMN_Title, movie.getTitle());
        values.put(COLUMN_YEAR, movie.getYear());
        values.put(COLUMN_TYPE, movie.getType());
        values.put(COLUMN_POSTER, movie.getPoster());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_MOVIE, null, values);
    }

    public void addMovieDetail(MovieDetail movie) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_IMDB, movie.getImdbID());
        values.put(COLUMN_RATED, movie.getRated());
        values.put(COLUMN_RELEASED, movie.getReleased());
        values.put(COLUMN_RUNTIME, movie.getRuntime());
        values.put(COLUMN_GENRE, movie.getGenre());
        values.put(COLUMN_DIRECTOR, movie.getDirector());
        values.put(COLUMN_WRITER, movie.getWriter());
        values.put(COLUMN_ACTORES, movie.getActors());
        values.put(COLUMN_PLOT, movie.getPlot());
        values.put(COLUMN_LANQ, movie.getLanguage());
        values.put(COLUMN_COUNTRY, movie.getCountry());
        values.put(COLUMN_AWARDS, movie.getAwards());
        values.put(COLUMN_METASCORE, movie.getMetascore());
        values.put(COLUMN_IMDBRATING, movie.getImdbRating());
        values.put(COLUMN_IMDBVOTE, movie.getImdbVotes());
        values.put(COLUMN_DVD, movie.getDVD());
        values.put(COLUMN_BOXOFFICE, movie.getBoxOffice());
        values.put(COLUMN_PRODUCTION, movie.getProduction());
        values.put(COLUMN_WEBSITE, movie.getWebsite());
        Gson gson = new GsonBuilder().create();
        JsonArray myCustomArray = gson.toJsonTree(movie.getRatings()).getAsJsonArray();
        values.put(COLUMN_RATINGS, myCustomArray.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_MOVIEDTAIL, null, values);
    }

    public boolean rowIdExistsInMovie(String StrId) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select _id from " + TABLE_MOVIE
                + " where imdb=?", new String[]{StrId});
        boolean exists = (cursor.getCount() > 0);
        return exists;
    }

    public boolean rowIdExistsInMovieDetail(String StrId) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select _id from " + TABLE_MOVIEDTAIL
                + " where imdb=?", new String[]{StrId});
        boolean exists = (cursor.getCount() > 0);
        return exists;
    }

}

