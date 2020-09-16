package com.example.localbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText username1,password1;
    Button login;
    public String myLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        username1=(EditText) findViewById(R.id.username);
        password1 = (EditText)findViewById(R.id.password);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }




}