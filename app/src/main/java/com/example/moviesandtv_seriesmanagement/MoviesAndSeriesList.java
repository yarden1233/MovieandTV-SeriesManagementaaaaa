package com.example.moviesandtv_seriesmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RatingBar;

import java.util.ArrayList;

public class MoviesAndSeriesList extends AppCompatActivity {


    ListView lstView1;
    ArrayList<MoviesAndSeries> aryList = new ArrayList<MoviesAndSeries>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_movies_and_series_list);
        setContentView(R.layout.mots);

        getListData();
        lstView1 = findViewById(R.id.listView1);
        MOTAdapter sa = new MOTAdapter(this, R.layout.layout_movie, aryList);
        lstView1.setAdapter(sa);

    }

    public void getListData()
    {
        MoviesAndSeries m = new MoviesAndSeries("a", "2", "Movie1");
        aryList.add(m);
        m = new MoviesAndSeries("b", "2", "Movie2");
        aryList.add(m);
    }


//    public void passToMovies(View view) {
//        Intent b = new Intent(this, Movies.class);
//        startActivity(b);
//    }
//
//    public void passToSeries(View view) {
//        Intent b = new Intent(this, Series.class);
//        startActivity(b);
//    }
}