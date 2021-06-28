package com.example.moviesandtv_seriesmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RatingBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void passToRegister(View view) {
        Intent a = new Intent(this, Register.class);
        startActivity(a);
    }

    public void passToLogin(View view) {
        Intent a = new Intent(this, Login.class);
        startActivity(a);
    }

    public void passToInfo(View view) {
        Intent a = new Intent(this, Info.class);
        startActivity(a);
    }
    public void passToHowToUse(View view) {
        Intent a = new Intent(this, HowToUse.class);
        startActivity(a);
    }
}