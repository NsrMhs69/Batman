package com.project.batman.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieList {

    @SerializedName("Search")
    private ArrayList<Movie> Search;

    public ArrayList<Movie> getSearch() {
        return Search;
    }

    public void setSearch(ArrayList<Movie> search) {
        Search = search;
    }
}