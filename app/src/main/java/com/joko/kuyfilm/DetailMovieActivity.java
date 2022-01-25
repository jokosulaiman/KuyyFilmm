package com.joko.kuyfilm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra("KEY_EXTRA");

        int imagePoster = movie.getPoster();
        int bgPoster = movie.getBgPoster();
        String title = movie.getName();
        String date = movie.getDate();
        String desc = movie.getDesc();
        String sutradara = movie.getSutradara();
        String genre = movie.getGenre();
        String production = movie.getProduction();
        String producer = movie.getProducer();
        String writter = movie.getWritter();
        String distributor = movie.getDistributor();

        ImageView imageView = findViewById(R.id.poster);
//        imageView.setImageResource(imagePoster);
        Glide.with(this).load(imagePoster).apply(new RequestOptions()).into(imageView);

        TextView textView1 = findViewById(R.id.txt_title);
        textView1.setText(title);

        TextView textView2 = findViewById(R.id.txt_date);
        textView2.setText(date);

        TextView textView3 = findViewById(R.id.txt_desc);
        textView3.setText(desc);

        TextView textView4 = findViewById(R.id.txt_sutradara);
        textView4.setText(sutradara);

        TextView textView5 = findViewById(R.id.txt_genre);
        textView5.setText(genre);

        TextView textView6 = findViewById(R.id.txt_production);
        textView6.setText(production);

        TextView textView7 = findViewById(R.id.txt_producer);
        textView7.setText(producer);

        TextView textView8 = findViewById(R.id.txt_writter);
        textView8.setText(writter);

        TextView textView9 = findViewById(R.id.txt_distributor);
        textView9.setText(distributor);

//        Background Poster
        ImageView imageView1 = findViewById(R.id.bg_poster);
//        imageView1.setImageResource(bgPoster);
        Glide.with(this).load(bgPoster).apply(new RequestOptions()).into(imageView1);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
