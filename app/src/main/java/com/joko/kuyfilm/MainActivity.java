package com.joko.kuyfilm;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName, dataDate, dataDesc, dataSutradara, dataGenre, dataProduction, dataProducer, dataWritter, dataDistributor;
    private TypedArray dataPoster, dataBgPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    // Method ini digunakan untuk menagani kejadian ketika Menu OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailMovieActivity.class);
                intent.putExtra("KEY_EXTRA", movies.get(i));
                startActivity(intent);
            }
        });
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDate = getResources().getStringArray(R.array.data_date);
        dataDesc = getResources().getStringArray(R.array.data_description);
        dataSutradara = getResources().getStringArray(R.array.data_sutradara);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataProduction = getResources().getStringArray(R.array.data_production);
        dataProducer = getResources().getStringArray(R.array.data_producer);
        dataWritter = getResources().getStringArray(R.array.data_writter);
        dataDistributor = getResources().getStringArray(R.array.data_distributor);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataBgPoster = getResources().obtainTypedArray(R.array.data_bg_poster);
    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setBgPoster(dataBgPoster.getResourceId(i, -1));
            movie.setName(dataName[i]);
            movie.setDate(dataDate[i]);
            movie.setDesc(dataDesc[i]);
            movie.setSutradara(dataSutradara[i]);
            movie.setGenre(dataGenre[i]);
            movie.setProduction(dataProduction[i]);
            movie.setProducer(dataProducer[i]);
            movie.setWritter(dataWritter[i]);
            movie.setDistributor(dataDistributor[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }
}
