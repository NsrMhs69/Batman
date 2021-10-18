package com.project.batman.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.batman.R;
import com.project.batman.mainActivity.RecyclerItemClickListener;
import com.project.batman.model.Movie;
import com.project.batman.model.Rating;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.RatingViewHolder> {

    private ArrayList<Rating> ratingArrayList;

    public RatingAdapter(ArrayList<Rating> ratingArrayList) {
        this.ratingArrayList = ratingArrayList;
    }
    @Override
    public RatingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_rating, parent, false);
        return new RatingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RatingViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.sourceId.setText(ratingArrayList.get(position).getSource());
        holder.valueId.setText(ratingArrayList.get(position).getValue());

    }

    @Override
    public int getItemCount() {
        return ratingArrayList.size();
    }

    class RatingViewHolder extends RecyclerView.ViewHolder {

        TextView sourceId,valueId;

        RatingViewHolder(View itemView) {
            super(itemView);
            sourceId = itemView.findViewById(R.id.source_id);
            valueId = itemView.findViewById(R.id.value_id);

        }
    }

}