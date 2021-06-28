package com.example.moviesandtv_seriesmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText Username;
    private EditText Passwordd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username = findViewById(R.id.Username);
        Passwordd = findViewById(R.id.PasswordET);
    }

    public void passToAddOrList(View view) {
        Toast.makeText(this,"Username: "+ Username.getText()+", Password: "+ Passwordd.getText(),Toast.LENGTH_LONG).show();
        Intent e = new Intent(this, AddOrList.class);
        if(checkUserValid())
        {
            e.putExtra("username", Username.getText().toString());
            startActivity(e);
        }
    }

    public Boolean checkUserValid()
    {
        Dal dal = new Dal(Login.this);
        String username = Username.getText().toString();
        String password = Passwordd.getText().toString();
        if (username.equals("") || password.equals(""))
        {
            Toast.makeText(this, "All fields must be filled", Toast.LENGTH_LONG).show();
            return false;
        }
        else if (!dal.isUserCorrect(username, password))
        {
            Toast.makeText(this, "Incorrect username or password!", Toast.LENGTH_LONG).show();
            return false;
        }
        else
            return true;
    }


    public void passToRegister(View view) {
        Intent e = new Intent(this, Register.class);
        startActivity(e);
    }
}