package com.example.listviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.MyViewHolder> {

    ArrayList<Movie>arrayListMovie= new ArrayList<>();

    public AdapterMovie(ArrayList<Movie> arrayListMovie) {
        this.arrayListMovie = arrayListMovie;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_movie,
               parent,false);
       return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie=arrayListMovie.get(position);
        holder.tvMovieName.setText(movie.getName());
        holder.tvYear.setText(movie.getYear());
        holder.tvGenner.setText(movie.getGenner());
    }

    @Override
    public int getItemCount() {
        return arrayListMovie.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvMovieName, tvYear, tvGenner;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovieName=(TextView) itemView.findViewById(R.id.tvMovieName);
            tvYear=(TextView) itemView.findViewById(R.id.tvYear);
            tvGenner=(TextView) itemView.findViewById(R.id.tvGenner);

        }
    }
}
