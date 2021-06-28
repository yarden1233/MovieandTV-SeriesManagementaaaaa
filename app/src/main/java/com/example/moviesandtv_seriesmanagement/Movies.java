package com.example.moviesandtv_seriesmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Movies extends AppCompatActivity {

    ListView lstView1;
    ArrayList<MoviesAndSeries> aryList = new ArrayList<MoviesAndSeries>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mots);

        getListData();
        lstView1 = findViewById(R.id.listView1);
        MOTAdapter sa = new MOTAdapter(this, R.layout.mots, aryList);
        lstView1.setAdapter(sa);
    }
    public void getListData()
    {
        MoviesAndSeries m = new MoviesAndSeries("a", "2", "Movie1");
        aryList.add(m);
        m = new MoviesAndSeries("b", "2", "Movie2");
        aryList.add(m);
    }
}