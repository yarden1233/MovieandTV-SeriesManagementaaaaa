package com.example.moviesandtv_seriesmanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebHistoryItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    private EditText NamePrint; // EditText
    private String WhichSeasonPrint; // CheckList
    private String MovieOrTV; // CheckList2
    String username; //creator


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Intent d = getIntent();
        username =d.getStringExtra("username");
        Toast.makeText(this, "" + username, Toast.LENGTH_LONG).show();
        NamePrint = findViewById(R.id.NameOfShow);





    }
    public void btnClick(View view) // ButtonSeason
    {
        final String[] Seasons = {"Not specified", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
       ListAdapter aryListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Seasons);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Which Season?");
        builder.setAdapter(aryListAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                WhichSeasonPrint = Seasons[which].toString();
                //Toast.makeText(Add.this, "Season:" + WhichSeasonPrint ,Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.getListView().setBackgroundColor(Color.GRAY);
        dialog.show();
    } // Button
    public void btnClick2(View view) // ButtonChoose
    {
        final String[] a = {"Not specified", "TV-Series", "Movie"};
        ListAdapter aryListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, a);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Movie or TV-Series?");
        builder.setAdapter(aryListAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MovieOrTV = a[which].toString();
                //Toast.makeText(Add.this, "Type:" + MovieOrTV, Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.getListView().setBackgroundColor(Color.GRAY);
        dialog.show();
    }
    public void OnSubmit(View view) {
        Dal dal = new Dal(Add.this);
        if(NamePrint.getText().toString().equals("") || MovieOrTV.equals("") || WhichSeasonPrint.equals("")) {
            Toast.makeText(this, "All fields must be filled", Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this, "dada", Toast.LENGTH_LONG).show();
            dal.addShow(NamePrint.getText().toString(), MovieOrTV, WhichSeasonPrint, username);

        }
    }









}