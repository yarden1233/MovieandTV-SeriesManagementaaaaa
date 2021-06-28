package com.example.moviesandtv_seriesmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddOrList extends AppCompatActivity {

    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_list);
        Intent d = getIntent();
        username = d.getStringExtra("username");

    }

    public void passToAdd(View view) {
        Intent d = new Intent(this, Add.class);
        d.putExtra("username", username);
        startActivity(d);
    }

    public void passToList(View view) {
        Intent d = new Intent(this, MoviesAndSeriesList.class);
        d.putExtra("username", username);
        startActivity(d);
    }
}