package com.project.batman.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.project.batman.R;
import com.project.batman.mainActivity.RecyclerItemClickListener;
import com.project.batman.model.Movie;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> movieArrayList;
    private RecyclerItemClickListener recyclerItemClickListener;
    private Context context;

    public MovieAdapter(ArrayList<Movie> movieArrayList, RecyclerItemClickListener recyclerItemClickListener, Context context) {
        this.movieArrayList = movieArrayList;
        this.recyclerItemClickListener = recyclerItemClickListener;
        this.context = context;
    }
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.movieTitle.setText(movieArrayList.get(position).getTitle());
        holder.movieType.setText(movieArrayList.get(position).getType());
        holder.movieYear.setText(movieArrayList.get(position).getYear());
        holder.movieId.setText(movieArrayList.get(position).getImdbID());
        setPoster(movieArrayList.get(position).getPoster(), holder.moviePoster);

        holder.itemView.setOnClickListener(v->{
            recyclerItemClickListener.onItemClick(movieArrayList.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle, movieType, movieId, movieYear;
        ImageView moviePoster;

        MovieViewHolder(View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieType = itemView.findViewById(R.id.movie_type);
            movieId = itemView.findViewById(R.id.movie_imdbId);
            movieYear = itemView.findViewById(R.id.movie_year);
            moviePoster = itemView.findViewById(R.id.movie_poster);

        }
    }


    public void setPoster(String url, ImageView imageView) {
        Picasso.with(context).load(url).placeholder(R.drawable.logo).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
            }
            @Override
            public void onError() {
                Picasso.with(context)
                        .load(url)
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(imageView);
            }
        });
    }

}