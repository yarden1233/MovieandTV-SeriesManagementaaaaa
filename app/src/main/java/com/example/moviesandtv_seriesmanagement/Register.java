package com.example.moviesandtv_seriesmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText Username;
    private EditText Email;
    private EditText Phone;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Username = findViewById(R.id.UsernameRegister);
        Email = findViewById(R.id.EmailRegister);
        Phone = findViewById(R.id.PhoneRegister);
        password =findViewById(R.id.PasswordRegister);
    }

    public void Registered(View view) {
        String username = Username.getText().toString();
        Intent c = new Intent(this, Login.class);
        if(checkUserValid(Username.getText().toString(), Email.getText().toString(), Phone.getText().toString(), password.getText().toString())) {
            //Toast.makeText(this,"Username: "+ Username.getText()+ ", Email: " + Email.getText() + ", Phone: " +Phone.getText() + ", Password: "+ password.getText(),Toast.LENGTH_LONG).show();
            c.putExtra("username", username);
            startActivity(c);
        }
    }

    public Boolean checkUserValid(String username, String email, String phone, String password)
    {
        Dal dal = new Dal(Register.this);
        if(dal.isUserExist(username))
        {
            Toast.makeText(this, "This user already exists!", Toast.LENGTH_LONG).show();
            return false;
        }
        else if (username.equals("") || password.equals("") || phone.equals("") || email.equals(""))
        {
            Toast.makeText(this, "All fields must be filled", Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            dal.addUser(username, email, phone, password);
            return true;
        }
    }

    public void passToLogin(View view) {
        Intent c = new Intent(this, Login.class);
        startActivity(c);
    }
}