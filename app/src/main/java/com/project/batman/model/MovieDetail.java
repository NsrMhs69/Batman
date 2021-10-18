package com.project.batman.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieDetail {

    @SerializedName("_id")
    private int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    @SerializedName("Title")
    private String Title;

    @SerializedName("Year")
    private String Year;


    @SerializedName("Rated")
    private String Rated;


    @SerializedName("Released")
    private String Released;

    @SerializedName("Runtime")
    private String Runtime;

    @SerializedName("Genre")
    private String Genre;

    @SerializedName("Director")
    private String Director;

    @SerializedName("Writer")
    private String Writer;


    @SerializedName("Actors")
    private String Actors;

    @SerializedName("Plot")
    private String Plot;


    @SerializedName("Language")
    private String Language;

    @SerializedName("Country")
    private String Country;

    @SerializedName("Awards")
    private String Awards;

    @SerializedName("Poster")
    private String Poster;

    @SerializedName("Metascore")
    private String Metascore;

    @SerializedName("imdbRating")
    private String imdbRating;

    @SerializedName("imdbVotes")
    private String imdbVotes;

    @SerializedName("imdbID")
    private String imdbID;

    @SerializedName("Type")
    private String Type;


    @SerializedName("DVD")
    private String DVD;


    @SerializedName("BoxOffice")
    private String BoxOffice;

    @SerializedName("Production")
    private String Production;

    @SerializedName("Website")
    private String Website;

    @SerializedName("Response")
    private boolean Response;

    @SerializedName("Ratings")
    private ArrayList<Rating> Ratings;

    @SerializedName("Ratings1")
    private String Ratings1;

    public String getRatings1() {
        return Ratings1;
    }

    public void setRatings1(String ratings1) {
        Ratings1 = ratings1;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDVD() {
        return DVD;
    }

    public void setDVD(String DVD) {
        this.DVD = DVD;
    }

    public String getBoxOffice() {
        return BoxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        BoxOffice = boxOffice;
    }

    public String getProduction() {
        return Production;
    }

    public void setProduction(String production) {
        Production = production;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public boolean isResponse() {
        return Response;
    }

    public void setResponse(boolean response) {
        Response = response;
    }

    public ArrayList<Rating> getRatings() {
        return Ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        Ratings = ratings;
    }

    //    public MovieDetail( String rated, String released, String runtime, String genre) {

    public MovieDetail(int id, String imdbID,String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, String awards, String metascore, String imdbRating, String imdbVotes, String DVD, String boxOffice, String production, String website,String ratings1) {
        this._id = id;
        this.imdbID = imdbID;
        this.Rated = rated;
        this.Released= released;
        this.Runtime= runtime;
        this.Genre = genre;
        this.Director = director;
        this.Writer = writer;
        this.Actors = actors;
        this.Plot = plot;
        this.Language = language;
        this.Country = country;
        this.Awards = awards;
        this.Metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.DVD = DVD;
        this.BoxOffice = boxOffice;
        this.Production = production;
        this.Website = website;
        this.Ratings1=ratings1;
    }

    public MovieDetail(String imdbID, String actores, String director, String country, String language) {
        this.imdbID = imdbID;
        this.Actors = actores;
        this.Director = director;
        this.Country = country;
        this.Language = language;
    }
}
