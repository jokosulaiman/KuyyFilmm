package com.joko.kuyfilm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder{
        private TextView nameMovie, txtDate, txtGenre;
        private ImageView imgPoster;

        ViewHolder(View view){
            nameMovie = view.findViewById(R.id.name_movie);
            txtDate = view.findViewById(R.id.txt_date);
            txtGenre = view.findViewById(R.id.txt_genre);
            imgPoster = view.findViewById(R.id.img_poster);
        }

        void bind(Movie movie){
            nameMovie.setText(movie.getName());
            txtDate.setText(movie.getDate());
            txtGenre.setText(movie.getGenre());
//            imgPoster.setImageResource(movie.getPoster());
            Glide.with(context).load(movie.getPoster()).apply(new RequestOptions()).into(imgPoster);
        }
    }
}