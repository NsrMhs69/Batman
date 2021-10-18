package com.project.batman.model;


import com.google.gson.annotations.SerializedName;



public class Movie {

    @SerializedName("Title")
    private String Title;

    @SerializedName("_id")
    private int _id;

    @SerializedName("Year")
    private String Year;


    @SerializedName("imdbID")
    private String imdbID;


    @SerializedName("Type")
    private String Type;


    @SerializedName("Poster")
    private String Poster;


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

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Movie(int id,String imdbID, String title,  String year, String type, String poster) {
        this._id = id;
        this.imdbID = imdbID;
        this.Title = title;
        this.Year = year;
        this.Type = type;
        this.Poster = poster;
    }
}
