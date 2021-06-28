package com.example.moviesandtv_seriesmanagement;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import androidx.core.view.ViewCompat;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Dal extends SQLiteAssetHelper {
    public Dal(Context context) {
        super(context, "my_db_master.db", null, 1);
    }

    public void addUser(String username, String email, String phone, String password) {
        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO registerr (username, email, phone, password) values(?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql_INSERT);
        statement.bindString(1, username);
        statement.bindString(2, email);
        statement.bindString(3, phone);
        statement.bindString(4, password);
        statement.execute();

    }

    public void addShow(String name, String MovieOrTV, String whichSeason, String creator) {
        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO tv_or_movies (name, movieortv, whichSeason, creator) values(?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql_INSERT);
        statement.bindString(1, name);
        statement.bindString(2, MovieOrTV);
        statement.bindString(3, whichSeason);
        statement.bindString(4, creator);
        statement.execute();

    }


    public ArrayList<users> getAllUsers() {
        ArrayList<users> ary = new ArrayList<users>();

        String st = "select * from registerr";
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {
            users u = new users();
            u.setUsername(cursor.getString(cursor.getColumnIndex("username")));


            ary.add(u);
        }
        return ary;

    }
    public Boolean isUserExist(String username) {


        String st = "select * from registerr";
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {
            if((cursor.getString(cursor.getColumnIndex("username")).equals(username)))
                return true;

        }
        return false;

    }

    public Boolean isUserCorrect(String username, String password) {


        String st = "select * from registerr";
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {

            if ((cursor.getString(cursor.getColumnIndex("username")).equals(username) && cursor.getString(cursor.getColumnIndex("password")).equals(password)))
                return true;

        }
        return false;

    }
}
